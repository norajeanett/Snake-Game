package no.uib.inf101.snakeGame.model;

//import no.uib.inf101.snakeGame.model.Direction;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;

import java.util.ArrayList;
import java.util.List;



/**
 * Represents a snake in a grid-based snake game. The snake consists of a list of
 * {@link GridCell}s that represent its body segments. The snake can move and grow
 * in the grid and checks for collisions with itself or the game boundaries.
 */
public class Snake {
    private List<GridCell<Character>> body;
    private Direction direction;
    private boolean life;


   
    
    /**
     * Constructs the snake with a specified size and position. 
     * Getting the snake a body with four body segments in a straight line. 
     * 
     * Letting the snake start to move to the right
     * 
     *Positioning the snake in a column starting from the middle of the grid. 
     */
    public Snake() {
        this.body = new ArrayList<>();
        int initialX = 8;
        for (int i = 0; i < 4; i++) {
            this.body.add(new GridCell<>(new CellPosition(10, initialX - i), 'I'));
        }
        this.direction = Direction.RIGHT;
        this.life = true; // setting the snake to be alive when starting the game 
    }

    /**
     * Checks if the snake's body occupies the specified position in the grid.
     * 
     * @param x The row index to check.
     * @param y The column index to check.
     * @return true if any part of the snake is at the specified position, false otherwise
     */
    public boolean isAtPosition(int x, int y) {
        for (GridCell<Character> segment : body) {
            if (segment.pos().row() == x && segment.pos().col() == y) {
                return true;
            }
        }
        return false;
    }



    /**
     * Returns a copy of the snake's body.
     *
     * @return A new list containing all the {@link GridCell}s that make up the snake's body.
     */
    public List<GridCell<Character>> getSnakeBody() {
        return new ArrayList<>(this.body); 
    }

    /**
     * Gets the current direction of the snake's movement.
     *
     * @return The current movement {@link Direction} of the snake.
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Checks if the snake is not dead.
     *
     * @return true if the snake is alive, false if it has collided with itself or the wall.
     */
    public boolean isNotDead() {
        return this.life;
    }

    /**
     * Sets the snake's direction of movement to the specified direction, unless it is opposite
     * to the current direction.
     *
     * @param direction The new {@link Direction} to set for the snake.
     */
    public void setDirection(Direction newDirection) {
        if (this.direction.getOpposite() != newDirection) {
            this.direction = newDirection;
        }
    }



    /**
     * Moves the snake in its current direction. If the move is not legal, sets the snake as not alive.
     * Otherwise, updates the snake's position by adding a new head and removing the tail.
     */
    public void move() {
        GridCell<Character> currentState = this.body.get(0);
        CellPosition posOfHead = currentState.pos();
        CellPosition newPosition = new CellPosition(
            posOfHead.row() + this.direction.getDeltaRow(),
            posOfHead.col() + this.direction.getDeltaCol()
        );

        if (!legalMove(newPosition, 20, 20)){
            this.life = false;
            return;
        }

        GridCell<Character> newHead = new GridCell<>(newPosition, 'I');
        this.body.add(0, newHead);
        this.body.remove(this.body.size() - 1);
        
    }


    
    /**
     * Updates the position of a specific body part of the snake.
     *
     * @param index The index of the body part to update.
     * @param newCell The new {@link GridCell} to replace the body part.
     * @throws IndexOutOfBoundsException If the specified index is out of the body's range.
     */
    public void updateSnakeBodyPart(int index, GridCell<Character> newCell) {
        if (index >= 0 && index < this.body.size()) {
            this.body.set(index, newCell);
        } else {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    


    /**
    * Checks for collisions with the game boundaries and updates the alive status if a collision occurs.
    *
    * @param width The width of the game grid.
    * @param height The height of the game grid.
    */
    private void checkWallCollision(int width, int height) {
        GridCell<Character> head = this.body.get(0);
        CellPosition position = head.pos();

        if (position.row() < 0 || position.row() >= height || position.col() < 0 || position.col() >= width) {
            this.life = false;
        }
    }


    /**
    * Checks for collisions with itself and updates the alive status if a collision occurs.
    */
    private void checkSelfCollision() {
        GridCell<Character> head = this.body.get(0);
        CellPosition headPosition = head.pos();

        for (int i = 1; i < this.body.size(); i++) {
            if (headPosition.equals(this.body.get(i).pos())) {
                this.life = false;
                return;
            }
        }
    }



    /**
    * Checks for collisions with the game boundaries or with itself and updates the alive status.
    *
    * @param width The width of the game grid.
    * @param height The height of the game grid.
        */
    public void checkCollision(int width, int height) {
        checkSelfCollision();
        if (this.life) {  // Only check wall collision if still alive after self-collision check
            checkWallCollision(width, height);
        }
    }

   



    /**
     * 
     * Sets the snake's direction of movement to the specified direction,
     * unless it is opposite to the current direction to prevent the snake from reversing.
     * 
     * @param newDirection The new {@link Direction} to set for the snake
     */
    public void updateDirection(Direction newDirection) {
        if (this.direction.getOpposite() != newDirection) {
            this.direction = newDirection;
        }
    }





    /**
     * Grows the snake by adding a new segment at the tail position, in the opposite direction of movement.
     */
    public void grow() {
        GridCell<Character> currentTail = this.body.get(this.body.size() - 1);
        CellPosition tailPosition = currentTail.pos();
        CellPosition newTailPosition = new CellPosition(
            tailPosition.row() - this.direction.getDeltaRow(),
            tailPosition.col() - this.direction.getDeltaCol()
        );

        GridCell<Character> newTail = new GridCell<>(newTailPosition, 'I');
        this.body.add(newTail);
    }

    /**
     * Checks if a move to a new position is legal, considering the boundaries of the game grid
     * and collisions with itself.
     *
     * @param newPosition The new position to check.
     * @param width The width of the game grid.
     * @param height The height of the game grid.
     * @return true if the move is legal, false otherwise.
     */
    private boolean legalMove(CellPosition newPosition, int width, int height) {
        // Check if the new position is within the grid bounds
        if (newPosition.row() < 0 || newPosition.row() >= height || 
            newPosition.col() < 0 || newPosition.col() >= width) {
            return false;
        }
    
        // Check for collision with itself
        for (GridCell<Character> cell : body) {
            if (cell.pos().equals(newPosition)) {
                return false;
            }
        }
    
        return true;
    }



    
}

   



