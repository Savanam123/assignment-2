package com.jocata.tcldl.utils;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtils {
	
	@Autowired
	private SessionFactory sessionFactory; 
	//this is created and autowired by Spring automatically - from application properties configuration
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		try {
			
			SessionFactory sessionFactory = getSessionFactory();
			return sessionFactory.openSession();
			
		}catch(Exception e) {
			//logger.error("(:) Error While Getting Session Object (:)");
			e.printStackTrace();
		}
		return null;
	}
	
	public Session openSession() {

		try {
			
			SessionFactory sessionFactory = getSessionFactory();
			return sessionFactory.openSession();
			
		}catch(Exception e) {
			//logger.error("(:) Error While Getting Session Object (:) in openSession()");
			e.printStackTrace();
		}
		return null;
	
	}
	
	public void closeSession(Session session) {
		//logger.info("closeSession() : Session Object ->> "+session);
		if(session != null) {
			session.close();
		}
	}
	
	public <T> Serializable save(T entity) {
		
		Session currentSession = getSession();
		Serializable newPkId = null;
		try {
			
			currentSession.beginTransaction();
			newPkId = currentSession.save(entity);
			currentSession.getTransaction().commit();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return newPkId;
	}
	
	public <T> void update(T entity) {
		Session currentSession = getSession();
		try {
			
			currentSession.beginTransaction();
			currentSession.update(entity);
			currentSession.getTransaction().commit();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
	}
	
	public <T> void delete(T entity) {
		Session currentSession = getSession();
		try {
			
			currentSession.beginTransaction();
			currentSession.delete(entity);
			currentSession.getTransaction().commit();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
	}
	
	public <T> void deleteByHql(String hql) {
		Session currentSession = getSession();
		try {
			
			currentSession.beginTransaction();
			@SuppressWarnings({ "rawtypes" })
			Query query = currentSession.createQuery(hql);
			query.executeUpdate();
			currentSession.getTransaction().commit();	
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
	}
	
	public <T> T getEntityById(Class<T> T, Serializable pkId) {
		Session currentSession = getSession();
		try {
			
			return currentSession.get(T, pkId);
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	
	public <T> T getEntityByHql(String hql) {
		Session currentSession = getSession();
		try {
			
			@SuppressWarnings({ "unchecked" })
			Query<T> query = currentSession.createQuery(hql);
			List<T> myList = query.list();
			
			if(myList != null && myList.size() >0) 
				return myList.get(0);
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	
	public <T> List<T> loadEntityByClassName(Class<T> T) {
		Session currentSession = getSession();
		try {
			
			@SuppressWarnings({ "unchecked" })
			Query<T> query = currentSession.createQuery("from " + T.getName());
			return query.list();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
	
	public <T> List<T> loadEntityByHql(String hql) {
		Session currentSession = getSession();
		try {
			
			@SuppressWarnings({ "unchecked" })
			Query<T> query = currentSession.createQuery(hql);
			return query.list();
			
		}catch(Exception exception) {
			exception.printStackTrace();
			closeSession(currentSession);
		}
		return null;
	}
}
