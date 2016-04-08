package net.kimleo.model.component;

import java.util.List;

public class Params implements Component {
    private List<Component> params;

    public Params(List<Component> params) {

        this.params = params;
    }
}
