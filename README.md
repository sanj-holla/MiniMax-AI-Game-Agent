# MiniMax AI Game Agent
A Java implementation of Tic-Tac-Toe featuring an AI opponent that uses the Minimax algorithm for optimal play. This program creates a playable Tic-Tac-Toe game with a graphical user interface where a human player competes against an AI agent. The AI uses the Minimax algorithm to make optimal moves, meaning it will never lose when playing correctly. The human player uses 'O' and goes first, while the AI responds with 'X'.
The Minimax algorithm works by exploring all possible future game states and selecting the move that leads to the best outcome for the AI. It assumes both players play optimally and uses utility values of +1 for AI wins, -1 for AI losses, and 0 for ties.

To run this project, you need Java JDK 8 or higher installed on your system. Clone or download the repository and compile all Java files in the project directory.
The game will open in a new window with a 3x3 grid. Click on any empty square to make your move, and the AI will automatically respond. The game will announce the winner and offer the option to play again.

# Algorithm Details
The Minimax algorithm implemented here performs a complete search of the game tree from any given state. The AI acts as the maximizing player, trying to achieve the highest utility value, while assuming the human player acts as the minimizing player. The algorithm recursively evaluates all possible moves and their consequences until reaching terminal states where the game ends.
Terminal states are evaluated using a utility function that returns +1 if the AI wins, -1 if the human wins, and 0 for a tie. The algorithm then propagates these values back up the game tree, with maximizing nodes choosing the highest value and minimizing nodes choosing the lowest value.

# Performance
Total States: The algorithm explores all possible game states from the current position 

Complexity: O(b^d) where b is branching factor and d is maximum depth 

Guaranteed Result: AI will never lose when playing optimally
