package com.example.tests;

public class ContactData {
	public String firstName;
	public String lastName;
	public String address;
	public String telHome;
	public String telMobile;
	public String telWork;
	public String eMail;
	public String eMail2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String newGroup;
	public String address2;
	public String phone2;

	public ContactData(String firstName, String lastName, String address,
			String telHome, String telMobile, String telWork, String eMail,
			String eMail2, String bDay, String bMonth, String bYear,
			String newGroup, String address2, String phone2) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.telHome = telHome;
		this.telMobile = telMobile;
		this.telWork = telWork;
		this.eMail = eMail;
		this.eMail2 = eMail2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.newGroup = newGroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	
	public ContactData() {
		
	}
}