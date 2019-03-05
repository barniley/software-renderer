package net.panasenkov.renderer.line.impl;

import net.panasenkov.renderer.line.LineAlgorithmStrategy;
import net.panasenkov.renderer.Point;

import java.util.ArrayList;
import java.util.List;

public class BresenhamLineStrategy implements LineAlgorithmStrategy {
	@Override
	public List<Point> line(int x0, int y0, int x1, int y1) {
		boolean isSteep = false;
		if (Math.abs(y1 - y0) > Math.abs(x1 - x0)) {
			y0 = swap(x0, x0 = y0);
			y1 = swap(x1, x1 = y1);
			isSteep = true;
		}
		if (x0 > x1) {
			x0 = swap(x1, x1 = x0);
			y0 = swap(y1, y1 = y0);
		}
		final int deltaX = Math.abs(x1 - x0);
		final int deltaY = Math.abs(y1 - y0);
		int y = y0;
		final int yStep = y1 > y0 ? 1 : -1;
		final int deltaError = deltaY;
		int error = 0;

		final List<Point> result = new ArrayList<>();
		for (int x = x0; x <= x1; ++x) {
			result.add(new Point(isSteep ? y : x, isSteep ? x : y));
			error += deltaError;
			if (2 * error >= deltaX) {
				y += yStep;
				error -= deltaX;
			}
		}
		return result;
	}
}
