package com.activitydata;

import java.io.Serializable;

import android.util.Log;

public class Person implements Serializable{
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
