package ToDoListPackage;

/**
 * Created by matthewsturgill on 10/12/16.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
public class ToDoListMethod {
    //Scanners
    Scanner input = new Scanner(System.in);
    Scanner inputToDo = new Scanner(System.in);
    //Array Lists
    ArrayList<String> highPriorityPersonal = new ArrayList<>();
    ArrayList<String> personalList = new ArrayList<>();
    ArrayList<String> groceryList = new ArrayList<>();
    ArrayList<String> highPriorityGroceryList = new ArrayList<>();
    //String variables
    String toDo;

    //Integer variables
    int delete;
    int userChoice;
    int deleteConfirm;
    String fileName = "todolist.txt";
    PrintWriter outFile = new PrintWriter(new FileWriter(fileName));

    //Main menu
    public ToDoListMethod() throws IOException {
    }

    void toDoMenu() {
        while (true) {
            System.out.println("MAIN" + "\n" + "(1) to add item" + "\n" + "(2) to list items" + "\n" + "(3) to remove previous item" + "\n" + "(4) to clear list" + "\n" + "(5) Save to file" + "\n" + "(6) to quit program" + "\n" + "(7) for help");
            try {
                userChoice = input.nextInt();
            } catch (InputMismatchException b){
                System.out.println("Please choose a number");
                input.nextLine(); // because eagle said so //
                toDoMenu();
                return;
            }
            switch (userChoice) {
                case 1:
                    addItemMethod();
                    break;
                case 2:
                    listItemMethod();
                    break;
                case 3:
                    removePreviousItemMethod();
                    break;
                case 4:
                    clearListMethod();
                    break;
                case 5:
                    outFile.println("High priority personal: " + highPriorityPersonal +"\n" + "Personal: " + personalList + "\n" + "High priority: " + highPriorityGroceryList + "\n" + "Grocery list: " + groceryList);
                    outFile.close();
                    break;
                case 6:
                    quitMethod();
                    break;
                case 7:
                    displayHelpMethod();
                    break;
                default:
                    System.out.println("You messed something up. Please try again");


            }

        }
    }

    public void addItemMethod() {
        System.out.println("(1) for personal high priority" + "\n" + "(2) for personal" + "\n" + "(3) for grocery high priority" + "\n" + "(4) for grocery" + "\n" + "(5) to exit to main menu");

        try {
            userChoice = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException b){
            System.out.println("Please choose a number");
            input.nextLine(); // because eagle said so //
            addItemMethod();
            return;
        }
        switch (userChoice) {
            case 1:
                System.out.println("Please type out item");
                toDo = input.nextLine();
                highPriorityPersonal.add(toDo);
                addAnother();
                break;
            case 2:
                System.out.println("Please type out item");
                toDo = input.nextLine();
                personalList.add(toDo);
                addAnother();
                break;
            case 3:
                System.out.println("Please type out item");
                toDo = input.nextLine();
                highPriorityGroceryList.add(toDo);
                addAnother();
                break;
            case 4:
                System.out.println("Please type out item");
                toDo = input.nextLine();
                groceryList.add(toDo);
                addAnother();
                break;
            case 5:
                toDoMenu();
                break;
            default:
                System.out.println("Please choose a correct option");
                break;
        }
    }
    public void listItemMethod() {
        System.out.println("(1) to list personal" + "\n" + "(2) to list grocery" + "\n" + "(3) to list all" + "\n" + "(4) for main menu");
        try {
            userChoice = input.nextInt();
        } catch (InputMismatchException b){
            System.out.println("Please choose a number");
            input.nextLine(); // because eagle said so //
            listItemMethod();
            return;
        }
        switch (userChoice) {
            case 1:
                System.out.println("High priority: " + highPriorityPersonal);
                System.out.println("Regular priority: " + personalList);
                break;
            case 2:
                System.out.println("High priority Grocery: " + highPriorityGroceryList);
                System.out.println("Grocery: " + groceryList);
                break;
            case 3:
                System.out.println("High priority: " + highPriorityPersonal);
                System.out.println("Regular priority: " + personalList);
                System.out.println("High priority Grocery: " + highPriorityGroceryList);
                System.out.println("Grocery: " + groceryList);
                break;
            case 4:
                toDoMenu();
                break;
            default:
                System.out.println("Please try again");
        }
    }
    //Below is iffy for removing previously added Array list item. NEEDS WORK. BReaks after choosing class to delete
    public void removePreviousItemMethod() {
        System.out.println("(1) to remove previous high priority personal" + "\n" + "(2) to remove previous personal" + "\n" +"(3) to remove previous high priority grocery item" + "\n" + "(4) to remove previous grocery item" + "\n" +"(5) to exit to main menu");
        try {
            userChoice = input.nextInt();
        } catch (InputMismatchException b){
            System.out.println("Please choose a number");
            input.nextLine(); // because eagle said so //
            removePreviousItemMethod();
            return;
        }
        switch (userChoice) {
            case 1:
                delete = highPriorityPersonal.size();
                highPriorityPersonal.remove(highPriorityPersonal.size()-1);
                break;
            case 2:
                delete = personalList.size();
                personalList.remove(personalList.size()-1);
                break;
            case 3:
                delete = highPriorityGroceryList.size();
                highPriorityGroceryList.remove(highPriorityGroceryList.size()-1);
                break;
            case 4:
                delete = groceryList.size();
                groceryList.remove(groceryList.size()-1);
                break;
            case 5:
                quitMethod();
                break;
            default:
                System.out.println("You have broke something. Try again");
        }
    }
    public void clearListMethod() {
        System.out.println("Are you sure you want to delete all list items? (1) for YES, (2) for NO and return to main menu");
        try {
            deleteConfirm = input.nextInt();
        } catch (InputMismatchException b){
            System.out.println("Please choose a number");
            input.nextLine(); // because eagle said so //
            clearListMethod();
            return;
        }
        switch (deleteConfirm) {
            case 1:
                highPriorityGroceryList.clear();
                highPriorityPersonal.clear();
                personalList.clear();
                groceryList.clear();
                break;
            case 2:
                toDoMenu();
                break;
            default:
                System.out.println("Please try again");
        }
    }
    //NEED to type out help explanation!!!!
    public void displayHelpMethod() {
        System.out.println("Choose menu item for what you want to do" + "\n" + "Choose if you want the item to be a personal to do or grocery as well as if it's high priority" + "\n" + "Can view items after they have been input");}


    public void addAnother(){
        System.out.print("Add another Item?" +"\n" + "(1) Yes" +"\n" + "(2) No and return to main");
        try {
            userChoice = input.nextInt();
        } catch (InputMismatchException b){
            System.out.println("Please choose a number");
            input.nextLine(); // because eagle said so //
            addAnother();
            return;
        }
        switch (userChoice){
            case 1:
                System.out.println("Choose which to add");
                addItemMethod();
                break;
            case 2:
                toDoMenu();
                break;
            default:
                System.out.println("Please choose a correct option");
        }
    }
    public void quitMethod() {
        System.out.println("Thanks for using this list");
        System.exit(0);
    }
}

