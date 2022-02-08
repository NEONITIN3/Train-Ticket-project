package com.abhi.TrainReservation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger implements Comparable<Passenger> {
	
	@Id
	private String name;
	private int age;
	private char gender;


	public Passenger()
	{	}
	public Passenger(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public int compareTo(Passenger passenger) {

		return this.getAge() - passenger.getAge();
	}
	
}