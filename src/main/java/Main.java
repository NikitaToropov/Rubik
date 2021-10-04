import cube.BigCube;
import utils.BigCubeGenerator;
import utils.BigCubePrinter;

public class Main {
    public static void main(String[] args) {
        BigCube bigCube = BigCubeGenerator.generateBigCube();
        BigCubePrinter.print(bigCube);
        BigCube another = bigCube.rotateDown().rotateDown().rotateDown().rotateDown();
        BigCubePrinter.print(another);

        System.out.println(bigCube.equals(another));
    }
}
