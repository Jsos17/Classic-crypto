/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class CombinatoricsTest {

    private Combinatorics combi;
    private int index;

    @Before
    public void setUp() {
        this.index = 0;
        this.combi = new Combinatorics();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void factorialTest1() {
        assertEquals(1, combi.factorial(0));
        assertEquals(1, combi.factorial(1));
        assertEquals(2, combi.factorial(2));
        assertEquals(6, combi.factorial(3));
        assertEquals(24, combi.factorial(4));
        assertEquals(120, combi.factorial(5));
        assertEquals(720, combi.factorial(6));
        assertEquals(5040, combi.factorial(7));
        assertEquals(40320, combi.factorial(8));
        assertEquals(362880, combi.factorial(9));
    }

    @Test
    public void factorialTest2() {
        assertEquals(-1, combi.factorial(-25));
    }

    @Test
    public void permutationsTest1() {
        byte[][] expected = new byte[6][3];
        expected[0] = new byte[]{0, 1, 2};
        expected[1] = new byte[]{0, 2, 1};
        expected[2] = new byte[]{1, 0, 2};
        expected[3] = new byte[]{1, 2, 0};
        expected[4] = new byte[]{2, 0, 1};
        expected[5] = new byte[]{2, 1, 0};

        byte[][] actuals = this.combi.permutations(3);
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
    }

    @Test
    public void permutationsTest2() {
        byte[][] expected = new byte[24][4];
        expected[0] = new byte[]{0, 1, 2, 3};
        expected[1] = new byte[]{0, 1, 3, 2};
        expected[2] = new byte[]{0, 2, 1, 3};
        expected[3] = new byte[]{0, 2, 3, 1};
        expected[4] = new byte[]{0, 3, 1, 2};
        expected[5] = new byte[]{0, 3, 2, 1};
        expected[6] = new byte[]{1, 0, 2, 3};
        expected[7] = new byte[]{1, 0, 3, 2};
        expected[8] = new byte[]{1, 2, 0, 3};
        expected[9] = new byte[]{1, 2, 3, 0};
        expected[10] = new byte[]{1, 3, 0, 2};
        expected[11] = new byte[]{1, 3, 2, 0};
        expected[12] = new byte[]{2, 0, 1, 3};
        expected[13] = new byte[]{2, 0, 3, 1};
        expected[14] = new byte[]{2, 1, 0, 3};
        expected[15] = new byte[]{2, 1, 3, 0};
        expected[16] = new byte[]{2, 3, 0, 1};
        expected[17] = new byte[]{2, 3, 1, 0};
        expected[18] = new byte[]{3, 0, 1, 2};
        expected[19] = new byte[]{3, 0, 2, 1};
        expected[20] = new byte[]{3, 1, 0, 2};
        expected[21] = new byte[]{3, 1, 2, 0};
        expected[22] = new byte[]{3, 2, 0, 1};
        expected[23] = new byte[]{3, 2, 1, 0};

        byte[][] actuals = this.combi.permutations(4);
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
    }

    /*
    This method is here to compare wtih the actual implementation of generating  permutations
    and it is found in an almost exact form (apart from not printing the permutations and 
    instead storing them in an array) in the lecture material of the course Data structures
    and algorithms (University of Helsinki).
     */
    public void generatePermutationsNaive(byte[] nums, boolean[] used, int k, byte[][] permutations) {
        if (k == nums.length) {
            System.arraycopy(nums, 0, permutations[this.index], 0, permutations[this.index].length);
            this.index++;
        } else {
            for (byte i = 0; i < nums.length; i++) {
                if (used[i] == false) {
                    boolean[] used2 = Arrays.copyOf(used, used.length);
                    used2[i] = true;
                    nums[k] = i;
                    generatePermutationsNaive(nums, used2, k + 1, permutations);
                }
            }
        }
    }

    /*
    Test done with the help of the naive version of the generate permutations algorithm
    which is almost identical implementation of the pseudocode found in the lecture
    material of the course Data structures and algorithms (University of Helsinki).
    
    Permutations are generated for random n, where n = 1,..,9
     */
    @Test
    public void permutationsTestRandom() {
        Random rand = new Random();
        int n = rand.nextInt(9) + 1;
        int[] factorials = new int[10];
        factorials[0] = 1;
        factorials[1] = 1;
        factorials[2] = 2;
        factorials[3] = 6;
        factorials[4] = 24;
        factorials[5] = 120;
        factorials[6] = 720;
        factorials[7] = 5040;
        factorials[8] = 40320;
        factorials[9] = 362880;

        byte[][] expected = new byte[factorials[n]][n];
        generatePermutationsNaive(new byte[n], new boolean[n], 0, expected);

        byte[][] actuals = this.combi.permutations(n);

        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
    }

    @Test
    public void permutationsTest4() {
        byte[][] expected = new byte[24][4];
        expected[0] = new byte[]{0, 1, 2, 3};
        expected[1] = new byte[]{0, 1, 3, 2};
        expected[2] = new byte[]{0, 2, 1, 3};
        expected[3] = new byte[]{0, 2, 3, 1};
        expected[4] = new byte[]{0, 3, 1, 2};
        expected[5] = new byte[]{0, 3, 2, 1};
        expected[6] = new byte[]{1, 0, 2, 3};
        expected[7] = new byte[]{1, 0, 3, 2};
        expected[8] = new byte[]{1, 2, 0, 3};
        expected[9] = new byte[]{1, 2, 3, 0};
        expected[10] = new byte[]{1, 3, 0, 2};
        expected[11] = new byte[]{1, 3, 2, 0};
        expected[12] = new byte[]{2, 0, 1, 3};
        expected[13] = new byte[]{2, 0, 3, 1};
        expected[14] = new byte[]{2, 1, 0, 3};
        expected[15] = new byte[]{2, 1, 3, 0};
        expected[16] = new byte[]{2, 3, 0, 1};
        expected[17] = new byte[]{2, 3, 1, 0};
        expected[18] = new byte[]{3, 0, 1, 2};
        expected[19] = new byte[]{3, 0, 2, 1};
        expected[20] = new byte[]{3, 1, 0, 2};
        expected[21] = new byte[]{3, 1, 2, 0};
        expected[22] = new byte[]{3, 2, 0, 1};
        expected[23] = new byte[]{3, 2, 1, 0};

        byte[][] actuals = this.combi.permutations(4);
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }

        byte[][] expected2 = new byte[6][3];
        expected2[0] = new byte[]{0, 1, 2};
        expected2[1] = new byte[]{0, 2, 1};
        expected2[2] = new byte[]{1, 0, 2};
        expected2[3] = new byte[]{1, 2, 0};
        expected2[4] = new byte[]{2, 0, 1};
        expected2[5] = new byte[]{2, 1, 0};

        byte[][] actuals2 = this.combi.permutations(3);
        for (int i = 0; i < actuals2.length; i++) {
            for (int j = 0; j < actuals2[i].length; j++) {
                assertEquals(expected2[i][j], actuals2[i][j]);
            }
        }
    }

    @Test
    public void permutationsCornerCase1() {
        byte[][] expected = new byte[0][0];
        assertArrayEquals(expected, this.combi.permutations(0));
    }

    @Test
    public void permutationsCornerCase2() {
        byte[][] expected = new byte[0][0];
        assertArrayEquals(expected, this.combi.permutations(-42));
    }
}
