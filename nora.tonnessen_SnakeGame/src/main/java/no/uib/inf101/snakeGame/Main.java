package no.uib.inf101.snakeGame;

import javax.swing.JFrame;

import no.uib.inf101.snakeGame.controller.SnakeController;
import no.uib.inf101.snakeGame.model.SnakeBoard;
import no.uib.inf101.snakeGame.model.SnakeModel;
import no.uib.inf101.snakeGame.model.newFood.FoodFactory;
import no.uib.inf101.snakeGame.model.newFood.RandomFoodFactory;
import no.uib.inf101.snakeGame.view.SnakeView;
import no.uib.inf101.snakeGame.model.Snake;

public class Main {

  public static final String WINDOW_TITLE = "Snake Game";

  public static void main(String[] args) {
    
    SnakeBoard board = new SnakeBoard(20, 20);
    FoodFactory factory = new RandomFoodFactory();
    Snake snake = new Snake();
    SnakeModel model = new SnakeModel(board, factory, snake);
    SnakeView view = new SnakeView(model);
    new SnakeController(model, view);


    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setTitle("Snake");
    frame.setContentPane(view);

    frame.pack();
    frame.setVisible(true);

  }
}
