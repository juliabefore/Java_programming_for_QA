package com.example.tests;

import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
	
	public String myRandomNumbers(){
		Random random = new Random();
		String sRand = null;
		int rand = random.nextInt(1000) + 1;
		sRand = Integer.toString(rand);
		return sRand;
	}
	
	public String myRandomYear(){
		String sRand = null;
		int rand = 1920 + (int)(Math.random() * ((2014 - 1920) + 1));
		sRand = Integer.toString(rand);
		return sRand;
	}
	
	public String myRandomMonth(){
		Random random = new Random();
		String sRand = null;
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
		return sRand;
	}
	
	public String myRandomDay(){
		Random random = new Random();
		String sRand = null;
		int rand = random.nextInt(29) + 1;
		sRand = Integer.toString(rand);
		return sRand;
	}
	
}
