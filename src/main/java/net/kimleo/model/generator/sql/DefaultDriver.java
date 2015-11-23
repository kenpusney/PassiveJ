package net.kimleo.model.generator.sql;

import net.kimleo.model.component.Entity;

public class DefaultDriver implements Driver {

    public String visit(Entity entity) {
        return entity.toString();
    }

}
