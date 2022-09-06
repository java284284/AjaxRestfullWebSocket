package crm.validators;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import crm.model.Member;

@Component
public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		boolean b = Member.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Member member = (Member)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "account", "member.account.not.empty","帳號欄不能空白(預設值)");
		ValidationUtils.rejectIfEmptyOrWhitespace
			(errors, "name", "member.name.not.empty","姓名欄不能空白(預設值)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "", "生日欄不能空白(MemberValidator)");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weight", "", "體重欄不能空白(MemberValidator)");
		
		if (member.getAccount().length()<5) {
			errors.rejectValue("account","", "帳號欄不能小於五個字元");
		}
//		Double d = member.getWeight();

		if (member.getCategory().getId() == -1) {
			errors.rejectValue("category","", "必須挑選分類欄的選項");
		}
		if (member.getHobby().getId() == -1) {
			errors.rejectValue("hobby","", "必須挑選嗜好欄的選項");
		}

	}

}
