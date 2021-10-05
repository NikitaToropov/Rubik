package resolver;

import cube.BigCube;
import utils.BigCubePrinter;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Report {
    private List<BigCube> statesFromStartToFinish;
    private long timeInterval;

    public Report(BigCube finishState, long timeInterval) {
        this.statesFromStartToFinish = reverseStates(finishState);
        this.timeInterval = timeInterval;
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
        System.out.println("================ REPORT STARTS HERE ===============");
        for (int i = 0; i < statesFromStartToFinish.size(); i++) {
            System.out.println("=======================================");
            BigCubePrinter.print(statesFromStartToFinish.get(i));
        }
        System.out.println("Working time = " + TimeUnit.NANOSECONDS.toSeconds(timeInterval) + " seconds");
        System.out.println("================= REPORT ENDS HERE ================");
    }
}
