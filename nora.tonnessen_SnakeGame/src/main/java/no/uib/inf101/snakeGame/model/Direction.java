package no.uib.inf101.snakeGame.model;


/**
 * Represents the possible directions in which an object can move in a grid-based environment.
 * Each direction is associated with a change in the row and column indices in the grid.
 */
public enum Direction {

    /** Direction up, decreases the row index by 1. */
    /** Direction down, increases the row index by 1. */
    /** Direction left, decreases the column index by 1. */
    /** Direction right, increases the column index by 1. */
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    private final int deltaRow; // Change in row index associated with the direction.
    private final int deltaCol; // Change in column index associated with the direction


    /**
     * Constructs a direction with specified changes in row and column indices.
     * 
     * @param deltaRow  The change in the row index when moving in this direction.
     * @param deltaCol  The change in the column index when moving in this direction
     */
    Direction(int deltaRow, int deltaCol) {
        this.deltaRow = deltaRow;
        this.deltaCol = deltaCol;
    }


    /**
     * Change in row index
     * 
     * @return The row delta for this direction.
     */
    public int getDeltaRow() {
        return this.deltaRow;
    }


    /**
     * Change in column index
     * 
     * @return The column delta for this direction.
     */
    public int getDeltaCol() {
        return this.deltaCol;
    }


    /**
     * Returns the opposite direction of the current direction.
     * For example, the opposite of UP is DOWN, same with RIGHT and LEFT.
     * 
     * @return The opposite direction.
     * @throws IllegalStateException If the direction is not recognized.

     */
    public Direction getOpposite() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case UP: return DOWN;
            case DOWN: return UP;
            default: throw new IllegalStateException("Unknown direction: " + this);
        }
    }
}
