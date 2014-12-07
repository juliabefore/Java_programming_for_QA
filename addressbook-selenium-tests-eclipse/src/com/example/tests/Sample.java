package com.example.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;
import com.example.fw.WebDriverHelperBase;

public class Sample extends WebDriverHelperBase {

	public Sample(ApplicationManager manager) {
		super(manager);
	}
	protected static WebDriver driver;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		ApplicationManager app = new ApplicationManager(properties);
		System.out.println(app.getHibernateHelper().listContacts());
		
		//System.out.println(app.getHibernateHelper().listGroups());
	
		
		//JdbcHelper jdbc = new JdbcHelper(app, "jdbc:mysql://localhost/addressbook?user=root&password=");
		//System.out.println(jdbc.listGroups());
		
		/*String a = "tttest";
		String b = "testtest";
					
		System.out.println(b.contains(a));
		System.out.println(b.indexOf(a));
		
		String c = "test     test     test";
		String[] arr = c.split("\\s+");
		System.out.println(arr.length);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		String d = "+7 (916) 123-45-67";
		System.out.println(d.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-]+"));
		String e = d.replaceAll("[ ()\\-]", "");
		System.out.println(e);
		System.out.println(e.matches("\\+\\d+"));
		
		String f = "        +7 (916) 123-45-67        ";
		String g = f.trim();
		System.out.println(g);
		
		String str1 = "str1";
		String str2 = "str1";
		
		System.out.println(str1.toLowerCase().compareTo(str2.toLowerCase()));
		*//*
		String str3 = "FirstName LastName";
		String[] arr3 = str3.split("\\s+");
		System.out.println(arr3[0]);
		System.out.println(arr3[1]);*/
		/*
		String str4 = " test-1310396153";
		String[] arr4 = str4.split("\\s+");
		System.out.println(arr4[0]);
		System.out.println(arr4[1]);
		/*
		String str5 = "FirstName LastName:	H: +38 (413) 374-49-98 M: +38 (981) 713-93-44";
		String[] arrStr5 = str5.split("\\:");
		System.out.println(arrStr5[0]);
		System.out.println(arrStr5[1]);
		System.out.println(str5.substring(19, 42));
		*/
		/*
		WebElement str5w = driver.findElement(By.xpath("//tr[1]/td[2]"));
		String str5 = str5w.getText();
		System.out.println(str5);*/
		
		/*
		String firstNameLastName = " test1566288806";
		String[] arrFirstLastNames = firstNameLastName.split("\\s+");
		//System.out.println(str6.matches("\\s+\\w+"));
		String firstName = "ky";
		String lastName = "ky-ky";
		
		if(firstNameLastName.matches("\\s+\\w+") == true){
			firstName = "";
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
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println("ky-k-ky");
		System.out.println(firstNameLastName.matches("\\s+\\w+"));
		*/
		/*
		String line = ",,test102550157,!";
		System.out.println(line.split(",").length);
		*/
	}

}
