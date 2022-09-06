package crm.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import crm.model.Member;
@Component
public class EmailValidator2 implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		Member member = (Member)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "","Email不能是空白");
		if (!member.getEmail().contains("@")) {
			errors.rejectValue("email","", "Email格式錯誤.");
		}
	}
} 