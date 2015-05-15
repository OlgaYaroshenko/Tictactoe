    
public enum Cell {
    X, O, BLANK;

/*
 * Overrides the toString method
 */
    @Override
    public String toString() {
        if (this.equals(Cell.X)) {
            return "X";
        }
        if (this.equals(Cell.O)) {
            return "O";
        }
        return " ";
    }
}
