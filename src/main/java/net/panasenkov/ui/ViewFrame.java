package net.panasenkov.ui;

import javax.swing.*;

public class ViewFrame extends JFrame {

	public ViewFrame() {
		init();
	}

	private void init() {
		final DrawPanel surface = new DrawPanel();
		add(surface);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}