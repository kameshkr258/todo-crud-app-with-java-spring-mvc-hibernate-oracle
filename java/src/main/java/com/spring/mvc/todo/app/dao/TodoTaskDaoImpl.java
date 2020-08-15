package com.spring.mvc.todo.app.dao;

import java.util.List;

import org.hibernate.Session;
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
	public List<TodoTask> getAllTodoTask() {
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
	public void createTodoTask(TodoTask todoTask) {
		beginTransaction();
		getSession().persist(todoTask);
		commitTransaction();
	}

	/**
	 *
	 */
	@Override
	public TodoTask getTodoTaskById(Long id) {
		beginTransaction();
		TodoTask todoTask  = (TodoTask) getSession().get(TodoTask.class, id);
		commitTransaction();
		return todoTask;
	}
	
	/**
	 *
	 */
	@Override
	public void updateStudent(TodoTask todoTask) {
		beginTransaction();
		getSession().update(todoTask);
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
