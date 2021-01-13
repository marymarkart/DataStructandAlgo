public class IntertionSort {
    public static void main(String[] args) {
        int [] a = {23, 45, 23, 676, 76, 34, 77, 99, 0};

        insertionSort(a, a.length);

    }
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
}
