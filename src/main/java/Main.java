import cube.BigCube;
import resolver.Helper;
import resolver.Resolver;
import utils.BigCubeGenerator;
import utils.BigCubePrinter;

public class Main {
    public static void main(String[] args) {
        BigCube goal = BigCubeGenerator.generateBigCube();
//        BigCube start = goal.doubleRotateBack().rotateRight().reverseRotateFront().doubleRotateLeft().reverseRotateDown().doubleRotateUp().reverseRotateDown();
        BigCube start = Helper.rotateTheCubeNTimes(goal, 8);
        start.score = start.score - start.stepNum;
        start.stepNum = 0;
        start.parent = null;
        BigCubePrinter.print(start);



        new Resolver(start).resolveIt().printResult();

//        BigCube randomState = goal.rotateBack().rotateDown().rotateLeft().rotateDown();
//        randomState.stepNum = 0;
//        randomState.parent = null;


    }
}
