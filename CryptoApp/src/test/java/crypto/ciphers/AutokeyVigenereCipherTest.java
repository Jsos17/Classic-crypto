package crypto.ciphers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class AutokeyVigenereCipherTest {

    private AutokeyVigenereCipher autokey;

    @Before
    public void setUp() {
        this.autokey = new AutokeyVigenereCipher();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void encryptTest1() {
        assertEquals("siqqhygeofuiajtetsrbxemskokwlalhpoakw", this.autokey.encrypt("queenly", "communicationbreakdownisalwaysthesame"));
    }

    @Test
    public void encryptTest2() {
        assertEquals("qnxepvytwtwp", this.autokey.encrypt("queenly", "attackatdawn"));
    }

    @Test
    public void encryptTest3() {
        assertEquals("elqsabnqeziitizeuwzbhmrvrdjqpbaadsybpipctyuavanvlbwgwbxvrt", this.autokey.encrypt("lemon", "theenigmamachinesproducedapolyalphabeticsubstitutioncipher"));
    }

    @Test
    public void encryptTest4() {
        assertEquals("fhghbgevrirkxcgszvjsppgolwqvafxyxgfialvrgxgtaxyekghxmezdufwxpbvugfklaqklgnapwjobreeglziztpykwniwipcivgaime",
                this.autokey.encrypt("machine", "theattackerreceivesonlytheciphertexttheycanattackthetextbyselectingawordthatislikelytoappearintheplaintext"));
    }

    @Test
    public void decryptTest1() {
        assertEquals("attackatdawn", this.autokey.decrypt("queenly", "qnxepvytwtwp"));
    }

    @Test
    public void decryptTest2() {
        assertEquals("thesystemmustbepracticallyifnotmathematicallyindecipherable", this.autokey.decrypt("queenly", "jbiwldrxtqmqluibduumjgpclabnpoexybmratfivhpxybvfentnpruedtt"));
    }

    @Test
    public void decryptTest3() {
        assertEquals("thesubjectofsecuritythroughobscuritycomesupfrequentlyithinkalotofthedebatehappensbecausepeoplemisunderstandtheissue",
                this.autokey.decrypt("codebreaker", "vvhwvsnemxfyziuosrxamvwgyibfjlanyzhsivafkwjwzxowszxdsxyymdeeyhemnmomqoblhxvfiwiqwcevebsteibhmioimmrsifheezllbrlwjmx"));
    }

    @Test
    public void decryptTest4() {
        assertEquals("akeyweaknessofthesystemhoweveristhattheplaintextispartofthekeythismeansthatthekeywilllikelycontaincommonwordsatvariouspointsthekeycanbeattackedbyusingadictionaryofcommonwordsbigramstrigramsandsoforthandattemptingthedecryptionofthemessagebymovingthatwordthroughthekeyuntilpotentiallyreadabletextappears",
                this.autokey.decrypt("bombe", "byqzaekolawsysxzwgdlaiefgpihlfewolrblalpetpripxbvltxkbgutyxyjralswkxhvkflaglalkxrdmvpjespwjkyreykbphmubpkadrfwhmdjihpsgwwhlhhprdwrjexfcctgbgkxwbaewloeuvqpzirvckgcscfkatpkadrfxwxusnaziisjtdagedegfbulvfbutatrppmbrsiamqkvycsxkfldybvrajlzesitqmuzjlshcigchydmdffxzokvyqlrbrdmjjbmmyiwtpyrzeloyspeweyeeitbtrh"));
    }

    @Test
    public void encryptCornerCase1() {
        assertEquals("ccycqamkmaimkamacca", this.autokey.encrypt("", "bombingstartsatnoon"));
    }

    /* An empty primer makes the simple deterministic decryption process 
    impossible since for example b encrypted with b maps to c and likewise 
    o encrypted with o maps to c. 
    Therefore the ciphertext is returned.
     */
    @Test
    public void decryptCornerCase1() {
        assertEquals("ccycqamkmaimkamacca", this.autokey.decrypt("", "ccycqamkmaimkamacca"));
    }

    @Test
    public void decryptCornerCase2() {
        assertEquals("turing", this.autokey.decrypt("colossusmachine", "vicwfy"));
    }
}
