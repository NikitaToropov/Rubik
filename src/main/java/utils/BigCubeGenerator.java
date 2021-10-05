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

    private BigCubeGenerator() {
    }

    public static BigCube generateBigCube() {
        Set<SmallCube> cubes = new HashSet<>();

        /*
        FRONT and BACK
         */
        for (int x = BigCube.minX; x <= BigCube.maxX; x++) {
            for (int y = BigCube.minY; y <= BigCube.maxY; y++) {
                cubes.add(getSmallCube(x, y, BigCube.maxZ));
                cubes.add(getSmallCube(x, y, BigCube.minZ));
            }
        }

        /*
        RIGHT and LEFT
         */
        for (int z = BigCube.minZ + 1; z <= BigCube.maxZ; z++) {
            for (int y = BigCube.minY; y <= BigCube.maxY; y++) {
                cubes.add(getSmallCube(BigCube.minX, y, z));
                cubes.add(getSmallCube(BigCube.maxX, y, z));
            }
        }

        /*
        UP and Down
         */
        for (int x = BigCube.minX + 1; x < BigCube.maxX; x++) {
            for (int z = BigCube.minZ + 1; z < BigCube.maxZ; z++) {
                cubes.add(getSmallCube(x, BigCube.minY, z));
                cubes.add(getSmallCube(x, BigCube.maxY, z));
            }
        }
        return new BigCube(null, cubes, 0);
    }

    private static SmallCube getSmallCube(int x, int y, int z) {
        Map<Sides, Sides> faces = new HashMap<>();
        if (x == BigCube.minX) {
            faces.put(Sides.L, Sides.L);
        }
        if (x == BigCube.maxX) {
            faces.put(Sides.R, Sides.R);
        }

        if (y == BigCube.minY) {
            faces.put(Sides.D, Sides.D);
        }
        if (y == BigCube.maxY) {
            faces.put(Sides.U, Sides.U);
        }

        if (z == BigCube.minZ) {
            faces.put(Sides.F, Sides.F);
        }

        if (z == BigCube.maxZ) {
            faces.put(Sides.B, Sides.B);
        }
        return new SmallCube(faces, new Coordinate(x, y, z));
    }
}
