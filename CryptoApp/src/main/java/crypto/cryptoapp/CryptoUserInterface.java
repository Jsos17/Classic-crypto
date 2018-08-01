/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptoapp;

import crypto.ciphers.TranspositionCipher;
import crypto.ciphers.KeyedVigenere;
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
        KeyedVigenere kvig = new KeyedVigenere("kryptos");
        System.out.println(kvig.decrypt("Palimpsest", "EMUFPHZLRFAXYUSDJKZLDKRNSHGNFIVJYQTQUXQBQVYUVLLTREVJYQTMKYRDMFD"));
        System.out.println(kvig.decrypt("Abscissa", "VFPJUDEEHZWETZYVGWHKKQETGFQJNCE" +
                                                    "GGWHKKDQMCPFQZDQMMIAGPFXHQRLG" +
                                                    "TIMVMZJANQLVKQEDAGDVFRPJUNGEUNA" +
                                                    "QZGZLECGYUXUEENJTBJLBQCRTBJDFHRR" +
                                                    "YIZETKZEMVDUFKSJHKFWHKUWQLSZFTI" +
                                                    "HHDDDUVHDWKBFUFPWNTDFIYCUQZERE" +
                                                    "EVLDKFEZMOQQJLTTUGSYQPFEUNLAVIDX" +
                                                    "FLGGTEZFKZBSFDQVGOGIPUFXHHDRKF" +
                                                    "FHQNTGPUAECNUVPDJMQCLQUMUNEDFQ" +
                                                    "ELZZVRRGKFFVOEEXBDMVPNFQXEZLGRE" +
                                                    "DNQFMPNZGLFLPMRJQYALMGNUVPDXVKP" +
                                                    "DQUMEBEDMHDAFMJGZNUPLGEWJLLAETG"));
        
        Vigenere vigenere = new Vigenere();
        System.out.println(vigenere.encrypt("LEMON", "ATTACKATDAWN"));
        System.out.println(vigenere.decrypt("LEMON", "LXFOPVEFRNHR"));
        System.out.println(vigenere.encrypt("l", "ATTACKATDAWN"));
        System.out.println(vigenere.encrypt("LEMON", "ATTöäACKATDAWN"));
        System.out.println(vigenere.decrypt("LEMON", "lxfonlgwogoeib"));
        System.out.println(vigenere.decrypt("LEMON", "LXFöOäPVEFRNHR"));
        System.out.println(vigenere.decrypt("LEMON", "LXFaOaPVEFRNHR"));
        System.out.println(vigenere.decrypt("Palimpsest", "EMUFPHZLRFAXYUSDJKZLDKRNSHGNFIVJYQTQUXQBQVYUVLLTREVJYQTMKYRDMFD"));
//        for (int i = 0; i < 53; i++) {
//            System.out.println(-i % 26);
//        }

        char[] nothing = new char[10];
        System.out.println(nothing[0] == '\u0000');
        
        TranspositionCipher dt = new TranspositionCipher();
        System.out.println(dt.encryptSingleTransposition("zebras", "wearediscoveredfleeatonce"));
        System.out.println(dt.decryptSingleTransposition("nsaciakgb", "tämektiiinenmäal"));
        System.out.println(dt.encryptDoubleTransposition("lorenz", "enigma", "KeinebesonderenEreignisse"));
        System.out.println(dt.encryptDoubleTransposition("lorenz", "enigma", "Claude Shannon proved, using information theory considerations, that any theoretically unbreakable cipher must have keys which are at least as long as the plaintext, and used only once: one-time pad."));
        System.out.println(dt.encryptSingleTransposition("", "wearediscoveredfleeatonce"));
//        System.out.println(dt.encryptDoubleTransposition("zebras", "stripe", "wearediscoveredfleeatonce"));
//        System.out.println(dt.decryptDoubleTransposition("zebras", "stripe", "caeensoiaedrlefwedreevtoc"));
    }
    
}
