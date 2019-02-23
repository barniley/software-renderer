package net.panasenkov.model.parser.impl;

import junit.framework.TestCase;
import net.panasenkov.model.Model;
import net.panasenkov.model.parser.ModelParser;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class ObjModelParserTest {

    private static final String MODEL_CUBE_OBJ_LOCATION = "/model/cube/cube.obj";

    private final ModelParser parser = new ObjModelParser();

    @Test
    public void parse() throws URISyntaxException {
        Model model = parser.parse(Paths.get(getClass().getResource(MODEL_CUBE_OBJ_LOCATION).toURI()));
        TestCase.assertNotNull(model);
    }
}