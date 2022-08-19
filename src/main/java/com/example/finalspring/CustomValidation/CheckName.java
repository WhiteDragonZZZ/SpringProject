package com.example.finalspring.CustomValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckNameValidator.class)
public @interface CheckName {
	public String value() default "A";
	public String message() default "Began with uppercase";

	public Class<?>[] groups() default {};
	public Class<? extends Payload> [] payload() default {};
}
