package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.telHome);
		type(By.name("mobile"), contact.telMobile);
		type(By.name("work"), contact.telWork);
		type(By.name("email"), contact.eMail);
		type(By.name("email2"), contact.eMail2);
	    selectByText(By.name("bday"), contact.bDay);
	    selectByText(By.name("bmonth"), contact.bMonth);
	    type(By.name("byear"), contact.bYear);
	    //selectByText(By.name("new_group"), contact.newGroup);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	    
	}

	

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void initContactEdit(int index) {
		selectContactByIndex(index);
		
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("(//img[@title='Edit'])[" + index + "]"));
	}

	public void submitContactDelete() {
		click(By.xpath("//input[@value='Delete']"));
		
	}

	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}

}
