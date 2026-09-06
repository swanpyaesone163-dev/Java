import java.util.*;

public class SelectionSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        System.out.println("Enter the elements of the array: ");
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        
        selectionSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
        sc.close();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            swap(arr, min_idx, i);
        }
    }

    public static void printArray(int[] arr){
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}