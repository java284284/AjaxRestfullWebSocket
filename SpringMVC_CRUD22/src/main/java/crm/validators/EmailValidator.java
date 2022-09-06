package crm.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import crm.model.User;
@Component
public class EmailValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
//		Cat c = null;
//		Dog d = null;
//		if (target instanceof Cat) {
//			c = (Cat)target; 
//		} else if (target instanceof Dog) {
//			d = (Dog)target; 
//		}
		// ...
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "","Email is empty");
		
		if (!user.getEmail().contains("@")) {
			errors.rejectValue("email","", "Email is not valid.");
		}
	}
} 