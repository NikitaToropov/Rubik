package resolver;

import cube.BigCube;

import java.util.PriorityQueue;

public class Resolver {
//    private int threshold;
    private final BigCube start;

    public Resolver(BigCube start) {
        this.start = start;
//        this.threshold = start.score;
    }

    public Report resolveIt() {
        long startTime = System.nanoTime();
        BigCube tmp = start;
        tmp.phase = 1;
        while (tmp.score != tmp.stepNum) {
//            System.out.println("Resolving threshold = " + threshold);
            tmp = search(start);
//            this.threshold++;
        }
//        this.threshold = 20;
//        tmp.phase = 2;
//        tmp = new BigCube(tmp.parent, tmp.cubes, tmp.stepNum, tmp.lastTurn);
//        while (tmp.score != tmp.stepNum) {
//            System.out.println("Resolving threshold = " + threshold);
//            tmp = search(start);
//            this.threshold++;
//        }

        long timeInterval = System.nanoTime() - startTime;
        return new Report(tmp, timeInterval);
    }

    private BigCube search(BigCube parent) {
        if (parent.stepNum > 15
                || parent.score == parent.stepNum) {
            return parent;
        }
        PriorityQueue<BigCube> children = Helper.expandTheState(parent);
        BigCube closest = parent;

        while (!children.isEmpty()) {
            BigCube tmp = children.remove();
            tmp = search(tmp);
            if (tmp.score == tmp.stepNum) {
                return tmp;
            }
            closest = tmp.score < closest.score
                    ? tmp
                    : closest;
        }
        return closest;
    }
}
