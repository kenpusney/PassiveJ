package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.Constraint;

/**
 * Created by Kim on 2014/6/1.
 */
public class CheckConstraint {
    public static final String KEYWORD[] = {"=>", "check"};
    Constraint constraint;
    public int build(String source,int begin){
        int end = source.indexOf('\n', begin);
        constraint = Constraint.create(source.substring(begin, end));
        return end;
    }
}
