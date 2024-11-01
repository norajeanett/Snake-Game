package no.uib.inf101.grid;

import java.lang.reflect.InaccessibleObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * Represents a generic two-dimensional grid. Allowing for storage and
 * manipulation of elements of any specified type.
 * 
 * @param <E> the type of elements stored in this grid
 */
public class Grid<E> implements IGrid<E> {

    protected int rows;
    private int cols;
    private List<List<E>> grid;

    /**
   * Initializes a new Grid instance with a specified size and default
   * value for all cells.
   * 
   * @param rows          the number of rows
   * @param cols          the number of colims
   * @param defaultValue used to initialize each cell of the grid
   */
    public Grid(int rows, int cols, E defaultValue) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new ArrayList<>();

        for (int r = 0; r< rows; r++){
            List<E> rowlist = new ArrayList<>();
            for(int i = 0; i<this.cols; i++){
                rowlist.add(defaultValue);    
            }
        grid.add(rowlist); 
        } 
    }
    /**
   * Constructs a grid object with a specific number of rows and colums,
   * where each cell is set to null. Creating a grid without specifying a
   * default calue for its cells.
   * 
   * @param row the number of rows
   * @param col the number of columns
   */
    public Grid(int rows, int cols) {
        this(rows, cols, null);

    }

   /**
   * Gets the number of rows in the grid.
   *
   * @return the row count
   */
    @Override
    public int rows() {
        return this.rows;
    }



   /**
   * Gets the number of columns in the grid.
   *
   * @return the column count
   */
    @Override
    public int cols() {
        return this.cols;
    }




   /**
   * Provides an iterator over the cells in the grid, allowing for
   * traversal of all cells.
   * 
   * @return an iterator over a ArrayList of GridCell<E>
   */
  @Override
  public Iterator<GridCell<E>> iterator() {
    List<GridCell<E>> cells = new ArrayList<>();
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.cols; col++) {
        CellPosition pos = new CellPosition(row, col);
        GridCell<E> gridItem = new GridCell<>(pos, get(pos));
        cells.add(gridItem);
      }
    }
    return cells.iterator();
  }

/**
   * Sets the value to a specific cell in the grid to a new value.
   * 
   * @param pos   the position of the cell to update
   * @param value the new value for the specified cell
   * @throws InaccessibleObjectException if the position is outside the
   *                                     grids bounds
   */
  @Override
  public void set(CellPosition pos, E value) {
    if (!positionIsOnGrid(pos)) {
      throw new InaccessibleObjectException("Position is not on the grid");
    }
    grid.get(pos.row()).set(pos.col(), value);
  }



/**
   * Retrives the value of a specific cell in the grid. It checks if the
   * spcified position is within the grid's bounds.
   * 
   * @param pos the position of the cell
   * @return the value at the specified position
   * @throws IndexOutOfBoundsException if the position is outside the
   *                                   grid's bounds
   */
  @Override
  public E get(CellPosition pos) {
    if (!positionIsOnGrid(pos)) {
      throw new IndexOutOfBoundsException("Position is not on grid");
    }
    return grid.get(pos.row()).get(pos.col());
  }


    
/**
   * Checks if a given position is within the bounds of the grid.
   *
   * @param pos the position to check
   * @return true if the position is within the grid, false otherwise
   */
  @Override
  public boolean positionIsOnGrid(CellPosition pos) {
    boolean isInRow = pos.row() >= 0 && pos.row() < this.rows;
    boolean isOnCol = pos.col() >= 0 && pos.col() < this.cols;
    return isInRow && isOnCol;
  }
    
}