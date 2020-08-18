/*
 * 
 */
package com.spring.mvc.todo.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * @author Kameshkr258
 *
 */
public class BaseValidator implements Validator {

	/**
	 * @param arg0
	 * @return
	 */
	@Override
	public boolean supports(final Class<?> arg0) {
		return false;
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	@Override
	public void validate(final Object arg0, final Errors arg1) {

	}
}
