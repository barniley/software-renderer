package net.panasenkov.model.loader;

import lombok.Getter;
import net.panasenkov.model.ModelFileType;

import java.net.URL;

@Getter
public final class ModelLocation {

    private URL modelUrl;
    private ModelFileType type;

    private ModelLocation(String location, ModelFileType type) {
        this.modelUrl = getClass().getResource(location);
        this.type = type;
    }

    public static final ModelLocation CUBE_OBJ_MODEL = new ModelLocation(
            "/model/cube/cube.obj",
            ModelFileType.OBJ
    );

    public static final ModelLocation HEAD_OBJ_MODEL = new ModelLocation(
            "/model/head/african_head.obj",
            ModelFileType.OBJ
    );
}
