/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
 * ~~~~~ Jeffrey Martin                                                                    ~~~~~ *
 * ~~~~~ CS4341 Introduction to Artifical Intelligence                                     ~~~~~ *
 * ~~~~~ Professor Neil Heffernan                                                          ~~~~~ *
 * ~~~~~ October 24th, 2016                                                                ~~~~~ *
 * ~~~~~                                                                                   ~~~~~ *
 * ~~~~~ BSMS Project : Goal Oriented Rubiks Cube Solver with IDA*                         ~~~~~ *
 * ~~~~~ File: Goal_Oriented_IDAStar_Solver.java                                           ~~~~~ *
 * ~~~~~ File Description                                                                  ~~~~~ *
 * ~~~~~~~ This class attempts to solve the a 3x3 rubiks cube using goal oriented IDA*     ~~~~~ *
 * ~~~~~~~ Search. The Major goal(solved) can be broken down into a number of sub goals,   ~~~~~ *
 * ~~~~~~~ this class implements a number of these decompositions. IDA* is performed on    ~~~~~ *
 * ~~~~~~~ cube to navigate from the starting scramble to the various goals until the      ~~~~~ *
 * ~~~~~~~ cube is ultimatly solved.                                                       ~~~~~ *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;


public class IDAStarResolver {


	private static final int MAX_STATE_COUNT = 1000000000;

	public static final Goal[] HUMAN_LIKE_DECOMPOSITION = {
		Goal.CROSS_W,                       
		Goal.FIRST_LAYER_1_W,
		Goal.FIRST_LAYER_2_W,
		Goal.FIRST_LAYER_3_W,
		Goal.FIRST_LAYER_4_W,
		Goal.SECOND_LAYER_1_W,
		Goal.SECOND_LAYER_2_W,
		Goal.SECOND_LAYER_3_W,
		Goal.SECOND_LAYER_4_W,
		Goal.THIRD_LAYER_INCONSISTENT_CROSS_W,
		Goal.THIRD_LAYER_CROSS_W,
		Goal.THIRD_LAYER_CORNER_POSITION_1_W,
		Goal.THIRD_LAYER_CORNER_POSITIONS,
		Goal.SOLVED
	};

	public static final Goal[] IMPROVED_FRIEDRICH_DECOMPOSITION = {
		Goal.CROSS_W,
		Goal.F2L1,
		Goal.F2L2,
		Goal.F2L3,
		Goal.F2L4,
		Goal.THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS,
		Goal.THIRD_LAYER_INCONSISTENT_CROSS_W,
		Goal.THIRD_LAYER_PARTIAL_CONSISTENT_CROSS,
		Goal.THIRD_LAYER_CROSS_W,
		Goal.THIRD_LAYER_CORNER_POSITION_1_W,
		Goal.THIRD_LAYER_CORNER_POSITIONS,
		Goal.THIRD_LAYER_1_CORNER,
		Goal.SOLVED
	};

	private static int state_count = 0;

	public static void  solveWithDecomposition(Cube cube, Goal[] goals){
		cube.printCube();
		ArrayList<String> turns_list = new ArrayList<String>(); //list to remember turns
		int last_move = -1; //store the previously made move so the branching factor becomes 15.
		double bound = 0; //current path cost bound for IDA*
		long totalTime = System.nanoTime();
		for(int i = 0; i < goals.length; i++){ //for every subgoal
			long startTime = System.nanoTime();

			Stack<String> turn_stack = new Stack<String>(); //stack for IDA* search moves
			bound = heuristic(cube); //set initial bound to heuristic value

			int thisShouldBeDelete = 0;
			while(true){ //search for solution to this subgoal
				thisShouldBeDelete++;
				//start search, initial cost is zero, previous move is undefined,
				double t = IDAStarSearch(cube, turn_stack, 0, bound, goals, i, last_move);
				if(t == -1) //solution is found
					break;
				bound = t; //else increase bound and search again.
				if(t == -2) //error occured (to many state checks);
					break;
			}
			if(bound == -2) break; //exit because of state overflow


			//create arraylist to transfer moves from the stack.
			ArrayList<String> this_goals_turns = new ArrayList<String>();

			while(!turn_stack.isEmpty()){ //copy each move used to solve this subgoal
				this_goals_turns.add(0, turn_stack.pop()); //add to front to invert stack order
			}
			this_goals_turns.forEach(t -> System.out.printf(t + " "));
			turns_list.addAll(this_goals_turns); //add all moves from this goal to the master list
//			System.out.println();

			//Display report
			long timeInterval = System.nanoTime() - startTime;
			System.out.println(goals[i] + " Working time = " + TimeUnit.NANOSECONDS.toMillis(timeInterval) + " milliseconds");
		}
		if(bound == -2){ //if state search overflow
			System.out.println("The Search explored " + MAX_STATE_COUNT + " states and did not");
			System.out.println("find a solution. Decomposition aborted");
			return;	
		}
		//Some goals use algorithms as a single move duiring IDA*. Convert these back to
		//orignal 18 moves. 
		replaceAlgorithms(turns_list);

		//Display Solution
		System.out.println("SOLUTION: ("+ turns_list.size() + " moves)\n");

		long timeInterval = System.nanoTime() - totalTime;
		System.out.println("TOTAL TIME = " + TimeUnit.NANOSECONDS.toSeconds(timeInterval) + " seconds");
		turns_list.forEach(t -> System.out.printf(t + " "));

	}

	public static double IDAStarSearch(Cube cube, Stack<String> turns,
		int cost, double bound, Goal[] goals, int goal_index, int last_move){
		
		//Determine if the current goal, and all past goals are satisfied by this cube. 
		if(satisfiesGoal(cube, goals, goal_index)) return -1;

		//get the cost.
		double f = cost + heuristic(cube); //Get the estimated cost of this cube
		//abort if the path appears unlikely
		if(f > bound) return f;            //If the estimated cost is too large return. depth limit;

		//Special Goals have access to algorithms in the IDA* search. See performMove2 & undoMove2
		boolean special_goal = 
			goals[goal_index] == Goal.SOLVED || 
			goals[goal_index] == Goal.THIRD_LAYER_1_CORNER;

		double min = -1; //want to maintain the smallest increase that could be made to 'bound' 

		//Try every possible move. (if special goal, need extra 'moves')
		for (int i = 0; i < (special_goal ? 26 : 18); i++){
			//if this move turns the same face as the last move, dont perform it. 
			//Branching factor 18 -> 15
			if(i/3 == last_move/3) continue;
			//increment the number of states checked.
			state_count++;
			if(state_count >= MAX_STATE_COUNT) return -2; //todo - нахуй не нужно

			if(special_goal) //perform Special move
				turns.push(performMove2(cube, i)); // todo - захардкоженые последовательности
			else //perform regular move
				turns.push(performMove(cube, i)); // todo - пул движений
			//perform search recursively on the new cube. 
			double t = IDAStarSearch(cube, turns, cost + 1, bound, goals, goal_index, i);

			if(t == -1) return -1; //if solution found
			if(t < min || min == -1) min = t; //update min if applicable

			turns.pop(); //remove this turn from the stack of turns 

			if(special_goal) //undo special move
				undoMove2(cube, i);
			else //undo regular move
				undoMove(cube, i); 
		}
		return min; //return the minimum bound increase from this branch of IDA*
	}

	/* This function performs one of the 18 moves based on the value of i. This action is  ~~~~~ *
	 * un-done by the function undoMove(). It returns the string representing the turn     ~~~~~ *
	 * that was made.                                                                      ~~~~~ */
	private static String performMove(Cube cube, int i){
		switch(i){
			case 0:
				cube.front();
				return "F";
			case 1:
				cube.frontDouble();
				return "F2";
			case 2:
				cube.frontReverse();
				return "F'";
			case 3:
				cube.back();
				return "B";
			case 4:
				cube.backDouble();
				return "B2";
			case 5:
				cube.backReverse();
				return "B'";
			case 6:
				cube.left();
				return "L";
			case 7:
				cube.leftDouble();
				return "L2";
			case 8:
				cube.leftReverse();
				return "L'";
			case 9:
				cube.right();
				return "R";
			case 10:
				cube.rightDouble();
				return "R2";
			case 11:
				cube.rightReverse();
				return "R'";
			case 12:
				cube.up();
				return "U";
			case 13:
				cube.upDouble();
				return "U2";
			case 14:
				cube.upReverse();
				return "U'";
			case 15:
				cube.down();
				return "D";
			case 16:
				cube.downDouble();
				return "D2";
			case 17:
				cube.downReverse();
				return "D'";

				
		}
		return "";
	}

	/* This function performs one of the 18 moves based on the value of i. This action     ~~~~~ *
	 * un-does any work made by PerformMove                                                ~~~~~ */
	private static void undoMove(Cube cube, int i){
		switch(i){
			case 0:
				cube.frontReverse();
				break;
			case 1:
				cube.frontDouble();
				break;
			case 2:
				cube.front();
				break;
			case 3:
				cube.backReverse();
				break;
			case 4:
				cube.backDouble();
				break;
			case 5:
				cube.back();
				break;
			case 6:
				cube.leftReverse();
				break;
			case 7:
				cube.leftDouble();
				break;
			case 8:
				cube.left();
				break;
			case 9:
				cube.rightReverse();
				break;
			case 10:
				cube.rightDouble();
				break;
			case 11:
				cube.right();
				break;
			case 12:
				cube.upReverse();
				break;
			case 13:
				cube.upDouble();
				break;
			case 14:
				cube.up();
				break;
			case 15:
				cube.downReverse();
				break;
			case 16:
				cube.downDouble();
				break;
			case 17:
				cube.down();
				break;
				
		}
	}

	/* This function performs one of the 18 moves based on the value of i. It also         ~~~~~ *
	 * supports a useful algoirthm for the end of the cube. This action is                 ~~~~~ *
	 * un-done by the function undoMove2(). It returns the string representing the turn    ~~~~~ *
	 * that was made or the algorithm that was used.                                       ~~~~~ */
	private static String performMove2(Cube cube, int i){
		switch(i){
			case 0:
				cube.front();
				return "F";
			case 1:
				cube.frontDouble();
				return "F2";
			case 2:
				cube.frontReverse();
				return "F'";
			case 3:
				cube.back();
				return "B";
			case 4:
				cube.backDouble();
				return "B2";
			case 5:
				cube.backReverse();
				return "B'";
			case 6:
				cube.left();
				return "L";
			case 7:
				cube.leftDouble();
				return "L2";
			case 8:
				cube.leftReverse();
				return "L'";
			case 9:
				cube.right();
				return "R";
			case 10:
				cube.rightDouble();
				return "R2";
			case 11:
				cube.rightReverse();
				return "R'";
			case 12:
				cube.up();
				return "U";
			case 13:
				cube.upDouble();
				return "U2";
			case 14:
				cube.upReverse();
				return "U'";
			case 15:
				cube.down();
				return "D";
			case 16:
				cube.downDouble();
				return "D2";
			case 17:
				cube.downReverse();
				return "D'";
			/* Add algorithms */
			case 18: 
				cube.rightReverse();
				cube.downReverse();
				cube.right();
				cube.down();
				cube.rightReverse();
				cube.downReverse();
				cube.right();
				cube.down();
				return "A1";
			case 19:
				cube.backReverse();
				cube.downReverse();
				cube.back();
				cube.down();
				cube.backReverse();
				cube.downReverse();
				cube.back();
				cube.down();
				return "A2";
			case 20:
				cube.leftReverse();
				cube.downReverse();
				cube.left();
				cube.down();
				cube.leftReverse();
				cube.downReverse();
				cube.left();
				cube.down();
				return "A3";
			case 21:
				cube.frontReverse();
				cube.downReverse();
				cube.front();
				cube.down();
				cube.frontReverse();
				cube.downReverse();
				cube.front();
				cube.down();
				return "A4";
			case 22: 
				cube.rightReverse();
				cube.upReverse();
				cube.right();
				cube.up();
				cube.rightReverse();
				cube.upReverse();
				cube.right();
				cube.up();
				return "A5";
			case 23:
				cube.backReverse();
				cube.upReverse();
				cube.back();
				cube.up();
				cube.backReverse();
				cube.upReverse();
				cube.back();
				cube.up();
				return "A6";
			case 24:
				cube.leftReverse();
				cube.upReverse();
				cube.left();
				cube.up();
				cube.leftReverse();
				cube.upReverse();
				cube.left();
				cube.up();
				return "A7";
			case 25:
				cube.frontReverse();
				cube.upReverse();
				cube.front();
				cube.up();
				cube.frontReverse();
				cube.upReverse();
				cube.front();
				cube.up();
				return "A8";				
		}
		return "";
	}


	/* This function performs one of the 18 moves based on the value of i. It also         ~~~~~ *
	 * supports a useful algoirthm for the end cube. This action                           ~~~~~ *
	 * un-does any work made by PerformMove2                                               ~~~~~ */
	private static void undoMove2(Cube cube, int i){
		switch(i){
			case 0:
				cube.frontReverse();
				break;
			case 1:
				cube.frontDouble();
				break;
			case 2:
				cube.front();
				break;
			case 3:
				cube.backReverse();
				break;
			case 4:
				cube.backDouble();
				break;
			case 5:
				cube.back();
				break;
			case 6:
				cube.leftReverse();
				break;
			case 7:
				cube.leftDouble();
				break;
			case 8:
				cube.left();
				break;
			case 9:
				cube.rightReverse();
				break;
			case 10:
				cube.rightDouble();
				break;
			case 11:
				cube.right();
				break;
			case 12:
				cube.upReverse();
				break;
			case 13:
				cube.upDouble();
				break;
			case 14:
				cube.up();
				break;
			case 15:
				cube.downReverse();
				break;
			case 16:
				cube.downDouble();
				break;
			case 17:
				cube.down();
				break;

			/* Add algorithms */
			case 18: 
				cube.downReverse();
				cube.rightReverse();
				cube.down();
				cube.right();
				cube.downReverse();
				cube.rightReverse();
				cube.down();
				cube.right();
				break;
			case 19:
				cube.downReverse();
				cube.backReverse();
				cube.down();
				cube.back();
				cube.downReverse();
				cube.backReverse();
				cube.down();
				cube.back();
				break;
			case 20:
				cube.downReverse();
				cube.leftReverse();
				cube.down();
				cube.left();
				cube.downReverse();
				cube.leftReverse();
				cube.down();
				cube.left();
				break;
			case 21:
				cube.downReverse();
				cube.frontReverse();
				cube.down();
				cube.front();
				cube.downReverse();
				cube.frontReverse();
				cube.down();
				cube.front();
				break;
			case 22: 
				cube.upReverse();
				cube.rightReverse();
				cube.up();
				cube.right();
				cube.upReverse();
				cube.rightReverse();
				cube.up();
				cube.right();
				break;
			case 23:
				cube.upReverse();
				cube.backReverse();
				cube.up();
				cube.back();
				cube.upReverse();
				cube.backReverse();
				cube.up();
				cube.back();
				break;
			case 24:
				cube.upReverse();
				cube.leftReverse();
				cube.up();
				cube.left();
				cube.upReverse();
				cube.leftReverse();
				cube.up();
				cube.left();
				break;
			case 25:
				cube.upReverse();
				cube.frontReverse();
				cube.up();
				cube.front();
				cube.upReverse();
				cube.frontReverse();
				cube.up();
				cube.front();
				break;
				
		}
	}











	/* This function determines if the cube satisfies the given goal.                      ~~~~~ *
	 * It is simply a very large switch statement that directs the function call to the    ~~~~~ *
	 * proper function in Rubiks_Cube_Goals_V2.java. It tests that all goals Prior to this ~~~~~ *
	 * this goal in the goal set are also satisfied. (do not want to lose progress)        ~~~~~ */
	public static boolean satisfiesGoal(Cube cube, Goal[] goals, int goal_index){
		for(int i = 0; i <= goal_index; i++){ //For all goals up to and including this goal
			Goal goal = goals[i];
			switch(goal){
				case PIECE1:
					if(!Rubiks_Cube_Goals_V2.piece1(cube)) return false;
					break;
				case PIECE2:
					if(!Rubiks_Cube_Goals_V2.piece2(cube)) return false;
					break;
				case PIECE3:
					if(!Rubiks_Cube_Goals_V2.piece3(cube)) return false;
					break;
				case PIECE4:
					if(!Rubiks_Cube_Goals_V2.piece4(cube)) return false;
					break;
				case PIECE5:
					if(!Rubiks_Cube_Goals_V2.piece5(cube)) return false;
					break;
				case PIECE6:
					if(!Rubiks_Cube_Goals_V2.piece6(cube)) return false;
					break;
				case PIECE7:
					if(!Rubiks_Cube_Goals_V2.piece7(cube)) return false;
					break;
				case PIECE8:
					if(!Rubiks_Cube_Goals_V2.piece8(cube)) return false;
					break;
				case PIECE9:
					if(!Rubiks_Cube_Goals_V2.piece9(cube)) return false;
					break;
				case PIECE10:
					if(!Rubiks_Cube_Goals_V2.piece10(cube)) return false;
					break;
				case PIECE11:
					if(!Rubiks_Cube_Goals_V2.piece11(cube)) return false;
					break;
				case PIECE12:
					if(!Rubiks_Cube_Goals_V2.piece12(cube)) return false;
					break;
				case PIECE13:
					if(!Rubiks_Cube_Goals_V2.piece13(cube)) return false;
					break;
				case PIECE14:
					if(!Rubiks_Cube_Goals_V2.piece14(cube)) return false;
					break;
				case PIECE15:
					if(!Rubiks_Cube_Goals_V2.piece15(cube)) return false;
					break;
				case PIECE16:
					if(!Rubiks_Cube_Goals_V2.piece16(cube)) return false;
					break;
				case PIECE17:
					if(!Rubiks_Cube_Goals_V2.piece17(cube)) return false;
					break;
				case PIECE18:
					if(!Rubiks_Cube_Goals_V2.piece18(cube)) return false;
					break;
				case PIECE19:
					if(!Rubiks_Cube_Goals_V2.piece19(cube)) return false;
					break;
				case PIECE20:
					if(!Rubiks_Cube_Goals_V2.piece20(cube)) return false;
					break;


				case CROSS_W:
					if(!Rubiks_Cube_Goals_V2.crossW(cube)) return false;
					break;
				case FIRST_LAYER_1_W:
					if(!Rubiks_Cube_Goals_V2.firstLayerW1(cube)) return false;
					break;
				case FIRST_LAYER_2_W:
					if(!Rubiks_Cube_Goals_V2.firstLayerW2(cube)) return false;
					break;
				case FIRST_LAYER_3_W:
					if(!Rubiks_Cube_Goals_V2.firstLayerW3(cube)) return false;
					break;
				case FIRST_LAYER_4_W:
					if(!Rubiks_Cube_Goals_V2.firstLayerW4(cube)) return false;
					break;
				case SECOND_LAYER_1_W:
					if(!Rubiks_Cube_Goals_V2.secondLayerW1(cube)) return false;
					break;
				case SECOND_LAYER_2_W:
					if(!Rubiks_Cube_Goals_V2.secondLayerW2(cube)) return false;
					break;
				case SECOND_LAYER_3_W:
					if(!Rubiks_Cube_Goals_V2.secondLayerW3(cube)) return false;
					break;
				case SECOND_LAYER_4_W:
					if(!Rubiks_Cube_Goals_V2.secondLayerW4(cube)) return false;
					break;
				case THIRD_LAYER_INCONSISTENT_CROSS_W:
					if(!Rubiks_Cube_Goals_V2.inconsistentThirdLayerCrossW(cube)) return false;
					break;
				case THIRD_LAYER_CROSS_W:
					if(!Rubiks_Cube_Goals_V2.ThirdLayerCrossW(cube)) return false;
					break;
				case THIRD_LAYER_CORNER_POSITION_1_W:
					if(!Rubiks_Cube_Goals_V2.ThirdLayerCornerPositionW1(cube)) return false;
					break;
				case THIRD_LAYER_CORNER_POSITIONS:
					if(!Rubiks_Cube_Goals_V2.ThirdLayerCornerPositions(cube)) return false;
					break;
				


				case PPP1:
					if(!Rubiks_Cube_Goals_V2.PPP1(cube)) return false;
					break;
				case PPP2:
					if(!Rubiks_Cube_Goals_V2.PPP2(cube)) return false;
					break;
				case PPP3:
					if(!Rubiks_Cube_Goals_V2.PPP3(cube)) return false;
					break;
				case PPP4:
					if(!Rubiks_Cube_Goals_V2.PPP4(cube)) return false;
					break;
				case PPP5:
					if(!Rubiks_Cube_Goals_V2.PPP5(cube)) return false;
					break;
				case PPP6:
					if(!Rubiks_Cube_Goals_V2.PPP6(cube)) return false;
					break;
				case PPP7:
					if(!Rubiks_Cube_Goals_V2.PPP7(cube)) return false;
					break;
				case PPP8:
					if(!Rubiks_Cube_Goals_V2.PPP8(cube)) return false;
					break;
				case PPP9:
					if(!Rubiks_Cube_Goals_V2.PPP9(cube)) return false;
					break;
				case PPP10:
					if(!Rubiks_Cube_Goals_V2.PPP10(cube)) return false;
					break;
				case PPP11:
					if(!Rubiks_Cube_Goals_V2.PPP11(cube)) return false;
					break;
				case PPP12:
					if(!Rubiks_Cube_Goals_V2.PPP12(cube)) return false;
					break;
				case PPP13:
					if(!Rubiks_Cube_Goals_V2.PPP13(cube)) return false;
					break;
				case PPP14:
					if(!Rubiks_Cube_Goals_V2.PPP14(cube)) return false;
					break;
				case PPP15:
					if(!Rubiks_Cube_Goals_V2.PPP15(cube)) return false;
					break;
				case PPP16:
					if(!Rubiks_Cube_Goals_V2.PPP16(cube)) return false;
					break;
				case PPP17:
					if(!Rubiks_Cube_Goals_V2.PPP17(cube)) return false;
					break;
				case PPP18:
					if(!Rubiks_Cube_Goals_V2.PPP18(cube)) return false;
					break;
				case ALL_EDGES:
					if(!Rubiks_Cube_Goals_V2.allEdges(cube)) return false;
					break;
				case ALL_CORNER_POSITIONS:
					if(!Rubiks_Cube_Goals_V2.allCornerPositions(cube)) return false;
					break;


				case F2L1:
					if(!Rubiks_Cube_Goals_V2.F2L1(cube)) return false;
					break;
				case F2L2:
					if(!Rubiks_Cube_Goals_V2.F2L2(cube)) return false;
					break;
				case F2L3:
					if(!Rubiks_Cube_Goals_V2.F2L3(cube)) return false;
					break;
				case F2L4:
					if(!Rubiks_Cube_Goals_V2.F2L4(cube)) return false;
					break;
				case THIRD_LAYER_PARTIAL_CONSISTENT_CROSS:
					if(!Rubiks_Cube_Goals_V2.thirdLayerPartialConsistentCross(cube)) return false;
					break;
				case THIRD_LAYER_PARTIAL_INCONSISTENT_CROSS:
					if(!Rubiks_Cube_Goals_V2.thirdLayerPartialInconsistentCross(cube)) return false;
					break;
				case THIRD_LAYER_1_CORNER:
					if(!Rubiks_Cube_Goals_V2.thirdLayer1Corner(cube)) return false;
					break;
				case THIRD_LAYER_2_CORNER:
					if(!Rubiks_Cube_Goals_V2.thirdLayer2Corner(cube)) return false;

				case SOLVED:
					if(!Rubiks_Cube_Goals_V2.solved(cube)) return false;
					break;
			}
		}
		return true;
	}

	/* This function estaimates the cost of getting the current cube to the solved state.  ~~~~~ *
	 * It determines the number of pieces that are unsolved. If an admissable heuristic is ~~~~~ *
	 * desired, this value is divided by 8 (because a move can (although unlikely) solve 8 ~~~~~ *
	 * pieces at once.). however, this is often not the reality... thus adding             ~~~~~ *
	 * admissability to this heurisitc takes away alot of the A* algorithms power.         ~~~~~ */
	private static double heuristic(Cube cube){
		double val = 20;
		if(Rubiks_Cube_Goals_V2.piece1(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece2(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece3(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece4(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece5(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece6(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece7(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece8(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece9(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece10(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece11(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece12(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece13(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece14(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece15(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece16(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece17(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece18(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece19(cube)) val--;
		if(Rubiks_Cube_Goals_V2.piece20(cube)) val--;

		//uncomment to make admissable
		return val;
	}


	/* This function replaces an Algorithm in the ArrayList of strings with all of the     ~~~~~ *
	 * turns.                                                                              ~~~~~ */
	private static void replaceAlgorithms(ArrayList<String> turns){
		String[] A1 = {"R'","D'","R","D","R'","D'","R","D"};
		String[] A2 = {"B'","D'","B","D","B'","D'","B","D"};
		String[] A3 = {"L'","D'","L","D","L'","D'","L","D"};
		String[] A4 = {"F'","D'","F","D","F'","D'","F","D"};
		String[] A5 = {"R'","U'","R","U","R'","U'","R","U"};
		String[] A6 = {"B'","U'","B","U","B'","U'","B","U"};
		String[] A7 = {"L'","U'","L","U","L'","U'","L","U"};
		String[] A8 = {"F'","U'","F","U","F'","U'","F","U"};



		while(turns.contains("A1")){
			int index = turns.indexOf("A1");
			turns.remove(index);
			for (int i = 0; i < A1.length; i++){
				turns.add(i+index, A1[i]);
			}
		}

		while(turns.contains("A2")){
			int index = turns.indexOf("A2");
			turns.remove(index);
			for (int i = 0; i < A2.length; i++){
				turns.add(i+index, A2[i]);
			}
		}

		while(turns.contains("A3")){
			int index = turns.indexOf("A3");
			turns.remove(index);
			for (int i = 0; i < A3.length; i++){
				turns.add(i+index, A3[i]);
			}
		}

		while(turns.contains("A4")){
			int index = turns.indexOf("A4");
			turns.remove(index);
			for (int i = 0; i < A4.length; i++){
				turns.add(i+index, A4[i]);
			}
		}

		while(turns.contains("A5")){
			int index = turns.indexOf("A5");
			turns.remove(index);
			for (int i = 0; i < A5.length; i++){
				turns.add(i+index, A5[i]);
			}
		}

		while(turns.contains("A6")){
			int index = turns.indexOf("A6");
			turns.remove(index);
			for (int i = 0; i < A6.length; i++){
				turns.add(i+index, A6[i]);
			}
		}

		while(turns.contains("A7")){
			int index = turns.indexOf("A7");
			turns.remove(index);
			for (int i = 0; i < A7.length; i++){
				turns.add(i+index, A7[i]);
			}
		}

		while(turns.contains("A8")){
			int index = turns.indexOf("A8");
			turns.remove(index);
			for (int i = 0; i < A8.length; i++){
				turns.add(i+index, A8[i]);
			}
		}
	}



}