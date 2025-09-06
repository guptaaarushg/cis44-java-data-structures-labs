import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result_displayed = 0;
        double current_number = 0;
        String op = "";

        System.out.println("Basic Calculator");
        System.out.println("Enter numbers or operators (+, -, *, /, =). Type 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            String user_input = scanner.nextLine();

            if (user_input.equalsIgnoreCase("exit")) {
                break;
            }

            if (user_input.equals("+") || user_input.equals("-") || user_input.equals("*") || user_input.equals("/") || user_input.equals("=")) {
                if (op.equals("+")) result_displayed += current_number;
                else if (op.equals("-")) result_displayed -= current_number;
                else if (op.equals("*")) result_displayed *= current_number;
                else if (op.equals("/")) {
                    if (current_number != 0) result_displayed /= current_number;
                    else System.out.println("Error: Division by zero");
                } else if (op.equals("")) result_displayed = current_number;

                if (!user_input.equals("=")) op = user_input;
                else op = "";

                System.out.println("Screen: " + result_displayed);
            } else {
                current_number = Double.parseDouble(user_input);
                if (op.equals("")) result_displayed = current_number;
                System.out.println("Screen: " + current_number);
            }
        }

        System.out.println("Calculator closed.");
        scanner.close();
    }
}
