package kr.or.ddit.validate.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
//<어노테이션, 검증 변수 타입>
import org.springframework.web.multipart.MultipartFile;

public class FileMimeCheckValidator implements ConstraintValidator<FileMimeChecher, MultipartFile>{
	
	private FileMimeChecher constraintAnnotaion;
	// 어노테이션에 미리 정의된 default값을 가져오기위해 어노테이션객체에 접근.
	@Override
	public void initialize(FileMimeChecher constraintAnnotation) {
		this.constraintAnnotaion = constraintAnnotation;
	}
	
	@Override
	public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
		//value가 null true를 반환(검증을 할 필요가 없으므로 넘긴다.)
		boolean valid = file ==null;
		if(!valid) {
			String fileMime = file.getContentType();
			String checkMime = constraintAnnotaion.mime();
			valid = fileMime.indexOf(checkMime) >=0;
		}
		return valid;
	}
	

}
