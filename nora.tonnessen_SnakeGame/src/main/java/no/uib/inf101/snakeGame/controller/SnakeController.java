package no.uib.inf101.snakeGame.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import no.uib.inf101.snakeGame.model.GameState;
import no.uib.inf101.snakeGame.view.SnakeView;
import no.uib.inf101.snakeGame.model.Direction;


/**
 * The controller for a Snake Game. Implementing the KeyListener
 * interface to handle keyboard inputs and control the game accordingly.
 */
public class SnakeController implements java.awt.event.KeyListener {

    private final ControllableSnake consol;
    private final SnakeView snakeView;
    private final Timer timer;



    /**
   * Initializes the SnakeController with references to the game's model
   * and view, sets up the game timer for periodic updates.
   * 
   * @param consol Represents the Snake Game's model, handling the
   *                 logic and state of the game
   * @param snakeview     Represents the UI of the game, displaying the game
   *                 state to the player and handling user input.
   */
    public SnakeController(ControllableSnake consol, SnakeView snakeView) {
        this.snakeView = snakeView;
        this.consol = consol;

      
        this.timer = new Timer(consol.getTimeBetweenTicks(), this::clockTick);
        this.timer.setInitialDelay(0);
        this.timer.start();

        this.snakeView.setFocusable(true);
        this.snakeView.addKeyListener(this); 

    }

    /**
   * Handles keyboard input for moving and rotating the Snake, 
   * moving it instantly on specific key presses.
   * 
   * @param e The KeyEvent triggered by the user's keyboard actions.
   */
    @Override
    public void keyPressed(KeyEvent e){
        if (consol.getGameState() == GameState.GAME_OVER && e.getKeyCode() != KeyEvent.VK_ENTER) {
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            consol.rotateSnake(Direction.LEFT);
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            consol.rotateSnake(Direction.RIGHT);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            consol.rotateSnake(Direction.DOWN);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            consol.rotateSnake(Direction.UP);;
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            consol.restartGame();
        }
        snakeView.repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


    /**
   * Handles the actions to be performed on each clock tick in the SnakeGame
   * game. On each tick, it updates the game model to reflect the passage
   * of time.
   * 
   * @param e is triggered by the game timer, but not used directly, but
   *          required for compatibility
   */
    public void clockTick(ActionEvent e) {
        consol.moveSnake();
        consol.clockTick();
        snakeView.repaint();
    }
}
