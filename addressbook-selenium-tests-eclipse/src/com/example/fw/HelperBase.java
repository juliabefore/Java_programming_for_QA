package com.example.fw;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {

		
	protected ApplicationManager manager;
	protected WebDriver driver;
	public boolean acceptNextAlert = true;

	public HelperBase(ApplicationManager manager){
		this.manager = manager;
		this.driver = manager.driver;
		
	}
	
	public boolean isElementPresent(By by) {
	    try {
	    driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	acceptNextAlert = true;
	    }
	  }

	public boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	protected void type(By locator, String text) {
		if(text != null){
			driver.findElement(locator).clear();
		    driver.findElement(locator).sendKeys(text);
		}
		
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if(text != null){
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

	public String myRandom(int a) {
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
}
