package net.panasenkov.model;

import lombok.Getter;
import net.panasenkov.model.parser.ModelParser;
import net.panasenkov.model.parser.impl.ObjModelParser;

@Getter
public enum ModelFileType {
    OBJ(new ObjModelParser());

    private ModelParser parser;

    ModelFileType(ModelParser parser) {
        this.parser = parser;
    }
}
