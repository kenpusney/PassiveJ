package net.kimleo.prm.components;

/**
 * Created by Kim on 2014/5/30.
 */
public class Attribute {
    public final Types types;
    final String repr;
    final EntityStructure belongs;

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Attribute{");
        sb.append("types=").append(types);
        sb.append(", repr='").append(repr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
