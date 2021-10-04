package cube;

import utils.BigCubeGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Сторона куба и матрица его ячеек.
 * TODO если код расширяемый, то нужно определять его ценртальную ячейку.
 */
public class BigCube {
    public final int size;
    public final BigCube parent;
    public final Set<SmallCube> cubes;

    public BigCube(BigCube parent, Set<SmallCube> cubes, int size) {
        this.parent = parent;
        this.cubes = cubes;
        this.size = size;
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
            if (c.coordinate.x == BigCubeGenerator.minX) {
                smallCubes.add(c.rotateLeft());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, size);
    }

    public BigCube rotateFront() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == BigCubeGenerator.minZ) {
                smallCubes.add(c.rotateFront());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, size);
    }

    public BigCube rotateRight() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.x == BigCubeGenerator.maxX) {
                smallCubes.add(c.rotateRight());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, size);
    }

    public BigCube rotateBack() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.z == BigCubeGenerator.maxZ) {
                smallCubes.add(c.rotateBack());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, size);
    }

    public BigCube rotateUp() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == BigCubeGenerator.maxY) {
                smallCubes.add(c.rotateUp());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, size);
    }

    public BigCube rotateDown() {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        cubes.forEach(c -> {
            if (c.coordinate.y == BigCubeGenerator.minY) {
                smallCubes.add(c.rotateDown());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(this, smallCubes, size);
    }
}
