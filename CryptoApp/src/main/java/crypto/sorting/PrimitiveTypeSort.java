/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.sorting;

/**
 * This class will implement sorting algorithms for primitive data types.
 *
 * @author jpssilve
 */
public class PrimitiveTypeSort {

    public PrimitiveTypeSort() {

    }

    public void insertionSort(double[] array) {
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

    public void insertionSort(int[] array) {
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

    public void insertionSort(long[] array) {
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

    public void insertionSort(char[] array) {
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

}
