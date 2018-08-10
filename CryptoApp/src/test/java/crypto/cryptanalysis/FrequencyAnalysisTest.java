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
public class FrequencyAnalysisTest {

    private FrequencyAnalysis freq;

    @Before
    public void setUp() {
        this.freq = new FrequencyAnalysis();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getterTest1() {
        double[] expected = new double[]{0.08167, 0.01492, 0.02782, 0.04253, 0.12702,
            0.02228, 0.02015, 0.06094, 0.06966, 0.00153,
            0.00772, 0.04025, 0.02406, 0.06749, 0.07507,
            0.01929, 0.00095, 0.05987, 0.06327, 0.09056,
            0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074};
        double[] actual = this.freq.getExpectedLetterFrequencies();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i], 0.00001);
        }
    }

    @Test
    public void getterTest2() {
        assertEquals("abcdefghijklmnopqrstuvwxyz", this.freq.getAlphabet());
    }

    @Test
    public void setAlphabetTest1() {
        FrequencyAnalysis freq2 = new FrequencyAnalysis();
        double[] newFreqs = new double[]{0.05, 0.04, 0.20, 0.15, 0.06, 0.10, 0.10, 0.09, 0.11, 0.03, 0.07};
        String newAlphabet = "äöåqwertyui";
        freq2.setAlphabet(newAlphabet, newFreqs);
        double[] actual = freq2.getExpectedLetterFrequencies();
        for (int i = 0; i < newFreqs.length; i++) {
            assertEquals(newFreqs[i], actual[i], 0.001);
        }

        assertEquals(newAlphabet, freq2.getAlphabet());
    }

    /*
    The sites
    https://www.mtholyoke.edu/courses/quenell/s2003/ma139/js/count.html
    and
    http://www.characterfrequencyanalyzer.com/english/index.php
    
    were used to provide correct values for every countOccurrencesTest 
    (checking that both sites produced same values) 
    which were then inputted by hand to the counts-array.
    Note that the latter site omits missing characters from its listing.
    */
    @Test
    public void countOccurrencesTest1() {
        String text = "a much more efficient method is the euclidean algorithm, which uses a division algorithm "
                + "such as long division in combination with the observation that the gcd of two numbers also "
                + "divides their difference. to compute gcd(48,18), divide 48 by 18 to get a quotient of 2 and a remainder of 12. "
                + "then divide 18 by 12 to get a quotient of 1 and a remainder of 6";
        int[] counts = new int[]{18, 5, 10, 17, 29, 9, 7, 14, 30, 0, 0, 5, 10,
            18, 24, 1, 2, 11, 11, 25, 8, 6, 3, 0, 2, 0};
        for (int i = 0; i < counts.length; i++) {
            assertEquals(counts[i], this.freq.countOccurrences(text)[i]);
        }
    }

    @Test
    public void countOccurrencesTest2() {
        String text = "depending on the language and its implementation, primitive data types may or may not have "
                + "a one-to-one correspondence with objects in the computer's memory. however, one usually expects "
                + "operations on basic primitive data types to be the fastest language constructs there are";
        int[] counts = new int[]{19, 3, 8, 6, 33, 1, 5, 7, 14, 1, 0, 5, 9, 18,
            19, 10, 0, 12, 14, 25, 6, 4, 2, 1, 6, 0};
        for (int i = 0; i < counts.length; i++) {
            assertEquals(counts[i], this.freq.countOccurrences(text)[i]);
        }
    }

    @Test
    public void countOccurrencesTest3() {
        String text = "there are 3,815 known exoplanets, or planets outside our solar system that orbit a star, "
                + "as of august 1, 2018; only a small fraction of these are located in the vicinity of the solar system."
                + "[2] within 10 parsecs (32.6 light-years), there are 56 exoplanets listed as confirmed by the nasa "
                + "exoplanet archive.[a][3] among the over 400 known stars within 10 parsecs,[b][4] 26 have been confirmed "
                + "to have planetary systems; 51 stars in this range are visible to the naked eye,[c][5] eight of which "
                + "have planetary systems.the first report of an exoplanet within this range was in 1998 for a planet "
                + "orbiting around gliese 876 (15.3 light-years (ly) away), and the latest as of 2017 is one around "
                + "ross 128 (11 ly). the closest exoplanet found is proxima centauri b, which was confirmed in 2016 "
                + "to orbit proxima centauri, the closest star to our solar system (4.25 ly). hd 219134 (21.6 ly) "
                + "has six exoplanets, the highest number discovered for any star within this range. a planet around "
                + "fomalhaut (25 ly) was, in 2008, the first planet to be directly imaged.[6]most known nearby exoplanets "
                + "orbit close to their star and have highly eccentric orbits. a majority are significantly larger than "
                + "earth, but a few have similar masses, including two planets (around yz ceti, 12 ly) which may be less "
                + "massive than earth. several confirmed exoplanets are hypothesized to be potentially habitable, with "
                + "proxima centauri b and three around gliese 667 c (23.6 ly) considered the most likely candidates.[7] "
                + "the international astronomical union took a public survey in 2015 about renaming some known extrasolar "
                + "bodies, including the planets around epsilon eridani (10.5 ly) and fomalhaut";
        int[] counts = new int[]{123, 22, 34, 33, 137, 20, 19, 58, 91, 1, 7, 62, 28,
            90, 85, 26, 0, 82, 93, 114, 25, 13, 18, 13, 34, 2};
        for (int i = 0; i < counts.length; i++) {
            assertEquals(counts[i], this.freq.countOccurrences(text)[i]);
        }
    }
}
