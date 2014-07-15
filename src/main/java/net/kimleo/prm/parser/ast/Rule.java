package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.sql.Driver;

/**
 * Created by Kim on 2014/6/1.
 */
public class Rule implements Element {
    public static final String KEYWORD[] = {"rule"};

    @Override
    public int build(String source, int index) {
        return 0;
    }

    @Override
    public String generate(Driver d) {
        return null;
    }

    @Override
    public String keyword() {
        return KEYWORD[0];
    }
}
