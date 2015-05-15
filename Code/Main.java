
public class Main {

    public static void main (String[] args) {

        
        //Fields
        GameBoard game;
        Cell currentPlayer;
        int turnCount = 0;
        boolean keepPlaying = true;

        //Initialise Reader
        Reader r = Reader.init();
        
        //Print welcome message
    	System.out.println(Messages.makeWelcomeMessage());

        //Start new game block
        String in = null;
        while (in == null) {
            System.out.println(Messages.makePrompt("Start new game?", "Type Y or N:"));
            try {
                in = r.readStart();
                if (in.equalsIgnoreCase("N")) {
                    System.out.println(Messages.quitMessage());
                 System.exit(0);   
                }
            }
            catch (InputException e) {
            System.out.println(e.getMessage());
            }
        }

        //Print start message
        System.out.println(Messages.startMessage());

        //Create new GameBoard
        game = GameBoard.newGame();

        //Print blank board
        System.out.println(Messages.getBoardRepresentation(game)); 

        //Main game block
        while (keepPlaying) {
            try {
                if (turnCount % 2 == 0) {
                    currentPlayer = Cell.X;
                }
                else {
                    currentPlayer = Cell.O;
                }
                System.out.println(Messages.makePrompt("Player " + currentPlayer.toString()  + ", enter your move: ", "type two integers from 1 to 3 separated by a space. First integer - column, second integer - row.")); 
                int[] i = r.readMove();
                game.putAtPosition(i[0], i[1], currentPlayer);
                turnCount++;
                System.out.println(Messages.getBoardRepresentation(game));
                if (game.winner() != Cell.BLANK) {
                    keepPlaying = false;
                    System.out.println("Player " +currentPlayer.toString()  + " wins!");
                    System.out.println(Messages.quitMessage());
                }
                if (turnCount == 9 && game.winner() == Cell.BLANK) {
                    keepPlaying = false;
                    System.out.println("It is a draw!");
                    System.out.println(Messages.quitMessage());
                }
            }
            catch (InputException e) {
                System.out.println(e.getMessage());
            }
            catch (IllegalArgumentException e) {
              System.out.println(e.getMessage());  
            }
        } 
    }
}