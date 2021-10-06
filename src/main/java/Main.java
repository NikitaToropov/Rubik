import cube.BigCube;
import enums.Turns;
import exceptions.WrongArgumentException;
import resolver.Helper;
import utils.BigCubeGenerator;
import utils.BigCubePrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Turns> turns = readingFromInput(args);
        if (turns == null || turns.size() < args.length) {
            return;
        }


        /*
        Шмат для тестов
         */
//        for (int i = 0; i < args.length; i++) System.out.print(args[i] + " ");
//        System.out.println();
//        turns.forEach(t -> System.out.printf(t.getDescription() + " "));

        BigCube goal = BigCubeGenerator.generateBigCube();
        BigCube start = Helper.rotateTheCube(goal, turns); // Смешивание по командам
        BigCubePrinter.print(start);
        /*
        U R2 F B R B2
         */
        BigCube manualStart = goal.rotateUp().doubleRotateRight().rotateFront().rotateBack().rotateRight().doubleRotateBack();
        BigCubePrinter.print(manualStart);
//        BigCube start = Helper.randomRotateTheCubeNTimes(goal, 8); // Рандомные смешивания
//        start.score = start.score - start.stepNum;
//        start.stepNum = 0;
//        start.parent = null;
//        BigCubePrinter.print(start);
//
//        new Resolver(start).resolveIt().printResult();


    }

    private static List<Turns> readingFromInput(String[] args) {
        List<Turns> turns = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                turns.add(getByDescription(args[i]));
            } catch (WrongArgumentException e) {
                System.out.println("Аргумент номер " + i + " не соответствует нотации F R U B L D:");
                System.out.println("L, L2, L', R, R2, R', F, F2, F', B, B2, B', U, U2, U', D, D2, D'");
                break;
            }
        }
        return turns.isEmpty()
                ? null
                : turns;
    }

    public static Turns getByDescription(String arg) {
        Turns[] turns = Turns.values();
        for (Turns turn : turns) {
            if (turn.getDescription().equals(arg)) {
                return turn;
            }
        }
        throw new WrongArgumentException();
    }
}
