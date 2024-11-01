package no.uib.inf101.grid;


/**
 * Provides an interface to retrieve dimensions of a grid.
 * This interface allows querying the number of rows and columns
 * in a grid structure.
 */
public interface GridDimension {

  /**
     * Retrieves the number of rows in the grid.
     * 
     * @return the number of rows
     */
  int rows();

  /**
     * Retrieves the number of columns in the grid.
     * 
     * @return the number of columns
     */
  int cols();
}
