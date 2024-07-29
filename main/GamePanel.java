package main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;

import entities.Ball;
import entities.Paddle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import utilz.Constants;
import utilz.Screens;

public class GamePanel extends JPanel {
    //Paddles
    public Paddle paddleOne = new Paddle(1);
    public Paddle paddleTwo = new Paddle(2);

    //Ball
    public Ball pongBall = new Ball();

    //Panel Color
    private static Color gamePanelColor = Color.BLACK;

    //Game Paused Status
    public static boolean isPaused = false;
    public static boolean gameStarted = false;
    public static boolean gameOver = false;
    
    public GamePanel () {
        addKeyListener(new KeyboardInputs(this));
        setBackground(gamePanelColor);
        setPanelSize();
    }

    private void setPanelSize () {
        Dimension size = new Dimension(GameWindow.screenWidth, GameWindow.screenHeight);
        setPreferredSize(size);
    }
    
    //Have a Render Function Here to Not Draw Everything in this PaintComponent Function
    public void paintComponent (Graphics g) {
        if (!GamePanel.gameStarted) {
            g.drawImage(Screens.START_SCREEN, 0, 0, null);
        } else if (!GamePanel.isPaused) {
            super.paintComponent(g);
            g.setColor(Constants.paddleColor);
            
            //Move Player One's Paddle
            g.fillRect((int)paddleOne.getXDelta(), (int)paddleOne.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
            //Move Player Two's Paddle
            g.fillRect((int)paddleTwo.getXDelta(), (int)paddleTwo.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
            //Move Pong Ball
            g.fillOval((int) pongBall.getXDelta(), (int) pongBall.getYDelta(), Constants.ballWidth, Constants.ballHeight);
        } else {
            g.drawImage(Screens.PAUSE_SCREEN, 0, 0, null);
        }
    }

    public void updatePaddleYPos() {
        paddleOne.changeYDelta(paddleOne.getPaddleYVel());
        paddleTwo.changeYDelta(paddleTwo.getPaddleYVel());
    }

    private void updateBallPos(boolean ballIsColliding) {
        pongBall.changeXDelta(pongBall.getBallXVel(), ballIsColliding);

        //FIX THE ERRORS FOR THE Y COORDINATES OF THE BALL
        // pongBall.changeYDelta(pongBall.getBallYVel(), ballIsColliding);
    }


    public void updateGame() {
        GameWindow currWindow = Game.gameWindow;
        JFrame currJFrame = currWindow.getJFrame();
        startGame(currWindow, currJFrame);
        pauseGame(currWindow, currJFrame);
        endGame(currWindow, currJFrame);
    }

    private void startGame(GameWindow currWindow, JFrame currJFrame) {
        if (GamePanel.gameStarted) {
            currWindow.setPlayingTitle();    
        } 
    }

    private void pauseGame(GameWindow currWindow, JFrame currJFrame) {
        if (!GamePanel.isPaused) {
            if (currJFrame.getTitle().equals(Constants.PAUSE_TITLE)) {
                currWindow.setPlayingTitle();
            }
            updatePaddleYPos();
            boolean ballIsColliding = isColliding(pongBall, pongBall.getBallXVel(), pongBall.getBallYVel());
            updateBallPos(ballIsColliding);

            return;
            
        } 
        currWindow.setPauseTitle();
        
    }

    //Collision Detection. MAKE IT BETTER AND MORE ROBUST. FIX THE ERRORS FOR THE Y PART
    public boolean isColliding (Ball pongBall, float xVel, float yVel) {
        if (pongBall.getXDelta() + xVel < paddleOne.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() >= paddleOne.getYDelta() && pongBall.getYDelta() <= paddleOne.getYDelta() + Constants.paddleHeight) {
                return true;
            }
            
        } else if (pongBall.getXDelta() + xVel > paddleTwo.getXDelta()) {
            if (pongBall.getYDelta() >= paddleTwo.getYDelta() && pongBall.getYDelta() <= paddleTwo.getYDelta() + Constants.paddleHeight) {
                return true;
            }  
        } else if (pongBall.getYDelta() <= 0) {
            return true;
        } else if (pongBall.getYDelta() >= GameWindow.screenHeight) {
            return true;
        }
        return false;
    }

    

    private void endGame(GameWindow currWindow, JFrame currJFrame) {
        
    }
}
