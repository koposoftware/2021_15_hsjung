package com.javamodeling.component;

import java.sql.Connection;

public interface DaoInterface {
	
	public void flush();
	
	public void clear();
	
	public <T> T addEntity(T t);
	
	public <T> T addEntityFlush(T t);
	
	public <T> T obtainEntityByPk(T t);
	
	public <T> T removeEntity(T t);
	
	public Connection getConnection();
	
	public void beginTransaction();
	
	public void commitTransaction();
	
	public void rollbackTransaction();

}
