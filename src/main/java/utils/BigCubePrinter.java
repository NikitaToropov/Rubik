package utils;

import cube.BigCube;
import cube.Sides;

public class BigCubePrinter {

    private BigCubePrinter() {
    }

    public static void print(BigCube cube) {
        Sides[][] front = getFrontSideMatrix(cube);
        Sides[][] left = getLeftSideMatrix(cube);
        Sides[][] right = geRightSidesMatrix(cube);
        Sides[][] back = getBackSidesMatrix(cube);
        Sides[][] down = getDownSideMatrix(cube);
        Sides[][] up = getUpSideMatrix(cube);

        printUpOrDownSide(up);
        printLeftFrontRightBackSides(left, front, right, back);
        printUpOrDownSide(down);
    }

    private static Sides[][] getUpSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.y == BigCubeGenerator.maxY)
                .forEach(c -> matrix[c.coordinate.x + BigCubeGenerator.maxX][BigCubeGenerator.size - 1 - (c.coordinate.z + BigCubeGenerator.maxZ)] = c.faces.get(Sides.U));
        return matrix;
    }

    private static Sides[][] getDownSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.y == BigCubeGenerator.minY)
                .forEach(c -> matrix[c.coordinate.x + BigCubeGenerator.maxX][c.coordinate.z + BigCubeGenerator.maxZ] = c.faces.get(Sides.D));
        return matrix;
    }

    private static Sides[][] getBackSidesMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.z == BigCubeGenerator.maxZ)
                .forEach(c -> matrix[BigCubeGenerator.size - 1 - (c.coordinate.x + BigCubeGenerator.maxX)][BigCubeGenerator.size - 1 - (c.coordinate.y + BigCubeGenerator.maxY)] = c.faces.get(Sides.B));
        return matrix;
    }

    private static Sides[][] geRightSidesMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.x == BigCubeGenerator.maxX)
                .forEach(c -> matrix[c.coordinate.z + BigCubeGenerator.maxZ][BigCubeGenerator.size - 1 - (c.coordinate.y + BigCubeGenerator.maxY)] = c.faces.get(Sides.R));
        return matrix;
    }

    private static Sides[][] getFrontSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.z == BigCubeGenerator.minZ)
                .forEach(c -> matrix[c.coordinate.x + BigCubeGenerator.maxX][BigCubeGenerator.size - 1 - (c.coordinate.y + BigCubeGenerator.maxY)] = c.faces.get(Sides.F));
        return matrix;
    }

    private static Sides[][] getLeftSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.x == BigCubeGenerator.minX)
                .forEach(c -> matrix[BigCubeGenerator.size - 1 - (c.coordinate.z + BigCubeGenerator.maxZ)][BigCubeGenerator.size - 1 - (c.coordinate.y + BigCubeGenerator.maxY)] = c.faces.get(Sides.L));
        return matrix;
    }

    /**
     * Метод для печати верхней или ниженей сторон.
     *
     * @param matrix
     */
    private static void printUpOrDownSide(Sides[][] matrix) {
        System.out.println();
        for (int i = 0; i < BigCubeGenerator.size; i++) {
            System.out.printf("%" + 7 + "s", " ");
            for (Sides[] sides : matrix) {
                System.out.printf("%2s", sides[i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Метод для печати матриц с общим направлением 'Y':
     * LEFT, FRONT, RIGHT, BACK.
     */
    private static void printLeftFrontRightBackSides(Sides[][] left, Sides[][] front, Sides[][] right, Sides[][] back) {
        for (int y = 0; y < BigCubeGenerator.size; y++) {
            for (Sides[] sides : left) {
                System.out.printf("%2s", sides[y]);
            }
            System.out.printf(" ");
            for (Sides[] sides : front) {
                System.out.printf("%2s", sides[y]);
            }
            System.out.printf(" ");
            for (Sides[] sides : right) {
                System.out.printf("%2s", sides[y]);
            }
            System.out.printf(" ");
            for (Sides[] sides : back) {
                System.out.printf("%2s", sides[y]);
            }
            System.out.println();
        }
    }
}
