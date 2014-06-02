package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.Attribute;
import net.kimleo.prm.components.EntityStructure;
import net.kimleo.prm.components.Types;

/**
 * Created by Kim on 2014/6/1.
 */
public class Type {
    public static Attribute build(String pair,EntityStructure entity) {
        String[] attr = pair.split(":");
        //@TODO:BUILD CONSTRAINT
        Attribute attribute = new Attribute(Types.parse(attr[1].trim()), attr[0].trim(), entity);
        attribute.types.referTo(attr[1].trim());
        return attribute;
    }
}
