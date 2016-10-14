package ZooPackage;

/**
 * Created by matthewsturgill on 10/13/16.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Animal {
    String animal;
    String gender;
    String location;
    Scanner userInput = new Scanner(System.in);
    public void addAnimal(){
        System.out.println("Animal?");
        animal = userInput.nextLine();
        System.out.println("Gender?");
        gender = userInput.nextLine();
        System.out.println("Location in zoo?");
        location = userInput.nextLine();
        Zoo z3 = new Zoo();
        z3.animalList.add("Animal: " + animal + "  Gender: " + gender + "  Location: " + location);
    }
}

