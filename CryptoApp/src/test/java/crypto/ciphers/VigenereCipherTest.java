/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class VigenereCipherTest {

    private VigenereCipher vig;

    /*
     Code based on the pseudocode for Randomize-In-Place(A) method found in
     the book Introduction to Algorithms, 3rd edition. It is used in this
     class to help produce pseudorandom messages for encryption.
     */
    public char[] randomizeInPlace(char[] alphabet) {
        int n = alphabet.length;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int rndNumber = random.ints(i, n).findFirst().getAsInt();
            char temp = alphabet[i];
            alphabet[i] = alphabet[rndNumber];
            alphabet[rndNumber] = temp;
        }

        return alphabet;
    }

    @Before
    public void setUp() {
        this.vig = new VigenereCipher();
    }

    @Test
    public void encryptTest1() {
        assertEquals("lxfopvefrnhr", vig.encrypt("LEMON", "ATTACKATDAWN"));
    }

    @Test
    public void decryptTest1() {
        assertEquals("attackatdawn", vig.decrypt("lemon", "lxfopvefrnhr"));
    }

    @Test
    public void encryptTest2() {
        assertEquals("ysfvvykfceptafg", vig.encrypt("LEMON", "NOTHINGTOREPORT"));
    }

    @Test
    public void decryptTest2() {
        assertEquals("nothingtoreport", vig.decrypt("lemon", "ysfvvykfceptafg"));
    }

    @Test
    public void encryptTest3() {
        assertEquals("bimprzjbwjm", vig.encrypt("MotherRussia", "PutinIshere"));
    }

    @Test
    public void decryptTest3() {
        assertEquals("putinishere", vig.decrypt("motherrussia", "bimprzjbwjm"));
    }

    @Test
    public void encryptTest4() {
        assertEquals("ufvbpneiqi", vig.encrypt("BletchleyPark", "TuringTest"));
    }

    @Test
    public void decryptTest4() {
        assertEquals("turingtest", vig.decrypt("BletchleyPark", "ufvbpneiqi"));
    }

    @Test
    public void randomizedDecryptTest1() {
        String key = "xcvtyukjhwplamyt";
        String messageContent = "abcdefghijklmnopqrstuvwxyzkflgsiqqpeiuuoovxzajjjjuuworimnvbaaablfohaieinveswqp";
        char[] alphabetChars = messageContent.toCharArray();
        String[] plaintexts = new String[100];
        String[] ciphertexts = new String[100];

        for (int i = 0; i < 100; i++) {
            String plaintext = new String(randomizeInPlace(alphabetChars));
            plaintexts[i] = plaintext;
            ciphertexts[i] = vig.encrypt(key, plaintext);
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(plaintexts[i], vig.decrypt(key, ciphertexts[i]));
        }
    }

    @Test
    public void lengthenKeyTest1() {
        assertEquals("codecodeco", vig.lengthenKey("code", 10));
    }

    @Test
    public void lengthenKeyTest2() {
        assertEquals("codecodecod", vig.lengthenKey("code", 11));
    }

    @Test
    public void lengthenKeyTest3() {
        assertEquals("code", vig.lengthenKey("code", 1));
    }

    @Test
    public void lengthenKeyTest4() {
        assertEquals("code", vig.lengthenKey("code", 4));
    }

    @Test
    public void lengthenKeyTest5() {
        assertEquals("codec", vig.lengthenKey("code", 5));
    }

    @Test
    public void encryptCornerCaseTest1() {
        assertEquals("attackatdawn", vig.encrypt("", "ATTACKATDAWN"));
    }

    @Test
    public void decryptCornerCaseTest1() {
        assertEquals("afegeteheasf", vig.decrypt("", "afegeteheasf"));
    }

    @Test
    public void mapCharToIndexCornerCase1() {
        assertEquals(0, this.vig.mapCharToIndex('X'));
    }

    @Test
    public void mapCharToIndexCornerCase2() {
        assertEquals(0, this.vig.mapCharToIndex('}'));
    }
}
