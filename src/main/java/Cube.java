import java.util.List;
import java.util.Random;

public class Cube {
    private static final char UP = 'U';
    private static final char LEFT = 'L';
    private static final char FRONT = 'F';
    private static final char RIGHT = 'R';
    private static final char BACK = 'B';
    private static final char DOWN = 'D';

    private char[] cube;

    private Random random;

    public Cube() {
        this.cube = new char[54];
        initializeCube();
        this.random = new Random();
    }

    public void front() {
        char temp = this.cube[6];
        this.cube[6] = this.cube[17];
        this.cube[17] = this.cube[47];
        this.cube[47] = this.cube[27];
        this.cube[27] = temp;

        temp = this.cube[7];
        this.cube[7] = this.cube[14];
        this.cube[14] = this.cube[46];
        this.cube[46] = this.cube[30];
        this.cube[30] = temp;

        temp = this.cube[8];
        this.cube[8] = this.cube[11];
        this.cube[11] = this.cube[45];
        this.cube[45] = this.cube[33];
        this.cube[33] = temp;

        temp = this.cube[18];
        this.cube[18] = this.cube[24];
        this.cube[24] = this.cube[26];
        this.cube[26] = this.cube[20];
        this.cube[20] = temp;

        temp = this.cube[19];
        this.cube[19] = this.cube[21];
        this.cube[21] = this.cube[25];
        this.cube[25] = this.cube[23];
        this.cube[23] = temp;
    }

    public void frontDouble() {
        char temp = this.cube[6];
        this.cube[6] = this.cube[47];
        this.cube[47] = temp;

        temp = this.cube[7];
        this.cube[7] = this.cube[46];
        this.cube[46] = temp;

        temp = this.cube[8];
        this.cube[8] = this.cube[45];
        this.cube[45] = temp;

        temp = this.cube[11];
        this.cube[11] = this.cube[33];
        this.cube[33] = temp;

        temp = this.cube[14];
        this.cube[14] = this.cube[30];
        this.cube[30] = temp;

        temp = this.cube[17];
        this.cube[17] = this.cube[27];
        this.cube[27] = temp;

        temp = this.cube[18];
        this.cube[18] = this.cube[26];
        this.cube[26] = temp;

        temp = this.cube[19];
        this.cube[19] = this.cube[25];
        this.cube[25] = temp;

        temp = this.cube[24];
        this.cube[24] = this.cube[20];
        this.cube[20] = temp;

        temp = this.cube[21];
        this.cube[21] = this.cube[23];
        this.cube[23] = temp;
    }

    public void frontReverse() {
        char temp = this.cube[6];
        this.cube[6] = this.cube[27];
        this.cube[27] = this.cube[47];
        this.cube[47] = this.cube[17];
        this.cube[17] = temp;

        temp = this.cube[7];
        this.cube[7] = this.cube[30];
        this.cube[30] = this.cube[46];
        this.cube[46] = this.cube[14];
        this.cube[14] = temp;

        temp = this.cube[8];
        this.cube[8] = this.cube[33];
        this.cube[33] = this.cube[45];
        this.cube[45] = this.cube[11];
        this.cube[11] = temp;

        temp = this.cube[18];
        this.cube[18] = this.cube[20];
        this.cube[20] = this.cube[26];
        this.cube[26] = this.cube[24];
        this.cube[24] = temp;

        temp = this.cube[19];
        this.cube[19] = this.cube[23];
        this.cube[23] = this.cube[25];
        this.cube[25] = this.cube[21];
        this.cube[21] = temp;
    }

    public void back() {
        char temp = this.cube[0];
        this.cube[0] = this.cube[29];
        this.cube[29] = this.cube[53];
        this.cube[53] = this.cube[15];
        this.cube[15] = temp;

        temp = this.cube[1];
        this.cube[1] = this.cube[32];
        this.cube[32] = this.cube[52];
        this.cube[52] = this.cube[12];
        this.cube[12] = temp;

        temp = this.cube[2];
        this.cube[2] = this.cube[35];
        this.cube[35] = this.cube[51];
        this.cube[51] = this.cube[9];
        this.cube[9] = temp;

        temp = this.cube[36];
        this.cube[36] = this.cube[42];
        this.cube[42] = this.cube[44];
        this.cube[44] = this.cube[38];
        this.cube[38] = temp;

        temp = this.cube[37];
        this.cube[37] = this.cube[39];
        this.cube[39] = this.cube[43];
        this.cube[43] = this.cube[41];
        this.cube[41] = temp;
    }

    public void backDouble() {
        char temp = this.cube[0];
        this.cube[0] = this.cube[53];
        this.cube[53] = temp;

        temp = this.cube[1];
        this.cube[1] = this.cube[52];
        this.cube[52] = temp;

        temp = this.cube[2];
        this.cube[2] = this.cube[51];
        this.cube[51] = temp;

        temp = this.cube[29];
        this.cube[29] = this.cube[15];
        this.cube[15] = temp;

        temp = this.cube[32];
        this.cube[32] = this.cube[12];
        this.cube[12] = temp;

        temp = this.cube[35];
        this.cube[35] = this.cube[9];
        this.cube[9] = temp;

        temp = this.cube[37];
        this.cube[37] = this.cube[43];
        this.cube[43] = temp;

        temp = this.cube[39];
        this.cube[39] = this.cube[41];
        this.cube[41] = temp;

        temp = this.cube[36];
        this.cube[36] = this.cube[44];
        this.cube[44] = temp;

        temp = this.cube[38];
        this.cube[38] = this.cube[42];
        this.cube[42] = temp;
    }

    public void backReverse() {
        char temp = this.cube[0];
        this.cube[0] = this.cube[15];
        this.cube[15] = this.cube[53];
        this.cube[53] = this.cube[29];
        this.cube[29] = temp;

        temp = this.cube[1];
        this.cube[1] = this.cube[12];
        this.cube[12] = this.cube[52];
        this.cube[52] = this.cube[32];
        this.cube[32] = temp;

        temp = this.cube[2];
        this.cube[2] = this.cube[9];
        this.cube[9] = this.cube[51];
        this.cube[51] = this.cube[35];
        this.cube[35] = temp;

        temp = this.cube[36];
        this.cube[36] = this.cube[38];
        this.cube[38] = this.cube[44];
        this.cube[44] = this.cube[42];
        this.cube[42] = temp;

        temp = this.cube[37];
        this.cube[37] = this.cube[41];
        this.cube[41] = this.cube[43];
        this.cube[43] = this.cube[39];
        this.cube[39] = temp;
    }

    public void left() {
        char temp = this.cube[0];
        this.cube[0] = this.cube[44];
        this.cube[44] = this.cube[45];
        this.cube[45] = this.cube[18];
        this.cube[18] = temp;

        temp = this.cube[3];
        this.cube[3] = this.cube[41];
        this.cube[41] = this.cube[48];
        this.cube[48] = this.cube[21];
        this.cube[21] = temp;

        temp = this.cube[6];
        this.cube[6] = this.cube[38];
        this.cube[38] = this.cube[51];
        this.cube[51] = this.cube[24];
        this.cube[24] = temp;

        temp = this.cube[9];
        this.cube[9] = this.cube[15];
        this.cube[15] = this.cube[17];
        this.cube[17] = this.cube[11];
        this.cube[11] = temp;

        temp = this.cube[10];
        this.cube[10] = this.cube[12];
        this.cube[12] = this.cube[16];
        this.cube[16] = this.cube[14];
        this.cube[14] = temp;
    }

    public void leftDouble() {
        char temp = this.cube[0];
        this.cube[0] = this.cube[45];
        this.cube[45] = temp;

        temp = this.cube[3];
        this.cube[3] = this.cube[48];
        this.cube[48] = temp;

        temp = this.cube[6];
        this.cube[6] = this.cube[51];
        this.cube[51] = temp;

        temp = this.cube[44];
        this.cube[44] = this.cube[18];
        this.cube[18] = temp;

        temp = this.cube[41];
        this.cube[41] = this.cube[21];
        this.cube[21] = temp;

        temp = this.cube[38];
        this.cube[38] = this.cube[24];
        this.cube[24] = temp;

        temp = this.cube[9];
        this.cube[9] = this.cube[17];
        this.cube[17] = temp;

        temp = this.cube[11];
        this.cube[11] = this.cube[15];
        this.cube[15] = temp;

        temp = this.cube[10];
        this.cube[10] = this.cube[16];
        this.cube[16] = temp;

        temp = this.cube[12];
        this.cube[12] = this.cube[14];
        this.cube[14] = temp;
    }

    public void leftReverse() {
        char temp = this.cube[0];
        this.cube[0] = this.cube[18];
        this.cube[18] = this.cube[45];
        this.cube[45] = this.cube[44];
        this.cube[44] = temp;

        temp = this.cube[3];
        this.cube[3] = this.cube[21];
        this.cube[21] = this.cube[48];
        this.cube[48] = this.cube[41];
        this.cube[41] = temp;

        temp = this.cube[6];
        this.cube[6] = this.cube[24];
        this.cube[24] = this.cube[51];
        this.cube[51] = this.cube[38];
        this.cube[38] = temp;

        temp = this.cube[9];
        this.cube[9] = this.cube[11];
        this.cube[11] = this.cube[17];
        this.cube[17] = this.cube[15];
        this.cube[15] = temp;

        temp = this.cube[10];
        this.cube[10] = this.cube[14];
        this.cube[14] = this.cube[16];
        this.cube[16] = this.cube[12];
        this.cube[12] = temp;
    }

    public void right() {
        char temp = this.cube[2];
        this.cube[2] = this.cube[20];
        this.cube[20] = this.cube[47];
        this.cube[47] = this.cube[42];
        this.cube[42] = temp;

        temp = this.cube[5];
        this.cube[5] = this.cube[23];
        this.cube[23] = this.cube[50];
        this.cube[50] = this.cube[39];
        this.cube[39] = temp;

        temp = this.cube[8];
        this.cube[8] = this.cube[26];
        this.cube[26] = this.cube[53];
        this.cube[53] = this.cube[36];
        this.cube[36] = temp;

        temp = this.cube[27];
        this.cube[27] = this.cube[33];
        this.cube[33] = this.cube[35];
        this.cube[35] = this.cube[29];
        this.cube[29] = temp;

        temp = this.cube[28];
        this.cube[28] = this.cube[30];
        this.cube[30] = this.cube[34];
        this.cube[34] = this.cube[32];
        this.cube[32] = temp;
    }

    public void rightDouble() {
        char temp = this.cube[2];
        this.cube[2] = this.cube[47];
        this.cube[47] = temp;

        temp = this.cube[5];
        this.cube[5] = this.cube[50];
        this.cube[50] = temp;

        temp = this.cube[8];
        this.cube[8] = this.cube[53];
        this.cube[53] = temp;

        temp = this.cube[20];
        this.cube[20] = this.cube[42];
        this.cube[42] = temp;

        temp = this.cube[23];
        this.cube[23] = this.cube[39];
        this.cube[39] = temp;

        temp = this.cube[26];
        this.cube[26] = this.cube[36];
        this.cube[36] = temp;

        temp = this.cube[28];
        this.cube[28] = this.cube[34];
        this.cube[34] = temp;

        temp = this.cube[32];
        this.cube[32] = this.cube[30];
        this.cube[30] = temp;

        temp = this.cube[27];
        this.cube[27] = this.cube[35];
        this.cube[35] = temp;

        temp = this.cube[33];
        this.cube[33] = this.cube[29];
        this.cube[29] = temp;
    }

    public void rightReverse() {
        char temp = this.cube[2];
        this.cube[2] = this.cube[42];
        this.cube[42] = this.cube[47];
        this.cube[47] = this.cube[20];
        this.cube[20] = temp;

        temp = this.cube[5];
        this.cube[5] = this.cube[39];
        this.cube[39] = this.cube[50];
        this.cube[50] = this.cube[23];
        this.cube[23] = temp;

        temp = this.cube[8];
        this.cube[8] = this.cube[36];
        this.cube[36] = this.cube[53];
        this.cube[53] = this.cube[26];
        this.cube[26] = temp;

        temp = this.cube[27];
        this.cube[27] = this.cube[29];
        this.cube[29] = this.cube[35];
        this.cube[35] = this.cube[33];
        this.cube[33] = temp;

        temp = this.cube[28];
        this.cube[28] = this.cube[32];
        this.cube[32] = this.cube[34];
        this.cube[34] = this.cube[30];
        this.cube[30] = temp;
    }

    public void up() {
        char temp = this.cube[9];
        this.cube[9] = this.cube[18];
        this.cube[18] = this.cube[27];
        this.cube[27] = this.cube[36];
        this.cube[36] = temp;

        temp = this.cube[10];
        this.cube[10] = this.cube[19];
        this.cube[19] = this.cube[28];
        this.cube[28] = this.cube[37];
        this.cube[37] = temp;

        temp = this.cube[11];
        this.cube[11] = this.cube[20];
        this.cube[20] = this.cube[29];
        this.cube[29] = this.cube[38];
        this.cube[38] = temp;

        temp = this.cube[0];
        this.cube[0] = this.cube[6];
        this.cube[6] = this.cube[8];
        this.cube[8] = this.cube[2];
        this.cube[2] = temp;

        temp = this.cube[1];
        this.cube[1] = this.cube[3];
        this.cube[3] = this.cube[7];
        this.cube[7] = this.cube[5];
        this.cube[5] = temp;
    }

    public void upDouble() {
        char temp = this.cube[9];
        this.cube[9] = this.cube[27];
        this.cube[27] = temp;

        temp = this.cube[10];
        this.cube[10] = this.cube[28];
        this.cube[28] = temp;

        temp = this.cube[11];
        this.cube[11] = this.cube[29];
        this.cube[29] = temp;

        temp = this.cube[18];
        this.cube[18] = this.cube[36];
        this.cube[36] = temp;

        temp = this.cube[19];
        this.cube[19] = this.cube[37];
        this.cube[37] = temp;

        temp = this.cube[20];
        this.cube[20] = this.cube[38];
        this.cube[38] = temp;

        temp = this.cube[1];
        this.cube[1] = this.cube[7];
        this.cube[7] = temp;

        temp = this.cube[3];
        this.cube[3] = this.cube[5];
        this.cube[5] = temp;

        temp = this.cube[0];
        this.cube[0] = this.cube[8];
        this.cube[8] = temp;

        temp = this.cube[2];
        this.cube[2] = this.cube[6];
        this.cube[6] = temp;
    }

    public void upReverse() {
        char temp = this.cube[9];
        this.cube[9] = this.cube[36];
        this.cube[36] = this.cube[27];
        this.cube[27] = this.cube[18];
        this.cube[18] = temp;

        temp = this.cube[10];
        this.cube[10] = this.cube[37];
        this.cube[37] = this.cube[28];
        this.cube[28] = this.cube[19];
        this.cube[19] = temp;

        temp = this.cube[11];
        this.cube[11] = this.cube[38];
        this.cube[38] = this.cube[29];
        this.cube[29] = this.cube[20];
        this.cube[20] = temp;

        temp = this.cube[0];
        this.cube[0] = this.cube[2];
        this.cube[2] = this.cube[8];
        this.cube[8] = this.cube[6];
        this.cube[6] = temp;

        temp = this.cube[1];
        this.cube[1] = this.cube[5];
        this.cube[5] = this.cube[7];
        this.cube[7] = this.cube[3];
        this.cube[3] = temp;
    }

    public void down() {
        char temp = this.cube[15];
        this.cube[15] = this.cube[42];
        this.cube[42] = this.cube[33];
        this.cube[33] = this.cube[24];
        this.cube[24] = temp;

        temp = this.cube[16];
        this.cube[16] = this.cube[43];
        this.cube[43] = this.cube[34];
        this.cube[34] = this.cube[25];
        this.cube[25] = temp;

        temp = this.cube[17];
        this.cube[17] = this.cube[44];
        this.cube[44] = this.cube[35];
        this.cube[35] = this.cube[26];
        this.cube[26] = temp;

        temp = this.cube[45];
        this.cube[45] = this.cube[51];
        this.cube[51] = this.cube[53];
        this.cube[53] = this.cube[47];
        this.cube[47] = temp;

        temp = this.cube[46];
        this.cube[46] = this.cube[48];
        this.cube[48] = this.cube[52];
        this.cube[52] = this.cube[50];
        this.cube[50] = temp;
    }

    public void downDouble() {
        char temp = this.cube[15];
        this.cube[15] = this.cube[33];
        this.cube[33] = temp;

        temp = this.cube[16];
        this.cube[16] = this.cube[34];
        this.cube[34] = temp;

        temp = this.cube[17];
        this.cube[17] = this.cube[35];
        this.cube[35] = temp;

        temp = this.cube[42];
        this.cube[42] = this.cube[24];
        this.cube[24] = temp;

        temp = this.cube[43];
        this.cube[43] = this.cube[25];
        this.cube[25] = temp;

        temp = this.cube[44];
        this.cube[44] = this.cube[26];
        this.cube[26] = temp;


        temp = this.cube[46];
        this.cube[46] = this.cube[52];
        this.cube[52] = temp;

        temp = this.cube[48];
        this.cube[48] = this.cube[50];
        this.cube[50] = temp;

        temp = this.cube[45];
        this.cube[45] = this.cube[53];
        this.cube[53] = temp;

        temp = this.cube[47];
        this.cube[47] = this.cube[51];
        this.cube[51] = temp;
    }

    public void downReverse() {
        char temp = this.cube[15];
        this.cube[15] = this.cube[24];
        this.cube[24] = this.cube[33];
        this.cube[33] = this.cube[42];
        this.cube[42] = temp;

        temp = this.cube[16];
        this.cube[16] = this.cube[25];
        this.cube[25] = this.cube[34];
        this.cube[34] = this.cube[43];
        this.cube[43] = temp;

        temp = this.cube[17];
        this.cube[17] = this.cube[26];
        this.cube[26] = this.cube[35];
        this.cube[35] = this.cube[44];
        this.cube[44] = temp;

        temp = this.cube[45];
        this.cube[45] = this.cube[47];
        this.cube[47] = this.cube[53];
        this.cube[53] = this.cube[51];
        this.cube[51] = temp;

        temp = this.cube[46];
        this.cube[46] = this.cube[50];
        this.cube[50] = this.cube[52];
        this.cube[52] = this.cube[48];
        this.cube[48] = temp;
    }

    private void initializeCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                char face;
                switch (i) {
                    case 0:
                        face = UP;
                        break;
                    case 1:
                        face = LEFT;
                        break;
                    case 2:
                        face = FRONT;
                        break;
                    case 3:
                        face = RIGHT;
                        break;
                    case 4:
                        face = BACK;
                        break;
                    case 5:
                        face = DOWN;
                        break;
                    default:
                        face = '?';
                        break;
                }
                this.cube[(i * 9) + j] = face;
            }
        }
    }

    public void printCube() {
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            char val1 = this.cube[(i * 3) + 0];
            char val2 = this.cube[(i * 3) + 1];
            char val3 = this.cube[(i * 3) + 2];
            System.out.println("           [" + val1 + "][" + val2 + "][" + val3 + "]");
        }
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                char val1 = this.cube[9 + (i * 3) + (j * 9) + 0];
                char val2 = this.cube[9 + (i * 3) + (j * 9) + 1];
                char val3 = this.cube[9 + (i * 3) + (j * 9) + 2];
                System.out.print(" [" + val1 + "][" + val2 + "][" + val3 + "]");
            }
            System.out.print("\n");
        }
        System.out.println(""); //Print the white face
        for (int i = 0; i < 3; i++) {
            char val1 = this.cube[45 + (i * 3) + 0];
            char val2 = this.cube[45 + (i * 3) + 1];
            char val3 = this.cube[45 + (i * 3) + 2];
            System.out.println("           [" + val1 + "][" + val2 + "][" + val3 + "]");
        }
        System.out.println("");
    }

    public char getFAce(int facelet_index) {
        if (facelet_index >= 0 && facelet_index < 54) {
            return this.cube[facelet_index];
        }
        return '?';
    }

    public void scramble(int turnsNumber) {
        if (turnsNumber < 0) {
            return;
        }
        turnsNumber = turnsNumber < 10 ? turnsNumber : turnsNumber - 10;
        for (int i = 0; i < turnsNumber; i++) {
            int turn = this.random.nextInt(17) + 1;
            switch (turn) {
                case 1:
                    front();
                    System.out.println(Turn.FRONT.notation);
                    break;
                case 2:
                    System.out.println(Turn.FRONT_DOUBLE.notation);
                    frontDouble();
                    break;
                case 3:
                    System.out.println(Turn.FRONT_REVERSE.notation);
                    frontReverse();
                    break;
                case 4:
                    System.out.println(Turn.BACK.notation);
                    back();
                    break;
                case 5:
                    System.out.println(Turn.BACK_DOUBLE.notation);
                    backDouble();
                    break;
                case 6:
                    System.out.println(Turn.BACK_REVERSE.notation);
                    backReverse();
                    break;
                case 7:
                    System.out.println(Turn.LEFT.notation);
                    left();
                    break;
                case 8:
                    System.out.println(Turn.LEFT_DOUBLE.notation);
                    leftDouble();
                    break;
                case 9:
                    System.out.println(Turn.LEFT_REVERSE.notation);
                    leftReverse();
                    break;
                case 10:
                    System.out.println(Turn.RIGHT.notation);
                    right();
                    break;
                case 11:
                    System.out.println(Turn.RIGHT_DOUBLE.notation);
                    rightDouble();
                    break;
                case 12:
                    System.out.println(Turn.RIGHT_REVERSE.notation);
                    rightReverse();
                    break;
                case 13:
                    System.out.println(Turn.UP.notation);
                    up();
                    break;
                case 14:
                    System.out.println(Turn.UP_DOUBLE.notation);
                    upDouble();
                    break;
                case 15:
                    System.out.println(Turn.UP_REVERSE.notation);
                    upReverse();
                    break;
                case 16:
                    System.out.println(Turn.DOWN.notation);
                    down();
                    break;
                case 17:
                    System.out.println(Turn.DOWN_DOUBLE.notation);
                    downDouble();
                    break;
                case 18:
                    System.out.println(Turn.DOWN_REVERSE.notation);
                    downReverse();
                    break;
                default:
                    System.out.println("Error: Cube.scramble()");
                    break;
            }
            printCube();
        }

    }

    public void rotateByListTurns(List<Turn> turns) {
        for (Turn turn : turns) {
            System.out.println(turn.performTurn(this));
            printCube();
        }
    }
}