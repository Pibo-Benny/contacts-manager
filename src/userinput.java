import java.util.Scanner;

public class userinput {



    private Scanner scanner;


    public userinput(){
        scanner = new Scanner(System.in);
    }

    public String getString(){
        scanner.nextLine();
        String input = scanner.nextLine();
        return input;
    }
    public int getInt(){
        int inp = scanner.nextInt();
        return inp;

    }


    boolean yesNo(){
        String answer = scanner.next();
        return (answer.equals("yes") || answer.equals("y"));
    }

    int getInteger(int min, int max) {
        int input;
        do {
            input = scanner.nextInt();
        } while (input >= min && input <= max);
        return input;

    }


    public  double getDouble(double min, double max) {
        double input;

        do {
            System.out.println("Enter double");
            input = scanner.nextDouble();
        } while (input >= min && input <= max);
        return input;

    }


}
