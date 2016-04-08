package net.kimleo.model.component;

import java.util.List;

public class Expr implements Component {
    private Component component;

    public Expr(Component component) {
        this.component = component;
    }
}
