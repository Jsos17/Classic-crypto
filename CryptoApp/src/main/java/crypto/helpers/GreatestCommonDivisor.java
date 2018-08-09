/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

/**
 *
 * @author jpssilve
 */
public class GreatestCommonDivisor {

    public GreatestCommonDivisor() {

    }

    public long euclid(long a, long b) {
        if (b < 0 || a < 0) {
            return -1;
        }

        if (b == 0) {
            return a;
        } else {
            return euclid(b, a % b);
        }
    }
}
