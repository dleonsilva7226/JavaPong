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
    private static float pOneXDelta = 20;
    private static float pOneYDelta = 300 - paddleHeight;

    //Initial Location of Player Two
    private static float pTwoXDelta = 880 - paddleWidth;
    private static float pTwoYDelta = 300 - paddleHeight;

    //Panel Color
    private static Color gamePanelColor = Color.BLACK;

    //FPS Counter
    private static int frames = 0;
    private static long lastCheck = 0;


    //Y Direction
    private float yDir = 1f;

    // //Booleans to see which Specific Paddle to Move
    // private static boolean movePlayerOne = true;
    // private static boolean movePlayerTwo = true;

    public GamePanel () {
        addKeyListener(new KeyboardInputs(this));
        setBackground(gamePanelColor);
    }

    public void changeYDelta (int value, int playerNum) {
        float pOneUpMovementTotal = pOneYDelta + value;
        float pOneDownMovementTotal = pOneYDelta + GamePanel.paddleHeight + value;
        float pTwoUpMovementTotal = pTwoYDelta + value;
        float pTwoDownMovementTotal = pTwoYDelta + GamePanel.paddleHeight + value;
        boolean pOneCanMove = (pOneUpMovementTotal >= 0);
        boolean pTwoCanMove = (pTwoUpMovementTotal >= 0);
        if (value >= 0) {
            pOneCanMove = (pOneDownMovementTotal < GameWindow.screenHeight - 29);
            pTwoCanMove = (pTwoDownMovementTotal < GameWindow.screenHeight - 29);
        }
        
        
        if (playerNum == 1) {
            if (pOneCanMove) {
                pOneYDelta += value;
            }
        } else {
            if (pTwoCanMove) {
                pTwoYDelta += value;
            }
        }
    }

    public void setYPos (float newYDelta, int playerNum) {
        if (playerNum == 1) {
            GamePanel.pOneYDelta = newYDelta;
        } else {
            GamePanel.pTwoYDelta = newYDelta;
        }
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(paddleColor);
        //Move Player One's Paddle
        g.fillRect((int)pOneXDelta, (int)pOneYDelta, paddleWidth, paddleHeight);
        //Move Player Two's Paddle
        g.fillRect((int)pTwoXDelta, (int)pTwoYDelta, paddleWidth, paddleHeight);
    }
    
}
