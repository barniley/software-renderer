package net.panasenkov.renderer;

public enum Color {
	WHITE(255, 255, 255, 0),
	RED(255, 0, 0, 0),
	BLUE(0, 0, 255, 0);

	private int red;
	private int green;
	private int blue;
	private int alpha;

	Color(int red, int green, int blue, int alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
}
