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

//        searchContact("mmmmmm");
//        contactDisplay();
        removeContact("kJ");

    }




    public static List<String> contactList() {
        Path contactFile = Paths.get("contacts.txt");
        List<String> contacts = new ArrayList<>();
        try {
            contacts = Files.readAllLines(contactFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public static void removeContact(String name){
        Path contactFile = Paths.get("contacts.txt");
        List<String> contacts = new ArrayList<>(contactList());
                    try {
            for (String contact : contacts) {
                        if (!contact.toLowerCase().contains(name.toLowerCase())){
                            System.out.println("----------\nsorry we can't find this contact\n----------");
                            break;
                        }
                        if (contact.toLowerCase().contains(name.toLowerCase())) {
                            contacts.remove(contact);
                        }
                        Files.write(contactFile , contacts);
            }
            contactDisplay();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


    }

    // Search contacts method
    public static void searchContact(String name) {
        List<String> contacts = new ArrayList<>(contactList());

        for(String contact : contacts) {
            if (contact.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(contact);
            } else {
                System.out.println("---------\nsorry this contact doesn't exist\n----------");
                break;
            }
        }

    }


}



