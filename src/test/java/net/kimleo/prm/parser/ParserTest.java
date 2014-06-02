package net.kimleo.prm.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void testParse() throws Exception {
        Parser.parse("entity user {\n\tname:string\n\tage:number => 0 < _ < 100\n\taddress:string(120)\n}\n" +
                     "entity class {\n\ttitle:string\n\tlevel:number\n}\n");
        assertEquals(Parser.ast.get(1).toString(),
                "Entity{" +
                    "identifier=class, " +
                    "entity=EntityStructure{" +
                            "id=id:INTEGER, " +
                            "attributes={" +
                                "Attribute{types=STRING, repr='title'}; " +
                                "Attribute{types=NUMBER, repr='level'}; " +
                            "}, " +
                            "constraints={}, " +
                        "}" +
                "}");
    }

}