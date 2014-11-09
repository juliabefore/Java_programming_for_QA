package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;
	private SortedListOf<ContactData> cachedContactsTel;
	
	public SortedListOf<ContactData> getContactsForPhoneTests() {
		if(cachedContacts == null){
			rebuildCacheForPhoneTests();
		}
		return cachedContacts;
	}
	
	private void rebuildCacheForPhoneTests() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
				
			WebElement lastNameS = row.findElement(By.xpath(".//td[2]"));
			String lastName = lastNameS.getText();
						
			WebElement firstNameS = row.findElement(By.xpath(".//td[3]"));
			String firstName = firstNameS.getText();
			
			WebElement telHomeS = row.findElement(By.xpath(".//td[5]"));
			String telHome = telHomeS.getText();
												
			ContactData contact = new ContactData();
			contact.withLastName(lastName);
			contact.withFirstName(firstName);
			contact.withTelHome(telHome);
			cachedContacts.add(contact);
		}
	}

	public SortedListOf<ContactData> getContactsFromPhonePage() {
		if(cachedContactsTel == null){
			rebuildCachePhonePage();
		}
		return cachedContactsTel;
	}
	
	public SortedListOf<ContactData> tryGetContPhonePage() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		List<WebElement> rows = getContactRowsOnPhonePage();
		for (WebElement row : rows) {
			WebElement firstNameLastNameS = row.findElement(By.xpath(".//b"));
			//String firstNameLastName = firstNameLastNameS.getText();
			String firstNameLastName = firstNameLastNameS.getAttribute("textContent");
			String[] arrFirstLastNames = firstNameLastName.split("\\s+");
			//String firstName = firstNameLastName;
			
			String firstName;
			String lastName;
			
			if(firstNameLastName.matches("\\s+\\w+") == true){
				firstName = "bla";
				lastName = firstNameLastName.trim();
			}else{
				firstName = arrFirstLastNames[0];
				try{
					lastName = arrFirstLastNames[1];
				}
				catch(java.lang.ArrayIndexOutOfBoundsException e){
					lastName = "null";
				}
			}
			
			/*
			WebElement allInfo = row.findElement(By.xpath("//td[@valign='top']"));
			String allInfoStr = allInfo.getText();
			String telHome = allInfoStr;
			*/
			
			ContactData contact = new ContactData();
			contact.withFirstName(firstName);
			contact.withLastName(lastName);
			//contact.withTelHome(telHome);
			contacts.add(contact);
		}
		return contacts;
	}
	
	private void rebuildCachePhonePage() {
		cachedContactsTel = new SortedListOf<ContactData>();
		manager.navigateTo().phonePage();
		List<WebElement> rows = getContactRowsOnPhonePage();
		for (WebElement row : rows) {
			WebElement firstNameLastNameS = row.findElement(By.xpath(".//b"));
			String firstNameLastName = firstNameLastNameS.getText();
			String[] arrFirstLastNames = firstNameLastName.split("\\s+");
			String firstName = arrFirstLastNames[0];
			String lastName = arrFirstLastNames[1];
			
			WebElement allInfo = row.findElement(By.xpath("//td[@valign='top']"));
			String allInfoStr = allInfo.getText();
			String telHome = allInfoStr;
			
			
			ContactData contact = new ContactData();
			contact.withFirstName(firstName);
			contact.withLastName(lastName);
			contact.withTelHome(telHome);
			cachedContactsTel.add(contact);
		}
	}

	public SortedListOf<ContactData> getContacts(){
		if(cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
		
		
	}

	public SortedListOf<ContactData> tryGetContMainPage() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
				
			WebElement lastNameS = row.findElement(By.xpath(".//td[2]"));
			String lastName = lastNameS.getText();
						
			WebElement firstNameS = row.findElement(By.xpath(".//td[3]"));
			String firstName = firstNameS.getText();
			/*									
			WebElement emailS = row.findElement(By.xpath(".//td[4]"));
			String eMail = emailS.getText();
			*/	/*		
			WebElement telS = row.findElement(By.xpath(".//td[5]"));
			String telHome = telS.getText();
			*/			
			ContactData contact = new ContactData();
			contact.withLastName(lastName);
			contact.withFirstName(firstName);
			//contact.withEMail(eMail);
			//contact.withTelHome(telHome);
			contacts.add(contact);
		}
		return contacts;
	}
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
				
			WebElement lastNameS = row.findElement(By.xpath(".//td[2]"));
			String lastName = lastNameS.getText();
						
			WebElement firstNameS = row.findElement(By.xpath(".//td[3]"));
			String firstName = firstNameS.getText();
												
			WebElement emailS = row.findElement(By.xpath(".//td[4]"));
			String eMail = emailS.getText();
						
			WebElement telS = row.findElement(By.xpath(".//td[5]"));
			String telHome = telS.getText();
						
			ContactData contact = new ContactData();
			contact.withLastName(lastName);
			contact.withFirstName(firstName);
			contact.withEMail(eMail);
			contact.withTelHome(telHome);
			cachedContacts.add(contact);
		}
		
	}

	public List<WebElement> getContactRows() {
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		
		return rows;
	}
	
	public List<WebElement> getContactRowsOnPhonePage() {
		List<WebElement> rows = driver.findElements(By.xpath("//td[@valign='top']"));
		
		return rows;
	}

	public ContactHelper createContact(ContactData contact, boolean cREATION2) {
		manager.navigateTo().mainPage();
	    initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact,
			boolean mODIFICATION2) {
		initContactEdit(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public void removeContact(int index) {
		initContactEdit(index);
		submitContactDelete();
		returnToHomePage();
		rebuildCache();
	}
	
	public void cheksOnPhonePage() {
		manager.navigateTo().phonePage();
				
	}
	public void actionsFromPhonePage() {
		driver.navigate().back();
	}
	
	public void goToPhonePage() {
		manager.navigateTo().phonePage();
		
	}
	
		
	//---------------------------------------------------------------------

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getTelHome());
		type(By.name("mobile"), contact.getTelMobile());
		type(By.name("work"), contact.getTelWork());
		type(By.name("email"), contact.getEMail());
		type(By.name("email2"), contact.getEMail2());
	    selectByText(By.name("bday"), contact.getBDay());
	    selectByText(By.name("bmonth"), contact.getBMonth());
	    type(By.name("byear"), contact.getBYear());
	    if(formType == CREATION){
	    	//selectByText(By.name("new_group"), contact.getNewGroup());
	    }else{
	    	if(driver.findElements(By.name("new_group")).size() != 0){
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	    
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhone2());
	    
	    return this;
	}

	

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactEdit(int index) {
		selectContactByIndex(index);
		return this;
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("(//img[@title='Edit'])[" + (index + 1) + "]"));
	}

	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper submitContactDelete() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}
/*
	public List<ContactData> getContacts1() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> lastNames = driver.findElements(By.xpath("//table/tbody/tr[@name='entry'][*]/td[2]"));
		for (WebElement lastName : lastNames) {
			ContactData contact = new ContactData();
			String title = lastName.getText();
			contact.lastName = title; 
			contacts.add(contact);
		}
		return contacts;
	}
*/

	

}
