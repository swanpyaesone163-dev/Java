`	import java.util.Scanner;

public class Quadratic{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		double a,b,c,d,root1,root2;

		System.out.println("Enter a, b, c: ");
		
		a = sc.nextDouble(); b = sc.nextDouble(); c = sc.nextDouble();
		
		d = b * b - 4 * a * c;

		if(d>0){
			root1 = (-b + Math.sqrt(d)) / (2 * a);
			root2 = (-b - Math.sqrt(d)) / (2 * a);
			
			System.out.println("Roots are: " + root1 + " and " + root2);
		}
		else if(d == 0){
			root1 = -b / (2 * a);
			
			System.out.println("Equal root is: " + root1);
		}
		else{
			System.out.println("No real solutions");
		}
		sc.close();
	}
}