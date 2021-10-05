package com.javamodeling.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.javamodeling.common.ResultValue;
import com.javamodeling.component.DaoInterface;

public class JPADaoSupport implements DaoInterface {
	
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;

	@Override
	public <T> T addEntity(T t) {
		
		entityManager.persist(t);
		
		return t;
	}

	@Override
	public <T> T addEntityFlush(T t) {

		entityManager.persist(t);
		
		entityManager.flush();
		
		return t;
	}
	
	@Override
	public <T> T removeEntity(T t) {

		T tResult = obtainEntityByPk(t);
		
		entityManager.remove(tResult);
		
		return t;
	}

	@Override
	public void flush() {
		entityManager.flush();		
	}

	@Override
	public void clear() {
		entityManager.clear();		
	}
	
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public Connection getConnection() {
		
		Connection connection = null;
		
		Session session = (Session) entityManager.getDelegate();
		
		SessionFactory sessionFactory = session.getSessionFactory();
		
		ConnectionProvider connectionProvider = sessionFactory.getSessionFactoryOptions()
				.getServiceRegistry()
				.getService(ConnectionProvider.class);
		
		try {
			connection = connectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return connection;

	}
	
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	@Override
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T obtainEntityByPk(T t) {
		
		if (t == null) {
			return null;
		}
		
		Class<?> clazz = t.getClass();
		
		Field fieldId = null;
		
		for (Field field : clazz.getDeclaredFields()) {
			
			Annotation[] annotations = field.getAnnotations();
			
			boolean isFound = false;
			
			for (Annotation annotation : annotations) {
				
				if (annotation.annotationType() == Id.class) {
					
					fieldId = field;
					isFound = true;
					break;
				}
			}
			
			if (isFound) {
				break;
			}
			
		}
		
		Method selectedMethod = null;
		
		if (fieldId != null) {
			
			String fieldName = fieldId.getName();
			
			for (Method method : clazz.getMethods()) {
				
				String name = method.getName();
				
				if (name.startsWith("get") && name.equalsIgnoreCase("get" + fieldName)) {
					
					selectedMethod = method;
					break;
				}
			}

		}
		
		T t2 = null;
		
		try {
			
			Object pkObject = selectedMethod.invoke(t, new Object[]{});
			
			t2 = (T)entityManager.find(t.getClass(), pkObject);
			
			if (t2 == null) {
				
				t2 = (T) t.getClass().newInstance();
				
				ResultValue resultValue = (ResultValue)t2;
				resultValue.setResultCodeZero();
			}
			else {
				
				ResultValue resultValue = (ResultValue)t2;
				resultValue.setResultCodePlus();
			}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		return t2;
	}
	
	
}
