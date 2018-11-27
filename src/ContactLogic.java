import java.util.Collections;
import java.util.Scanner;
// Give the user a list of options for viewing all the movies or viewing movies by category.
//Use your Input class to get input from the user, and display information based on their choice. (Remember to import your Input class)
//If a category is selected, only movies from that category should be displayed.
//Your application should continue to run until the user chooses to exit.
//Sample Output********
//What would you like to do?
//
//0 - exit
//1 - view all movies
//2 - view movies in the animated category
//3 - view movies in the drama category
//4 - view movies in the horror category
//5 - view movies in the scifi category
//
//Enter your choice: 1
//Frankenstein -- horror
//Goodfellas -- drama
//Pulp Fiction -- drama
//...

public class ContactLogic extends ContactManagerApplication{

    public static void askUser(){
        Input input = new Input(new Scanner(System.in));
//        Movie[] allMovies = MoviesArray.findAll();
        String message;
        message = "Welcome to the Contacts Manager!\n";
        message += "1 - View contacts\n";
        message += "2 - Add a new contact.\n";
        message += "3 - Search a contact by name.\n";
        message += "4 - Delete an existing contact.\n";
        message += "5 - Exit.\n";

    System.out.println(message);
    System.out.println("Enter an option (1, 2, 3, 4 or 5): ");
        int userAnswer = input.getInt(0, 5);

        if (userAnswer == 1) {
            contactDisplay();
             tryAgain();
        } else if (userAnswer == 2) {
            System.out.println("----------\nPlease type a name and a number to add new contact\n----------");
            String userInput = input.getString();
            System.out.println("-------");
            contactAdd(Collections.singletonList(userInput));
            System.out.println("-------");

            tryAgain();
        } else if (userAnswer == 3) {
            System.out.println("----------\nPlease type a contact name to search\n----------");
            String userInput = input.getString();
            searchContact(userInput);
            tryAgain();
        } else if (userAnswer == 4) {
            System.out.println("----------\nPlease type a name to delete from contacts\n----------");
            String userInput = input.getString();
            removeContact(userInput);
            tryAgain();
        } else if (userAnswer == 5) {
            endGame();
        }
    }

    // method for asking user to try again
    public static void tryAgain() {
        Input input = new Input(new Scanner(System.in));
        System.out.println("Do you want to choose another option? [ yes/no ]");
        String more = input.getString();
        if (more.equalsIgnoreCase("yes")) {
            askUser();
        } else {
            endGame();
        }
    }

    // method for ending game printout
    public static void endGame(){
        System.out.println("" +
                "######## ##     ##    ###    ##    ## ##    ##  ######     ########  #######  ########  \n" +
                "   ##    ##     ##   ## ##   ###   ## ##   ##  ##    ##    ##       ##     ## ##     ## \n" +
                "   ##    ##     ##  ##   ##  ####  ## ##  ##   ##          ##       ##     ## ##     ## \n" +
                "   ##    ######### ##     ## ## ## ## #####     ######     ######   ##     ## ########  \n" +
                "   ##    ##     ## ######### ##  #### ##  ##         ##    ##       ##     ## ##   ##   \n" +
                "   ##    ##     ## ##     ## ##   ### ##   ##  ##    ##    ##       ##     ## ##    ##  \n" +
                "   ##    ##     ## ##     ## ##    ## ##    ##  ######     ##        #######  ##     ## \n\n" +
                "########  ##          ###    ##    ## #### ##    ##  ######   #### \n" +
                "##     ## ##         ## ##    ##  ##   ##  ###   ## ##    ##  #### \n" +
                "##     ## ##        ##   ##    ####    ##  ####  ## ##        #### \n" +
                "########  ##       ##     ##    ##     ##  ## ## ## ##   ####  ##  \n" +
                "##        ##       #########    ##     ##  ##  #### ##    ##       \n" +
                "##        ##       ##     ##    ##     ##  ##   ### ##    ##  #### \n" +
                "##        ######## ##     ##    ##    #### ##    ##  ######   #### ");


    }
}
