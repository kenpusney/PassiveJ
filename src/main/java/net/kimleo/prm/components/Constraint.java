package net.kimleo.prm.components;

/**
 * Created by Kim on 2014/5/30.
 */
public class Constraint {

    final Constraints type;

    protected Constraint(Constraints type) {
        this.type = type;
    }

    public static Constraint create(String expr){
        expr = expr.trim();
        String type = expr.substring(0,expr.indexOf(" "));
        switch (type){
            case "=>":
            case "check": return new Constraint(Constraints.CHECK);
            case "!":
            case "unique": return new Constraint(Constraints.UNIQUE);
            case "&":
            case "ref": return new Constraint(Constraints.REFERENCE);
            case "^":
            case "auto_increment": return new Constraint(Constraints.AUTO_INCREMENT);
            default:return null;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Constraint{");
        sb.append("type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    public enum Constraints{
        UNIQUE,
        NOT_NULL,
        PRIMARY_KEY,
        FOREIGN_KEY,
        REFERENCE,
        AUTO_INCREMENT,
        CHECK,
    }
}
