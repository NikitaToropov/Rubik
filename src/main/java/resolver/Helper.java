package resolver;

import cube.BigCube;
import enums.Turns;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * TODO в процессе.
 */
public class Helper {
    public static PriorityQueue<BigCube> expandTheState(BigCube parent) {
        return parent.phase == 1
                ? firstPhaseExpanding(parent)
                : secondPhaseExpanding(parent);
    }

    /**
     * U,D,L,R,F,B
     */
    private static PriorityQueue<BigCube> firstPhaseExpanding(BigCube parent) {
        PriorityQueue<BigCube> expandedStates = new PriorityQueue<>();

        /*
        UP-DOWN
         */
//        if (!Turns.UP.equals(parent.lastTurn)
//                && !Turns.DOUBLE_UP.equals(parent.lastTurn)
//                && !Turns.REVERSE_UP.equals(parent.lastTurn)) {
            expandedStates.add(parent.rotateUp());
//            expandedStates.add(parent.doubleRotateUp());
//            expandedStates.add(parent.reverseRotateUp());
//        }
//        if (!Turns.DOWN.equals(parent.lastTurn)
//                && !Turns.DOUBLE_DOWN.equals(parent.lastTurn)
//                && !Turns.REVERSE_DOWN.equals(parent.lastTurn)) {
            expandedStates.add(parent.rotateDown());
//            expandedStates.add(parent.doubleRotateDown());
//            expandedStates.add(parent.reverseRotateDown());
//        }
        /*
        LEFT-RIGHT
         */
//        if (!Turns.LEFT.equals(parent.lastTurn)
//                && !Turns.DOUBLE_LEFT.equals(parent.lastTurn)
//                && !Turns.REVERSE_LEFT.equals(parent.lastTurn)) {
            expandedStates.add(parent.rotateLeft());
//            expandedStates.add(parent.doubleRotateLeft());
//            expandedStates.add(parent.reverseRotateLeft());
//        }
//        if (!Turns.RIGHT.equals(parent.lastTurn)
//                && !Turns.DOUBLE_RIGHT.equals(parent.lastTurn)
//                && !Turns.REVERSE_RIGHT.equals(parent.lastTurn)) {
            expandedStates.add(parent.rotateRight());
//            expandedStates.add(parent.doubleRotateRight());
//            expandedStates.add(parent.reverseRotateRight());
//        }
        /*
        FRONT-BACK
         */
//        if (!Turns.FRONT.equals(parent.lastTurn)
//                && !Turns.DOUBLE_FRONT.equals(parent.lastTurn)
//                && !Turns.REVERSE_FRONT.equals(parent.lastTurn)) {
            expandedStates.add(parent.rotateFront());
//            expandedStates.add(parent.doubleRotateFront());
//            expandedStates.add(parent.reverseRotateFront());
//        }
//        if (!Turns.BACK.equals(parent.lastTurn)
//                && !Turns.DOUBLE_BACK.equals(parent.lastTurn)
//                && !Turns.REVERSE_BACK.equals(parent.lastTurn)) {
            expandedStates.add(parent.rotateBack());
//            expandedStates.add(parent.doubleRotateBack());
//            expandedStates.add(parent.reverseRotateBack());
//        }

        return expandedStates;
    }

    /**
     * U,D,L2,R2,F2,B2
     */
    private static PriorityQueue<BigCube> secondPhaseExpanding(BigCube parent) {
        PriorityQueue<BigCube> expandedStates = new PriorityQueue<>();

        if (parent.lastTurn == null || parent.lastTurn.equals(Turns.UP)) {
            expandedStates.add(parent.rotateUp());
        }
        if (parent.lastTurn == null || parent.lastTurn.equals(Turns.DOWN)) {
            expandedStates.add(parent.rotateDown());
        }
        if (parent.lastTurn == null || parent.lastTurn.equals(Turns.DOUBLE_LEFT)) {
            expandedStates.add(parent.doubleRotateLeft());
        }
        if (parent.lastTurn == null || parent.lastTurn.equals(Turns.DOUBLE_RIGHT)) {
            expandedStates.add(parent.doubleRotateRight());
        }
        if (parent.lastTurn == null || parent.lastTurn.equals(Turns.DOUBLE_FRONT)) {
            expandedStates.add(parent.doubleRotateBack());
        }
        if (parent.lastTurn == null || parent.lastTurn.equals(Turns.DOUBLE_BACK)) {
            expandedStates.add(parent.doubleRotateFront());
        }
        return expandedStates;
    }

    public static BigCube rotateTheCube(BigCube start, List<Turns> turns) {
        BigCube cube = start;
        for (Turns turn : turns) {
            cube = rotateByTurn(cube, turn);
        }
        cube.parent = null;
        cube.lastTurn = null;
        return cube;
    }

    private static BigCube rotateByTurn(BigCube cube, Turns turn) {
        if (turn.equals(Turns.FRONT)) {
            return cube.rotateFront();
        } else if (turn.equals(Turns.DOUBLE_FRONT)) {
            return cube.doubleRotateFront();
        } else if (turn.equals(Turns.REVERSE_FRONT)) {
            return cube.reverseRotateFront();
        } else if (turn.equals(Turns.BACK)) {
            return cube.rotateBack();
        } else if (turn.equals(Turns.DOUBLE_BACK)) {
            return cube.doubleRotateBack();
        } else if (turn.equals(Turns.REVERSE_BACK)) {
            return cube.reverseRotateBack();
        } else if (turn.equals(Turns.LEFT)) {
            return cube.rotateLeft();
        } else if (turn.equals(Turns.DOUBLE_LEFT)) {
            return cube.doubleRotateLeft();
        } else if (turn.equals(Turns.REVERSE_LEFT)) {
            return cube.reverseRotateLeft();
        } else if (turn.equals(Turns.RIGHT)) {
            return cube.rotateRight();
        } else if (turn.equals(Turns.DOUBLE_RIGHT)) {
            return cube.doubleRotateRight();
        } else if (turn.equals(Turns.REVERSE_RIGHT)) {
            return cube.reverseRotateRight();
        } else if (turn.equals(Turns.UP)) {
            return cube.rotateUp();
        } else if (turn.equals(Turns.DOUBLE_UP)) {
            return cube.doubleRotateUp();
        } else if (turn.equals(Turns.REVERSE_UP)) {
            return cube.reverseRotateUp();
        } else if (turn.equals(Turns.DOWN)) {
            return cube.rotateDown();
        } else if (turn.equals(Turns.DOUBLE_DOWN)) {
            return cube.doubleRotateDown();
        } else {
            return cube.reverseRotateDown();
        }
    }

    public static BigCube randomRotateTheCubeNTimes(BigCube cube, int n) {
        Random random = new Random();
        int tmp;
        BigCube result = cube;
        while (n != 0) {
            tmp = getRandomInRangeMinMaxInclusive(1, 18);

            /*
            RIGHT
             */
            if (tmp == 1) {
                result = result.rotateRight();
            } else if (tmp == 2) {
                result = result.reverseRotateRight();
            } else if (tmp == 3) {
                result = result.doubleRotateRight();
            }
            /*
            LEFT
             */
            else if (tmp == 4) {
                result = result.rotateLeft();
            } else if (tmp == 5) {
                result = result.reverseRotateLeft();
            } else if (tmp == 6) {
                result = result.doubleRotateLeft();
            }
            /*
            FRONT
             */
            else if (tmp == 7) {
                result = result.rotateFront();
            } else if (tmp == 8) {
                result = result.reverseRotateFront();
            } else if (tmp == 9) {
                result = result.doubleRotateFront();
            }
            /*
            BACK
             */
            else if (tmp == 10) {
                result = result.rotateBack();
            } else if (tmp == 11) {
                result = result.reverseRotateBack();
            } else if (tmp == 12) {
                result = result.doubleRotateBack();
            }
            /*
            UP
             */
            else if (tmp == 13) {
                result = result.rotateUp();
            } else if (tmp == 14) {
                result = result.reverseRotateUp();
            } else if (tmp == 15) {
                result = result.doubleRotateUp();
            }
            /*
            DOWN
             */
            else if (tmp == 16) {
                result = result.rotateDown();
            } else if (tmp == 17) {
                result = result.reverseRotateDown();
            } else {
                result = result.doubleRotateDown();
            }
            n--;
        }
        result.parent = null;
        result.score = result.score - result.stepNum;
        result.stepNum = 0;
        result.lastTurn = null;
        return result;
    }

    /**
     * Метод генерации случайных чисел в диапазоне. Включая min и max.
     */
    public static int getRandomInRangeMinMaxInclusive(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
