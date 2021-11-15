package kr.or.ddit.validate.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TelNumberVaildator implements ConstraintValidator<TelNumber, String>{
	
	private TelNumber constraintAnnotaion;
	
	// 어노테이션에 미리 정의된 default값을 가져오기위해 어노테이션객체에 접근.
		@Override
		public void initialize(TelNumber constraintAnnotation) {
			this.constraintAnnotaion = constraintAnnotation;
		}
		
		@Override
		public boolean isValid(String value, ConstraintValidatorContext context) {
			// value가 비어있으면 true를 반환(검증을 할필요가 없으므로 넘긴다.)
			boolean valid = value == null || value.isEmpty();
			if(!valid) {
				valid = value.matches(constraintAnnotaion.regex());
			}
			return valid;
		}
}
