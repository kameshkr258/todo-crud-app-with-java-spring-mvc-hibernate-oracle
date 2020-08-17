package com.spring.mvc.todo.app.controller;

import java.util.Date;
import java.util.LinkedList;
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
import com.spring.mvc.todo.app.validator.TodoTaskValidator;


@Controller
@RequestMapping("/")
public class ToDoAppController  extends BaseController<TodoTask> {

	/**
	 * 
	 */
	public ToDoAppController() {
		validator = new TodoTaskValidator(); 
	}

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
		model.addAttribute("todoStatusList", getTodoStatusList());
		return "todo/create";
	}

	@RequestMapping(value = { "/create" }, method = RequestMethod.POST)
	public ModelAndView createTodo(@Valid TodoTask todoTask, BindingResult result, ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("todo/create");
			model.addAttribute("todoStatusList", getTodoStatusList());
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

	@RequestMapping(value = { "/edit/{taskId}" }, method = RequestMethod.GET)
	public String editTodo(@PathVariable Long taskId, ModelMap model) {
		final TodoTask todoTask = todoTaskService.getTodoById(taskId);
		model.addAttribute("todoStatusList", getTodoStatusList());
		model.addAttribute("todoTask", todoTask);
		return "todo/edit";
	}

	@RequestMapping(value = { "/edit/{taskId}" }, method = RequestMethod.POST)
	public ModelAndView editTodo(@PathVariable Long taskId, @Valid TodoTask todoTask, BindingResult result, ModelMap model) {
		final ModelAndView mv = new ModelAndView();

		if(result.hasErrors()) {
			mv.setViewName("todo/edit");
			model.addAttribute("error", "Missing required fields.");
			model.addAttribute("todoStatusList", getTodoStatusList());
			return mv;
		}
		
		todoTaskService.update(todoTask,taskId);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo <b>" + todoTask.getTitle() + "</b> updated successfully.");
		mv.setViewName("todo/list");
		return mv;
	}
	

	@RequestMapping(value = { "/delete/{taskId}" }, method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long taskId, ModelMap model) {
		final ModelAndView mv = new ModelAndView();
		String title = todoTaskService.delete(taskId);
		final List<TodoTask> list = todoTaskService.getAllTodos();
		model.addAttribute("todoTaskList", list);
		model.addAttribute("message", "Todo <b>" + title + "</b> deleted successfully.");
		mv.setViewName("todo/list");
		return mv;
	}
	
	/**
	 * @return
	 */
	public List<String> getTodoStatusList(){
		List<String> todoStatusList = new LinkedList<>();
		todoStatusList.add("Draft");
		todoStatusList.add("Creating");
		todoStatusList.add("Queued");
		todoStatusList.add("Running");
		todoStatusList.add("Aborting");
		todoStatusList.add("Aborted");
		todoStatusList.add("Failed");
		todoStatusList.add("Completed");
		
		return todoStatusList;
	}
	

}
