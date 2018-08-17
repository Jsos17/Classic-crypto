/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author jpssilve
 */
public abstract class Ngrams {

    private final int n;
    private final String filename;
    private long sampleSize;
    private final HashMap<String, Long> ngramStats;

    public Ngrams(int n, String filename) {
        this.n = n;
        this.filename = filename;
        this.sampleSize = 0;
        this.ngramStats = new HashMap<>();
        readFile();
    }

    public int getN() {
        return n;
    }

    private long readFile() {
        try (Scanner scanner = new Scanner(new File(this.filename))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                if (line.length >= 2) {
                    long frequency = 0;
                    try {
                        frequency = Long.parseLong(line[1]);
                    } catch (NumberFormatException ne) {
                        System.out.println("The file is corrupted: " + ne);
                    }

                    this.ngramStats.put(line[0], frequency);
                    this.sampleSize += frequency;
                }
            }
        } catch (FileNotFoundException exc) {
            System.out.println(exc);
        }

        return this.sampleSize;
    }

    public double logProbability(String ngram) {
        long count = this.getNgramCount(ngram);
        double dblCount = (double) count;
        if (count == 0) {
            dblCount = 0.1;
        }
        double prob = dblCount / this.sampleSize;
        return Math.log10(prob);
    }

    public long getSampleSize() {
        return sampleSize;
    }

    public long getNgramCount(String ngram) {
        return this.ngramStats.getOrDefault(ngram, 0l);
    }

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
