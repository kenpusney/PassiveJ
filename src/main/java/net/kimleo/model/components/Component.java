package net.kimleo.model.components;

import net.kimleo.model.generator.Generator;

public interface Component {
    default String gen(Generator generator) {
        return generator.gen(this);
    }
}
