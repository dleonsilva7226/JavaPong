package main;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;

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
        super.paintComponent(g);
        g.setColor(Constants.paddleColor);
        //Move Player One's Paddle
        g.fillRect((int)paddleOne.getXDelta(), (int)paddleOne.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
        //Move Player Two's Paddle
        g.fillRect((int)paddleTwo.getXDelta(), (int)paddleTwo.getYDelta(), Constants.paddleWidth, Constants.paddleHeight);
    }

    public void updatePaddleYPos() {
        paddleOne.changeYDelta(paddleOne.getPaddleYVel());
        paddleTwo.changeYDelta(paddleTwo.getPaddleYVel());
    }
}
