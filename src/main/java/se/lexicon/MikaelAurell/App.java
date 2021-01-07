package se.lexicon.MikaelAurell;

import se.lexicon.MikaelAurell.Calc.Calculate;
import se.lexicon.MikaelAurell.Calc.CalculateImplementation;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("-----Welcome to My Calculator-----");

        boolean finish = false;
        //Scanner scannerTemp = new Scanner(System.in);
        String numberCheck;

        Calculate interfaceImp = new CalculateImplementation();

        while (!finish) {

            //Checks if there is only digits at input1
            do {
                System.out.print("Enter Number1: ");
                numberCheck = Calculate.TakeInput(); //Scanner from interface
            }
            while (!numberCheckFunction(numberCheck));

            //Input1 is ok and is saved in number1

            double number1 = Double.parseDouble(numberCheck);

            //Checks if there is only digits at input2
            do {
                //Scanner scannerTemp = new Scanner(System.in);
                System.out.print("Enter Number2: ");
                numberCheck = Calculate.TakeInput(); //Scanner from interface
            }
            while (!numberCheckFunction(numberCheck));

            //Input2 is ok and is saved in number2
            //Scanner scanner2 = new Scanner(System.in);
            double number2 = Double.parseDouble(numberCheck);


            boolean divideByZero = false;
            double result = 0;

            Scanner scannerOperator = new Scanner(System.in);
            System.out.print("Enter Operator: +, -, * or /: ");
            String myChar = scannerOperator.nextLine();

            switch (myChar) {
                case "+":
                    result = interfaceImp.addition(number1, number2);
                    break;

                case "-":
                    result = interfaceImp.subtraction(number1, number2);
                    break;
                case "*":
                    result = interfaceImp.multiplication(number1, number2);
                    break;
                case "/":
                    if (number2 != 0) {
                        result = interfaceImp.division(number1, number2);
                    } else {
                        divideByZero = true;
                        System.out.println("Divide by zero not allowed!");
                    }
                    break;

                default:
                    System.out.println(myChar + "is not supported");
            }

            if (!divideByZero) {
                System.out.println("The result are: " + (String.format("%.0g", result)));
            }

            Scanner scannerFinish = new Scanner(System.in);
            System.out.print("Would you like to calculate again? (Y/N) ");
            String inputFinish = scannerFinish.nextLine();
            String inputFinishUpper = inputFinish.toUpperCase();

            if (inputFinishUpper.equals("N")) {
                finish = true;
            }
        }
        System.out.println();
        System.out.println("Thank you for using my Calculator!");
    }

    public static boolean numberCheckFunction(String numberCheck) {
        for (int i = 0; i < (numberCheck.length()); i++) {
            if (!((numberCheck.charAt(i) >= '0') && (numberCheck.charAt(i) <= '9'))) {
                return false;
            }
        }
        return true;
    }


}
