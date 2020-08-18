package com.spring.mvc.todo.app.dao;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author Kameshkr258
 */
public interface TodoTaskDao {

	/**
	 * @param todoTask
	 */
	void create(TodoTask todoTask);

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
	 * @param todoTask
	 */
	void update(TodoTask todoTask);

	/**
	 * @param todoTask
	 */
	void delete(TodoTask todoTask);

	/**
	 * @param status
	 * @return
	 */
	int deleteByStatus(String status);

}
