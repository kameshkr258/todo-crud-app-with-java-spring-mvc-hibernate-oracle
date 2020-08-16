package com.spring.mvc.todo.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.spring.mvc.todo.app.model.TodoTask;

/**
 * @author kameshkr258
 */
@Repository("todoTaskDao")
public class TodoTaskDaoImpl implements TodoTaskDao {

	/**
	 * 
	 */
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public TodoTaskDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 *
	 */
	@Override
	public List<TodoTask> getAllTodos() {
		beginTransaction();
		@SuppressWarnings("unchecked")
		List<TodoTask> todoTaskList = (List<TodoTask>) getSession().createCriteria(TodoTask.class).list();
		commitTransaction();
		return todoTaskList;
	}
	
	/**
	 *
	 */
	@Override
	public void create(TodoTask todoTask) {
		beginTransaction();
		getSession().persist(todoTask);
		commitTransaction();
	}

	/**
	 *
	 */
	@Override
	public TodoTask getTodoById(Long id) {
		beginTransaction();
		TodoTask todoTask  = (TodoTask) getSession().get(TodoTask.class, id);
		commitTransaction();
		return todoTask;
	}
	
	/**
	 *
	 */
	@Override
	public void update(TodoTask todoTask) {
		beginTransaction();
		getSession().update(todoTask);
		commitTransaction();
	}
	
	/**
	 *
	 */
	@Override
	public void delete(TodoTask todoTask) {
		beginTransaction();
		getSession().delete(todoTask);
		commitTransaction();
		
	}

	/**
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * @return
	 */
	public Transaction beginTransaction() {
		return getSession().beginTransaction();
	}
	
	/**
	 * 
	 */
	public void commitTransaction() {
		getSession().getTransaction().commit();
	}

}
