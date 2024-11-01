package no.uib.inf101.snakeGame.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Color;

import org.junit.jupiter.api.Test;


public class DefaultColorThemeTest {

    @Test
    public void testColorAssignments() {
        ColorTheme colors = new DefaultColorTheme();
        
        // Testing specific color assignments
        //assertEquals(Color.BLACK, colors.getCellColor('-'), "Cell color for '-' should be black.");
        //assertThrows(IllegalArgumentException.class, () -> colors.getCellColor('X'), "Should throw IllegalArgumentException for undefined colors.");

        // Test other color settings
        assertEquals(Color.DARK_GRAY, colors.getFrameColor(), "Frame color should be transparent black.");
        assertEquals(Color.BLACK, colors.getBackgroundColor(), "Background color should be null.");
        assertEquals(new Color(0, 0, 0, 128), colors.getGameOverColor(), "Game over color should be semi-transparent black.");
        assertEquals(Color.WHITE, colors.getGameOverText(), "Game over text color should be white.");
        assertEquals(Color.RED, colors.getFoodColor(), "Food color should be red.");
    }

}
