package com.example.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Course;

public interface CourseDao extends MongoRepository<Course,Long> 
{
	
	

}
