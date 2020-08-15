package com.spring.mvc.todo.app.dao;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author kameshkr258
 */
public interface TodoTaskDao {

	TodoTask getTodoTask(Long id);

	Long createTodoTask(TodoTask todoTask);

	List<TodoTask> getAllTodoTask();

	void updateTodoTask(TodoTask todoTask);

	void deleteTodoTask(TodoTask todoTask);

}
