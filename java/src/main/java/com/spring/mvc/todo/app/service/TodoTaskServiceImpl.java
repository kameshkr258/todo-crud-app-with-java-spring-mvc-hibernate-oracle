package com.spring.mvc.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.spring.mvc.todo.app.dao.TodoTaskDao;
import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author Kameshkr258
 *
 */
@Service("todoTaskService")
public class TodoTaskServiceImpl implements TodoTaskService {

	/**
	 * TodoTaskDao todoTaskDao
	 */
	@Autowired
	private TodoTaskDao todoTaskDao;

	/**
	 * @param st
	 * @return
	 */
	@Override
	public Long create(final TodoTask todoTask) {
		todoTaskDao.create(todoTask);
		return todoTask.getId();
	}


	/**
	 * @return
	 */
	@Override
	public List<TodoTask> getAllTodos() {
		return todoTaskDao.getAllTodos();
	}


	/**
	 * @param id
	 * @return
	 */
	@Override
	public TodoTask getTodoById(final Long id) {
		return todoTaskDao.getTodoById(id);
	}


	/**
	 * @param tt
	 * @param id
	 */
	@Override
	public void update(final TodoTask tt, final Long id) {
		final TodoTask todoTask = todoTaskDao.getTodoById(id);
		if (todoTask != null) {
			todoTask.setTitle(tt.getTitle());
			todoTask.setDescription(tt.getDescription());
			todoTask.setStatus(tt.getStatus());
			todoTask.setCompletionDate(tt.getCompletionDate());
			todoTaskDao.update(todoTask);
		}

	}


	/**
	 * @param id
	 * @return
	 */
	@Override
	public String delete(final Long id) {
		final TodoTask todoTask = todoTaskDao.getTodoById(id);
		final String title = todoTask.getTitle();
		if (todoTask != null) {
			todoTaskDao.delete(todoTask);
		}
		return title;
	}


	/**
	 * @param status
	 * @return
	 */
	@Override
	public int deleteByStatus(final String status) {
		int result = 0;
		if(!StringUtils.isEmpty(status)) {
			result = todoTaskDao.deleteByStatus(status);
		}
		return result;
	}


}
