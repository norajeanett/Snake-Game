package no.uib.inf101.snakeGame.controller;

import no.uib.inf101.snakeGame.model.GameState;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.snakeGame.model.Direction;

public interface ControllableSnake {

    /**
 * Moves the snake based on its current direction and updates the game state
 * according to the move's outcome.
 *
 * @return true if the snake successfully moved without colliding, false otherwise
 */
boolean moveSnake();
        

/**
* 
* 
* @return The the current gamestate
*/
GameState getGameState();


/**
 * Gets the dimensions of the grid on which the game is played.
 *
 * @return the dimensions of the grid
 */
GridDimension getDimension();
    
    
/**
 * Restarts the game, resetting all game elements to their initial state.
 */
void restartGame();
    
    

/**
 * Returns the interval between ticks in milliseconds. This determines the
 * pace at which the snake moves.
 *
 * @return the time between game update ticks in milliseconds
 */
int getTimeBetweenTicks();
    


/**
* Advances the game state based on a timer tick. 
*/
void clockTick();

/**
 * Changes the direction of the snake's movement unless it's directly opposite to the current direction.
 *
 * @param newDirection the new direction for the snake to move
 */ 
void rotateSnake(Direction newDirection);
            
}




    