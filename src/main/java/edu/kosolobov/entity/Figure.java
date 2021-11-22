package edu.kosolobov.entity;

public interface Figure {

    long getId();

    String getName();

    default String info() {
return String.format("[name: %s, id: %d]", getName(), getId());
    }

    Figure copy();
}
