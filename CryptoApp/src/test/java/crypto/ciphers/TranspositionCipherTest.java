/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class TranspositionCipherTest {
    
    private TranspositionCipher dblTr;
    @Before
    public void setUp() {
        this.dblTr = new TranspositionCipher();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void encryptSingleTranspositionTest1() {
        assertEquals("evlnacdtesearofodeecwiree", dblTr.encryptSingleTransposition("zebras", "wearediscoveredfleeatonce"));
    }
    
    @Test
    public void encryptSingleTranspositionTest2() {
        assertEquals("hmnrnvaicwhtsieiitoawguseint", dblTr.encryptSingleTransposition("ciaman", "wehavehimwaitinginstructions"));
    }
    
    @Test
    public void encryptSingleTranspositionTest3() {
        assertEquals("aotpheionnissstmoittnrie", dblTr.encryptSingleTransposition("nsaciakgb", "transpositionthisonetime"));
    }
    
    @Test
    public void decryptSingleTranspositionTest1() {
        assertEquals("mattimeikäläinen", dblTr.decryptSingleTransposition("nsaciakgb", "tämektiiinenmäal"));
    }
    
    @Test
    public void decryptSingleTranspositionTest2() {
        assertEquals("herra47kummelipulttibois", dblTr.decryptSingleTransposition("nsaciakgb", "reb4psutrloklaii7uhmtemi"));
    }
    
    @Test
    public void decryptSingleTranspositionTest3() {
        assertEquals("keyswereeasilychangedbychangingtherotordisksandtheplugboardwires", dblTr.decryptSingleTransposition("nsaciakgb", "yidnrtaecchspwennoageslbgdhreaarsurwyytiedrhheklikaggtnbseseiodo"));
    }
    
    @Test
    public void encryptDoubleTranspositionTest1() {
        assertEquals("caeensoiaedrlefwedreevtoc", dblTr.encryptDoubleTransposition("zebras", "stripe", "wearediscoveredfleeatonce"));
    }
    
    @Test
    public void encryptDoubleTranspositionTest2() {
        assertEquals("renrKgoesieeindsibeensnEe", dblTr.encryptDoubleTransposition("kryptos", "enigma", "KeinebesonderenEreignisse"));
    }
    
    @Test
    public void encryptDoubleTranspositionTest3() {
        assertEquals("erienrsosieebEesnKdgenien", dblTr.encryptDoubleTransposition("lorenz", "enigma", "KeinebesonderenEreignisse"));
    }
    
    @Test
    public void encryptDoubleTranspositionTest4() {
        assertEquals("b s nenidgerinseeiKneeoresE", dblTr.encryptDoubleTransposition("lorenz", "enigma", "Keine besonderen Ereignisse"));
    }
    
    @Test
    public void decryptDoubleTranspositionTest1() {
        assertEquals("The key is generated from the message in some automated fashion", 
                dblTr.decryptDoubleTransposition("hello", "world", "faem to eedeasT me notenyefr ehtnik dgeo   saemsahhta giruissmo"));
    }
    
    @Test
    public void decryptDoubleTranspositionTest2() {
        assertEquals("Ciphers, on the other hand, work at a lower level: the level of individual letters, small groups of letters, or, in modern schemes, individual bits and blocks of bits.", 
                dblTr.decryptDoubleTransposition("linguistics", "mathematics", "rlre.  hbg n s  ldsl: stntrnhuo etn,ebrvtdftehehct a,lps  todriiioi ls a lsloei ur  vsmlw no,rtce  ieofrl, iei loddhdp ,eseiaiuhCnvwnof vkbteremaoeo  slaas, eal kmeodt"));
    }
    
    @Test
    public void decryptDoubleTranspositionTest3() {
        assertEquals("Claude Shannon proved, using information theory considerations, that any theoretically unbreakable cipher must have keys which are at least as long as the plaintext, and used only once: one-time pad.", 
                dblTr.decryptDoubleTransposition("enigma", "lorenz", "uobanCt soopsuinpo ranrinctafte oetrvs ver x.ra sl n hi mnm ynoywaeihpsd hee o,tke aoh gc ia alittnnn lspisnltduneh edaar,d oaa:ereatodbhednaht arcee-n, lunyay tise  ayul ocl lmg ceshoikhe tiaeSet tn"));
    }
    
    @Test
    public void decryptDoubleTranspositionTest4() {
        assertEquals("Claude Shannon proved, using information theory considerations, that any theoretically unbreakable cipher must have keys which are at least as long as the plaintext, and used only once: one-time pad.", 
                dblTr.decryptDoubleTransposition("lorenz", "enigma", "ra slocl lm tiaeSet tnn, lun lspiuneh ever x.mnm ynoywaeo ranodbhed,tke Ct soorinctafte o n hi ayul psuinpnaht nyay tise  hoikheihpsdg ces hee o ia alittnndaar,etrvs arcee-snltdd oaa:ereataoh gcuoban"));
    }
}
