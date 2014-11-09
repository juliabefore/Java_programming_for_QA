package com.example.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.example.utils.SortedListOf;

public class PrintPhones extends TestBase{
	
	@Test(enabled = false)
	public void checksOnPrintPhones(){
		
		//save list of contacts from main page
		//SortedListOf<ContactData> mainListDetails = app.getContactHelper().getContactsForPhoneTests();
		SortedListOf<ContactData> mainListDetails = app.getContactHelper().tryGetContMainPage();
		List<WebElement> mainList = app.getContactHelper().getContactRows();
		
		//actions
		app.getContactHelper().cheksOnPhonePage();
				
		//save list of contacts from phone page
		//SortedListOf<ContactData> phoneListDetails = app.getContactHelper().getContactsFromPhonePage();
		SortedListOf<ContactData> phoneListDetails = app.getContactHelper().tryGetContPhonePage();
		List<WebElement> phoneList = app.getContactHelper().getContactRowsOnPhonePage();
		
		//actions again
		app.getContactHelper().actionsFromPhonePage();
			    
	    //compare lists
	    assertThat(mainList.size(), equalTo(phoneList.size()));
	    assertThat(mainListDetails, equalTo(phoneListDetails));
	}

}
