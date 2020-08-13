package com.spring.mvc.todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ToDoAppController {

	/**
	 * This Method will list All existing Students
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model) {
		System.out.println("request is coming");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("allStudents");
		return mv;
	}


}
