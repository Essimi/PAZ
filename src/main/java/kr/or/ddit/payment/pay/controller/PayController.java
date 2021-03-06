package kr.or.ddit.payment.pay.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PayController {
	
	private IamportClient api;
	
//  검증 메소드
	@ResponseBody
	@RequestMapping(value="/project/PayController.do/{imp_uid}", method = RequestMethod.POST)
	public IamportResponse<Payment> paymentByImpUid(@PathVariable(value= "imp_uid") String imp_uid) throws IamportResponseException, IOException{
	
		// 키값 입력 후 객체 생성
		api = new IamportClient("9508002261851383","cb3bd358575287882ecd10bae292935aaf858c3c8f98a12f0bb174bdbd3416f0028e9f485ba52d15");
		
		// 서버에서 받은 값을 보냅니다.
		return api.paymentByImpUid(imp_uid);
	}
	
}