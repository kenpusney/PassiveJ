package net.kimleo.prm.generator.sql;

import net.kimleo.prm.components.Entity;

public class DefaultDriver implements Driver {

    public String visit(Entity entity) {
        return entity.toString();
    }

}
