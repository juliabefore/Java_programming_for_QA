package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test(enabled = false)
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "first name " + app.myRandom(1);
	contact.lastName = "last name " + app.myRandom(1);
	contact.address = "address " + app.myRandom(1);
	contact.telHome = "tel home " + app.myRandom(1);
	contact.telMobile = "tel mobile " + app.myRandom(1);
	contact.telWork = "tel work " + app.myRandom(1);
	contact.eMail = "e-mail " + app.myRandom(1);
	contact.eMail2 = "e-mail " + app.myRandom(1);
	contact.bDay = app.myRandom(4);
	contact.bMonth = app.myRandom(3);
	contact.bYear = app.myRandom(2);
	contact.newGroup = "group name 1";
	contact.address2 = "address " + app.myRandom(1);
	contact.phone2 = "home " + app.myRandom(1);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }
  
  @Test(enabled = false)
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
