import java.util.Scanner;

public class ArrayInsertion{

    public static boolean itIsFull(int[] arr,int count){
        if(arr.length == count){
            return true;
        }
        else{
            return false;
        }
    }

    public static void arrayInsertion(int[] arr, int key, int count){
        for(int i = count - 1; i >= 0; i--){
            arr[i+1] =  arr[i];
        }
        arr[0] = key;
        System.out.println("Element inserted at the front!");
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        System.out.print("How many initial elements do you want to insert?: ");
        int no = sc.nextInt();

        int count = 0;

        System.out.println("Enter the elements of the initial array: ");
        for(int i = 0; i < no; i++){
            arr[i] = sc.nextInt();
            count++;
        }

        System.out.println("The array is :");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        
        while (true) {
            System.out.println("Enter the element to insert at the front: ");
            int key = sc.nextInt();

            if(itIsFull(arr, count)){
                System.out.println("Array is full! Can't Insert");
                return;
            }
            else{
                arrayInsertion(arr, key, count);
                count++;
            }
            
            System.out.println("The final array is :");
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println(" ");

            System.out.println("Quit? Y/N: ");
            String quit = sc.next();

            if(quit.equalsIgnoreCase("Y")){
                break;
            }
            else{
                continue;
            }
        }
        sc.close();
        return;
    }
}
