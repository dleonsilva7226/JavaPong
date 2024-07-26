package main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;

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
    

    public void paintComponent (Graphics g) {
        if (!GamePanel.isPaused) {
            super.paintComponent(g);
            g.setColor(Constants.paddleColor);
            //Move Player One's Paddle
            g.fillRect((int)paddleOne.getXDelta(), (int)paddleOne.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
            //Move Player Two's Paddle
            g.fillRect((int)paddleTwo.getXDelta(), (int)paddleTwo.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
        } else {
            g.drawImage(Screens.PAUSE_SCREEN, 0, 0, null);
        }
    }

    public void updatePaddleYPos() {
        paddleOne.changeYDelta(paddleOne.getPaddleYVel());
        paddleTwo.changeYDelta(paddleTwo.getPaddleYVel());
    }


    public void updateGame() {
        GameWindow currWindow = Game.gameWindow;
        JFrame currJFrame = currWindow.getJFrame();
        startGame(currWindow, currJFrame);
        pauseGame(currWindow, currJFrame);
        endGame(currWindow, currJFrame);
        // if (!GamePanel.isPaused) {
        //     if (currJFrame.getTitle().equals(Constants.PAUSE_TITLE)) {
        //         currWindow.setUnpauseTitle();
        //     }
        //     updatePaddleYPos();
        //     return;
        // } 
        // currWindow.setPauseTitle();

    }

    private void startGame(GameWindow currWindow, JFrame currJFrame) {

    }

    private void pauseGame(GameWindow currWindow, JFrame currJFrame) {
        if (!GamePanel.isPaused) {
            if (currJFrame.getTitle().equals(Constants.PAUSE_TITLE)) {
                currWindow.setUnpauseTitle();
            }
            updatePaddleYPos();
            return;
        } 
        currWindow.setPauseTitle();
    }

    private void endGame(GameWindow currWindow, JFrame currJFrame) {
        
    }
}
