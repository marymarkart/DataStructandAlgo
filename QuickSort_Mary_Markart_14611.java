import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort_Mary_Markart_14611 {
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File ("src/MyList.txt");
        int ARRAY_SIZE = 70; //initial array size of MyList
        int[] arr = new int[ARRAY_SIZE]; //create new array

        makeArray(arr, file); //populate array with values from MyList

        quickSort(arr, 0, arr.length-1); //use quickSort to sort the array

        printArray(arr);
    }

    public static void printArray(int a[]){
        System.out.print("[");
        for (int i = 0; i < a.length; ++i){
            System.out.print(a[i]);
            if (i < a.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    public static int[] makeArray (int[] array, File file) throws FileNotFoundException
    {
        Scanner read = new Scanner(file); //create scanner for file
        int i = 0; //create index
        while (read.hasNext()){ //while file1 has next value
            array[i] = read.nextInt(); //insert elem from the file into current index
            ++i; //update index
        }
        return array;
    }

    /**
     * Sort the array using partitions
     * @param a the array to be sorted
     * @param i the lowest index of the array
     * @param j the highest index of the array
     * @return return the index of the pivot value
     */
    public static int partition(int a[], int i, int j){
        int p = a[i]; //create pivot value
        int m = i; //create index m at the beginning of the array

        for (int k = i + 1; k <= j; k++){ //create a k index that starts at i + 1
            if (a[k] < p){ //if the value at index k is less than the pivot
                m++; //increment m
                int temp = a[k]; // create temp value for value that is < the pivot
                a[k] = a[m];   //swap the value at index k with the value at index m
                a[m]= temp;    //store previous a[k] value at index m
            }
        }
        int temp2 = a[i]; //create temp value for pivot
        a[i] = a[m]; //switch a[m] with the 1st spot in the array
        a[m] = temp2; //store pivot in a[m]
        return m; //return index of pivot
    }

    /**
     * Recursively call partion and then divide up the arrays
     * @param a the array to be sorted
     * @param low the first index of the array
     * @param high the last index of the array
     */
    static void quickSort(int a[], int low, int high){
        if (low < high){
            int pivotIndex = partition(a, low, high); //call partition to sort the array

            quickSort(a, low, pivotIndex -1); //sort the array that is smaller than the pivot value
            quickSort(a, pivotIndex + 1, high); //sort the array that is larger than the pivot value
        }
    }


}
