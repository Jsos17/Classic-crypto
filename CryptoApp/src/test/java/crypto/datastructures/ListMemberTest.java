package crypto.datastructures;

import org.junit.Before;
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
