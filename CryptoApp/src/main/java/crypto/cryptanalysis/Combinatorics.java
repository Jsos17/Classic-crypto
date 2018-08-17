/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

/**
 *
 * @author jpssilve
 */
public class Combinatorics {

    private int index;
    private int[] nums;
    private boolean[] used;
    private int[][] permutations;

    public Combinatorics() {
    }

    protected int[][] permutations(int n) {
        this.index = 0;
        this.nums = new int[n];
        this.used = new boolean[n];
        int rows = factorial(n);
        this.permutations = new int[rows][n];
        generatePermutations(0);
        return permutations;
    }

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

    private void generatePermutations(int k) {
        if (k == this.nums.length) {
            for (int i = 0; i < this.permutations[index].length; i++) {
                this.permutations[index][i] = nums[i];
            }
            this.index++;
        } else {
            for (int i = 0; i < this.nums.length; i++) {
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
