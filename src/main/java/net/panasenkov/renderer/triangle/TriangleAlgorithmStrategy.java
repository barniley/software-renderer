package net.panasenkov.renderer.triangle;

import net.panasenkov.renderer.Point;

import java.util.Set;

public interface TriangleAlgorithmStrategy {
	Set<Point> triangle(Point a, Point b, Point c);
}
