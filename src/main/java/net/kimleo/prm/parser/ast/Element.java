package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.Driver;

/**
 * Created by Kim on 2014/6/2.
 */
public interface Element {
    int build(String source,int index);
    String generate(Driver d);
}
