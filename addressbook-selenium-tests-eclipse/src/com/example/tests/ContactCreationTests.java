package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test(enabled = true)
  public void testNonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.firstName = "first name " + app.getGroupHelper().getRandom(1);
	contact.lastName = "last name " + app.getGroupHelper().getRandom(1);
	contact.address = "address " + app.getGroupHelper().getRandom(1);
	contact.telHome = "tel home " + app.getGroupHelper().getRandom(1);
	contact.telMobile = "tel mobile " + app.getGroupHelper().getRandom(1);
	contact.telWork = "tel work " + app.getGroupHelper().getRandom(1);
	contact.eMail = "e-mail " + app.getGroupHelper().getRandom(1);
	contact.eMail2 = "e-mail " + app.getGroupHelper().getRandom(1);
	contact.bDay = app.getGroupHelper().getRandom(4);
	contact.bMonth = app.getGroupHelper().getRandom(3);
	contact.bYear = app.getGroupHelper().getRandom(2);
	contact.newGroup = "group name 1";
	contact.address2 = "address " + app.getGroupHelper().getRandom(1);
	contact.phone2 = "home " + app.getGroupHelper().getRandom(1);
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
