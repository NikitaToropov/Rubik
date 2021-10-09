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
            case CROSS_W: //754
                if (!CubeGoalRealisation.crossW(cube)) return false;
                break;
            case THIRD_LAYER_INCONSISTENT_CROSS_W: //781
                if (!CubeGoalRealisation.inconsistentThirdLayerCrossU(cube)) return false;
                break;
            case THIRD_LAYER_CROSS_W: //784
                if (!CubeGoalRealisation.ThirdLayerCrossU(cube)) return false;
                break;
            case THIRD_LAYER_CORNER_POSITION_1_W: //787
                if (!CubeGoalRealisation.ThirdLayerCornerPositionU1(cube)) return false;
                break;
            case THIRD_LAYER_CORNER_POSITIONS: //790
                if (!CubeGoalRealisation.ThirdLayerCornerPositions(cube)) return false;
                break;
            case F2L1: //858
                if (!CubeGoalRealisation.F2L1(cube)) return false;
                break;
            case F2L2: //861
                if (!CubeGoalRealisation.F2L2(cube)) return false;
                break;
            case F2L3: //864
                if (!CubeGoalRealisation.F2L3(cube)) return false;
                break;
            case F2L4: //867
                if (!CubeGoalRealisation.F2L4(cube)) return false;
                break;
            case THIRD_LAYER_PARTIAL_CONSISTENT_CROSS: //870
                if (!CubeGoalRealisation.thirdLayerPartialConsistentCross(cube)) return false;
                break;
            case THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS: //873
                if (!CubeGoalRealisation.thirdLayerPartialInconsistentCross(cube)) return false;
                break;
            case THIRD_LAYER_1_CORNER: //876
                if (!CubeGoalRealisation.thirdLayer1Corner(cube)) return false;
                break;
            case SOLVED:
                if (!CubeGoalRealisation.solved(cube)) return false;
                break;
        }
        return true;
    }
}
