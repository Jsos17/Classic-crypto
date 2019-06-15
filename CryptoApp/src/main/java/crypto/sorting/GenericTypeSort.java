package crypto.sorting;

/**
 * This class will implement sorting algorithms for non-primitive data types.
 *
 * @author jpssilve
 */
public class GenericTypeSort {

    /**
     * This method implements a stable insertion sort for objects that have
     * implemented the Comparable interface. The algorithm is a standard basic
     * version of insertion sort found in the lecture material of the course
     * Data structures and algorithms (University of Helsinki).
     *
     * @param <T> Any non-primitive type that implements the Comparable
     * interface
     * @param array An array consisting of instances of the specified type
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
        for (int j = 1; j < array.length; j++) {
            T x = array[j];
            int i = j - 1;
            while (i >= 0 && array[i].compareTo(x) > 0) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = x;
        }
    }

    /**
     * This method implements a basic version of iterative merge-sort for
     * non-primitive types. It is a stable sorting algorithm. The basic version
     * is found in the lecture material of the course Data structures and
     * algorithms (University of Helsinki) with alterations made to account for
     * indexing starting from 0 instead of 1.
     *
     * @param <T> Any non-primitive type that implements the Comparable
     * interface
     * @param array An array consisting of instances of the specified type
     */
    public static <T extends Comparable<? super T>> void iterativeMergeSort(T[] array) {
        int len = 1;
        while (len < array.length) {
            int start = 0;
            while (start + len <= array.length) {
                int left = start;
                int middle = start + len - 1;
                int right = Math.min(middle + len, array.length - 1);
                merge(array, left, middle, right);
                start = start + 2 * len;
            }

            len = 2 * len;
        }
    }

    /**
     * This is a very close replication of the pseudocode found in the book
     * Introduction to Algorithms (3rd edition page 31) and also in the lecture
     * material of the course Data structures and algorithms (University of
     * Helsinki). The main difference is that an infinite valued SENTINEL is not
     * used because of the difficulty of determining appropriate value.
     *
     * @param <T> Any non-primitive type that implements the Comparable
     * interface
     * @param array The sub-array to be sorted
     * @param left The leftmost index of the current sub-array
     * @param middle The approximate middle point of the sub-array
     * @param right The rightmost index of the current sub-array
     */
    protected static <T extends Comparable<? super T>> void merge(T[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        T[] leftArray = (T[]) new Comparable[n1];
        T[] rightArray = (T[]) new Comparable[n2];
        for (int idx = 0; idx < n1; idx++) {
            leftArray[idx] = array[left + idx];
        }
        for (int idx = 0; idx < n2; idx++) {
            rightArray[idx] = array[middle + idx + 1];
        }

        int i = 0;
        int j = 0;
        for (int k = left; k <= right; k++) {
            if (j >= rightArray.length) {
                array[k] = leftArray[i];
                i++;
            } else if (i >= leftArray.length) {
                array[k] = rightArray[j];
                j++;
            } else {
                if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            }
        }
    }
}
