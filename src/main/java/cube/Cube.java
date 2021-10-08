package cube;

/**
 *                                                                                               *
 *          Solved Cube                              Order Mapping of Pieces                     *
 *                                                                                               *
 *           [U][U][U]                     |              [00][01][02]                           *
 *           [U][U][U]                     |              [03][04][05]                           *
 *           [U][U][U]                     |              [06][07][08]                           *
 *                                         |                                                     *
 * [L][L][L] [F][F][F] [R][R][R] [B][B][B] | [09][10][11] [18][19][20] [27][28][29] [36][37][38] *
 * [L][L][L] [F][F][F] [R][R][R] [B][B][B] | [12][13][14] [21][22][23] [30][31][32] [39][40][41] *
 * [L][L][L] [F][F][F] [R][R][R] [B][B][B] | [15][16][17] [24][25][26] [33][34][35] [42][43][44] *
 *                                         |                                                     *
 *           [D][D][D]                     |              [45][46][47]                           *
 *           [D][D][D]                     |              [48][49][50]                           *
 *           [D][D][D]                     |              [51][52][53]                           *
 *                                                                                               *
 * ~~~~~~~ The Colors will be represented as follows:                                      ~~~~~ *
 * ~~~~~~~ White  (U): 1   (top)                                                           ~~~~~ *
 * ~~~~~~~ Orange (L): 2   (left)                                                          ~~~~~ *
 * ~~~~~~~ Green  (F): 3   (front)                                                         ~~~~~ *
 * ~~~~~~~ Red    (R): 4   (right)                                                         ~~~~~ *
 * ~~~~~~~ Blue   (B): 5   (back)                                                          ~~~~~ *
 * ~~~~~~~ Yellow (D): 6   (bottom)                                                        ~~~~~ *
 */


import java.util.Random;

public class Cube {
    /* Define the representation of each color in binary                                   ~~~~~ */
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char FRONT = 'F';
    private static final char BACK = 'B';

    private char[] cube;

    private Random random; // TODO смотри реализацию

    public Cube() {
        this.cube = new char[54];
        initializeCube();
        this.random = new Random();
    }

    /**
     * FRONT rotation.
     */
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

    /**
     * 2 FRONT rotations.
     */
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

    /**
     * REVERSE FRONT rotation.
     */
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

    /**
     * BACK rotation.
     */
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

    /**
     * 2 BACK rotations.
     */
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

    /**
     * REVERSE BACK rotation.
     */
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

    /**
     * LEFT rotation.
     */
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

    /**
     * 2 LEFT rotation.
     */
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

    /**
     * REVERSE LEFT rotation.
     */
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

    /**
     * RIGHT rotation.
     */
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

    /**
     * 2 RIGHT rotations.
     */
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

    /**
     * REVERSE RIGHT rotation.
     */
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

    /**
     * UP rotation.
     */
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

    /**
     * 2 UP rotations.
     */
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

    /**
     * REVERSE UP rotation.
     */
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

    /**
     * DOWN rotation.
     */
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

    /**
     * 2 DOWN rotation.
     */
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

    /**
     * REVERSE DOWN rotation.
     */
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

    /**
     * Resolved cube initialization.
     */
    private void initializeCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                char faclet_color;
                switch (i) {
                    case 0:
                        faclet_color = UP;
                        break;
                    case 1:
                        faclet_color = LEFT;
                        break;
                    case 2:
                        faclet_color = FRONT;
                        break;
                    case 3:
                        faclet_color = RIGHT;
                        break;
                    case 4:
                        faclet_color = BACK;
                        break;
                    case 5:
                        faclet_color = DOWN;
                        break;
                    default:
                        faclet_color = '?';
                        break;
                }
                this.cube[(i * 9) + j] = faclet_color;
            }
        }
    }

    /**
     * Cube printing
     */
    public void printCube() {
        System.out.println("");
        /*
        UP side.
         */
        for (int i = 0; i < 3; i++) {
            char val1 = this.cube[(i * 3) + 0];
            char val2 = this.cube[(i * 3) + 1];
            char val3 = this.cube[(i * 3) + 2];
            System.out.println("           [" + val1 + "][" + val2 + "][" + val3 + "]");
        }
        System.out.println("");
        /*
        LEFT, FRONT, RIGHT and BACK sides.
         */
        for (int i = 0; i < 3; i++) { //Print the middle faces (orange, green, red, blue)
            for (int j = 0; j < 4; j++) {
                char val1 = this.cube[9 + (i * 3) + (j * 9)];
                char val2 = this.cube[9 + (i * 3) + (j * 9) + 1];
                char val3 = this.cube[9 + (i * 3) + (j * 9) + 2];
                System.out.print(" [" + val1 + "][" + val2 + "][" + val3 + "]");
            }
            System.out.print("\n");
        }
        /*
        DOWN side.
         */
        System.out.println("");
        for (int i = 0; i < 3; i++) {
            char val1 = this.cube[45 + (i * 3)];
            char val2 = this.cube[45 + (i * 3) + 1];
            char val3 = this.cube[45 + (i * 3) + 2];
            System.out.println("           [" + val1 + "][" + val2 + "][" + val3 + "]");
        }
        System.out.println("");
    }

    /**
     * Return smallCube face.
     */
    public char getFaceletColor(int facelet_index) {
        if (facelet_index >= 0 && facelet_index < 54) {
            return this.cube[facelet_index];
        }
        return '?';
    }

    /**
     * Randomizer.
     */
    public void scramble() {
        int number_of_turns = random.nextInt(20) + 20;
        number_of_turns = 20;
        for (int i = 0; i < number_of_turns; i++) {
            int turn = this.random.nextInt(17) + 1;
            switch (turn) {
                case 1:
                    System.out.println("F");
                    front();
                    break;
                case 2:
                    System.out.println("F2");
                    frontDouble();
                    break;
                case 3:
                    System.out.println("F'");
                    frontReverse();
                    break;
                case 4:
                    System.out.println("B");
                    back();
                    break;
                case 5:
                    System.out.println("B2");
                    backDouble();
                    break;
                case 6:
                    System.out.println("B'");
                    backReverse();
                    break;
                case 7:
                    System.out.println("L");
                    left();
                    break;
                case 8:
                    System.out.println("L2");
                    leftDouble();
                    break;
                case 9:
                    System.out.println("L'");
                    leftReverse();
                    break;
                case 10:
                    System.out.println("R");
                    right();
                    break;
                case 11:
                    System.out.println("R2");
                    rightDouble();
                    break;
                case 12:
                    System.out.println("R'");
                    rightReverse();
                    break;
                case 13:
                    System.out.println("U");
                    up();
                    break;
                case 14:
                    System.out.println("U2");
                    upDouble();
                    break;
                case 15:
                    System.out.println("U'");
                    upReverse();
                    break;
                case 16:
                    System.out.println("DOWN");
                    down();
                    break;
                case 17:
                    System.out.println("D2");
                    downDouble();
                    break;
                case 18:
                    System.out.println("D'");
                    downReverse();
                    break;
                default:
                    System.out.println("Error: Cube.scramble()");
                    break;
            }
        }
    }
}