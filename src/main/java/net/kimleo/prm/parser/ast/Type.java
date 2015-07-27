package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.Attribute;
import net.kimleo.prm.components.EntityStructure;
import net.kimleo.prm.components.Types;
import net.kimleo.prm.components.constraints.Constraint;

import java.util.List;

/**
 * Created by Kim on 2014/6/1.
 */
public class Type {
    public static Attribute build(String pair,EntityStructure entity) {
        String[] attr = pair.split(":");
        //@TODO:BUILD CONSTRAINT
        String[] type = attr[1].split("[^0-9a-zA-Z_\\-]", 2);

        String attributeName = attr[0].trim();
        String typeName = type[0].trim();
        Attribute attribute = new Attribute(Types.parse(typeName), attributeName, entity);

        attribute.types.referTo(typeName);
        if (type.length > 1){
            String constraintExpr = type[1].trim();
            List<Constraint> constraints = Constraint.build(constraintExpr);
            attribute.pushConstraints(constraints);
        }
        return attribute;
    }
}
