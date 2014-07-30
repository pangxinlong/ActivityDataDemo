package com.activitydata;

import java.io.Serializable;


public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String id;
	
	Person(String name,String id){
		this.name=name;
		this.id=id;
	}
	
	 String getName(){
		return name;
	}
	
	 String getId(){
		 return id;
	}
}
