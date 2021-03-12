import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int calcCount = 1;

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Calculation: " + calcCount++);
            int lhs, rhs;
            String operator;
            System.out.print("Enter Operation Name: ");
            operator = sc.next();
            operator = operator.toLowerCase();

            if (!isValidInput(operator)) {
                System.out.println("invalid input is provided. Please use one of the following operators:");
                System.out.println("\tadd: Addition\n\tsub: Subtraction\n\tmult: Multiplication\n\tdiv: Division");
                calcCount--;
                continue;
            }
            try {
                System.out.print("Enter the First Operand: ");
                lhs = sc.nextInt();
                System.out.print("Enter the Second Operand: ");
                rhs = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input is provided. Please check number is in range of integer.");
                continue;
            }


            Support addition = new AdditionSupport("Addition");
            Support subtraction = new SubtractionSupport("Subtraction");
            Support multiplication = new MultiplicationSupport("Multiplication");
            Support division = new DivisionSupport("Division");

            addition.setNext(subtraction).setNext(multiplication).setNext(division);

            addition.support(new CalculationSource(operator, lhs, rhs));
            System.out.println("=============================");
        }

    }

    public static boolean isValidInput(String input) {
        String[] operators = {"add", "sub", "mult", "div"};
        for (String op : operators) {
            if (input.compareTo(op) == 0) return true;
        }
        return false;
    }
}
