package com.spring.mvc.todo.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.todo.app.model.TodoTask;
/**
 * @author kameshkr258
 */
@Repository("todoTaskDao")
@Transactional
public class TodoTaskDaoImpl extends AbstractDao<Long, TodoTask> implements TodoTaskDao {

	/**
	 * 
	 */
	@Override
	public TodoTask getTodoTask(Long id) {
		return getByKey(id);
	}

	/**
	 *
	 */
	@Override
	public Long createTodoTask(TodoTask todoTask) {
		persist(todoTask);
		return todoTask.getId();
	}

	/**
	 *
	 */
	@Override
	public List<TodoTask> getAllTodoTask() {
		return super.loadAll();
	}

	/**
	 *
	 */
	@Override
	public void updateTodoTask(TodoTask st) {
		update(st);
	}

	/**
	 *
	 */
	@Override
	public void deleteTodoTask(TodoTask st) {
		delete(st);
	}

}
