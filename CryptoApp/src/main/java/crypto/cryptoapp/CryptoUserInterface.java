/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptoapp;

import crypto.ciphers.Vigenere;

/**
 *
 * @author jpssilve
 */
public class CryptoUserInterface {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();
        
        System.out.println(vigenere.encrypt("LEMON", "ATTACKATDAWN"));
        System.out.println(vigenere.decrypt("LEMON", "LXFOPVEFRNHR"));
        System.out.println(vigenere.encrypt("l", "ATTACKATDAWN"));
    }
    
}
