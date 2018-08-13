/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

/**
 * This class contains the Euclidean algorithm for computing the greatest common
 * divisor of two numbers.
 *
 * @author jpssilve
 */
public class GreatestCommonDivisor {

    public GreatestCommonDivisor() {

    }

    /**
     * This method is found in the book Introduction to Algorithms 3rd edition
     * and is a recursive form of Euclid's algorithm
     *
     * @param a A non-negative integer
     * @param b A non-negative integer
     * @return The greatest common divisor of the parameters or if one of them
     * was negative then -1
     */
    public long euclidRecursive(long a, long b) {
        if (b < 0 || a < 0) {
            return -1;
        }

        if (b == 0) {
            return a;
        } else {
            return euclidRecursive(b, a % b);
        }
    }

    /**
     * An iterative form of Euclid's algorithm and it produces the same result
     * as the recursive version, the only difference is that since it avoids the
     * recursion it might be faster in practice and also uses less memory by
     * avoiding the recursion.
     *
     * @see euclidRecursive(long a, long b)
     * @param a A non-negative integer
     * @param b A non-negative integer
     * @return The greatest common divisor of the parameters or if one of them
     * was negative then -1
     */
    public long euclidIterative(long a, long b) {
        if (b < 0 || a < 0) {
            return -1;
        }

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
