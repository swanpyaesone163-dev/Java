import java.util.Scanner;

public class Linear{

    public static boolean LinearSearch(int[] n, int key){
        
        for(int i = 0; i < n.length; i++){
            if(n[i] == key){
                return true;
            }
        }

        return  false;
    }

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("The array is :");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }

        System.out.println("Enter the key you want to search: ");
        int key = sc.nextInt();

        if(LinearSearch(arr, key)){
            System.out.println("Element found in the array! Hooray!");
        }
        else{
            System.out.println("Element not found, unfortunately :(");
        }
        sc.close();
    }
}