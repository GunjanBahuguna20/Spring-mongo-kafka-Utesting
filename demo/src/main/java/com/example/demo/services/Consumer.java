package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.example.demo.model.Course;

public class Consumer {
@Autowired 
CourseService courseservice;
	
	@KafkaListener(topics="demo1",groupId="kafka")
	public List<Course> consume() {
		List<Course> courselist = courseservice.getCourses();
		return courselist;
	}
	
	@KafkaListener
	public void consume1(Course course) {
		System.out.println("Added course"+course);
		
	}

}
