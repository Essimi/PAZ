package kr.or.ddit.validate.constraints;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;


@Target({FIELD, METHOD})
@Retention(RUNTIME)
@Constraint(validatedBy= {FileMimeCheckValidator.class})  // validatedBy에는 Constraintvalidator의 자손들만 입력가능
public @interface FileMimeChecher {
	String mime();
	
	String message() default "{kr.or.ddit.validate.constraints.FileMimeChecker.message}"; // ${validatedValue} : 검증할 변수의 값(ex. 입력받은 전화번호값)

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
