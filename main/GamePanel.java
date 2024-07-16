package main;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import javax.swing.JPanel;
import inputs.KeyboardInputs;

public class GamePanel extends JPanel {
    //Dimensions and the Color of the Pong Paddles
    private static int paddleHeight = 70;
    private static int paddleWidth = 10;
    private static Color paddleColor = Color.WHITE;

    //Initial Location of Player One
    private static int pOneXDelta = 10;
    private static int pOneYDelta = 300 - paddleHeight;

    //Initial Location of Player Two
    private static int pTwoXDelta = 890 - paddleWidth;
    private static int pTwoYDelta = 300 - paddleHeight;

    //Panel Color
    private static Color gamePanelColor = Color.BLACK;

    // //Booleans to see which Specific Paddle to Move
    // private static boolean movePlayerOne = true;
    // private static boolean movePlayerTwo = true;

    public GamePanel () {
        addKeyListener(new KeyboardInputs(this));
        setBackground(gamePanelColor);
    }

    public void changeYDelta (int value, int playerNum) {
        if (playerNum == 1) {
            pOneYDelta += value;
        } else {
            pTwoYDelta += value;
        }
        repaint();
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(paddleColor);
        // g.fillRect(100, 200, paddleWidth, paddleHeight);
        //Move Player One's Paddle
        g.fillRect(pOneXDelta, pOneYDelta, paddleWidth, paddleHeight);
        g.fillRect(pTwoXDelta, pTwoYDelta, paddleWidth, paddleHeight);
        
    }
    
}
