package utils;

import cube.BigCube;
import enums.Sides;

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

        System.out.println("phase = " + BigCube.phase + " step = " + cube.stepNum + "  score = " + cube.score + ((cube.lastTurn != null)
                ? "  move = " +  cube.lastTurn.getDescription()
                : ""));
        printUpOrDownSide(up);
        printLeftFrontRightBackSides(left, front, right, back);
        printUpOrDownSide(down);
    }

    private static Sides[][] getUpSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.y == BigCube.maxY)
                .forEach(c -> matrix[c.coordinate.x + BigCube.maxX][BigCube.size - 1 - (c.coordinate.z + BigCube.maxZ)] = c.faces.get(Sides.U));
        return matrix;
    }

    private static Sides[][] getDownSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.y == BigCube.minY)
                .forEach(c -> matrix[c.coordinate.x + BigCube.maxX][c.coordinate.z + BigCube.maxZ] = c.faces.get(Sides.D));
        return matrix;
    }

    private static Sides[][] getBackSidesMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.z == BigCube.maxZ)
                .forEach(c -> matrix[BigCube.size - 1 - (c.coordinate.x + BigCube.maxX)][BigCube.size - 1 - (c.coordinate.y + BigCube.maxY)] = c.faces.get(Sides.B));
        return matrix;
    }

    private static Sides[][] geRightSidesMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.x == BigCube.maxX)
                .forEach(c -> matrix[c.coordinate.z + BigCube.maxZ][BigCube.size - 1 - (c.coordinate.y + BigCube.maxY)] = c.faces.get(Sides.R));
        return matrix;
    }

    private static Sides[][] getFrontSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.z == BigCube.minZ)
                .forEach(c -> matrix[c.coordinate.x + BigCube.maxX][BigCube.size - 1 - (c.coordinate.y + BigCube.maxY)] = c.faces.get(Sides.F));
        return matrix;
    }

    private static Sides[][] getLeftSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.x == BigCube.minX)
                .forEach(c -> matrix[BigCube.size - 1 - (c.coordinate.z + BigCube.maxZ)][BigCube.size - 1 - (c.coordinate.y + BigCube.maxY)] = c.faces.get(Sides.L));
        return matrix;
    }

    /**
     * Метод для печати верхней или ниженей сторон.
     *
     * @param matrix
     */
    private static void printUpOrDownSide(Sides[][] matrix) {
        System.out.println();
        for (int i = 0; i < BigCube.size; i++) {
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
        for (int y = 0; y < BigCube.size; y++) {
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
