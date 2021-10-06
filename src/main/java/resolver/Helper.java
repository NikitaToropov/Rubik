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
    public static PriorityQueue<BigCube> expandTheState(BigCube previousState) {
        PriorityQueue<BigCube> expandedStates = new PriorityQueue<>();

        expandedStates.add(previousState.rotateFront());
        expandedStates.add(previousState.reverseRotateFront());
        expandedStates.add(previousState.doubleRotateFront());

        expandedStates.add(previousState.rotateBack());
        expandedStates.add(previousState.reverseRotateBack());
        expandedStates.add(previousState.doubleRotateBack());

        expandedStates.add(previousState.rotateRight());
        expandedStates.add(previousState.reverseRotateRight());
        expandedStates.add(previousState.doubleRotateRight());

        expandedStates.add(previousState.rotateLeft());
        expandedStates.add(previousState.reverseRotateLeft());
        expandedStates.add(previousState.doubleRotateLeft());

        expandedStates.add(previousState.rotateUp());
        expandedStates.add(previousState.reverseRotateUp());
        expandedStates.add(previousState.doubleRotateUp());

        expandedStates.add(previousState.rotateDown());
        expandedStates.add(previousState.reverseRotateDown());
        expandedStates.add(previousState.doubleRotateDown());

        return expandedStates;
    }


//    public static PriorityQueue<BigCube> expandTheState(BigCube parent) {
//        PriorityQueue<BigCube> expandedStates = new PriorityQueue<>();
////        if (isNotGranny(parent, Rotations.FRONT)) {
//            expandedStates.add(parent.rotateFront());
////        }
////        if (isNotGranny(parent, Rotations.BACK)) {
//            expandedStates.add(parent.rotateBack());
////        }
////        if (isNotGranny(parent, Rotations.RIGHT)) {
//            expandedStates.add(parent.rotateRight());
////        }
////        if (isNotGranny(parent, Rotations.LEFT)) {
//            expandedStates.add(parent.rotateLeft());
////        }
////        if (isNotGranny(parent, Rotations.UP)) {
//            expandedStates.add(parent.rotateUp());
////        }
////        if (isNotGranny(parent, Rotations.DOWN)) {
//            expandedStates.add(parent.rotateDown());
////        }
//        return expandedStates;
//    }

    public static BigCube rotateTheCube(BigCube start, List<Turns> turns) {
        BigCube cube = start;
        for (Turns turn : turns) {
            cube = rotateByTurn(cube, turn);
        }
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
        result.moveToCurrent = null;
        return result;
    }

    /**
     * Метод генерации случайных чисел в диапазоне. Включая min и max.
     */
    public static int getRandomInRangeMinMaxInclusive(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
