package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if(args.length < 3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if(file.exists()){
			System.out.println("File exists, please remove it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if("csv".equals(format)){
			saveContactsToCsvFile(contacts, file);
		}else if("xml".equals(format)){
			saveContactsToXmlFile(contacts, file);
		}else{
			System.out.println("Uknown format " + format);
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + "," + contact.getTelHome() + "," + contact.getTelMobile() + "," + contact.getTelWork() + "," + contact.getEMail() + "," + contact.getEMail2() + "," + contact.getBDay() + "," + contact.getBMonth() + "," + contact.getBYear() + "," + contact.getNewGroup() + "," + contact.getAddress2() + "," + contact.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactData contact = new ContactData()
				.withFirstName(part[0])
				.withLastName(part[1])
				.withAddress(part[2])
				.withTelHome(part[3])
				.withTelMobile(part[4])
				.withTelWork(part[5])
				.withEMail(part[6])
				.withEMail2(part[7])
				.withBDay(part[8])
				.withBMonth(part[9])
				.withBYear(part[10])
				.withNewGroup(part[11])
				.withAddress2(part[12])
				.withPhone2(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		
		for(int i = 0; i < amount; i++){
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
			list.add(contact);
		}
		return list;
		
	}
	
	public static String generateRandomString(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		}else{
			return "test" + rnd.nextInt();
		}
	}
	
	public static String generateRandomPhone(){
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
	
	public static String generateRandomEmail(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		}else{
			return "e-mail" + rnd.nextInt() + "@gmail.com";
		}
	}
	
	public static String generateRandomYear(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "";
		}else{
			int rand = 1920 + (int)(Math.random() * ((2014 - 1920) + 1));
			return Integer.toString(rand);
		}
		
	}
	
	public static String generateRandomMonth(){
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
	
	public static String generateRandomDay(){
		Random rnd = new Random();
		if(rnd.nextInt(3) == 0){
			return "-";
		}else{
			return Integer.toString(rnd.nextInt(29) + 1);
		}
	}
}
