/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class NgramsTest {

    /*
    The following code adapted from (initialization and three methods)
    https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
     */
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setErr(originalErr);
    }

    private Ngrams ngrams;

    @Before
    public void setUp() throws Exception {
        String str = "THET 3597105\nHEIR 2630839\nTOBE 1850003\nTHRO 1239338";
        byte[] bytes = str.getBytes("UTF-8");
        this.ngrams = new Ngrams(4);
        this.ngrams.readInputStream(new ByteArrayInputStream(bytes));
    }

    @Test
    public void getNTest() {
        assertEquals(4, this.ngrams.getN());
    }

    @Test
    public void getSampleSizeTest1() {
        assertEquals(9317285, this.ngrams.getSampleSize());
    }

    @Test
    public void getNgramsTest1() {
        assertEquals(3597105l, this.ngrams.getNgramCount("THET"));
    }

    @Test
    public void getNgramsTest2() {
        assertFalse(this.ngrams.getNgramCount("THAT") == 3597105l);
    }

    @Test
    public void logProbabilityTest1() {
        assertEquals(-0.876099614, this.ngrams.logProbability("THRO"), 0.00001);
    }

    @Test
    public void logProbabilityTest2() {
        assertEquals(-7.96928938, this.ngrams.logProbability("ALGO"), 0.00001);
    }

    @Test
    public void logProbabilityTest3() {
        assertEquals(-0.7021169474, this.ngrams.logProbability("TOBE"), 0.00001);
    }

    @Test
    public void fitnessTest1() {
        assertEquals(-326.7408646, this.ngrams.fitness("ANAGRAMSAREINTHEMSELVESARECREATIONALACTIVITY"), 0.001);
    }

    @Test
    public void fitnessTest2() {
        assertEquals(-89.0874779, this.ngrams.fitness("THROUGHTHEIRWILL"), 0.001);
    }

    @Test
    public void fitnessTest3() {
        assertTrue(Double.isInfinite(this.ngrams.fitness("THE")));
    }

    @Test
    public void corruptedFileTest1() throws Exception {
        String str = "THET TEST\n";
        byte[] bytes = str.getBytes("UTF-8");

        Ngrams ngrams2 = new Ngrams(4);
        ngrams2.readInputStream(new ByteArrayInputStream(bytes));
        assertEquals("The file is corrupted\n", errContent.toString());
    }

    @Test
    public void corruptedFileTest2() throws Exception {
        String str = "THET TEST\n";
        byte[] bytes = str.getBytes("UTF-8");

        Ngrams ngrams2 = new Ngrams(4);
        ngrams2.readInputStream(new ByteArrayInputStream(bytes));
        assertEquals(0, ngrams2.getSampleSize());
    }

    @Test
    public void monoBiTrigramsTest1() {
        Ngrams mono = new Ngrams(1);
        mono.readInputStream(getClass().getResourceAsStream("/english_monograms.txt"));
        Ngrams bi = new Ngrams(2);
        bi.readInputStream(getClass().getResourceAsStream("/english_bigrams.txt"));
        Ngrams tri = new Ngrams(3);
        tri.readInputStream(getClass().getResourceAsStream("/english_trigrams.txt"));

        assertEquals(1, mono.getN());
        assertEquals(2, bi.getN());
        assertEquals(3, tri.getN());

        assertEquals(183996130l, mono.getNgramCount("L"));
        assertEquals(3920675l, bi.getNgramCount("GS"));
        assertEquals(3317738l, tri.getNgramCount("UGH"));
    }

}
