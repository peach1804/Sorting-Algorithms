package basepackage;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Sort {

    private Random random = new Random();
    private int max = 10000000;
    private int min = 10000;

    private Instant start;
    private Instant finish;
    private long time;

    public void mergeSort(int[] array) {
        mergeSort(array, array.length);
    }

    public void mergeSort(int[] array, int n) {

        if (n > 1) {

            int mid = n / 2;
            int[] left = new int[mid];
            int[] right = new int[n - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            for (int i = mid; i < n; i++) {
                right[i - mid] = array[i];
            }

            mergeSort(left, mid);
            mergeSort(right, n - mid);

            merge(array, left, right);
        }
    }

    public void merge(int[] array, int[] left, int[] right) {

        int m = left.length;
        int n = right.length;

        int i = 0, j = 0, k = 0;

        // increment k and the index that is copied
        while (i < m && j < n) {

            if (left[i] < right[j]) {
                array[k] = left[i];
                k++;
                i++;

            } else {
                array[k] = right[j];
                k++;
                j++;
            }
        }

        // copy remaining elements of left[] to array[]
        for (; i < m; i++) {
            array[k] = left[i];
            k++;
        }

        // copy remaining elements of right[] to array[]
        for (; j < n; j++) {
            array[k] = right[j];
            k++;
        }
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int j = partition(array, low, high);
            quickSort(array, low, j);
            quickSort(array, j+1, high);
        }
    }

    public int partition(int[] array, int low, int high) {

        int pivot = array[low];
        int j = high + 1;
        int i = low - 1;

        while (i < j) {

            // increment i while array[i] is less than pivot
            do {
                if (i < high) {
                    i++;
                }
            } while (array[i] < pivot && i < high);

            // decrement j while array[j] is greater than pivot
            do {
                j--;
            } while (array[j] > pivot);

            if (i < j) {
                // swap array[i] with array[j]
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }

        // swap array[low](the pivot) with array[j]
        int swap = array[low];
        array[low] = array[j];
        array[j] = swap;

        return j;
    }

    public void heapSort(int[] array) {

        int n = array.length;

        // find the last node that is not a leaf (i)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // remove nodes from the heap from largest to smallest
        for (int i = n - 1; i > 0; i--) {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // heapify the remaining heap
            heapify(array, i, 0);
        }
    }

    public void heapify(int[] array, int n, int i) {

        int max = i; // initialize max as root of the sub-tree
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // if left child is larger than root
        if (left < n && array[left] > array[max])
            max = left;

        // if right child is larger than max so far
        if (right < n && array[right] > array[max])
            max = right;

        // if max is not the root
        if (max != i) {
            int swap = array[i];
            array[i] = array[max];
            array[max] = swap;

            // recursively heapify the affected sub-tree
            heapify(array, n, max);
        }
    }

    public void sortAll(int[] arrayM, int[] arrayQ, int[] arrayH, int size) {

        for (int i = 0; i < size; i++) {
            int n = random.nextInt(max - min) + min;
            arrayM[i] = n;
            arrayQ[i] = n;
            arrayH[i] = n;
        }

        start = Instant.now();
        mergeSort(arrayM);
        finish = Instant.now();
        time = Duration.between(start, finish).toMillis();
        String mergeData = (Long.toString(time));

        start = Instant.now();
        quickSort(arrayQ);
        finish = Instant.now();
        time = Duration.between(start, finish).toMillis();
        String quickData = (Long.toString(time));

        start = Instant.now();
        heapSort(arrayH);
        finish = Instant.now();
        time = Duration.between(start, finish).toMillis();
        String heapData = (Long.toString(time));

        Output.dataOutput(mergeData, quickData, heapData);
    }
}