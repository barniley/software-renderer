package net.panasenkov.ui;

import javax.swing.*;
import java.awt.*;

public class ViewFrame extends JFrame {

	public ViewFrame() {
		init();
	}

	private void init() {
		final DrawPanel surface = new DrawPanel();
		surface.setBackground(Color.BLACK);
		add(surface);
		setSize(1200, 1200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}