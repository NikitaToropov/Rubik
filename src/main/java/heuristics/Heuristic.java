package heuristics;

import cube.SmallCube;
import enums.Sides;

import java.util.Set;

public class Heuristic {

    /**
     *         U U U
     *         U U U
     *         U U U
     *
     * - - -   - - -   - - -   - - -
     * - L -   F F F   - R -   B B B
     * - - -   - - -   - - -   - - -
     *
     *         D D D
     *         D D D
     *         D D D
     */
    public int getFirstPhaseHScore(Set<SmallCube> cubes) {
        int score = 0;
        for (SmallCube cube : cubes) {
            if (cube.faces.containsValue(Sides.U)
            || cube.faces.containsValue(Sides.D)) {
                score += cube.heuristic;
            } else if (cube.faces.size() == 2
            && (cube.faces.containsValue(Sides.F)
                    || (cube.faces.containsValue(Sides.B)))) {
                score += cube.heuristic;
            }
        }
        return score;
    }

    /**
     *         U U U
     *         U U U
     *         U U U
     *
     * L L L   F F F   R R R   B B B
     * L L L   F F F   R R R   B B B
     * L L L   F F F   R R R   B B B
     *
     *         D D D
     *         D D D
     *         D D D
     */
    public int getSecondPhaseHScore(Set<SmallCube> cubes) {
        int score = 0;
        for (SmallCube cube : cubes) {
            score += cube.heuristic;
        }
        return score;
    }
}
