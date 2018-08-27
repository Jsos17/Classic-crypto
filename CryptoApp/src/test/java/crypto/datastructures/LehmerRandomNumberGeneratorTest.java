/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

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
public class LehmerRandomNumberGeneratorTest {

    private LehmerRandomNumberGenerator unSeeded;
    private LehmerRandomNumberGenerator seeded;

    @Before
    public void setUp() {
        this.unSeeded = new LehmerRandomNumberGenerator();
        this.seeded = new LehmerRandomNumberGenerator(1, 16807);
    }

    @Test
    public void getMultiplierTest1() {
        assertEquals(16807, this.seeded.getMultiplier());
    }

    @Test
    public void getMultiplierTest2() {
        assertEquals(48271, this.unSeeded.getMultiplier());
    }

    @Test
    public void seededGetInitialSeedTest1() {
        assertEquals(1, this.seeded.getSeed());
    }

    @Test
    public void seededIllegalParametersNoticedTest1() {
        LehmerRandomNumberGenerator seeded2 = new LehmerRandomNumberGenerator(1, 0);
        assertEquals(48271, seeded2.getMultiplier());
        LehmerRandomNumberGenerator seeded3 = new LehmerRandomNumberGenerator(1, 1);
        assertEquals(48271, seeded3.getMultiplier());
    }

    @Test
    public void seededIllegalParametersNoticedTest2() {
        LehmerRandomNumberGenerator seeded2 = new LehmerRandomNumberGenerator(0, 16807);
        assertTrue(seeded2.getSeed() != 0);
        LehmerRandomNumberGenerator seeded3 = new LehmerRandomNumberGenerator(2147483647, 16807);
        assertTrue(seeded3.getSeed() != 0);
    }

    @Test
    public void unSeededGetInitialSeedTest1() {
        assertTrue(this.unSeeded.getSeed() != 0);
        assertTrue(this.unSeeded.getSeed() > 0);
        assertTrue(this.unSeeded.getSeed() < 2147483647);
    }

    @Test
    public void seed10001thTest1() {
        int value = -1;
        for (int i = 1; i <= 10000; i++) {
            value = this.seeded.nextInt();
        }

        assertEquals(1043618065, value);
    }

    @Test
    public void seededNextIntRangeTest1() {
        assertTrue(this.seeded.nextInt() > 0);
        assertTrue(this.seeded.nextInt() < 2147483647);
    }

    @Test
    public void unseededNextIntRangeTest1() {
        assertTrue(this.unSeeded.nextInt() > 0);
        assertTrue(this.unSeeded.nextInt() < 2147483647);
    }

    @Test
    public void unseededNextIntBoundRangeTest1() {
        assertEquals(0, this.unSeeded.nextInt(1));
    }

    @Test
    public void unseededNextIntBoundRangeTest2() {
        assertTrue(this.unSeeded.nextInt(2) >= 0);
        assertTrue(this.unSeeded.nextInt(2) < 2);
    }

    @Test
    public void unseededNextIntBoundRangeTest3() {
        assertTrue(this.unSeeded.nextInt(10) >= 0);
        assertTrue(this.unSeeded.nextInt(10) < 10);
    }

    @Test
    public void intsRangeCorrectTest1() {
        assertEquals(9, this.unSeeded.ints(9, 10));
    }

    @Test
    public void intsRangeCorrectTest2() {
        assertTrue(this.unSeeded.ints(4, 10) >= 4);
        assertTrue(this.unSeeded.ints(4, 10) < 10);
    }

    @Test
    public void intsRangeCorrectTest3() {
        assertTrue(this.unSeeded.ints(0, 10) >= 0);
        assertTrue(this.unSeeded.ints(0, 10) < 10);
    }

    @Test
    public void cornerCaseTest1() {
        assertTrue(this.unSeeded.ints(-10, -8) > 0);
        assertTrue(this.seeded.ints(-10, -8) < 2147483647);
        assertTrue(this.unSeeded.nextInt(-100) > 0);
        assertTrue(this.unSeeded.nextInt(-100) < 2147483647);
        assertTrue(this.unSeeded.ints(0, -8) > 0);
        assertTrue(this.seeded.ints(0, -8) < 2147483647);
        assertTrue(this.unSeeded.ints(-4, 8) > 0);
        assertTrue(this.seeded.ints(-4, 8) < 2147483647);
        assertTrue(this.unSeeded.ints(0, 2147483647 + 1000) > 0);
        assertTrue(this.seeded.ints(0, 2147483647 + 1000) < 2147483647);
    }
}
