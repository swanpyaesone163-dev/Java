import java.util.*;

public class ExceptionHandling {

    public static void main(String[] args) {
        final int SIZE = 10;
        int[] array = new int[SIZE];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements of the array: ");

        int maxRetries = 3;
        int attempt = 0;
        int i = 0;
        while (i < SIZE && attempt < maxRetries) {
            try {
                for (; i < SIZE; i++) {
                    array[i] = sc.nextInt();
                }
            } catch (InputMismatchException e) {
                sc.next(); // discard the bad token
                attempt++;
                if (attempt == maxRetries) {
                    System.out.println("No more retries, remaining elements auto-filled with zeros!");
                } else {
                    System.out.println("Your input was not an integer! Please try again!");
                }
            }
        }

        System.out.println("Up to which index do you want to print?");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Input index is not accepted for less than 0");
        } else {
            int limit = Math.min(n, SIZE);
            for (i = 0; i < limit; i++) {
                System.out.print(array[i] + " ");
            }
            if (n > SIZE) {
                System.out.println("..end of array");
            }
        }

        sc.close();
    }
}