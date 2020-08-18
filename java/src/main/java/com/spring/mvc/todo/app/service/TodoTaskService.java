package com.spring.mvc.todo.app.service;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author Kameshkr258
 *
 */
public interface TodoTaskService {

	/**
	 * @param todoTask
	 * @return
	 */
	Long create(TodoTask todoTask);


	/**
	 * @return
	 */
	List<TodoTask> getAllTodos();


	/**
	 * @param id
	 * @return
	 */
	TodoTask getTodoById(Long id);

	/**
	 * @param tt
	 * @param id
	 */
	void update(TodoTask tt, Long id);

	/**
	 * @param id
	 */
	String delete(Long id);

	/**
	 * @param status
	 */
	int deleteByStatus(String status);
}
