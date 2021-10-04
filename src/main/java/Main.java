import cube.BigCube;
import utils.BigCubeGenerator;
import utils.BigCubePrinter;
import utils.BigCubeRotator;

public class Main {
    public static void main(String[] args) {
        BigCube bigCube = BigCubeGenerator.generateBigCube();
        BigCubePrinter.print(bigCube);

        BigCube rotatedFront = BigCubeRotator.rotateUp(bigCube);
        BigCubePrinter.print(rotatedFront);

        rotatedFront = BigCubeRotator.rotateFront(rotatedFront);
        BigCubePrinter.print(rotatedFront);
    }
}
