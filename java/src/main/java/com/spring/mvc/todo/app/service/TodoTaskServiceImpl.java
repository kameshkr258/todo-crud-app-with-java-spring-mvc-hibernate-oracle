package com.spring.mvc.todo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Long createTodoTask(TodoTask todoTask) {
		todoTaskDao.createTodoTask(todoTask);
		return todoTask.getId();
	}

	
	/**
	 * @return
	 */
	@Override
	public List<TodoTask> getAllTodoTask() {
		return todoTaskDao.getAllTodoTask();
	}



}
