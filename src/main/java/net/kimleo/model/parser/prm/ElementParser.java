package net.kimleo.model.parser.prm;

import net.kimleo.model.generator.Generator;

public interface ElementParser {
    int build(String source, int index);

    String gen(Generator d);

    default String keyword() {
        return "";
    }
}
