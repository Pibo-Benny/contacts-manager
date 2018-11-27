import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import java.util.List;



public class ContactManagerApplication {

    public static void main( String[] args ) {

        ContactLogic.askUser();

    } // end of min method







    // Create contact list
    public static List<String> contactList() {
        Path contactFile = Paths.get("contacts.txt");
        List<String> contacts = new ArrayList<>();
        try {
            contacts = Files.readAllLines(contactFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    } // end of contactList method

    // Display contacts method
    public static void contactDisplay() {
        List<String> contacts = new ArrayList<>(contactList());
        for(String contact : contacts) {
            System.out.println(contact);
        }
    } // end of contactDisplay method

    // Add contact method
    public static void contactAdd(List<String> input) {

        Path contactFile = Paths.get("contacts.txt");
        try {
            Files.write(contactFile , input , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            }
        contactDisplay();
    } // end of contactAdd method

    //remove contact
    public static void removeContact(String name){
        Path contactFile = Paths.get("contacts.txt");
        List<String> contacts = new ArrayList<>(contactList());

            for (String contact : contacts) {

              if (contact.toLowerCase().contains(name.toLowerCase())) {
                    contacts.remove(contact);
              }
            }
                    try {
                        Files.write(contactFile, contacts);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            contactDisplay();

        }
     // end of removeContact method

    // Search contacts method
    public static void searchContact(String name) {
        List<String> contacts = new ArrayList<>(contactList());

        for(String contact : contacts) {
            if (contact.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(contact);
            }
        }
    } // end of searchContact method


} // end of ContactManagerApplication class



