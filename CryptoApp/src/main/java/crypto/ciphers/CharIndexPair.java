/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

/**
 *
 * @author jpssilve
 */
public class CharIndexPair implements Comparable<CharIndexPair> {
    private char c;
    private int number;
    
    public CharIndexPair(char c, int number) {
        this.c = c;
        this.number = number;
    }
    
    public char getChar() {
        return this.c;
    }
    
    public int getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(CharIndexPair other) {
        return this.c - other.c;
    }
}
