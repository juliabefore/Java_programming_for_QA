package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase{
	
	@Test(enabled = true)
	public void deleteSomeGroup() throws Exception{
		
	    //save old state
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		//SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
		
		//save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		//SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
		//SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
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
