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
public class DoubleTransposition {

    public DoubleTransposition() {

    }

    private int[] messageOrder(String key) {
        int[] order = new int[key.length()];
        CharNumberPair[] charNumPairs = new CharNumberPair[key.length()];
        for (int i = 0; i < key.length(); i++) {
            CharNumberPair cnPair = new CharNumberPair(key.charAt(i), i % key.length());
            charNumPairs[i] = cnPair;
        }

        Arrays.sort(charNumPairs);
        for (int i = 0; i < order.length; i++) {
            order[i] = charNumPairs[i].getNumber();
        }

        return order;
    }

    private char[][] createMessageMatrix(String key, String message, int rows) {
        char[][] matrix = new char[rows][key.length()];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (k < message.length()) {
                    matrix[i][j] = message.charAt(k);
                } else {
                    matrix[i][j] = ' ';
                } 
                
                k++;
            }
        }

        return matrix;
    }

    private String transposition(String key, String message) {
        int rows = (int) (message.length() / key.length());
        if (message.length() % key.length() > 0) {
            rows += 1;
        }

        char[][] matrix = createMessageMatrix(key, message, rows);
        int[] order = messageOrder(key);
        String encryptedMessage = "";
        
        for (int j = 0; j < order.length; j++) {
            char[] chars = new char[rows];
            for (int i = 0; i < rows; i++) {
                if (matrix[i][order[j]] != '\u0000') {
                    chars[i] = matrix[i][order[j]];
                }
            }

            encryptedMessage += new String(chars).trim();
        }

        return encryptedMessage;
    }
    
    public String encryptDoubleTransposition(String key1, String key2, String message) {
        String encrypt1 = transposition(key1, message);
        return transposition(key2, encrypt1);
    }
    
    public String decryptDoubleTransposition(String key1, String key2, String message) {
        return "";
    }
}
