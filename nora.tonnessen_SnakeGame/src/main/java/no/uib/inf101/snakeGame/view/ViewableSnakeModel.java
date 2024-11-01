package no.uib.inf101.snakeGame.view;

import no.uib.inf101.grid.GridCell;
import no.uib.inf101.grid.GridDimension;
import no.uib.inf101.snakeGame.model.GameState;
import no.uib.inf101.snakeGame.model.Snake;
import no.uib.inf101.snakeGame.model.newFood.Food;

public interface ViewableSnakeModel {
    
        GridDimension getDimension();
    
        Iterable<GridCell<Character>> getTilesOnBoard ();
    
        Food getPostition();
    
        Snake getSnake();
    
        GameState getGameState();
        
        void checkFood();

        int getScore();
    
    }
