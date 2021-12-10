package kr.or.ddit.member.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.utils.MessageUtils;
import kr.or.ddit.utils.TempKey;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO memberDAO;
	
	// 비밀번호 암호화 객체
	@Inject
	private PasswordEncoder encoder;
	
	@Resource(name="messageUtils")
	private MessageUtils msgUtils;
	
	@Value("#{appInfo['member.profile.image']}")
	private File saveFolder;
	
	// 비밀번호를 암호화해 MemberVO에 세팅
	private void encryptPassword(MemberVO member) {
		String password = member.getMemPass().trim();
		if(StringUtils.isNotBlank(password)) {
			member.setMemPass(encoder.encode(member.getMemPass()));
		}
	}
	
	@Transactional
	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if(memberDAO.selectMember(member) == null) {
			encryptPassword(member);
			
			int memberCnt = memberDAO.insertMember(member);
			int roleCnt = memberDAO.insertMemberRole(member);
			if(memberCnt > 0 && roleCnt > 0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAILED;
			}
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		
		return result;
	}

	@Override
	public MemberVO selectMember(MemberVO member) {
		return memberDAO.selectMember(member);
	}

	@Override
	public ServiceResult memberIdCheck(MemberVO member) {
		ServiceResult result = null;
		if(memberDAO.selectMember(member) == null) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		
		return result;
	}
	
	private void sendMail(MemberVO member, String key, String subject, StringBuffer content) {
		String receiveAddress = member.getMemMail();
		
		Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.debug", "true");
        
        Authenticator auth = new Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
  	          return new PasswordAuthentication(msgUtils.getMessage("mail.username"),
  	        		  							msgUtils.getMessage("mail.password"));
  	        }
		};
		
        Session session = Session.getDefaultInstance(prop, auth);
        MimeMessage msg = new MimeMessage(session);

        try {

            msg.setSentDate(new Date());
            msg.setFrom(new InternetAddress(msgUtils.getMessage("mail.username"), "PAZ"));

            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveAddress));            

            msg.setSubject(subject, "UTF-8");            

            msg.setText(content.toString(), "UTF-8", "html");

            Transport.send(msg);
        } catch(AddressException ae) {            
            System.out.println("AddressException : " + ae.getMessage());           
        } catch(MessagingException me) {            
            System.out.println("MessagingException : " + me.getMessage());
        } catch(UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException : " + e.getMessage());
        }
	}

	@Override
	public Map<String, String> sendMail(MemberVO member) {
		Map<String, String> map = new HashMap<>();
		if(memberDAO.selectMemberEmail(member) == null) {
			String emailAuthKey = new TempKey().getKey(30, false);
			String subject = "PAZ 회원가입 이메일 인증입니다.";
			StringBuffer content = new StringBuffer()
										.append("<h1>메일 인증</h1>")
							    		.append("아래 링크를 클릭해 이메일 인증을 해주세요.<br>")
							    		.append("<a href='http://localhost/PAZ/login/emailConfirm?key=")
							    		.append(emailAuthKey)
							    		.append("' target='_blenk'>이메일 인증 확인</a>");
			sendMail(member, emailAuthKey, subject, content);
	        map.put("status", "OK");
	        map.put("emailAuthKey", emailAuthKey);
		}else {
			map.put("status", "FAIL");
		}
		
		return map;
	}

	@Override
	public ServiceResult memberEmailCheck(MemberVO member) {
		ServiceResult result = null;
		if(memberDAO.selectMemberEmail(member) != null) {
			TempKey key = new TempKey(); 
			String tempPass = key.getKey(10, false);
			String subject = "PAZ 임시 비밀번호입니다.";
			StringBuffer content = new StringBuffer()
										.append("<h1>임시비밀번호</h1>")
										.append(member.getMemId())
										.append(" 회원님의 임시 비밀번호는 [")
							    		.append(tempPass)
										.append("] 입니다.");
			sendMail(member, tempPass, subject, content);
			member.setMemPass(tempPass);
			encryptPassword(member);
			memberDAO.updatePassword(member);
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Transactional
	@Override
	public ServiceResult memberUpdate(MemberVO member) {
		encryptPassword(member);
		int cnt = memberDAO.updateMember(member);
		
		ServiceResult result = ServiceResult.OK;
		// 이미지 변경 데이터가 없는 경우 실행되지 않게수행
		if(!member.getMemIkon().getImgMime().equals("octet-stream")) {
			memberDAO.deleteMemberImage(member.getMemIkon());
			int insCnt = memberDAO.insertMemberImage(member.getMemIkon());
			try {
				member.getImageFile().transferTo(new File(saveFolder, member.getMemIkon().getSaveName()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			result = ServiceResult.FAILED;
			if(cnt > 0 && insCnt > 0) {
				result = ServiceResult.OK;
			}
		}
		
		return result;
	}

	@Override
	public ServiceResult memperPay(String memId) {
		
		ServiceResult result = null;
		
		String test = memberDAO.memberPay(memId);
		
		if(test.equals("N")) {
			result = ServiceResult.FAILED;
		}else if(test.equals("Y")){
			result = ServiceResult.OK;
		}
		
		return result;
	}

	@Override
	public List<Map<Object, String>> memberDeadLineInfo() {
		
		return memberDAO.memberDeadLineInfo();
		
	}

	@Override
	public ServiceResult memberDeadLineChangePayment(List<String> memId) {
	
		int rowcnt = memberDAO.memberDeadLineChangePayment(memId);
		
		ServiceResult result = null;
		
		if(rowcnt > 0)
			result = ServiceResult.OK;
		else {
			result = ServiceResult.FAILED;
		}
		return result;
		
	}

	@Override
	public List<MemberVO> projectMemberList(ProjectVO project) {
		return memberDAO.projectMemberList(project);
	}
}
