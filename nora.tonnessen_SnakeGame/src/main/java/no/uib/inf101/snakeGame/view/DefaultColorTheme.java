package no.uib.inf101.snakeGame.view;

import java.awt.Color;

public class DefaultColorTheme implements ColorTheme{
 
   
     
    
   
    @Override
    public Color getFrameColor() {
        return Color.DARK_GRAY;
    }

    @Override
    public Color getBackgroundColor() {
        return Color.BLACK;
    }

    
    
        @Override
        public Color getGameOverColor() {
            return new Color(0, 0, 0, 128);
        }
    
   
        @Override
        public Color getGameOverText() {
            return Color.WHITE;
        }
    
    
        @Override
        public Color getFoodColor() {
            return Color.RED;
        }   
    
    
        
        
        
        
    }
