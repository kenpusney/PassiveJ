package net.kimleo.prm.components;

import net.kimleo.prm.generator.Generator;

public interface Component {
    default String gen(Generator generator) {
        return generator.gen(this);
    }
}
