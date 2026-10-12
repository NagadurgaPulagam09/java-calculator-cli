import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static String divide(double a, double b) {
        if (b == 0) {
            return "Error: Division by zero";
        }
        return String.valueOf(a / b);
    }

    // Keeps asking until the user enters a valid number
    private static double readNumber(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = sc.nextDouble();
                sc.nextLine(); // clear leftover newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // discard bad input
            }
        }
    }

    // Keeps asking until the user enters one of + - * /
    private static char readOperator(Scanner sc) {
        while (true) {
            System.out.print("Enter operator (+, -, *, /): ");
            String input = sc.nextLine().trim();
            if (input.length() == 1 && "+-*/".indexOf(input.charAt(0)) != -1) {
                return input.charAt(0);
            }
            System.out.println("Invalid operator. Use +, -, * or /.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");
        double num1 = readNumber(sc, "Enter first number: ");
        char op = readOperator(sc);
        double num2 = readNumber(sc, "Enter second number: ");

        String result;
        if (op == '+') {
            result = String.valueOf(add(num1, num2));
        } else if (op == '-') {
            result = String.valueOf(subtract(num1, num2));
        } else if (op == '*') {
            result = String.valueOf(multiply(num1, num2));
        } else {
            result = divide(num1, num2);
        }

        System.out.println("Result: " + result);
        sc.close();
    }
}