/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import java.util.Arrays;

/**
 *
 * @author jpssilve
 */
public class TranspositionCipher {

    public TranspositionCipher() {

    }

    private CharIndexPair[] orderOfKey(String key) {
        int[] order = new int[key.length()];
        CharIndexPair[] charIdxPairs = new CharIndexPair[key.length()];
        
        for (int i = 0; i < key.length(); i++) {
            CharIndexPair cnPair = new CharIndexPair(key.charAt(i), i % key.length());
            charIdxPairs[i] = cnPair;
        }

        Arrays.sort(charIdxPairs);
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
                if (matrix[i][pairOrder[j].getNumber()] != '\u0000') {
                    encryptedMessage += Character.toString(matrix[i][pairOrder[j].getNumber()]);
                }
            }
        }

        return encryptedMessage;
    }

    public String encryptDoubleTransposition(String key1st, String key2nd, String plaintext) {
        String encrypted1 = encryptSingleTransposition(key1st, plaintext);
        return encryptSingleTransposition(key2nd, encrypted1);
    }

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
            int colIndex = pairOrder[j].getNumber();
            if ((colIndex >= remainder && i == regularRows) || (colIndex < remainder && i == rows)) {
                i = 0;
                j++;
            }

            matrix[i][pairOrder[j].getNumber()] = ciphertext.charAt(k);
            i++;
            k++;
        }

        return matrix;
    }
}
