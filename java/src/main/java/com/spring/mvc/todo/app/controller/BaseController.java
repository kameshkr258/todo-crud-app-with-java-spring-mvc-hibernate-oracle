/*
 * 
 */
package com.spring.mvc.todo.app.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.spring.mvc.todo.app.validator.BaseValidator;

/**
 * 
 *
 * @param <T>
 */
public class BaseController<T> {

	/**  */
	protected BaseValidator validator;

	/**
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(final WebDataBinder webDataBinder) {
		webDataBinder.setValidator(validator);
	}

	/**
	 * @return
	 */
	public BaseValidator getValidator() {
		return validator;
	}

	/**
	 * @param validator
	 */
	public void setValidator(final BaseValidator validator) {
		this.validator = validator;
	}
}
