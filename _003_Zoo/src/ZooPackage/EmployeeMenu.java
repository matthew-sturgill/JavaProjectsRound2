package ZooPackage;

/**
 * Created by matthewsturgill on 10/13/16.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMenu {
    //Scanner
    Scanner employeeInput = new Scanner(System.in);
    int menuChoice;
    String passWordInput;
    String fileName = "zoolist.txt";
    PrintWriter outFile = new PrintWriter(new FileWriter(fileName));

    public EmployeeMenu() throws IOException {
    }


    public void employeeMenuMethod () throws IOException {
            System.out.println("Please input employee Password hint (ILOVETHISZOO) or type EXIT to return to previous");
                passWordInput = employeeInput.nextLine();
        switch (passWordInput){
            case ("ILOVETHISZOO"):
                employeeFirstSetOfOptions();
                break;
            case ("EXIT"):
                MenuHandler mh1 = new MenuHandler();
                mh1.zooMenu();
            default:
                System.out.println("Please try again");
                employeeMenuMethod();
        }
    }
    public void employeeFirstSetOfOptions() throws IOException {
        while (true) {
            System.out.println("What would you like to do?" + "\n" + "(1) Add Person at Zoo" + "\n" +"(2) Add Animal to Zoo" + "\n" + "(3) List Employees" + "\n" + "(4) List visitors" + "\n" + "(5) List animals"+ "\n" + "(6) Exit to main" + "\n" + "(7) Save lists to file");
            try {
                menuChoice = employeeInput.nextInt();
            }
            catch (InputMismatchException b) {
                System.out.println("Back to main");
                MenuHandler mh1 = new MenuHandler();
                mh1.zooMenu();
                return;
            }
            switch (menuChoice){
                case 1:
                    Person p1 = new Person();
                    p1.personMenu();
                    break;
                case 2:
                    Animal a1 = new Animal();
                    a1.addAnimal();
                    break;
                case 3:
                    Zoo z6 = new Zoo();
                    System.out.println(z6.employeeList);
                    break;
                case 4:
                    Zoo z7 = new Zoo();
                    System.out.println(z7.visitorList);
                    break;
                case 5:
                   Zoo z8 = new Zoo();
                    System.out.println(z8.animalList);
                    break;
                case 6:
                    MenuHandler mh1 = new MenuHandler();
                    mh1.zooMenu();
                    break;
                case 7:
                    Zoo z10 = new Zoo();
                    outFile.println("Employees: " + (z10.employeeList)  +"\n" + "Visitors : " + (z10.visitorList) + "\n" + "Animals: " +  (z10.animalList));
                    outFile.close();
                    break;
                default:
                    System.out.println("Please choose an option");
            }
        }
    }



}
