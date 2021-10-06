package enums;

import java.util.Arrays;

public enum Turns {
    FRONT("F"),
    DOUBLE_FRONT("F2"),
    REVERSE_FRONT("F'"),

    BACK("B"),
    DOUBLE_BACK("B2"),
    REVERSE_BACK("B'"),

    UP("U"),
    DOUBLE_UP("U2"),
    REVERSE_UP("U'"),

    DOWN("D"),
    DOUBLE_DOWN("D2"),
    REVERSE_DOWN("D'"),

    RIGHT("R"),
    DOUBLE_RIGHT("R2"),
    REVERSE_RIGHT("R'"),

    LEFT("L"),
    DOUBLE_LEFT("L2"),
    REVERSE_LEFT("L'");

    final String description;

    Turns(String name) {
        this.description = name;
    }

    public String getDescription() {
        return description;
    }
}
