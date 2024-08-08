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

    private void updateBallPos(boolean ballIsCollidingWithPaddle, boolean ballIsCollidingWithFloor) {
        pongBall.changeXDelta(pongBall.getBallXVel(), ballIsCollidingWithPaddle);
        pongBall.changeYDelta(pongBall.getBallYVel(), ballIsCollidingWithFloor);
    }


    public void updateGame() {
        GameWindow currWindow = Game.gameWindow;
        JFrame currJFrame = currWindow.getJFrame();
        updateGameState(currWindow, currJFrame);
    }

    private void updateGameState(GameWindow currWindow, JFrame currJFrame) {
        if (!GamePanel.isPaused) {
            updatePaddleYPos();
            boolean ballIsCollidingWithPaddle = isCollidingWithPaddle(pongBall, pongBall.getBallXVel(), pongBall.getBallYVel());
            boolean ballIsCollidingWithFloor = isCollidingWithFloor(pongBall, pongBall.getBallXVel(), pongBall.getBallYVel());
            updateBallPos(ballIsCollidingWithPaddle, ballIsCollidingWithFloor);
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
        pongBall.setXDelta(Constants.ballXStart);
        pongBall.setYDelta(Constants.ballYStart);
        if (playerPoint == 1)
            pongBall.setBallXVel(1);
        else {
            pongBall.setBallXVel(-1);   
        }
    }

    //ERRORS:
    //COLLISION BUG WITH THE BALL GOING THROUGH PADDLES. LOOK AT ERROR. 
    //TRY ADDING AND SUBTRACTING BALL HEIGHT TO SEE IF THAT MAKES A DIFFERENCE
    //USE PRINT STATEMENTS IN COLLISION TO DEBUG.
    public boolean isCollidingWithPaddle (Ball pongBall, float xVel, float yVel) {
        //PADDLE ONE COLLISION CHECKS BELOW
        //Checking if Ball Is Colliding with the Right Side of Paddle One
        if (pongBall.getXDelta() + xVel < paddleOne.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() >= paddleOne.getYDelta() && pongBall.getYDelta() <= paddleOne.getYDelta() + Constants.paddleHeight) {
                return true;
            }
        }
        //Checking if Ball Is Colliding with the Left Side of Paddle One
        else if (pongBall.getXDelta() + xVel > paddleOne.getXDelta() && pongBall.getXDelta() + xVel < paddleOne.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() >= paddleOne.getYDelta() && pongBall.getYDelta() <= paddleOne.getYDelta() + Constants.paddleHeight) {
                return true;
            }
        }
        //Checking if Ball is Colliding with the Top Side of Paddle One
        else if (pongBall.getXDelta() + xVel >= paddleOne.getXDelta() && pongBall.getXDelta() + xVel <= paddleOne.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() + yVel + pongBall.getHeight() >= paddleOne.getYDelta()) {
                return true;
            }
        }
        //Checking if Ball is Colliding with the Bottom Side of Paddle One
        else if (pongBall.getXDelta() + xVel >= paddleOne.getXDelta() && pongBall.getXDelta() + xVel <= paddleOne.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() - pongBall.getHeight() + yVel <= paddleOne.getYDelta() + Constants.paddleHeight) {
                return true;
            }
        }


        //PADDLE TWO COLLISION CHECKS BELOW
        //Checking if Ball is Colliding with the Left Side of Paddle Two
        if (pongBall.getXDelta() + xVel > paddleTwo.getXDelta()) {
            if (pongBall.getYDelta() >= paddleTwo.getYDelta() && pongBall.getYDelta() <= paddleTwo.getYDelta() + Constants.paddleHeight) {
                return true;
            }  
        }
        //Checking if Ball is Colliding with the Right Side of Paddle Two 
        else if (pongBall.getXDelta() + xVel < paddleTwo.getXDelta() + Constants.paddleWidth && pongBall.getXDelta() + xVel > paddleTwo.getXDelta()) {
            if (pongBall.getYDelta() >= paddleTwo.getYDelta() && pongBall.getYDelta() <= paddleTwo.getYDelta() + Constants.paddleHeight) {
                return true;
            }  
        }
        //Checking if Ball is Colliding with the Top Side of Paddle Two
        else if (pongBall.getXDelta() + xVel >= paddleTwo.getXDelta() && pongBall.getXDelta() + xVel <= pongBall.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() + yVel + pongBall.getHeight() >= paddleTwo.getYDelta()) {
                return true;
            }
        }
        //Checking if Ball is Colliding with the Bottom Side of Paddle Two
        else if (pongBall.getXDelta() + xVel >= paddleTwo.getXDelta() && pongBall.getXDelta() + xVel <= pongBall.getXDelta() + Constants.paddleWidth) {
            if (pongBall.getYDelta() + yVel - pongBall.getHeight() <= paddleTwo.getYDelta() + Constants.paddleHeight) {
                return true;
            }
        }

        return false;
    }


    //Have Paddle Collision Here Also
    public boolean isCollidingWithFloor (Ball pongBall, float xVel, float yVel) {
        if (pongBall.getYDelta() - pongBall.getHeight() <= 0) {
            return true;
        } else if (pongBall.getYDelta() + pongBall.getHeight() >= GameWindow.screenHeight) {
            return true;
        }
        return false;
    }
}
