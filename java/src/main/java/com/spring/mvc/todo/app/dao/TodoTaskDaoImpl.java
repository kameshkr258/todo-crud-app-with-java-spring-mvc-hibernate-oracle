package com.spring.mvc.todo.app.dao;

import java.util.List;

import org.hibernate.Query;
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
		try {
			beginTransaction();
			@SuppressWarnings("unchecked")
			List<TodoTask> todoTaskList = (List<TodoTask>) getSession().createCriteria(TodoTask.class).list();
			commitTransaction();
			return todoTaskList;
		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public void create(TodoTask todoTask) {
		try {
			beginTransaction();
			getSession().persist(todoTask);
			commitTransaction();
		} catch (Throwable t) {
			rollbackTransaction();
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public TodoTask getTodoById(Long id) {
		try {
			beginTransaction();
			TodoTask todoTask = (TodoTask) getSession().get(TodoTask.class, id);
			commitTransaction();
			return todoTask;
		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public void update(TodoTask todoTask) {
		try {
			beginTransaction();
			getSession().update(todoTask);
			commitTransaction();
		} catch (Throwable t) {
			rollbackTransaction();
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public void delete(TodoTask todoTask) {
		try {
			beginTransaction();
			getSession().delete(todoTask);
			commitTransaction();
		} catch (Throwable t) {
			rollbackTransaction();
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public int deleteByStatus(String status) {
		String hql = "DELETE FROM TodoTask WHERE STATUS = :status";
		int result;
		try {
			beginTransaction();
			Query query = getSession().createQuery(hql);
			query.setString("status", status);
			result = query.executeUpdate();
			commitTransaction();
		} catch (Throwable t) {
			rollbackTransaction();
			throw t;
		}
		
		return result;
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

	/**
	 * 
	 */
	public void rollbackTransaction() {
		getSession().getTransaction().rollback();
	}

}
