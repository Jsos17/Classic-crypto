/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author jpssilve
 */
public class NgramsTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    private File testFile;
    private Ngrams ngrams;
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
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
       assertTrue(this.ngrams.getNgramStats().get("THET").equals(3597105l));
   }
   
   @Test
   public void getNgramsTest2() {
       assertFalse(this.ngrams.getNgramStats().getOrDefault("THAT", 0l).equals(3597105l));
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
        assertEquals(0, (long) ngrams2.getNgramStats().get("THET"));
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
}