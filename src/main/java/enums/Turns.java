package enums;

import java.util.Arrays;

public enum Turns {
    FRONT("F"),
    FRONT_DOUBLE("F2"),
    FRONT_REVERSE("F'"),

    BACK("B"),
    BACK_DOUBLE("B2"),
    BACK_REVERSE("B'"),

    UP("U"),
    UP_DOUBLE("U2"),
    UP_REVERSE("U'"),

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
