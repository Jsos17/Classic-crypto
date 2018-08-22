/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author jpssilve
 */
public class NgramsTest {

    /*
    The following code adapted from (initialization and three methods) found in
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

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    private File testFile;
    private Ngrams ngrams;

    @Before
    public void setUp() throws Exception {
        this.testFile = testFolder.newFile("test_ngram.txt");
        try (FileWriter file = new FileWriter(this.testFile.getAbsolutePath())) {
            file.write("THET 3597105\nHEIR 2630839\nTOBE 1850003\nTHRO 1239338");

        }
        this.ngrams = new Quadgrams(this.testFile.getAbsolutePath());
    }

    @After
    public void tearDown() {
        testFile.delete();
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
        File testFile2 = testFolder.newFile("test_2.txt");
        try (FileWriter file = new FileWriter(testFile2.getAbsolutePath())) {
            file.write("THET TEST\n");
        }

        Ngrams ngrams2 = new Quadgrams(testFile2.getAbsolutePath());
        assertEquals("The file is corrupted\n", errContent.toString());
        testFile2.delete();
    }

    @Test
    public void corruptedFileTest2() throws Exception {
        File testFile2 = testFolder.newFile("test_2.txt");
        try (FileWriter file = new FileWriter(testFile2.getAbsolutePath())) {
            file.write("THET\n");
        }

        Ngrams ngrams2 = new Quadgrams(testFile2.getAbsolutePath());
        assertEquals(0, ngrams2.getSampleSize());
        testFile2.delete();
    }

    @Test
    public void nonExistentFileTest() {
        Ngrams ngrams2 = new Quadgrams("test3.txt");
        assertEquals("File not found\n", errContent.toString());
    }

    @Test
    public void monoBiTrigramsTest1() {
        Monograms mono = new Monograms("english_monograms.txt");
        Bigrams bi = new Bigrams("english_bigrams.txt");
        Trigrams tri = new Trigrams("english_trigrams.txt");

        assertEquals(1, mono.getN());
        assertEquals(2, bi.getN());
        assertEquals(3, tri.getN());

        assertEquals(183996130l, mono.getNgramCount("L"));
        assertEquals(3920675l, bi.getNgramCount("GS"));
        assertEquals(3317738l, tri.getNgramCount("UGH"));
    }

}
