package com.schoolManager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="Students_Courses")
public class StudentCourse {
	
	private int id;
	private Student student;
	private Course course;
	private int score;
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "student_course_id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }   
    
    @ManyToOne(cascade = CascadeType.ALL)
    //@ManyToOne
    @JoinColumn(name = "student_id")  
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }   
    @ManyToOne(cascade = CascadeType.ALL)
    //@ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }  
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}	
	@Override
	public String toString(){
		return this.id + " " + this.student.getName() + " " + this.course.getName();
	}
}
