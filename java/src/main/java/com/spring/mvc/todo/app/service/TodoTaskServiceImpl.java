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
	 * @param st
	 * @return
	 */
	@Override
	public Long create(TodoTask todoTask) {
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
	 *
	 */
	@Override
	public TodoTask getTodoById(Long id) {
		return todoTaskDao.getTodoById(id);
	}


	/**
	 *
	 */
	@Override
	public void update(TodoTask tt, Long id) {
		TodoTask todoTask = todoTaskDao.getTodoById(id);
		if (todoTask != null) {
			todoTask.setTitle(tt.getTitle());
			todoTask.setDescription(tt.getDescription());
			todoTask.setStatus(tt.getStatus());
			todoTask.setCompletionDate(tt.getCompletionDate());
			todoTaskDao.update(todoTask);
		}
		
	}


	/**
	 *
	 */
	@Override
	public String delete(Long id) {
		TodoTask todoTask = todoTaskDao.getTodoById(id);
		String title = todoTask.getTitle();
		if (todoTask != null) {
			todoTaskDao.delete(todoTask);
		}
		return title;
	}


}
