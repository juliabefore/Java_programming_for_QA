package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	    
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
	    app.stop();
	
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
				
		for(int i = 0; i<5; i++){
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(int i = 0; i < 5; i++){
			ContactData contact = new ContactData();
			contact.firstName = generateRandomString();
			contact.lastName = generateRandomString();
			contact.address = generateRandomString();
			contact.telHome = generateRandomString();
			contact.telMobile = generateRandomString();
			contact.telWork = generateRandomString();
			contact.eMail = generateRandomString();
			contact.eMail2 = generateRandomString();
			contact.bDay = generateRandomDay();
			contact.bMonth = generateRandomMonth();
			contact.bYear = generateRandomYear();
			contact.newGroup = "group name 1";
			contact.address2 = generateRandomString();
			contact.phone2 = generateRandomString();
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
		
	public String generateRandomDay(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "-";
		}else{
			return Integer.toString(rnd.nextInt(29) + 1);
		}
	}
	
	public String generateRandomMonth(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "-";
		}else{
			String sRand = null;
			int rand = rnd.nextInt(13) + 1;
			switch (rand){
            case 1: sRand = "January"; break;
            case 2: sRand = "February"; break;
            case 3: sRand = "March"; break;
            case 4: sRand = "April"; break;
            case 5: sRand = "May"; break;
            case 6: sRand = "June"; break;
            case 7: sRand = "July"; break;
            case 8: sRand = "August"; break;
            case 9: sRand = "September"; break;
            case 10: sRand = "October"; break;
            case 11: sRand = "November"; break;
            case 12: sRand = "December"; break;
        }
			return sRand;
		}
	}
	
	public String generateRandomYear(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		}else{
			int rand = 1920 + (int)(Math.random() * ((2014 - 1920) + 1));
			return Integer.toString(rand);
		}
		
	}

	public String generateRandomString(){
		Random rnd = new Random();
		if(rnd.nextInt(4) == 0){
			return "";
		}/*else if(rnd.nextInt(4) == 1){
			return null;
		}*/else{
			return "test" + rnd.nextInt();
		}
	}
		
}
