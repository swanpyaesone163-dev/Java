import java.util.*;

public class ExceptionHandling{

    public static void main(String[] args) {
        int[] array = new int[10];
        
        System.out.println("Enter the elements of the array: ");
        Scanner sc = new Scanner(System.in);
        
        int retries = 0;
        int max_retries = 3;

        while(retries < max_retries){
            try{
                for(int i = 0; i < 10; i++){
                    array[i] = sc.nextInt();
                }
                break;
            }
            catch(InputMismatchException I){
                if(retries == max_retries - 1){
                    System.out.println("No more retries, the remaining elements auto-filled with zeros!");

                }
                System.out.println("your input was not an integer! Please try again!");
                sc.next();
                
                retries++;
            }
        }

        System.out.println("Up to which index do you want to print?");
        int n = sc.nextInt();

        if(n >= 0 && n <= 10){
            for(int i = 0; i < n; i++){
                System.out.print(array[i] + " ");
            }
        }
        else if(n < 0){
            System.out.println("Input index is not accepted for less than 0");
        }
        else{
            for(int i = 0; i < 10; i++){
                System.out.print(array[i] + " ");
            }
            System.out.println("..end of array");
        }

        sc.close();
    }


}