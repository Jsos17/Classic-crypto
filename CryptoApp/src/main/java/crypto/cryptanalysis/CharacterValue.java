/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

/**
 * A helper class to keep track of the most likely characters in a Vigenere
 * encryption key, based on the double chi-squared value that is the second
 * parameter.
 *
 * @author jpssilve
 */
public class CharacterValue implements Comparable<CharacterValue> {

    private char character;
    private double value;

    /**
     *
     * @param character The character candidate for the encryption key
     * @param value A double value that corresponds to the character
     */
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

    /**
     * CharacterValues are ordered based on the double value only and using the
     * natural order of double values.
     *
     * @param other The CharacterValue to be compared to
     * @return A negative value if this double value is smaller than the other
     * double value, 0 if they are equal and positive otherwise
     */
    @Override
    public int compareTo(CharacterValue other) {
        return Double.compare(this.value, other.value);
    }
}
