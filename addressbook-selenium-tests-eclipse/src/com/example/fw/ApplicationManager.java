package com.example.fw;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	
	public WebDriver driver;
	public String baseUrl;
			
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	
	public ApplicationManager(){
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}

	public NavigationHelper getNavigationHelper(){
		if (navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if (groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper(){
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}

	public String myRandom(int a){
		Random random = new Random();
		String sRand = null;
		//Random for simple numbers
		if (a == 1){
			int rand = random.nextInt(1000) + 1;
			sRand = Integer.toString(rand);
		}
		//Random for bYear
		else if(a == 2){
			int rand = 1920 + (int)(Math.random() * ((2014 - 1920) + 1));
			sRand = Integer.toString(rand);
		}
		//Random for bMonth
		else if(a == 3){
			int rand = random.nextInt(13) + 1;
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
		}
		//Random for bDay
		else if(a == 4){
			int rand = random.nextInt(29) + 1;
			sRand = Integer.toString(rand);
		}
		return sRand;
	}

	public void stop() {
		driver.quit();
	    		
	}

}
