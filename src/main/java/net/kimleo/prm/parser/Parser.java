package net.kimleo.prm.parser;

import java.util.LinkedList;
import java.util.List;

public class Parser {
    final List<Object> ast = new LinkedList<>();
    public Parser(){}
    public void parse(String source) {
        int index = 0;
        while(true){
            while(index < source.length() && isBlank(source.charAt(index))) index++;
            int pos = findNextBlank(source,index);
            if(pos < 0) break;
            String keyword = source.substring(index, pos).trim();
            switch (keyword){
                case "entity" :
                    EntityParser entityParser = new EntityParser();
                    ast.add(entityParser);
                    index = entityParser.build(source, pos);
                    break;
                case "rule":
                    //@TODO: implements `rule`
                    break;
                case "query":
                    //@TODO: implements `query`
                    break;
                default: break;
            }
        }
    }

    private int findNextBlank(String source, int index) {
        char BLANKS[] = {'\n', '\r', '\t', ' '};
        int min = index;
        for(char c:BLANKS){
            int pos = source.indexOf(c,index);
            if(pos < min || min <= index)
                min = pos;
        }
        return min;
    }

    private boolean isBlank(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }
}
