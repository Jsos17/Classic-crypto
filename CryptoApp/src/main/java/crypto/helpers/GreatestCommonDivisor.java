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
