import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort_Mary_Markart_14611 {

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File ("src/MyList.txt"); //add MyList.txt file to src folder
        int ARRAY_SIZE = 70; //initial array size of MyList
        int[] arr = new int[ARRAY_SIZE]; //create new array

        makeArray(arr, file); //populate array with values from MyList

        mergeSort(arr, 0, arr.length-1); //call mergeSort to sort the array

        printArray(arr); //print the array
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

    /**
     * make the array from scanning a file
     * @param array the array to be filled
     * @param file the file to be read
     * @return return the created array
     * @throws FileNotFoundException
     */
    public static int[] makeArray (int[] array, File file) throws FileNotFoundException
    {
        Scanner read = new Scanner(file); //create scanner for file
        int i = 0; //create index
        while (read.hasNext()){ //while file has next value
            array[i] = read.nextInt(); //insert elem from the file into current index
            ++i; //update index
        }
        return array;
    }

    /**
     * Recursively divides up the array and calls merge to bring them back together
     * @param a array to be sorted
     * @param low the index of the first value of the array
     * @param high the index of the last value of the array
     */
    public static void mergeSort(int a[], int low, int high){
        if (low < high){ //base case of recursion
            int mid = (low+high)/2; //created midpoint

            mergeSort(a, low, mid); //mergeSort with lower portion of the array
            mergeSort(a, mid+1, high); //mergeSort with the upper portion of the array

            merge(a, low, mid, high);//merge
        }
    }

    /**
     * Merges the arrays together
     * @param a the array to be merged
     * @param low the lowest index of the array
     * @param mid the middle index of the array
     * @param high the highest index of the array
     */
    private static void merge(int[] a, int low, int mid, int high) {
        int n = high - low + 1; //create int for array size
        int b[] = new int[n]; //create new array to hold sorted values

        int left = low, right = mid+1, bIdx = 0; //create variables for sorting

        while (left <= mid && right <= high){ //while the left index <= mid index & mid+1<=high
            if (a[left] <= a[right]){ //if the value at index left is <= the value at index right
                b[bIdx++] = a[left++];   //place the value at index left in current b index and then increment both
            }
            else
                b[bIdx++] = a[right++]; //place the value at index right in current b index and then increment both
        }
        while (left <= mid) b[bIdx++] = a[left++];   // fill the rest of the array with the left values
        while (right <= high) b[bIdx++] = a[right++];//fill the rest of the array with the right values

        for (int k = 0; k < n; k++){
            a[low+k] = b[k]; //take values from the created array and place them back into the original array
        }
    }
}
