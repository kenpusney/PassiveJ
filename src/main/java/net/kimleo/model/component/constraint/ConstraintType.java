package net.kimleo.model.component.constraint;

public enum ConstraintType {
    UNIQUE(1),
    NOT_NULL(2),
    PRIMARY_KEY(4),
    FOREIGN_KEY(8),
    REFERENCE(16),
    AUTO_INCREMENT(32),
    CHECK(64);

    public final long value;

    ConstraintType(long value) {
        this.value = value;
    }

}
