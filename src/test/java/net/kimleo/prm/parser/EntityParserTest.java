package net.kimleo.prm.parser;

import net.kimleo.prm.generator.sql.DefaultDriver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityParserTest {

    public static final String KEYWORD = EntityParser.KEYWORD[0];

    @Test
    public void testBuildEntity() throws Exception {
        String source = "entity department {\n \t name! : string \n \t base : department \n }\n  ";
        EntityParser entityParser = new EntityParser();
        int offset = source.indexOf(KEYWORD) + KEYWORD.length();
        entityParser.build(source, offset);
        assertEquals(entityParser.identifier().repr, "department");
        System.out.println(entityParser.gen(new DefaultDriver()));
    }
}