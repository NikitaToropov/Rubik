package resolver;

import cube.BigCube;
import utils.BigCubePrinter;

import java.util.LinkedList;
import java.util.List;

public class Report {
    List<BigCube> statesFromStartToFinish;

    public Report(BigCube finishState) {
        this.statesFromStartToFinish = reverseStates(finishState);
    }

    private List<BigCube> reverseStates(BigCube state) {
        LinkedList<BigCube> path = new LinkedList<>();
        while (state != null) {
            path.addFirst(state);
            state = state.parent;
        }
        return path;
    }

    public void printResult() {
        for (int i = 0; i < statesFromStartToFinish.size(); i++) {
            System.out.println("=======================================");
            System.out.println("step = " + statesFromStartToFinish.get(i).stepNum + "  heuristic = " + statesFromStartToFinish.get(i).score);
            BigCubePrinter.print(statesFromStartToFinish.get(i));
        }
    }
}
