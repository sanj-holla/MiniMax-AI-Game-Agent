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

		// Show board after player plays
		System.out.println("Board after player move:");
		showBoardState(boardState);
	}

	public String[] getNextMove()
	{
		GameState state = new GameState(BOARD_SIZE, boardState);

		// Get AI's move using minimax
		GameState nextMove = Minimax.miniMax(state);
		boardState = nextMove.getBoardState();

		// Show board after AI move
		System.out.println("Board after AI move:");
		showBoardState(boardState);

		return boardState;
	}

	public static void showBoardState(String[] state)
	{
		for (int row = 0; row < BOARD_SIZE; row++)
		{
			for (int col = 0; col < BOARD_SIZE; col++)
			{
				System.out.print("[" + state[(row * BOARD_SIZE) + col] + "] ");
			}
			System.out.println();
		}
	}

	static void showTotalCount()
	{
		System.out.println("Total states generated/explored: " + getTotalCount());
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
