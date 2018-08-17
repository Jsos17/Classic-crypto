/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class TranspositionCipherAttackTest {
    
    private TranspositionCipherAttack attack;
    private int index;
    
    @Before
    public void setUp() {
        this.attack = new TranspositionCipherAttack();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void factorialTest1() {
        assertEquals(1, attack.factorial(0));
        assertEquals(1, attack.factorial(1));
        assertEquals(2, attack.factorial(2));
        assertEquals(6, attack.factorial(3));
        assertEquals(24, attack.factorial(4));
        assertEquals(120, attack.factorial(5));
        assertEquals(720, attack.factorial(6));
        assertEquals(5040, attack.factorial(7));
        assertEquals(40320, attack.factorial(8));
        assertEquals(362880, attack.factorial(9));
    }
    
    @Test
    public void factorialTest2() {
        assertEquals(-1, attack.factorial(-25));
    }
    
    @Test
    public void permutationsTest1() {
        int[][] expected = new int[6][3];
        expected[0] = new int[]{0, 1, 2};
        expected[1] = new int[]{0, 2, 1};
        expected[2] = new int[]{1, 0, 2};
        expected[3] = new int[]{1, 2, 0};
        expected[4] = new int[]{2, 0, 1};
        expected[5] = new int[]{2, 1, 0};
        
        int[][] actuals = this.attack.permutations(3);
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
    }
    
    @Test
    public void permutationsTest2() {
        int[][] expected = new int[24][4];
        expected[0] = new int[]{0, 1, 2, 3};
        expected[1] = new int[]{0, 1, 3, 2};
        expected[2] = new int[]{0, 2, 1, 3};
        expected[3] = new int[]{0, 2, 3, 1};
        expected[4] = new int[]{0, 3, 1, 2};
        expected[5] = new int[]{0, 3, 2, 1};
        expected[6] = new int[]{1, 0, 2, 3};
        expected[7] = new int[]{1, 0, 3, 2};
        expected[8] = new int[]{1, 2, 0, 3};
        expected[9] = new int[]{1, 2, 3, 0};
        expected[10] = new int[]{1, 3, 0, 2};
        expected[11] = new int[]{1, 3, 2, 0};
        expected[12] = new int[]{2, 0, 1, 3};
        expected[13] = new int[]{2, 0, 3, 1};
        expected[14] = new int[]{2, 1, 0, 3};
        expected[15] = new int[]{2, 1, 3, 0};
        expected[16] = new int[]{2, 3, 0, 1};
        expected[17] = new int[]{2, 3, 1, 0};
        expected[18] = new int[]{3, 0, 1, 2};
        expected[19] = new int[]{3, 0, 2, 1};
        expected[20] = new int[]{3, 1, 0, 2};
        expected[21] = new int[]{3, 1, 2, 0};
        expected[22] = new int[]{3, 2, 0, 1};
        expected[23] = new int[]{3, 2, 1, 0};
        
        int[][] actuals = this.attack.permutations(4);
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
    }
    
    public void generatePermutationsNaive(int[] nums, boolean[] used, int k, int[][] permutations) {
        if (k == nums.length) {
            for (int i = 0; i < permutations[index].length; i++) {
                permutations[index][i] = nums[i];
            }
            index++;
        } else {
            for (int i = 0; i < nums.length; i++) {
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
    which is almost identical implementation of the pseudo code found in the lecture 
    material of the course Data structures and algorithms (University of Helsinki).
    */
    @Test
    public void permutationsTestLarge() {
        int n = 9;
        int[][] expected = new int[362880][n];
        generatePermutationsNaive(new int[n], new boolean[n], 0, expected);
        
        int[][] actuals = this.attack.permutations(n);
        
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
    }
    
    @Test
    public void permutationsTest4() {
        int[][] expected = new int[24][4];
        expected[0] = new int[]{0, 1, 2, 3};
        expected[1] = new int[]{0, 1, 3, 2};
        expected[2] = new int[]{0, 2, 1, 3};
        expected[3] = new int[]{0, 2, 3, 1};
        expected[4] = new int[]{0, 3, 1, 2};
        expected[5] = new int[]{0, 3, 2, 1};
        expected[6] = new int[]{1, 0, 2, 3};
        expected[7] = new int[]{1, 0, 3, 2};
        expected[8] = new int[]{1, 2, 0, 3};
        expected[9] = new int[]{1, 2, 3, 0};
        expected[10] = new int[]{1, 3, 0, 2};
        expected[11] = new int[]{1, 3, 2, 0};
        expected[12] = new int[]{2, 0, 1, 3};
        expected[13] = new int[]{2, 0, 3, 1};
        expected[14] = new int[]{2, 1, 0, 3};
        expected[15] = new int[]{2, 1, 3, 0};
        expected[16] = new int[]{2, 3, 0, 1};
        expected[17] = new int[]{2, 3, 1, 0};
        expected[18] = new int[]{3, 0, 1, 2};
        expected[19] = new int[]{3, 0, 2, 1};
        expected[20] = new int[]{3, 1, 0, 2};
        expected[21] = new int[]{3, 1, 2, 0};
        expected[22] = new int[]{3, 2, 0, 1};
        expected[23] = new int[]{3, 2, 1, 0};
        
        int[][] actuals = this.attack.permutations(4);
        for (int i = 0; i < actuals.length; i++) {
            for (int j = 0; j < actuals[i].length; j++) {
                assertEquals(expected[i][j], actuals[i][j]);
            }
        }
        
        int[][] expected2 = new int[6][3];
        expected2[0] = new int[]{0, 1, 2};
        expected2[1] = new int[]{0, 2, 1};
        expected2[2] = new int[]{1, 0, 2};
        expected2[3] = new int[]{1, 2, 0};
        expected2[4] = new int[]{2, 0, 1};
        expected2[5] = new int[]{2, 1, 0};
        
        int[][] actuals2 = this.attack.permutations(3);
        System.out.println("Len: " + actuals2.length);
        for (int i = 0; i < actuals2.length; i++) {
            for (int j = 0; j < actuals2[i].length; j++) {
                assertEquals(expected2[i][j], actuals2[i][j]);
            }
        }
    }
}
