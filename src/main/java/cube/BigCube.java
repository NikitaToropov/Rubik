package cube;

/**
 * Сторона куба и матрица его ячеек.
 * TODO если код расширяемый, то нужно определять его ценртальную ячейку.
 */
public class BigCube {
    public final BigCube side;
    public final SmallCube[][][] cube3d;


    public BigCube(BigCube side, SmallCube[][][] cube3d) {
        this.side = side;
        this.cube3d = cube3d;
    }
}
