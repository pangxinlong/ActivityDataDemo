package com.activitydata;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Serializable, Parcelable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String id;

	Person(String name, String id) {
		this.name = name;
		this.id = id;
	}

	String getName() {
		return name;
	}

	String getId() {
		return id;
	}

	//实现Parcelable.Creator接口
	
	public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {

		@Override
		public Person createFromParcel(Parcel source) {
			return new Person(source);
		}

		@Override
		public Person[] newArray(int size) {
			return new Person[size];
		}

	};

	private Person(Parcel dest) {
		this.name = dest.readString();
		this.id = dest.readString();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);
		dest.writeString(id);
	}
}
