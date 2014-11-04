package com.example.tests;

public class Sample {

	public static void main(String[] args) {
		String a = "tttest";
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
	}

}
