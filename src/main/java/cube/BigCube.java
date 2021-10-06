package cube;

import enums.Sides;
import enums.Turns;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Сторона куба и матрица его ячеек.
 * TODO если код расширяемый, то нужно определять его ценртальную ячейку.
 */
public class BigCube implements Comparable<BigCube> {
    public static final int size = 3;
    public static final int minX = -1;
    public static final int maxX = 1;
    public static final int minY = -1;
    public static final int maxY = 1;
    public static final int minZ = -1;
    public static final int maxZ = 1;
    public static int phase = 1;
    public int stepNum;
    public int score;
    public BigCube parent;
    public Turns lastTurn;
    public final Set<SmallCube> cubes;

    public BigCube(BigCube parent, Set<SmallCube> cubes, int stepNum, Turns moveToCurrent) {
        this.parent = parent;
        this.cubes = cubes;
        this.stepNum = stepNum;
        this.score = countHeuristic(cubes) + stepNum;
        this.lastTurn = moveToCurrent;
    }


    @Override
    public int compareTo(BigCube state) {
        return score - state.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigCube bigCube = (BigCube) o;
        return cubes.equals(bigCube.cubes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cubes);
    }

    public BigCube rotateLeft() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == minX) {
                smallCubes.add(c.rotateLeft());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.LEFT);
    }

    public BigCube doubleRotateLeft() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == minX) {
                smallCubes.add(c.rotateLeft().rotateLeft());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOUBLE_LEFT);
    }

    public BigCube reverseRotateLeft() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == minX) {
                smallCubes.add(c.rotateLeft().rotateLeft().rotateLeft());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.REVERSE_LEFT);
    }

    public BigCube rotateFront() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == minZ) {
                smallCubes.add(c.rotateFront());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.FRONT);
    }

    public BigCube doubleRotateFront() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == minZ) {
                smallCubes.add(c.rotateFront().rotateFront());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOUBLE_FRONT);
    }

    public BigCube reverseRotateFront() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == minZ) {
                smallCubes.add(c.rotateFront().rotateFront().rotateFront());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.REVERSE_FRONT);
    }

    public BigCube rotateRight() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == maxX) {
                smallCubes.add(c.rotateRight());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.RIGHT);
    }

    public BigCube doubleRotateRight() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == maxX) {
                smallCubes.add(c.rotateRight().rotateRight());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOUBLE_RIGHT);
    }

    public BigCube reverseRotateRight() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == maxX) {
                smallCubes.add(c.rotateRight().rotateRight().rotateRight());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.REVERSE_RIGHT);
    }

    public BigCube rotateBack() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == maxZ) {
                smallCubes.add(c.rotateBack());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.BACK);
    }

    public BigCube doubleRotateBack() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == maxZ) {
                smallCubes.add(c.rotateBack().rotateBack());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOUBLE_BACK);
    }

    public BigCube reverseRotateBack() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == maxZ) {
                smallCubes.add(c.rotateBack().rotateBack().rotateBack());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.REVERSE_BACK);
    }

    public BigCube rotateUp() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == maxY) {
                smallCubes.add(c.rotateUp());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.UP);
    }

    public BigCube doubleRotateUp() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == maxY) {
                smallCubes.add(c.rotateUp().rotateUp());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOUBLE_UP);
    }

    public BigCube reverseRotateUp() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == maxY) {
                smallCubes.add(c.rotateUp().rotateUp().rotateUp());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.REVERSE_UP);
    }

    public BigCube rotateDown() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == minY) {
                smallCubes.add(c.rotateDown());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOWN);
    }

    public BigCube doubleRotateDown() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == minY) {
                smallCubes.add(c.rotateDown().rotateDown());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.DOUBLE_DOWN);
    }

    public BigCube reverseRotateDown() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == minY) {
                smallCubes.add(c.rotateDown().rotateDown().rotateDown());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, stepNum + 1, Turns.REVERSE_DOWN);
    }

    private int countHeuristic(Set<SmallCube> cubes) {
        return phase == 1
                ? getFirstPhaseHScore(cubes)
                : getSecondPhaseHScore(cubes);
    }

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
    private int getFirstPhaseHScore(Set<SmallCube> cubes) {
        int score = 0;
        for (SmallCube cube : cubes) {
            if (cube.faces.containsValue(Sides.U) && (!Sides.U.equals(cube.faces.get(Sides.U)))) {
                score += Math.abs(BigCube.maxY - cube.coordinate.y);
            } else if (cube.faces.containsValue(Sides.D) && (!Sides.U.equals(cube.faces.get(Sides.D)))) {
                score += Math.abs(BigCube.minY - cube.coordinate.y);
            } else if (cube.faces.size() == 2
                && ((cube.faces.containsValue(Sides.F) && (!Sides.F.equals(cube.faces.get(Sides.F))))
                    || (cube.faces.containsValue(Sides.B)) && (!Sides.B.equals(cube.faces.get(Sides.B))))) {
                score += 1;
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
    private int getSecondPhaseHScore(Set<SmallCube> cubes) {
        int score = 0;
        for (SmallCube cube : cubes) {
            score += cube.heuristic;
        }
        return score;
    }
}
