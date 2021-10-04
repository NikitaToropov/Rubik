package utils;

import cube.BigCube;
import cube.SmallCube;

import java.util.HashSet;

public class BigCubeRotator {
    public static BigCube rotateLeft(BigCube parent) {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        parent.cubes.forEach(c -> {
            if (c.coordinate.x == BigCubeGenerator.minX) {
                smallCubes.add(c.rotateLeft());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(parent, smallCubes, parent.size);
    }

    public static BigCube rotateFront(BigCube parent) {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        parent.cubes.forEach(c -> {
            if (c.coordinate.z == BigCubeGenerator.minZ) {
                smallCubes.add(c.rotateFront());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(parent, smallCubes, parent.size);
    }

    public static BigCube rotateRight(BigCube parent) {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        parent.cubes.forEach(c -> {
            if (c.coordinate.x == BigCubeGenerator.maxX) {
                smallCubes.add(c.rotateRight());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(parent, smallCubes, parent.size);
    }

    public static BigCube rotateBack(BigCube parent) {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        parent.cubes.forEach(c -> {
            if (c.coordinate.z == BigCubeGenerator.maxZ) {
                smallCubes.add(c.rotateBack());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(parent, smallCubes, parent.size);
    }

    public static BigCube rotateUp(BigCube parent) {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        parent.cubes.forEach(c -> {
            if (c.coordinate.y == BigCubeGenerator.maxY) {
                smallCubes.add(c.rotateUp());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(parent, smallCubes, parent.size);
    }

    public static BigCube rotateDown(BigCube parent) {
        HashSet<SmallCube> smallCubes = new HashSet<>();
        parent.cubes.forEach(c -> {
            if (c.coordinate.y == BigCubeGenerator.minY) {
                smallCubes.add(c.rotateDown());
            } else {
                smallCubes.add(c);
            }
        });
        return new BigCube(parent, smallCubes, parent.size);
    }
}
