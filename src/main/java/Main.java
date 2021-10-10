/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Jeffrey Martin                                                                    ~~~~~ *
 * ~~~~~ CS4341 Introduction to Artifical Intelligence                                     ~~~~~ *
 * ~~~~~ Professor Neil Heffernan                                                          ~~~~~ *
 * ~~~~~ October 24th, 2016                                                                ~~~~~ *
 * ~~~~~                                                                                   ~~~~~ *
 * ~~~~~ BSMS Project : Goal Oriented Rubiks Cube Solver with IDA*                         ~~~~~ *
 * ~~~~~ File: Main.java                                                                   ~~~~~ *
 * ~~~~~ File Description                                                                  ~~~~~ *
 * ~~~~~~~ This program solves a 3x3 rubiks cube using subgoal decomposition and IDA*      ~~~~~ *
 * ~~~~~~~ search. The user can enter in a specific cube state, or the program can solve   ~~~~~ *
 * ~~~~~~~ a randomly scrambled cube. There are for different sub goal decompositions:     ~~~~~ *
 * ~~~~~~~ A beginners method (how most cubers first learn to solve it), a parallel piece  ~~~~~ *
 * ~~~~~~~ piece placement decomposition, a random decomposition, and lastly and improved  ~~~~~ *
 * ~~~~~~~ 'beginners method' decomposition, which performs the best.                      ~~~~~ *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Goal[] DECOMPOSITION = IDAStarResolver.IMPROVED_FRIEDRICH_DECOMPOSITION;
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
        cube.printCube();
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