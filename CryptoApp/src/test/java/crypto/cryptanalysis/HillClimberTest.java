/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class HillClimberTest {

    private Ngrams quad;
    private HillClimber hc;

    @Before
    public void setUp() {
        this.quad = new Quadgrams("src/main/resources/english_quadgrams.txt");
        this.hc = new HillClimber(quad);
    }

    @Test
    public void randomizeInPlaceContainsEveryMemberTest1() {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.hc.randomizeInPlace(alphabet);
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < alphabet.length; i++) {
            set.add(alphabet[i]);
        }

        char[] comparison = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < comparison.length; i++) {
            assertTrue(set.contains(comparison[i]));
        }
    }

    @Test
    public void swapRandomlyContainsEveryMemberTest1() {
        char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String randStr = this.hc.swapRandomly(alphabet);
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < randStr.length(); i++) {
            set.add(randStr.charAt(i));
        }

        char[] comparison = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int i = 0; i < comparison.length; i++) {
            assertTrue(set.contains(comparison[i]));
        }
    }
}
