package com.spring.mvc.todo.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author kameshkr258
 */
@Repository("todoTaskDao")
public class TodoTaskDaoImpl implements TodoTaskDao {

	private SessionFactory sessionFactory;

	public TodoTaskDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Transaction beginTransaction() {
		return sessionFactory.getCurrentSession().beginTransaction();
	}
	
	public void commitTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
	@Override
	public List<TodoTask> getAllTodoTask() {
		beginTransaction();
		@SuppressWarnings("unchecked")
		List<TodoTask> todoTaskList = (List<TodoTask>) sessionFactory.getCurrentSession().createCriteria(TodoTask.class).list();
		commitTransaction();
		return todoTaskList;
	}
	
	@Override
	public void createTodoTask(TodoTask todoTask) {
		beginTransaction();
		sessionFactory.getCurrentSession().persist(todoTask);
		commitTransaction();
	}

}
