package net.panasenkov.ui;

import net.panasenkov.model.Face;
import net.panasenkov.model.Model;
import net.panasenkov.model.loader.ModelLoader;
import net.panasenkov.model.loader.ModelLocation;
import net.panasenkov.model.parser.Vec3;
import net.panasenkov.renderer.line.LineAlgorithmStrategy;
import net.panasenkov.renderer.line.Point;
import net.panasenkov.renderer.line.impl.BresenhamLineStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.IntStream;

public class DrawPanel extends JPanel implements ActionListener {

	private LineAlgorithmStrategy lineAlgorithmStrategy = new BresenhamLineStrategy();

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		Model cubeModel = ModelLoader.load(ModelLocation.HEAD_OBJ_MODEL);

		drawModel(g2d, Color.WHITE, cubeModel);
	}

	private void drawModel(Graphics2D g2d, Color meshLineColor, Model model) {
		int width = getWidth();
		int height = getHeight();

		List<Vec3<Float>> vertices = model.getVertices();
		model.getFaces().stream()
				.map(Face::getVertexIndexes)
				.forEach(vertexIndexes ->
						IntStream.range(0, 3).forEach(index -> {
							// Vertex index starts from 1. Need to subtract 1.
							Vec3<Float> begin = vertices.get(vertexIndexes.get(index) - 1);
							Vec3<Float> end = vertices.get(vertexIndexes.get((index + 1) % 3) - 1);
							List<Point> line = lineAlgorithmStrategy.line(
									(int) ((begin.getX() + 1.0) * width * 0.5),
									// flip vertically
									height - (int) ((begin.getY() + 1.0) * height * 0.5),
									(int) ((end.getX() + 1.0) * width * 0.5),
									// flip vertically
									height - (int) ((end.getY() + 1.0) * height * 0.5)
							);
							drawLine(g2d, meshLineColor, line);
					})
				);
	}

	private void drawLine(Graphics2D g2d, Color color, List<Point> points) {
		g2d.setPaint(color);
		points.forEach(point -> g2d.drawLine(point.getX(), point.getY(), point.getX(), point.getY()));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}

