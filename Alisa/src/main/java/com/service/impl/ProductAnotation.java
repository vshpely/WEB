package com.service.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint (validatedBy = productValid.class)
public @interface ProductAnotation {
	
	String message();
	Class<?>[]groups() default {};
	Class<? extends Payload>[] payload() default{};
}
