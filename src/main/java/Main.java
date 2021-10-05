import cube.BigCube;
import resolver.Report;
import utils.BigCubeGenerator;
import utils.BigCubePrinter;

public class Main {
    public static void main(String[] args) {
        BigCube goal = BigCubeGenerator.generateBigCube();
        BigCubePrinter.print(goal);
        BigCubePrinter.print(goal.doubleRotateFront());


//        BigCube randomState = goal.rotateBack().rotateDown().rotateLeft().rotateDown();
//        randomState.stepNum = 0;
//        randomState.parent = null;


    }
}
