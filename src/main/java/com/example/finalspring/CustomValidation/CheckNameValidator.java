package com.example.finalspring.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckNameValidator implements ConstraintValidator<CheckName,String> {

	private String beganName;

	@Override
	public void initialize(CheckName constraintAnnotation) {
		beganName = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String enterValue, ConstraintValidatorContext constraintValidatorContext) {

		return enterValue.startsWith(beganName);
	}
}
