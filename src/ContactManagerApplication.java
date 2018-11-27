import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ContactManagerApplication {

    public static void main( String[] args ) {
//        contactAdd(Collections.singletonList("benny: 9999999"));

        searchContact("mmmmmm");
//        contactDisplay();

    }

    public static List<String> contactList() {
        Path contactFile = Paths.get("contacts.txt");
        List<String> contacts = new ArrayList<>();
        try {
            contacts = Files.readAllLines(contactFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(contacts);
//        for(String contact : contacts ){
//            System.out.println(contact);
//        }
        return contacts;
    }

    // Display contacts method
    public static void contactDisplay() {
        List<String> contacts = new ArrayList<>(contactList());
        for(String contact : contacts) {
            System.out.println(contact);
        }
    }

    // Add contact method
    public static void contactAdd(List<String> input) {
        Path contactFile = Paths.get("contacts.txt");
        try {
            Files.write(contactFile , input , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
            }
        contactDisplay();
    }

    //remove contact
//    public static void removeContact

    // Search contacts method
    public static void searchContact(String name) {
        List<String> contacts = new ArrayList<>(contactList());

        for(String contact : contacts) {
            if (contact.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(contact);
            } else {
                System.out.println("Sorry this contact doesn't exist.");
                break;
            }
        }

    }

}

//    try {
//            Files.write(carMakers, makers, StandardOpenOption.APPEND);
//            } catch (IOException e) {
//            e.printStackTrace();
//            }

//public static void mainMenu(){
//    System.out.println("Welcome tot he contacts manager");
//}

