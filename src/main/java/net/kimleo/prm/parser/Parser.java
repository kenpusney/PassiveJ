package net.kimleo.prm.parser;

/**
 * Created by Kim on 2014/5/30.
 */

import net.kimleo.prm.parser.ast.Entity;

import java.util.LinkedList;
import java.util.List;

public class Parser {
    final static List<Object> ast = new LinkedList<>();
    public static void parse(String source) {
        int index = 0;
        while(true){
            Character.isSpaceChar(0);
            while(index < source.length() && isBlank(source.charAt(index))) index++;
            int pos = findNextBlank(source,index);
            if(pos < 0) break;
            String keyword = source.substring(index, pos).trim();
            switch (keyword){
                case "entity" :
                    Entity entity = new Entity();
                    ast.add(entity);
                    index = entity.build(source, pos); break;
                case "rule":
                    //@TODO: implements `rule`
                    break;
                case "query":
                    //@TODO: implements `query`
                    break;
                default: break;
            }
        }
//        for (Object o:ast)
//            System.out.println(o);
    }

    private static int findNextBlank(String source, int index) {
        char BLANKS[] = {'\n', '\r', '\t', ' '};
        int min = index;
        for(char c:BLANKS){
            int pos = source.indexOf(c,index);
            if(pos < min || min <= index)
                min = pos;
        }
        return min;
    }

    private static boolean isBlank(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }
}
