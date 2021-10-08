package solver;

import cube.Cube;
import cube.Rubiks_Cube_Goals_V2;
import enums.Goal;
import enums.Turn;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;


public class IDAStarSolver {

    private static final int MAX_STATE_COUNT = 1000000000;
    private static int stateCount = 0;

    public static void solveWithDecomposition(Cube cube) {
        ArrayList<Turn> turns = new ArrayList<>();
        Turn lastTurn = null;
        double bound = 0;
        long startTime = System.nanoTime();

//		for (int i = 0; i < goals.length; i++) {
        for (Goal goal : Goal.values()) {
            /*
            todo stack подходит оствь, не подходит, замени
             */
            Stack<Turn> turnStack = new Stack<>();
            bound = heuristic(cube);

            while (true) {
                double t = IDAStarSearch(cube, turnStack, 0, bound, goal, lastTurn); // todo сделать очевиднее переменную 't'


                if (t == -1) { //solution is found
                    break;
                }
                bound = t; //else increase bound and search again.
                if (t == -2) { //error occured (to many state checks);
                    break;
                }
            }
            if (bound == -2) {
                break; //exit because of state overflow
            }

            //create arraylist to transfer moves from the stack.
            ArrayList<Turn> this_goals_turns = new ArrayList<>();

            while (!turnStack.isEmpty()) { //copy each move used to solve this subgoal
                this_goals_turns.add(0, turnStack.pop()); //add to front to invert stack order
            }
            turns.addAll(this_goals_turns); //add all moves from this goal to the master list
            //Display report
//			if(VERBOSE){
//				System.out.println("Solved Goal: " + goals[i]);
//				System.out.println("Current Number of States searched: " + stateCount);
//				System.out.println("Current Number of Moves: " + turns.size());
//				System.out.println("This Goals Move: " + this_goals_turns);
//				cube.printCube();
//				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//			}
        }
        if (bound == -2) { //if state search overflow
            System.out.println("The Search explored " + MAX_STATE_COUNT + " states and did not");
            System.out.println("find a solution. Decomposition aborted");
            return;
        }
        //Some goals use algorithms as a single move duiring IDA*. Convert these back to
        //orignal 18 moves.
        replaceAlgorithms(turns);
        long timeInterval = System.nanoTime() - startTime;
        System.out.println("Working time = " + TimeUnit.NANOSECONDS.toSeconds(timeInterval) + " seconds");
        System.out.println("================= REPORT ENDS HERE ================");
//		if(VERBOSE)System.out.println("This Search explored " + stateCount + " states.");
        //Display Solution
        System.out.println("SOLUTION: (" + turns.size() + " moves)\n");
//        for (int i = 0; i < turns.size() / 10; i++) {
//            turns.add(10 + (i * 10), "\n");
//        }
        for (Turn turn : turns) {
            System.out.print(turn.notation + " ");
        }
        System.out.println("\n");

    }

    public static double IDAStarSearch(Cube cube, Stack<Turn> turns, int step, double bound, Goal goal, Turn lastTurn) {

        if (Goal.satisfiesGoal(cube, goal)) {
            return -1;
        }
        double f = step + heuristic(cube);
        if (f > bound) {
            return f;
        }

        boolean specialGoal = Goal.SOLVED.equals(goal) || Goal.THIRD_LAYER_1_CORNER.equals(goal);
        double min = -1; // resolved by default.

        for (Turn turn : Turn.values()) {
            if (turn.special && !specialGoal) {
                break;
            }
            if (turn.isConflict(lastTurn)) {
                continue;
            }
            stateCount++; // todo проверить возможность укоротить код и инкрементить в условии

            if (stateCount >= MAX_STATE_COUNT) {  //todo - нахуй не нужно
                return -2;
            }

            turns.push(turn);
            Turn.performTurn(cube, turn);

            double t = IDAStarSearch(cube, turns, step + 1, bound, goal, turn);

            if (t == -1) {
                return -1;
            }
            if (t < min || min == -1) {
                min = t;
            }

            turns.pop();

            turn.undoMove(cube);
        }
        return min;
    }

    /**
     * TODO double нужно будет заменить на int, если не буду добавлять деление.
     */
    private static double heuristic(Cube cube) {
        double val = 20;
        if (Rubiks_Cube_Goals_V2.piece1(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece2(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece3(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece4(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece5(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece6(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece7(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece8(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece9(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece10(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece11(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece12(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece13(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece14(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece15(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece16(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece17(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece18(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece19(cube)) val--;
        if (Rubiks_Cube_Goals_V2.piece20(cube)) val--;

        return val;
    }


    /* This function replaces an Algorithm in the ArrayList of strings with all of the     ~~~~~ *
     * turns.                                                                              ~~~~~ */
    private static void replaceAlgorithms(ArrayList<Turn> turns) {
        /*
        TODO  нужно перепроверить замену
         */
        Turn[] A1 = {Turn.RIGHT_REVERSE, Turn.DOWN_REVERSE, Turn.RIGHT, Turn.DOWN, Turn.RIGHT_REVERSE, Turn.DOWN_REVERSE, Turn.RIGHT, Turn.DOWN};
        Turn[] A2 = {Turn.BACK_REVERSE, Turn.DOWN_REVERSE, Turn.BACK, Turn.DOWN, Turn.BACK_REVERSE, Turn.DOWN_REVERSE, Turn.BACK, Turn.DOWN};
        Turn[] A3 = {Turn.LEFT_REVERSE, Turn.DOWN_REVERSE, Turn.LEFT, Turn.DOWN, Turn.LEFT_REVERSE, Turn.DOWN_REVERSE, Turn.LEFT, Turn.DOWN};
        Turn[] A4 = {Turn.FRONT_REVERSE, Turn.DOWN_REVERSE, Turn.FRONT, Turn.DOWN, Turn.FRONT_REVERSE, Turn.DOWN_REVERSE, Turn.FRONT, Turn.DOWN};
        Turn[] A5 = {Turn.RIGHT_REVERSE, Turn.UP_REVERSE, Turn.RIGHT, Turn.UP, Turn.RIGHT_REVERSE, Turn.UP_REVERSE, Turn.RIGHT, Turn.UP};
        Turn[] A6 = {Turn.BACK_REVERSE, Turn.UP_REVERSE, Turn.BACK, Turn.UP, Turn.BACK_REVERSE, Turn.UP_REVERSE, Turn.BACK, Turn.UP};
        Turn[] A7 = {Turn.LEFT_REVERSE, Turn.UP_REVERSE, Turn.LEFT, Turn.UP, Turn.LEFT_REVERSE, Turn.UP_REVERSE, Turn.LEFT, Turn.UP};
        Turn[] A8 = {Turn.FRONT_REVERSE, Turn.UP_REVERSE, Turn.FRONT, Turn.UP, Turn.FRONT_REVERSE, Turn.UP_REVERSE, Turn.FRONT, Turn.UP};


        while (turns.contains(Turn.A_1)) {
            int index = turns.indexOf(Turn.A_1);
            turns.remove(index);
            for (int i = 0; i < A1.length; i++) {
                turns.add(i + index, A1[i]);
            }
        }

        while (turns.contains(Turn.A_2)) {
            int index = turns.indexOf(Turn.A_2);
            turns.remove(index);
            for (int i = 0; i < A2.length; i++) {
                turns.add(i + index, A2[i]);
            }
        }

        while (turns.contains(Turn.A_3)) {
            int index = turns.indexOf(Turn.A_3);
            turns.remove(index);
            for (int i = 0; i < A3.length; i++) {
                turns.add(i + index, A3[i]);
            }
        }

        while (turns.contains(Turn.A_4)) {
            int index = turns.indexOf(Turn.A_4);
            turns.remove(index);
            for (int i = 0; i < A4.length; i++) {
                turns.add(i + index, A4[i]);
            }
        }

        while (turns.contains(Turn.A_5)) {
            int index = turns.indexOf(Turn.A_5);
            turns.remove(index);
            for (int i = 0; i < A5.length; i++) {
                turns.add(i + index, A5[i]);
            }
        }

        while (turns.contains(Turn.A_6)) {
            int index = turns.indexOf(Turn.A_6);
            turns.remove(index);
            for (int i = 0; i < A6.length; i++) {
                turns.add(i + index, A6[i]);
            }
        }

        while (turns.contains(Turn.A_7)) {
            int index = turns.indexOf(Turn.A_7);
            turns.remove(index);
            for (int i = 0; i < A7.length; i++) {
                turns.add(i + index, A7[i]);
            }
        }

        while (turns.contains(Turn.A_8)) {
            int index = turns.indexOf(Turn.A_8);
            turns.remove(index);
            for (int i = 0; i < A8.length; i++) {
                turns.add(i + index, A8[i]);
            }
        }
    }
}