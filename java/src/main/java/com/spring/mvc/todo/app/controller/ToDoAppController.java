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
import com.spring.mvc.todo.app.uitl.Utility;
import com.spring.mvc.todo.app.validator.TodoTaskValidator;


/**
 * @author Kameshkr258
 *
 */
@Controller
@RequestMapping("/")
public class ToDoAppController  extends BaseController<TodoTask> {

	/**
	 * 
	 */
	public ToDoAppController() {
		validator = new TodoTaskValidator(); 
	}

	/**
	 * 
	 */
	@Autowired
	TodoTaskService todoTaskService;

	/**
	 * This Method will list All To-dos Task
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView list(final ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		mv.setViewName("todo/list");
		return mv;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/create" }, method = RequestMethod.GET)
	public String createTodo(final ModelMap model) {
		final TodoTask todoTask = new TodoTask();
		model.addAttribute("todoTask", todoTask);
		model.addAttribute("todoStatusList", Utility.getTodoStatusList());
		return "todo/create";
	}

	/**
	 * @param todoTask
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public ModelAndView createTodo(@Valid final TodoTask todoTask, final BindingResult result, final ModelMap model) {
		final ModelAndView mv = new ModelAndView();

		if(result.hasErrors()) {
			mv.setViewName("todo/create");
			model.addAttribute("todoStatusList", Utility.getTodoStatusList());
			model.addAttribute("error", "Missing required fields.");
			return mv;
		}

		todoTask.setCreatedDate(new Date());
		todoTaskService.create(todoTask);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo <b>" + todoTask.getTitle() + "</b> added successfully.");
		mv.setViewName("todo/list");
		return mv;
	}

	/**
	 * @param taskId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/edit/{taskId}" }, method = RequestMethod.GET)
	public String editTodo(@PathVariable final Long taskId, final ModelMap model) {
		final TodoTask todoTask = todoTaskService.getTodoById(taskId);
		model.addAttribute("todoStatusList", Utility.getTodoStatusList());
		model.addAttribute("todoTask", todoTask);
		return "todo/edit";
	}

	/**
	 * @param taskId
	 * @param todoTask
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/edit/{taskId}" }, method = RequestMethod.POST)
	public ModelAndView editTodo(@PathVariable final Long taskId, @Valid final TodoTask todoTask, final BindingResult result, final ModelMap model) {
		final ModelAndView mv = new ModelAndView();

		if(result.hasErrors()) {
			mv.setViewName("todo/edit");
			model.addAttribute("error", "Missing required fields.");
			model.addAttribute("todoStatusList", Utility.getTodoStatusList());
			return mv;
		}

		todoTaskService.update(todoTask,taskId);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo <b>" + todoTask.getTitle() + "</b> updated successfully.");
		mv.setViewName("todo/list");
		return mv;
	}


	/**
	 * @param taskId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/delete/{taskId}" }, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable final Long taskId, final ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		final String title = todoTaskService.delete(taskId);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo <b>" + title + "</b> deleted successfully.");
		mv.setViewName("todo/list");
		return mv;
	}

	/**
	 * @param status
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/deleteByStatus/{status}" }, method = RequestMethod.GET)
	public ModelAndView deleteByStatus(@PathVariable final String status, final ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		final int result = todoTaskService.deleteByStatus(status);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "<b>"+result+"</b> To-do with <b>"+status+"</b> status deleted.");
		mv.setViewName("todo/list");
		return mv;
	}

}
