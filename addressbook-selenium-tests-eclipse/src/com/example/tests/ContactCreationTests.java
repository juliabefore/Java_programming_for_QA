package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "first name " + myRandom(1);
	contact.lastName = "last name " + myRandom(1);
	contact.address = "address " + myRandom(1);
	contact.telHome = "tel home " + myRandom(1);
	contact.telMobile = "tel mobile " + myRandom(1);
	contact.telWork = "tel work " + myRandom(1);
	contact.eMail = "e-mail " + myRandom(1);
	contact.eMail2 = "e-mail " + myRandom(1);
	contact.bDay = myRandom(4);
	contact.bMonth = myRandom(3);
	contact.bYear = myRandom(2);
	contact.newGroup = "group name 1";
	contact.address2 = "address " + myRandom(1);
	contact.phone2 = "home " + myRandom(1);
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
