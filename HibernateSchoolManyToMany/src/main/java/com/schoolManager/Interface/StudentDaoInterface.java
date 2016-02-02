package com.schoolManager.Interface;

import java.io.Serializable;
import java.util.List;

public interface StudentDaoInterface<T , Id extends Serializable> {
	public void persist(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Id id);
	public List<T> findAllStudents(Id id);
	public List<T> findStudentsNoRegistrated(Id id);
	public void deleteStudent(Id id);
}
