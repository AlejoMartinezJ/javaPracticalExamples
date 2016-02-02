package com.schoolManager.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;

@Entity
@Table(name="students")
public class Student {

	private int id;
	private String name;	
	private Set<StudentCourse> studentCourses;	
	
	public Student(){}
	public Student(String name){
		this.name = name;
		this.studentCourses = new HashSet<StudentCourse>();
	}
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "student_name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "student")
	@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}
	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	public void addCourse(StudentCourse course) {
        this.studentCourses.add(course);
    }
	
	@Override
	public String toString(){
		return "Student: " + this.id + "  " + this.name;
	}
	
    public void addStudentCourse(StudentCourse studentCourse) {
        this.studentCourses.add(studentCourse);
    }  
}
