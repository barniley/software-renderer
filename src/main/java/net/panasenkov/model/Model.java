package net.panasenkov.model;

import lombok.Value;
import net.panasenkov.model.parser.Vec3;

import java.util.List;

@Value
public class Model {
	private final List<Vec3<Float>> vertices;
	private final List<Face> faces;
}
