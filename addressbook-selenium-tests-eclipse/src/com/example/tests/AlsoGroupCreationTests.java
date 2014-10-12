package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase{
  
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name " + myRandom(1);
    group.header = "header " + myRandom(1);
    group.footer = "footer " + myRandom(1);
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  } 

}

