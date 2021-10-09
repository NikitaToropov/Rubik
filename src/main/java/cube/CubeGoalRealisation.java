package cube;

public class CubeGoalRealisation {

    public static boolean solved(Cube cube) {
        return piece1(cube)
                && piece2(cube)
                && piece3(cube)
                && piece4(cube)
                && piece5(cube)
                && piece6(cube)
                && piece7(cube)
                && piece8(cube)
                && piece9(cube)
                && piece10(cube)
                && piece11(cube)
                && piece12(cube)
                && piece13(cube)
                && piece14(cube)
                && piece15(cube)
                && piece16(cube)
                && piece17(cube)
                && piece18(cube)
                && piece19(cube)
                && piece20(cube);
    }

    public static boolean piece1(Cube cube) {
        return cube.getFaceletColor(0) == 'U'
                && cube.getFaceletColor(9) == 'L'
                && cube.getFaceletColor(38) == 'B';
    }

    public static boolean piece2(Cube cube) {
        return cube.getFaceletColor(2) == 'U'
                && cube.getFaceletColor(29) == 'R'
                && cube.getFaceletColor(36) == 'B';
    }

    public static boolean piece3(Cube cube) {
        return cube.getFaceletColor(8) == 'U'
                && cube.getFaceletColor(27) == 'R'
                && cube.getFaceletColor(20) == 'F';
    }

    public static boolean piece4(Cube cube) {
        return cube.getFaceletColor(6) == 'U'
                && cube.getFaceletColor(11) == 'L'
                && cube.getFaceletColor(18) == 'F';
    }

    public static boolean piece5(Cube cube) {
        return cube.getFaceletColor(51) == 'D'
                && cube.getFaceletColor(15) == 'L'
                && cube.getFaceletColor(44) == 'B';
    }

    public static boolean piece6(Cube cube) {
        return cube.getFaceletColor(53) == 'D'
                && cube.getFaceletColor(35) == 'R'
                && cube.getFaceletColor(42) == 'B';
    }

    public static boolean piece7(Cube cube) {
        return cube.getFaceletColor(47) == 'D'
                && cube.getFaceletColor(33) == 'R'
                && cube.getFaceletColor(26) == 'F';
    }

    public static boolean piece8(Cube cube) {
        return cube.getFaceletColor(45) == 'D'
                && cube.getFaceletColor(17) == 'L'
                && cube.getFaceletColor(24) == 'F';
    }

    public static boolean piece9(Cube cube) {
        return cube.getFaceletColor(3) == 'U'
                && cube.getFaceletColor(10) == 'L';
    }

    public static boolean piece10(Cube cube) {
        return cube.getFaceletColor(1) == 'U'
                && cube.getFaceletColor(37) == 'B';
    }

    public static boolean piece11(Cube cube) {
        return cube.getFaceletColor(5) == 'U'
                && cube.getFaceletColor(28) == 'R';
    }

    public static boolean piece12(Cube cube) {
        return cube.getFaceletColor(7) == 'U'
                && cube.getFaceletColor(19) == 'F';
    }

    public static boolean piece13(Cube cube) {
        return cube.getFaceletColor(12) == 'L'
                && cube.getFaceletColor(41) == 'B';
    }

    public static boolean piece14(Cube cube) {
        return cube.getFaceletColor(39) == 'B'
                && cube.getFaceletColor(32) == 'R';
    }

    public static boolean piece15(Cube cube) {
        return cube.getFaceletColor(30) == 'R'
                && cube.getFaceletColor(23) == 'F';
    }

    public static boolean piece16(Cube cube) {
        return cube.getFaceletColor(21) == 'F'
                && cube.getFaceletColor(14) == 'L';
    }

    public static boolean piece17(Cube cube) {
        return cube.getFaceletColor(48) == 'D'
                && cube.getFaceletColor(16) == 'L';
    }

    public static boolean piece18(Cube cube) {
        return cube.getFaceletColor(52) == 'D'
                && cube.getFaceletColor(43) == 'B';
    }

    public static boolean piece19(Cube cube) {
        return cube.getFaceletColor(50) == 'D'
                && cube.getFaceletColor(34) == 'R';
    }

    public static boolean piece20(Cube cube) {
        return cube.getFaceletColor(46) == 'D'
                && cube.getFaceletColor(25) == 'F';
    }

    public static boolean crossW(Cube cube) {
        return piece9(cube)
                && piece10(cube)
                && piece11(cube)
                && piece12(cube);
    }

    public static boolean inconsistentThirdLayerCrossU(Cube cube) {
        return cube.getFaceletColor(46) == 'D'
                && cube.getFaceletColor(48) == 'D'
                && cube.getFaceletColor(50) == 'D'
                && cube.getFaceletColor(52) == 'D';
    }

    public static boolean ThirdLayerCrossU(Cube cube) {
        return piece17(cube)
                && piece18(cube)
                && piece19(cube)
                && piece20(cube);
    }

    public static boolean ThirdLayerCornerPositionU1(Cube cube) {
        char F1 = cube.getFaceletColor(51);
        char F2 = cube.getFaceletColor(15);
        char F3 = cube.getFaceletColor(44);
        if (((F1 == 'D' && F2 == 'L' && F3 == 'B')
                || (F1 == 'B' && F2 == 'D' && F3 == 'L')
                || (F1 == 'L' && F2 == 'B' && F3 == 'D'))) {
            return true;
        }
        F1 = cube.getFaceletColor(53);
        F2 = cube.getFaceletColor(35);
        F3 = cube.getFaceletColor(42);
        if (((F1 == 'D' && F2 == 'R' && F3 == 'B') ||
                (F1 == 'B' && F2 == 'D' && F3 == 'R') ||
                (F1 == 'R' && F2 == 'B' && F3 == 'D'))) {
            return true;
        }
        F1 = cube.getFaceletColor(47);
        F2 = cube.getFaceletColor(33);
        F3 = cube.getFaceletColor(26);
        if (((F1 == 'D' && F2 == 'R' && F3 == 'F')
                || (F1 == 'F' && F2 == 'D' && F3 == 'R')
                || (F1 == 'R' && F2 == 'F' && F3 == 'D'))) {
            return true;
        }
        F1 = cube.getFaceletColor(45);
        F2 = cube.getFaceletColor(17);
        F3 = cube.getFaceletColor(24);
        return (F1 == 'D' && F2 == 'L' && F3 == 'F')
                || (F1 == 'F' && F2 == 'D' && F3 == 'L')
                || (F1 == 'L' && F2 == 'F' && F3 == 'D');
    }

    public static boolean ThirdLayerCornerPositions(Cube cube) {
        char F1 = cube.getFaceletColor(51);
        char F2 = cube.getFaceletColor(15);
        char F3 = cube.getFaceletColor(44);
        if (!((F1 == 'D' && F2 == 'L' && F3 == 'B')
                || (F1 == 'B' && F2 == 'D' && F3 == 'L')
                || (F1 == 'L' && F2 == 'B' && F3 == 'D'))) {
            return false;
        }
        F1 = cube.getFaceletColor(53);
        F2 = cube.getFaceletColor(35);
        F3 = cube.getFaceletColor(42);
        if (!((F1 == 'D' && F2 == 'R' && F3 == 'B')
                || (F1 == 'B' && F2 == 'D' && F3 == 'R')
                || (F1 == 'R' && F2 == 'B' && F3 == 'D'))) {
            return false;
        }
        F1 = cube.getFaceletColor(47);
        F2 = cube.getFaceletColor(33);
        F3 = cube.getFaceletColor(26);
        if (!((F1 == 'D' && F2 == 'R' && F3 == 'F')
                || (F1 == 'F' && F2 == 'D' && F3 == 'R')
                || (F1 == 'R' && F2 == 'F' && F3 == 'D'))) {
            return false;
        }
        F1 = cube.getFaceletColor(45);
        F2 = cube.getFaceletColor(17);
        F3 = cube.getFaceletColor(24);
        return (F1 == 'D' && F2 == 'L' && F3 == 'F')
                || (F1 == 'F' && F2 == 'D' && F3 == 'L')
                || (F1 == 'L' && F2 == 'F' && F3 == 'D');
    }

    public static boolean F2L1(Cube cube) {
        return (piece1(cube) && piece13(cube))
                || (piece2(cube) && piece14(cube))
                || (piece3(cube) && piece15(cube))
                || (piece4(cube) && piece16(cube));
    }

    public static boolean F2L2(Cube cube) {
        int count = 0;
        if (piece1(cube) && piece13(cube)) count++;
        if (piece2(cube) && piece14(cube)) count++;
        if (piece3(cube) && piece15(cube)) count++;
        if (piece4(cube) && piece16(cube)) count++;
        return count >= 2;
    }

    public static boolean F2L3(Cube cube) {
        int count = 0;
        if (piece1(cube) && piece13(cube)) count++;
        if (piece2(cube) && piece14(cube)) count++;
        if (piece3(cube) && piece15(cube)) count++;
        if (piece4(cube) && piece16(cube)) count++;
        return count >= 3;
    }

    public static boolean F2L4(Cube cube) {
        int count = 0;
        if (piece1(cube) && piece13(cube)) count++;
        if (piece2(cube) && piece14(cube)) count++;
        if (piece3(cube) && piece15(cube)) count++;
        if (piece4(cube) && piece16(cube)) count++;
        return count >= 4;
    }

    public static boolean thirdLayerPartialInconsistentCross(Cube cube) {
        return (cube.getFaceletColor(46) == 'D' && cube.getFaceletColor(50) == 'D')
                || (cube.getFaceletColor(50) == 'D' && cube.getFaceletColor(52) == 'D')
                || (cube.getFaceletColor(52) == 'D' && cube.getFaceletColor(48) == 'D')
                || (cube.getFaceletColor(48) == 'D' && cube.getFaceletColor(46) == 'D');
    }

    public static boolean thirdLayerPartialConsistentCross(Cube cube) {
        return (piece17(cube) && piece18(cube))
                || (piece18(cube) && piece19(cube))
                || (piece19(cube) && piece20(cube))
                || (piece20(cube) && piece17(cube));
    }

    public static boolean thirdLayer1Corner(Cube cube) {
        return piece5(cube) || piece6(cube) || piece7(cube) || piece8(cube);
    }
}