package com.schoolManager.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.schoolManager.Interface.StudentDaoInterface;
import com.schoolManager.domain.Student;

public class StudentDao implements StudentDaoInterface<Student , String> {
	
	private Session currentSession;
	private Transaction currentTransaction;
	public StudentDao(){
		
	}
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(Student entity) {
		getCurrentSession().save(entity);
	}
	public void delete(Student entity) {
		getCurrentSession().delete(entity);
	}
	public void update(Student entity) {
		getCurrentSession().update(entity);
    }

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents(String inputCourse) {
		
		List<Student> students = new ArrayList<Student>();	
		SQLQuery q = getCurrentSession().createSQLQuery("Select s.student_id,s.student_name FROM students as s, Students_Courses as j, courses as c "
				+ "WHERE s.student_id = j.student_id "
				+ "AND c.course_id = j.course_id "
				+ "AND c.course_name = :mycourse "  + " ORDER by s.student_name");		
		//
		q.setString("mycourse", inputCourse);      
		List<Object[]> rows = q.list();
		for(Object[] row : rows){
			Student student = new Student();
			student.setId(Integer.parseInt(row[0].toString()));
			student.setName(row[1].toString());
			students.add(student);
		}
		return students;		
	}		
	
	public void deleteStudent(String id) {
	
        Query q = getCurrentSession().createQuery("from  Student as student where student.id = :studentId ");
        q.setParameter("studentId", Integer.parseInt(id));
        Student student = (Student)q.list().get(0);        
        delete(student);
	
	}
	public Student findById(String id) {
			Student student = (Student) getCurrentSession().get(Student.class, Integer.parseInt(id));
			return student; 
	}
	@SuppressWarnings("unchecked")
	public List<Student> findStudentsNoRegistrated(String inputCourse) {
		List<Student> students = new ArrayList<Student>();	
		SQLQuery q = getCurrentSession().createSQLQuery("Select st.student_id,st.student_name FROM students as st WHERE st.student_name NOT IN (Select s.student_name FROM students as s, Students_Courses as j, courses as c "
				+ "WHERE s.student_id = j.student_id "
				+ "AND c.course_id = j.course_id "
				+ "AND c.course_name = :mycourse )"  + " ORDER by st.student_name");		
		//
		q.setString("mycourse", inputCourse);      
		
		List<Object[]> rows = q.list();
		for(Object[] row : rows){
			Student student = new Student();
			student.setId(Integer.parseInt(row[0].toString()));
			student.setName(row[1].toString());
			students.add(student);
		}
		return students;		
	
	}	
}
