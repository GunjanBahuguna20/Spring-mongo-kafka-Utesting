package com.example.demo.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
@Service
public class Consumer {
	@KafkaListener(topics="demo1", groupId="kafka")
public void consumerFromTopic(Course course) {
		System.out.println("recieved"+ course);
		
	}
}
