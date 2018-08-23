/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.datastructures;

import crypto.datastructures.ListMember;
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
public class ListMemberTest {

    private ListMember m;

    @Before
    public void setUp() {
        this.m = new ListMember("word", null, null);
    }

    @Test
    public void getObjectTest() {
        assertEquals("word", this.m.getObject());
    }

    @Test
    public void linkingTest1() {
        ListMember k = new ListMember("cipher", this.m, null);
        ListMember l = new ListMember("text", this.m, k);

        assertEquals("cipher", l.prev.getObject());
        assertEquals("word", l.next.getObject());
        assertEquals("word", k.next.getObject());
        assertTrue(k.prev == null);
    }
}
