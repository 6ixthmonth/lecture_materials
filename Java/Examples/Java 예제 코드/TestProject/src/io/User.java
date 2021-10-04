package io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String name;
	private int age;
	private double height;
	private char gender;
	private boolean marrige;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, int age, double height, char gender, boolean marrige) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
		this.marrige = marrige;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isMarrige() {
		return marrige;
	}

	public void setMarrige(boolean marrige) {
		this.marrige = marrige;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", height=" + height + ", gender=" + gender + ", marrige="
				+ marrige + "]";
	}
}