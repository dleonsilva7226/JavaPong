package main;
import javax.swing.*;
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

    public GameWindow (GamePanel gamePanel) {
        jFrame = new JFrame();

        jFrame.setTitle("PlayerOne Score <INSERT-NUM>, PlayerTwo Score<INSERT-NUM>");
        jFrame.setSize(screenWidth, screenHeight);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.pack();
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    // public int getWindowWidth() {
    //     return GameWindow.screenWidth;
    // }

    // public int getWindowHeight() {
    //     return GameWindow.screenHeight;
    // }
}
