package net.panasenkov.renderer.line;

import java.util.List;

public interface LineAlgorithmStrategy {
	List<Point> line(int x0, int y0, int x1, int y1);

	default <T> T swap(T a, T b) {
		return a;
	}
}
