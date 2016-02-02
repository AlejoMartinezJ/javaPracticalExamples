package com.schoolManager.UI;

import java.util.List;

import com.schoolManager.domain.Course;
import com.schoolManager.domain.Student;
import com.schoolManager.domain.StudentCourse;
import com.schoolManager.services.StudentService;

public class mainApp {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
	
		Student student5 = new Student("Carl");
		Student student1 = new Student("Mike");
		Student student2 = new Student("Paul");
		Student student3 = new Student("Timoty");
		Course course5 = new Course("Math I");
		Course course1 = new Course("Fisiology");
		Course course2 = new Course("English I");

		StudentCourse studentCourse1 = new StudentCourse();
		studentCourse1.setCourse(course1);
		studentCourse1.setStudent(student1);
		studentCourse1.setScore(79);
		student1.getStudentCourses().add(studentCourse1);
		studentService.persist(student1);
		
		StudentCourse studentCourse2 = new StudentCourse();
		studentCourse2.setCourse(course2);
		studentCourse2.setStudent(student3);
		studentCourse2.setScore(92);
		student3.getStudentCourses().add(studentCourse2);
		studentService.persist(student3);	
				
		StudentCourse studentCourse3 = new StudentCourse();
		studentCourse3.setCourse(course2);
		studentCourse3.setStudent(student2);
		studentCourse3.setScore(87);
		student2.getStudentCourses().add(studentCourse3);
		studentService.persist(student2);			
		
		StudentCourse studentCourse4 = new StudentCourse();
		studentCourse4.setCourse(course5);
		studentCourse4.setStudent(student5);
		studentCourse4.setScore(90);
		student5.getStudentCourses().add(studentCourse4);
		studentService.persist(student5);

		
//      Add new course to the student
  
		Student student = studentService.findById("1");
		Course course = new Course("English II");
		 
		StudentCourse studentCourse5 = new StudentCourse();
		studentCourse5.setCourse(course);
		studentCourse5.setStudent(student);
		studentCourse5.setScore(77);
		student.getStudentCourses().add(studentCourse5);
		studentService.update(student);				
//		
		studentService.deleteStudent("1");

//		
		List<Student> allStudents = studentService.findAllStudent("Math I");
		
		for(Student next:allStudents){
			System.out.println(next.getId() + " " + next.getName());
		}
		
		System.out.println("---------------------------------------");
		
		allStudents = studentService.findStudentNoRegistrated("Math I");
		
		for(Student next:allStudents){
			System.out.println(next.getId() + " " + next.getName());
		}		
	}
}
