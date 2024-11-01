package no.uib.inf101.snakeGame.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.Grid;


/**
 * Represents the game board for a snake game,
 */
public class SnakeBoard extends Grid<Character> {
    
        /**
         * Constructs a SnakeBoard with the specified number of rows and columns.
     * All cells are initialized with a hyphen ('-') representing an empty state
         * 
         * @param rows The number of rows in the board.
         * @param cols The number of columns in the board
         */
        public SnakeBoard(int rows, int cols) {
            super(rows, cols, '-');
    
        }

    
        /**
         * Removes an object from the specified position by setting it to the default empty state ('-').
         * 
         * @param x The row index of the cell to clear.
         * @param y The column index of the cell to clear.
         */
        public void removeObject(int x, int y) {
            set(new CellPosition(x, y), '-');
        }


        /**
         * Checks if a given position is within the boundaries of the grid.
         * 
         * @param position The cell position to check.
         * @return true if the position is within the grid bounds, false otherwise.
         * 
         */
        public boolean positionIsOnGrid(CellPosition position) {
            return position.row() >= 0 && position.row() < this.rows() &&
                   position.col() >= 0 && position.col() < this.cols();
        }



     
    
        /**
        * Generates a pretty string representation of the grid.
        * Each row is separated by a newline, with each cell's value concatenated directly.
        * 
        * @return A formatted string representing the grid.
        */
        public String prettyString() {
            StringBuilder sb = new StringBuilder();
            String delimiter = " "; // Delimiter can be adjusted or made a parameter.
    
            for (int i = 0; i < rows(); i++) {
                for (int j = 0; j < cols(); j++) {
                    sb.append(get(new CellPosition(i, j)));
                    if (j < cols() - 1) {
                        sb.append(delimiter); // Delimiter to separate cells within the same row.
                    }
                }
            if (i < rows() - 1) {
                sb.append("\n");
            }
        }
    
        return sb.toString();
    }
        
    }
    
