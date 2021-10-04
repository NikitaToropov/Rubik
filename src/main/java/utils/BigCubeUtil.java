package utils;

import cube.BigCube;
import cube.Sides;

public class BigCubeUtil {

    public static void printBigCube(BigCube cube) {
        Sides[][] front = getFrontSideMatrix(cube);
        Sides[][] left = getLeftSideMatrix(cube);
        printLeftFrontRightBackSides(left, front, null, null);
//        printUpOrDownSide(left);
    }

    private static Sides[][] getFrontSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.z == BigCubeGenerator.minZ)
                .forEach(c -> matrix[Math.abs(c.coordinate.x + BigCubeGenerator.maxX)][Math.abs(c.coordinate.y + BigCubeGenerator.minY)] = c.faces.get(Sides.F));
        return matrix;
    }

    private static Sides[][] getLeftSideMatrix(BigCube cube) {
        int size = cube.size;
        Sides[][] matrix = new Sides[size][size];

        cube.cubes.stream()
                .filter(c -> c.coordinate.x == BigCubeGenerator.minX)
                .forEach(c -> matrix[BigCubeGenerator.size - 1 - c.coordinate.z - BigCubeGenerator.maxZ][BigCubeGenerator.size - 1 - c.coordinate.y - BigCubeGenerator.maxY] = c.faces.get(Sides.L));
        return matrix;
    }

    private static void printUpOrDownSide(Sides[][] matrix) {
        for (int i = 0; i < BigCubeGenerator.size; i++) {
            System.out.printf("%" + 2 * BigCubeGenerator.size + "s", " ");
            for (Sides[] sides : matrix) {
                System.out.printf("%2s", sides[i]);
            }
            System.out.println();
        }
    }

    private static void printLeftFrontRightBackSides(Sides[][] left, Sides[][] front, Sides[][] right, Sides[][] back) {
        for (int y = 0; y < BigCubeGenerator.size; y++) {
            for (Sides[] sides : left) {
                System.out.printf("%2s", sides[y]);
            }
            System.out.printf(" ");
            for (Sides[] sides : front) {
                System.out.printf("%2s", sides[y]);
            }
//            System.out.printf(" ");
//            for (Sides[] sides : right) {
//                System.out.printf("%2s", sides[y]);
//            }
//            System.out.printf(" ");
//            for (Sides[] sides : back) {
//                System.out.printf("%2s", sides[y]);
//            }
            System.out.println();
        }
    }
}
