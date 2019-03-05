package net.panasenkov.renderer.triangle.impl;

import lombok.AllArgsConstructor;
import net.panasenkov.renderer.Point;
import net.panasenkov.renderer.line.LineAlgorithmStrategy;
import net.panasenkov.renderer.triangle.TriangleAlgorithmStrategy;

import java.util.Set;

@AllArgsConstructor
public class SimpleTriangleAlgorithmStrategy implements TriangleAlgorithmStrategy {

	private LineAlgorithmStrategy lineAlgorithmStrategy;

	@Override
	public Set<Point> triangle(Point a, Point b, Point c) {

		return null;
	}
}
