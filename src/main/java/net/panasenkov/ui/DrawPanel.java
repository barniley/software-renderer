package net.panasenkov.ui;

import net.panasenkov.renderer.line.LineAlgorithmStrategy;
import net.panasenkov.renderer.line.Point;
import net.panasenkov.renderer.line.impl.BresenhamLineStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DrawPanel extends JPanel implements ActionListener {

	private LineAlgorithmStrategy lineAlgorithmStrategy = new BresenhamLineStrategy();

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		drawLine(g2d, Color.RED, lineAlgorithmStrategy.line(100, 100, 400, 350));
		drawLine(g2d, Color.BLUE, lineAlgorithmStrategy.line(300, 100, 200, 300));
		drawLine(g2d, Color.RED, lineAlgorithmStrategy.line(200, 300, 300, 100));
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

