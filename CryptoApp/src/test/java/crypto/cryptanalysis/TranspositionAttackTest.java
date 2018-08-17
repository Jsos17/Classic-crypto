/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.cryptanalysis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * These tests are very time consuming compared to other tests due to the
 * generation of permutations
 *
 * @author jpssilve
 */
public class TranspositionAttackTest {

    private TranspositionAttack attack;

    @Before
    public void setUp() {
        attack = new TranspositionAttack();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void attackShortKeyWordsNaiveTest1() {
        String ciphertext = "TTRTROTOOEOAMWNZCOAZEAKRTER";
        assertEquals("eabcd", attack.attackShortKeyWordsNaive(ciphertext));
    }

    @Test
    public void attackShortKeyWordsTest1() {
        String ciphertext = "TTRTROTOOEOAMWNZCOAZEAKRTER";
        assertEquals("eabcd", attack.attackShortKeyWords(ciphertext));
    }

    @Test
    public void crackWithKeyTest1() {
        String ciphertext = "QDBSSAGNTDOLLCSERUELAESTOSIOODDUYSANUFRISUIUHARRGAE"
                + "MLULANORSARCROSMEPDVNUXVSTBCNAFNTIWUZUFIITEISDMOENSEYINUMDIAITACEEHECCC";
        String keycandidate = attack.attackShortKeyWords(ciphertext);
        assertEquals("AFREQUENCYDISTRIBUTIONSHOWSUSASUMMARIZEDGROUPING"
                + "OFDATADIVIDEDINTOMUTUALLYEXCLUSIVECLASSESANDTHENUMBER"
                + "OFOCCURRENCESINACLASS", attack.crackWithKey(keycandidate, ciphertext));
    }

    @Test
    public void crackWithKeyTest2() {
        String ciphertext = "NSTLEICYEMPMHELGOAAHVCOTBYAAAESEAWAMNERTATHOPFTMZDHAISAALITSUOOAZNSREMSEAVTLETYGUAEGREERNIUAKRNRPSMS";
        String keycandidate = attack.attackShortKeyWords(ciphertext);
        assertEquals("ANAGRAMSAREINTHEMSELVESARECREATIONALACTIVITYBUTTHEYALSOMAKEUPPARTOFMANYOTHERGAMESPUZZLESANDGAMESHOWS", 
                attack.crackWithKey(keycandidate, ciphertext));
    }
}
