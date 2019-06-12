/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import crypto.datastructures.HashTable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class facilitates statistical calculations that relate to n-grams i.e.
 * to substrings of a piece of text that are of length n.
 *
 * @author jpssilve
 */
public class Ngrams {

    private final int n;
    private long sampleSize;
    private HashTable<String, Long> ngramStats;

    /**
     *
     * @param n The desired n-gram substring length i.e. monogram is 1-gram and
     * is related to frequencies of single letter in a text, bigram (2-gram) is
     * related to frequencies of letter pairs in a text etc.
     */
    public Ngrams(int n) {
        this.n = n;
        this.sampleSize = 0;
        this.ngramStats = new HashTable<>();
    }

    public int getN() {
        return n;
    }

    public void readInputStream(InputStream stream) {
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(isr);

        try {
            String lineString = br.readLine();
            while (lineString != null) {
                String[] line = lineString.split(" ");
                if (line.length >= 2) {
                    long frequency = 0;
                    try {
                        frequency = Long.parseLong(line[1]);
                        this.ngramStats.hashInsert(line[0], frequency);
                        this.sampleSize += frequency;
                    } catch (NumberFormatException ne) {
                        System.err.println("The file is corrupted");
                    }
                }

                lineString = br.readLine();
            }
            System.out.println("File read successfully");
        } catch (IOException exc) {
            System.err.println("File not found");
        }
    }

    /**
     * Calculates the base 10 logarithm of a "probability" that is associated
     * with a particular n-gram. The "probability" is an empirical observation
     * of the count of the frequency the n-gram in the sample size divided by
     * the sample size.
     *
     * So the frequency of the n-gram is used as a substitute for a real
     * probability
     *
     * @param ngram A substring of a text that has a length of n and is in upper
     * case
     * @return The base 10 logarithm of the "probability" as a double
     */
    public double logProbability(String ngram) {
        long count = this.getNgramCount(ngram);
        double dblCount = (double) count;
        if (count == 0) {
            dblCount = 0.1;
        }
        double prob = dblCount / this.sampleSize;
        return Math.log10(prob);
    }

    /**
     * The total amount of n-grams in the sample size i.e. the sum of all n-gram
     * counts in the sample
     *
     * @return The sample size as a long value
     */
    public long getSampleSize() {
        return sampleSize;
    }

    /**
     * Retrieves the particular count of occurrences of the n-gram in the
     * sample.
     *
     * @param ngram A substring of a text that has a length of n and is in upper
     * case
     * @return The count of occurrences of this n-gram in the sample
     */
    public long getNgramCount(String ngram) {
        return this.ngramStats.getOrDefault(ngram, 0l);
    }

    /**
     * Calculates the base 10 logarithm of the product of all the n-gram
     * "probabilities" in a given text.
     *
     * The higher the value the more likely it is to be a valid English language
     * text sample. Since probabilities are smaller than zero the fitness value
     * is always smaller or equal to zero
     *
     * @param text The text (in upper case) that is to be assessed
     * @return The "fitness" of the text as a double value, the higher the value
     * the better.
     */
    public double fitness(String text) {
        if (text.length() < this.n) {
            return Double.NEGATIVE_INFINITY;
        }

        double logProbSum = 0;
        int i = 0;
        while (i + this.n <= text.length()) {
            logProbSum += logProbability(text.substring(i, i + this.n));
            i++;
        }

        return logProbSum;
    }
}
