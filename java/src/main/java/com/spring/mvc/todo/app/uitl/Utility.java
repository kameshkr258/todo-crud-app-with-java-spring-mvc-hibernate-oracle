package com.spring.mvc.todo.app.uitl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Kameshkr258
 *
 */
public class Utility {

	/**
	 * @return
	 */
	public static List<String> getTodoStatusList(){
		final List<String> todoStatusList = new LinkedList<>();
		todoStatusList.add("Draft");
		todoStatusList.add("Creating");
		todoStatusList.add("Queued");
		todoStatusList.add("Running");
		todoStatusList.add("Aborting");
		todoStatusList.add("Aborted");
		todoStatusList.add("Failed");
		todoStatusList.add("Completed");

		return todoStatusList;
	}

	/**
	 * @return
	 */
	public static Session getSession(final SessionFactory sessionFactory) {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * @return
	 */
	public static Transaction beginTransaction(final SessionFactory sessionFactory) {
		return getSession(sessionFactory).beginTransaction();
	}

	/**
	 * 
	 */
	public static void commitTransaction(final SessionFactory sessionFactory) {
		getSession(sessionFactory).getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void rollbackTransaction(final SessionFactory sessionFactory) {
		getSession(sessionFactory).getTransaction().rollback();
	}


}
