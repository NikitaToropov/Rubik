package cube;

import enums.Rotations;
import javafx.scene.transform.Rotate;

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
    public int stepNum;
    public int score;
    public BigCube parent;
    public Rotations moveToCurrent;
    public final Set<SmallCube> cubes;

    public BigCube(BigCube parent, Set<SmallCube> cubes, int stepNum, Rotations moveToCurrent) {
        this.parent = parent;
        this.cubes = cubes;
        this.stepNum = stepNum;
        this.score = countHeuristic() + stepNum;
        this.moveToCurrent = moveToCurrent;
    }

    private int countHeuristic() {
        int count = cubes.stream().mapToInt(c -> c.heuristic).sum();
        return count;
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.LEFT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOUBLE_LEFT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.REVERSE_LEFT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.FRONT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOUBLE_FRONT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.REVERSE_FRONT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.RIGHT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOUBLE_RIGHT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.REVERSE_RIGHT);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.BACK);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOUBLE_BACK);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.REVERSE_BACK);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.UP);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOUBLE_UP);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.REVERSE_UP);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOWN);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.DOUBLE_DOWN);
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
        return new BigCube(this, smallCubes, stepNum + 1, Rotations.REVERSE_DOWN);
    }
}
