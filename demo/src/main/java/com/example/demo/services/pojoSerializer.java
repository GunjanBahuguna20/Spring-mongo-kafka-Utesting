package com.example.demo.services;


import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.example.demo.model.Course;
import com.fasterxml.jackson.databind.ObjectMapper;

public class pojoSerializer implements Serializer<Course> {
	
@Override 
	public void configure(Map<String, ?> map, boolean b) {

	 }

	@Override
	public byte[] serialize(String arg1,Course arg2) {
		// TODO Auto-generated method stub
		 byte[] retVal = null;
		 ObjectMapper objectMapper = new ObjectMapper();
		    try {
		      retVal = objectMapper.writeValueAsString(arg2).getBytes();
		    } catch (Exception e) {
		    	System.out.println("Error in serializing object"+ arg2);
		    }
		    return retVal;
	}
	@Override 
	public void close() {

	  }


}
	


