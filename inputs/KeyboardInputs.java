package inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import entities.*;

import main.Game;
import main.GamePanel;

//Work on getting this keyboard inputs to work
public class KeyboardInputs implements KeyListener{

    //GamePanel of the Pong Game
    private GamePanel gamePanel;

    //PLAYER ONE KEYBOARD INPUT
    protected final static int playerOnePaddleUp = KeyEvent.VK_W;
    protected final static int playerOnePaddleDown = KeyEvent.VK_S;

    //PLAYER TWO KEYBOARD INPUT
    protected final static int playerTwoPaddleUp = KeyEvent.VK_UP;
    protected final static int playerTwoPaddleDown = KeyEvent.VK_DOWN;

    //PLAYER ID'S
    protected final static int playerOneID = 1;
    protected final static int playerTwoID = 2;

    //PADDLE REFERENCES FROM GAME PANEL
    public Paddle paddleOneRef;
    public Paddle paddleTwoRef;

    //CURRENT YVELOCITY OF PADDLE
    // public float velY;

    //PAUSE AND UNPAUSE BUTTON
    protected final static int pauseKey = KeyEvent.VK_P;

    //MOST RECENT PADDLE ONE AND PADDLE TWO VELOCITIES
    private float recPOneYVel = 0;
    private float recPTwoYVel = 0;

    public KeyboardInputs (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.paddleOneRef = gamePanel.paddleOne;
        this.paddleTwoRef = gamePanel.paddleTwo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case pauseKey:
                if (GamePanel.isPaused) {
                    GamePanel.isPaused = false;
                } else {
                    GamePanel.isPaused = true;
                }
                break;
            case playerOnePaddleUp:
                if (!GamePanel.isPaused) {
                    this.paddleOneRef.setPaddleYVel(-5);
                }
                break;
            case playerOnePaddleDown:
                if (!GamePanel.isPaused) {
                    this.paddleOneRef.setPaddleYVel(5);
                } 
                break;
            case playerTwoPaddleUp:
                if (!GamePanel.isPaused) {
                    this.paddleTwoRef.setPaddleYVel(-5);
                }
                break;
            case playerTwoPaddleDown:
                if (!GamePanel.isPaused) {
                    this.paddleTwoRef.setPaddleYVel(5);
                }
                break;
        }
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case playerOnePaddleUp:
                this.paddleOneRef.setPaddleYVel(0);
                break;
            case playerOnePaddleDown:
                this.paddleOneRef.setPaddleYVel(0);
                break;
            case playerTwoPaddleUp:
                this.paddleTwoRef.setPaddleYVel(0);
                break;
            case playerTwoPaddleDown:
                this.paddleTwoRef.setPaddleYVel(0);
                break;
        }
        System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }
    
}
