package net.kimleo.prm.components.constraints;

import java.util.Arrays;
import java.util.List;

/**
 * Created by qkliu on 7/27/15.
 */
public class Constraint {
    final Constraints type;
    final String expr;

    public Constraint(Constraints type, String expr) {
        this.type = type;
        this.expr = expr;
    }

    public Constraint(Constraints type) {
        this(type, "");
    }

    public static List<Constraint> build(String constraint) {
        return Arrays.asList(new Constraint(Constraints.NOT_NULL));
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "type=" + type +
                ", expr='" + expr + '\'' +
                '}';
    }
}
