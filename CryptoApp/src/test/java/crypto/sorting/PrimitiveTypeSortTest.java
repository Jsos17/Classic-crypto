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
    private char[] charControl;
    
    private int[] intOwn;
    private long[] longOwn;
    private double[] doubleOwn;
    private char[] charOwn;
    
    @Before
    public void setUp() {
        this.n = 1000;
        this.intControl = new int[this.n];
        this.longControl = new long[this.n];
        this.doubleControl = new double[this.n];
        this.charControl = new char[this.n];
        this.intOwn = new int[this.n];
        this.longOwn = new long[this.n];
        this.doubleOwn = new double[this.n];
        this.charOwn = new char[this.n];
        char[] characters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'Å', 'Ä', 'Ö', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'å', 'ä', 'ö'};
        
        Random rand = new Random();
        for (int i = 0; i < this.n; i++) {
            int rndInt = rand.nextInt();
            long rndLong = rand.nextLong();
            double rndDouble = rand.nextDouble();
            char c = characters[rand.nextInt(characters.length)];
            
            this.intControl[i] = rndInt;
            this.intOwn[i] = rndInt;
            
            this.longControl[i] = rndLong;
            this.longOwn[i] = rndLong;
            
            this.doubleControl[i] = rndDouble;
            this.doubleOwn[i] = rndDouble;
            
            this.charControl[i] = c;
            this.charOwn[i] = c;
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
    
    @Test
    public void charInsertionSortTest1() {
        Arrays.sort(this.charControl);
        PrimitiveTypeSort.insertionSort(this.charOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.charControl[i], this.charOwn[i]);
        }
    }
    
    @Test
    public void intIterativeMergeSortTest1() {
        Arrays.sort(this.intControl);
        PrimitiveTypeSort.iterativeMergeSort(this.intOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.intControl[i], this.intOwn[i]);
        }
    }
    
    @Test
    public void longIterativeMergeSortTest1() {
        Arrays.sort(this.longControl);
        PrimitiveTypeSort.iterativeMergeSort(this.longOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.longControl[i], this.longOwn[i]);
        }
    }
    
    @Test
    public void doubleIterativeMergeSortTest1() {
        Arrays.sort(this.doubleControl);
        PrimitiveTypeSort.iterativeMergeSort(this.doubleOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.doubleControl[i], this.doubleOwn[i], 0.00000001);
        }
    }
    
    @Test
    public void charIterativeMergeSortTest1() {
        Arrays.sort(this.charControl);
        PrimitiveTypeSort.iterativeMergeSort(this.charOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.charControl[i], this.charOwn[i]);
        }
    }
}
