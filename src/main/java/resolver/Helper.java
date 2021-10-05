package resolver;

import cube.BigCube;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * TODO в процессе.
 */
public class Helper {
//    public static PriorityQueue<BigCube> expandTheState(BigCube previousState) {
//        PriorityQueue<BigCube> expandedStates = new PriorityQueue<>();
//
//        expandedStates.add(previousState.rotateFront());
//        expandedStates.add(previousState.reverseRotateFront());
//        expandedStates.add(previousState.doubleRotateFront());
//
//        expandedStates.add(previousState.rotateBack());
//        expandedStates.add(previousState.reverseRotateBack());
//        expandedStates.add(previousState.doubleRotateBack());
//
//        expandedStates.add(previousState.rotateRight());
//        expandedStates.add(previousState.reverseRotateRight());
//        expandedStates.add(previousState.doubleRotateRight());
//
//        expandedStates.add(previousState.rotateLeft());1
//        expandedStates.add(previousState.reverseRotateLeft());
//        expandedStates.add(previousState.doubleRotateLeft());
//
//        expandedStates.add(previousState.rotateUp());
//        expandedStates.add(previousState.reverseRotateUp());
//        expandedStates.add(previousState.doubleRotateUp());
//
//        expandedStates.add(previousState.rotateDown());
//        expandedStates.add(previousState.reverseRotateDown());
//        expandedStates.add(previousState.doubleRotateDown());
//
//        return expandedStates;
//    }


    public static PriorityQueue<BigCube> expandTheState(BigCube previousState) {
        PriorityQueue<BigCube> expandedStates = new PriorityQueue<>();

        expandedStates.add(previousState.rotateFront());

        expandedStates.add(previousState.rotateBack());

        expandedStates.add(previousState.rotateRight());

        expandedStates.add(previousState.rotateLeft());

        expandedStates.add(previousState.rotateUp());

        expandedStates.add(previousState.rotateDown());
        return expandedStates;
    }

    public static BigCube rotateTheCubeNTimes(BigCube cube, int n) {
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
        return result;
    }

    /**
     * Метод генерации случайных чисел в диапазоне. Включая min и max.
     */
    public static int getRandomInRangeMinMaxInclusive(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
