package com.spring.mvc.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.todo.app.dao.TodoTaskDao;
import com.spring.mvc.todo.app.model.TodoTask;

@Service("todoTaskService")
public class TodoTaskServiceImpl implements TodoTaskService {

	@Autowired
	private TodoTaskDao todoTaskDao;

	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public TodoTask getStudent(Long id) {
		return todoTaskDao.getTodoTask(id);
	}

	
	/**
	 * @param st
	 * @return
	 */
	@Override
	public Long createTodoTask(TodoTask todoTask) {
		return todoTaskDao.createTodoTask(todoTask);
	}

	
	/**
	 * @return
	 */
	@Override
	public List<TodoTask> getAllTodoTask() {
		return todoTaskDao.getAllTodoTask();
	}

	
	/**
	 * @param id
	 * @param todoTask
	 */
	@Override
	public void update(Long id, TodoTask todoTask) {
		final TodoTask todoEntity = todoTaskDao.getTodoTask(id);
		if (todoEntity != null) {
			todoEntity.setTitle(todoTask.getTitle());
			todoEntity.setDescription(todoTask.getDescription());
			todoEntity.setStatus(todoTask.getStatus());
			todoEntity.setCompletionDate(todoTask.getCompletionDate());
			todoTaskDao.updateTodoTask(todoEntity);
		}
	}

	
	/**
	 * @param id
	 */
	@Override
	public void delete(Long id) {
		final TodoTask todoEntity = todoTaskDao.getTodoTask(id);
		if (todoEntity != null) {
			todoTaskDao.deleteTodoTask(todoEntity);
		}
	}

	
	/**
	 * @param id
	 * @return
	 */
	@Override
	public boolean isUniqueTodoTask(Long id) {
		final TodoTask todoTask = todoTaskDao.getTodoTask(id);
		return todoTask == null || id != null & !id.equals(todoTask.getId());
	}

}
