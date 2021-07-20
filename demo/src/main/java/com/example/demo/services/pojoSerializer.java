package com.example.demo.services;


import org.apache.kafka.common.serialization.Serializer;

import com.example.demo.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

public class pojoSerializer implements Serializer<Course> {

	@Override
	public byte[] serialize(String topic, Course data) {
		
		byte[] retVal=null;
		ObjectMapper objectmapper=new ObjectMapper();
		try {
			retVal=objectmapper.writeValueAsString(data).getBytes();
		}
		catch(Exception e) {
			System.out.println("Error in serializing" + data);
		}
		
		return retVal;
		
		// TODO Auto-generated method stub
	}

	

}
