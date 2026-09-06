import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci{

    static BigInteger fibIterative(int n) {

        if (n <= 1)
            return BigInteger.valueOf(n);

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        return b;
    }

    static BigInteger fibRecursive(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);
        else
            return fibRecursive(n - 1).add(fibRecursive(n - 2));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the nth term of fibonacci series: ");
        int n = sc.nextInt();

        System.out.println("Result (Iterative): " + fibIterative(n));
        System.out.println("Result (Recursive): " + fibRecursive(n));
        sc.close();
    }
}
