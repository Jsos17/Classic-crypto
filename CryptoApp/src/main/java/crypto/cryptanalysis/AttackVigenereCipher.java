/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.helpers.GreatestCommonDivisor;

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
        double max = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += icValues[i];
            if (icValues[i] > max) {
                max = icValues[i];
            }
        }

        double avg = sum / n;

        return ((max + avg) / 2);
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
