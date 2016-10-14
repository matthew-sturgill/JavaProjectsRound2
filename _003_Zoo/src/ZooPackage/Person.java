package ZooPackage;

/**
 * Created by matthewsturgill on 10/13/16.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    Scanner userinput = new Scanner(System.in);
    int numberChoice;
    public String name;
    public int age;
    public String visitorEmail;
    public int employeeNumber;

    public void personMenu() throws IOException {
            System.out.println("(1) Add employee" + "\n" + "(2) Add visitor" + "\n" + "(3) Return to main");
            numberChoice = userinput.nextInt();
            switch (numberChoice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                    addVisitor();
                    break;
                case 3:
                    EmployeeMenu eM = new EmployeeMenu();
                    eM.employeeFirstSetOfOptions();
                    break;
                default:
                    System.out.println("Please choose a correct option");
            }
    }
    public void addEmployee() {
        System.out.println("Name?");
        name = userinput.next();
        System.out.println("Employee number");
        employeeNumber = userinput.nextInt();
        Zoo z1 = new Zoo();
        z1.employeeList.add("Name : " + name + "  Employee number: " + employeeNumber);
    }
        public void addVisitor(){
        System.out.println("Name?");
        name = userinput.next();
        System.out.println("Email?");
        visitorEmail = userinput.next();
            System.out.println("Age?");
        age = userinput.nextInt();
            Zoo z2 = new Zoo();
        z2.visitorList.add("Name : " + name + "  Age: " + age + "\n" + "  Email: " + visitorEmail );
    }
}
