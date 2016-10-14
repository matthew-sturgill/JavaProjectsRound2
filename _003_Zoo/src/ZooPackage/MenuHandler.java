package ZooPackage;

/**
 * Created by matthewsturgill on 10/13/16.
 */

import java.io.IOException;
import java.util.InputMismatchException;
import  java.util.Scanner;
public class MenuHandler {


    public MenuHandler() {
    }
    Scanner userInput = new Scanner (System.in);
    int userChoice;

    public void zooMenu() throws IOException {

        while (true) {
            System.out.println("Welcome to our Zoo please choose:" + "\n" + "(1) For Employee Menu" + "\n" + "(2) For visitor Menu" + "\n" + "(3) Exit Program");
            try {
                userChoice = userInput.nextInt();
            } catch (InputMismatchException a) {
                System.out.println("Must be a visitor if you're breaking stuff so:");
                VisitorMenu vM1 = new VisitorMenu();
                vM1.visitorMenu();
                return;
            }
            switch (userChoice) {
                case 1:
                    EmployeeMenu eM1 = new EmployeeMenu();
                    eM1.employeeMenuMethod();
                    break;
                case 2:
                    VisitorMenu vM1 = new VisitorMenu();
                    vM1.visitorMenu();
                    break;
                case 3:
                    System.out.println("Thank you for visiting the zoo and not jumping in the gorilla enclosure.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a number");
                    break;
            }
        }
    }
}
