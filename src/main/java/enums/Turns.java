package enums;

import cube.Cube;

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
    DOWN_DOUBLE("D2"),
    DOWN_REVERSE("D'"),

    RIGHT("R"),
    RIGHT_DOUBLE("R2"),
    RIGHT_REVERSE("R'"),

    LEFT("L"),
    LEFT_DOUBLE("L2"),
    LEFT_REVERSE("L'");

    final String notation;

    Turns(String name) {
        this.notation = name;
    }

    public String getNotation() {
        return notation;
    }

    public static String performMove(Cube cube, Turns turn){
        switch(turn){
            case FRONT:
                cube.front();
                break;
            case FRONT_DOUBLE:
                cube.frontDouble();
                break;
            case FRONT_REVERSE:
                cube.frontReverse();
                break;
            case BACK:
                cube.back();
                break;
            case BACK_DOUBLE:
                cube.backDouble();
                break;
            case BACK_REVERSE:
                cube.backReverse();
                break;
            case LEFT:
                cube.left();
                break;
            case LEFT_DOUBLE:
                cube.leftDouble();
                break;
            case LEFT_REVERSE:
                cube.leftReverse();
                break;
            case RIGHT:
                cube.right();
                break;
            case RIGHT_DOUBLE:
                cube.rightDouble();
                break;
            case RIGHT_REVERSE:
                cube.rightReverse();
                break;
            case UP:
                cube.up();
                break;
            case UP_DOUBLE:
                cube.upDouble();
                break;
            case UP_REVERSE:
                cube.upReverse();
                break;
            case DOWN:
                cube.down();
                break;
            case DOWN_DOUBLE:
                cube.downDouble();
                break;
            case DOWN_REVERSE:
                cube.downReverse();
                break;
        }
        return turn.notation;
    }
}
