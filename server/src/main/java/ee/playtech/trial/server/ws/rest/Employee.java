/*
 * Any use, copying, modification, distribution and selling of this software
 * and its documentation for any purposes without SoftwareMind's written permission
 * is hereby prohibited
 *
 */
package ee.playtech.trial.server.ws.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Employee {
	private String name = "";
	private int age = 0;
	private String department = "";
	private double wage = 0;

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

	public String getDepartment() {
		return department;
	}

	public void setDeparment(String department) {
		this.department = department;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department="
				+ department + ", wage=" + wage + "]";
	}
}