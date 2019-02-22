package net.panasenkov.model.parser;

import net.panasenkov.model.Model;

import java.nio.file.Path;

public interface ModelParser {
	Model parse(Path resourcePath);
}
