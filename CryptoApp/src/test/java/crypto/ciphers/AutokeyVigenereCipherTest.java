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
}
