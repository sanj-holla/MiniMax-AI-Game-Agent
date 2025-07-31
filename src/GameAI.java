/*
 * Adversarial Search
 * 
 */

 import java.util.ArrayList;
 import java.util.Random;
 
 public class GameAI
 {
	 private static String AI_AGENT = "X";
	 public static int BOARD_SIZE = 3;
	 static int drawset = 0;
	 private static int totalCount;
 
	 String[] boardState;
 
 
	 GameAI()
	 {
		 boardState = new String[BOARD_SIZE * BOARD_SIZE];
	 }
	 
	 
	 public void updateState(String[] state)
	 {
		 boardState = state;
		 
		 Log.debug("Printing the board state after player plays");
		 showBoardState(boardState);
	 }
	 
	 
	 /*
	  * This method finds the next move and returns and updated board state,
	  * i.e., the state of the game board after the selected move is made.
	  * 
	  */
	 public String[] getNextMove()
	 {
		 GameState state = new GameState(BOARD_SIZE, boardState);		
		 //	Using miniMax
		 GameState nextMove = Minimax.miniMax(state);
		 boardState = nextMove.getBoardState();
		 //	Display the state of the board after the selected move		
		 showBoardState(boardState);
		 
		 return boardState;
	 }
	 
 
	 /*
	  * This method shows the state of the game board.
	  * 
	  * The tiles (squares) are numbered from zero to 8, hence
	  * the layout is as follows:
	  * 
	  * 		[0] [1] [2]
	  * 		[3] [4] [5]
	  *		    [6] [7] [8]
	  */
	 public static void showBoardState(String[] state)
	 {
		 StringBuilder sb = new StringBuilder();
		 
		 sb.append("Board State:");
		 
		 for (int row = 0; row < BOARD_SIZE; row++)
		 {
			 sb.append("\n\t");
			 for (int col = 0; col < BOARD_SIZE; col++)
			 {
				 sb.append(String.format("[%s] ", state[(row*BOARD_SIZE)+col]));
			 }
		 }
		 
		 Log.debug(sb.toString());
	 }
	 
	 
	 static void showTotalCount()
	 {
		 Log.debug("Total states generated/explored " + getTotalCount());
	 }
 
 
	 public static int getTotalCount()
	 {
		 return totalCount;
	 }
 
 
	 public static void setTotalCount(int totalCount)
	 {
		 GameAI.totalCount = totalCount;
	 }
 }