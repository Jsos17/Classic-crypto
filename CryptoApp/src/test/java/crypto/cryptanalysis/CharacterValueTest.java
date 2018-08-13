/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class CharacterValueTest {

    private CharacterValue cval;

    @Before
    public void setUp() {
        this.cval = new CharacterValue('a', 0.742);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getterTest1() {
        assertEquals('a', this.cval.getCharacter());
    }

    @Test
    public void getterTest2() {
        assertEquals(0.742, this.cval.getValue(), 0.0001);
    }

    @Test
    public void compareToTest1() {
        CharacterValue cval2 = new CharacterValue('z', 1.9);
        assertTrue(cval.compareTo(cval2) == -1);
    }

    @Test
    public void compareToTest2() {
        CharacterValue cval2 = new CharacterValue('z', 0.7);
        assertTrue(cval.compareTo(cval2) == 1);
    }

    @Test
    public void compareToTest3() {
        CharacterValue cval2 = new CharacterValue('z', 0.74201);
        assertFalse(cval.compareTo(cval2) == 0);
    }

    @Test
    public void equalsTest1() {
        CharacterValue cval1 = new CharacterValue('a', 0.4201);
        CharacterValue cval2 = new CharacterValue('a', 0.4201);
        assertTrue(cval1.equals(cval2));
    }
    
    @Test
    public void equalsTest2() {
        CharacterValue cval1 = new CharacterValue('a', 0.4200000001);
        CharacterValue cval2 = new CharacterValue('a', 0.4200000001);
        assertTrue(cval1.equals(cval2));
    }
    /*
    The last digit is different, and the difference is noticed
    */
    @Test
    public void equalsTest3() {
        CharacterValue cval1 = new CharacterValue('a', 0.4234512355431131);
        CharacterValue cval2 = new CharacterValue('a', 0.4234512355431132);
        assertFalse(cval1.equals(cval2));
    }
    
    /*
    The last digit is different, and the difference is no longer noticed
    */
    @Test
    public void equalsTest4() {
        CharacterValue cval1 = new CharacterValue('a', 0.42345123554311341);
        CharacterValue cval2 = new CharacterValue('a', 0.42345123554311342);
        assertTrue(cval1.equals(cval2));
    }
    
    @Test
    public void equalsTest5() {
        CharacterValue cval1 = new CharacterValue('A', 0.4201);
        CharacterValue cval2 = new CharacterValue('a', 0.4201);
        assertFalse(cval1.equals(cval2));
    }
}
