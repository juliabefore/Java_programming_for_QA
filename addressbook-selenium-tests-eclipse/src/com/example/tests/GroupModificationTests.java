package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
			    
	    //save old state
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
		/*------------- Get list without ApplicationModel
		SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    */
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getGroupHelper().modifyGroup(index, group);
				
		//save new state
	    SortedListOf<GroupData> newList = app.getModel().getGroups();
	    /*------------- Get list without ApplicationModel
	    SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    */
	    
	    //compare states
	    //assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	    
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
