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
    public Paddle paddleOne = new Paddle(1); //Player One
    public Paddle paddleTwo = new Paddle(2); //Player Two

    //Ball
    public Ball pongBall = new Ball();

    //Panel Color
    private static Color gamePanelColor = Color.BLACK;

    //Game Paused Status
    public static boolean isPaused = false;
    public static boolean gameStarted = false;
    public static boolean gameOver = false;
    public static boolean restartedGame = false;
    public static int pointsToWin = 10;

    
    public GamePanel () {
        addKeyListener(new KeyboardInputs(this));
        setBackground(gamePanelColor);
        setPanelSize();
    }

    private void setPanelSize () {
        Dimension size = new Dimension(GameWindow.screenWidth, GameWindow.screenHeight);
        setPreferredSize(size);
    }
    
    public void paintComponent (Graphics g) {
        render(g);
    }

    private void render(Graphics g) {
        GameWindow currWindow = Game.gameWindow;
        JFrame currJFrame = currWindow.getJFrame();
        gameNotStarted(g, currWindow, currJFrame);
        currentlyPlaying(g, currWindow, currJFrame);
        currentlyPaused(g, currWindow, currJFrame);
        gameOver(g, currWindow, currJFrame);
    }

    private void gameOver(Graphics g, GameWindow currWindow, JFrame currJFrame) {
        if (GamePanel.gameOver) {
            if (paddleOne.getPlayerScore() == pointsToWin) {
                currWindow.setPaddleOneWinTitle();
                g.drawImage(Screens.P1_WIN_SCREEN, 0, 0, null);
                return;
            } else if (paddleTwo.getPlayerScore() == pointsToWin){
                currWindow.setPaddleTwoWinTitle();
                g.drawImage(Screens.P2_WIN_SCREEN, 0, 0, null);
            }
        }
    }

    public void gameNotStarted(Graphics g, GameWindow currWindow, JFrame currJFrame) {
        if (!GamePanel.gameStarted) {
            // currWindow.setTitle();
            g.drawImage(Screens.START_SCREEN, 0, 0, null);    
        }

    }

    public void currentlyPaused(Graphics g, GameWindow currWindow, JFrame currJFrame) {
        if (GamePanel.isPaused) {
            g.drawImage(Screens.PAUSE_SCREEN, 0, 0, null);
            currWindow.setPauseTitle();
        }
    }

    public void currentlyPlaying (Graphics g, GameWindow currWindow, JFrame currJFrame) {
        if (GamePanel.gameStarted && !GamePanel.isPaused && !GamePanel.gameOver) {
            currWindow.setPlayingTitle(paddleOne.getPlayerScore(), paddleTwo.getPlayerScore());
            super.paintComponent(g);
            g.setColor(Constants.paddleColor);
            //Move Player One's Paddle
            g.fillRect((int)paddleOne.getXDelta(), (int)paddleOne.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
            //Move Player Two's Paddle
            g.fillRect((int)paddleTwo.getXDelta(), (int)paddleTwo.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
            //Move Pong Ball
            g.fillOval((int) pongBall.getXDelta(), (int) pongBall.getYDelta(), Constants.ballWidth, Constants.ballHeight);
        }
    }

    public void updatePaddleYPos() {
        paddleOne.changeYDelta(paddleOne.getPaddleYVel());
        paddleTwo.changeYDelta(paddleTwo.getPaddleYVel());
    }

    private void updateBallPos(boolean ballIsCollidingX, boolean ballIsCollidingY) {
        pongBall.changeXDelta(pongBall.getBallXVel(), ballIsCollidingX);
        pongBall.changeYDelta(pongBall.getBallYVel(), ballIsCollidingY);
    }


    public void updateGame() {
        GameWindow currWindow = Game.gameWindow;
        JFrame currJFrame = currWindow.getJFrame();
        updateGameState(currWindow, currJFrame);
    }

    private void updateGameState(GameWindow currWindow, JFrame currJFrame) {
        if (!GamePanel.isPaused) {
            updatePaddleYPos();
            boolean ballIsCollidingX = xIsColliding(pongBall, pongBall.getBallXVel(), pongBall.getBallYVel());
            boolean ballIsCollidingY = yIsColliding(pongBall, pongBall.getBallXVel(), pongBall.getBallYVel());
            updateBallPos(ballIsCollidingX, ballIsCollidingY);
            if (pongBall.getXDelta() <= 0) {
                currWindow.setScore(paddleTwo);
                restart(2);
            } else if (pongBall.getXDelta() >= GameWindow.screenWidth) {
                currWindow.setScore(paddleOne);
                restart(1);
            }
        } 
    }

    private void restart(int playerPoint) {
        //Have a function that restarts the game once the player gets a point
        // GamePanel.restartedGame = true;
        // paddleOne.setXDelta(Constants.paddleOneXStart);
        // paddleOne.setYDelta(Constants.paddleOneYStart);
        // paddleTwo.setXDelta(Constants.paddleTwoXStart);
        // paddleTwo.setYDelta(Constants.paddleTwoYStart);
        pongBall.setXDelta(Constants.ballXStart);
        pongBall.setYDelta(Constants.ballYStart);
        if (playerPoint == 1)
            pongBall.setBallXVel(1);
        else {
            pongBall.setBallXVel(-1);   
        }
        // GamePanel.isPaused = true;
    }

    //Collision Detection. MAKE IT BETTER AND MORE ROBUST. FIX THE ERRORS FOR THE Y PART
    public boolean xIsColliding (Ball pongBall, float xVel, float yVel) {
        if (pongBall.getXDelta() + xVel < paddleOne.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() >= paddleOne.getYDelta() && pongBall.getYDelta() <= paddleOne.getYDelta() + Constants.paddleHeight) {
                return true;
            }
            
        } else if (pongBall.getXDelta() + xVel > paddleTwo.getXDelta()) {
            if (pongBall.getYDelta() >= paddleTwo.getYDelta() && pongBall.getYDelta() <= paddleTwo.getYDelta() + Constants.paddleHeight) {
                return true;
            }  
        } 
        // else if (pongBall.getYDelta() - pongBall.getHeight() <= 0) {
        //     return true;
        // } else if (pongBall.getYDelta() + pongBall.getHeight() >= GameWindow.screenHeight) {
        //     return true;
        // }
        return false;
    }

    public boolean yIsColliding (Ball pongBall, float xVel, float yVel) {
        if (pongBall.getYDelta() - pongBall.getHeight() <= 0) {
            return true;
        } else if (pongBall.getYDelta() + pongBall.getHeight() >= GameWindow.screenHeight) {
            return true;
        }
        return false;
    }




}
