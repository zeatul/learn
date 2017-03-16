package com.hawk.utility.example.jsr303.example2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.validation.Valid;
import javax.validation.Validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerValidatorAOP {
	private Validator validator;

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void controllerInvocation() {
	}

	@Around("controllerInvocation()")
	public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Annotation[] annotationList = method.getAnnotations();
		/*
		 * for(Annotation anno:annotationList){
		 * System.out.println(ResponseBody.class.isInstance(anno)); }
		 */
		Annotation[][] argAnnotations = method.getParameterAnnotations();
		String[] argNames = methodSignature.getParameterNames();
		Object[] args = joinPoint.getArgs();

		for (int i = 0; i < args.length; i++) {
			if (hasRequestBodyAndValidAnnotations(argAnnotations[i])) {
				Object ret = validateArg(args[i], argNames[i]);
				if (ret != null) {
					return ret;
				}
			}
		}

		return joinPoint.proceed(args);
	}

	private boolean hasRequestBodyAndValidAnnotations(Annotation[] annotations) {
		if (annotations.length < 2)
			return false;

		boolean hasValid = false;
		boolean hasRequestBody = false;

		for (Annotation annotation : annotations) {
			if (Valid.class.isInstance(annotation))
				hasValid = true;
			else if (RequestBody.class.isInstance(annotation))
				hasRequestBody = true;

			if (hasValid && hasRequestBody)
				return true;
		}
		return false;
	}

	private JsonResult validateArg(Object arg, String argName) {
		BindingResult result = getBindingResult(arg, argName);
		validator.validate(arg, result);
		if (result.hasErrors()) {
			JsonResult jsonresult = new JsonResult();
			jsonresult.setSuccess(false);
			jsonresult.setMsg("fail");
			return jsonresult;
		}
		return null;
	}

	private BindingResult getBindingResult(Object target, String targetName) {
		return new BeanPropertyBindingResult(target, targetName);
	}

	@Required
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
}
