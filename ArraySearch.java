import java.util.Random;
import java.util.Scanner;

public class PartTwo {

    public static void main(String[] args) {
        int [] array = new int[10]; //initialize array
        createArray(array); //create an array with 10 random values

        PartOne.selectionSort(array, array.length); //use the Selection sort method from PartOne
        Scanner search = new Scanner(System.in); //initialize scanner for input
        System.out.println("What number would you like to search for?: "); //prompt user to enter a number
        int s = search.nextInt(); //create variable for user input
        binarySearch(array, 0, array.length, s); //search the randomized array for the integer the user wants to search for
        PartOne.printArray(array);

    }

    /**
     * Create random array with max value 100
     * @param array the array to be populated
     */
    private static void createArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            Random random = new Random();
            array[i] =  random.nextInt(100);
        }
    }

    /**
     * Binary search of a sorted array
     * @param array the array to be searched
     * @param start the starting index of the array
     * @param end array.legth
     * @param n the value to be searched for
     */
    private static void binarySearch(int[] array, int start, int end, int n) {
        int mid = (start + end)/2; //calculate the midpoint in the array
        while (start <= end)
        {
            if (array[mid] < n)
            {
                start = mid + 1; // if array[mid] is less than n, change the starting index to mid + 1
            }
            else if (array[mid] == n) // if array[mid] is equal to n, print statement
            {
                System.out.println("The number " + n + " can be found at index " + mid);
                return; // return to call
            }
            else {
                end = mid - 1; // if array[mid] is > n, change ending index to mid - 1
            }
            mid = (start + end)/2; // create new mid from new start/end index
        }
        System.out.println("Your searched number is not found"); //print if n is not found
    }
}
