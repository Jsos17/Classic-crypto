/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.helpers;

/**
 *
 * @author jpssilve
 */
public class ValueLengthPair implements Comparable<ValueLengthPair> {

    private double value;
    private int length;

    public ValueLengthPair(double value, int index) {
        this.value = value;
        this.length = index;
    }

    public double getValue() {
        return value;
    }

    public int getIndex() {
        return length;
    }

    @Override
    public int compareTo(ValueLengthPair other) {
        return Double.compare(this.value, other.value);
    }
}
