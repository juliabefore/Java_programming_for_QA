package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class AlsoGroupCreationTests extends TestBase{
  
	@Test(dataProvider = "randomValidGroupGenerator", enabled = false)
	  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	      
	    //save old state
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		/*------------- Get list without ApplicationModel
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    */
	    
	    //actions
	    app.getGroupHelper().createGroup(group);
	    
	    //save new state
	    SortedListOf<GroupData> newList = app.getModel().getGroups();
	    /*------------- Get list without ApplicationModel
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    */
	    
	    //compare states
	    //assertThat(newList, equalTo(oldList.withAdded(group)));
	    
	    //Compare model to implementation
	    if(wantToCheck()){
	    	if("yes".equals(app.getProperty("check.db"))){
	        	assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	        }
	        if("yes".equals(app.getProperty("check.ui"))){
	        	assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
	        }
	    }
	 }
}

