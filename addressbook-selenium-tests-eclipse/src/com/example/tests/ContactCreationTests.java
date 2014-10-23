package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test(enabled = true)
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "first name " + myRandomNumbers();
	//contact.firstName = "first name " + app.getGroupHelper().getRandom(1);
	contact.lastName = "last name " + myRandomNumbers();
	contact.address = "address " + myRandomNumbers();
	contact.telHome = "tel home " + myRandomNumbers();
	contact.telMobile = "tel mobile " + myRandomNumbers();
	contact.telWork = "tel work " + myRandomNumbers();
	contact.eMail = "e-mail " + myRandomNumbers();
	contact.eMail2 = "e-mail " + myRandomNumbers();
	contact.bDay = myRandomDay();
	contact.bMonth = myRandomMonth();
	contact.bYear = myRandomYear();
	contact.newGroup = "group name 1";
	contact.address2 = "address " + myRandomNumbers();
	contact.phone2 = "home " + myRandomNumbers();
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  
  @Test(enabled = true)
  public void testEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
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
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
}
