package com.example.tests;

import java.util.ArrayList;
import java.util.Date;
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
			GroupData group = new GroupData()
				.withName(generateRandomString())
				.withHeader(generateRandomString())
				.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for(int i = 0; i < 5; i++){
			ContactData contact = new ContactData()
				.withFirstName(generateRandomString())
				.withLastName(generateRandomString())
				.withAddress(generateRandomString())
				.withTelHome(generateRandomPhone())
				.withTelMobile(generateRandomPhone())
				.withTelWork(generateRandomPhone())
				.withEMail(generateRandomEmail())
				.withEMail2(generateRandomEmail())
				.withBDay(generateRandomDay())
				.withBMonth(generateRandomMonth())
				.withBYear(generateRandomYear())
				.withNewGroup("group name 1")
				.withAddress2(generateRandomString())
				.withPhone2(generateRandomPhone());
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
		if(rnd.nextInt(3) == 0){
			return "";
		}/*else if(rnd.nextInt(4) == 1){
			return null;
		}*/else{
			return "test" + rnd.nextInt();
		}
	}
	
	public String generateRandomPhone(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		}else{
			int rand1 = 100 + (int)(Math.random() * ((999 - 100) + 1));
			int rand2 = 100 + (int)(Math.random() * ((999 - 100) + 1));
			int rand3 = 10 + (int)(Math.random() * ((99 - 10) + 1));
			int rand4 = 10 + (int)(Math.random() * ((99 - 10) + 1));
			return "+38 " + "(" + rand1 + ") " + rand2 + "-" + rand3 + "-" + rand4;
		}
	}
	
	public String generateRandomEmail(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		}else{
			return "e-mail" + rnd.nextInt() + "@gmail.com";
		}
	}
/*	
public static Date rundomWithNulls(){
		
		Random rnd = new Random();
		Date date = new Date();
		if(rnd.nextInt(3) == 0){
			
			return null;
		}else{
			int year = 1920 + (int)(Math.random() * ((2014 - 1920) + 1));
			date.setYear(year);
			int month = rnd.nextInt(13) + 1;
			date.setMonth(month);
			int day = rnd.nextInt(32) + 1;
			date.setDate(day);
		}
		
		
		return date;
	}*/
		
}
