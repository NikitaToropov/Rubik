package enums;

import cube.Cube;

public enum Turn {
    FRONT("F", false),
    FRONT_DOUBLE("F2", false),
    FRONT_REVERSE("F'", false),

    BACK("B", false),
    BACK_DOUBLE("B2", false),
    BACK_REVERSE("B'", false),

    UP("U", false),
    UP_DOUBLE("U2", false),
    UP_REVERSE("U'", false),

    DOWN("D", false),
    DOWN_DOUBLE("D2", false),
    DOWN_REVERSE("D'", false),

    RIGHT("R", false),
    RIGHT_DOUBLE("R2", false),
    RIGHT_REVERSE("R'", false),

    LEFT("L", false),
    LEFT_DOUBLE("L2", false),
    LEFT_REVERSE("L'", false),
    A_1("A1", true),
    A_2("A2", true),
    A_3("A3", true),
    A_4("A4", true),
    A_5("A5", true),
    A_6("A6", true),
    A_7("A7", true),
    A_8("A8", true);

    public final String notation;
    public final boolean special;

    Turn(String name, boolean special) {
        this.notation = name;
        this.special = special;
    }

    public boolean isConflict(Turn turn) {
        if (this.equals(turn))
            return true;

        if (this.equals(FRONT) || this.equals(FRONT_DOUBLE) || this.equals(FRONT_REVERSE)) {
            return FRONT.equals(turn) || FRONT_DOUBLE.equals(turn) || FRONT_REVERSE.equals(turn);
        } else if (this.equals(BACK) || this.equals(BACK_DOUBLE) || this.equals(BACK_REVERSE)) {
            return BACK.equals(turn) || BACK_DOUBLE.equals(turn) || BACK_REVERSE.equals(turn);
        } else if (this.equals(RIGHT) || this.equals(RIGHT_DOUBLE) || this.equals(RIGHT_REVERSE)) {
            return RIGHT.equals(turn) || RIGHT_DOUBLE.equals(turn) || RIGHT_REVERSE.equals(turn);
        } else if (this.equals(LEFT) || this.equals(LEFT_DOUBLE) || this.equals(LEFT_REVERSE)) {
            return LEFT.equals(turn) || LEFT_DOUBLE.equals(turn) || LEFT_REVERSE.equals(turn);
        } else if (this.equals(UP) || this.equals(UP_DOUBLE) || this.equals(UP_REVERSE)) {
            return UP.equals(turn) || UP_DOUBLE.equals(turn) || UP_REVERSE.equals(turn);
        } else if (this.equals(DOWN) || this.equals(DOWN_DOUBLE) || this.equals(DOWN_REVERSE)) {
            return DOWN.equals(turn) || DOWN_DOUBLE.equals(turn) || DOWN_REVERSE.equals(turn);
        }

        /*
        TODO тут можно поэксперементировать!!!
         */
        else if (this.equals(A_1) || this.equals(A_2) || this.equals(A_3)) {
            return A_1.equals(turn) || A_2.equals(turn) || A_3.equals(turn);
        } else if (this.equals(A_4) || this.equals(A_5) || this.equals(A_6)) {
            return A_4.equals(turn) || A_5.equals(turn) || A_6.equals(turn);
        } else if (this.equals(A_7) || this.equals(A_8)) {
            return A_7.equals(turn) || A_8.equals(turn);
        }
//        else if (this.equals(A_1)) {
//            return A_1.equals(turn);
//        } else if (this.equals(A_2)) {
//            return A_2.equals(turn);
//        } else if (this.equals(A_3)) {
//            return A_3.equals(turn);
//        } else if (this.equals(A_4)) {
//            return A_4.equals(turn);
//        } else if (this.equals(A_5)) {
//            return A_5.equals(turn);
//        } else if (this.equals(A_6)) {
//            return A_6.equals(turn);
//        } else if (this.equals(A_7)) {
//            return A_7.equals(turn);
//        } else if (this.equals(A_8)) {
//            return A_8.equals(turn);
//        } else {
            return false;
//        }
    }

    public static String performTurn(Cube cube, Turn turn) {
        switch (turn) {
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
            case A_1:
                cube.rightReverse();
                cube.downReverse();
                cube.right();
                cube.down();
                cube.rightReverse();
                cube.downReverse();
                cube.right();
                cube.down();
                break;
            case A_2:
                cube.backReverse();
                cube.downReverse();
                cube.back();
                cube.down();
                cube.backReverse();
                cube.downReverse();
                cube.back();
                cube.down();
                break;
            case A_3:
                cube.leftReverse();
                cube.downReverse();
                cube.left();
                cube.down();
                cube.leftReverse();
                cube.downReverse();
                cube.left();
                cube.down();
                break;
            case A_4:
                cube.frontReverse();
                cube.downReverse();
                cube.front();
                cube.down();
                cube.frontReverse();
                cube.downReverse();
                cube.front();
                cube.down();
                break;
            case A_5:
                cube.rightReverse();
                cube.upReverse();
                cube.right();
                cube.up();
                cube.rightReverse();
                cube.upReverse();
                cube.right();
                cube.up();
                break;
            case A_6:
                cube.backReverse();
                cube.upReverse();
                cube.back();
                cube.up();
                cube.backReverse();
                cube.upReverse();
                cube.back();
                cube.up();
                break;
            case A_7:
                cube.leftReverse();
                cube.upReverse();
                cube.left();
                cube.up();
                cube.leftReverse();
                cube.upReverse();
                cube.left();
                cube.up();
                break;
            case A_8:
                cube.frontReverse();
                cube.upReverse();
                cube.front();
                cube.up();
                cube.frontReverse();
                cube.upReverse();
                cube.front();
                cube.up();
                break;
        }
        return turn.notation;
    }

    public void undoMove(Cube cube) {
        switch (this) {
            case FRONT:
                cube.frontReverse();
                break;
            case FRONT_DOUBLE:
                cube.frontDouble();
                break;
            case FRONT_REVERSE:
                cube.front();
                break;
            case BACK:
                cube.backReverse();
                break;
            case BACK_DOUBLE:
                cube.backDouble();
                break;
            case BACK_REVERSE:
                cube.back();
                break;
            case LEFT:
                cube.leftReverse();
                break;
            case LEFT_DOUBLE:
                cube.leftDouble();
                break;
            case LEFT_REVERSE:
                cube.left();
                break;
            case RIGHT:
                cube.rightReverse();
                break;
            case RIGHT_DOUBLE:
                cube.rightDouble();
                break;
            case RIGHT_REVERSE:
                cube.right();
                break;
            case UP:
                cube.upReverse();
                break;
            case UP_DOUBLE:
                cube.upDouble();
                break;
            case UP_REVERSE:
                cube.up();
                break;
            case DOWN:
                cube.downReverse();
                break;
            case DOWN_DOUBLE:
                cube.downDouble();
                break;
            case DOWN_REVERSE:
                cube.down();
                break;
            case A_1:
                cube.downReverse();
                cube.rightReverse();
                cube.down();
                cube.right();
                cube.downReverse();
                cube.rightReverse();
                cube.down();
                cube.right();
                break;
            case A_2:
                cube.downReverse();
                cube.backReverse();
                cube.down();
                cube.back();
                cube.downReverse();
                cube.backReverse();
                cube.down();
                cube.back();
                break;
            case A_3:
                cube.downReverse();
                cube.leftReverse();
                cube.down();
                cube.left();
                cube.downReverse();
                cube.leftReverse();
                cube.down();
                cube.left();
                break;
            case A_4:
                cube.downReverse();
                cube.frontReverse();
                cube.down();
                cube.front();
                cube.downReverse();
                cube.frontReverse();
                cube.down();
                cube.front();
                break;
            case A_5:
                cube.upReverse();
                cube.rightReverse();
                cube.up();
                cube.right();
                cube.upReverse();
                cube.rightReverse();
                cube.up();
                cube.right();
                break;
            case A_6:
                cube.upReverse();
                cube.backReverse();
                cube.up();
                cube.back();
                cube.upReverse();
                cube.backReverse();
                cube.up();
                cube.back();
                break;
            case A_7:
                cube.upReverse();
                cube.leftReverse();
                cube.up();
                cube.left();
                cube.upReverse();
                cube.leftReverse();
                cube.up();
                cube.left();
                break;
            case A_8:
                cube.upReverse();
                cube.frontReverse();
                cube.up();
                cube.front();
                cube.upReverse();
                cube.frontReverse();
                cube.up();
                cube.front();
                break;

        }
    }
}
