/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import crypto.helpers.CharIndexPair;
import crypto.sorting.GenericTypeSort;

/**
 * The class implements a columnar transposition cipher. Both single and double
 * transposition encryption and decryption is available. Double transposition is
 * simply columnar transposition applied twice in a row.
 *
 * @author jpssilve
 */
public class TranspositionCipher {

    /**
     * The constructor takes no parameters
     */
    public TranspositionCipher() {

    }

    private CharIndexPair[] orderOfKey(String key) {
        CharIndexPair[] charIdxPairs = new CharIndexPair[key.length()];

        for (int i = 0; i < key.length(); i++) {
            CharIndexPair cnPair = new CharIndexPair(key.charAt(i), i);
            charIdxPairs[i] = cnPair;
        }

        // THRESHOLD: to be decided, just a placeholder value
        final int THRESHOLD = 14;
        if (key.length() < THRESHOLD) {
            GenericTypeSort.insertionSort(charIdxPairs);
        } else {
            GenericTypeSort.iterativeMergeSort(charIdxPairs);
        }
        return charIdxPairs;
    }

    private char[][] createMessageMatrix(String key, String message, int rows) {
        char[][] matrix = new char[rows][key.length()];
        int k = 0;
        outerLoop:
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (k >= message.length()) {
                    break outerLoop;
                }

                matrix[i][j] = message.charAt(k);
                k++;
            }
        }

        return matrix;
    }

    /**
     * This method executes a single columnar transposition trying to emulate
     * the pen and pencil process. A two-dimensional array of characters is
     * created and each character of the message is then stored to the rows of
     * the matrix. The row length is determined by the key length and then the
     * message is written from left to right starting from the first row, and
     * repeating the process in the second row from left to right until the
     * message ends.
     *
     * Then the alphabetical order of the characters in the key determines the
     * order of how entire columns are copied to form a ciphertext from the
     * original message.
     *
     * @param key is a keyword which defines the column length and the
     * alphabetical order of the characters in the word defines the order of the
     * transposition
     * @param plaintext the text to be encrypted
     * @return the original message in encrypted form
     */
    public String encryptSingleTransposition(String key, String plaintext) {
        if (key.length() == 0) {
            return plaintext;
        }

        int rows = (int) (plaintext.length() / key.length());
        if (plaintext.length() % key.length() > 0) {
            rows += 1;
        }

        char[][] matrix = createMessageMatrix(key, plaintext, rows);
        CharIndexPair[] pairOrder = orderOfKey(key);
        String encryptedMessage = "";

        for (int j = 0; j < pairOrder.length; j++) {
            for (int i = 0; i < rows; i++) {
                if (matrix[i][pairOrder[j].getIndex()] != '\u0000') {
                    encryptedMessage += Character.toString(matrix[i][pairOrder[j].getIndex()]);
                }
            }
        }

        return encryptedMessage;
    }

    /**
     * The method simply executes a columnar transposition twice in a row.
     *
     * @see #encryptSingleTransposition(String key, String plaintext)
     *
     * @param key1st the key to be used in the first columnar transposition
     * @param key2nd the key to be used in the second columnar transposition,
     * this key can be the same as the first one although then the encryption is
     * weaker
     * @param plaintext the text to be encrypted
     * @return the original message in encrypted form
     */
    public String encryptDoubleTransposition(String key1st, String key2nd, String plaintext) {
        String encrypted1 = encryptSingleTransposition(key1st, plaintext);
        return encryptSingleTransposition(key2nd, encrypted1);
    }

    /**
     * This method reverses the columnar transposition encryption process. The
     * original two-dimensional array is reconstructed from the ciphertext based
     * on the alphabetical order of the characters in the key. Then the
     * resulting array is simply iterated once from left to right and moving one
     * row down when the end of the row is reached until the whole message has
     * been read.
     *
     * @param key the key that was used to originally encrypt the message
     * @param ciphertext the encrypted message which the user wishes to decrypt
     * @return the original message as plaintext
     */
    public String decryptSingleTransposition(String key, String ciphertext) {
        if (key.length() == 0) {
            return ciphertext;
        }

        char[][] matrix = reverseEngineerMatrix(key, ciphertext);

        String decryptedMessage = "";
        int k = 0;
        outerLoop:
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                decryptedMessage += Character.toString(matrix[i][j]);
                k++;

                if (k >= ciphertext.length()) {
                    break outerLoop;
                }
            }
        }

        return decryptedMessage;
    }

    /**
     * The method decrypts a ciphertext produced by double transposition cipher.
     * The decryption process is simply applying the singular case process twice
     * in a row by using the appropriate key.
     *
     * An important thing to note here is the order of the keys: The keys are
     * exactly in the same order as they would be if one was trying to encrypt a
     * message by using double transposition. Thus the second is applied first
     * since it was the last key used when the original message was encrypted.
     * And the first key is used last.
     *
     * @see #decryptSingleTransposition(String key, String ciphertext)
     *
     * @param key1st The first key used when the original plaintext message was
     * encrypted and consequently it is used LAST in the decryption process
     * @param key2nd The second key used when the original plaintext message was
     * encrypted and consequently it is used FIRST in the decryption process
     * @param ciphertext the message the user wishes to decrypt
     * @return the original message in plaintext
     */
    public String decryptDoubleTransposition(String key1st, String key2nd, String ciphertext) {
        String decrypted1 = decryptSingleTransposition(key2nd, ciphertext);
        return decryptSingleTransposition(key1st, decrypted1);
    }

    private char[][] reverseEngineerMatrix(String key, String ciphertext) {
        int regularRows = (int) (ciphertext.length() / key.length());
        int remainder = ciphertext.length() % key.length();
        int rows = regularRows;
        if (remainder > 0) {
            rows += 1;
        }

        CharIndexPair[] pairOrder = orderOfKey(key);
        char[][] matrix = new char[rows][key.length()];

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < ciphertext.length()) {
            int colIndex = pairOrder[j].getIndex();
            if ((colIndex >= remainder && i == regularRows) || (colIndex < remainder && i == rows)) {
                i = 0;
                j++;
            }

            matrix[i][pairOrder[j].getIndex()] = ciphertext.charAt(k);
            i++;
            k++;
        }

        return matrix;
    }
}
