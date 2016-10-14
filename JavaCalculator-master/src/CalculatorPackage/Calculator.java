package CalculatorPackage;

/**
 * Created by matthewsturgill on 10/11/16.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Calculator {
    Scanner userCalcInput = new Scanner(System.in);
    double num1;
    double num2;
    String algebra;
    double calctotal;
    double calctotalplusbill;
    int serviceRate;
    double bill;
    double salesTaxAdd;
    double adjustedBill;
    static ArrayList<Double> history = new ArrayList<>();
    DecimalFormat f = new DecimalFormat("##.00");
    public Calculator() throws IOException {
    }
    void calc() throws IOException {
        Scanner userMenu = new Scanner(System.in);
        int userChoice;
        while (true) {
            System.out.println("(1) Calculator" + "\n" + "(2) Tip calculator" + "\n" + "(3) Sales tax calculator" + "\n" + "(4) History of answers" +"\n" + "(5) Delete History" + "\n" + "(6) Save history to file" + "\n" + "(7) Help" + "\n" +"(8) Exit");
            try {
                userChoice = userMenu.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Enter number");
                calc();
                return;
            }
            switch (userChoice) {
                case 1:
                    calcWork();
                    break;

                case 2:
                    tipCalc();
                    break;

                case 3:
                    salesTax();
                    break;

                case 4:
                    showHistory();
                    break;

                case 5:
                    deleteHistory();
                    break;

                case 6:
                    outFile.println(history);
                        outFile.close();
                    break;

                case 7:
                    showHelp();
                    break;

                case 8:
                    System.out.println("Thank you");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a correct menu option");
                    calc();
            }


        }
    }

    //Below is method for calculator.

    String fileName = "calcHistory.txt";
    PrintWriter outFile = new PrintWriter(new FileWriter(fileName),false);


    public void calcWork() {
        System.out.println("First number?");
        num1 = userCalcInput.nextDouble();
        System.out.println("Second number?");
        num2 = userCalcInput.nextDouble();


        System.out.println("Choose +, -, *, or /");

        algebra = userCalcInput.next();
        switch (algebra) {
            case "+":
                calctotal = (num1 + num2);
                System.out.println(f.format(calctotal));
                history.add(calctotal);
                break;
            case "-":
                calctotal = num1 - num2;
                System.out.println(f.format(calctotal));
                history.add(calctotal);
                break;
            case "*":
                calctotal = num1 * num2;
                System.out.println(f.format(calctotal));
                history.add(calctotal);
                break;
            case "/":
                calctotal = num1 / num2;
                System.out.println(f.format(calctotal));
                history.add(calctotal);
                break;
            default:
                System.out.println("You did something wrong, try again");
                break;

        }
    }

    //Below is method for tip calculator.
    public void tipCalc() {
        System.out.print("Amount of your bill?");
        bill = userCalcInput.nextDouble();
        System.out.print("Rate your service on a scale of 1-5. 5 being the best. 1 being the worst");
        serviceRate = userCalcInput.nextInt();
        switch (serviceRate) {
            case 1:
                calctotal = (bill * 0.05) * 100 / 100;
                calctotalplusbill = calctotal + bill;
                System.out.println("Leave $" + (f.format(calctotal)) + "\n" + "For a total of: $" + (f.format(calctotalplusbill)));
                history.add(calctotal);
                break;
            case 2:
                calctotal = (bill * 0.10) * 100 / 100;
                calctotalplusbill = calctotal + bill;
                System.out.println("Leave $" + (f.format(calctotal)) + "\n" + "For a total of: $" + (f.format(calctotalplusbill)));
                history.add(calctotal);
                break;
            case 3:
                calctotal = (bill * 0.15) * 100 / 100;
                calctotalplusbill = calctotal + bill;
                System.out.println("Leave $" + (f.format(calctotal)) + "\n" + "For a total of: $" + (f.format(calctotalplusbill)));
                history.add(calctotal);
                break;
            case 4:
                calctotal = (bill * 0.20) * 100 / 100;
                calctotalplusbill = calctotal + bill;
                System.out.println("Leave $" + (f.format(calctotal)) + "\n" + "For a total of: $" + (f.format(calctotalplusbill)));
                history.add(calctotal);
                break;
            case 5:
                calctotal = (bill * 0.25) * 100 / 100;
                calctotalplusbill = calctotal + bill;
                System.out.println("Leave $" + (f.format(calctotal)) + "\n" + "For a total of: $" + (f.format(calctotalplusbill)));
                history.add(calctotal);
                break;
            default:
                System.out.print("Sorry you did something wrong. Try again.");
        }
    }
    //Below is method for sales tax.
    public void salesTax() {
        System.out.print("What is your grocery total?");
        bill = userCalcInput.nextDouble();
        System.out.print("Input your state sales tax. Example 6 for Kentucky.");
        salesTaxAdd = userCalcInput.nextDouble();
        adjustedBill = (bill * (salesTaxAdd * 0.01));
        System.out.println("Your added sales tax will be: $" + f.format(bill * (salesTaxAdd * 0.01)) + "\n" + "For a total of: $" + f.format(bill + (bill * (salesTaxAdd * 0.01))));
        history.add(adjustedBill);
    }
    public void showHistory() {
        System.out.println(history);
    }
    public void showHelp() {
        System.out.println("* Please choose a menu item 1-4" + "\n" + "* Input your numbers or bill total" + "\n" + "* Choose +, -, *, or / in calculator" + "\n" + "* Rate your service 1,2,3,4,5 in tip calculator" + "\n" + "* Sales tax calculator input your sales tax as follows. KY sales tax is 6% so I would input 6" + "\n" + "* Choose 3 to see all previous equations performed or choose 5 to remove all history");
    }
    public void deleteHistory() {
        history.clear();
        System.out.println("History of answers deleted");
    }
}







