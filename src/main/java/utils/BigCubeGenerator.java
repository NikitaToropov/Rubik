package utils;

import cube.BigCube;
import cube.Coordinate;
import cube.Sides;
import cube.SmallCube;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class BigCubeGenerator {
    public static int size = 3;
    public static int minX = -1;
    public static int maxX = 1;
    public static int minY = -1;
    public static int maxY = 1;
    public static int minZ = -1;
    public static int maxZ = 1;

    private BigCubeGenerator() {
    }

    public static BigCube generateBigCube() {
        Set<SmallCube> cubes = new HashSet<>();

        /*
        FRONT and BACK
         */
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                cubes.add(getSmallCube(x, y, maxZ));
                cubes.add(getSmallCube(x, y, minZ));
            }
        }

        /*
        RIGHT and LEFT
         */
        for (int z = minZ + 1; z <= maxZ; z++) {
            for (int y = minY; y <= maxY; y++) {
                cubes.add(getSmallCube(minX, y, z));
                cubes.add(getSmallCube(maxX, y, z));
            }
        }

        /*
        UP and Down
         */
        for (int x = minX + 1; x < maxX; x++) {
            for (int z = minZ + 1; z < maxZ; z++) {
                cubes.add(getSmallCube(x, minY, z));
                cubes.add(getSmallCube(x, maxY, z));
            }
        }
        return new BigCube(null, cubes, size);
    }

    private static SmallCube getSmallCube(int x, int y, int z) {
        Map<Sides, Sides> faces = new HashMap<>();
        if (x == minX) {
            faces.put(Sides.L, Sides.L);
        }
        if (x == maxX) {
            faces.put(Sides.R, Sides.R);
        }

        if (y == minY) {
            faces.put(Sides.D, Sides.D);
        }
        if (y == maxY) {
            faces.put(Sides.U, Sides.U);
        }

        if (z == minZ) {
            faces.put(Sides.F, Sides.F);
        }

        if (z == maxZ) {
            faces.put(Sides.B, Sides.B);
        }
        return new SmallCube(faces, new Coordinate(x, y, z));
    }
}
