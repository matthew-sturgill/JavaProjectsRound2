package ZooPackage;

/**
 * Created by matthewsturgill on 10/14/16.
 */
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class VisitorMenu {
    Scanner userInput = new Scanner(System.in);
    int visitorChoice;


    public void visitorMenu() throws IOException {
        while (true) {
            System.out.println("Thank you for visiting our zoo what would you like to do?" + "\n" + "(1) Add visitor" + "\n" + "(2) View Animal list and locations" + "\n" + "(3) Exit to main");
            try {visitorChoice = userInput.nextInt();
            } catch (InputMismatchException c) {
                System.out.println("Back to main");
                MenuHandler mh1 = new MenuHandler();
                mh1.zooMenu();
                return;
            }
            switch (visitorChoice) {
                case 1:
                    Person nv1 = new Person();
                    nv1.addVisitor();
                    break;
                case 2:
                    Zoo z9 = new Zoo ();
                    System.out.println(z9.animalList);
                    break;
                case 3:
                    MenuHandler mh1 = new MenuHandler();
                    mh1.zooMenu();
                    break;
                default:
                    System.out.println("Please choose a correct option");
            }
        }
    }
}
