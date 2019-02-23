package net.panasenkov.model.parser;

import lombok.Value;

@Value
public class Vec3<T> {
    private final T x;
    private final T y;
    private final T z;
}
