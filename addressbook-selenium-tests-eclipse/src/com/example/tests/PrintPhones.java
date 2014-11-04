package com.example.tests;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class PrintPhones extends TestBase{
	
	@Test(enabled = false)
	public void checksOnPrintPhones(){
		
		//save list of contacts from main page
		SortedListOf<ContactData> mainList = app.getContactHelper().getContacts();

		//actions
		app.getContactHelper().goToPhonePage();
		
		//save list of contacts from phone page
	    SortedListOf<ContactData> phoneList = app.getContactHelper().getContactsFromPhonePage();
	    
	    //compare states
	    int a = mainList.size();
	    int b = phoneList.size();
	}

}
