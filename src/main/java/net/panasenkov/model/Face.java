package net.panasenkov.model;

import lombok.Value;

import java.util.List;

@Value
public class Face {
    private final List<Integer> vertexIndexes;
}
