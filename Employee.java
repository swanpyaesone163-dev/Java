import java.util.Scanner;

public class Employee{

    public static void main(String[] args){
        int age = 0;
        String name = "";
        double salary = 0;
        String KPI = "0";
        boolean leaveTaken = false;

        System.out.println("Hello Employee! Please enter your information!");
        System.out.println("First, your name: ");

        Scanner sc = new Scanner(System.in); //Scanner -> name of the class, sc -> reference variables that points to the object in the memory, 
                                             //new Scanner(...) -> calls the constructor (this one is parameterized), 
                                             // System.in -> argument of the constructor to create an object specified by the constructor

        name = sc.nextLine();
        
        System.out.println("Next, your age: ");
        age = sc.nextInt();

        System.out.println("Your salary: ");
        salary = sc.nextDouble();

        System.out.println("Leave taken? Y/N: ");
        String leave = sc.next();
        if(leave.equalsIgnoreCase("Y")){
            KPI = "0";
            leaveTaken = true;
        }
        else{
            KPI = "10";
            leaveTaken = false;
        }

        System.out.println("+--------------------------------+");
        System.out.println("           Thank you!             ");
        System.out.println("     Your Employee Information    ");
        System.out.println("+--------------------------------+");
        System.out.println("   Your name        : " + name);
        System.out.println("   Your age         : " + age);
        System.out.println("   Your salary      : " + salary);
        System.out.println("   Your Leave Status: " + leaveTaken);
        System.out.println("   Your KPI         : " + KPI);
        System.out.println("+--------------------------------+");

        sc.close();
    }
}