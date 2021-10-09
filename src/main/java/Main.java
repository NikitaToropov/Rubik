import cube.Cube;
import enums.Turn;
import exceptions.WrongArgumentException;
import solver.IDAStarSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cube cube = new Cube();
        try {
            cube.scramble(Integer.parseInt(args[0]));
        } catch (RuntimeException e) {
            List<Turn> turns = readingFromInput(args);
            if (turns.size() < args.length) {
                return;
            }
            cube.rotateByListTurns(turns);
        }

//        turns.forEach(System.out::println);
        /*
        Base cube.
         */
//        cube.printCube();

//        cube.printCube();
        IDAStarSolver.solveWithDecomposition(cube);
    }


    private static List<Turn> readingFromInput(String[] args) {
        List<Turn> turns = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                turns.add(getByDescription(args[i]));
            } catch (WrongArgumentException e) {
                System.out.println("Аргумент номер " + i + " не соответствует ни одной из нотаций:");
                Arrays.stream(Turn.values()).forEach(t -> System.out.print(t.notation + " "));
                break;
            }
        }
        return turns;
    }

    public static Turn getByDescription(String arg) {
        Turn[] turns = Turn.values();
        for (Turn turn : turns) {
            if (turn.notation.equals(arg)) {
                return turn;
            }
        }
        throw new WrongArgumentException();
    }
}
