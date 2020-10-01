package com.bridgelabz.addressbook;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class ContactPerson {
	public static ContactPerson obj = new ContactPerson();
	public static ArrayList<AddressBook> list = new ArrayList<AddressBook>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		 
		obj.addPerson();
		System.out.println("Do you want to edit any details of any person? (yes/no)");
		String ans_edit = sc.nextLine();
		if(ans_edit.equalsIgnoreCase("yes"))
			obj.editContact();
		System.out.println("Do you want to delete a person? (yes/no)");
		String ans_del = sc.nextLine();
		if(ans_del.equalsIgnoreCase("yes"))
			obj.deleteContact();
		System.out.println("Do you want to search a person given city? (yes/no)");
		String ans_city = sc.nextLine();
		if(ans_city.equals("yes"))
			obj.searchPerson();
		
	}
	
	public void searchPerson() {
		System.out.println("Enter the name of the city");
		ArrayList<String> cityList = new ArrayList<>();
		String city = sc.nextLine();
		for(AddressBook b : list) {
			if(b.getCity().equals(city)) {
				cityList.add(b.getFirst_name());
			}
		}
		System.out.println("The persons present in "+city+ " are :");
		for(String s : cityList) {
			System.out.println(s);
		}
	}

	public void addPerson() { 
		
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
			if(list.contains(book)) {
				System.out.println("Name already exists. Hence cannot be added   " );
			}
			else
				list.add(book);
			System.out.println("Do you want to enter more person? (yes/no)  ");
			answer = sc.nextLine();
		}
		System.out.println("The details after adding are :");
		for(AddressBook p : list) {
			System.out.println(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail());

		}
		
	}

	public void editContact() {
		
		System.out.println("Enter the name to edit");
		String name = sc.nextLine();
		
		System.out.println("Enter the field you want to edit : (address/city/state/zip/phone/email)");
		String field = sc.nextLine();
		System.out.println("Enter the new value");
		String new_value = sc.nextLine();
		for(AddressBook b : list) {
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
		for(AddressBook p : list) {
			System.out.println(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail());

		}
	}
	
	public void deleteContact() {
		
		Iterator<AddressBook> itr = list.iterator();
		System.out.println("Enter name of the person to be deleted");
		String del_person = sc.nextLine();
		while(itr.hasNext()) {
			AddressBook book= itr.next();
			if(book.getFirst_name().equalsIgnoreCase(del_person)) {
				itr.remove();
			}
		}
		System.out.println("The details after deleting are :");
		for(AddressBook p : list) {
			System.out.println(p.getFirst_name()+" "+ p.getLast_name()+" " + p.getAddress()+" "+ p.getCity()+" "+ p.getState()+" "+ p.getZip()+" "+ p.getPhone()+ " " +p.getEmail());

		}
	}
}


