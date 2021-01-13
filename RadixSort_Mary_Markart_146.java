import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RadixSort_Mary_Markart_146 {
    public static int ARRAY_SIZE = 70; //initial array size of MyList
    public static void main(String[] args) throws FileNotFoundException {
        {
            File file = new File("src/MyList.txt");

            int [] arr = new int[ARRAY_SIZE];


            makeArray(arr, file); //populate array with values from MyList
            int max = findMaxNumber(arr);

            radixSort(arr, max);


            printArray(arr);
        }
    }

    public static int[] makeArray(int[] array, File file) throws FileNotFoundException {
        Scanner read = new Scanner(file); //create scanner for file
        int i = 0; //create index
        while (read.hasNext()) { //while file1 has next value
            array[i] = read.nextInt(); //insert elem from the file into current index
            ++i; //update index
        }
        return array;
    }

    private static int findMaxNumber(int[] arr) {
        int power = 1; //current power
        int counter = 0; //count iterations of while loop to get maxNumber
        int maxIndex = 0; //current maxIndex

        for (int i = arr.length-1; i >= 1; i--) //start at the largest value of the array
        {
            if (arr[i] >= arr[maxIndex])
            maxIndex = i; //if arr[i] >= b[maxIndex] update maxIndex to be i
        }
        while ((arr[maxIndex]%power) != arr[maxIndex]){ //the remainder should be less than int at index
            power *= 10; //increase power
            ++counter; //increment maxDigit
        }
        return counter; //return the maxDigit
    }

    public static void printArray(int a[]) {
        System.out.print("[");
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void radixSort(int v[], int maxDigits)
    {
        int i; //current index < maxDigit
        int power = 1; //base for division
        Queue [] digitQueue = new Queue[10]; //initialize Queue of Queues
        for (int queueNum = 0; queueNum < 10; queueNum++) {
            digitQueue[queueNum] = new Queue(ARRAY_SIZE); //Create a queues within the queue array digitQueue
        }


        for (i = 0; i < maxDigits; i++){
            distribute(v, digitQueue, power); //first loop to sort into sorted Queues
            collect(digitQueue, v); //second loop to bring array back together
            power *= 10; // increment base for division
        }
    }


    public static void distribute(int v[], Queue digitQ[], int power){
        int digit;
        for (int i = 0; i < v.length; i++){
            digit = (v[i]/power) %10; //divide int in queue by current power, mod base(10) for decimal num
            digitQ[digit].enqueue(v[i]); //add number from Queue v[] to Queue and index 'digit'
        }
    }

    public static void collect(Queue[] digitQ, int v[]) {
        int i = 0;
        for (int digit = 0; digit < digitQ.length ; digit++ ){
            while (!digitQ[digit].isEmpty(digitQ[digit])) // while Queue in digitQueue array is not empty
            {
                v[i] = digitQ[digit].dequeue(); //remove int from digitQueue and place in current v[] index
                i++; //increment index
            }
        }
    }

}

class Queue {
    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int capacity) //Queue constructor
    {
        this.capacity = capacity; //Queue capacity
        front = this.size = 0; //front of Queue
        rear = capacity - 1; //back of Queue
        array = new int[this.capacity]; //int array
    }

    // Queue is full when size becomes
    // equal to the capacity
    boolean isFull(Queue queue)
    {
        return (queue.size == queue.capacity); //return true if size == capacity, else false
    }

    // Queue is empty when size is 0
    boolean isEmpty(Queue queue)
    {
        return (queue.size == 0);
    } //return true is size == 0, else false

    // Method to add an item to the queue.
    // It changes rear and size
    void enqueue(int item)
    {
        if (isFull(this)) //if Queue is full, return
            return;
        this.rear = (this.rear + 1)
                % this.capacity; //increment rear index and take mod capacity
        this.array[this.rear] = item; //insert item at rear index
        this.size = this.size + 1; //increment size of array
    }

    // Method to remove an item from queue.
    // It changes front and size
    int dequeue()
    {
        if (isEmpty(this)) //check if array is empty
            return Integer.MIN_VALUE;

        int item = this.array[this.front]; //create item for front of the array
        this.front = (this.front + 1)
                % this.capacity; //increment front by one and mod capacity
        this.size = this.size - 1; //decrease size by one
        return item; //return the dequeued item
    }
}




