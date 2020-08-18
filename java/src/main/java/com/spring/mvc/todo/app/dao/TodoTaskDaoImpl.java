package com.spring.mvc.todo.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.mvc.todo.app.model.TodoTask;
import com.spring.mvc.todo.app.uitl.Utility;

/**
 * @author Kameshkr258
 */
@Repository("todoTaskDao")
public class TodoTaskDaoImpl implements TodoTaskDao {

	/**
	 * 
	 */
	private final SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public TodoTaskDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 *
	 */
	@Override
	public List<TodoTask> getAllTodos() {
		try {
			Utility.beginTransaction(sessionFactory);
			@SuppressWarnings("unchecked")
			final
			List<TodoTask> todoTaskList = Utility.getSession(sessionFactory).createCriteria(TodoTask.class).list();
			Utility.commitTransaction(sessionFactory);
			return todoTaskList;
		} catch (final Throwable t) {
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public void create(final TodoTask todoTask) {
		try {
			Utility.beginTransaction(sessionFactory);
			Utility.getSession(sessionFactory).persist(todoTask);
			Utility.commitTransaction(sessionFactory);
		} catch (final Throwable t) {
			Utility.rollbackTransaction(sessionFactory);
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public TodoTask getTodoById(final Long id) {
		try {
			Utility.beginTransaction(sessionFactory);
			final TodoTask todoTask = (TodoTask) Utility.getSession(sessionFactory).get(TodoTask.class, id);
			Utility.commitTransaction(sessionFactory);
			return todoTask;
		} catch (final Throwable t) {
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public void update(final TodoTask todoTask) {
		try {
			Utility.beginTransaction(sessionFactory);
			Utility.getSession(sessionFactory).update(todoTask);
			Utility.commitTransaction(sessionFactory);
		} catch (final Throwable t) {
			Utility.rollbackTransaction(sessionFactory);
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public void delete(final TodoTask todoTask) {
		try {
			Utility.beginTransaction(sessionFactory);
			Utility.getSession(sessionFactory).delete(todoTask);
			Utility.commitTransaction(sessionFactory);
		} catch (final Throwable t) {
			Utility.rollbackTransaction(sessionFactory);
			throw t;
		}
	}

	/**
	 *
	 */
	@Override
	public int deleteByStatus(final String status) {
		final String hql = "DELETE FROM TodoTask WHERE STATUS = :status";
		int result;
		try {
			Utility.beginTransaction(sessionFactory);
			final Query query = Utility.getSession(sessionFactory).createQuery(hql);
			query.setString("status", status);
			result = query.executeUpdate();
			Utility.commitTransaction(sessionFactory);
		} catch (final Throwable t) {
			Utility.rollbackTransaction(sessionFactory);
			throw t;
		}

		return result;
	}

}
