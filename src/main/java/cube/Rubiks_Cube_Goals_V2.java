package cube;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Jeffrey Martin                                                                    ~~~~~ *
 * ~~~~~ CS4341 Introduction to Artifical Intelligence                                     ~~~~~ *
 * ~~~~~ Professor Neil Heffernan                                                          ~~~~~ *
 * ~~~~~ October 24th, 2016                                                                ~~~~~ *
 * ~~~~~                                                                                   ~~~~~ *
 * ~~~~~ BSMS Project : Goal Oriented Rubiks Cube Solver with IDA*                         ~~~~~ *
 * ~~~~~ File: Rubiks_Cube_Goals_V2.java                                                   ~~~~~ *
 * ~~~~~ File Description                                                                  ~~~~~ *
 * ~~~~~~~ This class defines all the goal states of the rubiks cube. All methods are      ~~~~~ *
 * ~~~~~~~ static and accept an object that implements Rubiks_Cube_Interface. They all     ~~~~~ *
 * ~~~~~~~ return a boolean indicating if the current cube satisfies the goal.             ~~~~~ *
 * ~~~~~~~ The simplest subgoal is getting 1 piece to its final location and proper        ~~~~~ *
 * ~~~~~~~ orientation. All goals are a joining of these simple subgoals with the 'and' or ~~~~~ *
 * ~~~~~~~ 'or' operators. (Ex: the solved cube is the and of all simple subgoals).        ~~~~~ *
 * ~~~~~~~ Because the center of each face can not change, we do not need to consider it   ~~~~~ *
 * ~~~~~~~ as a goal. This leaves 20 pieces remaining to consider. The pieces are ordered  ~~~~~ *
 * ~~~~~~~ as follows:                                                                     ~~~~~ *
 * ~~~~~~~ 1:  WOB corner                                                                  ~~~~~ *
 * ~~~~~~~ 2:  WRB corner                                                                  ~~~~~ *
 * ~~~~~~~ 3:  WRG corner                                                                  ~~~~~ *
 * ~~~~~~~ 4:  WOG corner                                                                  ~~~~~ *
 * ~~~~~~~ 5:  YOB corner                                                                  ~~~~~ *
 * ~~~~~~~ 6:  YRB corner                                                                  ~~~~~ *
 * ~~~~~~~ 7:  YRG corner                                                                  ~~~~~ *
 * ~~~~~~~ 8:  YOG corner                                                                  ~~~~~ *
 * ~~~~~~~ 9:  WO  edge                                                                    ~~~~~ *
 * ~~~~~~~ 10: WB  edge                                                                    ~~~~~ *
 * ~~~~~~~ 11: WR  edge                                                                    ~~~~~ *
 * ~~~~~~~ 12: WG  edge                                                                    ~~~~~ *
 * ~~~~~~~ 13: OB  edge                                                                    ~~~~~ *
 * ~~~~~~~ 14: BR  edge                                                                    ~~~~~ *
 * ~~~~~~~ 15: RG  edge                                                                    ~~~~~ *
 * ~~~~~~~ 16: GO  edge                                                                    ~~~~~ *
 * ~~~~~~~ 17: YO  edge                                                                    ~~~~~ *
 * ~~~~~~~ 18: YB  edge                                                                    ~~~~~ *
 * ~~~~~~~ 19: YR  edge                                                                    ~~~~~ *
 * ~~~~~~~ 20: YG  edge                                                                    ~~~~~ *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Rubiks_Cube_Goals_V2 {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
	 * ~~~~~ Solved Goal                                                                   ~~~~~ *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static boolean solved(Cube cube){
		return 
			piece1(cube) &&
			piece2(cube) &&
			piece3(cube) &&
			piece4(cube) &&
			piece5(cube) &&
			piece6(cube) &&
			piece7(cube) &&
			piece8(cube) &&
			piece9(cube) &&
			piece10(cube) &&
			piece11(cube) &&
			piece12(cube) &&
			piece13(cube) &&
			piece14(cube) &&
			piece15(cube) &&
			piece16(cube) &&
			piece17(cube) &&
			piece18(cube) &&
			piece19(cube) &&
			piece20(cube);
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
	 * ~~~~~ Piece Goals                                                                   ~~~~~ *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	public static boolean piece1(Cube cube){
		return 
			cube.getFaceletColor(0)  == 'U' &&
			cube.getFaceletColor(9)  == 'L' &&
			cube.getFaceletColor(38) == 'B';
	}

	public static boolean piece2(Cube cube){
		return 
			cube.getFaceletColor(2)  == 'U' &&
			cube.getFaceletColor(29) == 'R' &&
			cube.getFaceletColor(36) == 'B';
	}

	public static boolean piece3(Cube cube){
		return 
			cube.getFaceletColor(8)  == 'U' &&
			cube.getFaceletColor(27) == 'R' &&
			cube.getFaceletColor(20) == 'F';
	}

	public static boolean piece4(Cube cube){
		return 
			cube.getFaceletColor(6)  == 'U' &&
			cube.getFaceletColor(11) == 'L' &&
			cube.getFaceletColor(18) == 'F';
	}

	public static boolean piece5(Cube cube){
		return 
			cube.getFaceletColor(51) == 'D' &&
			cube.getFaceletColor(15) == 'L' &&
			cube.getFaceletColor(44) == 'B';
	}

	public static boolean piece6(Cube cube){
		return 
			cube.getFaceletColor(53) == 'D' &&
			cube.getFaceletColor(35) == 'R' &&
			cube.getFaceletColor(42) == 'B';
	}

	public static boolean piece7(Cube cube){
		return 
			cube.getFaceletColor(47) == 'D' &&
			cube.getFaceletColor(33) == 'R' &&
			cube.getFaceletColor(26) == 'F';
	}

	public static boolean piece8(Cube cube){
		return 
			cube.getFaceletColor(45) == 'D' &&
			cube.getFaceletColor(17) == 'L' &&
			cube.getFaceletColor(24) == 'F';
	}

	public static boolean piece9(Cube cube){
		return 
			cube.getFaceletColor(3)  == 'U' &&
			cube.getFaceletColor(10) == 'L';
	}

	public static boolean piece10(Cube cube){
		return 
			cube.getFaceletColor(1)  == 'U' &&
			cube.getFaceletColor(37) == 'B';
	}

	public static boolean piece11(Cube cube){
		return 
			cube.getFaceletColor(5)  == 'U' &&
			cube.getFaceletColor(28) == 'R';
	}

	public static boolean piece12(Cube cube){
		return 
			cube.getFaceletColor(7)  == 'U' &&
			cube.getFaceletColor(19) == 'F';
	}

	public static boolean piece13(Cube cube){
		return 
			cube.getFaceletColor(12) == 'L' &&
			cube.getFaceletColor(41) == 'B';
	}

	public static boolean piece14(Cube cube){
		return 
			cube.getFaceletColor(39) == 'B' &&
			cube.getFaceletColor(32) == 'R';
	}

	public static boolean piece15(Cube cube){
		return 
			cube.getFaceletColor(30) == 'R' &&
			cube.getFaceletColor(23) == 'F';
	}

	public static boolean piece16(Cube cube){
		return 
			cube.getFaceletColor(21) == 'F' &&
			cube.getFaceletColor(14) == 'L';
	}

	public static boolean piece17(Cube cube){
		return 
			cube.getFaceletColor(48) == 'D' &&
			cube.getFaceletColor(16) == 'L';
	}

	public static boolean piece18(Cube cube){
		return 
			cube.getFaceletColor(52) == 'D' &&
			cube.getFaceletColor(43) == 'B';
	}

	public static boolean piece19(Cube cube){
		return 
			cube.getFaceletColor(50) == 'D' &&
			cube.getFaceletColor(34) == 'R';
	}

	public static boolean piece20(Cube cube){
		return 
			cube.getFaceletColor(46) == 'D' &&
			cube.getFaceletColor(25) == 'F';
	}

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
	 * ~~~~~ Beginners Method Goals                                                        ~~~~~ *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

	/* This function determines if the rubiks cube has a white cross                       ~~~~~ */
	public static boolean crossW(Cube cube){
		return 
			piece9(cube) &&
			piece10(cube) &&
			piece11(cube) &&
			piece12(cube);
	}

	/* This function determines if one corner piece has been placed in the rubiks cube's   ~~~~~ *
	 * first layer (white)                                                                 ~~~~~ */
	public static boolean firstLayerW1(Cube cube){
		return 
			piece1(cube) ||
			piece2(cube) ||
			piece3(cube) ||
			piece4(cube);
	}

	/* This function determines if two corner pieces have been placed in the rubiks cube's ~~~~~ *
	 * first layer (white).                                                                ~~~~~ */
	public static boolean firstLayerW2(Cube cube){
		int corners = 0;
		if(piece1(cube)) corners++;
		if(piece2(cube)) corners++;
		if(piece3(cube)) corners++;
		if(piece4(cube)) corners++;		
		return corners >= 2;
	}

	/* This function determines if three corner pieces have been placed in the rubik's     ~~~~~ *
	 * cube's first layer (white).                                                         ~~~~~ */
	public static boolean firstLayerW3(Cube cube){
		int corners = 0;
		if(piece1(cube)) corners++;
		if(piece2(cube)) corners++;
		if(piece3(cube)) corners++;
		if(piece4(cube)) corners++;		
		return corners >= 3;
	}

	/* This function determines if the first layer of the rubiks cube is solved            ~~~~~ */
	public static boolean firstLayerW4(Cube cube){
		return
		piece1(cube) &&
		piece2(cube) &&
		piece3(cube) &&
		piece4(cube);
	}

	/* This function determines if 1 edge piece are placed in the second layer(white)      ~~~~~ */
	public static boolean secondLayerW1(Cube cube){
		return 
			piece13(cube) ||
			piece14(cube) ||
			piece15(cube) ||
			piece16(cube);
	}

	/* This function determines if 2 edge pieces are placed in the second layer(white)     ~~~~~ */
	public static boolean secondLayerW2(Cube cube){
		int edges = 0;
		if(piece13(cube)) edges++;
		if(piece14(cube)) edges++;
		if(piece15(cube)) edges++;
		if(piece16(cube)) edges++;
		return edges >= 2;
		
	}

	/* This function determines if 3 edge pieces are placed in the second layer(white)     ~~~~~ */
	public static boolean secondLayerW3(Cube cube){
		int edges = 0;
		if(piece13(cube)) edges++;
		if(piece14(cube)) edges++;
		if(piece15(cube)) edges++;
		if(piece16(cube)) edges++;
		return edges >= 3;
	}

	/* This function determines if 4 edge pieces are placed in the second layer(white)     ~~~~~ */
	public static boolean secondLayerW4(Cube cube){
		return
			piece13(cube) &&
			piece14(cube) &&
			piece15(cube) &&
			piece16(cube);
	}

	/* This function determines if the yellow cross(not consistent with layer) has         ~~~~~ *
	 * been formed                                                                         ~~~~~ */
	public static boolean inconsistentThirdLayerCrossW(Cube cube){
		return 
			cube.getFaceletColor(46) == 'D' &&
			cube.getFaceletColor(48) == 'D' &&
			cube.getFaceletColor(50) == 'D' &&
			cube.getFaceletColor(52) == 'D';
	}

	/* This function determines if the yellow cross(consistent with the layer) has         ~~~~~ *
	 * been formed.                                                                        ~~~~~ */
	public static boolean ThirdLayerCrossW(Cube cube){
		return 
			piece17(cube) &&
			piece18(cube) &&
			piece19(cube) &&
			piece20(cube);
	}


	/* This function determines if one of the yellow corners is in in the right position.  ~~~~~ */
	public static boolean ThirdLayerCornerPositionW1(Cube cube){
		/* Check Corner 5                                                                  ~~~~~ */
		//faclets of corner 5 (YOB)
		char F1 = cube.getFaceletColor(51);
		char F2 = cube.getFaceletColor(15);
		char F3 = cube.getFaceletColor(44);

		/* If Corner 5 is not in the right location. */
		if(((F1 == 'D' && F2 == 'L' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'B' && F3 == 'D')))
			return true;

		/* Check Corner 6                                                                  ~~~~~ */
		//faclets of corner 6 (YRB)
		F1 = cube.getFaceletColor(53);
		F2 = cube.getFaceletColor(35);
		F3 = cube.getFaceletColor(42);

		/* If Corner 6 is not in the right location. */
		if(((F1 == 'D' && F2 == 'R' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'B' && F3 == 'D')))
			return true;

		/* Check Corner 7                                                                  ~~~~~ */
		//faclets of corner 7 (YRG)
		F1 = cube.getFaceletColor(47);
		F2 = cube.getFaceletColor(33);
		F3 = cube.getFaceletColor(26);

		/* If Corner 7 is not in the right location. */
		if(((F1 == 'D' && F2 == 'R' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'F' && F3 == 'D')))
			return true;

		/* Check Corner 8                                                                  ~~~~~ */
		//faclets of corner 8 (Y)G)
		F1 = cube.getFaceletColor(45);
		F2 = cube.getFaceletColor(17);
		F3 = cube.getFaceletColor(24);

		/* If Corner 8 is not in the right location. */
		if(((F1 == 'D' && F2 == 'L' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'F' && F3 == 'D')))
			return true;


		return false;
	}

	/* This function determines if the 4 corners of the last layer have been placed in the ~~~~~ *
	 * position, but not necessarily the proper orientation                                ~~~~~ */
	public static boolean ThirdLayerCornerPositions(Cube cube){
		/* Check Corner 5                                                                  ~~~~~ */
		//faclets of corner 5 (YOB)
		char F1 = cube.getFaceletColor(51);
		char F2 = cube.getFaceletColor(15);
		char F3 = cube.getFaceletColor(44);

		/* If Corner 5 is not in the right location. */
		if(!((F1 == 'D' && F2 == 'L' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'B' && F3 == 'D')))
			return false;

		/* Check Corner 6                                                                  ~~~~~ */
		//faclets of corner 6 (YRB)
		F1 = cube.getFaceletColor(53);
		F2 = cube.getFaceletColor(35);
		F3 = cube.getFaceletColor(42);

		/* If Corner 6 is not in the right location. */
		if(!((F1 == 'D' && F2 == 'R' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'B' && F3 == 'D')))
			return false;

		/* Check Corner 7                                                                  ~~~~~ */
		//faclets of corner 7 (YRG)
		F1 = cube.getFaceletColor(47);
		F2 = cube.getFaceletColor(33);
		F3 = cube.getFaceletColor(26);

		/* If Corner 7 is not in the right location. */
		if(!((F1 == 'D' && F2 == 'R' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'F' && F3 == 'D')))
			return false;

		/* Check Corner 8                                                                  ~~~~~ */
		//faclets of corner 8 (Y)G)
		F1 = cube.getFaceletColor(45);
		F2 = cube.getFaceletColor(17);
		F3 = cube.getFaceletColor(24);

		/* If Corner 8 is not in the right location. */
		if(!((F1 == 'D' && F2 == 'L' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'F' && F3 == 'D')))
			return false;


		return true;
	}

	/* This function determines if the 4 corners of the last layer have been placed in the ~~~~~ *
	 * position, but not necessarily the proper orientation                                ~~~~~ */
	public static boolean FirstLayerCornerPositions(Cube cube){
		/* Check Corner 1                                                                  ~~~~~ */
		//faclets of corner 1 (WOB)
		char F1 = cube.getFaceletColor(0);
		char F2 = cube.getFaceletColor(9);
		char F3 = cube.getFaceletColor(38);

		/* If Corner 1 is not in the right location. */
		if(!((F1 == 'U' && F2 == 'L' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'U' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'B' && F3 == 'U')))
			return false;

		/* Check Corner 2                                                                  ~~~~~ */
		//faclets of corner 2 (WRB)
		F1 = cube.getFaceletColor(2);
		F2 = cube.getFaceletColor(29);
		F3 = cube.getFaceletColor(36);

		/* If Corner 2 is not in the right location. */
		if(!((F1 == 'U' && F2 == 'R' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'U' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'B' && F3 == 'U')))
			return false;

		/* Check Corner 3                                                                  ~~~~~ */
		//faclets of corner 3 (WRG)
		F1 = cube.getFaceletColor(8);
		F2 = cube.getFaceletColor(27);
		F3 = cube.getFaceletColor(20);

		/* If Corner 3 is not in the right location. */
		if(!((F1 == 'U' && F2 == 'R' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'U' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'F' && F3 == 'U')))
			return false;

		/* Check Corner 4                                                                  ~~~~~ */
		//faclets of corner 4 (WOG)
		F1 = cube.getFaceletColor(6);
		F2 = cube.getFaceletColor(11);
		F3 = cube.getFaceletColor(18);

		/* If Corner 8 is not in the right location. */
		if(!((F1 == 'U' && F2 == 'L' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'U' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'F' && F3 == 'U')))
			return false;


		return true;
	}


	/* This function determines if n pieces are solved                                     ~~~~~ */
	private static boolean nPiecesSolved(Cube cube, int n){
		int count = 0;
		if(piece1(cube)) count++;
		if(count >= n) return true;
		if(piece2(cube)) count++;
		if(count >= n) return true;
		if(piece3(cube)) count++;
		if(count >= n) return true;
		if(piece4(cube)) count++;
		if(count >= n) return true;
		if(piece5(cube)) count++;
		if(count >= n) return true;
		if(piece6(cube)) count++;
		if(count >= n) return true;
		if(piece7(cube)) count++;
		if(count >= n) return true;
		if(piece8(cube)) count++;
		if(count >= n) return true;
		if(piece9(cube)) count++;
		if(count >= n) return true;
		if(piece10(cube)) count++;
		if(count >= n) return true;
		if(piece11(cube)) count++;
		if(count >= n) return true;
		if(piece12(cube)) count++;
		if(count >= n) return true;
		if(piece13(cube)) count++;
		if(count >= n) return true;
		if(piece14(cube)) count++;
		if(count >= n) return true;
		if(piece15(cube)) count++;
		if(count >= n) return true;
		if(piece16(cube)) count++;
		if(count >= n) return true;
		if(piece17(cube)) count++;
		if(count >= n) return true;
		if(piece18(cube)) count++;
		if(count >= n) return true;
		if(piece19(cube)) count++;
		if(count >= n) return true;
		if(piece20(cube)) count++;
		if(count >= n) return true;
		return false;
	}

	public static boolean PPP1(Cube cube){
		return nPiecesSolved(cube, 1);
	}

	public static boolean PPP2(Cube cube){
		return nPiecesSolved(cube, 2);
	}

	public static boolean PPP3(Cube cube){
		return nPiecesSolved(cube, 3);
	}

	public static boolean PPP4(Cube cube){
		return nPiecesSolved(cube, 4);
	}

	public static boolean PPP5(Cube cube){
		return nPiecesSolved(cube, 5);
	}

	public static boolean PPP6(Cube cube){
		return nPiecesSolved(cube, 6);
	}

	public static boolean PPP7(Cube cube){
		return nPiecesSolved(cube, 7);
	}

	public static boolean PPP8(Cube cube){
		return nPiecesSolved(cube, 8);
	}

	public static boolean PPP9(Cube cube){
		return nPiecesSolved(cube, 9);
	}

	public static boolean PPP10(Cube cube){
		return nPiecesSolved(cube, 10);
	}

	public static boolean PPP11(Cube cube){
		return nPiecesSolved(cube, 11);
	}

	public static boolean PPP12(Cube cube){
		return nPiecesSolved(cube, 12);
	}

	public static boolean PPP13(Cube cube){
		return nPiecesSolved(cube, 13);
	}

	public static boolean PPP14(Cube cube){
		return nPiecesSolved(cube, 14);
	}

	public static boolean PPP15(Cube cube){
		return nPiecesSolved(cube, 15);
	}

	public static boolean PPP16(Cube cube){
		return nPiecesSolved(cube, 16);
	}

	public static boolean PPP17(Cube cube){
		return nPiecesSolved(cube, 17);
	}

	public static boolean PPP18(Cube cube){
		return nPiecesSolved(cube, 18);
	}

	/* This function determines if all the edge pieces are solved.                         ~~~~~ */
	public static boolean allEdges(Cube cube){
		return
			piece9(cube) &&
			piece10(cube) &&
			piece11(cube) &&
			piece12(cube) &&
			piece13(cube) &&
			piece14(cube) &&
			piece15(cube) &&
			piece16(cube) &&
			piece17(cube) &&
			piece18(cube) &&
			piece19(cube) &&
			piece20(cube);

	}
	/* This funciton determines if all of the corners are in their proper location.        ~~~~~ */
	public static boolean allCornerPositions(Cube cube){
		return ThirdLayerCornerPositions(cube) && FirstLayerCornerPositions(cube);
	}


	/* This function determines if one F2L pair is solved                                  ~~~~~ */
	public static boolean F2L1(Cube cube){
		return 
			(piece1(cube) && piece13(cube)) ||
			(piece2(cube) && piece14(cube)) ||
			(piece3(cube) && piece15(cube)) ||
			(piece4(cube) && piece16(cube));
	}

	/* This function determines if two F2L pairs are solved                                ~~~~~ */
	public static boolean F2L2(Cube cube){
		int count = 0;
		if(piece1(cube) && piece13(cube)) count++;
		if(piece2(cube) && piece14(cube)) count++;
		if(piece3(cube) && piece15(cube)) count++;
		if(piece4(cube) && piece16(cube)) count++;
		return count >= 2;
	}

	/* This function determines if three F2L pairs are solved                              ~~~~~ */
	public static boolean F2L3(Cube cube){
		int count = 0;
		if(piece1(cube) && piece13(cube)) count++;
		if(piece2(cube) && piece14(cube)) count++;
		if(piece3(cube) && piece15(cube)) count++;
		if(piece4(cube) && piece16(cube)) count++;
		return count >= 3;
	}

	/* This function determines if four F2L pairs are solved                               ~~~~~ */
	public static boolean F2L4(Cube cube){
		int count = 0;
		if(piece1(cube) && piece13(cube)) count++;
		if(piece2(cube) && piece14(cube)) count++;
		if(piece3(cube) && piece15(cube)) count++;
		if(piece4(cube) && piece16(cube)) count++;
		return count >= 4;
	}

	/* This function determines if the there are two adjacent edges in the third layer that~~~~~ *
	 * have the yellow faclet correct.                                                     ~~~~~ */
	public static boolean thirdLayerPartialInconsistentCross(Cube cube){
		return 
			(cube.getFaceletColor(46) == 'D' && cube.getFaceletColor(50) == 'D') ||
			(cube.getFaceletColor(50) == 'D' && cube.getFaceletColor(52) == 'D') ||
			(cube.getFaceletColor(52) == 'D' && cube.getFaceletColor(48) == 'D') ||
			(cube.getFaceletColor(48) == 'D' && cube.getFaceletColor(46) == 'D');
	}

	/* This function determines if two adjacent edges are solved in the third layer.       ~~~~~ */
	public static boolean thirdLayerPartialConsistentCross(Cube cube){
		return
			(piece17(cube) && piece18(cube)) ||
			(piece18(cube) && piece19(cube)) ||
			(piece19(cube) && piece20(cube)) ||
			(piece20(cube) && piece17(cube));
	}

	/* This function determines if one corner has been solved in the third layer           ~~~~~ */
	public static boolean thirdLayer1Corner(Cube cube){
		return piece5(cube) || piece6(cube) || piece7(cube) || piece8(cube);
	}

	/* This function determines if two corners have been solved in the third layer.        ~~~~~ */
	public static boolean thirdLayer2Corner(Cube cube){
		int count = 0;
		if(piece5(cube)) count++;
		if(piece6(cube)) count++;
		if(piece7(cube)) count++;
		if(piece8(cube)) count++;
		return count >= 2;
	}
}