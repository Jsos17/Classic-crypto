/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.sorting;

import crypto.helpers.CharIndexPair;
import crypto.helpers.CharacterValue;
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
public class GenericTypeSortTest {

    private int n;
    private CharacterValue[] cValControls;
    private CharacterValue[] cValOwns;
    private CharIndexPair[] cIdxControls;
    private CharIndexPair[] cIdxOwns;

    @Before
    public void setUp() {
        this.n = 1000;
        this.cValControls = new CharacterValue[n];
        this.cValOwns = new CharacterValue[n];
        this.cIdxControls = new CharIndexPair[n];
        this.cIdxOwns = new CharIndexPair[n];
        char[] characters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'Å', 'Ä', 'Ö', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'å', 'ä', 'ö'};

        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            char c = characters[rand.nextInt(characters.length)];
            double value = rand.nextDouble() * rand.nextInt();
            int index = rand.nextInt(100_000);
            CharacterValue cVal = new CharacterValue(c, value);
            CharIndexPair ciPair = new CharIndexPair(c, index);

            this.cValControls[i] = cVal;
            this.cValOwns[i] = cVal;

            this.cIdxControls[i] = ciPair;
            this.cIdxOwns[i] = ciPair;
        }
    }

    @Test
    public void genericInsertionSortTest1() {
        Arrays.sort(this.cValControls);
        GenericTypeSort.insertionSort(this.cValOwns);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.cValControls[i], this.cValOwns[i]);
        }
    }

    @Test
    public void genericInsertionSortTest2() {
        Arrays.sort(this.cIdxControls);
        GenericTypeSort.insertionSort(this.cIdxOwns);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.cIdxControls[i], this.cIdxOwns[i]);
        }
    }

    @Test
    public void genericInsertionSortTest3() {
        Integer[] nums1 = new Integer[100];
        Integer[] nums2 = new Integer[100];
        Random rand2 = new Random();
        for (int i = 0; i < 100; i++) {
            Integer value = rand2.nextInt();
            nums1[i] = value;
            nums2[i] = value;
        }

        Arrays.sort(nums1);
        GenericTypeSort.insertionSort(nums2);
        for (int i = 0; i < 100; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void genericInsertionSortTest4() {
        Integer[] nums1 = new Integer[100];
        Integer[] nums2 = new Integer[100];
        Random rand2 = new Random();
        for (int i = 0; i < 100; i++) {
            Integer value = rand2.nextInt();
            nums1[i] = value;
            nums2[i] = value;
        }

        Arrays.sort(nums1);
        GenericTypeSort.insertionSort(nums2);
        assertArrayEquals(nums1, nums2);
    }

    @Test
    public void genericInsertionSortTest5() {
        Double[] nums1 = new Double[100];
        Double[] nums2 = new Double[100];
        Random rand2 = new Random();
        for (int i = 0; i < 100; i++) {
            Double value = rand2.nextDouble();
            nums1[i] = value;
            nums2[99 - i] = value;
        }

        Arrays.sort(nums1);
        GenericTypeSort.insertionSort(nums2);
        for (int i = 0; i < 100; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void genericMergeSortTest1() {
        Integer[] nums1 = new Integer[100];
        Integer[] nums2 = new Integer[100];
        Random rand2 = new Random();
        for (int i = 0; i < 100; i++) {
            Integer value = rand2.nextInt();
            nums1[i] = value;
            nums2[i] = value;
        }

        Arrays.sort(nums1);
        GenericTypeSort.iterativeMergeSort(nums2);
        for (int i = 0; i < 100; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void genericMergeSortTest2() {
        Integer[] nums1 = new Integer[1001];
        Integer[] nums2 = new Integer[1001];
        for (int i = 0; i <= 1000; i++) {
            nums1[i] = i;
            nums2[i] = 1000 - i;
        }

        GenericTypeSort.iterativeMergeSort(nums2);
        for (int i = 0; i < 1001; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void genericMergeSortTest3() {
        Arrays.sort(this.cValControls);
        GenericTypeSort.iterativeMergeSort(this.cValOwns);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.cValControls[i], this.cValOwns[i]);
        }
    }

    @Test
    public void genericMergeSortTest4() {
        Arrays.sort(this.cIdxControls);
        GenericTypeSort.iterativeMergeSort(this.cIdxOwns);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.cIdxControls[i], this.cIdxOwns[i]);
        }
    }
}
