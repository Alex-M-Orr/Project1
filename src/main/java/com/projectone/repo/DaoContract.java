package com.projectone.repo;

import java.util.List;

/**
 * @author Alex Orr
 * @Param <T> type of model
 * @Param <I> primary key for model
 * */

public interface DaoContract <T, I> {
	
	/**
	 * @return All instances of model T
	 * */
	List<T> findAll();
	
	/**
	 * @param i primary key of the instance
	 * @return the instance with the same pk
	 * */
	T findById(I i);
	
	/**
	 * @param t the instance to update
	 * @return the updated instance
	 * */
	T update(T t);
	
	/**
	 * @param i the pk of the instance to be deleted
	 * @return return how many were removed;
	 * */
	
	int delete (I i);
}
