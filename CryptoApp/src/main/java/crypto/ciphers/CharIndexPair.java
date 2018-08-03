/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

/**
 * This class is a small helper class to store the indexes of the characters
 * that are found in the keys when performing columnar transposition.
 *
 * @author jpssilve
 */
public class CharIndexPair implements Comparable<CharIndexPair> {

    private char c;
    private int number;

    /**
     *
     * @param c The character found in the key
     * @param number The index of the character within the key String
     */
    public CharIndexPair(char c, int number) {
        this.c = c;
        this.number = number;
    }

    /**
     *
     * @return The character
     */
    public char getChar() {
        return this.c;
    }

    /**
     *
     * @return The index of the character within the key String
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * The CharIndexPairs are ordered based on their natural character order
     *
     * @param other Another CharIndexPair to be compared with
     * @return If a character comes before another character in alphabetical
     * order then the corresponding CharIndexPair is before the other in order.
     */
    @Override
    public int compareTo(CharIndexPair other) {
        return this.c - other.c;
    }
}
