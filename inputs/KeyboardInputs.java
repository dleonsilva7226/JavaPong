package inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

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

    public KeyboardInputs (GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case playerOnePaddleUp:
                gamePanel.changeYDelta(-15, 1);
                break;
            case playerOnePaddleDown:
                gamePanel.changeYDelta(15, 1);
                break;
            case playerTwoPaddleUp:
                gamePanel.changeYDelta(-15, 2);
                break;
            case playerTwoPaddleDown:
                gamePanel.changeYDelta(15, 2);
                break;
        }
        System.out.println("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
    
}
