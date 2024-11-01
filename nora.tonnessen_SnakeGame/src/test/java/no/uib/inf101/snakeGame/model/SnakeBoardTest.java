package no.uib.inf101.snakeGame.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.uib.inf101.grid.CellPosition;
//import no.uib.inf101.grid.GridCell;


public class SnakeBoardTest {

    @Test
  public void testPrettyString() {
      SnakeBoard board = new SnakeBoard(3, 4);
      board.set(new CellPosition(0, 0), 'H');  // Snake's head
      board.set(new CellPosition(0, 1), 'S');  // Snake's body
      board.set(new CellPosition(2, 0), 'F');  // Food
      board.set(new CellPosition(2, 3), '-');  // Empty space
  
      String expected = "H S - -\n" +
                        "- - - -\n" +
                        "F - - -";
      assertEquals(expected, board.prettyString());
  }  


    

}
