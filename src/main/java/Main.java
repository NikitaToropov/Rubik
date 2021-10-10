import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
        private static final Goal[] DECOMPOSITION = IDAStarResolver.IMPROVED_FRIEDRICH_DECOMPOSITION;
    //    private static final Goal[] DECOMPOSITION = IDAStarResolver.HUMAN_LIKE_DECOMPOSITION;
    public static void main(String args[]) {
        Cube cube = new Cube(); //initialize cube.
        try {
            cube.scramble(Integer.parseInt(args[0]));
        } catch (RuntimeException e) {
            List<Turn> turns = readingFromInput(args);
            if (turns.size() == 0 || turns.size() < args.length) {
                return;
            }
            cube.rotateByListTurns(turns);
        }
        IDAStarResolver.solveWithDecomposition(cube, DECOMPOSITION);
    }

    private static List<Turn> readingFromInput(String[] args) {
        List<Turn> turns = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                turns.add(getByDescription(args[i]));
            } catch (WrongArgumentException e) {
                System.out.println("Аргумент номер по индексу " + i + " не соответствует ни одной из нотаций:");
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