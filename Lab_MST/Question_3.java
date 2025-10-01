import java.util.*;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);  
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.size() == 0) {
                throw new ArithmeticException("List is empty, cannot calculate average.");
            }

            int sum = 0;
            for (int n : numbers) {
                sum += n;
            }
            double avg = (double) sum / numbers.size();
            System.out.println("Average: " + avg);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
