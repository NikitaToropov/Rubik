import cube.BigCube;
import utils.BigCubeGenerator;
import utils.BigCubePrinter;
import utils.BigCubeRotator;

public class Main {
    public static void main(String[] args) {
        BigCube bigCube = BigCubeGenerator.generateBigCube();
        BigCubePrinter.print(bigCube);
        BigCube another = BigCubeRotator.rotateBack(bigCube);
        another = BigCubeRotator.rotateBack(another);
        another = BigCubeRotator.rotateBack(another);
        another = BigCubeRotator.rotateBack(another);
        BigCubePrinter.print(another);

        System.out.println(bigCube.equals(another));
    }
}
