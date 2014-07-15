package net.kimleo.prm.parser.ast;

import net.kimleo.prm.components.EntityStructure;
import net.kimleo.prm.components.sql.Driver;

/**
 * Created by Kim on 2014/6/1.
 */
public class Entity implements Element {
    public static final String KEYWORD[] = {"entity"};
    Identifier identifier;
    public final EntityStructure entity = new EntityStructure();

    public Identifier getIdentifier() {
        return identifier;
    }

    public int build(String source,int begin){
        int left_brace = source.indexOf("{", begin);
        int right_brace = source.indexOf("}\n", begin);
        String repr = source.substring(begin, left_brace).trim();
        identifier = new Identifier(repr);
        String[] attr_pairs = source
                .substring(left_brace + 1, right_brace - 1)
                .split("\\n");
        for(String s:attr_pairs) {
            String pair = s.trim();
            if(pair.length() > 0 && s.contains(":")){
                entity.pushAttribute(Type.build(pair,entity));
            }
        }
        return right_brace+1;
    }

    public String generate(Driver driver){
        StringBuffer sql = new StringBuffer("create table ").append(identifier.repr).append(" (\n");
        sql.append(entity.generate(driver)).append(");\n");
        return sql.toString();
    }

    @Override
    public String keyword() {
        return KEYWORD[0];
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Entity{");
        sb.append("identifier=").append(identifier.repr);
        sb.append(", entity=").append(entity);
        sb.append('}');
        return sb.toString();
    }
}
