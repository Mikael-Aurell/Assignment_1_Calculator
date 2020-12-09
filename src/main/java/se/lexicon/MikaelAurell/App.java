package se.lexicon.MikaelAurell;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        boolean finish = false;

        while (!finish) {


            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Enter Number1: ");
            double number1 = scanner1.nextDouble();

            Scanner scanner2 = new Scanner(System.in);
            System.out.print("Enter Number2: ");
            double number2 = scanner2.nextDouble();

            double result = 0;

            Scanner scannerOperator = new Scanner(System.in);
            System.out.print("Enter Operator: +, -, * or /: ");
            String myChar = scannerOperator.nextLine();

            switch (myChar) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                        break;
                    } else {
                        System.out.println("Devide by zero not allowed!");
                        break;
                    }

                default:
                    System.out.println(myChar + "is not supported");
            }
            System.out.println(result);

            Scanner scannerFinish = new Scanner(System.in);
            System.out.print("Would you like to calculate again? (Y/N) ");
            String inputFinish = scannerFinish.nextLine();
            String inputFinishUpper = inputFinish.toUpperCase();

            if ( inputFinishUpper.equals("N")){
                finish = true;
            }
        }
    }
}
