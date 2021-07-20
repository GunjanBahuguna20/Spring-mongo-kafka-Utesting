package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;

@Service
public class CourseServiceImple implements CourseService {
	@Autowired
	private CourseDao courseDao;
	
	
	public static final String topic="demo1";
	@Autowired
	private KafkaTemplate<String,Course> kafkatemp;
	
	
	

	@Override
	public void getCourses() {
		List<Course>courseslist= courseDao.findAll();
		for(Course i: courseslist) {
			this.kafkatemp.send(topic,i);
			
		}
		

		//return courseDao.findAll();
		
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
				return courseDao.findById(courseId);
	}

	@Override
	public void addCourse(Course course) {
		courseDao.save(course);
		this.kafkatemp.send(topic,course);
	
	}

	@Override
	public Course updateCourse(Course course) {
courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		courseDao.deleteById(courseId);
	}

}
