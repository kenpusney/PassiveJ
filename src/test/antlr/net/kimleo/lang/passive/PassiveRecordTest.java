package net.kimleo.lang.passive;

import net.kimleo.model.component.Component;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PassiveRecordTest {

    private BufferedReader file;
    private int errorCount = 0;

    @After
    public void tearDown() throws Exception {
        file.close();
    }

    @Test
    public void should_parse_entity() throws Exception {
        file = open("entity.prm");

        PassiveRecordParser.ModelContext model = parse(file).model();

        assertThat(model.entity().size(), is(1));
        PassiveRecordParser.EntityContext entity = model.entity().get(0);
        assertThat(value(entity.ENTITY()), is("entity"));
        assertThat(value(entity.name().ID()), is("employee"));
        verifyEntityStructure(entity.record().pair(), zip(of("name",   "age"),
                                                               of("string", "integer")));
    }

    @Test
    public void should_parse_function() throws Exception {
        file = open("function.prm");
        PassiveRecordParser.ModelContext model = parse(file).model();

        assertThat(model.function().size(), is(2));
        PassiveRecordParser.FunctionContext first = model.function(0);
        PassiveRecordParser.FunctionContext second = model.function(1);

        Component accept = model.accept(new ConcretePassiveRecordVisitor());

        assertThat(value(first.FUNCTION()), is("function"));
        assertThat(value(second.FUNCTION()), is("function"));
        assertThat(value(first.name().ID()), is("id"));
        assertThat(value(first.statement().statement(0).expr().ID()), is("x"));
        assertThat(value(second.statement().statement(0).expr().ID()), is("hello"));
    }

    @Test
    public void should_pass() throws Exception {

        file = open("example.prm");

        PassiveRecordParser parse = parse(file);

        PassiveRecordParser.ModelContext model = parse.model();

        Component accept = model.accept(new ConcretePassiveRecordVisitor());


        assertThat(errorCount, is(0));
    }

    private void verifyEntityStructure(List<PassiveRecordParser.PairContext> attrs, Map<String, String> map) {
        for (PassiveRecordParser.PairContext attribute : attrs) {
            assertThat(value(attribute.hint().name().ID()), is(map.get(value(attribute.name().ID()))));
        }
    }

    @SafeVarargs
    private final <T> List<T> of(T... ts) {
        return Arrays.asList(ts);
    }

    private <K, V> Map<K, V> zip(List<K> ks, List<V> vs) {
        assert (ks.size() == vs.size());
        LinkedHashMap<K, V> map = new LinkedHashMap<>();
        Iterator<V> vi = vs.iterator();
        ks.stream().forEach(k -> map.put(k, vi.next()));
        return map;
    }


    private String value(TerminalNode node) {
        return node.getSymbol().getText();
    }

    private BufferedReader open(String name) throws FileNotFoundException {
        return new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File(getClass().getClassLoader().getResource(name).getFile()))));
    }

    private PassiveRecordParser parse(BufferedReader file) throws IOException {
        PassiveRecordParser parser = new PassiveRecordParser(
                new CommonTokenStream(
                        new PassiveRecordLexer(
                                new ANTLRInputStream(file))));
        parser.setErrorHandler(new DefaultErrorStrategy() {
            @Override
            public void reportError(Parser recognizer, RecognitionException e) {
                PassiveRecordTest.this.errorCount++;
            }
        });
        return parser;
    }
}
