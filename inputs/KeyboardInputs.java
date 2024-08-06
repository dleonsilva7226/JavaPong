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

    //START, PAUSE, END BUTTONS
    protected final static int pauseKey = KeyEvent.VK_P;
    protected final static int startKey = KeyEvent.VK_SPACE;

    public KeyboardInputs (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.paddleOneRef = gamePanel.paddleOne;
        this.paddleTwoRef = gamePanel.paddleTwo;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //NOTHING NEEDED HERE FOR NOW
    }

    //Check Over Here if the !GamePanel.gameOver if statement in here is causing a bug
    @Override
    public void keyPressed(KeyEvent e) {
        if (!GamePanel.gameOver) {
            switch (e.getKeyCode()) {
                case startKey:
                    if (!GamePanel.gameStarted && !GamePanel.gameOver) {
                        GamePanel.gameStarted = true;
                    } 
                    break;
                case pauseKey:
                    if (GamePanel.isPaused) {
                        GamePanel.isPaused = false;
                    } else {
                        GamePanel.isPaused = true;
                    }
                    break;
                case playerOnePaddleUp:
                    this.paddleOneRef.setPaddleYVel(-4);
                    break;
                case playerOnePaddleDown:
                    this.paddleOneRef.setPaddleYVel(4);   
                    break;
                case playerTwoPaddleUp:
                    this.paddleTwoRef.setPaddleYVel(-4);
                    break;
                case playerTwoPaddleDown:
                    
                    this.paddleTwoRef.setPaddleYVel(4);
                    break;
            }
        }
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }


    //Check Over Here if the !GamePanel.gameOver if statement in here is causing a bug
    @Override
    public void keyReleased(KeyEvent e) {
        if (!GamePanel.gameOver) {
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
        }
        System.out.println("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }
    
}
