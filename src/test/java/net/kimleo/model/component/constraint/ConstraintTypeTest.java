package net.kimleo.model.component.constraint;

import net.kimleo.model.component.constraint.ConstraintType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstraintTypeTest {
    @Test
    public void testCreateWithSymbols() throws Exception {
        ConstraintType reference = ConstraintType.valueOf("REFERENCE");
        assertEquals(reference, ConstraintType.REFERENCE);
        ConstraintType check = ConstraintType.valueOf("CHECK");
        assertEquals(check, ConstraintType.CHECK);
    }
}