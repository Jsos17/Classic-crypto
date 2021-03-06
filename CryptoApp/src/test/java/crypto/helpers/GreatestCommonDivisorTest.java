package crypto.helpers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class GreatestCommonDivisorTest {

    private GreatestCommonDivisor gcd;

    @Before
    public void setUp() {
        this.gcd = new GreatestCommonDivisor();
    }

    /*
    WolframAlpha provides a handy tool to produce test values
    http://www.wolframalpha.com/widgets/view.jsp?id=d269d2879d38da48991e43c3d3b66664
     */
    @Test
    public void gcdRecursiveTest1() {
        assertEquals(3, gcd.euclidRecursive(30, 21));
    }

    @Test
    public void gcdRecursiveTest2() {
        assertEquals(-1, gcd.euclidRecursive(-30, -21));
    }

    @Test
    public void gcdRecursiveTest3() {
        assertEquals(29, gcd.euclidRecursive(899, 493));
    }

    @Test
    public void gcdRecursiveTest4() {
        assertEquals(29, gcd.euclidRecursive(493, 899));
    }

    @Test
    public void gcdRecursiveTest5() {
        assertEquals(6, gcd.euclidRecursive(10596, 5634));
    }

    @Test
    public void gcdRecursiveTest6() {
        assertEquals(21, gcd.euclidRecursive(462, 1071));
    }

    @Test
    public void gcdRecursiveTestCornerCase1() {
        assertEquals(-1, gcd.euclidRecursive(-462, -1071));
    }

    @Test
    public void gcdRecursiveTestCornerCase2() {
        assertEquals(-1, gcd.euclidRecursive(462, -1071));
    }

    @Test
    public void gcdRecursiveTestCornerCase3() {
        assertEquals(-1, gcd.euclidRecursive(-462, 1071));
    }

    @Test
    public void gcdRecursiveTestCornerCase4() {
        assertEquals(42, gcd.euclidRecursive(42, 0));
    }

    @Test
    public void gcdRecursiveTestCornerCase5() {
        assertEquals(42, gcd.euclidRecursive(0, 42));
    }

    @Test
    public void gcdRecursiveTestCornerCase6() {
        assertEquals(0, gcd.euclidRecursive(0, 0));
    }

    @Test
    public void gcdIterativeTest1() {
        assertEquals(3l, gcd.euclidIterative(30l, 21l));
    }

    @Test
    public void gcdIterativeTest2() {
        assertEquals(-1l, gcd.euclidIterative(-30l, -21l));
    }

    @Test
    public void gcdIterativeTest3() {
        assertEquals(29l, gcd.euclidIterative(899l, 493l));
    }

    @Test
    public void gcdIterativeTest4() {
        assertEquals(29l, gcd.euclidIterative(493l, 899l));
    }

    @Test
    public void gcdIterativeTest5() {
        assertEquals(6l, gcd.euclidIterative(10596l, 5634l));
    }

    @Test
    public void gcdIterativeTest6() {
        assertEquals(21l, gcd.euclidIterative(462l, 1071l));
    }

    @Test
    public void gcdIterativeTestCornerCase1() {
        assertEquals(-1, gcd.euclidIterative(-462, -1071));
    }

    @Test
    public void gcdIterativeTestCornerCase2() {
        assertEquals(-1, gcd.euclidIterative(462, -1071));
    }

    @Test
    public void gcdIterativeTestCornerCase3() {
        assertEquals(-1, gcd.euclidIterative(-462, 1071));
    }

    @Test
    public void gcdIterativeTestCornerCase4() {
        assertEquals(42, gcd.euclidIterative(42, 0));
    }

    @Test
    public void gcdIterativeTestCornerCase5() {
        assertEquals(42, gcd.euclidIterative(0, 42));
    }

    @Test
    public void gcdIterativeTestCornerCase6() {
        assertEquals(0, gcd.euclidIterative(0, 0));
    }

    @Test
    public void intGcdIterativeTest1() {
        assertEquals(3, gcd.euclidIterative(30, 21));
    }

    @Test
    public void intGcdIterativeTest2() {
        assertEquals(21, gcd.euclidIterative(462, 1071));
    }

    @Test
    public void longGcdIterativeTest1() {
        assertEquals(21l, gcd.euclidIterative(462l, 1071l));
    }

    @Test
    public void longgcdIterativeLongCornerCase1() {
        assertEquals(-1, gcd.euclidIterative(-462l, 1071l));
    }

    @Test
    public void longgcdIterativeLongCornerCase2() {
        assertEquals(-1, gcd.euclidIterative(462l, -1071l));
    }

    @Test
    public void gcdForMultiplesCornerCase1() {
        assertEquals(0, gcd.gcdForMultiples(new int[]{}));
    }

    @Test
    public void gcdForMultiplesCornerCase2() {
        assertEquals(-1, gcd.gcdForMultiples(new int[]{1078, 1654, 334, 116, 54, 22, -4, 56, 32}));
    }

    @Test
    public void gcdForMultiplesTest1() {
        assertEquals(3, gcd.gcdForMultiples(new int[]{42, 63, 30}));
    }

    @Test
    public void gcdForMultiplesTest2() {
        assertEquals(15, gcd.gcdForMultiples(new int[]{45, 1050, 270, 30, 75, 105}));
    }

    @Test
    public void gcdForMultiplesTest3() {
        assertEquals(2, gcd.gcdForMultiples(new int[]{1078, 1654, 334, 116, 54, 22}));
    }

    @Test
    public void gcdForMultiplesTest4() {
        assertEquals(21, gcd.gcdForMultiples(new int[]{462, 1071, 3738, 336, 9072, 5166, 588, 41370, 17073, 273, 4935, 21021}));
    }

    @Test
    public void cornerCaseTest() {
        assertEquals(57, gcd.gcdForMultiples(new int[]{57}));
    }
}
