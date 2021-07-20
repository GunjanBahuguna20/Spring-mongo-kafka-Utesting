package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Course;

public interface CourseService {
	
	public void getCourses();

	public Optional<Course> getCourse(long courseId);

	public void addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long courseId);
	

}
