package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.entity.User;

public class UserValidator implements Validator {

	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
			+"[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PHONE_PATTERN=
			"^\\+?[0-9. ()-]{10,25}$";
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		// validation login
		if (user.getLogin().isEmpty()) {
			errors.rejectValue("login", "user.login", "ви не ввели логін");
		} else if (user.getLogin().length() < 5) {
			errors.rejectValue("login", "user.login", "ім'я надто коротке");
		} else if (user.getLogin().length() > 20) {
			errors.rejectValue("login", "user.login", "занадто довгий логін");
		}
		// validation password
		if (user.getPassword().isEmpty()) {
			errors.rejectValue("password", "user.password", "не введено пароль");
		} else if (user.getPassword().length() < 5) {
			errors.rejectValue("password", "user.password", "пароль занадто короткий");
		} else if (user.getPassword().length() > 20) {
			errors.rejectValue("password", "user.password", "пароль занадто довгий");
		}
		//validation phone
		if(user.getPhone().isEmpty()){
			errors.rejectValue("phone", "user.phobe", "не введено номер телефону");
		}else if(!user.getPhone().matches(PHONE_PATTERN)){
			errors.rejectValue("phone", "user.phobe", "не коректний номер телефону");
		}
		//validation email
		if(user.getEmail().isEmpty()){
			errors.rejectValue("email", "user.email", "адреса не введена");
		}else if (!user.getEmail().matches(EMAIL_PATTERN)){
			errors.rejectValue("email", "user.email", "адреса не правильна");
		}

	}
}
