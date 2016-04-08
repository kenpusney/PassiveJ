package net.kimleo.model.component;

import net.kimleo.model.component.Component;

public class FunCall implements Component {
    private final String name;
    private final Component args;

    public FunCall(String name, Component args) {

        this.name = name;
        this.args = args;
    }
}
