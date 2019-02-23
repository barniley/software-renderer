package net.panasenkov.model.loader;

import net.panasenkov.model.Model;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public final class ModelLoader {

    private ModelLoader() {
    }

    public static Model load(ModelLocation location) throws ModelLoaderException {
        try {
            return location.getType().getParser().parse(Paths.get(location.getModelUrl().toURI()));
        } catch (URISyntaxException e) {
            throw new ModelLoaderException(e);
        }
    }
}
