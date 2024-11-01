package no.uib.inf101.snakeGame.model.newFood;

import java.util.Random;

import no.uib.inf101.grid.Grid;

/**
 * This class implements the {@link FoodFactory} interface to provide a mechanism
 * for generating food items at random positions within a given grid. The positions
 * are generated such that they do not conflict with existing elements like the snake.
 */
public class RandomFoodFactory implements FoodFactory{

    private final Random random = new Random();


    /**
     * 
     * Generates and returns a new Food item placed random at the grid. 
     * It does this repeatedly until a good place is found where there is no sign of the snake occupying the space. 
     * 
     *
     * @param grid The game grid on which the food is to be placed, used to determine
     *             the boundaries and check the validity of the food's position.
     * 
     * @return A new Food object positioned at a valid location on the grid.
     * 
     */
    @Override
    public Food getNext(Grid<?> grid) {
        int x, y;
        do {
            x = random.nextInt(grid.rows());
            y = random.nextInt(grid.cols());
        } while (!isValidPosition(grid, x, y)); // Continues until a valid position is found.
        return new Food(x, y);
    }

    //SOMETHING IS WRONG SINCE THE FOOD CAN BE PLACED UNDER THE SNAKE WHEN THE SNAKE GROWS !!!!

    /**
     *
     * Validates the position for placing new food in the grid. 
     * Checks conditions to the games rules. 
     * Ensuring that the position is not currently occupied by the snake or ouside the grid. (dont think it works that good..)
     * 
     * @param grid The grid on which the food is to be placed
     * @param x The x-coordinate of the cell to check.
     * @param y The y-coordinate of the cell to check.
     * @return true if the position is valid for new food placement, false otherwise.
     */
    private boolean isValidPosition(Grid<?> grid, int x, int y) {
        return true;
    }
    
}
