/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.sorting;

import java.lang.reflect.Array;

/**
 * This class will implement sorting algorithms for primitive data types.
 *
 * @author jpssilve
 */
public class PrimitiveTypeSort {

    public PrimitiveTypeSort() {

    }

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

    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Class type = array.getClass().getComponentType();
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];
        for (int idx = 0; idx < n1; idx++) {
            leftArray[idx] = array[left + idx];
        }
        for (int idx = 0; idx < n2; idx++) {
            rightArray[idx] = array[middle + idx + 1];
        }
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = left; k <= right; k++) {
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
