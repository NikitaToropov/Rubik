package cube;

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
}
