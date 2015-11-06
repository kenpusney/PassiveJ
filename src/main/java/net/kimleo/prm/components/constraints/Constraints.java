package net.kimleo.prm.components.constraints;

public enum Constraints {
    UNIQUE(1),
    NOT_NULL(2),
    PRIMARY_KEY(4),
    FOREIGN_KEY(8),
    REFERENCE(16),
    AUTO_INCREMENT(32),
    CHECK(64);

    final int i;

    Constraints(int anInt) {
        this.i = anInt;
    }

}
