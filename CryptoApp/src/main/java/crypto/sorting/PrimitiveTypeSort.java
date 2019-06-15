package crypto.sorting;

/**
 * This class will implement sorting algorithms for primitive data types.
 *
 * @author jpssilve
 */
public class PrimitiveTypeSort {

    /**
     * A very close replication of the pseudocode found in the book Introduction
     * to Algorithms (3rd edition page 18) for insertion-sort.
     *
     * @param array The array of primitive int values
     */
    public static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int x = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > x) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = x;
        }
    }

    /**
     * @see insertionSort(int[] array)
     * @param array An array of primitive long values
     */
    public static void insertionSort(long[] array) {
        for (int j = 1; j < array.length; j++) {
            long x = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > x) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = x;
        }
    }

    /**
     * @see insertionSort(int[] array)
     * @param array An array of primitive char values
     */
    public static void insertionSort(char[] array) {
        for (int j = 1; j < array.length; j++) {
            char x = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > x) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = x;
        }
    }

    /**
     * @see insertionSort(int[] array)
     * @param array An array of primitive double values
     */
    public static void insertionSort(double[] array) {
        for (int j = 1; j < array.length; j++) {
            double x = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > x) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = x;
        }
    }

    /**
     * This method implements a stable insertion sort for ints that have. The
     * algorithm is a standard basic version of insertion sort found in the
     * lecture material of the course Data structures and algorithms (University
     * of Helsinki) with alterations made to account for indexing starting from
     * 0 instead of 1.
     *
     * @param array An array of ints
     */
    public static void iterativeMergeSort(int[] array) {
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
     * used because of a lack of applicable infinite values.
     *
     * @param array The sub-array to be sorted
     * @param left The leftmost index of the current sub-array
     * @param middle The approximate middle point of the sub-array
     * @param right The rightmost index of the current sub-array
     */
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
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
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            }
        }
    }

    /**
     * @see iterativeMergeSort(int[] array)
     * @param array An array of primitive long values
     */
    public static void iterativeMergeSort(long[] array) {
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
     * @see merge(int[] array, int left, int middle, int right)
     *
     * @param array The sub-array to be sorted
     * @param left The leftmost index of the current sub-array
     * @param middle The approximate middle point of the sub-array
     * @param right The rightmost index of the current sub-array
     */
    public static void merge(long[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        long[] leftArray = new long[n1];
        long[] rightArray = new long[n2];
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
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            }
        }
    }

    /**
     * @see iterativeMergeSort(int[] array)
     * @param array An array of primitive double values
     */
    public static void iterativeMergeSort(double[] array) {
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
     * @see merge(int[] array, int left, int middle, int right)
     *
     * @param array The sub-array to be sorted
     * @param left The leftmost index of the current sub-array
     * @param middle The approximate middle point of the sub-array
     * @param right The rightmost index of the current sub-array
     */
    public static void merge(double[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];
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
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
            }
        }
    }

    /**
     * @see iterativeMergeSort(int[] array)
     * @param array An array of primitive char values
     */
    public static void iterativeMergeSort(char[] array) {
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
     * @see merge(int[] array, int left, int middle, int right)
     *
     * @param array The sub-array to be sorted
     * @param left The leftmost index of the current sub-array
     * @param middle The approximate middle point of the sub-array
     * @param right The rightmost index of the current sub-array
     */
    public static void merge(char[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        char[] leftArray = new char[n1];
        char[] rightArray = new char[n2];
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
                if (leftArray[i] <= rightArray[j]) {
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
