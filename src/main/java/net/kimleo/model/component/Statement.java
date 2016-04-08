package net.kimleo.model.component;

import java.util.List;

public class Statement implements Component {
    private List<Component> components;

    public Statement(List<Component> components) {

        this.components = components;
    }
}
