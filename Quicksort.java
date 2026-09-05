import Java.util.*;

public class QuickSort{

    public void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = arr[left + i];
        }
        for(int i = 0; i < n2; i++){
            R[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
                k++;
            }
            else{
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        while(j < n2){
            arr[k] = R[j];
            k++;
            j++;
        }
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
    }

    public void mergeSort(int[] arr, int left,int mid, int right)
    {
        if(left < right){
            mergeSort(arr, left, mid, right);
        }
    }
    public static void main(String[] args) {
        
    }
}