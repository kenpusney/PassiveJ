package net.kimleo.prm.parser;

import net.kimleo.prm.generator.Generator;

public class RuleParser implements ElementParser {
    public static final String KEYWORD[] = {"rule"};

    @Override
    public int build(String source, int index) {
        return 0;
    }

    @Override
    public String gen(Generator d) {
        return null;
    }

    @Override
    public String keyword() {
        return KEYWORD[0];
    }
}
