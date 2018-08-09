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
import crypto.cryptanalysis.FrequencyAnalysis;
import crypto.cryptanalysis.IndexOfCoincidence;

/**
 *
 * @author jpssilve
 */
public class CryptoUserInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        KeyedVigenereCipher kvig = new KeyedVigenereCipher("kryptos");
//        System.out.println(kvig.decrypt("Palimpsest", "EMUFPHZLRFAXYUSDJKZLDKRNSHGNFIVJYQTQUXQBQVYUVLLTREVJYQTMKYRDMFD"));
//        System.out.println(kvig.decrypt("Abscissa", "VFPJUDEEHZWETZYVGWHKKQETGFQJNCE"
//                + "GGWHKKDQMCPFQZDQMMIAGPFXHQRLG"
//                + "TIMVMZJANQLVKQEDAGDVFRPJUNGEUNA"
//                + "QZGZLECGYUXUEENJTBJLBQCRTBJDFHRR"
//                + "YIZETKZEMVDUFKSJHKFWHKUWQLSZFTI"
//                + "HHDDDUVHDWKBFUFPWNTDFIYCUQZERE"
//                + "EVLDKFEZMOQQJLTTUGSYQPFEUNLAVIDX"
//                + "FLGGTEZFKZBSFDQVGOGIPUFXHHDRKF"
//                + "FHQNTGPUAECNUVPDJMQCLQUMUNEDFQ"
//                + "ELZZVRRGKFFVOEEXBDMVPNFQXEZLGRE"
//                + "DNQFMPNZGLFLPMRJQYALMGNUVPDXVKP"
//                + "DQUMEBEDMHDAFMJGZNUPLGEWJLLAETG"));
//
//        VigenereCipher vigenere = new VigenereCipher();
//        System.out.println(vigenere.encrypt("LEMON", "ATTACKATDAWN"));
//        System.out.println(vigenere.decrypt("LEMON", "LXFOPVEFRNHR"));
//        System.out.println(vigenere.encrypt("l", "ATTACKATDAWN"));
//        System.out.println(vigenere.encrypt("LEMON", "ATTöäACKATDAWN"));
//        System.out.println(vigenere.decrypt("LEMON", "lxfonlgwogoeib"));
//        System.out.println(vigenere.decrypt("LEMON", "LXFöOäPVEFRNHR"));
//        System.out.println(vigenere.decrypt("LEMON", "LXFaOaPVEFRNHR"));
//        System.out.println(vigenere.decrypt("Palimpsest", "EMUFPHZLRFAXYUSDJKZLDKRNSHGNFIVJYQTQUXQBQVYUVLLTREVJYQTMKYRDMFD"));
//        System.out.println(vigenere.encrypt("aertyuiopwkjfllsjdsfgs", "ATTACKATDAWN"));
//        System.out.println(vigenere.decrypt("LEMON", "LEMON"));
////        for (int i = 0; i < 53; i++) {
////            System.out.println(-i % 26);
////        }
//
//        char[] nothing = new char[10];
//        System.out.println(nothing[0] == '\u0000');
//
//        TranspositionCipher dt = new TranspositionCipher();
//        System.out.println(dt.encryptSingleTransposition("zebras", "wearediscoveredfleeatonce"));
//        System.out.println(dt.decryptSingleTransposition("nsaciakgb", "tämektiiinenmäal"));
//        System.out.println(dt.encryptDoubleTransposition("lorenz", "enigma", "KeinebesonderenEreignisse"));
//        System.out.println(dt.encryptDoubleTransposition("lorenz", "enigma", "Claude Shannon proved, using information theory considerations, that any theoretically unbreakable cipher must have keys which are at least as long as the plaintext, and used only once: one-time pad."));
//        System.out.println(dt.encryptSingleTransposition("", "wearediscoveredfleeatonce"));
////        System.out.println(dt.encryptDoubleTransposition("zebras", "stripe", "wearediscoveredfleeatonce"));
////        System.out.println(dt.decryptDoubleTransposition("zebras", "stripe", "caeensoiaedrlefwedreevtoc"));
//
//        AutokeyVigenereCipher autokey = new AutokeyVigenereCipher();
//        System.out.println(autokey.encrypt("bombe", "akeyweaknessofthesystemhoweveristhattheplaintextispartofthekeythismeansthatthekeywilllikelycontaincommonwordsatvariouspointsthekeycanbeattackedbyusingadictionaryofcommonwordsbigramstrigramsandsoforthandattemptingthedecryptionofthemessagebymovingthatwordthroughthekeyuntilpotentiallyreadabletextappears"));
//        System.out.println(autokey.decrypt("queenly", "qnxepvytwtwp"));
//        System.out.println(autokey.decrypt("queenly", "siqqhygeofuiajtetsrbxemskokwlalhpoakw"));
//        System.out.println(autokey.decrypt("lemon", "lyfc"));
//        System.out.println(autokey.decrypt("x", "xunh"));
////        System.out.println("abc".substring(1, 1));
//        System.out.println(vigenere.decrypt("", "ATTACKATDAWN"));
//        System.out.println(vigenere.encrypt("fire", "turingtestenigmamachinebabbagekasiskibombebletchleypark"));
        
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
//        System.out.println(ic.deltaBarIC(ciphertext1));
//        System.out.println(ciphertext1);
//        System.out.println(ic.deltaBarIC("qwavxqigbfemlmdvhcjeitqneirkvvxeczzzhmvvirqdehsyxsmkqjdimedvrllzo"));
        
        double[] deltas = ic.allDeltaBarICs(ciphertext1);
//        for (int i = 0; i < 20; i++) {
//            System.out.print((i+1) + " | ");
//            System.out.printf("%.2f %n", deltas[i]);
//        }
        
        System.out.println(ic.findKey(ciphertext1, 5));
        System.out.println(ic.solve(ic.findKey(ciphertext1, 5), ciphertext1));
    }

}
