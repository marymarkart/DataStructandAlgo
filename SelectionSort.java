public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {47,125,23,32,51,73,101};
        int arr2[] = selectionSort(arr);
    }

    private static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = n-1; i > 1; i--){
            int max = i;
            for (int j = 0; j >= i; j++){
                if (arr[j] < arr[max]){
                    max = j;

                }

            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i]= temp;
            for (int k = 0 ; k < arr.length; k++){
                System.out.print(arr[k] + ",");

            }
        }
        return arr;
    }
}
