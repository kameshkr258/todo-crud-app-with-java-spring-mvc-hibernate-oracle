package com.spring.mvc.todo.app.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.todo.app.model.TodoTask;
import com.spring.mvc.todo.app.service.TodoTaskService;

@Controller
@RequestMapping("/")
public class ToDoAppController {

	@Autowired
	TodoTaskService todoTaskService;

	/**
	 * This Method will list All To-dos Task
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list(ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		mv.setViewName("todo/list");
		return mv;
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String createTodo(ModelMap model) {
		final TodoTask todoTask = new TodoTask();
		model.addAttribute("todoTask", todoTask);
		return "todo/create";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public ModelAndView createTodo(@Valid TodoTask todoTask, BindingResult result, ModelMap model) {
		final ModelAndView mv = new ModelAndView();

		todoTask.setCreatedDate(new Date());
		todoTask.setStatus("Active");
		todoTaskService.create(todoTask);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo Task " + todoTask.getTitle() + " added successfully.");
		mv.setViewName("todo/list");
		return mv;
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
	public String editTodo(@PathVariable Long id, ModelMap model) {
		final TodoTask todoTask = todoTaskService.getTodoById(id);
		model.addAttribute("todoTask", todoTask);
		return "todo/edit";
	}

	@RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
	public ModelAndView editTodo(@PathVariable Long id, @Valid TodoTask todoTask, BindingResult result, ModelMap model) {
		final ModelAndView mv = new ModelAndView();

		todoTaskService.update(todoTask,id);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo Task " + todoTask.getTitle() + " updated successfully.");
		mv.setViewName("todo/list");
		return mv;
	}
	

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id, ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		String title = todoTaskService.delete(id);
		model.addAttribute("message", "Todo Task " + title + " deleted successfully.");
		mv.setViewName("todo/list");
		return mv;
	}
}
