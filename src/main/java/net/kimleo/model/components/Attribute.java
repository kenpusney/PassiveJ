package net.kimleo.model.components;

import net.kimleo.model.components.constraints.Constraint;

import java.util.LinkedList;
import java.util.List;

public class Attribute implements Component {
    public final Types types;
    public final String repr;
    public final Entity belongs;

    List<Constraint> constraints = new LinkedList<>();

    public Attribute(Types types, String repr, Entity belongs) {
        this.types = types;
        this.repr = repr;
        this.belongs = belongs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;

        Attribute attribute = (Attribute) o;

        return repr.equals(attribute.repr) && types == attribute.types;

    }

    @Override
    public int hashCode() {
        int result = types.hashCode();
        result = 31 * result + repr.hashCode();
        return result;
    }

    public void pushConstraints(List<Constraint> constraints) {
        this.constraints.addAll(constraints);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Attribute{");
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
