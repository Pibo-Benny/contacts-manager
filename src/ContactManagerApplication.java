import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactManagerApplication {

    public static void main( String[] args ) {
        contactRead();
        contactAdd();
    }

    public static List<String> contactRead() {
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

    public static void contactAdd() {
        Path contactFile = Paths.get("contacts.txt");
        List<String> contacts = new ArrayList<>(contactRead());
        for(String contact : contacts ) {
            System.out.println(contact);
        }
        contacts += input;

        }
    }



