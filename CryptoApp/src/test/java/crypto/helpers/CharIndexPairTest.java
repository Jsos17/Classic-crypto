/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

import crypto.helpers.CharIndexPair;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class CharIndexPairTest {

    private CharIndexPair ciPair;

    @Before
    public void setUp() {
        this.ciPair = new CharIndexPair('x', 3);
    }

    @Test
    public void getCharTest1() {
        assertEquals('x', ciPair.getChar());
    }

    @Test
    public void equalstest1() {
        String s = "abc";
        assertFalse(this.ciPair.equals(s));
    }

    @Test
    public void equalstest2() {
        CharIndexPair c2 = new CharIndexPair('y', 2);
        assertFalse(this.ciPair.equals(c2));
    }

    @Test
    public void equalstest3() {
        CharIndexPair c2 = new CharIndexPair('y', 3);
        assertFalse(this.ciPair.equals(c2));
    }

    @Test
    public void equalstest4() {
        CharIndexPair c2 = new CharIndexPair('x', 2);
        assertFalse(this.ciPair.equals(c2));
    }
    
    @Test
    public void equalsTest5() {
        CharIndexPair ci2 = new CharIndexPair('A', 5);
        Object obj = new Object();
        assertEquals(false, ci2.equals(obj));
    }
    
    @Test
    public void equalsTest6() {
        CharIndexPair ci2 = new CharIndexPair('A', 5);
        assertEquals(false, ci2.equals(null));
    }
}
