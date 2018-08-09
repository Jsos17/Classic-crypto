/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

/**
 *
 * @author jpssilve
 */
public class CharacterValue implements Comparable<CharacterValue> {
    private char character;
    private double value;
    
    public CharacterValue(char character, double value) {
        this.character = character;
        this.value = value;
    }

    public char getCharacter() {
        return character;
    }

    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(CharacterValue other) {
        return Double.compare(this.value, other.value);
    }
}
