package com.spring.mvc.todo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Kameshkr258
 *
 */
@Controller
@RequestMapping("/about")
public class AboutController {

	/**
	 * This Method will tell about developer
	 */
	@RequestMapping(value = { "/dev" }, method = RequestMethod.GET)
	public ModelAndView list(final ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		mv.setViewName("about/dev");
		return mv;
	}


}
