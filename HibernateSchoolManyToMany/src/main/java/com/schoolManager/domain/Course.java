package com.schoolManager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

@Entity
@Table(name = "Courses")
public class Course {

	private int id;
	private String name;
	private Set<StudentCourse> studentCourses;
	
	public Course(){};
	
	public Course(String name){
		this.name = name;
		this.studentCourses = new HashSet<StudentCourse>();
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "course_id")	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "course_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="course")
	public Set<StudentCourse> getStudentCourses(){
		return this.studentCourses;	
	}
    public void setStudentCourses(Set<StudentCourse> courses) {
        this.studentCourses = courses;
    }
     
    public void addStudentCourse(StudentCourse studentCourse) {
        this.studentCourses.add(studentCourse);
    }
 	
	@Override
	public String toString(){
		return name;
	}	
}
