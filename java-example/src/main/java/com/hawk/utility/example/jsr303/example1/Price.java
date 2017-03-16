package com.hawk.utility.example.jsr303.example1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Max(10000)
@Min(8000)
@Constraint(validatedBy = {})
@Documented
@Target( { ElementType .ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy .RUNTIME)
public @interface Price {

}
