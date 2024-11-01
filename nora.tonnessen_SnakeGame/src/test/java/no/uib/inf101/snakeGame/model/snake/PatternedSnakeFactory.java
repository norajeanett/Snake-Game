package no.uib.inf101.snakeGame.model.snake;

import no.uib.inf101.grid.Grid;
import no.uib.inf101.snakeGame.model.newFood.Food;
import no.uib.inf101.snakeGame.model.newFood.FoodFactory;

public class PatternedSnakeFactory implements FoodFactory {

	private String tetrominoPattern;
	private int index;

	public PatternedSnakeFactory(String pattern) {
		this.tetrominoPattern = pattern;
		this.index = 0;
	}

	@Override
	public Food getNext(Grid<?> grid) {
		char current = tetrominoPattern.charAt(index % tetrominoPattern.length());
        index++;
        return Food.getSnake(current);
	}
	

}
