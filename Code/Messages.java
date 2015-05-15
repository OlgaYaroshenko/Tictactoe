
public class Messages {

	/**
	* Class constructor with no params
	*/
	private Messages(){}

	/**
	* Displays welcome message
	* @return string welcome message
	*/
	public static String makeWelcomeMessage () {
		return "Welcome to Tic Tac Toe!";
	}

	/**
	* Creates prompt string
	* @param question string Question to the user
	* @param answerFormat string Explanation of the format of input
	* @return string prompt with 2 params
	*/
	public static String makePrompt (String question, String answerFormat) {
		return question + "\n" + answerFormat;
	}

	/**
	* Displays quit message
	* @return string quit message
	*/
	public static String quitMessage () {
		return "Thanks for playing!";
	}

	/**
	* Displays start message
	* @return string start message
	*/
	public static String startMessage () {
		return "Game started!";
	}

	/**
	* Creates game board representation
	* @param g takes a current gameboard
	* @return string with graphical representation of the current board
	*/
	public static String getBoardRepresentation (GameBoard g) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				sb.append(" " + g.atPosition(j, i).toString());
				if (j == 1 || j == 2) {
					sb.append(" |");
				}
			}
			sb.append("\n");
			if (i == 1|| i == 2) {
				sb.append("-----------\n");
			}

		}
		return sb.toString();
	}
}