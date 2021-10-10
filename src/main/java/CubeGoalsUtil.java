
public class CubeGoalsUtil {
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

	public static boolean piece1(Cube cube){
		return
			cube.getFAce(0)  == 'U' &&
			cube.getFAce(9)  == 'L' &&
			cube.getFAce(38) == 'B';
	}

	public static boolean piece2(Cube cube){
		return
			cube.getFAce(2)  == 'U' &&
			cube.getFAce(29) == 'R' &&
			cube.getFAce(36) == 'B';
	}

	public static boolean piece3(Cube cube){
		return
			cube.getFAce(8)  == 'U' &&
			cube.getFAce(27) == 'R' &&
			cube.getFAce(20) == 'F';
	}

	public static boolean piece4(Cube cube){
		return
			cube.getFAce(6)  == 'U' &&
			cube.getFAce(11) == 'L' &&
			cube.getFAce(18) == 'F';
	}

	public static boolean piece5(Cube cube){
		return
			cube.getFAce(51) == 'D' &&
			cube.getFAce(15) == 'L' &&
			cube.getFAce(44) == 'B';
	}

	public static boolean piece6(Cube cube){
		return
			cube.getFAce(53) == 'D' &&
			cube.getFAce(35) == 'R' &&
			cube.getFAce(42) == 'B';
	}

	public static boolean piece7(Cube cube){
		return
			cube.getFAce(47) == 'D' &&
			cube.getFAce(33) == 'R' &&
			cube.getFAce(26) == 'F';
	}

	public static boolean piece8(Cube cube){
		return
			cube.getFAce(45) == 'D' &&
			cube.getFAce(17) == 'L' &&
			cube.getFAce(24) == 'F';
	}

	public static boolean piece9(Cube cube){
		return
			cube.getFAce(3)  == 'U' &&
			cube.getFAce(10) == 'L';
	}

	public static boolean piece10(Cube cube){
		return
			cube.getFAce(1)  == 'U' &&
			cube.getFAce(37) == 'B';
	}

	public static boolean piece11(Cube cube){
		return
			cube.getFAce(5)  == 'U' &&
			cube.getFAce(28) == 'R';
	}

	public static boolean piece12(Cube cube){
		return
			cube.getFAce(7)  == 'U' &&
			cube.getFAce(19) == 'F';
	}

	public static boolean piece13(Cube cube){
		return
			cube.getFAce(12) == 'L' &&
			cube.getFAce(41) == 'B';
	}

	public static boolean piece14(Cube cube){
		return
			cube.getFAce(39) == 'B' &&
			cube.getFAce(32) == 'R';
	}

	public static boolean piece15(Cube cube){
		return
			cube.getFAce(30) == 'R' &&
			cube.getFAce(23) == 'F';
	}

	public static boolean piece16(Cube cube){
		return
			cube.getFAce(21) == 'F' &&
			cube.getFAce(14) == 'L';
	}

	public static boolean piece17(Cube cube){
		return
			cube.getFAce(48) == 'D' &&
			cube.getFAce(16) == 'L';
	}

	public static boolean piece18(Cube cube){
		return
			cube.getFAce(52) == 'D' &&
			cube.getFAce(43) == 'B';
	}

	public static boolean piece19(Cube cube){
		return
			cube.getFAce(50) == 'D' &&
			cube.getFAce(34) == 'R';
	}

	public static boolean piece20(Cube cube){
		return
			cube.getFAce(46) == 'D' &&
			cube.getFAce(25) == 'F';
	}

	public static boolean crossU(Cube cube){
		return
			piece9(cube) &&
			piece10(cube) &&
			piece11(cube) &&
			piece12(cube);
	}

	public static boolean firstLayerU1(Cube cube){
		return
			piece1(cube) ||
			piece2(cube) ||
			piece3(cube) ||
			piece4(cube);
	}

	public static boolean firstLayerU2(Cube cube){
		int corners = 0;
		if(piece1(cube)) corners++;
		if(piece2(cube)) corners++;
		if(piece3(cube)) corners++;
		if(piece4(cube)) corners++;
		return corners >= 2;
	}

	public static boolean firstLayerU3(Cube cube){
		int corners = 0;
		if(piece1(cube)) corners++;
		if(piece2(cube)) corners++;
		if(piece3(cube)) corners++;
		if(piece4(cube)) corners++;
		return corners >= 3;
	}

	public static boolean firstLayerU4(Cube cube){
		return
		piece1(cube) &&
		piece2(cube) &&
		piece3(cube) &&
		piece4(cube);
	}

	public static boolean secondLayerU1(Cube cube){
		return
			piece13(cube) ||
			piece14(cube) ||
			piece15(cube) ||
			piece16(cube);
	}

	public static boolean secondLayerU2(Cube cube){
		int edges = 0;
		if(piece13(cube)) edges++;
		if(piece14(cube)) edges++;
		if(piece15(cube)) edges++;
		if(piece16(cube)) edges++;
		return edges >= 2;

	}

	public static boolean secondLayerU3(Cube cube){
		int edges = 0;
		if(piece13(cube)) edges++;
		if(piece14(cube)) edges++;
		if(piece15(cube)) edges++;
		if(piece16(cube)) edges++;
		return edges >= 3;
	}

	public static boolean secondLayerU4(Cube cube){
		return
			piece13(cube) &&
			piece14(cube) &&
			piece15(cube) &&
			piece16(cube);
	}

	public static boolean inconsistentThirdLayerCrossU(Cube cube){
		return
			cube.getFAce(46) == 'D' &&
			cube.getFAce(48) == 'D' &&
			cube.getFAce(50) == 'D' &&
			cube.getFAce(52) == 'D';
	}

	public static boolean ThirdLayerCrossU(Cube cube){
		return
			piece17(cube) &&
			piece18(cube) &&
			piece19(cube) &&
			piece20(cube);
	}


	public static boolean ThirdLayerCornerPositionU1(Cube cube){
		char F1 = cube.getFAce(51);
		char F2 = cube.getFAce(15);
		char F3 = cube.getFAce(44);
		if(((F1 == 'D' && F2 == 'L' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'B' && F3 == 'D')))
			return true;
		F1 = cube.getFAce(53);
		F2 = cube.getFAce(35);
		F3 = cube.getFAce(42);
		if(((F1 == 'D' && F2 == 'R' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'B' && F3 == 'D')))
			return true;
		F1 = cube.getFAce(47);
		F2 = cube.getFAce(33);
		F3 = cube.getFAce(26);
		if(((F1 == 'D' && F2 == 'R' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'F' && F3 == 'D')))
			return true;
		F1 = cube.getFAce(45);
		F2 = cube.getFAce(17);
		F3 = cube.getFAce(24);
		if(((F1 == 'D' && F2 == 'L' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'F' && F3 == 'D')))
			return true;
		return false;
	}

	public static boolean ThirdLayerCornerPositions(Cube cube){
		char F1 = cube.getFAce(51);
		char F2 = cube.getFAce(15);
		char F3 = cube.getFAce(44);
		if(!((F1 == 'D' && F2 == 'L' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'B' && F3 == 'D')))
			return false;
		F1 = cube.getFAce(53);
		F2 = cube.getFAce(35);
		F3 = cube.getFAce(42);
		if(!((F1 == 'D' && F2 == 'R' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'B' && F3 == 'D')))
			return false;
		F1 = cube.getFAce(47);
		F2 = cube.getFAce(33);
		F3 = cube.getFAce(26);
		if(!((F1 == 'D' && F2 == 'R' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'F' && F3 == 'D')))
			return false;
		F1 = cube.getFAce(45);
		F2 = cube.getFAce(17);
		F3 = cube.getFAce(24);
		if(!((F1 == 'D' && F2 == 'L' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'D' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'F' && F3 == 'D')))
			return false;
		return true;
	}

	public static boolean FirstLayerCornerPositions(Cube cube){
		char F1 = cube.getFAce(0);
		char F2 = cube.getFAce(9);
		char F3 = cube.getFAce(38);
		if(!((F1 == 'U' && F2 == 'L' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'U' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'B' && F3 == 'U')))
			return false;
		F1 = cube.getFAce(2);
		F2 = cube.getFAce(29);
		F3 = cube.getFAce(36);
		if(!((F1 == 'U' && F2 == 'R' && F3 == 'B') ||
			(F1 == 'B' && F2 == 'U' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'B' && F3 == 'U')))
			return false;
		F1 = cube.getFAce(8);
		F2 = cube.getFAce(27);
		F3 = cube.getFAce(20);
		if(!((F1 == 'U' && F2 == 'R' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'U' && F3 == 'R') ||
			(F1 == 'R' && F2 == 'F' && F3 == 'U')))
			return false;
		F1 = cube.getFAce(6);
		F2 = cube.getFAce(11);
		F3 = cube.getFAce(18);
		if(!((F1 == 'U' && F2 == 'L' && F3 == 'F') ||
			(F1 == 'F' && F2 == 'U' && F3 == 'L') ||
			(F1 == 'L' && F2 == 'F' && F3 == 'U')))
			return false;
		return true;
	}


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

	public static boolean allCornerPositions(Cube cube){
		return ThirdLayerCornerPositions(cube) && FirstLayerCornerPositions(cube);
	}

	public static boolean F2L1(Cube cube){
		return
			(piece1(cube) && piece13(cube)) ||
			(piece2(cube) && piece14(cube)) ||
			(piece3(cube) && piece15(cube)) ||
			(piece4(cube) && piece16(cube));
	}

	public static boolean F2L2(Cube cube){
		int count = 0;
		if(piece1(cube) && piece13(cube)) count++;
		if(piece2(cube) && piece14(cube)) count++;
		if(piece3(cube) && piece15(cube)) count++;
		if(piece4(cube) && piece16(cube)) count++;
		return count >= 2;
	}

	public static boolean F2L3(Cube cube){
		int count = 0;
		if(piece1(cube) && piece13(cube)) count++;
		if(piece2(cube) && piece14(cube)) count++;
		if(piece3(cube) && piece15(cube)) count++;
		if(piece4(cube) && piece16(cube)) count++;
		return count >= 3;
	}

	public static boolean F2L4(Cube cube){
		int count = 0;
		if(piece1(cube) && piece13(cube)) count++;
		if(piece2(cube) && piece14(cube)) count++;
		if(piece3(cube) && piece15(cube)) count++;
		if(piece4(cube) && piece16(cube)) count++;
		return count >= 4;
	}
	public static boolean thirdLayerPartialInconsistentCross(Cube cube){
		return
			(cube.getFAce(46) == 'D' && cube.getFAce(50) == 'D') ||
			(cube.getFAce(50) == 'D' && cube.getFAce(52) == 'D') ||
			(cube.getFAce(52) == 'D' && cube.getFAce(48) == 'D') ||
			(cube.getFAce(48) == 'D' && cube.getFAce(46) == 'D');
	}

	public static boolean thirdLayerPartialConsistentCross(Cube cube){
		return
			(piece17(cube) && piece18(cube)) ||
			(piece18(cube) && piece19(cube)) ||
			(piece19(cube) && piece20(cube)) ||
			(piece20(cube) && piece17(cube));
	}

	public static boolean thirdLayer1Corner(Cube cube){
		return piece5(cube) || piece6(cube) || piece7(cube) || piece8(cube);
	}

	public static boolean thirdLayer2Corner(Cube cube){
		int count = 0;
		if(piece5(cube)) count++;
		if(piece6(cube)) count++;
		if(piece7(cube)) count++;
		if(piece8(cube)) count++;
		return count >= 2;
	}
}