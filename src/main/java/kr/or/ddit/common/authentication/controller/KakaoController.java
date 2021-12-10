package kr.or.ddit.common.authentication.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class KakaoController {
	
	private String authCode;
	private String access_Token;
	
	@RequestMapping("/login/requestKakaoAuth.do")
	public String requestKakaoAuth(
			) {
		String authUrl = "https://kauth.kakao.com/oauth/authorize"
				+ "?client_id=3ea2e4c4820aad7ae9dc921905559943"
				+ "&redirect_uri=https://localhost/PAZ/login/getKakaoAuthCode.do"
				+ "&response_type=code";
		// https://kauth.kakao.com/oauth/authorize?client_id=3ea2e4c4820aad7ae9dc921905559943&redirect_uri=https://localhost/PAZ/login/getKakaoAuthCode.do&response_type=code
		return "redirect:" + authUrl;
	}
	
	@RequestMapping("/login/getKakaoAuthCode.do")
	public String getKakaoAuthCode(
			@RequestParam("code") String Code,
			Model model
			) {
		
		access_Token = getAccessToken(Code);
		HashMap<String, Object> userInfo = getUserInfo(access_Token);
		
		log.info("userInfo : {}", userInfo);
		
		return "redirect:/";
	}
	
	// 로그아웃
	@RequestMapping("/login/requestKakaologout.do")
	public String requestKakaologout() {
		String reqURL = "https://kauth.kakao.com/oauth/logout"
				+ "?client_id=3ea2e4c4820aad7ae9dc921905559943"
				+ "&logout_redirect_uri=https://localhost/PAZ/login/logout.do";
		
		return "redirect:" + reqURL;
	}
	
	//토큰발급
	public String getAccessToken (String authCode) {
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //	POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=3ea2e4c4820aad7ae9dc921905559943");  //본인이 발급받은 key
            sb.append("&redirect_uri=https://localhost/PAZ/login/getKakaoAuthCode.do");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + authCode);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            log.info("responseCode : {}", responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            log.info("response body : {}", result);

            // Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonObject jsonObj = (JsonObject) JsonParser.parseString(result);
            
            access_Token = jsonObj.get("access_token").toString();
            refresh_Token = jsonObj.get("refresh_token").toString();
//            access_Token = element.getAsJsonObject().get("access_token").getAsString();
//            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            log.info("access_token : {}" + access_Token);
            log.info("refresh_token : {}" + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }
	
	//유저정보조회
    public HashMap<String, Object> getUserInfo (String access_Token) {
	    //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
	    HashMap<String, Object> userInfo = new HashMap<String, Object>();
	    String reqURL = "https://kapi.kakao.com/v2/user/me";
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	
	        //    요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
	
	        int responseCode = conn.getResponseCode();
	        log.info("responseCode : {}" + responseCode);
	
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	
	        String line = "";
	        String result = "";
	
	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        log.info("response body : {}" + result);
	
	        JsonObject jsonObj = (JsonObject) JsonParser.parseString(result);
	        JsonObject kakao_account = jsonObj.getAsJsonObject("kakao_account");
	        JsonObject profile = kakao_account.getAsJsonObject("profile");
	        
	        String id = jsonObj.get("id").toString();
	        String nickname = profile.get("nickname").toString();
	        String imageUrl = profile.get("profile_image_url").toString();
	        String eamil = kakao_account.get("email").toString();
//	        String birth = kakao_account.get("birthyear").toString() + kakao_account.get("birthday").toString();
	        String birthday = kakao_account.get("birthday").toString();
	        String gender = kakao_account.get("gender").toString();
//	        String tel = kakao_account.get("phone_number").toString();
	        
	        userInfo.put("id", id);
	        userInfo.put("nickname", nickname);
	        userInfo.put("imageUrl", imageUrl);
	        userInfo.put("eamil", eamil );
//	        userInfo.put("birth", birth);
	        userInfo.put("birthday", birthday);
	        userInfo.put("gender", gender);
//	        userInfo.put("tel", tel);
//	        JsonParser parser = new JsonParser();
//	        JsonElement element = parser.parse(result);
//	
//	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
//	        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
//	
//	        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
//	        String email = kakao_account.getAsJsonObject().get("email").getAsString();
//	        
//	        userInfo.put("accessToken", access_Token);
//	        userInfo.put("nickname", nickname);
//	        userInfo.put("email", email);
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return userInfo;
    }
}

