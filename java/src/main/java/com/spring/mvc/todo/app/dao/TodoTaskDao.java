package com.spring.mvc.todo.app.dao;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author kameshkr258
 */
public interface TodoTaskDao {

	void create(TodoTask todoTask);

	List<TodoTask> getAllTodos();

	TodoTask getTodoById(Long id);

	void update(TodoTask todoTask);
	
	void delete(TodoTask todoTask);

}
