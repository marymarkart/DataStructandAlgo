import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {

    public static int[] makeArray (int[] array, File file) throws FileNotFoundException
    {
        Scanner read = new Scanner(file); //create scanner for file
        int i = 0; //create index
        while (read.hasNext()) //while the file has a next value
        {
            array[i] = read.nextInt(); //insert element from the file into current index
            ++i; //update index
        }
        return array; //return the populated array

    }
    public static int[] makeArray (int[] array, File file1, File file2) throws FileNotFoundException
    {
        Scanner read = new Scanner(file1); //create scanner for file
        int i = 0; //create index
        while (read.hasNext()){ //while file1 has next value
            array[i] = read.nextInt(); //insert elem from the file into current index
            ++i; //update index
        }
        Scanner read2 = new Scanner(file2); //create scanner for file2
        while (read2.hasNext()){ //while file2 has next value
            array[i] = read2.nextInt(); //insert elem from file2 at current index
            ++i; //update index
        }
        return array;

    }
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("src/resources/arr1.txt"); //first array file
        File file2 = new File("src/resources/arr2.txt"); //second array file
        int [] arr1 = new int [50]; //create new array for arr1
        int [] arr2 = new int[50];  // create new array for arr2
        int [] arr3 = new int[100]; // create new array for arr3
        makeArray(arr1, file1);        //make arr1 with values from arr1.txt
        makeArray(arr2, file2);        //make arr2 with values from arr2.txt
        makeArray(arr3, file1 ,file2); //make arr3 with values from arr1.txt and arr2.txt

        bubbleSort(arr1, arr1.length);    //call bubbleSort
        selectionSort(arr2, arr2.length); //call selectionSort
        insertionSort(arr3, arr3.length); //call insertionSort

        System.out.println("Bubble Sort:");    //Print Bubble Sort
        printArray(arr1);

        System.out.println("Selection Sort:"); //Print Selection Sort Array
        printArray(arr2);

        System.out.println("Insertion Sort:"); //Print Insertion Sort Array
        printArray(arr3);

    }

    public static void printArray(int[] arr) { //Print the array
        System.out.print("[");
        for (int i = 0; i < arr.length; ++i)
        {
            System.out.print(arr[i] );
            if (i < arr.length-1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Insertion sorting method
     * @param c the array to be sorted
     * @param n the length of the array to be sorted
     */
    public static void insertionSort(int[] c, int n)
    {
        for (int i = 1; i < n; ++i) //start the index at the second elem of the array
        {
            int next = c[i]; //item to be inserted
            int j; //initialize a value j
            for (j = i-1; j >= 0 && c[j]>next; j--) //for the index j if it is le
            {
                c[j+1] = c[j]; //shift sort items to make place for 'next'
            }
            c[j+1] = next; //insert next to the correct location

            for (int k = 0; k < c.length; k++){
                System.out.print(c[k] + ", ");
            }
            System.out.println();
        }
    }

    /**
     * Selection sorting method
     * @param b the array to be sorted
     * @param n the length of the array to be sorted
     */
    public static void selectionSort(int[] b, int n)
    {
        for (int i = n-1; i >= 1; i--) //start at the largest value of the array
        {
            int maxIndex = i; //initialize i as the largest value
            for (int j = 0; j < i; j++) //start index j from 0
            {
                if (b[j] >= b[maxIndex])
                {
                    maxIndex = j; //if b[j] >= b[maxIndex] update maxIndex to be j
                    int temp = b[i]; //hold the value that was previously the maximum value
                    b[i] = b[maxIndex]; //update the largest index to be the maximum value
                    b[maxIndex] = temp; //return the previous maximum value back to the array to be sorted
                }
            }
        }
    }

    /**
     * Bubble sorting method
     * @param a the array to be sorted
     * @param n the length of the array to be sorted
     */
    public static void bubbleSort(int[] a, int n)
    {
        for(int i = n-1; i >= 1; i--) // start with the maximum index in the array
        {
            for (int j = 1; j <= i; j++) //initialize j to be the second index
            {
                if (a[j-1] > a[j]) //check if a[j-1] is larger than a[j]
                {
                    int temp = a[j]; // store smaller value in a temp location
                    a[j] = a[j-1];   // store the larger value in the higher index
                    a[j-1]= temp;    // store the smaller value in the lower index
                }
            }
        }
    }
}


