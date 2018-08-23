/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.ciphers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jpssilve
 */
public class TranspositionCipherTest {

    private TranspositionCipher tr;

    @Before
    public void setUp() {
        this.tr = new TranspositionCipher();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void encryptSingleTranspositionTest1() {
        assertEquals("evlnacdtesearofodeecwiree", tr.encryptSingleTransposition("zebras", "wearediscoveredfleeatonce"));
    }

    @Test
    public void encryptSingleTranspositionTest2() {
        assertEquals("hmnrnwhtsivaiceiitoawguseint", tr.encryptSingleTransposition("ciamen", "wehavehimwaitinginstructions"));
    }

    @Test
    public void encryptSingleTranspositionTest3() {
        assertEquals("aihtpooesismntiitonnrste", tr.encryptSingleTransposition("nsakgb", "transpositionthisonetime"));
    }

    @Test
    public void decryptSingleTranspositionTest1() {
        assertEquals("mattimeikäläinen", tr.decryptSingleTransposition("nsakgb", "tkemäiltänmeiain"));
    }

    @Test
    public void decryptSingleTranspositionTest2() {
        assertEquals("Binäärihakupuu", tr.decryptSingleTransposition("nsakgb", "narpäuäkBiuihu"));
    }

    @Test
    public void decryptSingleTranspositionTest3() {
        assertEquals("keyswereeasilychangedbychangingtherotordisksandtheplugboardwires",
                tr.decryptSingleTransposition("nsakgb", "yecdnhrapaeeincnostgwwsayiridudsahbgednlrskrlghgtkhbieeyeatoseor"));
    }

    @Test
    public void encryptDoubleTranspositionTest1() {
        assertEquals("caeensoiaedrlefwedreevtoc", tr.encryptDoubleTransposition("zebras", "stripe", "wearediscoveredfleeatonce"));
    }

    @Test
    public void encryptDoubleTranspositionTest2() {
        assertEquals("renrKgoesieeindsibeensnEe", tr.encryptDoubleTransposition("kryptos", "enigma", "KeinebesonderenEreignisse"));
    }

    @Test
    public void encryptDoubleTranspositionTest3() {
        assertEquals("erienrsosieebEesnKdgenien", tr.encryptDoubleTransposition("lorenz", "enigma", "KeinebesonderenEreignisse"));
    }

    @Test
    public void encryptDoubleTranspositionTest4() {
        assertEquals("b s nenidgerinseeiKneeoresE", tr.encryptDoubleTransposition("lorenz", "enigma", "Keine besonderen Ereignisse"));
    }

    @Test
    public void decryptDoubleTranspositionTest1() {
        assertEquals("The key is generated from the message in some automated fashion",
                tr.decryptDoubleTransposition("helou", "world", "faem to eedeasT me notenyefr ehtnik dgeo   saemsahhta giruissmo"));
    }

    @Test
    public void decryptDoubleTranspositionTest2() {
        assertEquals("Ciphers, on the other hand, work at a lower level: the level of individual letters, small groups of letters, or, in modern schemes, individual bits and blocks of bits.",
                tr.decryptDoubleTransposition("enigma", "lorenz", "als Caa i tlso,ffdewe ah:mnsretinh gebairl lrmbhep,.kituoneisrtnd vuss veanv,doelrmi e ecn  ihol, e a  wilvi lotte h rdtdoesolreoettds , e   u,btlsrk   ipl rsohlcfdoon"));
    }

    @Test
    public void decryptDoubleTranspositionTest3() {
        assertEquals("Claude Shannon proved, using information theory considerations, that any theoretically unbreakable cipher must have keys which are at least as long as the plaintext, and used only once: one-time pad.",
                tr.decryptDoubleTransposition("enigma", "lorenz", "uobanCt soopsuinpo ranrinctafte oetrvs ver x.ra sl n hi mnm ynoywaeihpsd hee o,tke aoh gc ia alittnnn lspisnltduneh edaar,d oaa:ereatodbhednaht arcee-n, lunyay tise  ayul ocl lmg ceshoikhe tiaeSet tn"));
    }

    @Test
    public void decryptDoubleTranspositionTest4() {
        assertEquals("Claude Shannon proved, using information theory considerations, that any theoretically unbreakable cipher must have keys which are at least as long as the plaintext, and used only once: one-time pad.",
                tr.decryptDoubleTransposition("lorenz", "enigma", "ra slocl lm tiaeSet tnn, lun lspiuneh ever x.mnm ynoywaeo ranodbhed,tke Ct soorinctafte o n hi ayul psuinpnaht nyay tise  hoikheihpsdg ces hee o ia alittnndaar,etrvs arcee-snltdd oaa:ereataoh gcuoban"));
    }

    @Test
    public void encryptCornerCaseTest1() {
        assertEquals("abBtsaelkl", tr.encryptSingleTransposition("lemon", "Basketball"));
    }

    @Test
    public void encryptCornerCaseTest2() {
        assertEquals("Basketball", tr.encryptSingleTransposition("", "Basketball"));
    }

    @Test
    public void decryptCornerCaseTest1() {
        assertEquals("rotor disk", tr.decryptSingleTransposition("mind", "oio krrstd"));
    }

    @Test
    public void decryptCornerCaseTest2() {
        assertEquals("keojdanfjdk", tr.decryptSingleTransposition("", "keojdanfjdk"));
    }

    @Test
    public void decryptCornerCaseTest3() {
        assertEquals("", tr.decryptSingleTransposition("enigma", ""));
    }

    @Test
    public void sortChoiceTest() {
        assertEquals("plreryilomrmpelucryaoiet pi me ioare t  cvur- lpmRer imoo",
                tr.encryptSingleTransposition("uncopyrightable", "Relatively prime or mutually prime or coprime or co-prime"));
    }
}
