package net.kimleo.model.component.constraint;

import net.kimleo.model.component.Component;

import java.util.Collections;
import java.util.List;

public class Constraint implements Component {
    public final ConstraintType type;
    public final String expr;

    public Constraint(ConstraintType type, String expr) {
        this.type = type;
        this.expr = expr;
    }

    public Constraint(ConstraintType type) {
        this(type, "");
    }

    public static List<Constraint> build(String constraint) {
        return Collections.singletonList(new Constraint(ConstraintType.NOT_NULL));
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "type=" + type +
                ", expr='" + expr + '\'' +
                '}';
    }
}
