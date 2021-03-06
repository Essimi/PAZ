package kr.or.ddit.code.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ResultStatus;
import kr.or.ddit.vo.MemberVO;

@Controller
public class CodeContent {
	
	private static String codeShaData;
	private static String codeUrlData;
	private static String codeUserInfoData;
	
	// 선택한 트리구조 파일의 Content 정보를 불러온 후, CodeMirror 페이지로 전송합니다.
	@RequestMapping(value = "project/{pCode}/gitHub/gitCode.do", method = RequestMethod.POST)
	public String gitCode(@RequestParam(value = "codeContent", required = false) String codeData, 
					      @RequestParam(value = "codeUrl", required = false) String codeUrl, 
					      @RequestParam(value = "codeSha", required = false) String codeSha, 
					      @RequestParam(value = "codeUserInfo", required = false) String codeUserInfo, Model model) {
		
		// 경로 저장을 위해(업데이트)  sha 값을 받아줍니다.
		codeShaData = codeSha;
		
		// 파일의 경로값을 받아옵니다.
		codeUrlData = codeUrl;
		
		// 경로 지정을 위해 사용자의 이름과 repo 이름을 받아옵니다.
		codeUserInfoData = codeUserInfo;
		
		// content 값을 읽기 위해 디코딩 해줍니다.
		byte[] decodedBytes = Base64.decodeBase64(codeData);
				
		String decodedCode = new String(decodedBytes);
		
		model.addAttribute("codeData", decodedCode);
		model.addAttribute("codeUrl", codeUrlData);
		
		return "code/gitCode";
	}
	
	// 전송받은 CodeMirrer 의 text 값을 GitHib 에 저장하기 위해 base64 로 인코딩 해줍니다.
	@RequestMapping(value = "project/{pCode}/gitHub/gitCodeConversion.do", method = RequestMethod.POST)
	public String gitCodeConversion(@RequestParam(value = "codeText", required = false) String codeText, 
									@RequestParam(value = "inputCommitMessageForm", required = false) String inputCommitMessageForm,
									@PathVariable("pCode") String pCode,
									@AuthenticationPrincipal(expression="authMember") MemberVO authMember, Model model,
									RedirectAttributes redirect) throws IOException {
		
		ResultStatus status = ResultStatus.FAIL;
					      			
		// 받아온 값을 base64 로 인코딩 해줍니다.
		byte[] encodedBytes = Base64.encodeBase64(codeText.getBytes());
		// String 형식으로 변환해줍니다.
		String encodedCode = new String(encodedBytes);
		
		HttpURLConnection conn = null;
		URL url = new URL("https://api.github.com/repos/" + codeUserInfoData + "/contents/" + codeUrlData); // 수정 주소를 작성합니다.
		conn = (HttpURLConnection)url.openConnection();
					
		conn.setRequestMethod("PUT"); // PUT 으로 요청합니다.
					
		// Header 를 설정해줍니다.(json 형식으로 데이터 전송)
		conn.setRequestProperty("Content-Type", "application/json");
		// 전송받은 토큰을 Authorization 헤더에 실어 넘겨줍니다.
		conn.setRequestProperty("Authorization", "token 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");
		// OutPutStream 으로 POST 데이터를 넘겨주겠다는 옵션을 설정합니다.
		conn.setDoOutput(true);
					
		// 요청할 정보를 Body 에 실어 전송합니다.
		JSONObject obj = new JSONObject();
		// 계층형 구조이기 때문에 오브젝트 객체를 하나 더 생성합니다.
		JSONObject obj2 = new JSONObject();
		
		obj2.put("name", authMember.getMemId());
		obj2.put("email", authMember.getMemMail());
		
		obj.put("message",inputCommitMessageForm);
		obj.put("committer",obj2);
		obj.put("content", encodedCode);
		obj.put("sha", codeShaData);
				
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(obj.toString());
		bw.flush();
		bw.close();
					
		// 서버로부터 응답 데이터를 받습니다.
		int responseCode = conn.getResponseCode(); // 응답 코드
		
		if(responseCode == 200) { // 성공할 경우
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = null;
			status = ResultStatus.UPDATE;
			while((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
						
		br.close();
				
		} else if(responseCode != 200) {
			status = ResultStatus.FAIL;
		}
		
		redirect.addFlashAttribute("status", status);	
		return "redirect:/project/" + pCode + "/gitHub/gitTeam.do";
	}
}
