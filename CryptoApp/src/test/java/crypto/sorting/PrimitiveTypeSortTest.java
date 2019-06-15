package crypto.sorting;

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
public class PrimitiveTypeSortTest {

    private int n;
    private int[] intExpected;
    private long[] longExpected;
    private double[] doubleExpected;
    private char[] charExpected;

    private int[] intOwn;
    private long[] longOwn;
    private double[] doubleOwn;
    private char[] charOwn;

    @Before
    public void setUp() {
        this.n = 1000;
        this.intExpected = new int[this.n];
        this.longExpected = new long[this.n];
        this.doubleExpected = new double[this.n];
        this.charExpected = new char[this.n];
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

            this.intExpected[i] = rndInt;
            this.intOwn[i] = rndInt;

            this.longExpected[i] = rndLong;
            this.longOwn[i] = rndLong;

            this.doubleExpected[i] = rndDouble;
            this.doubleOwn[i] = rndDouble;

            this.charExpected[i] = c;
            this.charOwn[i] = c;
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void intInsertionSortTest0() {
        int k = 1000;
        int[] nums1 = new int[k];
        int[] nums2 = new int[k];
        for (int i = 0; i <= k - 1; i++) {
            nums1[i] = i;
            nums2[i] = k - 1 - i;
        }

        PrimitiveTypeSort.insertionSort(nums2);
        for (int i = 0; i < k; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void intInsertionSortTest1() {
        Arrays.sort(this.intExpected);
        PrimitiveTypeSort.insertionSort(this.intOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.intExpected[i], this.intOwn[i]);
        }
    }

    @Test
    public void longInsertionSortTest0() {
        int k = 1000;
        long[] nums1 = new long[k];
        long[] nums2 = new long[k];
        for (int i = 0; i <= k - 1; i++) {
            nums1[i] = i;
            nums2[i] = k - 1 - i;
        }

        PrimitiveTypeSort.insertionSort(nums2);
        for (int i = 0; i < k; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void longInsertionSortTest1() {
        Arrays.sort(this.longExpected);
        PrimitiveTypeSort.insertionSort(this.longOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.longExpected[i], this.longOwn[i]);
        }
    }

    @Test
    public void doubleInsertionSortTest0() {
        int k = 1000;
        double[] nums1 = new double[k];
        double[] nums2 = new double[k];
        for (int i = 0; i <= k - 1; i++) {
            nums1[i] = (double) i;
            nums2[i] = (double) k - 1 - i;
        }

        PrimitiveTypeSort.insertionSort(nums2);
        for (int i = 0; i < k; i++) {
            assertEquals(nums1[i], nums2[i], 0.00000001);
        }
    }

    @Test
    public void doubleInsertionSortTest1() {
        Arrays.sort(this.doubleExpected);
        PrimitiveTypeSort.insertionSort(this.doubleOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.doubleExpected[i], this.doubleOwn[i], 0.00000001);
        }
    }

    @Test
    public void charInsertionSortTest1() {
        Arrays.sort(this.charExpected);
        PrimitiveTypeSort.insertionSort(this.charOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.charExpected[i], this.charOwn[i]);
        }
    }

    @Test
    public void intIterativeMergeSortTest0() {
        int k = 10000;
        int[] nums1 = new int[k];
        int[] nums2 = new int[k];
        for (int i = 0; i <= k - 1; i++) {
            nums1[i] = i;
            nums2[i] = k - 1 - i;
        }

        PrimitiveTypeSort.iterativeMergeSort(nums2);
        for (int i = 0; i < k; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void intIterativeMergeSortTest1() {
        Arrays.sort(this.intExpected);
        PrimitiveTypeSort.iterativeMergeSort(this.intOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.intExpected[i], this.intOwn[i]);
        }
    }

    @Test
    public void longIterativeMergeSortTest0() {
        int k = 10000;
        long[] nums1 = new long[k];
        long[] nums2 = new long[k];
        for (int i = 0; i <= k - 1; i++) {
            nums1[i] = i;
            nums2[i] = k - 1 - i;
        }

        PrimitiveTypeSort.iterativeMergeSort(nums2);
        for (int i = 0; i < k; i++) {
            assertEquals(nums1[i], nums2[i]);
        }
    }

    @Test
    public void longIterativeMergeSortTest1() {
        Arrays.sort(this.longExpected);
        PrimitiveTypeSort.iterativeMergeSort(this.longOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.longExpected[i], this.longOwn[i]);
        }
    }

    @Test
    public void doubleIterativeMergeSortTest0() {
        int k = 10000;
        double[] nums1 = new double[k];
        double[] nums2 = new double[k];
        for (int i = 0; i <= k - 1; i++) {
            nums1[i] = (double) i;
            nums2[i] = (double) k - 1 - i;
        }

        PrimitiveTypeSort.iterativeMergeSort(nums2);
        for (int i = 0; i < k; i++) {
            assertEquals(nums1[i], nums2[i], 0.00000001);
        }
    }

    @Test
    public void doubleIterativeMergeSortTest1() {
        Arrays.sort(this.doubleExpected);
        PrimitiveTypeSort.iterativeMergeSort(this.doubleOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.doubleExpected[i], this.doubleOwn[i], 0.00000001);
        }
    }

    @Test
    public void charIterativeMergeSortTest1() {
        Arrays.sort(this.charExpected);
        PrimitiveTypeSort.iterativeMergeSort(this.charOwn);
        for (int i = 0; i < this.n; i++) {
            assertEquals(this.charExpected[i], this.charOwn[i]);
        }
    }
}
