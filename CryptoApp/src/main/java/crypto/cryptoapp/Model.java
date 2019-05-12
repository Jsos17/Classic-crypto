package crypto.cryptoapp;

import crypto.ciphers.AutokeyVigenereCipher;
import crypto.ciphers.KeyedVigenereCipher;
import crypto.ciphers.TranspositionCipher;
import crypto.ciphers.VigenereCipher;
import crypto.cryptanalysis.FrequencyAnalysis;
import crypto.cryptanalysis.HillClimber;
import crypto.cryptanalysis.IndexOfCoincidence;
import crypto.cryptanalysis.Ngrams;

/**
 *
 * @author jpssilve
 */
public class Model {

    private VigenereCipher vigenere;
    private KeyedVigenereCipher keyedVig;
    private AutokeyVigenereCipher autokeyVig;
    private TranspositionCipher transposition;
    private Ngrams quadgrams;
    private HillClimber hillClimber;
    private FrequencyAnalysis freq;
    private IndexOfCoincidence ic;

    public Model() {
        vigenere = new VigenereCipher();
        keyedVig = new KeyedVigenereCipher("");
        autokeyVig = new AutokeyVigenereCipher();
        transposition = new TranspositionCipher();

        quadgrams = new Ngrams(4);
        quadgrams.readInputStream(getClass().getResourceAsStream("/english_quadgrams.txt"));
        hillClimber = new HillClimber(quadgrams);
        freq = new FrequencyAnalysis();
        ic = new IndexOfCoincidence(freq);
    }

    public String encrypt(String encryptionMethod, String[] keys, String plaintext) {
        if (encryptionMethod.equals("Vigenere cipher")) {
            return vigenere.encrypt(keys[0], plaintext);
        } else if ((encryptionMethod.equals("Keyed Vigenere cipher"))) {
            return keyedVig.encrypt(keys[0], plaintext);
        } else if ((encryptionMethod.equals("Autokey Vigenere cipher"))) {
            return autokeyVig.encrypt(keys[0], plaintext);
        } else if ((encryptionMethod.equals("Single columnar transposition cipher"))) {
            return transposition.encryptSingleTransposition(keys[0], plaintext);
        } else {
            return transposition.encryptDoubleTransposition(keys[0], keys[1], plaintext);
        }
    }

    public String decrypt(String encryptionMethod, String[] keys, String ciphertext) {
        if (encryptionMethod.equals("Vig")) {
            return vigenere.decrypt(keys[0], ciphertext);
        } else if ((encryptionMethod.equals("KeyedVig"))) {
            return keyedVig.decrypt(keys[0], ciphertext);
        } else if ((encryptionMethod.equals("Autokey"))) {
            return autokeyVig.decrypt(keys[0], ciphertext);
        } else if ((encryptionMethod.equals("SingleTransp"))) {
            return transposition.decryptSingleTransposition(keys[0], ciphertext);
        } else {
            return transposition.decryptDoubleTransposition(keys[0], keys[1], ciphertext);
        }
    }
}
