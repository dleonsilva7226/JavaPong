package main;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import entities.Paddle;

import javax.swing.JPanel;
import inputs.KeyboardInputs;
import utilz.Constants;

public class GamePanel extends JPanel {
    //Paddles
    public Paddle paddleOne = new Paddle(1);
    public Paddle paddleTwo = new Paddle(2);

    //Panel Color
    private static Color gamePanelColor = Color.BLACK;

    //FPS Counter
    private static int frames = 0;
    private static long lastCheck = 0;

    //Y Direction
    private float yDir = 1f;

    //Velocity for Y Variable- FOR SMOOTHER MOVEMENT OF PADDLES AND BALL
    public static float velY = 0;


    public GamePanel () {
        addKeyListener(new KeyboardInputs(this));
        setBackground(gamePanelColor);
    }

    // GET RID OF THE STUFF BELOW
    // public void changeYDelta (int value, int playerNum) {
    //     float pOneUpMovementTotal = pOneYDelta + value;
    //     float pOneDownMovementTotal = pOneYDelta + GamePanel.paddleHeight + value;
    //     float pTwoUpMovementTotal = pTwoYDelta + value;
    //     float pTwoDownMovementTotal = pTwoYDelta + GamePanel.paddleHeight + value;
    //     boolean pOneCanMove = (pOneUpMovementTotal >= 0);
    //     boolean pTwoCanMove = (pTwoUpMovementTotal >= 0);
    //     if (value >= 0) {
    //         pOneCanMove = (pOneDownMovementTotal < GameWindow.screenHeight - 29);
    //         pTwoCanMove = (pTwoDownMovementTotal < GameWindow.screenHeight - 29);
    //     }
        
        
    //     if (playerNum == 1) {
    //         if (pOneCanMove) {
    //             pOneYDelta += value;
    //         }
    //     } else {
    //         if (pTwoCanMove) {
    //             pTwoYDelta += value;
    //         }
    //     }
    // }

    // public void setYPos (float newYDelta, int playerNum) {
    //     if (playerNum == 1) {
    //         GamePanel.pOneYDelta = newYDelta;
    //     } else {
    //         GamePanel.pTwoYDelta = newYDelta;
    //     }
    // }

    // GET RID OF THE STUFF ON TOP


    //USE THIS FOR SMOOTHER PADDLE MOVING
    // public void setVelY (float velY) {
    //     GamePanel.velY = velY;
    // }

    

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Constants.paddleColor);
        //Move Player One's Paddle
        g.fillRect((int)paddleOne.getXDelta(), (int)paddleOne.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
        //Move Player Two's Paddle
        g.fillRect((int)paddleTwo.getXDelta(), (int)paddleTwo.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
    }

    public Paddle getPaddleOne () {
        return this.paddleOne;
    }

    public Paddle getPaddleTwo () {
        return this.paddleTwo;
    }


    
}
