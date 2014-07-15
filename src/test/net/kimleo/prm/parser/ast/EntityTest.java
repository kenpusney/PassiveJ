package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.sql.DefaultDriver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityTest {

    public static final String KEYWORD = Entity.KEYWORD[0];

    @Test
    public void testBuildEntity() throws Exception {
        String source = "           entity department {\n \t name! : string \n \t base : department \n }\n  ";
        Entity entity = new Entity();
        int offset = source.indexOf(KEYWORD) + KEYWORD.length();
        entity.build(source, offset);
        assertEquals(entity.identifier.repr, "department");
        System.out.println(entity.generate(new DefaultDriver()));
    }
}