package ui;

import model.ShoppingCart;
import model.Song;
import model.Student;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Music shopping application
public class MusicShoppingApp {

    private static final String JSON_STORE = "./data/shoppingcart.json";
    private String userName;
    private Scanner input;
    private ShoppingCart myCart = new ShoppingCart();
    private Student student;
    private boolean isStudent;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: runs the teller application
    public MusicShoppingApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runApp() {

        boolean keepGoing = true;
        String command;

        input = new Scanner(System.in);
        userInfo();

        while (keepGoing) {
            shoppingCartList();
            command = input.next();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nStart Listening Music!");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void userInfo() {
        System.out.print("Enter your name -->\t");
        userName = input.next();
        String command;

        System.out.print("Hi! " + userName + "\n\nAre u a student? (yes/no) -->\t");
        command = input.next();
        checkIsValid(command);
        System.out.println("Welcome to the Music World!!");
    }


    private void checkIsValid(String command) {
        Boolean isValid;
        if (command.equals("yes") || command.equals("no")) {
            isValid = true;
        } else {
            isValid = false;
        }
        while (!isValid) {
            System.out.println("> SORRY! This is invalid. Please try it again!\n\nAre u a student? (yes/no) -->\t");
            command = input.next();
            if (command.equals("yes") || command.equals("no")) {
                isValid = true;
                if (command.equals("yes")) {
                    student = new Student(userName);
                    isStudent = true;
                    System.out.println("Great! If u order any song, u will get a 10% off discount. Lets get start!");
                } else if (command.equals("no")) {
                    isStudent = false;
                }
            } else {
                isValid = false;
            }
        }
    }

    // EFFECTS: displays menu of options to user
    private void shoppingCartList() {
        System.out.println("===================================================================================");
        System.out.println("\nMy Shopping Cart\n");
        System.out.println("add -> Add a New Song");
        System.out.println("remove -> Remove the Song");
        System.out.println("print -> Print out my Receipt");
        System.out.println("save -> Save my cart list to file");
        System.out.println("load -> load my cart list from file");
        System.out.println("quit -> quit");
        System.out.println("\nPlease enter the action that you want to do.");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            addNewSong();
        } else if (command.equals("remove")) {
            removeSong();
        } else if (command.equals("print")) {
            printOutReceipt();
        } else if (command.equals("save")) {
            saveCartList();
        } else if (command.equals("load")) {
            loadCartList();
        } else {
            System.out.println("> SORRY! Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts an adding function
    private void addNewSong() {
        System.out.print("Please enter the name of the song that u want to add -->\t");

        String name = input.next();
        myCart.addSong(new Song(name));

        System.out.println("enter add --> Add another Song");
        System.out.println("enter menu --> Return to Menu");

        String command = input.next();
        if (command.equals("add")) {
            addNewSong();
        } else if (command.equals("menu")) {
            System.out.println("> Add Successfully");
            System.out.println("===================================================================================");
            myCartList();
        } else {
            System.out.println("> SORRY! Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts a removing function
    private void removeSong() {
        System.out.print("Please enter the name of the song that u want to remove -->\t");
        String name = input.next();

        if (myCart.getMyCartList().size() == 0) {
            System.out.println("> There is nothing in your shopping cart.");
        } else {
            boolean songExist = true;
            for (int i = 0; i < myCart.getMyCartList().size(); i++) {
                Song temp = myCart.getMyCartList().get(i);


                if (name.equals(myCart.getMyCartList().get(i).getName())) {
                    myCart.removeSong(temp);
                    System.out.println("> Remove Successfully");
                    songExist = true;
                    break;
                } else {
                    songExist = false;
                }
            }
            if (!songExist) {
                System.out.println("> SORRY! There is no such song in your shopping cart.");
            }
        }
        System.out.println("===================================================================================");
        myCartList();
    }

    // EFFECTS: print out a receipt
    private void printOutReceipt() {
        myCartList();
        System.out.println("Total Price: $" + myCart.getTotalPrice());
        if (isStudent) {
            System.out.println("With The Student Discount");
            System.out.println("Final Price: $" + myCart.getTotalPrice() * student.getDiscount());
        }
    }

    // EFFECTS: print out a cart list
    private void myCartList() {
        System.out.println("My Cart List:\n");
        for (int i = 0; i < myCart.getMyCartList().size(); i++) {
            Song temp = myCart.getMyCartList().get(i);
            System.out.println("Song " + (i + 1) + ": " + temp.toString());
        }
    }

    // EFFECTS: saves the cart list from shopping cart to file
    private void saveCartList() {
        try {
            jsonWriter.open();
            jsonWriter.write(myCart);
            jsonWriter.close();
            for (int i = 0; i < myCart.getMyCartList().size(); i++) {
                System.out.println("Saved " + myCart.getMyCartList().get(i).getName() + " to " + JSON_STORE);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }


    // MODIFIES: this
    // EFFECTS: loads songs from file
    private void loadCartList() {
        try {
            myCart = jsonReader.read();
            System.out.println("Loaded Successfully");

        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);

        }
    }
}