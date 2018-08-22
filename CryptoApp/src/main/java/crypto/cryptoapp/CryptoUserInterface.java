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
import crypto.cryptanalysis.Quadgrams;
import crypto.cryptanalysis.Combinatorics;
import crypto.cryptanalysis.TranspositionAttack;
import crypto.datastructures.HashTable;
import crypto.helpers.GreatestCommonDivisor;
import crypto.sorting.GenericTypeSort;
import crypto.sorting.PrimitiveTypeSort;
import java.util.ArrayList;
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
//        FrequencyAnalysis freq = new FrequencyAnalysis();
//        double[] expFreq = freq.getExpectedLetterFrequencies();
//        double sum = 0;
//        for (int i = 0; i < expFreq.length; i++) {
//            sum += expFreq[i];
//        }
//
//        System.out.println(sum);
//
//        double sum_pow2 = 0;
//        for (int i = 0; i < expFreq.length; i++) {
//            sum_pow2 += expFreq[i] * expFreq[i];
//        }
//
//        double expectedIC = 26 * sum_pow2;
//        System.out.println(expectedIC);
//        IndexOfCoincidence ic = new IndexOfCoincidence(freq);
//        String ciphertext1 = "QPWKALVRXCQZIKGRBPFAEOMFLJMSDZVDHXCXJYEBIMTRQWNMEAIZRVKCVKVLXNEICFZPZCZZHKMLVZVZIZRRQWDKECHOSNYXXLSPMYKVQXJTDCIOMEEXDQVSRXLRLKZHOV".toLowerCase();
//        System.out.println(ciphertext1);

//        double[] deltas = ic.allAggregateDeltaBarICs(ciphertext1);
//        for (int i = 0; i < 20; i++) {
//            System.out.print((i + 1) + " | ");
//            System.out.printf("%.2f %n", deltas[i]);
//        }
//
//        ic.findKey(ciphertext1, 5);
//        ic.solve(ic.getKeyCandidate(), ciphertext1);
//        System.out.println(ic.getKeyCandidate());
//        String ciphertext2 = "vptnvffuntshtarptymjwzirappljmhhqvsubwlzzygvtyitarptyiougxiuydtgzhhvvmum"
//                + "shwkzgstfmekvmpkswdgbilvjljmglmjfqwioiivknulvvfemioiemojtywdsajtwmtcgluy"
//                + "sdsumfbieugmvalvxkjduetukatymvkqzhvqvgvptytjwwldyeevquhlulwpkt";
//        double[] deltas2 = ic.allAggregateDeltaBarICs(ciphertext2);
//        for (int i = 0; i < deltas2.length; i++) {
//            System.out.print((i + 1) + " | ");
//            System.out.printf("%.2f %n", deltas2[i]);
//        }
//
////        CharacterValue[][] charValues = ic.findKey(ciphertext2, 7);
////        for (int j = 0; j < charValues[0].length; j++) {
////            for (int i = 0; i < charValues.length; i++) {
////                System.out.print(charValues[i][j].getCharacter());
////            }
////            System.out.println();
////        }
//        System.out.println(ic.solve(ic.getKeyCandidate(), ciphertext2));
//        ic.findKey(ciphertext2, 14);
//        System.out.println(ic.solve(ic.getKeyCandidate(), ciphertext2));     
//        System.out.println(ic.solve("ciphers", ciphertext2));
//        int[] nums1 = new int[]{5, 4, 2, 1, 9, 8, 6};
//        PrimitiveTypeSort.iterativeMergeSort(nums1);
//        System.out.println(Arrays.toString(nums1));
//        long[] numbas = new long[10];
//        for (int i = 0; i< numbas.length; i++) {
//            numbas[i] = Long.MAX_VALUE;
//        }
//        PrimitiveTypeSort.iterativeMergeSort(numbas);
//        System.out.println(Arrays.toString(numbas));
//        
//        long[] numbas2 = new long[]{1l};
//        PrimitiveTypeSort.iterativeMergeSort(numbas2);
//        System.out.println(Arrays.toString(numbas2));
//        
//        Integer[] nums2 = new Integer[]{5, 4, 2, 1, 9, 8, 6};
//        GenericTypeSort.iterativeMergeSort(nums2);
//        System.out.println(Arrays.toString(nums2));
//        
//        System.out.println(3 ^ 2);
        String text = "unczqztxeubjfxutwaqbroiromeimcjsmgxqrqmbuiblcpvgijtkzzrtxaelljmfhcuwglqrculnrkpcybvgglcytrxfetpvglqpnhqaxqxvdqypmlyhgffqtthvfjarollvrfovomfeyenlbgidipaprgupjlzgijthvzvretcukrmranswpggrtlvpieohaprpqtvlzrxgrppvgsfhgsmgxqrzhkvttetamkxyeuzitioopaivruniuczidowzqawfapjmfsrtjltrxfeteebyxdubotietvvipvkpvhvnpksvapnxjrgwzrwqnvzmglqbczqpyeeqmneicuguklezanfavwusvvnvvetevcaxfhgmzrugepjgbjoiromexqxvsmgxqruhvqxtephafsoicamtyqsullcpmipamkxxevamewiivobuiymqymkwunvompmbhgybrbftjhvnrktjpvtixsgzctkqsvzbuefxevzeiepqulfxaekubuiblcpvgijtdbbgluskzvbxoetaivrfapkinvqanzwiidyevuzsziplvtpusjzwkqugjajriutjlzbjfhgtiywaivpahrximltlxabghxyeunvlfgdarsdpvgtatltrwecqtubrfhwzbuiorawbnrmlazbzekngllgsfrazmiidanjwzfuncaqbreohtictunizjrxiegukvttetamkxmnfwtnmztgebyiftgya";
//        SubSequencePrinter.printSubSequences(text, 7);

//        String text = "bevqqfharxuhjcgszvulreljdfgywkpvtpgygnwtvqelnzkhzckhqthrfmhipgaytlgtzipvmnajncvkzjdhhyvnhhqbkmonxdpneanqpfncodkyasieyenznktepydxpduoncljbdxvqctcrrotbnwdaaydmixysfmizucskbykoaoksymscdzytnvaomqotoanswdjrmlwbfrxgabfgvufbrlrnkxhjccjctzbjbjqkjoogpsdonfkfftoiyrpfpuxztdpmeezoeqfrvxyafxgtkhcouehrjsvyfnfetvncdnnxjxsekxeodxupxyvioimpuxucsofmrdysixggpvimyrjfyofrtqdcarnxavmybahlixvnwilujfpmqyrmaytgedcocescdtznafpuagyfuqukefjxrzlzodqehyqsiyzrxpyazzaknkyjrmhfkiotpjbtkhhbzcxuxckkwbbnactcbubfhwvhqfkzrqiqoqlnecjhcpnnqlwwdbjswa"
//                + "qfkzrqiqoqlnecjhcpnnqlwwdbjswa";
//        ArrayList<Integer> indexes = new ArrayList<>();
//        double[] deltas3 = ic.allAggregateDeltaBarICs(text);
//        for (int i = 0; i < deltas3.length; i++) {
//            if (deltas3[i] > 1.40) {
//                System.out.print((i + 1) + " | ");
//                System.out.printf("%.2f %n", deltas3[i]);
//                indexes.add((i+1));
//            }
//            
//        }
//        
//        ArrayList<Integer> keyLens = new ArrayList<>();
//        ic.findKey(text, 2);
//        System.out.println(ic.getKeyCandidate());
//        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
//        for (int i = 0; i < indexes.size(); i++) {
//            for (int j = i + 1; j < indexes.size(); j++) {
//                System.out.println(indexes.get(i) + " and " + indexes.get(j));
//                int common = gcd.euclidIterative(indexes.get(i), indexes.get(j));
//                System.out.println(common);
//                keyLens.add(common);
//            }
//        }
//        
//        for (int i = 0; i < keyLens.size(); i++) {
//            ic.findKey(text, keyLens.get(i));
//            System.out.println(ic.getKeyCandidate());
//        }
//        double[] vals = ic.allAggregateDeltaBarICs(text);
//        for (int i = 0; i < 10; i++) {
//            System.out.print((i + 1) + " | ");
//            System.out.println(vals[i]);
//        }
//        ic.findKey(text, 7);
//        System.out.println(ic.getKeyCandidate());
//        CharacterValue[][] charValues = ic.findKey(text, 7);
//        for (int j = 0; j < charValues[0].length; j++) {
//            for (int i = 0; i < charValues.length; i++) {
//                System.out.print(charValues[i][j].getCharacter() + " ");
//            }
//            System.out.println();
//        }
//        ArrayList<String> subs = new ArrayList<>();
//        subs.add("uxuomqbjxfqkgfqqmqafydujergeqgfqtyoudfrfxekkjqqeczuefgoqqtoqmxiyubfkxqfeabjuofqdzuuufaxauatefomkfdueuitmzf");
//        subs.add("neticrltahrplepxltroeipttarotrhreeonoatedtpsrnbeuastheixreisieimnhttssxpeltseaayisgthiibnrachrlnranoneentt");
//        subs.add("cuwrjqckecccctnvytovnpjhcnthvpgztupiwpjtuvvvgvcqgnvegprvupcupvvqvgjjgveqkcdktpnepjjjgvmgvstqwaaganchigtfgg");
//        subs.add("zbaosmpzluuyyphdhhlolalvuslalpshazauzjlebvhawzzmufvvmjoshhalaaoyoyhpzzvuupbzakzvlzaltplhldltzwzlzjatzuawey");
//        subs.add("qjqmmbvzlwlbtvqqgvlmbpzzkwvpzvmkmiicqmteoivpzmqnkanczgmmvamlmmbmmbvvcbzlbvbviiwuvwjziatxfptubbblmwqijkmtba");
//        subs.add("zfbegugrjgnvrgayffvfgrgvrpprrggvktvzafrbtpnnrgpelvvarbegqftckeukprnttuefuggbvniztkrbyhlygvrbunzgizbcrvkny");
//        subs.add("txrixiitmlrgxlxpfjreigirmgipxsxtxiriwsxyivpxwlyiewvxujxxxsypxwiwmbrikeixiilxrvispqijwrxedgwriresifrtxtxmi");
//        VigenereCipher vig = new VigenereCipher();
//        String abc = "abcdefghijklmnopqrstuvwxyz";
//        for (int i = 0; i < abc.length(); i++) {
//            long[] occurrences = freq.countOccurrences(vig.decrypt(abc.substring(i, i + 1), subT));
//            System.out.println(Arrays.toString(occurrences));
//        }
//        quad.
//        System.out.println(quad.getNgramCount("INGT"));
//        System.out.println(quad.getSampleSize());
//        System.out.println(quad.logProbability("INGT"));
//        System.out.println(6461147l / 4224127912l);
//        String text2 = "ATTACKTHEEASTWALLOFTHECASTLEATDAWN";
//        System.out.println(text2.length());
//        String ciphertext2 = "FYYFHPYMJJFXYBFQQTKYMJHFXYQJFYIFBS";
//        System.out.println(quad.fitness(text2));
//        System.out.println(quad.fitness(ciphertext2));
//        System.out.println(quad.getN());
//        
//        Quadgrams quad2 = new Quadgrams("test.txt");
//        System.out.println(quad2.getSampleSize());
//        System.out.println(quad2.getNgramCount("INGT"));
//        System.out.println(quad2.getNgramCount("MATT"));
//        System.out.println(quad2.fitness(text2));
//        System.out.println(quad.fitness(text2));
//        System.out.println(quad.fitness(ciphertext2));
//       
//        Combinatorics comib = new Combinatorics();
//        
//        int[] nums = new int[25];
//        nums[4] = 2;
//        System.out.println(nums.length);
//        System.out.println(nums[4]);
//        
//        nums = new int[0];
//        System.out.println(nums.length);
//        System.out.println(nums[4]);
//        TranspositionAttack attack = new TranspositionAttack();
//
//        String text1 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text2 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text3 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text4 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text5 = "evlnacdtesearofodeecwiree".toUpperCase();
//        String text6 = "evlnacdtesearofodeecwiree".toUpperCase();
//
//        long startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text1);
//        long endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text2);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text3);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text4);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text5);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        startTime = System.currentTimeMillis();
//        attack.attackShortKeyWordsPreGenerated(text6);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        System.out.println(attack.crackWithKey(cand, text1));
//
//        startTime = System.currentTimeMillis();
//        String candi = attack.attackShortKeyWordsPreGenerated(text1);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//
//        System.out.println(attack.crackWithKey(candi, text1));
//
//        String ciphertext = "QDBSSAGNTDOLLCSERUELAESTOSIOODDUYSANUFRISUIUHARRGAE"
//                + "MLULANORSARCROSMEPDVNUXVSTBCNAFNTIWUZUFIITEISDMOENSEYINUMDIAITACEEHECCC";
//        startTime = System.currentTimeMillis();
//        String cand2 = attack.attackShortKeyWordsPreGenerated(ciphertext);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        System.out.println(attack.crackWithKey(cand2, ciphertext));
//
//        String ciphertext1 = "NSTLEICYEMPMHELGOAAHVCOTBYAAAESEAWAMNERTATHOPFTMZDHAISAALITSUOOAZNSREMSEAVTLETYGUAEGREERNIUAKRNRPSMS";
//
//        startTime = System.currentTimeMillis();
//        String cand3 = attack.attackShortKeyWordsPreGenerated(ciphertext1);
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        System.out.println(attack.crackWithKey(cand3, ciphertext1));
//        String text2 = "hmnrnvaicwhtsieiitoawguseint".toUpperCase();
//        String cand2 = attack.attackShortKeyWordsPreGenerated(text2);
//        System.out.println(attack.crackWithKey(cand2, text2));
//        int[] table = new int[]{0, 2, 1, 4};
//        byte x = 1;
//        System.out.println(table[x]);
//
//        int[] table2 = table;
//        System.out.println(table2.length);
//        
//        HashTable ht = new HashTable();
        int n = 5;
        long[] times = new long[n];

        long startTime = System.currentTimeMillis();
        Quadgrams quad1 = new Quadgrams("english_quadgrams.txt");
        long endTime = System.currentTimeMillis();
        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
        times[0] = endTime - startTime;

        long sum = 0;
        int count = 0;
        int longest = 0;
        for (int i = 0; i < quad1.ngramStats.hashtable.length; i++) {
            if (quad1.ngramStats.hashtable[i] != null) {
                int l = quad1.ngramStats.hashtable[i].getSize();
                if (l > longest) {
                    longest = l;
                }
                sum += l;
                count++;
            }
        }

        System.out.println("Longest: " + longest);
        System.out.println(sum);
        System.out.println(count);
        System.out.println((double) sum / count);

//        startTime = System.currentTimeMillis();
//        Quadgrams quad2 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[1] = endTime - startTime;
//
//        startTime = System.currentTimeMillis();
//        Quadgrams quad3 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[2] = endTime - startTime;
//
//        startTime = System.currentTimeMillis();
//        Quadgrams quad4 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[3] = endTime - startTime;
//
//        startTime = System.currentTimeMillis();
//        Quadgrams quad5 = new Quadgrams("english_quadgrams.txt");
//        endTime = System.currentTimeMillis();
//        System.out.println("Operaatioon kului aikaa: " + (endTime - startTime) + "ms.");
//        times[4] = endTime - startTime;
//
//        double avg = 0;
//        for (int i = 0; i < n; i++) {
//            avg += (double) times[i] / n;
//        }
//
//        System.out.println(avg + " ms");
    }
}
