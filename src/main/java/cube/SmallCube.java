package cube;

import java.util.HashMap;
import java.util.Map;

public class SmallCube {
    public final Coordinate coordinate;
    /*
    Ключ - сторона относительно зрителя.
    Значение - где должна стоять ячейка.
     */
    public final Map<Sides, Sides> faces;


    public SmallCube(Map<Sides, Sides> faces, Coordinate coordinate) {
        this.faces = faces;
        this.coordinate = coordinate;
    }

    public SmallCube rotateFront() {
        Map<Sides, Sides> newFaces = new HashMap<>();
        Sides face;
        if ((face = faces.get(Sides.U)) != null) {
            newFaces.put(Sides.R, face);
        }

        if ((face = faces.get(Sides.R)) != null) {
            newFaces.put(Sides.D, face);
        }

        if ((face = faces.get(Sides.D)) != null) {
            newFaces.put(Sides.L, face);
        }

        if ((face = faces.get(Sides.L)) != null) {
            newFaces.put(Sides.U, face);
        }

        int x = coordinate.y;
        int y = coordinate.x * -1;
        int z = coordinate.z;
        return new SmallCube(newFaces, new Coordinate(x, y, z));
    }

    public SmallCube rotateRight() {
        Map<Sides, Sides> newFaces = new HashMap<>();
        Sides face;
        if ((face = faces.get(Sides.U)) != null) {
            newFaces.put(Sides.B, face);
        }

        if ((face = faces.get(Sides.B)) != null) {
            newFaces.put(Sides.D, face);
        }

        if ((face = faces.get(Sides.D)) != null) {
            newFaces.put(Sides.F, face);
        }

        if ((face = faces.get(Sides.F)) != null) {
            newFaces.put(Sides.U, face);
        }

        int x = coordinate.x;
        int z = coordinate.y;
        int y = coordinate.z * -1;
        return new SmallCube(newFaces, new Coordinate(x, y, z));
    }

    public SmallCube rotateDown() {
        Map<Sides, Sides> newFaces = new HashMap<>();
        Sides face;
        if ((face = faces.get(Sides.F)) != null) {
            newFaces.put(Sides.R, face);
        }

        if ((face = faces.get(Sides.R)) != null) {
            newFaces.put(Sides.B, face);
        }

        if ((face = faces.get(Sides.B)) != null) {
            newFaces.put(Sides.L, face);
        }

        if ((face = faces.get(Sides.L)) != null) {
            newFaces.put(Sides.F, face);
        }

        int x = coordinate.z * -1;
        int y = coordinate.y;
        int z = coordinate.x;
        return new SmallCube(newFaces, new Coordinate(x, y, z));
    }

    public SmallCube rotateLeft() {
        Map<Sides, Sides> newFaces = new HashMap<>();
        Sides face;
        if ((face = faces.get(Sides.F)) != null) {
            newFaces.put(Sides.D, face);
        }

        if ((face = faces.get(Sides.D)) != null) {
            newFaces.put(Sides.B, face);
        }

        if ((face = faces.get(Sides.B)) != null) {
            newFaces.put(Sides.U, face);
        }

        if ((face = faces.get(Sides.U)) != null) {
            newFaces.put(Sides.F, face);
        }

        int x = coordinate.x;
        int y = coordinate.z;
        int z = coordinate.y * -1;
        return new SmallCube(newFaces, new Coordinate(x, y, z));
    }

    public SmallCube rotateUp() {
        Map<Sides, Sides> newFaces = new HashMap<>();
        Sides face;
        if ((face = faces.get(Sides.F)) != null) {
            newFaces.put(Sides.L, face);
        }

        if ((face = faces.get(Sides.L)) != null) {
            newFaces.put(Sides.B, face);
        }

        if ((face = faces.get(Sides.B)) != null) {
            newFaces.put(Sides.R, face);
        }

        if ((face = faces.get(Sides.R)) != null) {
            newFaces.put(Sides.F, face);
        }

        int x = coordinate.z;
        int y = coordinate.y;
        int z = coordinate.x * -1;
        return new SmallCube(newFaces, new Coordinate(x, y, z));
    }

    public SmallCube rotateBack() {
        Map<Sides, Sides> newFaces = new HashMap<>();
        Sides face;
        if ((face = faces.get(Sides.R)) != null) {
            newFaces.put(Sides.U, face);
        }

        if ((face = faces.get(Sides.U)) != null) {
            newFaces.put(Sides.L, face);
        }

        if ((face = faces.get(Sides.L)) != null) {
            newFaces.put(Sides.D, face);
        }

        if ((face = faces.get(Sides.D)) != null) {
            newFaces.put(Sides.R, face);
        }

        int y = coordinate.x;
        int x = coordinate.y * -1;
        int z = coordinate.z;
        return new SmallCube(newFaces, new Coordinate(x, y, z));
    }
}
