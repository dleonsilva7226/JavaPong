package main;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

import javax.swing.JPanel;

import inputs.KeyboardInputs;

public class GamePanel extends JPanel {
    private static int paddleHeight = 70;
    private static int paddleWidth = 10;
    private static Color paddleColor = Color.WHITE;

    //Initial Location of Player One
    private static int playerOneXLocation = 10;
    private static int playerOneYLocation = 10;

    //Initial Location of Player Two
    private static int playerTwoXLocation = 890 - paddleWidth;
    private static int playerTwoYLocation = 10;

    //Panel Color
    private static Color gamePanelColor = Color.BLACK;

    public GamePanel () {
        //addKeyListener(new KeyboardInputs());
        this.setBackground(gamePanelColor);
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        // g.fillRect(100, 200, paddleWidth, paddleHeight);
        g.fillRect(playerOneXLocation, playerOneYLocation, paddleWidth, paddleHeight);
        g.fillRect(playerTwoXLocation, playerTwoYLocation, paddleWidth, paddleHeight);
        
    }
    
}
