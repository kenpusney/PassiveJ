package net.kimleo.prm.components.constraints;

import net.kimleo.prm.components.Component;

import java.util.Collections;
import java.util.List;

public class Constraint implements Component {
    public final Constraints type;
    public final String expr;

    public Constraint(Constraints type, String expr) {
        this.type = type;
        this.expr = expr;
    }

    public Constraint(Constraints type) {
        this(type, "");
    }

    public static List<Constraint> build(String constraint) {
        return Collections.singletonList(new Constraint(Constraints.NOT_NULL));
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "type=" + type +
                ", expr='" + expr + '\'' +
                '}';
    }
}
