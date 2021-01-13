public class Merge {
    public static void main(String[] args) {
        int a[] = {12,34,1,76,234,88,9,0};

        mergeSort(a, 0, a.length-1);
    }

    public static void mergeSort(int a[], int low, int high){
        if (low < high){
            int mid = (low+high)/2;

            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);

            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int n = high - low + 1;
        int b[] = new int[n];

        int left = low, right = mid+1, bIdx = 0;

        while (left <= mid && right <= high){
            if (a[left] <= a[right]){
                b[bIdx++] = a[left++];
            }
            else
                b[bIdx++] = a[right++];
        }
        while (left <= mid) b[bIdx++] = a[left++];
        while (right <= high) b[bIdx++] = a[right++];

        for (int k = 0; k < n; k++){
            a[low+k] = b[k];
        }
    }
}
