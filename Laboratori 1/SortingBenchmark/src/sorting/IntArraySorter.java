package sorting;

/**
 * @author jmgimeno
 */

public class IntArraySorter {

    private final int[] array;

    public IntArraySorter(int[] array) {
        this.array = array;
    }

    public boolean isSorted() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void insertionSort() {
        // Invariant: The prefix [0, end) is a sorted array
        for (int end = 1; end < array.length; end++) {
            // We insert element at end into this prefix

            // Invariant: arrays sorted in the ranges [0, insert)
            // and [insert, end] and all elements in [0, insert)
            // are lower than or equal to those in [insert+1, end]


            for (int insert = end; insert >= 1; insert--) {
                if (array[insert - 1] > array[insert]) {
                    swap(insert - 1, insert);
                } else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) { /*array.length - i - 1 => From here the array is sorted*/
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < array.length; i++) {
            int minimum = i; /*We're searching the minor element of the unsorted array*/
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minimum]) {
                    minimum = j;
                }
            }
            if (i < minimum) {
                swap(i, minimum);
            }
        }
    }

    public void quickSort() {
        recursiveQuickSort(this.array, 0, this.array.length);
    }

    public void recursiveQuickSort(int[] array, int lowest, int highest) {
        if (lowest < highest) {
            int pos = partition(array, array[lowest], lowest, highest);
            recursiveQuickSort(array, lowest, pos);
            recursiveQuickSort(array, pos + 1, highest);
        }
    }

    public int partition(int[] array, int pivot, int left, int right) {
        int lowest = left;
        int highest = right;
        while (lowest < highest) {
            do {
                lowest++;
            } while (array.length > lowest && array[lowest] <= pivot); /*Ignoring the smaller elements than the pivot*/
            /*We cannot arrive to the end of the array. It is also not possible that the element pointed by the pointer 'lowest' be <= pivot (indicates that we should stop)*/
            do {
                highest--;
            } while (array[highest] > pivot && highest > 0); /*Ignoring the greater elements than the pivot*/
            /*We cannot arrive to the start of the array. It is also not possible that the element pointed by the pointer 'highest' be >= pivot (indicates that we should stop)*/
            if (highest > lowest) {
                swap(lowest, highest);
            }
        }
        swap(left, highest); /*Placing the items on the relevant side*/
        return highest;
    }

}
