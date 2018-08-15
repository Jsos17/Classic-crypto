/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import java.util.ArrayList;

/**
 *
 * @author jpssilve
 */
public class SubSequencePrinter {

    public static void printSubSequences() {
        String text = "wnylazlzeqntfpwtsmabjqinaweaocfewgpsrmyluadlybfgaltgljrlzaaxvjehhygggdsrygvnjmpyklvyilykdrphepbfgdspjtaap"
                + "sxrpayholutqfxstptffbcrkxvvjhorawfwaejxlgafilmzrywpfxjgaltdhjvjgtyguretajegpyirpxfpagodmzrhstrxjrpirlbfgkhhce"
                + "wgpsrvtuvlvepmwkpaeqlstaqolmsvjwnegmzafoslaaohalvwfkttfxdrphepqobqzdqnytagtrhspnmprtfnhmsrmznplrcijrosnrlwgds"
                + "bylapqgemyxeaeucgulwbajrkvowsrhxvngtahmaphhcyjrmielvqbbqinawepsxrewgpsrqtfqpveltkfkqiymwtqssqxvchoilmwkpzermw"
                + "eokiraluaammkwkownrawpedhcklrthtftfnjmtfbftazsclmtcssrlluwhxahjeagpmgvfpceggluadlybfgaltznlgdwsglfbpqepmsvjha"
                + "lwsnnsajlgiafyahezkbilxfthwsflgkiwgfmtrawtfxjbbhhcfsyocirbkhjziixdlpcbcthywwnrxpgvcropzvyvapxdrogcmfebjhhsllu"
                + "aqrwilnjolwllzwmncxvgkhrwlwiafajvgzxwnymabjgodfsclwneltrpkecguvlvepmwkponbidnebtcqlyahtckk";
        ArrayList<String[]> subSeqs = new ArrayList<>();
        for (int keyLen = 1; keyLen <= text.length(); keyLen++) {
            subSeqs.add(allSubSequences(text, keyLen));
        }

        for (int i = 0; i < subSeqs.size() / 2; i++) {
            System.out.println("KeyLen: " + (i + 1));
            for (int j = 0; j < subSeqs.get(i).length; j++) {
                System.out.println(subSeqs.get(i)[j]);
            }
        }
    }

    protected static String[] allSubSequences(String ciphertext, int keyLen) {
        String[] subsequences = new String[keyLen];
        for (int k = 0; k < keyLen; k++) {
            String newText = "";
            for (int i = k; i < ciphertext.length(); i += keyLen) {
                newText += ciphertext.charAt(i) + " ";
            }

            subsequences[k] = newText;
        }

        return subsequences;
    }
}
