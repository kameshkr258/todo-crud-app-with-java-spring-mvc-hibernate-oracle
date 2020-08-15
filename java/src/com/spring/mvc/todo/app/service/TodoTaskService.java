package com.spring.mvc.todo.app.service;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

public interface TodoTaskService {

	/**
	 * @param id
	 * @return
	 */
	public TodoTask getStudent(Long id);
	
	/**
	 * @param st
	 * @return
	 */
	public Long createTodoTask(TodoTask todoTask);

	
	/**
	 * @return
	 */
	public List<TodoTask> getAllTodoTask();

	
	/**
	 * @param id
	 * @param todoTask
	 */
	public void update(Long id, TodoTask todoTask);

	
	/**
	 * @param id
	 */
	public void delete(Long id);

	
	/**
	 * @param id
	 * @return
	 */
	public boolean isUniqueTodoTask(Long id);

}
