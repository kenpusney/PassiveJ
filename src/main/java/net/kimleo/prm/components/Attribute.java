package net.kimleo.prm.components;

import net.kimleo.prm.components.constraints.Constraint;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kim on 2014/5/30.
 */
public class Attribute {
    public final Types types;
    public final String repr;
    public final EntityStructure belongs;

    List<Constraint> constraints = new LinkedList<>();

    public Attribute(Types types, String repr, EntityStructure belongs) {
        this.types = types;
        this.repr = repr;
        this.belongs = belongs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;

        Attribute attribute = (Attribute) o;

        if (!belongs.equals(attribute.belongs)) return false;
        if (!repr.equals(attribute.repr)) return false;
        if (types != attribute.types) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = types.hashCode();
        result = 31 * result + repr.hashCode();
        result = 31 * result + belongs.hashCode();
        return result;
    }

    public void pushConstraints(List<Constraint> constraints) {
        this.constraints.addAll(constraints);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Attribute{");
        sb.append("types=").append(types);
        sb.append(", repr='").append(repr).append('\'');
        if(!constraints.isEmpty()) {
            sb.append(", constraints={");
            for(Constraint constraint:constraints) {
                sb.append(constraint.toString());
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
