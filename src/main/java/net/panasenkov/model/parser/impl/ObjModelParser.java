package net.panasenkov.model.parser.impl;

import net.panasenkov.model.Model;
import net.panasenkov.model.parser.ModelParser;
import net.panasenkov.model.parser.ParseModelException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ObjModelParser implements ModelParser {

	@Override
	public Model parse(Path resourcePath) {
		try (Scanner scanner = new Scanner(resourcePath)) {
			Model model = new Model(new ArrayList<>(), new ArrayList<>());
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				Arrays.stream(ParseRoutine.values())
						.filter(parseRoutine -> parseRoutine.matches(currentLine))
						.findFirst()
						.ifPresent(parseRoutine -> parseRoutine.addTo(model, parseRoutine.parse(currentLine)));
			}
			return model;
		} catch (IOException e) {
			throw new ParseModelException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private enum ParseRoutine {
		VERTEX("v", "") {
			@Override
			public Vector<Float> parse(String line) {
				return null;
			}

			@Override
			public boolean matches(String line) {
				return false;
			}

			@Override
			public void addTo(Model model, Object parsedValue) {
				model.getVertices().add((Vector<Float>) parsedValue);
			}
		},

		FACE("f", "") {
			@Override
			public Vector<Integer> parse(String line) {
				return null;
			}

			@Override
			public boolean matches(String line) {
				return false;
			}

			@Override
			public void addTo(Model model, Object parsedValue) {
				model.getFaces().add((Vector<Integer>) parsedValue);
			}
		};

		private String startsWith;
		private String itemRegex;

		ParseRoutine(String startsWith, String itemRegex) {
			this.startsWith = startsWith;
			this.itemRegex = itemRegex;
		}

		public abstract Object parse(String line);
		public abstract boolean matches(String line);
		public abstract void addTo(Model model, Object parsedValue);
	}
}
