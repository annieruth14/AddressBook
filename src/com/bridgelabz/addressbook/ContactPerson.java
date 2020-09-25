package com.bridgelabz.addressbook;
import java.util.Scanner;
import java.util.ArrayList;

public class ContactPerson {

	
	public static void main(String[] args) {
		ArrayList<AddressBook> list = new ArrayList<AddressBook>(); 
		Scanner sc = new Scanner(System.in);
		String answer = "null"; 
		while(!(answer.equals("no"))) {
			
			System.out.println("Enter the first name of a person");
			String f_name = sc.nextLine();
			System.out.println("Enter the last name of a person");
			String l_name = sc.nextLine();
			System.out.println("Enter the address");
			String address = sc.nextLine();
			System.out.println("Enter the city");
			String city = sc.nextLine();
			System.out.println("Enter the state");
			String state = sc.nextLine();
			System.out.println("Enter the zip code");
			int zip = sc.nextInt();
			System.out.println("Enter the phone number");
			long ph = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the email");
			String email = sc.nextLine();
			
			AddressBook book = new AddressBook(f_name,l_name,address,city,state,zip,ph,email);
			list.add(book);
			System.out.println("Do you want to enter more person? Enter yes or no: ");
			answer = sc.nextLine();
		}
		
	}
}



















