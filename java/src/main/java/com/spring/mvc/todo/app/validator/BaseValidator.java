/*
 * 
 */
package com.spring.mvc.todo.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 */
public class BaseValidator implements Validator {

	/*
	*/
	@Override
	public boolean supports(final Class<?> arg0) {
		return false;
	}

	/*
	*/
	@Override
	public void validate(final Object arg0, final Errors arg1) {

	}
}
