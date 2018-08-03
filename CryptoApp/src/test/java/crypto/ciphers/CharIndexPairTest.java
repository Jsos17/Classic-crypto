/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

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
        ciPair = new CharIndexPair('x', 3);
    }

    @Test
    public void getCharTest1() {
        assertEquals('x', ciPair.getChar());
    }
}
