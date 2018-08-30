/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.helpers.GreatestCommonDivisor;
import crypto.helpers.ValueLengthPair;
import crypto.sorting.GenericTypeSort;

/**
 *
 * @author jpssilve
 */
public class AttackVigenereCipher {

    private GreatestCommonDivisor gcd;

    public AttackVigenereCipher() {
        this.gcd = new GreatestCommonDivisor();
    }

    public double calculateThreshold(double[] icValues, int n) {
        ValueLengthPair[] valueLens = new ValueLengthPair[icValues.length];
        double sum = 0;

        for (int i = 0; i < icValues.length; i++) {
            sum += icValues[i];
            valueLens[i] = new ValueLengthPair(icValues[i], i + 1);
        }

        GenericTypeSort.iterativeMergeSort(valueLens);

        double maxSum = 0;
        int k = 20;
        int i = valueLens.length - 1;
        int end = valueLens.length - k;
        while (i >= end) {
            maxSum += valueLens[i].getValue();
            i--;
        }

        double avg = sum / icValues.length;
        double maxAvg = maxSum / k;

        return ((maxAvg + avg) / 2);
    }

    public int findKeyLengths(double[] icValues, double threshold) {
        int[] keyLens = new int[icValues.length];
        int index = 0;
        for (int i = 0; i < icValues.length; i++) {
            if (icValues[i] > threshold) {
                keyLens[index] = i + 1;
                index++;
            }
        }

        int[] lengths = new int[index];
        System.arraycopy(keyLens, 0, lengths, 0, index);
        return this.gcd.gcdForMultiples(lengths);
    }
}
