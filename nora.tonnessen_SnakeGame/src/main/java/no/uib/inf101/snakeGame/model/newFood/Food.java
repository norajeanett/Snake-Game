package no.uib.inf101.snakeGame.model.newFood;


/**
 * Represents a food item on the grid in the snake game.
 * Each food item has a fixed position characterized by its x and y coordinates.
 */
public class Food {

   
        private final int x;
        private final int y;
    

        /**
        * Constructs a new Food object at a specified location on the game grid.
        *
        * @param x the x-coordinate of the food's location
        * @param y the y-coordinate of the food's location
        */
        public Food(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
    
        /**
        * Gets the x-coordinate of this food item.
        *
        * @return the x-coordinate of the food
        */
        public int getX() {
            return x;
        }
    
    
        /**
        * Gets the y-coordinate of this food item.
        *
        * @return the y-coordinate of the food
        */
        public int getY() {
            return y;
        }



        /**
        * Generates a food item associated with a specific characteristic or property.
        * This method is currently unsupported and throws UnsupportedOperationException if used.
        *
        * @param current The character representing the specific type of food or condition
        * @return A new Food object based on the specified character
        * @throws UnsupportedOperationException if the method is not implemented
        */
        public static Food getSnake(char current) {
            throw new UnsupportedOperationException("Unimplemented method 'getSnake'");
        }
    
        
    }
