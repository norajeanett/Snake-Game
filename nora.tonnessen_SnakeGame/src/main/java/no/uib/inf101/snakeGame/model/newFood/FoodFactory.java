package no.uib.inf101.snakeGame.model.newFood;

import no.uib.inf101.grid.Grid;

/** 
 * Interface for a factory that produces Food items for a SnakeGame.
 */
public interface FoodFactory {
    
    /**
     * 
     * Gets the next food item and places it on the grid.
     * 
     * @param grid  The game grid on which the food is to be placed, providing context
     *             such as size, and possibly the positions of other game elements.
     * 
     * @return The next Food object, positioned appropriately on the grid
     */
    public Food getNext(Grid<?> grid);
}
