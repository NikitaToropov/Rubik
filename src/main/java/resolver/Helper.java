package resolver;

import cube.BigCube;

import java.util.PriorityQueue;

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
}
