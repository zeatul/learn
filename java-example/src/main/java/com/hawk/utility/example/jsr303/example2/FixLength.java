package com.hawk.utility.example.jsr303.example2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FixLengthImpl.class)
@Documented
public @interface FixLength {
	int length();

	String message() default "{net.zhepu.web.valid.fixlength.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
