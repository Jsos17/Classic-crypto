/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class KeyedVigenereCipherTest {

    private KeyedVigenereCipher kvig;
    private KeyedVigenereCipher kvig2;

    @Before
    public void setUp() {
        this.kvig = new KeyedVigenereCipher("kryptos");
        this.kvig2 = new KeyedVigenereCipher("ciakgb");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hashFunctionMapsToUniqueIndexes() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int primeModulus = 29;

        int prev = alphabet.charAt(0) % primeModulus;
        for (int i = 1; i < alphabet.length(); i++) {
            assertNotEquals(prev, alphabet.charAt(i) % primeModulus);
            prev = alphabet.charAt(i) % primeModulus;
        }
    }

    @Test
    public void encryptTest1() {
        assertEquals("twjshmfhgyzqnujnormjxikavucsjxxndalnlflirzjdmaitesjmubzzxjxnbiqjyzczlfpvkbbzjhdzbvklkaxdzxykkeqysscvtmkhxidjc",
                kvig.encrypt("whitehouse", "acryptanalystlooksforrepeatedgroupsoflettersandcountsthenumberoflettersbetweenthebeginningofeachrepeatedgroup"));
    }

    @Test
    public void encryptTest2() {
        assertEquals("iairfcllnnfpdqkfeoqbukfksvzgldcsomuxocyeapkfladiezkobhagfzbifacftofbhcithjxajvyntnhpityo",
                kvig.encrypt("entropy", "thekasiskiexaminationinvolveslookingforstringsofcharactersthatarerepeatedintheciphertext"));
    }

    @Test
    public void encryptTest3() {
        assertEquals("ebbd",
                kvig2.encrypt("artificialintelligence", "bomb"));
    }

    @Test
    public void encryptTest4() {
        assertEquals("vccdjtiiwkfiipasryoccbggvmdtitkkuiifakugvencvcchzfqvhyileplmqnogtozjgfiuesunotmqsykwzicfgjcbafsthrqyvfygficyecvyjtgatjvufzbvasywfctqhruqrfruhfudahynoacwiudygtptubdstdlcunuieiryhhfpvesuqsacmqscmdfctozj",
                kvig2.encrypt("artificialintelligence", "thebasicuseoffrequencyanalysisistofirstcountthefrequencyofciphertextlettersandthenassociateguessedplaintextletterswiththemmorexsintheciphertextthananythingelsesuggeststhatxcorrespondstoeintheplaintext"));
    }

    @Test
    public void decryptTest1() {
        assertEquals("modernattacksonpolyalphabeticciphersareessentiallyidenticaltothatdescribedabovewiththeoneimprovementofcoincidencecounting",
                kvig.decrypt("entropy", "pxhfsvciwedocatvcmadnhaecjalqyntnhplkofjcbvfbjfqngbhfxalqkuodajmwhfefpkriefeaatrjclsztcqjmqhqcwjugtwcghbltynejvevycvxalts"));
    }

    @Test
    public void decryptTest2() {
        assertEquals("modernanalystsusecomputersbutthisdescriptionillustratestheprinciplethatthecomputeralgorithmsimplement",
                kvig2.decrypt("colossus", "marvhbwbazhdljojeozcemnzrdqfllktsusdshvetpzitkbmseaqlzmlhvcbtbutpzseiunlhvlageolebnzwdlttxxdtghkecsil"));
    }

    @Test
    public void decryptTest3() {
        assertEquals("following",
                kvig2.decrypt("tabularecta", "iqqbzysug"));
    }

    @Test
    public void decryptTest4() {
        assertEquals("normandy",
                kvig2.decrypt("operationoverlord", "ikykgdem"));
    }

    @Test
    public void mapCharToIndexCornerCase1() {
        assertEquals(0, this.kvig.mapCharToIndex('X'));
    }

    @Test
    public void mapCharToIndexCornerCase2() {
        assertEquals(0, this.kvig.mapCharToIndex('}'));
    }

    @Test
    public void buildAlphabetKeyWrongTypesOfCharactersIgnored1() {
        assertEquals("eyabcdfghijklmnopqrstuvwxz", this.kvig.buildAlphabet("Key"));
    }

    @Test
    public void buildAlphabetKeyWrongTypesOfCharactersIgnored2() {
        assertEquals("abcdefghijklmnopqrstuvwxyz", this.kvig.buildAlphabet("KEY{}"));
    }

    @Test
    public void buildAlphabetRepeatedCharactersIgnored() {
        assertEquals("dreamtbcfghijklnopqsuvwxyz", this.kvig.buildAlphabet("dreamteam"));
    }
}
