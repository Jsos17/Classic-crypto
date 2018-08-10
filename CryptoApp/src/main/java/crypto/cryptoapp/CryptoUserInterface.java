/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptoapp;

import crypto.ciphers.AutokeyVigenereCipher;
import crypto.ciphers.TranspositionCipher;
import crypto.ciphers.KeyedVigenereCipher;
import crypto.ciphers.VigenereCipher;
import crypto.cryptanalysis.CharacterValue;
import crypto.cryptanalysis.FrequencyAnalysis;
import crypto.cryptanalysis.IndexOfCoincidence;
import crypto.helpers.GreatestCommonDivisor;
import java.util.Arrays;

/**
 *
 * @author jpssilve
 */
public class CryptoUserInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrequencyAnalysis freq = new FrequencyAnalysis();
        double[] expFreq = freq.getExpectedLetterFrequencies();
        double sum = 0;
        for (int i = 0; i < expFreq.length; i++) {
            sum += expFreq[i];
        }

        System.out.println(sum);

        double sum_pow2 = 0;
        for (int i = 0; i < expFreq.length; i++) {
            sum_pow2 += expFreq[i] * expFreq[i];
        }

        double expectedIC = 26 * sum_pow2;
        System.out.println(expectedIC);
        IndexOfCoincidence ic = new IndexOfCoincidence(freq);
        String ciphertext1 = "QPWKALVRXCQZIKGRBPFAEOMFLJMSDZVDHXCXJYEBIMTRQWNMEAIZRVKCVKVLXNEICFZPZCZZHKMLVZVZIZRRQWDKECHOSNYXXLSPMYKVQXJTDCIOMEEXDQVSRXLRLKZHOV".toLowerCase();
        System.out.println(ciphertext1);

        double[] deltas = ic.allDeltaBarICs(ciphertext1);
        for (int i = 0; i < 20; i++) {
            System.out.print((i + 1) + " | ");
            System.out.printf("%.2f %n", deltas[i]);
        }

        ic.findKey(ciphertext1, 5);
        ic.solve(ic.getKeyCandidate(), ciphertext1);

        String ciphertext2 = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmum"
                + "shwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluy"
                + "sdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
        double[] deltas2 = ic.allDeltaBarICs(ciphertext2);
        for (int i = 0; i < 20; i++) {
            System.out.print((i + 1) + " | ");
            System.out.printf("%.2f %n", deltas2[i]);
        }

        CharacterValue[][] charValues = ic.findKey(ciphertext2, 7);
        for (int j = 0; j < charValues[0].length; j++) {
            for (int i = 0; i < charValues.length; i++) {
                System.out.print(charValues[i][j].getCharacter());
            }
            System.out.println();
        }
        System.out.println(ic.solve(ic.getKeyCandidate(), ciphertext2));
        ic.findKey(ciphertext2, 14);
        System.out.println(ic.solve(ic.getKeyCandidate(), ciphertext2));
//        
        System.out.println(ic.solve("ciphers", ciphertext2));
        
        CharacterValue cv1 = new CharacterValue('a', 3.0);
        CharacterValue cv2 = new CharacterValue('a', 1.0);
        CharacterValue cv3 = new CharacterValue('a', 1.0);
        System.out.println(cv1.compareTo(cv2));
        System.out.println(cv2.compareTo(cv3));
        System.out.println(cv2.compareTo(cv1));
        
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.euclidRecursive(5792659652l, 639220529486l));
        System.out.println(gcd.euclidIterative(5792659652l, 639220529486l));
        Arrays.sort(new int[10]);
    }

}
