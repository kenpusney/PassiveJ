package net.kimleo.model.components;

import net.kimleo.model.components.constraints.Constraint;

import java.util.LinkedList;
import java.util.List;

public class Entity implements Component {
    public final Attribute id = new Attribute(Types.INTEGER, "id", this);
    public final List<Attribute> attributes = new LinkedList<>();

    public Entity() {
    }

    public void pushAttribute(Attribute attr){
        attributes.add(attr);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entity{");
        sb.append("id=").append(id.repr).append(':').append(id.types);
        sb.append(", attributes={");
        for (Attribute attr:attributes){
            sb.append(attr).append("; ");
        }
        sb.append("}, constraints={");

        sb.append("}, }");
        return sb.toString();
    }

    public Attribute buildAttribute(String pair) {
        String[] attr = pair.split(":");
        //@TODO:BUILD CONSTRAINT
        String[] type = attr[1].split("[^0-9a-zA-Z_\\-]", 2);

        String attributeName = attr[0].trim();
        String typeName = type[0].trim();
        Attribute attribute = new Attribute(Types.parse(typeName), attributeName, this);

        attribute.types.referTo(typeName);
        if (type.length > 1) {
            String constraintExpr = type[1].trim();
            List<Constraint> constraints = Constraint.build(constraintExpr);
            attribute.pushConstraints(constraints);
        }
        return attribute;
    }
}
