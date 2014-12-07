package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase{

	@Test(dataProvider = "randomValidContactsGenerator")
	public void modifySomeContact(ContactData contact){
				
		//save old state
		SortedListOf<ContactData> oldList = app.getModel().getContacts();
		//SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getContactHelper().modifyContact(index, contact, MODIFICATION);
		
		//save new state
	    SortedListOf<ContactData> newList = app.getModel().getContacts();
	    //SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    //assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	    
	    //Compare model to implementation
	    if(wantToCheck()){
	    	if("yes".equals(app.getProperty("check.db"))){
	        	assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
	        }
	        if("yes".equals(app.getProperty("check.ui"))){
	        	assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUiContacts()));
	        }
	    }
	}
}
