package com.spring.mvc.todo.app.service;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

public interface TodoTaskService {

	/**
	 * @param todoTask
	 * @return
	 */
	public Long create(TodoTask todoTask);

	
	/**
	 * @return
	 */
	public List<TodoTask> getAllTodos();


	/**
	 * @param id
	 * @return
	 */
	public TodoTask getTodoById(Long id);

	/**
	 * @param tt
	 * @param id
	 */
	void update(TodoTask tt, Long id);
	
	/**
	 * @param id
	 */
	String delete(Long id);
}
