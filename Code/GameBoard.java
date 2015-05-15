
import java.util.*;

public class GameBoard {

    /**
    * Class fields
    */
    private Cell[][] board;
    private boolean ended;
    private Cell winner;

    /**
    * Class constructor with no params
    * creates new 3x3 board with 9 blank cells
    * sets default value to boolean ended
    * sets default value to Cell winner
    */
    private GameBoard() {
        board = new Cell[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Cell.BLANK;
            }
        }
        ended = false;
        winner = Cell.BLANK;
    }

    /**
    * Creates new GameBoard object, takes no params
    * @return new GameBoard object
    */
    public static GameBoard newGame() {return new GameBoard();}

    /**
    * Creates board with
    * @param x specifies column
    * @param y specifies row
    * @return board with specified params
    * checks if int x and int y are in range 1-3
    */
    public Cell atPosition (int x, int y) {
        checkInRange(x, 1, 3);
        checkInRange(y, 1, 3);
        return board[x-1][y-1];
    }

    /**
    * Method checks if it is possible to put next move on the current board
    * and puts it if checks are passed
    * @param x specifies column
    * @param y specifies row
    * @param c Cell c specifies current players symbol (X or O)
    * checks if int x and int y are in range 1-3
    * checks if int x and int y are blank
    * checks is not null
    * sets board to c
    * checks for end of the game
    */
    public void putAtPosition (int x, int y, Cell c) {
        checkInRange(x, 1, 3);
        checkInRange(y, 1, 3);
        checkBlank(x, y);
        checkNull(c);
        board[x-1][y-1] = c;
        checkForEnd();
    }

    /**
    * Checks who is the winner
    * @return winner current winner
    */
    public Cell winner () {return winner;}

    /**
    * Overrides the equals method
    */
    @Override
    public boolean equals (Object o) {
        if (o instanceof GameBoard) {
            GameBoard gb = (GameBoard)o;
            return Arrays.deepEquals(board, gb.board);
        }
        return false;
    }

    /**
    * Overrides the hashcode method
    */
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    /**
     * Overrides the toString method
    */
    @Override
    public String toString() {
        return Arrays.deepToString(board);
    }

   /**
    * Checks if the specified cell is blank
    * @param int x specifies column
    * @param int y specifies row
    * @throws new IllegalArgumentException with specified text
    */
    private void checkBlank (int x, int y) {
        if (!board[x-1][y-1].equals(Cell.BLANK)) {
            throw new IllegalArgumentException("Cell at (" + x + ", " + y + ") is not blank. Try again.");
        }
    }

   /**
    * Checks if the game is ended:
    * checks rows for x and y
    * checks columns for x and y
    * checks diagonals for x and y
    */
    private void checkForEnd () {
        for (int i = 1; i <= 3; i++) {
            if (checkRow(i, Cell.X)) {
                ended = true;
                winner = Cell.X;
                break;
            }
            if (checkRow(i, Cell.O)) {
                ended = true;
                winner = Cell.O;
                break;
            }
        }
        if (!ended) {
            for (int i = 1; i <= 3; i++) {
                if (checkColumn(i, Cell.X)) {
                    ended = true;
                    winner = Cell.X;
                    break;
                }
                if (checkColumn(i, Cell.O)) {
                    ended = true;
                    winner = Cell.O;
                    break;
                }
            }
        }
        if (!ended) {
            if (checkDiagonals(Cell.X)) {
                ended = true;
                winner = Cell.X;
            }
            if (checkDiagonals(Cell.O)) {
                ended = true;
                winner = Cell.O;
            }
        }
    }

    /**
    * Checks rows for winner
    * @param row specifies the row
    * @param c Cell who specifies which player is the winner (X or O)
    * @return boolean true if all row is occupied by the same player
    */
    private boolean checkRow (int row, Cell who) {
        for (int i = 0; i < 3; i++) {
            if (!board[i][row-1].equals(who)) {
                return false;
            }
        }
        return true;
    }

    /**
    * Checks columns for winner
    * @param int column specifies the row
    * @param Cell who specifies which player is the winner (X or O)
    * @return boolean true if all column is occupied by the same player
    * I love Ken! I hate Java! Nobody reads this anyway! =)
    */
    private boolean checkColumn (int column, Cell who) {
        for (int i = 0; i < 3; i++) {
            if (!board[column-1][i].equals(who)) {
                return false;
            }
        }
        return true;
    }

    /**
    * Checks diagonals for winner
    * @param Cell who specifies which player is the winner (X or O)
    * @return boolean true if all row is occupied by the same player
    */
    private boolean checkDiagonals (Cell who) {
        if (!board[1][1].equals(who)) {
            return false;
        }
        if (board[0][0].equals(who) && board[2][2].equals(who)) {
            return true;
        }
        if (board[0][2].equals(who) && board[2][0].equals(who)) {
            return true;
        }
        return false;
    }
    
    /**
    * Checks if input values are in range between lower and higher bound
    * @param int val input value
    * @param int low lower bound
    * @param int high higher bound
    * @throws new IllegalArgumentException with specified text
    */
    private void checkInRange (int val, int low, int high) {
        if (val < low || val > high) {
            throw new IllegalArgumentException("Value should be in the range [" + low + ", " + high + "].");
        }
    }

    /**
    * Checks if input values are not null
    * @param Object val input value
    * @throws new IllegalArgumentException with specified text
    */
    private void checkNull (Object val) {
        if (val == null) {
            throw new IllegalArgumentException("Value should not be null.");
        }
    }
}
