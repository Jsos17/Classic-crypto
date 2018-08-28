/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

import crypto.datastructures.HashTable;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class AlphabetHelperTest {

    private AlphabetHelper abc;
    private HashTable<Character, Integer> helper;

    @Before
    public void setUp() {
        this.abc = new AlphabetHelper();
        this.helper = this.abc.hashAlphabet("abcdefghijklmnopqrstuvxyz");
    }

    @Test
    public void hashTest1() {
        String alphabet = "abcdefghijklmnopqrstuvxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            assertTrue(this.helper.get(alphabet.charAt(i)) == i);
        }
    }
}
