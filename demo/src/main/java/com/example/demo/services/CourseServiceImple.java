package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;

@Service
public class CourseServiceImple implements CourseService {
	@Autowired
	private CourseDao courseDao;
	
	
	@Autowired
	private KafkaTemplate<String,Course> kafkaTemplate;
	
	private static final String TOPIC="demo1";
	
	
	
//	public void consumeJson(Course course) {
//		System.out.println("consumed JSON message"+ course);
//		courseDao.save(course);
//	}
//	
	
	
	
	@Override
	public List<Course> getCourses() {
		
		List<Course> courselist=courseDao.findAll();
		for(Course i:courselist) {		
			this.kafkaTemplate.send(TOPIC,i);

		}
		return courselist;
		//return courselist;
		
	

		//return courseDao.findAll();
		
	}

	@Override
	public Optional<Course> getCourse(long courseId) {
				return courseDao.findById(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
return course;	
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
