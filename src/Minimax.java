import java.util.ArrayList;


 public class Minimax
 {
	 private static String AI_AGENT = "X";
	 private static String HUMAN_PLAYER = "O";
	 
	 /*
	  * We assume that MAX moves first
	  * 
	  * This method returns the move that results in the best utility.
	  * 
	  * @param GameState
	  * 			The current state/node from which the move is being made.
	  * 
	  */
	 public static GameState miniMax(GameState currentState)
	 {
		 //	Keep track of the number of states generated/explored
		 GameAI.setTotalCount(GameAI.getTotalCount() + 1);
		 
		 GameState bestMove = null;
		 
		 // Generate all possible successor states
		 ArrayList<GameState> successorStates = GameState.generateSuccessors(currentState, AI_AGENT);
		 
		 int bestValue = Integer.MIN_VALUE;
		 
		 // For each possible move
		 for (GameState successor : successorStates) {
			 // Calculate the minimum utility the opponent can force
			 int value = minValue(successor);
			 
			 // If this move is better than any we've seen, remember it
			 if (value > bestValue) {
				 bestValue = value;
				 bestMove = successor;
			 }
		 }
		 
		 if (bestMove != null)
		 {
			 Log.debug("Selected move: ");
			 GameAI.showBoardState(bestMove.getBoardState());
		 }
		 
		 return bestMove;
	 }
	 
	 /*
	  * Returns the maximum utility that can be achieved from this state
	  * Assumes it's MAX's turn (AI_AGENT)
	  */
	 private static int maxValue(GameState state) {
		 // Keep track of states explored
		 GameAI.setTotalCount(GameAI.getTotalCount() + 1);
		 
		 // Check if this is a terminal state
		 if (GameState.isWinState(state.getBoardState()) || GameState.boardFullCheck(state.getBoardState())) {
			 return calculateUtility(state);
		 }
		 
		 // If not terminal, find the maximum value among all successor states
		 int value = Integer.MIN_VALUE;
		 ArrayList<GameState> successors = GameState.generateSuccessors(state, AI_AGENT);
		 
		 for (GameState successor : successors) {
			 value = Math.max(value, minValue(successor));
		 }
		 
		 return value;
	 }
	 
	 /*
	  * Returns the minimum utility that can be achieved from this state
	  * Assumes it's MIN's turn (HUMAN_PLAYER)
	  */
	 private static int minValue(GameState state) {
		 // Keep track of states explored
		 GameAI.setTotalCount(GameAI.getTotalCount() + 1);
		 
		 // Check if this is a terminal state
		 if (GameState.isWinState(state.getBoardState()) || GameState.boardFullCheck(state.getBoardState())) {
			 return calculateUtility(state);
		 }
		 
		 // If not terminal, find the minimum value among all successor states
		 int value = Integer.MAX_VALUE;
		 ArrayList<GameState> successors = GameState.generateSuccessors(state, HUMAN_PLAYER);
		 
		 for (GameState successor : successors) {
			 value = Math.min(value, maxValue(successor));
		 }
		 
		 return value;
	 }
	 
	 /*
	  * Checks the given gameState and returns the utility.
	  * Utility is calculated as follows:
	  * 		- If MAX wins, the utility is +1
	  * 		- If MIN wins, the utility is -1
	  * 		- If game is tied, the utility is 0
	  * 
	  * Makes the assumption that we are at a terminal (or leaf) node.
	  * This method should only be called on a node in which the game has ended.
	  * 
	  * @param GameState
	  * 			The terminal state/node that is being evaluated.
	  */
	 public static int calculateUtility(GameState gameState)
	 {
		 //	First, check for a winner
		 if (GameState.isWinState(gameState.getBoardState()))
		 {
			 if (GameState.checkWinner(gameState.getBoardState(), AI_AGENT))
			 {
 //				//	Debug code. Enable/disable as needed
 //				Log.debug("Leaf node - MAX wins:");
 //				GameAI.showBoardState(gameState.getBoardState());
				 
				 //	MAX wins
				 return 1;
			 }
			 else
			 {
 //				//	Debug code. Enable/disable as needed
 //				Log.debug("Leaf node - MIN wins:");
 //				GameAI.showBoardState(gameState.getBoardState());
				 
				 // MIN wins
				 return -1;
			 }
		 }
		 else
		 {
			 //	Assuming that the board is full, this is a tie.
			 return 0;
		 }
	 }
 }