package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase{
  
  @Test(enabled = false)
  public void testNonEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name " + app.getGroupHelper().getRandom(1);
    group.header = "header " + app.getGroupHelper().getRandom(1);
    group.footer = "footer " + app.getGroupHelper().getRandom(1);
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }
  
  @Test(enabled = false)
  public void testEmptyGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  } 

}

