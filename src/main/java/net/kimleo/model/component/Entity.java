package net.kimleo.model.component;

public class Entity implements Component {
    private final String name;
    private final Record record;

    public Entity(String name, Record record) {
        this.name = name;
        this.record = record;
    }
}
