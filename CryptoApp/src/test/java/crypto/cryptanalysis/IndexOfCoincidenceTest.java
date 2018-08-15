/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class IndexOfCoincidenceTest {

    private FrequencyAnalysis freq;
    private IndexOfCoincidence ic;

    @Before
    public void setUp() {
        this.freq = new FrequencyAnalysis();
        this.ic = new IndexOfCoincidence(this.freq);
    }

    @After
    public void tearDown() {
    }

    /*
    Expected subsequences produced manually
     */
    @Test
    public void subSequencesTest1() {
        String text = "crypt"
                + "ograp"
                + "hyand"
                + "crypt"
                + "analy"
                + "sis";

        String[] expected = new String[5];
        expected[0] = "cohcas";
        expected[1] = "rgyrni";
        expected[2] = "yrayas";
        expected[3] = "panpl";
        expected[4] = "tpdty";
        String[] owns = this.ic.subSequences(text, 5);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], owns[i]);
        }
    }

    /*
    Expected subsequences produced manually
     */
    @Test
    public void subSequencesTest2() {
        String text = "hashco"
                + "llisio"
                + "nsarep"
                + "ractic"
                + "allyun"
                + "avoida"
                + "blewhe"
                + "nhashi"
                + "ngaran"
                + "domsub"
                + "setofa"
                + "larges"
                + "etofpo"
                + "ssible"
                + "keys";

        String[] expected = new String[6];
        expected[0] = "hlnraabnndslesk";
        expected[1] = "alsalvlhgoeatse";
        expected[2] = "siacloeaamtroiy";
        expected[3] = "hsrtyiwsrsogfbs";
        expected[4] = "cieiudhhaufepl";
        expected[5] = "oopcnaeinbasoe";
        String[] owns = this.ic.subSequences(text, 6);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], owns[i]);
        }
    }

    /*
   Test values calculated with LibreOffice Calc 
    (file is attached to documentation), and the website
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html 
    was used to provide character counts
     */
    @Test
    public void subSequencesTest3() {
        String text = "wnylazlzeqntfpwtsmabjqinaweaocfewgpsrmyluadlybfgaltgljrlzaaxvjehhygggdsrygvnjmpyklvyilykdrphepbfgdspjtaap"
                + "sxrpayholutqfxstptffbcrkxvvjhorawfwaejxlgafilmzrywpfxjgaltdhjvjgtyguretajegpyirpxfpagodmzrhstrxjrpirlbfgkhhce"
                + "wgpsrvtuvlvepmwkpaeqlstaqolmsvjwnegmzafoslaaohalvwfkttfxdrphepqobqzdqnytagtrhspnmprtfnhmsrmznplrcijrosnrlwgds"
                + "bylapqgemyxeaeucgulwbajrkvowsrhxvngtahmaphhcyjrmielvqbbqinawepsxrewgpsrqtfqpveltkfkqiymwtqssqxvchoilmwkpzermw"
                + "eokiraluaammkwkownrawpedhcklrthtftfnjmtfbftazsclmtcssrlluwhxahjeagpmgvfpceggluadlybfgaltznlgdwsglfbpqepmsvjha"
                + "lwsnnsajlgiafyahezkbilxfthwsflgkiwgfmtrawtfxjbbhhcfsyocirbkhjziixdlpcbcthywwnrxpgvcropzvyvapxdrogcmfebjhhsllu"
                + "aqrwilnjolwllzwmncxvgkhrwlwiafajvgzxwnymabjgodfsclwneltrpkecguvlvepmwkponbidnebtcqlyahtckk";

        String[] expected = new String[6];
        expected[0] = "wlfaafrdarvgypipgaputcjflmftgepfmrrhpvwllnfofdqqtmhnjlyeewvxhceqpgftysopelkrhhjtmlapcagllpasazflfthohdtrrvobliwnhazafeevpnlk";
        expected[1] = "nzpbwemllljggylhdaatprhwgzxdttypzxlhslksmeohkronrpmprwlmubovmylispqkmqizouwactmatlhmedagfmlafktgmfhcjlhxoagjullcrfxbslceoeyk";
        expected[2] = "yewjewyytzegvkyespyqtkoaarjhyaiarjbcrvptsgsatpbyhrslogaycawnajvnxspfwxlekakwkftzcujgglldbswjybhktxcizpypppchanlxwawjctgpnba";
        expected[3] = "lqtqaglbgahdnlkppshffxrefygjgjrghrfeveaavmllthqtstrrsdpxgjsgprqarrvktvmriaopltfsswevgytwpvslaiwirjfricwgzxmhqjzvljnglrumbth";
        expected[4] = "ansiopuflahsjvdbjxoxfvajiwavuepospgwtpeqjzavfezapfmcnsqeurrthmbweqeqqcwmrmwerfbcshaflbzsqjnghlswabsbibwvvdfsrowgwvyowpvwict";
        expected[5] = "ztmncsagjxyrmyrftrlsbvwxlpljrgxdtikgumqowaawxpdgnnzirbgalkhahibewtlishkwamndtnflrxgpufngehniexfgwbykxcncyrelwlmkigmdnklkdqc";
        int keyLen = 6;
        String[] owns = this.ic.subSequences(text, keyLen);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], owns[i]);
        }
    }

    /*
    Test values calculated with LibreOffice Calc 
    (file is attached to documentation), and the website
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html 
    was used to provide character counts
     */
    @Test
    public void chiSquaredTest1() {
        long[] occs = new long[26];
        occs[0] = 43;
        occs[1] = 453;
        occs[2] = 42;
        occs[3] = 4;
        occs[4] = 1;
        occs[5] = 0;
        occs[6] = 27;
        occs[7] = 29;
        occs[8] = 301;
        occs[9] = 107;
        occs[10] = 79;
        occs[11] = 201;
        occs[12] = 3;
        occs[13] = 5;
        occs[14] = 82;
        occs[15] = 36;
        occs[16] = 47;
        occs[17] = 90;
        occs[18] = 68;
        occs[19] = 45;
        occs[20] = 9;
        occs[21] = 23;
        occs[22] = 42;
        occs[23] = 421;
        occs[24] = 26;
        occs[25] = 2;
        int textLen = 2186;
        assertEquals(64388.4292706625, this.ic.chiSquared(occs,
                this.freq.getExpectedLetterFrequencies(), textLen), 0.01);

    }

    /*
    Test values calculated with LibreOffice Calc 
    (file is attached to documentation), and the website
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html 
    was used to provide character counts
     */
    @Test
    public void chiSquaredTest2() {
        long[] occs = new long[26];
        occs[0] = 195;
        occs[1] = 51;
        occs[2] = 96;
        occs[3] = 51;
        occs[4] = 305;
        occs[5] = 72;
        occs[6] = 32;
        occs[7] = 130;
        occs[8] = 194;
        occs[9] = 1;
        occs[10] = 4;
        occs[11] = 119;
        occs[12] = 64;
        occs[13] = 183;
        occs[14] = 236;
        occs[15] = 72;
        occs[16] = 8;
        occs[17] = 130;
        occs[18] = 159;
        occs[19] = 269;
        occs[20] = 62;
        occs[21] = 24;
        occs[22] = 40;
        occs[23] = 8;
        occs[24] = 48;
        occs[25] = 3;
        int textLen = 2556;

        assertEquals(136.9908235901, this.ic.chiSquared(occs,
                this.freq.getExpectedLetterFrequencies(), textLen), 0.01);
    }

    @Test
    public void deltaBarICTest0() {
        String text = "";
        assertEquals(0.0, this.ic.deltaBarIC(text), 0.0000001);
    }

    /*
    Test values calculated with LibreOffice Calc 
    (file is attached to documentation), and the website
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html 
    was used to provide character counts
     */
    @Test
    public void deltaBarICTest1() {
        String text = "The basic idea of information theory is the more one knows about a topic, the less new information one "
                + "is apt to get about it. If an event is very probable, it is no surprise when it happens and thus provides little "
                + "new information. Inversely, if the event was improbable, it is much more informative that the event happened. "
                + "Therefore, the information content is an increasing function of the inverse of the probability of the event (1/p). "
                + "Now, if more events may happen, entropy measures the average information content you can expect to get if one of "
                + "the events actually happens. This implies that casting a die has more entropy than tossing a coin because each outcome "
                + "of the die has smaller probability than each outcome of the coin.Thus, entropy is a measure of unpredictability of the "
                + "state, or equivalently, of its average information content. To get an intuitive understanding of these terms, consider "
                + "the example of a political poll. Usually, such polls happen because the outcome of the poll is not already known. "
                + "In other words, the outcome of the poll is relatively unpredictable, and actually performing the poll and learning "
                + "the results gives some new information; these are just different ways of saying that the a priori entropy of the poll "
                + "results is large. Now, consider the case that the same poll is performed a second time shortly after the first poll. "
                + "Since the result of the first poll is already known, the outcome of the second poll can be predicted well and the "
                + "results should not contain much new information; in this case the a priori entropy of the second poll result is small "
                + "relative to that of the first.Now consider the example of a coin toss. Assuming the probability of heads is the same "
                + "as the probability of tails, then the entropy of the coin toss is as high as it could be. This is because there is no "
                + "way to predict the outcome of the coin toss ahead of time: if we have to choose, the best we can do is predict that the "
                + "coin will come up heads, and this prediction will be correct with probability 1/2. Such a coin toss has one bit of "
                + "entropy since there are two possible outcomes that occur with equal probability, and learning the actual outcome "
                + "contains one bit of information. In contrast, a coin toss using a coin that has two heads and no tails has zero "
                + "entropy since the coin will always come up heads, and the outcome can be predicted perfectly. Analogously, "
                + "one binary-outcome with equiprobable values has a Shannon entropy of log 2 ⁡ 2 = 1 "
                + "{\\displaystyle \\log _{2}2=1} \\log _{2}2=1 bit. Similarly, one trit with equiprobable values contains "
                + "log 2 ⁡ 3 {\\displaystyle \\log _{2}3} \\log _{2}3 (about 1.58496) bits of information because it can have "
                + "one of three values.English text, treated as a string of characters, has fairly low entropy, i.e., is fairly "
                + "predictable. Even if we do not know exactly what is going to come next, we can be fairly certain that, "
                + "for example, 'e' will be far more common than 'z', that the combination 'qu' will be much more common than "
                + "any other combination with a 'q' in it, and that the combination 'th' will be more common than 'z', 'q', or 'qu'. "
                + "After the first few letters one can often guess the rest of the word. English text has between 0.6 "
                + "and 1.3 bits of entropy per character of the message.";

        assertEquals(1.7489797231, this.ic.deltaBarIC(text.toLowerCase()), 0.01);
    }

    /*
    Test values calculated with LibreOffice Calc 
    (file is attached to documentation), and the website
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html 
    was used to provide character counts
     */
    @Test
    public void deltaBarICTest2() {
        String text = "in a simple substitution cipher, each letter of the plaintext is replaced with another, and any particular"
                + " letter in the plaintext will always be transformed into the same letter in the ciphertext. for instance, "
                + "if all occurrences of the letter e turn into the letter x, a ciphertext message containing numerous instances "
                + "of the letter x would suggest to a cryptanalyst that x represents e.the basic use of frequency analysis is to "
                + "first count the frequency of ciphertext letters and then associate guessed plaintext letters with them. more xs "
                + "in the ciphertext than anything else suggests that x corresponds to e in the plaintext, but this is not certain; "
                + "t and a are also very common in english, so x might be either of them also. it is unlikely to be a plaintext "
                + "z or q which are less common. thus the cryptanalyst may need to try several combinations of mappings between "
                + "ciphertext and plaintext letters";

        assertEquals(1.9124163406, this.ic.deltaBarIC(text), 0.01);
    }

    /*
    Test values calculated with LibreOffice Calc 
    (file is attached to documentation), and the website
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html 
    was used to provide character counts
     */
    @Test
    public void aggregateDeltaBarICTest1() {
        String text = "wnylazlzeqntfpwtsmabjqinaweaocfewgpsrmyluadlybfgaltgljrlzaaxvjehhygggdsrygvnjmpyklvyilykdrphepbfgdspjtaap"
                + "sxrpayholutqfxstptffbcrkxvvjhorawfwaejxlgafilmzrywpfxjgaltdhjvjgtyguretajegpyirpxfpagodmzrhstrxjrpirlbfgkhhce"
                + "wgpsrvtuvlvepmwkpaeqlstaqolmsvjwnegmzafoslaaohalvwfkttfxdrphepqobqzdqnytagtrhspnmprtfnhmsrmznplrcijrosnrlwgds"
                + "bylapqgemyxeaeucgulwbajrkvowsrhxvngtahmaphhcyjrmielvqbbqinawepsxrewgpsrqtfqpveltkfkqiymwtqssqxvchoilmwkpzermw"
                + "eokiraluaammkwkownrawpedhcklrthtftfnjmtfbftazsclmtcssrlluwhxahjeagpmgvfpceggluadlybfgaltznlgdwsglfbpqepmsvjha"
                + "lwsnnsajlgiafyahezkbilxfthwsflgkiwgfmtrawtfxjbbhhcfsyocirbkhjziixdlpcbcthywwnrxpgvcropzvyvapxdrogcmfebjhhsllu"
                + "aqrwilnjolwllzwmncxvgkhrwlwiafajvgzxwnymabjgodfsclwneltrpkecguvlvepmwkponbidnebtcqlyahtckk";
        int keyLen = 6;
        assertEquals(1.1417354205, this.ic.aggregateDeltaBarIC(text, keyLen), 0.01);
    }
    
//    @Test
//    public void aggregateDeltaBarICTest2() {
//        String text = "inasimplesubstitutionciphereachletteroftheplaintextisreplacedwithanother";
//        int keyLen = text.length() / 2;
//        assertEquals(26.0, this.ic.aggregateDeltaBarIC(text, keyLen), 0.01);
//    }
    
    /*
    The test values were created by replicating the calculations in LibreOffice 
    Calc spreadsheet (file is attached to documentation). 
    The subsequences were produced by using 
    a modified version of the subSequences method (see SubSequencePrinter) 
    and then the functions of the LibreOffice Calc were used to count characters 
    in the subsequence and to calculate the expected values
    */
    @Test
    public void allAggregateDeltaBarICsTest1() {
        String text = "wnylazlzeqntfpwtsmabjqinaweaocfewgpsrmyluadlybfgaltgljrlzaaxvjehhygggdsrygvnjmpyklvyilykdrphepbfgdspjtaap"
                + "sxrpayholutqfxstptffbcrkxvvjhorawfwaejxlgafilmzrywpfxjgaltdhjvjgtyguretajegpyirpxfpagodmzrhstrxjrpirlbfgkhhce"
                + "wgpsrvtuvlvepmwkpaeqlstaqolmsvjwnegmzafoslaaohalvwfkttfxdrphepqobqzdqnytagtrhspnmprtfnhmsrmznplrcijrosnrlwgds"
                + "bylapqgemyxeaeucgulwbajrkvowsrhxvngtahmaphhcyjrmielvqbbqinawepsxrewgpsrqtfqpveltkfkqiymwtqssqxvchoilmwkpzermw"
                + "eokiraluaammkwkownrawpedhcklrthtftfnjmtfbftazsclmtcssrlluwhxahjeagpmgvfpceggluadlybfgaltznlgdwsglfbpqepmsvjha"
                + "lwsnnsajlgiafyahezkbilxfthwsflgkiwgfmtrawtfxjbbhhcfsyocirbkhjziixdlpcbcthywwnrxpgvcropzvyvapxdrogcmfebjhhsllu"
                + "aqrwilnjolwllzwmncxvgkhrwlwiafajvgzxwnymabjgodfsclwneltrpkecguvlvepmwkponbidnebtcqlyahtckk";
        
        double[] expected = new double[21];
        expected[0] = 1.0954174743;
        expected[1] = 1.1125173954;
        expected[2] = 1.1146111504;
        expected[3] = 1.108666275;
        expected[4] = 1.0755653613;
        expected[5] = 1.1417354205;
        expected[6] = 1.9012065203;
        expected[7] = 1.0759283377;
        expected[8] = 1.0989061133;
        expected[9] = 1.104109589;
        expected[10] = 1.1004143115;
        expected[11] = 1.1254979729;
        expected[12] = 1.0689223058;
        expected[13] = 1.9305533534;
        expected[14] = 1.1191791383;
        expected[15] = 1.0702718676;
        expected[16] = 1.0317716939;
        expected[17] = 1.1070718802;
        expected[18] = 1.023832697;
        expected[19] = 1.1145645646;
        expected[20] = 1.9334400427;
        
        double[] actuals = this.ic.allAggregateDeltaBarICs(text);
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actuals[i], 0.01);
        }
    }
}
