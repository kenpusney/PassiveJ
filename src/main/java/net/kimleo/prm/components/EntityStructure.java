package net.kimleo.prm.components;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kim on 2014/5/30.
 */
public class EntityStructure {
    final Attribute id = new Attribute(Types.INTEGER, "id", this);
    List<Attribute> attributes = new LinkedList<>();
    List<Constraint> constraints = new LinkedList<>();

    public EntityStructure() {
    }

    public void pushAttribute(Attribute attr){
        attributes.add(attr);
    }

    public void pushConstraint(Constraint constraint){
        constraints.add(constraint);
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EntityStructure{");
        sb.append("id=").append(id.repr).append(':').append(id.types);
        sb.append(", attributes={");
        for (Attribute attr:attributes){
            sb.append(attr).append("; ");
        }
        sb.append("}, constraints={");
        for (Constraint constraint:constraints){
            sb.append(constraint).append("; ");
        }
        sb.append("}, }");
        return sb.toString();
    }

    public String generate(Driver driver) {
        StringBuffer sb = new StringBuffer();
        for(Attribute attr:attributes){
            sb.append("\t").append(attr.repr).append(" ").append(attr.types).append(",\n");
        }
        return sb.toString();
    }
}
