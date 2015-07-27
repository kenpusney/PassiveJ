package net.kimleo.prm.components;

import net.kimleo.prm.components.constraints.Constraints;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstraintsTest {
    @Test
    public void testCreateWithSymbols() throws Exception {
        Constraints reference = Constraints.valueOf("REFERENCE");
        assertEquals(reference, Constraints.REFERENCE);
        Constraints check = Constraints.valueOf("CHECK");
        assertEquals(check, Constraints.CHECK);
    }
}