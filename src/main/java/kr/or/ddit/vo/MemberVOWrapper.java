package kr.or.ddit.vo;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;


/**
 * MemberVO의 값을 spring security에 맞춰 값을 변환
 * (Id, password, authority)를 저장하는 VO객체
 * @author pc01
 * 
 */
@Getter
public class MemberVOWrapper extends User{
	private MemberVO authMember;

	public MemberVOWrapper(MemberVO authMember) {
		super(authMember.getMemId(), authMember.getMemPass(), 
					AuthorityUtils.createAuthorityList(authMember.getMemRoles().toArray(new String[authMember.getMemRoles().size()])));
		this.authMember = authMember;
	}

}
