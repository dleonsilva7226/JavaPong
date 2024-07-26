package main;
import javax.swing.*;

import utilz.Constants;
import utilz.Screens;

import java.awt.Image;
import java.awt.event.*;
public class GameWindow {

    //JFrame for the whole JPong Game Screen
    private JFrame jFrame;

    //SCREEN HEIGHT DEFINED HERE
    public final static int screenWidth = 900;
    public final static int screenHeight = 600;

    //PLAYER ONE KEYBOARD INPUT
    protected final static int playerOnePaddleUp = KeyEvent.VK_W;
    protected final static int playerOnePaddleDown = KeyEvent.VK_S;

    //PLAYER TWO KEYBOARD INPUT
    protected final static int playerTwoPaddleUp = KeyEvent.VK_UP;
    protected final static int playerTwoPaddleDown = KeyEvent.VK_DOWN;

    //PLAYER SCORES 
    public static int playerOneScore = 0;
    public static int playerTwoScore = 0;

    public GameWindow (GamePanel gamePanel) {
        jFrame = new JFrame();
        jFrame.setTitle(Constants.START_TITLE);
        jFrame.setSize(screenWidth, screenHeight);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.pack();
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    public void setPauseTitle () {
        jFrame.setTitle(Constants.PAUSE_TITLE);
    }

    public void setPlayingTitle() {
        jFrame.setTitle(Constants.playingTitle);
    }
    
    public int getWindowWidth() {
        return screenWidth;
    }

    public int getWindowHeight() {
        return screenHeight;
    }

    public JFrame getJFrame() {
        return this.jFrame;
    }

    public String getPlayingTitle() {
        return Constants.playingTitle;
    }
    
    public String getPauseTitle() {
        return Constants.PAUSE_TITLE;
    }

    public String getStartTitle() {
        return Constants.START_TITLE;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }
    
    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

}
