/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.sorting;

import java.lang.reflect.Array;

/**
 * This class will implement sorting algorithms for non-primitive data types.
 *
 * @author jpssilve
 */
public class GenericTypeSort {

    public GenericTypeSort() {

    }

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

    public static <T extends Comparable<? super T>> void merge(T[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Class type = array.getClass().getComponentType();
        T[] leftArray = (T[]) Array.newInstance(type, n1);
        T[] rightArray = (T[]) Array.newInstance(type, n2);
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
