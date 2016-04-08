package net.kimleo.model.component;

import java.util.List;

public class Model implements Component {
    private List<Component> components;

    public Model(List<Component> components) {

        this.components = components;
    }
}
