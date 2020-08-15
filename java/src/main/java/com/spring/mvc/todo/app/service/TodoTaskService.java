package com.spring.mvc.todo.app.service;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

public interface TodoTaskService {

	/**
	 * @param todoTask
	 * @return
	 */
	public Long createTodoTask(TodoTask todoTask);

	
	/**
	 * @return
	 */
	public List<TodoTask> getAllTodoTask();
}
