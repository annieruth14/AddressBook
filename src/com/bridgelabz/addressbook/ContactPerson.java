package com.bridgelabz.addressbook;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class ContactPerson {

	private static ArrayList<AddressBook> new_list = new ArrayList<AddressBook>();
	public static void main(String[] args) {
		 
		new_list = addPerson();
		editContact();
		deleteContact();
	}
	
	public static ArrayList addPerson() {
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
		return list;
		
	}
	public  static void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name to edit");
		String name = sc.nextLine();
		String search = "null";
		
		System.out.println("Enter the field you want to edit");
		String field = sc.nextLine();
		System.out.println("Enter the new value");
		String new_value = sc.nextLine();
		for(AddressBook b : new_list) {
			if(name.equalsIgnoreCase(b.getFirst_name())) {
				if(field.equalsIgnoreCase("address")) {
					b.setAddress(new_value);
				}
				else if(field.equalsIgnoreCase("city")) {
					b.setCity(new_value);
				}
				else if(field.equalsIgnoreCase("state")) {
					b.setState(new_value);
				}
				else if(field.equalsIgnoreCase("zip")) {
					int val = Integer.parseInt(new_value);
					b.setZip(val);
				}
				else if(field.equalsIgnoreCase("phone")) {
					long ph = Long.parseLong(new_value);
					b.setPhone(ph);
				}
				else if(field.equalsIgnoreCase("email")) {
					b.setEmail(new_value);
				}
				else
					System.out.println("The name of the field is not correct");
			}
			
		}
		System.out.println("The details after editing are :");
		for(AddressBook p : new_list) {
			System.out.println(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail());

		}
	}
	
	public static void deleteContact() {
		Scanner sc = new Scanner(System.in);
		Iterator<AddressBook> itr = new_list.iterator();
		System.out.println("Enter name of the person to be deleted");
		String del_person = sc.nextLine();
		while(itr.hasNext()) {
			AddressBook book= itr.next();
			if(book.getFirst_name().equalsIgnoreCase(del_person)) {
				itr.remove();
			}
		}
		System.out.println("The details after deleting are :");
		for(AddressBook p : new_list) {
			System.out.println(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail());

		}
	}
}





















