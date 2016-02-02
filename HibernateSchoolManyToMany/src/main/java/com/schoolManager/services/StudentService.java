package com.schoolManager.services;

import java.util.List;

import com.schoolManager.DAO.StudentDao;
import com.schoolManager.domain.Student;

public class StudentService {
	private static StudentDao studentDao;
	
	public StudentService(){
		studentDao = new StudentDao();
	}
	public void persist(Student entity) {
		studentDao.openCurrentSessionwithTransaction();
		studentDao.persist(entity);
		studentDao.closeCurrentSessionwithTransaction();
	}	
	public void delete(Student entity) {
		studentDao.openCurrentSessionwithTransaction();
		studentDao.delete(entity);
		studentDao.closeCurrentSessionwithTransaction();
	}
	public void update(Student entity) {
		studentDao.openCurrentSessionwithTransaction();
		studentDao.update(entity);
		studentDao.closeCurrentSessionwithTransaction();
	}	
	public void deleteStudent(String id) {	
		studentDao.openCurrentSessionwithTransaction();
		studentDao.deleteStudent(id);
		studentDao.closeCurrentSessionwithTransaction();
	}
	public Student findById(String id) {
		studentDao.openCurrentSession();
		Student book = studentDao.findById(id);
		studentDao.closeCurrentSession();
		return book;
	}
	public List<Student> findAllStudent(String id) {
		studentDao.openCurrentSession();
		List<Student> students = studentDao.findAllStudents(id);
		studentDao.closeCurrentSession();
		return students;
	}
	public List<Student> findStudentNoRegistrated(String id) {
		studentDao.openCurrentSession();
		List<Student> students = studentDao.findStudentsNoRegistrated(id);
		studentDao.closeCurrentSession();
		return students;
	}	
	public StudentDao studentDao() {
		return studentDao;
	}	
}
