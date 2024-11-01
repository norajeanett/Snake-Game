package no.uib.inf101.snakeGame.model;

import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.snakeGame.controller.ControllableSnake;
import no.uib.inf101.snakeGame.model.newFood.Food;
import no.uib.inf101.snakeGame.model.newFood.FoodFactory;
import no.uib.inf101.snakeGame.view.ViewableSnakeModel;


/**
 * Initializes the game model with a game board
 */
public class SnakeModel implements ViewableSnakeModel, ControllableSnake {

    private final SnakeBoard board;
    private final FoodFactory foodFactory;
    private GameState state;
    private Snake snake;
    private Food food;
    private int score;

    /**
     * Constructs a SnakeModel with specified board, food factory, and snake.
     *
     * @param board        The game board.
     * @param foodFactory  The factory to create food.
     * @param snake        The snake object.
     */
    public SnakeModel(SnakeBoard board, FoodFactory foodFactory, Snake snake) {
        this.board = board;
        this.foodFactory = foodFactory;
        this.snake = new Snake();
        this.food = this.foodFactory.getNext(this.board);
        this.score = 0;
        this.state = GameState.ACTIVE_GAME;
    }


    /**
     * 
     * 
     */
    @Override
    public GridDimension getDimension() {
        return this.board; //maybe getDimensions from Snakeboard 
    }


    /**
     * 
     * 
     */
    @Override
    public Iterable<GridCell<Character>> getTilesOnBoard() {
        return this.board; //maybe getCells from Snakeboard
    }

    /**
     * 
     * 
     */
    @Override
    public GameState getGameState() {
        return this.state;
    }


    /**
     * 
     * 
     */
    @Override
    public Snake getSnake() {
        return this.snake;
    }


    /**
     * 
     * 
     */
    @Override
    public Food getPostition() {
        return this.food;
    }


    /**
     * Checks if the snake's head is on the food position to trigger growth and food regeneration.
     * 
     */
    @Override
    public void checkFood() {
        CellPosition headPos = this.snake.getSnakeBody().get(0).pos();
        CellPosition foodPos = new CellPosition(food.getX(), food.getY());

        if (headPos.equals(foodPos)) {
            this.snake.grow();
            //this.board.removeObject(food.getX(), food.getY());
            this.score += 10;
            this.food = this.foodFactory.getNext(this.board);
        }
    }


    /**
     *  Changes the direction of the snake unless it is opposite to the current direction.
     * @param dir The new direction to set.
     * 
     */
    @Override
    public void rotateSnake(Direction dir) {
        //Direction currentDirection = snake.getDirection();
        if (dir != snake.getDirection().getOpposite()) {
            this.snake.setDirection(dir);
        }
    }


    /**
     * Moves the snake, checks for food, and checks for collisions.
     * @return true if the snake is still alive after the move; false otherwise.
     * 
     */
    @Override
    public boolean moveSnake() {
        this.snake.move();
        checkFood();
        //this.snake.checkCollision(board.rows(), board.cols());
        this.snake.checkCollision(this.board.rows(), this.board.cols());

        if (!this.snake.isNotDead()) {
            this.state = GameState.GAME_OVER;
            return false;
        }
        return true;
    }



    /**
     * 
     * Resets the game to its initial state with a new snake and food.
     */
    @Override
    public void restartGame() {
        this.snake = new Snake(); // Consider adjusting to use a factory or method for flexibility.
        this.food = this.foodFactory.getNext(this.board);
        this.score = 0; 
        this.state = GameState.ACTIVE_GAME;
    }

    /**
     * Provides the time between each game update tick in milliseconds.
     * @return The time in milliseconds between game updates.
     */
    @Override
    public int getTimeBetweenTicks() {
        return 100;  // Milliseconds
    }

   
    @Override
    public void clockTick() {
        // Implementation for timed game updates can be added here if needed.
    }



    public void getNewScore() {
        this.score += 10;  // Increase score by 10 points
    }

    

    public int getScore(){
        return this.score;
    }

}
