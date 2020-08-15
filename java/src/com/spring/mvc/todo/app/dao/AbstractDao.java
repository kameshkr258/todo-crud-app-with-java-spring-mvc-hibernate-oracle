package com.spring.mvc.todo.app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kameshkr258
 */
public class AbstractDao<PK extends Serializable, T> {

	@Autowired
	private static SessionFactory sessionFactory;

	@SuppressWarnings("rawtypes")
	private final Class persistentClass;
	@SuppressWarnings("rawtypes")
	public AbstractDao() {
		
		this.persistentClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	protected Session getSession() {
		
		if(sessionFactory!=null) {
		System.out.println("sessionFactory " + sessionFactory);
		return sessionFactory.getCurrentSession();
		}else {
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
				} catch (final HibernateException e) {
						System.out.println(e.getMessage());
				}
				
				return sessionFactory.getCurrentSession();
			}
		} 

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {
		getSession().beginTransaction();
		getSession().save(entity);
		final Transaction transaction = getSession().getTransaction();
		transaction.commit();
		
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected List<T> loadAll() {
		getSession();
		final List<T> list = new ArrayList<T>();
		//list = getSession().//(T) getSession().loadAll(T.class);
		return list;

	}

}
