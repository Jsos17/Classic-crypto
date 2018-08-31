/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

/**
 * This class implements a prime modulus multiplicative linear congruential
 * generator also known as the Lehmer random number generator.
 *
 * The recurrence relation
 *
 * Z_n+1 = a * Z_n (mod m)
 *
 * is used to produce the pseudo-random numbers, where a belongs to {2,3,...,
 * m-1} and m is a large prime number, and z_0 is initialized as a number
 * belonging to {1,2,...,m-1} and the notations _n and _n+1 in z_n and z_n+1
 * mean the subindex of the variable z.
 *
 * @author jpssilve
 */
public class LehmerRandomNumberGenerator {

    private final int multiplier; // Not every value is appropriate, see the papers indicated below
    private final int modulus; // Should be a large prime number
    private long seed; // Should never be zero (or negative)

    /**
     * The modulus m is a (Mersenne) prime number, m = 2^31 - 1, which
     * incidentally is also the largest positive value an int can have, the
     * multiplier is chosen according to the discussion provided by Park,
     * Miller, and Stockmeyer in the article mentioned below: Technical
     * correspondence: Remarks on Choosing and Implementing Random Number
     * Generators, and lastly the seed should be a value belonging to the set
     * {1, 2, ..., 2^31 - 2} (from 1 to m-1).
     *
     * Long value is used as the seed to avoid integer overflow since 48271 *
     * (2^31 -2) is smaller than the maximum long value, and thus integer
     * overflow should never occur.
     *
     * See wikipedia for a short introduction
     * https://en.wikipedia.org/wiki/Lehmer_random_number_generator
     *
     * Sources:
     *
     * Stephen K. Park; Keith W. Miller (1988). Random Number Generators: Good
     * Ones Are Hard To Find. Communications of the ACM. Volume 31. pages
     * 1192-1201
     *
     * George Marsaglia (1993). Technical correspondence: Remarks on Choosing
     * and Implementing Random Number Generators. Communications of the ACM.
     * Volume 36. pages 108-110
     */
    public LehmerRandomNumberGenerator() {
        this.multiplier = 48271;
        this.modulus = 2147483647; // 2^31 - 1
        // seed should belong to the set {1, ..., 2147483646} where m = modulus
        this.seed = System.currentTimeMillis() % this.modulus;
        if (this.seed == 0) {
            this.seed = 1;
        }
    }

    /**
     * This constructor mainly exists to test the correctness of the
     * implementation as instructed in the paper Random Number Generators: Good
     * Ones Are Hard To Find, since initialization with the seed value of 1
     * produces the value 1043618065 for the seed number 10001 when the
     * multiplier is 16807.
     *
     * @param seed Should belong to the set {1, ..., 2147483646}
     * @param multiplier Great care should be used when choosing this, for
     * example the value 16807 or 48271 produces good results
     */
    public LehmerRandomNumberGenerator(int seed, int multiplier) {
        if (multiplier <= 1) {
            this.multiplier = 48271;
        } else {
            this.multiplier = multiplier;
        }

        this.modulus = 2147483647; // 2^31 - 1
        // seed should belong to the set {1, ...,  2147483646} where m = modulus
        if (seed <= 0 || seed >= 2147483647) {
            this.seed = System.currentTimeMillis() % this.modulus;
            if (this.seed == 0) {
                this.seed = 1;
            }
        } else {
            this.seed = seed;
        }
    }

    public int getMultiplier() {
        return multiplier;
    }

    public long getSeed() {
        return seed;
    }

    /**
     * Since the seed is never initialized to 0 and it is always smaller than
     * the modulus, the method produces pseudorandom integers in the range 1 to
     * 2^31 - 2.
     *
     * @return A pseudorandom integer from the set {1, ..., 2147483646} = {1,
     * ..., 2^31-2}
     */
    public int nextInt() {
        this.seed = (this.seed * multiplier) % this.modulus;
        return (int) this.seed;
    }

    /**
     * Returns a pseudorandom integer in the range of 0 (inclusive) to bound
     * (exclusive) IF the bound is positive and smaller or equal to
     * Integer.MAX_VALUE, otherwise the method simply returns the value produced
     * by the nextInt() method.
     *
     * @param bound An int value between {1,..., 2^31 - 1}
     * @return A pseudorandom integer from the set {0, 1, ..., bound-1} if the
     * bound was acceptable, otherwise return the value produced by nextInt()
     */
    public int nextInt(int bound) {
        if (bound > 0 && bound <= 2147483647) {
            return this.nextInt() % bound;
        }

        return nextInt();
    }

    /**
     * This method returns a pseudo-random integer value from the range origin
     * (inclusive) to bound (exclusive) i.e. the value is chosen pseudo-randomly
     * from the set {origin, ..., bound-1}
     *
     * @param origin The first value that is included among the sampling range,
     * shoud be smaller than bound and greater or equal to zero
     * @param bound The ending range for the sampling range, should be bigger
     * than origin
     * @return A pseudorandom integer value from the range origin (inclusive) to
     * bound (exclusive) or if the parameter ranges are violated then a value
     * produced by nextInt()
     */
    public int ints(int origin, int bound) {
        if (origin >= 0 && bound > origin) {
            int offset = bound - origin;
            return this.nextInt(offset) + origin;
        }

        return nextInt();
    }
}
