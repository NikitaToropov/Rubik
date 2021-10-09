package enums;

import cube.Cube;
import cube.CubeGoalRealisation;

import java.util.Arrays;
import java.util.List;

public enum Goal {
    CROSS_W,
    F2L1,
    F2L2,
    F2L3,
    F2L4,
    THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS,
    THIRD_LAYER_INCONSISTENT_CROSS_W,
    THIRD_LAYER_PARTIAL_CONSISTENT_CROSS,
    THIRD_LAYER_CROSS_W,
    THIRD_LAYER_CORNER_POSITION_1_W,
    THIRD_LAYER_CORNER_POSITIONS,
    THIRD_LAYER_1_CORNER,
    SOLVED;


    public static boolean satisfiesGoal(Cube cube, Goal goal) {
        List<Goal> goals = Arrays.asList(Goal.values());
        int lastIndex = goals.indexOf(goal);

        for (int i = 0; i <= lastIndex ; i++) {
            if (!isSolvedGoal(cube, goals.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSolvedGoal(Cube cube, Goal goal) {
        switch (goal) {
            case CROSS_W:
                if (!CubeGoalRealisation.crossW(cube)) return false;
                break;
            case THIRD_LAYER_INCONSISTENT_CROSS_W:
                if (!CubeGoalRealisation.inconsistentThirdLayerCrossU(cube)) return false;
                break;
            case THIRD_LAYER_CROSS_W:
                if (!CubeGoalRealisation.ThirdLayerCrossU(cube)) return false;
                break;
            case THIRD_LAYER_CORNER_POSITION_1_W:
                if (!CubeGoalRealisation.ThirdLayerCornerPositionU1(cube)) return false;
                break;
            case THIRD_LAYER_CORNER_POSITIONS:
                if (!CubeGoalRealisation.ThirdLayerCornerPositions(cube)) return false;
                break;
            case F2L1:
                if (!CubeGoalRealisation.F2L1(cube)) return false;
                break;
            case F2L2:
                if (!CubeGoalRealisation.F2L2(cube)) return false;
                break;
            case F2L3:
                if (!CubeGoalRealisation.F2L3(cube)) return false;
                break;
            case F2L4:
                if (!CubeGoalRealisation.F2L4(cube)) return false;
                break;
            case THIRD_LAYER_PARTIAL_CONSISTENT_CROSS:
                if (!CubeGoalRealisation.thirdLayerPartialConsistentCross(cube)) return false;
                break;
            case THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS:
                if (!CubeGoalRealisation.thirdLayerPartialInconsistentCross(cube)) return false;
                break;
            case THIRD_LAYER_1_CORNER:
                if (!CubeGoalRealisation.thirdLayer1Corner(cube)) return false;
                break;
            case SOLVED:
                if (!CubeGoalRealisation.solved(cube)) return false;
                break;
        }
        return true;
    }
}
