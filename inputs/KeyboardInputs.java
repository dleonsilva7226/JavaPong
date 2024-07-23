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
        //ATTEMPTING TO GET SMOOTHER MOVEMENT OF THE PADDLES
        switch (e.getKeyCode()) {
            case playerOnePaddleUp:
                this.paddleOneRef.setYDelta(paddleOneRef.getYDelta() - 10);
                // gamePanel.setVelY(5);
                break;
            case playerOnePaddleDown:
                this.paddleOneRef.setYDelta(paddleOneRef.getYDelta() + 10);
                // gamePanel.setVelY(5);
                break;
            case playerTwoPaddleUp:
                this.paddleTwoRef.setYDelta(paddleTwoRef.getYDelta() - 10);
                // gamePanel.setVelY(5);
                break;
            case playerTwoPaddleDown:
                this.paddleTwoRef.setYDelta(paddleTwoRef.getYDelta() + 10);
                // gamePanel.setVelY(5);
                break;
        }
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
}
