import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class IDAStarResolver {
    public static final Goal[] HUMAN_LIKE_DECOMPOSITION = {
            Goal.CROSS_W,
            Goal.FIRST_LAYER_1_W,
            Goal.FIRST_LAYER_2_W,
            Goal.FIRST_LAYER_3_W,
            Goal.FIRST_LAYER_4_W,
            Goal.SECOND_LAYER_1_W,
            Goal.SECOND_LAYER_2_W,
            Goal.SECOND_LAYER_3_W,
            Goal.SECOND_LAYER_4_W,
            Goal.THIRD_LAYER_INCONSISTENT_CROSS_W,
            Goal.THIRD_LAYER_CROSS_W,
            Goal.THIRD_LAYER_CORNER_POSITION_1_W,
            Goal.THIRD_LAYER_CORNER_POSITIONS,
            Goal.SOLVED
    };

    public static final Goal[] IMPROVED_FRIEDRICH_DECOMPOSITION = {
            Goal.CROSS_W,
            Goal.F2L1,
            Goal.F2L2,
            Goal.F2L3,
            Goal.F2L4,
            Goal.THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS,
            Goal.THIRD_LAYER_INCONSISTENT_CROSS_W,
            Goal.THIRD_LAYER_PARTIAL_CONSISTENT_CROSS,
            Goal.THIRD_LAYER_CROSS_W,
            Goal.THIRD_LAYER_CORNER_POSITION_1_W,
            Goal.THIRD_LAYER_CORNER_POSITIONS,
            Goal.THIRD_LAYER_1_CORNER,
            Goal.SOLVED
    };

    public static Goal[] getRandomDecomposition(){
        ArrayList<Goal> all_goals = new ArrayList<Goal>();

        all_goals.add(Goal.PIECE1);
        all_goals.add(Goal.PIECE2);
        all_goals.add(Goal.PIECE3);
        all_goals.add(Goal.PIECE4);
        all_goals.add(Goal.PIECE5);
        all_goals.add(Goal.PIECE6);
        all_goals.add(Goal.PIECE7);
        all_goals.add(Goal.PIECE8);
        all_goals.add(Goal.PIECE9);
        all_goals.add(Goal.PIECE10);
        all_goals.add(Goal.PIECE11);
        all_goals.add(Goal.PIECE12);
        all_goals.add(Goal.PIECE13);
        all_goals.add(Goal.PIECE14);
        all_goals.add(Goal.PIECE15);
        all_goals.add(Goal.PIECE16);
        all_goals.add(Goal.PIECE17);
        all_goals.add(Goal.PIECE18);
        all_goals.add(Goal.PIECE19);
        all_goals.add(Goal.PIECE20);

        Random random = new Random();

        Goal[] random_decomp = new Goal[20];

        for(int i = 0; i < 20; i++){
            int rand = random.nextInt(all_goals.size());
            random_decomp[i] = all_goals.get(rand);
            all_goals.remove(rand);
        }
        return random_decomp;
    }

    public static void solveWithDecomposition(Cube cube, Goal[] goals) {
        System.out.println("============== RESOLVING STARTS HERE ==============");
        cube.printCube();
        ArrayList<String> turns_list = new ArrayList<String>();
        int lastTurn = -1;
        int bound = 0;
        long totalTime = System.nanoTime();
        for (int i = 0; i < goals.length; i++) {
            Stack<String> turn_stack = new Stack<>();
            bound = heuristic(cube);

            while (true) {
                int t = IDAStarSearch(cube, turn_stack, 0, bound, goals, i, lastTurn);
                if (t < 0) break;
                bound = t;
            }
            while (!turn_stack.isEmpty()) {
                turns_list.add(0, turn_stack.pop());
            }
        }
        long time = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - totalTime);
        time = time > 1 ? time - 1 : time;
        replaceAlgorithms(turns_list);

        //Display Solution
        System.out.println("SOLUTION: (" + turns_list.size() + " turns)");
        System.out.println("TOTAL TIME = " + (time + " seconds"));
        turns_list.forEach(t -> System.out.printf(t + " "));

    }

    public static int IDAStarSearch(Cube cube, Stack<String> turns, int cost, int bound, Goal[] goals, int goalIndex, int last_move) {

        if (satisfiesGoal(cube, goals, goalIndex)) return -1;
        int f = cost + heuristic(cube);
        if (f > bound) return f;


        boolean special_goal = goals[goalIndex] == Goal.SOLVED
                || goals[goalIndex] == Goal.THIRD_LAYER_1_CORNER;

        int min = -1;

        for (int i = 0; i < (special_goal ? 26 : 18); i++) {
            if (i / 3 == last_move / 3) {
                continue;
            }
            turns.push(performMove2(cube, i));
            int t = IDAStarSearch(cube, turns, cost + 1, bound, goals, goalIndex, i);

            if (t == -1) return -1;
            if (t < min || min == -1) min = t;

            turns.pop();

            undoMove2(cube, i);
        }
        return min;
    }

    private static String performMove2(Cube cube, int i) {
        switch (i) {
            case 0:
                cube.front();
                return "F";
            case 1:
                cube.frontDouble();
                return "F2";
            case 2:
                cube.frontReverse();
                return "F'";
            case 3:
                cube.back();
                return "B";
            case 4:
                cube.backDouble();
                return "B2";
            case 5:
                cube.backReverse();
                return "B'";
            case 6:
                cube.left();
                return "L";
            case 7:
                cube.leftDouble();
                return "L2";
            case 8:
                cube.leftReverse();
                return "L'";
            case 9:
                cube.right();
                return "R";
            case 10:
                cube.rightDouble();
                return "R2";
            case 11:
                cube.rightReverse();
                return "R'";
            case 12:
                cube.up();
                return "U";
            case 13:
                cube.upDouble();
                return "U2";
            case 14:
                cube.upReverse();
                return "U'";
            case 15:
                cube.down();
                return "D";
            case 16:
                cube.downDouble();
                return "D2";
            case 17:
                cube.downReverse();
                return "D'";
            /* Add algorithms */
            case 18:
                cube.rightReverse();
                cube.downReverse();
                cube.right();
                cube.down();
                cube.rightReverse();
                cube.downReverse();
                cube.right();
                cube.down();
                return "A1";
            case 19:
                cube.backReverse();
                cube.downReverse();
                cube.back();
                cube.down();
                cube.backReverse();
                cube.downReverse();
                cube.back();
                cube.down();
                return "A2";
            case 20:
                cube.leftReverse();
                cube.downReverse();
                cube.left();
                cube.down();
                cube.leftReverse();
                cube.downReverse();
                cube.left();
                cube.down();
                return "A3";
            case 21:
                cube.frontReverse();
                cube.downReverse();
                cube.front();
                cube.down();
                cube.frontReverse();
                cube.downReverse();
                cube.front();
                cube.down();
                return "A4";
            case 22:
                cube.rightReverse();
                cube.upReverse();
                cube.right();
                cube.up();
                cube.rightReverse();
                cube.upReverse();
                cube.right();
                cube.up();
                return "A5";
            case 23:
                cube.backReverse();
                cube.upReverse();
                cube.back();
                cube.up();
                cube.backReverse();
                cube.upReverse();
                cube.back();
                cube.up();
                return "A6";
            case 24:
                cube.leftReverse();
                cube.upReverse();
                cube.left();
                cube.up();
                cube.leftReverse();
                cube.upReverse();
                cube.left();
                cube.up();
                return "A7";
            case 25:
                cube.frontReverse();
                cube.upReverse();
                cube.front();
                cube.up();
                cube.frontReverse();
                cube.upReverse();
                cube.front();
                cube.up();
                return "A8";
        }
        return "";
    }

    private static void undoMove2(Cube cube, int i) {
        switch (i) {
            case 0:
                cube.frontReverse();
                break;
            case 1:
                cube.frontDouble();
                break;
            case 2:
                cube.front();
                break;
            case 3:
                cube.backReverse();
                break;
            case 4:
                cube.backDouble();
                break;
            case 5:
                cube.back();
                break;
            case 6:
                cube.leftReverse();
                break;
            case 7:
                cube.leftDouble();
                break;
            case 8:
                cube.left();
                break;
            case 9:
                cube.rightReverse();
                break;
            case 10:
                cube.rightDouble();
                break;
            case 11:
                cube.right();
                break;
            case 12:
                cube.upReverse();
                break;
            case 13:
                cube.upDouble();
                break;
            case 14:
                cube.up();
                break;
            case 15:
                cube.downReverse();
                break;
            case 16:
                cube.downDouble();
                break;
            case 17:
                cube.down();
                break;
            case 18:
                cube.downReverse();
                cube.rightReverse();
                cube.down();
                cube.right();
                cube.downReverse();
                cube.rightReverse();
                cube.down();
                cube.right();
                break;
            case 19:
                cube.downReverse();
                cube.backReverse();
                cube.down();
                cube.back();
                cube.downReverse();
                cube.backReverse();
                cube.down();
                cube.back();
                break;
            case 20:
                cube.downReverse();
                cube.leftReverse();
                cube.down();
                cube.left();
                cube.downReverse();
                cube.leftReverse();
                cube.down();
                cube.left();
                break;
            case 21:
                cube.downReverse();
                cube.frontReverse();
                cube.down();
                cube.front();
                cube.downReverse();
                cube.frontReverse();
                cube.down();
                cube.front();
                break;
            case 22:
                cube.upReverse();
                cube.rightReverse();
                cube.up();
                cube.right();
                cube.upReverse();
                cube.rightReverse();
                cube.up();
                cube.right();
                break;
            case 23:
                cube.upReverse();
                cube.backReverse();
                cube.up();
                cube.back();
                cube.upReverse();
                cube.backReverse();
                cube.up();
                cube.back();
                break;
            case 24:
                cube.upReverse();
                cube.leftReverse();
                cube.up();
                cube.left();
                cube.upReverse();
                cube.leftReverse();
                cube.up();
                cube.left();
                break;
            case 25:
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

    public static boolean satisfiesGoal(Cube cube, Goal[] goals, int goal_index) {
        for (int i = 0; i <= goal_index; i++) {
            Goal goal = goals[i];
            switch (goal) {
                case PIECE1:
                    if (!CubeGoalsUtil.piece1(cube)) return false;
                    break;
                case PIECE2:
                    if (!CubeGoalsUtil.piece2(cube)) return false;
                    break;
                case PIECE3:
                    if (!CubeGoalsUtil.piece3(cube)) return false;
                    break;
                case PIECE4:
                    if (!CubeGoalsUtil.piece4(cube)) return false;
                    break;
                case PIECE5:
                    if (!CubeGoalsUtil.piece5(cube)) return false;
                    break;
                case PIECE6:
                    if (!CubeGoalsUtil.piece6(cube)) return false;
                    break;
                case PIECE7:
                    if (!CubeGoalsUtil.piece7(cube)) return false;
                    break;
                case PIECE8:
                    if (!CubeGoalsUtil.piece8(cube)) return false;
                    break;
                case PIECE9:
                    if (!CubeGoalsUtil.piece9(cube)) return false;
                    break;
                case PIECE10:
                    if (!CubeGoalsUtil.piece10(cube)) return false;
                    break;
                case PIECE11:
                    if (!CubeGoalsUtil.piece11(cube)) return false;
                    break;
                case PIECE12:
                    if (!CubeGoalsUtil.piece12(cube)) return false;
                    break;
                case PIECE13:
                    if (!CubeGoalsUtil.piece13(cube)) return false;
                    break;
                case PIECE14:
                    if (!CubeGoalsUtil.piece14(cube)) return false;
                    break;
                case PIECE15:
                    if (!CubeGoalsUtil.piece15(cube)) return false;
                    break;
                case PIECE16:
                    if (!CubeGoalsUtil.piece16(cube)) return false;
                    break;
                case PIECE17:
                    if (!CubeGoalsUtil.piece17(cube)) return false;
                    break;
                case PIECE18:
                    if (!CubeGoalsUtil.piece18(cube)) return false;
                    break;
                case PIECE19:
                    if (!CubeGoalsUtil.piece19(cube)) return false;
                    break;
                case PIECE20:
                    if (!CubeGoalsUtil.piece20(cube)) return false;
                    break;


                case CROSS_W:
                    if (!CubeGoalsUtil.crossU(cube)) return false;
                    break;
                case FIRST_LAYER_1_W:
                    if (!CubeGoalsUtil.firstLayerU1(cube)) return false;
                    break;
                case FIRST_LAYER_2_W:
                    if (!CubeGoalsUtil.firstLayerU2(cube)) return false;
                    break;
                case FIRST_LAYER_3_W:
                    if (!CubeGoalsUtil.firstLayerU3(cube)) return false;
                    break;
                case FIRST_LAYER_4_W:
                    if (!CubeGoalsUtil.firstLayerU4(cube)) return false;
                    break;
                case SECOND_LAYER_1_W:
                    if (!CubeGoalsUtil.secondLayerU1(cube)) return false;
                    break;
                case SECOND_LAYER_2_W:
                    if (!CubeGoalsUtil.secondLayerU2(cube)) return false;
                    break;
                case SECOND_LAYER_3_W:
                    if (!CubeGoalsUtil.secondLayerU3(cube)) return false;
                    break;
                case SECOND_LAYER_4_W:
                    if (!CubeGoalsUtil.secondLayerU4(cube)) return false;
                    break;
                case THIRD_LAYER_INCONSISTENT_CROSS_W:
                    if (!CubeGoalsUtil.inconsistentThirdLayerCrossU(cube)) return false;
                    break;
                case THIRD_LAYER_CROSS_W:
                    if (!CubeGoalsUtil.ThirdLayerCrossU(cube)) return false;
                    break;
                case THIRD_LAYER_CORNER_POSITION_1_W:
                    if (!CubeGoalsUtil.ThirdLayerCornerPositionU1(cube)) return false;
                    break;
                case THIRD_LAYER_CORNER_POSITIONS:
                    if (!CubeGoalsUtil.ThirdLayerCornerPositions(cube)) return false;
                    break;
                case F2L1:
                    if (!CubeGoalsUtil.F2L1(cube)) return false;
                    break;
                case F2L2:
                    if (!CubeGoalsUtil.F2L2(cube)) return false;
                    break;
                case F2L3:
                    if (!CubeGoalsUtil.F2L3(cube)) return false;
                    break;
                case F2L4:
                    if (!CubeGoalsUtil.F2L4(cube)) return false;
                    break;
                case THIRD_LAYER_PARTIAL_CONSISTENT_CROSS:
                    if (!CubeGoalsUtil.thirdLayerPartialConsistentCross(cube)) return false;
                    break;
                case THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS:
                    if (!CubeGoalsUtil.thirdLayerPartialInconsistentCross(cube)) return false;
                    break;
                case THIRD_LAYER_1_CORNER:
                    if (!CubeGoalsUtil.thirdLayer1Corner(cube)) return false;
                    break;

                case SOLVED:
                    if (!CubeGoalsUtil.solved(cube)) return false;
                    break;
            }
        }
        return true;
    }

    private static int heuristic(Cube cube) {
        int val = 20;
        if (CubeGoalsUtil.piece1(cube)) val--;
        if (CubeGoalsUtil.piece2(cube)) val--;
        if (CubeGoalsUtil.piece3(cube)) val--;
        if (CubeGoalsUtil.piece4(cube)) val--;
        if (CubeGoalsUtil.piece5(cube)) val--;
        if (CubeGoalsUtil.piece6(cube)) val--;
        if (CubeGoalsUtil.piece7(cube)) val--;
        if (CubeGoalsUtil.piece8(cube)) val--;
        if (CubeGoalsUtil.piece9(cube)) val--;
        if (CubeGoalsUtil.piece10(cube)) val--;
        if (CubeGoalsUtil.piece11(cube)) val--;
        if (CubeGoalsUtil.piece12(cube)) val--;
        if (CubeGoalsUtil.piece13(cube)) val--;
        if (CubeGoalsUtil.piece14(cube)) val--;
        if (CubeGoalsUtil.piece15(cube)) val--;
        if (CubeGoalsUtil.piece16(cube)) val--;
        if (CubeGoalsUtil.piece17(cube)) val--;
        if (CubeGoalsUtil.piece18(cube)) val--;
        if (CubeGoalsUtil.piece19(cube)) val--;
        if (CubeGoalsUtil.piece20(cube)) val--;
        return val;
    }


    private static void replaceAlgorithms(ArrayList<String> turns) {
        String[] A1 = {"R'", "D'", "R", "D", "R'", "D'", "R", "D"};
        String[] A2 = {"B'", "D'", "B", "D", "B'", "D'", "B", "D"};
        String[] A3 = {"L'", "D'", "L", "D", "L'", "D'", "L", "D"};
        String[] A4 = {"F'", "D'", "F", "D", "F'", "D'", "F", "D"};
        String[] A5 = {"R'", "U'", "R", "U", "R'", "U'", "R", "U"};
        String[] A6 = {"B'", "U'", "B", "U", "B'", "U'", "B", "U"};
        String[] A7 = {"L'", "U'", "L", "U", "L'", "U'", "L", "U"};
        String[] A8 = {"F'", "U'", "F", "U", "F'", "U'", "F", "U"};


        while (turns.contains("A1")) {
            int index = turns.indexOf("A1");
            turns.remove(index);
            for (int i = 0; i < A1.length; i++) {
                turns.add(i + index, A1[i]);
            }
        }

        while (turns.contains("A2")) {
            int index = turns.indexOf("A2");
            turns.remove(index);
            for (int i = 0; i < A2.length; i++) {
                turns.add(i + index, A2[i]);
            }
        }

        while (turns.contains("A3")) {
            int index = turns.indexOf("A3");
            turns.remove(index);
            for (int i = 0; i < A3.length; i++) {
                turns.add(i + index, A3[i]);
            }
        }

        while (turns.contains("A4")) {
            int index = turns.indexOf("A4");
            turns.remove(index);
            for (int i = 0; i < A4.length; i++) {
                turns.add(i + index, A4[i]);
            }
        }

        while (turns.contains("A5")) {
            int index = turns.indexOf("A5");
            turns.remove(index);
            for (int i = 0; i < A5.length; i++) {
                turns.add(i + index, A5[i]);
            }
        }

        while (turns.contains("A6")) {
            int index = turns.indexOf("A6");
            turns.remove(index);
            for (int i = 0; i < A6.length; i++) {
                turns.add(i + index, A6[i]);
            }
        }

        while (turns.contains("A7")) {
            int index = turns.indexOf("A7");
            turns.remove(index);
            for (int i = 0; i < A7.length; i++) {
                turns.add(i + index, A7[i]);
            }
        }

        while (turns.contains("A8")) {
            int index = turns.indexOf("A8");
            turns.remove(index);
            for (int i = 0; i < A8.length; i++) {
                turns.add(i + index, A8[i]);
            }
        }
    }
}