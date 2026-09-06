import java.util.*;
// Java program for implementation of QuickSort

class QuickSort
{
    int partition(double a[], int low, int high)
    {
        double pivot = a[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (a[j] <= pivot)
            {
                i++;

                double temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        double temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      a[] --> Array to be sorted,
      l  --> Starting index,
      h  --> Ending index */
    void sort(double a[], int l, int h)
    {
        if (l < h)
        {
            int pi = partition(a, l, h);

            // Recursively sort elements before
            // partition and after partition
            sort(a, l, pi-1);
            sort(a, pi+1, h);
        }
    }
}

public class StatCalc{
    int arraysize;
    double[] data;
    double[] rawData;

    public StatCalc(double[] rawData){
        this.rawData = rawData.clone();
        arraysize = rawData.length;
        data = rawData.clone();

        QuickSort ob = new QuickSort();
        ob.sort(data, 0, data.length - 1);
    }

    public double mean(){
        if (arraysize == 0) {
            return 0;
        }

        double sum = 0;

        for(int i = 0; i < arraysize; i++){
            sum += data[i];
        }

        return sum / arraysize;
    }

    public double median(){
        if (arraysize == 0){
            return 0.0;
        }
        else if (arraysize % 2 == 0){
            return (data[arraysize/2] + data[arraysize/2 - 1]) / 2;
        }
        else{
            return data[arraysize/2];   
        }
    }

    public double[] getData(){
        return data;
    }

    public double[] getRawData(){
        return rawData;
    }

    public double[] mode(){
        if (arraysize == 0){
            return new double[0];
        }

        Map<Double, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        for (double num : data) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        List<Double> modes = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        if(maxFrequency == 1) {
            return new double[0]; // No mode if all values are unique
        }

        double[] modeArray = new double[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            modeArray[i] = modes.get(i);
        }

        return modeArray;
    }

    public void describe(){
        System.out.println("Mean Value of the array is: " + mean());
        System.out.println("Median Value of the array is: " + median());
        System.out.println("Mode of the array is: " + Arrays.toString(mode()));
    }

    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of the array: ");
        int n = sc.nextInt();
        double[] arr = new double[n];

        System.out.println("Enter the values: ");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextDouble();
        }
        StatCalc stats = new StatCalc(arr);

        System.out.println("Raw array: " + Arrays.toString(stats.getRawData()));
        System.out.println("Sorted array: " + Arrays.toString(stats.getData()));
        stats.describe();

        
        sc.close();
    }
}
