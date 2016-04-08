package net.kimleo.model.component;

public class Function implements Component {
    private final String name;
    private final Component param;
    private final Component stmt;

    public Function(String name, Component param, Component stmt) {
        this.name = name;
        this.param = param;
        this.stmt = stmt;
    }
}
