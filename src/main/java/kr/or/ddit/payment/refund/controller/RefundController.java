package kr.or.ddit.payment.refund.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.payment.refund.service.PayRefundService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PayRefundVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RefundController {

	@Inject
	private PayRefundService service;

	public static String memId;
	public static String token;
	public static String message;

	// 환불 가능한 결제내역 리스트를 조회합니다.
	@RequestMapping(value = "project/payInfo.do", method = RequestMethod.POST)
	@ResponseBody
	public List<PayVO> payInfo(@AuthenticationPrincipal(expression = "authMember") MemberVO authMember) {
		
		memId = authMember.getMemId();
		
		List<PayVO> payList = service.payInfo(memId);

		return payList;
	}

	// 환불
	@RequestMapping(value = "project/payRefund.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String payRefund(@RequestParam("reason") String reason, @RequestParam("refundPayCode") String payCode, 
							@RequestParam("refundMonth") String refundMonth, Model modal, HttpSession session) throws Exception {
		
		HttpURLConnection conn = null;
		URL url = new URL("https://api.iamport.kr/users/getToken"); // 토큰을 받아올 주소를 입력합니다.
		conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST"); // POST 로 요청합니다.

		// Header 를 설정해줍니다.(json 형식으로 데이터 전송)
		conn.setRequestProperty("Content-Type", "application/json");
		// 서버로부터 받을 데이터 형식을 json 으로 요청합니다.
		conn.setRequestProperty("Accept", "application/json");
		// OutPutStream 으로 POST 데이터를 넘겨주겠다는 옵션을 설정합니다.
		conn.setDoOutput(true);

		// 키값들을 JSON 형태로 넣은 후 import 서버로 넘겨줍니다.
		JSONObject obj = new JSONObject();
		obj.put("imp_key", "9508002261851383");
		obj.put("imp_secret", "cb3bd358575287882ecd10bae292935aaf858c3c8f98a12f0bb174bdbd3416f0028e9f485ba52d15");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(obj.toString());
		bw.flush();
		bw.close();

		// 서버로부터 응답 데이터를 받습니다.
		int responseCode = conn.getResponseCode(); // 응답 코드

		if (responseCode == 200) { // 성공할 경우
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			br.close();

			// 결과값 파싱을 위해 결과값을 String 형태로 변환해줍니다.
			String sbStr = sb.toString();

			// parser 객체를 생성합니다
			JSONParser parser = new JSONParser();

			// String 결과값을 파싱해줍니다.
			Object sbObj = (JSONObject) parser.parse(sbStr);

			// 파싱된 데이터는 Object 형태와 Array 형태가 있습니다.
			// 형태를 구분짓기 위해 조건문을 실행합니다.
			if (sbObj instanceof JSONArray) {

				// jsonArray 이용한 처리
				// 현재 받은 JSON 데이터는 Array 형태가 아니기 때문 해당 조건문을 실행하지 않습니다.
				JSONArray jsonArray = (JSONArray) sbObj;

			} else if (sbObj instanceof JSONObject) {

				// jsonObject 이용한 처리
				JSONObject jsonObject = (JSONObject) sbObj;

				// 현재 응답은 오브젝트 안에 오브젝트가 있는 구조기 때문에 오브젝트 형식으로 키값을 요청합니다.
				// 값이 response 인 오브젝트 값 가져옴
				JSONObject jsonobject2 = (JSONObject) jsonObject.get("response");

				// response 오브젝트 안에 있는 키값이 access_token 인 value 값을 String 으로 변환해줍니다.
				token = (String) jsonobject2.get("access_token");

			} else {

				// 다른 타입
			}
			
			// 가져온 토큰값을 환불메소드에 파라메터로 넘겨줍니다.(토큰, 결제코드, 결제사유)
			message = refundAnswer(token, payCode, reason, refundMonth, memId);
			
			return message;
		} else {
			log.info("환불 실패 에러코드 : {}", conn.getResponseMessage()); // 환불 실패시 에러코드 반환
			message = "서버 문제로 실패하였습니다. 나중에 다시 시도해주세요.";
			return message;
		}
	}
	

	// 받아온 토큰값을 토대로 환불을 진행합니다.
	public String refundAnswer(String token, String payCode, String reason, String refundMonth, String memId) throws IOException, ParseException {

		HttpURLConnection conn = null;
		URL url = new URL("https://api.iamport.kr/payments/cancel"); // 환불 요청 주소를 입력합니다.
		conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("POST"); // POST 로 요청합니다.

		// Header 를 설정해줍니다.(json 형식으로 데이터 전송)
		conn.setRequestProperty("Content-Type", "application/json");
		// 전송받은 토큰을 Authorization 헤더에 실어 넘겨줍니다.
		conn.setRequestProperty("Authorization", token);
		// OutPutStream 으로 POST 데이터를 넘겨주겠다는 옵션을 설정합니다.
		conn.setDoOutput(true);

		// 요청할 정보를 Body 에 실어 전송합니다.
		JSONObject obj = new JSONObject();
		obj.put("reason", "테스트 환불");
		obj.put("imp_uid", payCode);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(obj.toString());
		bw.flush();
		bw.close();

		// 서버로부터 응답 데이터를 받습니다.
		int responseCode = conn.getResponseCode(); // 응답 코드

		if (responseCode == 200) { // 성공할 경우
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			br.close();
			
			// 환불이 성공했다면, 서버 데이터에 내역 추가를 위해 데이터 통신을 합니다.
			PayRefundVO payRefund = new PayRefundVO();
			payRefund.setPayCode(payCode);
			payRefund.setRefundDetail(reason);
			payRefund.setRefundMonth(refundMonth);
			payRefund.setMemId(memId);
			
			ServiceResult responseResult = service.createPayRefundInfo(payRefund);

			if (responseResult.equals(ServiceResult.OK)) {
				
				// 만약 환불을 한 후의 멤버 데드라인이 현 날짜보다 작을 경우, 미결제 계정 처리로 합니다.
				String deadLineInfo = service.memberDeadLineInfo(memId);
				SimpleDateFormat deadLineDayFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date deadLineDay = deadLineDayFormat.parse(deadLineInfo);
				
				// 날짜비교를 위해 현재 날짜 객체를 만들어줍니다.
				Date today = new Date();
				
				// 비교를 합니다.
				int compare = deadLineDay.compareTo(today);
				
				if(compare > 0) {
					
					// 아직 이용기간이 남아있는 경우 입니다.
					message = "환불이 완료되었습니다";

				}else if(compare < 0) {
					
					// 현재 날짜보다 이용기간이 더 작은 경우 입니다.
					ServiceResult changeMemberStatus = service.memberDeadLineChange(memId);
					
					if(changeMemberStatus.equals(ServiceResult.OK)) {
						
						message = "환불이 완료되었습니다.";
						
					}else {
						
						message = "알 수 없는 오류로 실패하였습니다. 잠시 후에 다시 시도해주세요";
						
					}
					
				}else {
					
					// 데드라인이 현재 날짜와 같을 경우 입니다.
					message = "환불이 완료되었습니다";
				}
				
			} else {
				message = "환불이 실패하였습니다....(서버)";
			}

			return message;

		} else {
			log.info("환불 실패 에러코드 : {}", conn.getResponseMessage()); // 환불 실패시 에러코드 반환
			message = conn.getResponseMessage();
			return message;
		}
	}

}