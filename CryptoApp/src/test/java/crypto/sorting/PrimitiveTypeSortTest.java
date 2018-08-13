/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.sorting;

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
public class PrimitiveTypeSortTest {

    private int n;
    private int[] intControl;
    private long[] longControl;
    private double[] doubleControl;

    private int[] intOwn;
    private long[] longOwn;
    private double[] doubleOwn;

    @Before
    public void setUp() {
        this.n = 1000;
        this.intControl = new int[n];
        this.longControl = new long[n];
        this.doubleControl = new double[n];
        this.intOwn = new int[n];
        this.longOwn = new long[n];
        this.doubleOwn = new double[n];

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int rndInt = rand.nextInt();
            long rndLong = rand.nextLong();
            double rndDouble = rand.nextDouble();

            this.intControl[i] = rndInt;
            this.intOwn[i] = rndInt;

            this.longControl[i] = rndLong;
            this.longOwn[i] = rndLong;

            this.doubleControl[i] = rndDouble;
            this.doubleOwn[i] = rndDouble;
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void intInsertionSortTest1() {
        Arrays.sort(this.intControl);
        PrimitiveTypeSort.insertionSort(this.intOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.intControl[i], this.intOwn[i]);
        }
    }

    @Test
    public void longInsertionSortTest1() {
        Arrays.sort(this.longControl);
        PrimitiveTypeSort.insertionSort(this.longOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.longControl[i], this.longOwn[i]);
        }
    }

    @Test
    public void doubleInsertionSortTest1() {
        Arrays.sort(this.doubleControl);
        PrimitiveTypeSort.insertionSort(this.doubleOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.doubleControl[i], this.doubleOwn[i], 0.00000001);
        }
    }
}
