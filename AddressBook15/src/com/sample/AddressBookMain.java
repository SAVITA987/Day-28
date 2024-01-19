package com.sample;

	public class AddressBookMain {
	    public static void main(String[] args) {
	        AddressBook addressBook = new AddressBook();

	        // Adding some sample contacts
	        addressBook.addContact(new Contact("Savita", "Tekale", "123 Main St", "Nanded", "Maharastra", "12345", "123-456-7890", "savita@gmail.com"));
	        addressBook.addContact(new Contact("Yogesh", "Gunde", "456 Oak St", "Pune", "State2", "67890", "987-654-3210", "yogesh@gmail.com"));

	        // Save to CSV
	        addressBook.saveToCSV("address_book.csv");

	        // Read from CSV
	        AddressBook newAddressBook = new AddressBook();
	        newAddressBook.readFromCSV("address_book.csv");

	        // Save to JSON
	        addressBook.saveToJSON("address_book.json");

	        // Read from JSON
	        AddressBook anotherAddressBook = new AddressBook();
	        anotherAddressBook.readFromJSON("address_book.json");
	    }
	}


