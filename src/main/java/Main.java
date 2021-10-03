import cube.BigCube;
import utils.BigCubeGenerator;
import utils.BigCubeUtil;

public class Main {
    public static void main(String[] args) {
        BigCube bigCube = BigCubeGenerator.generateBigCube();
        BigCubeUtil.printBigCube(bigCube);

    }
}
