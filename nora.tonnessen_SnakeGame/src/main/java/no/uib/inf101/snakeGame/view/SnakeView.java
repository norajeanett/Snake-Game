package no.uib.inf101.snakeGame.view;


import javax.swing.JPanel;
import no.uib.inf101.grid.CellPosition;
import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.snakeGame.model.GameState;
import no.uib.inf101.snakeGame.model.Snake;
import no.uib.inf101.snakeGame.model.newFood.Food;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
//import java.io.File;

import java.awt.FontMetrics;

//import java.awt.geom.AffineTransform;



public class SnakeView extends JPanel {

    public static final int OUTERMARGIN = 22;
    public static final int CELLMARGIN = 0;
    public static final int PREFERREDSIDESIZE = 30;

    private final ViewableSnakeModel model;
    private final ColorTheme color;
   
    
    
    
    

    public SnakeView(ViewableSnakeModel model) {
        this.model = model;
        this.color = new DefaultColorTheme();
        this.setBackground(color.getBackgroundColor());
        this.setFocusable(true);
        this.setPreferredSize(getDefaultSize(model.getDimension()));
        


    }



   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawGame(g2);
        
        
    }

    private void drawGame(Graphics2D g2) {
        // Define a smaller game area within the JPanel
        Rectangle2D r2d = new Rectangle2D.Double(
            OUTERMARGIN,
            OUTERMARGIN,
            this.getWidth() - 2 * OUTERMARGIN,  // Smaller width
            this.getHeight() - 2 * OUTERMARGIN  // Smaller height
        );
        g2.setColor(color.getFrameColor());
        g2.fill(r2d);
    
        // Adjust cell positioning and drawing code accordingly
        CellPositionToPixelConverter converter = new CellPositionToPixelConverter(r2d, this.model.getDimension(), CELLMARGIN);
        drawFood(g2, this.model.getPostition(), converter);
        drawSnake(g2, this.model.getSnake(), converter, color);
    
        if (model.getGameState() == GameState.GAME_OVER) {
            drawGameOver(g2, r2d);
        } else {
            drawScore(g2);
        }
    }


    private void drawScore(Graphics2D g2) {
        String scoreText = "Score: " + model.getScore();
        Font scoreFont = new Font("Calibri", Font.BOLD, 20);

        g2.setFont(scoreFont);
        g2.setColor(Color.WHITE); // Ensuring score is visible on black background

        FontMetrics metrics = g2.getFontMetrics(scoreFont);
        int x = (this.getWidth() - metrics.stringWidth(scoreText)) / 2;
        int y = this.getHeight() - metrics.getHeight(); // Positioning score at the bottom
        g2.drawString(scoreText, x, y);
    }


    private void drawGameOver(Graphics2D g2, Rectangle2D r2d) {
        g2.setColor(color.getGameOverColor());
        g2.fill(r2d);
        g2.setColor(color.getGameOverText());
        g2.setFont(new Font("Calibri", Font.BOLD, 30));
        String gameOverText = "GAME OVER";
        FontMetrics gameOverMetrics = g2.getFontMetrics();

        // Calculate the position to center the "Game Over" text
        int x = (int) (r2d.getX() + (r2d.getWidth() - gameOverMetrics.stringWidth(gameOverText)) / 2);
        int y = (int) (r2d.getY() + ((r2d.getHeight() - gameOverMetrics.getHeight()) / 2) + gameOverMetrics.getAscent());
        g2.drawString(gameOverText, x, y);

        // Define and draw the final score text below the "Game Over" message
        String scoreText = "Score: " + model.getScore();
        Font scoreFont = new Font("Arial", Font.PLAIN, 20);
        g2.setFont(scoreFont);
        FontMetrics scoreMetrics = g2.getFontMetrics(scoreFont);

        // Calculate the position to center the score text on the screen
        int scoreX = (int) (r2d.getX() + (r2d.getWidth() - scoreMetrics.stringWidth(scoreText)) / 2);
        int scoreY = y + scoreMetrics.getHeight() + 20; // Position below the "Game Over" text
        g2.drawString(scoreText, scoreX, scoreY);
    }

    

    private void drawFood(Graphics2D g2d, Food food, CellPositionToPixelConverter converter) {
        Rectangle2D foodRect = converter.getBoundsForCell(new CellPosition(food.getX(), food.getY()));
        g2d.setColor(color.getFoodColor());
        g2d.fill(foodRect);

        }
   
    
    private void drawSnake(Graphics2D g2d, Snake snake, CellPositionToPixelConverter converter, ColorTheme ct) {
        Color snakeColor = Color.GREEN; // This method should return a consistent color, such as green.

        for (GridCell<Character> cell : snake.getSnakeBody()) {
            Rectangle2D cellRect = converter.getBoundsForCell(cell.pos());
                g2d.setColor(snakeColor);
                g2d.fill(cellRect);
            }
        }
    


    private static Dimension getDefaultSize(GridDimension gd) {
        int width = (int) (PREFERREDSIDESIZE * gd.cols() + 2 * OUTERMARGIN);
        int height = (int) (PREFERREDSIDESIZE * gd.rows() + 2 * OUTERMARGIN);
        return new Dimension(width, height);
    }

    
  
}