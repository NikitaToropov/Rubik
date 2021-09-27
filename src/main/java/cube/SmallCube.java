package cube;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;

import java.util.HashMap;
import java.util.Map;

public class SmallCube {
    public final Coordinate coordinate;
    /*
    Ключ - сторона относительно зрителя.
    Значение - где должна стоять ячейка.
     */
    public final Map<Sides, Sides> faces;


    public SmallCube(Map<Sides, Sides> faces, Coordinate coordinate)
    {
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

        int x = 

        return new SmallCube(newFaces);
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

        return new SmallCube(newFaces);
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

        return new SmallCube(newFaces);
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

        return new SmallCube(newFaces);
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

        return new SmallCube(newFaces);
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

        return new SmallCube(newFaces);
    }
}
