package com.practice.resultset;

public class Employee {
	
	private int eId;
	private String eName;
	private float eSalary;
	private long eContact;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public float geteSalary() {
		return eSalary;
	}
	public void seteSalary(float eSalary) {
		this.eSalary = eSalary;
	}
	public long geteContact() {
		return eContact;
	}
	public void seteContact(long eContact) {
		this.eContact = eContact;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eSalary=" + eSalary + ", eContact=" + eContact + "]";
	}
	
	
	

}
