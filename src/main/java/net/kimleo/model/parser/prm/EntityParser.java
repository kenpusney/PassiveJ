package net.kimleo.model.parser.prm;

import net.kimleo.model.component.Entity;
import net.kimleo.model.generator.Generator;

import static java.lang.String.format;

public class EntityParser implements ElementParser {
    public static final String KEYWORD[] = {"entity"};
    public final Entity entity = new Entity();
    Identifier identifier;

    public Identifier identifier() {
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
                entity.pushAttribute(entity.buildAttribute(pair));
            }
        }
        return right_brace+1;
    }

    public String gen(Generator driver) {
        return entity.gen(driver);
    }

    @Override
    public String keyword() {
        return KEYWORD[0];
    }

    @Override
    public String toString() {
        return format("Entity{identifier=%s, entity=%s}", identifier.repr, entity);
    }
}
