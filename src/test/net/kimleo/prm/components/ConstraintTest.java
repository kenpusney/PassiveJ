package net.kimleo.prm.components;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstraintTest {
    @Test
    public void testCreateWithSymbols() throws Exception {
        Constraint reference = Constraint.create("& employee");
        assertEquals(reference.type, Constraint.Constraints.REFERENCE);
        Constraint check = Constraint.create("=> 1 < _ < 2");
        assertEquals(check.type, Constraint.Constraints.CHECK);
    }

    @Test
    public void testCreateWithKeywords() throws Exception {
        Constraint reference = Constraint.create("ref employee");
        assertEquals(reference.type, Constraint.Constraints.REFERENCE);
        Constraint check = Constraint.create("check 1 < _ < 2");
        assertEquals(check.type, Constraint.Constraints.CHECK);
    }
}