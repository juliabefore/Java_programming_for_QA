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


	private String contId;
	private String firstName;
	private String lastName;
	private String address;
	private String telHome;
	private String telMobile;
	private String telWork;
	private String eMail;
	private String eMail2;
	private String bDay;
	private String bMonth;
	private String bYear;
	private String newGroup;
	private String address2;
	private String phone2;

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
		int resultLN = this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		if (resultLN != 0){
			return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		}else{
			int resultFN = this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
			if(resultFN != 0){
				return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
			}else{
				int resultM = this.eMail.toLowerCase().compareTo(other.eMail.toLowerCase());
				if(resultM != 0){
					return this.eMail.toLowerCase().compareTo(other.eMail.toLowerCase());
				}else{
					int resultT = this.telHome.toLowerCase().compareTo(other.telHome.toLowerCase());
					if(resultT != 0){
						return this.telHome.toLowerCase().compareTo(other.telHome.toLowerCase());
					}else{
						return 0;
					}
				}
			}
		}
		//
	}

	public ContactData withContId(String contId) {
		this.contId = contId;
		return this;
	}
	
	public ContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withTelHome(String telHome) {
		this.telHome = telHome;
		return this;
	}

	public ContactData withTelMobile(String telMobile) {
		this.telMobile = telMobile;
		return this;
	}

	public ContactData withTelWork(String telWork) {
		this.telWork = telWork;
		return this;
	}

	public ContactData withEMail(String eMail) {
		this.eMail = eMail;
		return this;
	}

	public ContactData withEMail2(String eMail2) {
		this.eMail2 = eMail2;
		return this;
	}

	public ContactData withBDay(String bDay) {
		this.bDay = bDay;
		return this;
	}

	public ContactData withBMonth(String bMonth) {
		this.bMonth = bMonth;
		return this;
	}

	public ContactData withBYear(String bYear) {
		this.bYear = bYear;
		return this;
	}

	public ContactData withNewGroup(String newGroup) {
		this.newGroup = newGroup;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getTelHome() {
		return telHome;
	}

	public String getTelMobile() {
		return telMobile;
	}

	public String getTelWork() {
		return telWork;
	}

	public String getEMail() {
		return eMail;
	}

	public String getEMail2() {
		return eMail2;
	}

	public String getBDay() {
		return bDay;
	}

	public String getBMonth() {
		return bMonth;
	}

	public String getBYear() {
		return bYear;
	}

	public String getNewGroup() {
		return newGroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getContId() {
		return contId;
	}

	public String geteMail() {
		return eMail;
	}

	public String geteMail2() {
		return eMail2;
	}

	public String getbDay() {
		return bDay;
	}

	public String getbMonth() {
		return bMonth;
	}

	public String getbYear() {
		return bYear;
	}

	public void setContId(String contId) {
		this.contId = contId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}

	public void setTelMobile(String telMobile) {
		this.telMobile = telMobile;
	}

	public void setTelWork(String telWork) {
		this.telWork = telWork;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void seteMail2(String eMail2) {
		this.eMail2 = eMail2;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}

	public void setbYear(String bYear) {
		this.bYear = bYear;
	}

	public void setNewGroup(String newGroup) {
		this.newGroup = newGroup;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
}