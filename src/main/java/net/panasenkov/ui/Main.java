package net.panasenkov.ui;

import java.awt.*;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			ViewFrame ex = new ViewFrame();
			ex.setVisible(true);
		});
	}
}