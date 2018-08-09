/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

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
public class GreatestCommonDivisorTest {

    private GreatestCommonDivisor gcd;

    @Before
    public void setUp() {
        this.gcd = new GreatestCommonDivisor();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void gcdTest1() {
        assertEquals(3, gcd.euclid(30, 21));
    }

    @Test
    public void gcdTest2() {
        assertEquals(-1, gcd.euclid(-30, -21));
    }

    @Test
    public void gcdTest3() {
        assertEquals(29, gcd.euclid(899, 493));
    }

    @Test
    public void gcdTest4() {
        assertEquals(29, gcd.euclid(493, 899));
    }

    @Test
    public void gcdTest5() {
        assertEquals(6, gcd.euclid(10596, 5634));
    }
}
