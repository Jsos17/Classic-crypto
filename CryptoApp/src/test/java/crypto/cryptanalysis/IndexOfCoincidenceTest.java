/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.util.Arrays;
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

    @Test
    public void getKeyCandidateTest1() {
        String ciphertext = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmum"
                + "shwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluy"
                + "sdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
        this.ic.findKey(ciphertext, 7);
        assertEquals("ciahers", this.ic.getKeyCandidate());
    }

    @Test
    public void findKeyTest1() {
        CharacterValue[] cvals1 = new CharacterValue[26];
        cvals1[0] = new CharacterValue('a', 2497.71031791495000);
        cvals1[1] = new CharacterValue('b', 654.03203501739800);
        cvals1[2] = new CharacterValue('c', 298.92083595533400);
        cvals1[3] = new CharacterValue('d', 594.26491237835400);
        cvals1[4] = new CharacterValue('e', 2146.95518868435000);
        cvals1[5] = new CharacterValue('f', 1164.37613638998000);
        cvals1[6] = new CharacterValue('g', 2838.64209862507000);
        cvals1[7] = new CharacterValue('h', 2240.44171757765000);
        cvals1[8] = new CharacterValue('i', 1447.76477498069000);
        cvals1[9] = new CharacterValue('j', 423.35785628646600);
        cvals1[10] = new CharacterValue('k', 990.90142798632200);
        cvals1[11] = new CharacterValue('l', 1608.18742067536000);
        cvals1[12] = new CharacterValue('m', 133.53908468833400);
        cvals1[13] = new CharacterValue('n', 735.00068274474000);
        cvals1[14] = new CharacterValue('o', 1013.06735393434000);
        cvals1[15] = new CharacterValue('p', 2801.32449312556000);
        cvals1[16] = new CharacterValue('q', 333.64338034876400);
        cvals1[17] = new CharacterValue('r', 2924.77502028588000);
        cvals1[18] = new CharacterValue('s', 314.20767531726900);
        cvals1[19] = new CharacterValue('t', 1575.03097625396000);
        cvals1[20] = new CharacterValue('u', 748.41275174680600);
        cvals1[21] = new CharacterValue('v', 2939.19073226197000);
        cvals1[22] = new CharacterValue('w', 1680.05073626135000);
        cvals1[23] = new CharacterValue('x', 1175.81609921529000);
        cvals1[24] = new CharacterValue('y', 931.18720504183700);
        cvals1[25] = new CharacterValue('z', 439.74213593915200);
        Arrays.sort(cvals1);

        CharacterValue[] cvals2 = new CharacterValue[26];
        cvals2[0] = new CharacterValue('a', 77.24526868542730);
        cvals2[1] = new CharacterValue('b', 2108.56506641344000);
        cvals2[2] = new CharacterValue('c', 874.48839566155000);
        cvals2[3] = new CharacterValue('d', 2912.58801816205000);
        cvals2[4] = new CharacterValue('e', 680.56195944282900);
        cvals2[5] = new CharacterValue('f', 2804.53488966407000);
        cvals2[6] = new CharacterValue('g', 333.50036602552400);
        cvals2[7] = new CharacterValue('h', 1591.82308057005000);
        cvals2[8] = new CharacterValue('i', 1382.34129749200000);
        cvals2[9] = new CharacterValue('j', 1782.96863735655000);
        cvals2[10] = new CharacterValue('k', 2325.32731003889000);
        cvals2[11] = new CharacterValue('l', 653.93988161233000);
        cvals2[12] = new CharacterValue('m', 536.26461356434700);
        cvals2[13] = new CharacterValue('n', 241.57362716742500);
        cvals2[14] = new CharacterValue('o', 3290.60283405506000);
        cvals2[15] = new CharacterValue('p', 474.08883639426700);
        cvals2[16] = new CharacterValue('q', 1036.41458968706000);
        cvals2[17] = new CharacterValue('r', 1029.91267029177000);
        cvals2[18] = new CharacterValue('s', 2774.83945662655000);
        cvals2[19] = new CharacterValue('t', 796.42203382788200);
        cvals2[20] = new CharacterValue('u', 3886.64637238324000);
        cvals2[21] = new CharacterValue('v', 1909.68253794525000);
        cvals2[22] = new CharacterValue('w', 1569.59845734046000);
        cvals2[23] = new CharacterValue('x', 1012.36643988847000);
        cvals2[24] = new CharacterValue('y', 987.26158180812000);
        cvals2[25] = new CharacterValue('z', 922.98540958727200);
        Arrays.sort(cvals2);

        CharacterValue[] cvals3 = new CharacterValue[26];
        cvals3[0] = new CharacterValue('a', 956.16653553576400);
        cvals3[1] = new CharacterValue('b', 400.50927780610500);
        cvals3[2] = new CharacterValue('c', 29.48415588342560);
        cvals3[3] = new CharacterValue('d', 2331.39664372643000);
        cvals3[4] = new CharacterValue('e', 623.56118190369400);
        cvals3[5] = new CharacterValue('f', 3346.05337217156000);
        cvals3[6] = new CharacterValue('g', 759.93262041637600);
        cvals3[7] = new CharacterValue('h', 2225.47559598827000);
        cvals3[8] = new CharacterValue('i', 302.98806614271200);
        cvals3[9] = new CharacterValue('j', 1134.02642197581000);
        cvals3[10] = new CharacterValue('k', 1478.19489968203000);
        cvals3[11] = new CharacterValue('l', 704.44529218896400);
        cvals3[12] = new CharacterValue('m', 3023.09447591995000);
        cvals3[13] = new CharacterValue('n', 242.85840599656600);
        cvals3[14] = new CharacterValue('o', 757.88822135480800);
        cvals3[15] = new CharacterValue('p', 178.37330236491600);
        cvals3[16] = new CharacterValue('q', 2784.35597818409000);
        cvals3[17] = new CharacterValue('r', 579.74256852624100);
        cvals3[18] = new CharacterValue('s', 831.48148398033700);
        cvals3[19] = new CharacterValue('t', 1627.06903625441000);
        cvals3[20] = new CharacterValue('u', 1202.06980675680000);
        cvals3[21] = new CharacterValue('v', 513.45699253500400);
        cvals3[22] = new CharacterValue('w', 3471.02941910619000);
        cvals3[23] = new CharacterValue('x', 1657.71515893947000);
        cvals3[24] = new CharacterValue('y', 1549.30488516156000);
        cvals3[25] = new CharacterValue('z', 1081.92038394218000);
        Arrays.sort(cvals3);

        CharacterValue[] cvals4 = new CharacterValue[26];
        cvals4[0] = new CharacterValue('a', 3004.21174478884000);
        cvals4[1] = new CharacterValue('b', 2643.10930347168000);
        cvals4[2] = new CharacterValue('c', 2965.56912370983000);
        cvals4[3] = new CharacterValue('d', 1304.56859980359000);
        cvals4[4] = new CharacterValue('e', 1037.61239710028000);
        cvals4[5] = new CharacterValue('f', 906.64876141693900);
        cvals4[6] = new CharacterValue('g', 515.88146759729000);
        cvals4[7] = new CharacterValue('h', 44.30003835897450);
        cvals4[8] = new CharacterValue('i', 1368.60694803821000);
        cvals4[9] = new CharacterValue('j', 2450.49609076462000);
        cvals4[10] = new CharacterValue('k', 2605.80595908494000);
        cvals4[11] = new CharacterValue('l', 629.55036352739000);
        cvals4[12] = new CharacterValue('m', 2864.19221669695000);
        cvals4[13] = new CharacterValue('n', 408.61969225286800);
        cvals4[14] = new CharacterValue('o', 1408.57550652782000);
        cvals4[15] = new CharacterValue('p', 902.14414435454600);
        cvals4[16] = new CharacterValue('q', 2204.14878061093000);
        cvals4[17] = new CharacterValue('r', 2073.47181123730000);
        cvals4[18] = new CharacterValue('s', 360.54442772998600);
        cvals4[19] = new CharacterValue('t', 471.59423875700100);
        cvals4[20] = new CharacterValue('u', 358.18042090989600);
        cvals4[21] = new CharacterValue('v', 2945.23794464298000);
        cvals4[22] = new CharacterValue('w', 742.72750027034800);
        cvals4[23] = new CharacterValue('x', 721.37017602689100);
        cvals4[24] = new CharacterValue('y', 1157.04609099813000);
        cvals4[25] = new CharacterValue('z', 958.58612910076700);
        Arrays.sort(cvals4);

        CharacterValue[] cvals5 = new CharacterValue[26];
        cvals5[0] = new CharacterValue('a', 1652.99347902693000);
        cvals5[1] = new CharacterValue('b', 469.93110769010900);
        cvals5[2] = new CharacterValue('c', 2741.94663446593000);
        cvals5[3] = new CharacterValue('d', 2107.98937220812000);
        cvals5[4] = new CharacterValue('e', 1056.70018948410000);
        cvals5[5] = new CharacterValue('f', 1612.60389518383000);
        cvals5[6] = new CharacterValue('g', 699.36119994848900);
        cvals5[7] = new CharacterValue('h', 526.50598223790200);
        cvals5[8] = new CharacterValue('i', 19.38755489915710);
        cvals5[9] = new CharacterValue('j', 1393.20088411263000);
        cvals5[10] = new CharacterValue('k', 594.11135988263200);
        cvals5[11] = new CharacterValue('l', 2261.84876370962000);
        cvals5[12] = new CharacterValue('m', 1571.89069582548000);
        cvals5[13] = new CharacterValue('n', 3581.47644822526000);
        cvals5[14] = new CharacterValue('o', 449.96144438226900);
        cvals5[15] = new CharacterValue('p', 1815.26550667508000);
        cvals5[16] = new CharacterValue('q', 850.51724465515900);
        cvals5[17] = new CharacterValue('r', 1122.93980381844000);
        cvals5[18] = new CharacterValue('s', 1567.41428045296000);
        cvals5[19] = new CharacterValue('t', 527.28990248837000);
        cvals5[20] = new CharacterValue('u', 623.12445559396000);
        cvals5[21] = new CharacterValue('v', 545.46923585213700);
        cvals5[22] = new CharacterValue('w', 4585.72241782652000);
        cvals5[23] = new CharacterValue('x', 575.85486999150100);
        cvals5[24] = new CharacterValue('y', 1056.91771959537000);
        cvals5[25] = new CharacterValue('z', 725.91348812456200);
        Arrays.sort(cvals5);

        CharacterValue[] cvals6 = new CharacterValue[26];
        cvals6[0] = new CharacterValue('a', 578.30528210614800);
        cvals6[1] = new CharacterValue('b', 2147.46318939822000);
        cvals6[2] = new CharacterValue('c', 879.33683055254200);
        cvals6[3] = new CharacterValue('d', 608.12491306445700);
        cvals6[4] = new CharacterValue('e', 975.70423219847800);
        cvals6[5] = new CharacterValue('f', 1549.80557482961000);
        cvals6[6] = new CharacterValue('g', 885.96024600058500);
        cvals6[7] = new CharacterValue('h', 2908.62766153561000);
        cvals6[8] = new CharacterValue('i', 1615.94859593832000);
        cvals6[9] = new CharacterValue('j', 1649.38564688177000);
        cvals6[10] = new CharacterValue('k', 497.19317849006200);
        cvals6[11] = new CharacterValue('l', 1338.50981510828000);
        cvals6[12] = new CharacterValue('m', 860.07864290534400);
        cvals6[13] = new CharacterValue('n', 177.17323266950900);
        cvals6[14] = new CharacterValue('o', 985.11607955020900);
        cvals6[15] = new CharacterValue('p', 754.85069235711200);
        cvals6[16] = new CharacterValue('q', 2876.29220683329000);
        cvals6[17] = new CharacterValue('r', 229.50407102448500);
        cvals6[18] = new CharacterValue('s', 2740.14984996285000);
        cvals6[19] = new CharacterValue('t', 185.61910475097800);
        cvals6[20] = new CharacterValue('u', 1924.75409734253000);
        cvals6[21] = new CharacterValue('v', 680.02519968151800);
        cvals6[22] = new CharacterValue('w', 2189.89459371723000);
        cvals6[23] = new CharacterValue('x', 1933.38987567723000);
        cvals6[24] = new CharacterValue('y', 721.46249446853100);
        cvals6[25] = new CharacterValue('z', 585.06762009918500);
        Arrays.sort(cvals6);

        CharacterValue[] cvals7 = new CharacterValue[26];
        cvals7[0] = new CharacterValue('a', 2402.36811940861000);
        cvals7[1] = new CharacterValue('b', 1479.87993767141000);
        cvals7[2] = new CharacterValue('c', 920.28736846374900);
        cvals7[3] = new CharacterValue('d', 622.13283979502900);
        cvals7[4] = new CharacterValue('e', 62.96938004412030);
        cvals7[5] = new CharacterValue('f', 568.52677060189700);
        cvals7[6] = new CharacterValue('g', 874.64109325045700);
        cvals7[7] = new CharacterValue('h', 4349.68250620346000);
        cvals7[8] = new CharacterValue('i', 1067.12861756154000);
        cvals7[9] = new CharacterValue('j', 5457.72494046238000);
        cvals7[10] = new CharacterValue('k', 502.81867892600000);
        cvals7[11] = new CharacterValue('l', 2733.64516437300000);
        cvals7[12] = new CharacterValue('m', 610.90078997181500);
        cvals7[13] = new CharacterValue('n', 1318.78888483234000);
        cvals7[14] = new CharacterValue('o', 2728.66537994489000);
        cvals7[15] = new CharacterValue('p', 274.86812709813000);
        cvals7[16] = new CharacterValue('q', 642.45518912843200);
        cvals7[17] = new CharacterValue('r', 252.19322487113800);
        cvals7[18] = new CharacterValue('s', 5832.72165242897000);
        cvals7[19] = new CharacterValue('t', 643.17669784310100);
        cvals7[20] = new CharacterValue('u', 1240.63422835294000);
        cvals7[21] = new CharacterValue('v', 680.99860277243000);
        cvals7[22] = new CharacterValue('w', 916.83642946731000);
        cvals7[23] = new CharacterValue('x', 877.12517485307300);
        cvals7[24] = new CharacterValue('y', 5188.69550245539000);
        cvals7[25] = new CharacterValue('z', 3306.28673902853000);
        Arrays.sort(cvals7);

        CharacterValue[][] expected = new CharacterValue[7][26];
        expected[0] = cvals1;
        expected[1] = cvals2;
        expected[2] = cvals3;
        expected[3] = cvals4;
        expected[4] = cvals5;
        expected[5] = cvals6;
        expected[6] = cvals7;

        String ciphertext = "unczqztxeubjfxutwaqbroiromeimcjsmgxqrqmbuiblcpvgijtkzzrtx"
                + "aelljmfhcuwglqrculnrkpcybvgglcytrxfetpvglqpnhqaxqxvdqypmlyhgf"
                + "fqtthvfjarollvrfovomfeyenlbgidipaprgupjlzgijthvzvretcukrmrans"
                + "wpggrtlvpieohaprpqtvlzrxgrppvgsfhgsmgxqrzhkvttetamkxyeuzitioo"
                + "paivruniuczidowzqawfapjmfsrtjltrxfeteebyxdubotietvvipvkpvhvnp"
                + "ksvapnxjrgwzrwqnvzmglqbczqpyeeqmneicuguklezanfavwusvvnvvetevc"
                + "axfhgmzrugepjgbjoiromexqxvsmgxqruhvqxtephafsoicamtyqsullcpmip"
                + "amkxxevamewiivobuiymqymkwunvompmbhgybrbftjhvnrktjpvtixsgzctkq"
                + "svzbuefxevzeiepqulfxaekubuiblcpvgijtdbbgluskzvbxoetaivrfapkin"
                + "vqanzwiidyevuzsziplvtpusjzwkqugjajriutjlzbjfhgtiywaivpahrximl"
                + "tlxabghxyeunvlfgdarsdpvgtatltrwecqtubrfhwzbuiorawbnrmlazbzekn"
                + "gllgsfrazmiidanjwzfuncaqbreohtictunizjrxiegukvttetamkxmnfwtnm"
                + "ztgebyiftgya";

        CharacterValue[][] actuals = this.ic.findKey(ciphertext, 7);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[0].length; j++) {
                assertEquals(expected[i][j].getCharacter(), actuals[i][j].getCharacter());
                assertEquals(expected[i][j].getValue(), actuals[i][j].getValue(), 0.001);
            }
        }
    }

    @Test
    public void getKeyCandidateTest2() {
        String ciphertext = "unczqztxeubjfxutwaqbroiromeimcjsmgxqrqmbuiblcpvgijtkzzrtx"
                + "aelljmfhcuwglqrculnrkpcybvgglcytrxfetpvglqpnhqaxqxvdqypmlyhgf"
                + "fqtthvfjarollvrfovomfeyenlbgidipaprgupjlzgijthvzvretcukrmrans"
                + "wpggrtlvpieohaprpqtvlzrxgrppvgsfhgsmgxqrzhkvttetamkxyeuzitioo"
                + "paivruniuczidowzqawfapjmfsrtjltrxfeteebyxdubotietvvipvkpvhvnp"
                + "ksvapnxjrgwzrwqnvzmglqbczqpyeeqmneicuguklezanfavwusvvnvvetevc"
                + "axfhgmzrugepjgbjoiromexqxvsmgxqruhvqxtephafsoicamtyqsullcpmip"
                + "amkxxevamewiivobuiymqymkwunvompmbhgybrbftjhvnrktjpvtixsgzctkq"
                + "svzbuefxevzeiepqulfxaekubuiblcpvgijtdbbgluskzvbxoetaivrfapkin"
                + "vqanzwiidyevuzsziplvtpusjzwkqugjajriutjlzbjfhgtiywaivpahrximl"
                + "tlxabghxyeunvlfgdarsdpvgtatltrwecqtubrfhwzbuiorawbnrmlazbzekn"
                + "gllgsfrazmiidanjwzfuncaqbreohtictunizjrxiegukvttetamkxmnfwtnm"
                + "ztgebyiftgya";
        this.ic.findKey(ciphertext, 7);
        assertEquals("machine", this.ic.getKeyCandidate());
    }

    @Test
    public void solveTest1() {
        String ciphertext = "unczqztxeubjfxutwaqbroiromeimcjsmgxqrqmbuiblcpvgijtkzzrtx"
                + "aelljmfhcuwglqrculnrkpcybvgglcytrxfetpvglqpnhqaxqxvdqypmlyhgf"
                + "fqtthvfjarollvrfovomfeyenlbgidipaprgupjlzgijthvzvretcukrmrans"
                + "wpggrtlvpieohaprpqtvlzrxgrppvgsfhgsmgxqrzhkvttetamkxyeuzitioo"
                + "paivruniuczidowzqawfapjmfsrtjltrxfeteebyxdubotietvvipvkpvhvnp"
                + "ksvapnxjrgwzrwqnvzmglqbczqpyeeqmneicuguklezanfavwusvvnvvetevc"
                + "axfhgmzrugepjgbjoiromexqxvsmgxqruhvqxtephafsoicamtyqsullcpmip"
                + "amkxxevamewiivobuiymqymkwunvompmbhgybrbftjhvnrktjpvtixsgzctkq"
                + "svzbuefxevzeiepqulfxaekubuiblcpvgijtdbbgluskzvbxoetaivrfapkin"
                + "vqanzwiidyevuzsziplvtpusjzwkqugjajriutjlzbjfhgtiywaivpahrximl"
                + "tlxabghxyeunvlfgdarsdpvgtatltrwecqtubrfhwzbuiorawbnrmlazbzekn"
                + "gllgsfrazmiidanjwzfuncaqbreohtictunizjrxiegukvttetamkxmnfwtnm"
                + "ztgebyiftgya";

        String plaintext = "inasimplesubstitutionciphereachletteroftheplaintextisreplaced"
                + "withanotherandanyparticularletterintheplaintextwillalwaysbetransformed"
                + "intothesameletterintheciphertextforinstanceifalloccurrencesoftheletter"
                + "eturnintotheletterxaciphertextmessagecontainingnumerousinstancesofthel"
                + "etterxwouldsuggesttoacryptanalystthatxrepresentsethebasicuseoffrequenc"
                + "yanalysisistofirstcountthefrequencyofciphertextlettersandthenassociate"
                + "guessedplaintextletterswiththemmorexsintheciphertextthananythingelsesu"
                + "ggeststhatxcorrespondstoeintheplaintextbutthisisnotcertaintandaarealso"
                + "verycommoninenglishsoxmightbeeitherofthemalsoitisunlikelytobeaplaintex"
                + "tzorqwhicharelesscommonthusthecryptanalystmayneedtotryseveralcombinationsofmappingsbetweenciphertextandplaintextletters";
        this.ic.findKey(ciphertext, 7);
        String keyCandidate = this.ic.getKeyCandidate();
        assertEquals(plaintext, this.ic.solve(keyCandidate, ciphertext));
    }
    
    @Test
    public void findKeyCornerCase() {
        this.freq.setAlphabet("", new double[1]);
        assertEquals(0, this.ic.findKey("", 1)[0].length);
    }
}
