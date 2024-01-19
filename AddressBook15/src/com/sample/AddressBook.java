package com.sample;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

	class AddressBook {
	    List<Contact> contacts;

	    public AddressBook() {
	        this.contacts = new ArrayList<>();
	    }

	    public void addContact(Contact contact) {
	        contacts.add(contact);
	    }

	    public void saveToCSV(String fileName) {
	        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
	            for (Contact contact : contacts) {
	                String[] data = {contact.firstName, contact.lastName, contact.address, contact.city,
	                        contact.state, contact.zip, contact.phoneNumber, contact.email};
	                writer.writeNext(data);
	            }
	            System.out.println("Address Book saved to CSV: " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void readFromCSV(String fileName) {
	        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
	            String[] line;
	            while ((line = reader.readNext()) != null) {
	                Contact contact = new Contact(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
	                addContact(contact);
	            }
	            System.out.println("Address Book loaded from CSV: " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void saveToJSON(String fileName) {
	        try (Writer writer = new FileWriter(fileName)) {
	            Gson gson = new GsonBuilder().setPrettyPrinting().create();
	            gson.toJson(contacts, writer);
	            System.out.println("Address Book saved to JSON: " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void readFromJSON(String fileName) {
	        try (Reader reader = new FileReader(fileName)) {
	            Json gson = new Json();
	            Contact[] contactsArray = gson.fromJson(reader, Contact[].class);
	            contacts.clear();
	            for (Contact contact : contactsArray) {
	                addContact(contact);
	            }
	            System.out.println("Address Book loaded from JSON: " + fileName);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

