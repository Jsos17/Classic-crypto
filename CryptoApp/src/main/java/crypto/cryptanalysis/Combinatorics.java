/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

/**
 * @author jpssilve
 */
public class Combinatorics {

    private int index;
    private byte[] nums;
    private boolean[] used;
    private byte[][] permutations;

    public Combinatorics() {
    }

    /**
     * This method generates all the permutations of the numbers 0 to n-1, and
     * stores them in a two-dimensional byte array.
     *
     * This is an exponential algorithm hence the n should be small, and because
     * the algorithm is only intended to be used for small n, byte arrays are
     * used.
     *
     * @param n The number of elements to be permuted
     * @return A two-dimensional byte array that contains all the possible
     * permutations of the numbers 0 to n-1. In each row there is a permutation,
     * and the columns consist of the numbers 0 to n-1.
     */
    protected byte[][] permutations(int n) {
        if (n <= 0) {
            return new byte[0][0];
        }

        this.index = 0;
        this.nums = new byte[n];
        this.used = new boolean[n];
        for (int i = 0; i < this.used.length; i++) {
            this.used[i] = false;
        }

        int rows = factorial(n);
        this.permutations = new byte[rows][n];
        generatePermutations(0);
        return permutations;
    }

    /**
     * Iterative way of calculating the factorial. Negative values are simply
     * ignored. This method is only meant to calculate very small factorials (1
     * to 9 for the purposes of this application), hence it returns an int and
     * not a long value.
     *
     * @param n An non-negative integer value
     * @return n! as defined for non-negative integer values
     */
    protected int factorial(int n) {
        if (n < 0) {
            return -1;
        }

        int factorial = 1;
        int i = 2;
        while (i <= n) {
            factorial *= i;
            i++;
        }

        return factorial;
    }

    /**
     * A recursive method to generate permutations and this is a slightly
     * adapted version of the method generate(table, used, k) found in the
     * lecture material of the course Data structures and algorithms (University
     * of Helsinki).
     *
     * @param k This should always be zero
     */
    private void generatePermutations(int k) {
        if (k >= this.nums.length) {
            for (int i = 0; i < this.permutations[index].length; i++) {
                this.permutations[index][i] = nums[i];
            }
            this.index++;
        } else {
            for (byte i = 0; i < this.nums.length; i++) {
                if (this.used[i] == false) {
                    this.used[i] = true;
                    this.nums[k] = i;
                    generatePermutations(k + 1);
                    this.used[i] = false;
                }
            }
        }
    }
}
