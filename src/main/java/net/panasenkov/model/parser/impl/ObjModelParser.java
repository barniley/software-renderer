package net.panasenkov.model.parser.impl;

import com.google.common.base.Preconditions;
import net.panasenkov.model.Face;
import net.panasenkov.model.Model;
import net.panasenkov.model.parser.ModelParser;
import net.panasenkov.model.parser.ParseModelException;
import net.panasenkov.model.parser.Vec3;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        } catch (Exception e) {
            throw new ParseModelException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private enum ParseRoutine {
        VERTEX("v ", "[-+]?\\d+(\\.\\d+(e[-+]?\\d+)?)?") {
            @Override
            public Vec3<Float> parse(String line) {
                Matcher matcher = itemRegex.matcher(line);
                List<Float> components = new ArrayList<>();
                while (matcher.find()) {
                    components.add(Float.parseFloat(matcher.group()));
                }
                Preconditions.checkState(components.size() == 3);
                return new Vec3(components.get(0), components.get(1), components.get(2));
            }

            @Override
            public boolean matches(String line) {
                return line.startsWith(linePrefix);
            }

            @Override
            public void addTo(Model model, Object parsedValue) {
                model.getVertices().add((Vec3<Float>) parsedValue);
            }
        },

        FACE("f ", "[\\d/]+") {
            @Override
            public Face parse(String line) {
                Matcher matcher = itemRegex.matcher(line);
                List<Integer> vertexIndexes = new ArrayList<>();
                while (matcher.find()) {
                    String[] items = matcher.group().split("/");
                    Preconditions.checkState(items.length > 0);
                    vertexIndexes.add(Integer.parseInt(items[0]));
                }
                return new Face(vertexIndexes);
            }

            @Override
            public boolean matches(String line) {
                return line.startsWith(linePrefix);
            }

            @Override
            public void addTo(Model model, Object parsedValue) {
                model.getFaces().add((Face) parsedValue);
            }
        };

        protected final String linePrefix;
        protected final Pattern itemRegex;

        ParseRoutine(String linePrefix, String itemRegex) {
            this.linePrefix = linePrefix;
            this.itemRegex = Pattern.compile(itemRegex);
        }

        public abstract Object parse(String line);

        public abstract boolean matches(String line);

        public abstract void addTo(Model model, Object parsedValue);
    }
}
