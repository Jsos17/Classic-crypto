package crypto.cryptanalysis;

import java.util.HashMap;
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
        this.quad = new Ngrams(4);
        this.quad.readInputStream(getClass().getResourceAsStream("/english_quadgrams.txt"));
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

    @Test
    public void runToTheHillsRetursnStringWtihOnlyValidCharacters() {
        String ciphertext = "oarhmcofokmuttfteraelodsfwatortaltnicawwr";
        String alphabet = "abcdefghij";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            map.put(alphabet.charAt(i), 0);
        }

        String key = this.hc.runToTheHills(10, ciphertext, 20, 1000);
        for (int i = 0; i < key.length(); i++) {
            map.put(key.charAt(i), 1);
        }

        for (int i = 0; i < alphabet.length(); i++) {
            assertEquals(1, (int) map.get(alphabet.charAt(i)));
        }
    }
}
