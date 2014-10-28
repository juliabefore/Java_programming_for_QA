package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result
			//	+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	
	
	@Override
	public String toString() {
		return "ContactData [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", telHome=" + telHome
				+ ", telMobile=" + telMobile + ", telWork=" + telWork
				+ ", eMail=" + eMail + ", eMail2=" + eMail2 + ", bDay=" + bDay
				+ ", bMonth=" + bMonth + ", bYear=" + bYear + ", newGroup="
				+ newGroup + ", address2=" + address2 + ", phone2=" + phone2
				+ "]";
	}



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

	@Override
	public int compareTo(ContactData other) {
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}
}