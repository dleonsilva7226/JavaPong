package utilz;

import java.awt.Color;

import main.GameWindow;

public class Constants {

    //----------TITLE VARIABLES----------\\
    //Currently Playing Title
    public static String playingTitle = "P1 Score: " + GameWindow.playerOneScore + "                    P2 Score: " + GameWindow.playerTwoScore;

    //Paused Title
    public final static String PAUSE_TITLE = "Game is Paused!";

    //Start Title
    public final static String START_TITLE = "Welcome to JPong!";

    //Lost Game Title
    public final static String LOST_TITLE = "Game Over! You Lose!";

    //Won Game Title
    public final static String WON_TITLE = "Congratulations! You Win!";

    //----------END OF TITLE VARIABLES----------\\

    

    //----------PADDLE VARIABLES----------\\
    //Dimensions and the Color of the Pong Paddles
    public final static int paddleHeight = 80;
    public final static int paddleWidth = 10;
    public final static Color paddleColor = Color.WHITE;

    //Starting Location of the PlayerOne Paddle
    public static final float paddleOneXStart = 20;
    public static final float paddleOneYStart = 300 - paddleHeight;
    
    //Starting Location of the PlayerTwo Paddle
    public static final float paddleTwoXStart = 880 - paddleWidth;
    public static final float paddleTwoYStart = 300 - paddleHeight;

    //----------END OF PADDLE VARIABLES----------\\






    //----------BALL VARIABLES----------\\

    //MODIFY THE VARIABLES ENTIRELY

    //Dimensions and the Color of the Pong Paddles
    public final static int ballHeight = 10;
    public final static int ballWidth = 10;
    public final static Color ballColor = Color.WHITE;

    //Starting Location of the Ball 
    public static final float ballXStart = 450;
    public static final float ballYStart = 300;

    
    //----------END OF BALL VARIABLES----------\\
}
