package com.spring.mvc.todo.app.dao;

import java.util.List;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author kameshkr258
 */
public interface TodoTaskDao {

	void createTodoTask(TodoTask todoTask);

	List<TodoTask> getAllTodoTask();

	TodoTask getTodoTaskById(Long id);

	void updateStudent(TodoTask todoTask);

}
