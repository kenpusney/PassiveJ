package net.kimleo.prm.parser;

import net.kimleo.prm.generator.Generator;

public interface ElementParser {
    int build(String source, int index);

    String gen(Generator d);

    default String keyword() {
        return "";
    }
}
