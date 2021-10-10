package enums;

import cube.Cube;
import cube.CubeGoalRealisation;

import java.util.Arrays;
import java.util.List;

public enum Goal {
    /* Is the cube solved? Last Goal of any Decomposition                              ~~~~~ */
    SOLVED,

    /* All Piece Goals: Used for Random Decomposition                                  ~~~~~ */
    PIECE1,
    PIECE2,
    PIECE3,
    PIECE4,
    PIECE5,
    PIECE6,
    PIECE7,
    PIECE8,
    PIECE9,
    PIECE10,
    PIECE11,
    PIECE12,
    PIECE13,
    PIECE14,
    PIECE15,
    PIECE16,
    PIECE17,
    PIECE18,
    PIECE19,
    PIECE20,

    /* Goals for Beginners Method                                                      ~~~~~ *
     * See Goal_Oriented_IDAStar_Solver.java for details.                              ~~~~~ */
    CROSS_W,
    FIRST_LAYER_1_W,
    FIRST_LAYER_2_W,
    FIRST_LAYER_3_W,
    FIRST_LAYER_4_W,
    SECOND_LAYER_1_W,
    SECOND_LAYER_2_W,
    SECOND_LAYER_3_W,
    SECOND_LAYER_4_W,
    THIRD_LAYER_INCONSISTENT_CROSS_W,
    THIRD_LAYER_CROSS_W,
    THIRD_LAYER_CORNER_POSITION_1_W,
    THIRD_LAYER_CORNER_POSITIONS,

    /* Goals For Parrel Piece Placing                                                  ~~~~~ *
     * See Goal_Oriented_IDAStar_Solver.java for details.                              ~~~~~ */
    PPP1,
    PPP2,
    PPP3,
    PPP4,
    PPP5,
    PPP6,
    PPP7,
    PPP8,
    PPP9,
    PPP10,
    PPP11,
    PPP12,
    PPP13,
    PPP14,
    PPP15,
    PPP16,
    PPP17,
    PPP18,
    ALL_EDGES,
    ALL_CORNER_POSITIONS,

    /* Goals for the improved Decomposition                                            ~~~~~ *
     * See Goal_Oriented_IDAStar_Solver.java for details.                              ~~~~~ */
    F2L1,
    F2L2,
    F2L3,
    F2L4,
    THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS,
    THIRD_LAYER_PARTIAL_CONSISTENT_CROSS,
    THIRD_LAYER_1_CORNER,
    THIRD_LAYER_2_CORNER
}
