package net.panasenkov.model;

import lombok.Value;

import java.util.List;
import java.util.Vector;

@Value
public class Model {
	private final List<Vector<Float>> vertices;
	private final List<Vector<Integer>> faces;
}
