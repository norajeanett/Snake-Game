package no.uib.inf101.snakeGame.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.snakeGame.model.SnakeBoard;
import no.uib.inf101.snakeGame.model.SnakeModel;
import no.uib.inf101.snakeGame.model.newFood.Food;
import no.uib.inf101.snakeGame.model.newFood.FoodFactory;
import no.uib.inf101.snakeGame.model.newFood.RandomFoodFactory;
import no.uib.inf101.snakeGame.model.snake.PatternedSnakeFactory;
import no.uib.inf101.snakeGame.view.ViewableSnakeModel;




public class TestSnakeModel {
	
	private SnakeModel model;
    private SnakeBoard board;
    private Snake snake;
	private FoodFactory foodFactory;

	@BeforeEach
    public void setUp() {
        board = new SnakeBoard(20, 20); // Assuming a board of 20 rows by 10 columns
        snake = new Snake();
		foodFactory = new RandomFoodFactory();
        model = new SnakeModel(board, foodFactory, snake);
		model.restartGame();

		GridCell<Character> headAtBoundary = new GridCell<>(new CellPosition(0, 5), 'I');
		snake.getSnakeBody().clear();
    	snake.getSnakeBody().add(headAtBoundary); // Adjust the body list directly.
    	snake.setDirection(Direction.UP);

    }

	@Test
    public void testSnakeMovement() {
        // Example test to check snake movement
        assertTrue(model.moveSnake(), "Snake should move successfully.");
    }


	@Test
    public void testFoodPlacement() {
        // Test to ensure food is not placed on the snake
        Food food = model.getPostition();
        assertFalse(snake.isAtPosition(food.getX(), food.getY()), "Food should not be on the snake.");
    }

	@Test
    public void testMoveSnakeWithinBoard() {
        snake.setDirection(Direction.RIGHT);
        assertTrue(model.moveSnake(), "Snake should move successfully within board limits.");
    }


	@Test
    public void snakeDoesNotExitBoard() {
        // Move the snake to the right edge of the board
        snake.setDirection(Direction.RIGHT);
        for (int i = 0; i < board.cols() - 1; i++) {
            model.moveSnake();
        }
        // Next move should be out of bounds, assuming moveSnake returns false if move is not possible
        assertFalse(model.moveSnake());
    }


	@Test
	public void testSnakeCannotReverseFromRightToLeft() {
    	Snake snake = new Snake();
    	snake.setDirection(Direction.RIGHT);
    	snake.updateDirection(Direction.LEFT);  // Attempt to reverse direction
    	assertNotEquals(Direction.LEFT, snake.getDirection(), "Snake should not reverse direction from RIGHT to LEFT.");
}

	


	

// HVORFOR VIK UJJE DENNE FYYYYYYY
	
	@Test
	public void testSnakeCannotReverseFromDownToUp() {
    	Snake snake = new Snake();
    	snake.setDirection(Direction.DOWN);
    	snake.updateDirection(Direction.UP);  // Attempt to reverse direction
    	assertNotEquals(Direction.UP, snake.getDirection(), "Snake should not reverse direction from DOWN to UP.");
}


	@Test
	public void testSnakeCannotReverseFromUpToDown() {
    	Snake snake = new Snake();
    	snake.setDirection(Direction.UP);
    	snake.updateDirection(Direction.DOWN);  // Attempt to reverse direction
    	assertNotEquals(Direction.DOWN, snake.getDirection(), "Snake should not reverse direction from UP to DOWN.");
}

	

	

	@Test
    public void rotateSnakeWithinItsBodyBounds() {
        snake.setDirection(Direction.RIGHT);
        model.moveSnake(); // Move once to the right
        snake.setDirection(Direction.UP); // Change direction up
        assertDoesNotThrow(() -> model.moveSnake()); // This should not throw an exception
    }


	


}
