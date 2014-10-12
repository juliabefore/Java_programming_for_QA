package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "first name 1";
	contact.lastName = "last name 1";
	contact.address = "address 1";
	contact.telHome = "tel home 1";
	contact.telMobile = "tel mobile 1";
	contact.telWork = "tel work 1";
	contact.eMail = "e-mail 1";
	contact.eMail2 = "e-mail 2";
	contact.bDay = "1";
	contact.bMonth = "January";
	contact.bYear = "2001";
	contact.newGroup = "group name 1";
	contact.address2 = "address 2";
	contact.phone2 = "home 1";
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "";
	contact.lastName = "";
	contact.address = "";
	contact.telHome = "";
	contact.telMobile = "";
	contact.telWork = "";
	contact.eMail = "";
	contact.eMail2 = "";
	contact.bDay = "-";
	contact.bMonth = "-";
	contact.bYear = "";
	contact.newGroup = "";
	contact.address2 = "";
	contact.phone2 = "";
    fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
}
