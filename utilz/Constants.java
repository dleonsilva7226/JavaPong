package utilz;

import java.awt.Color;

public class Constants {

    //----------PADDLE VARIABLES----------\\
    //Dimensions and the Color of the Pong Paddles
    public final static int paddleHeight = 70;
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
    private final static int ballHeight = 70;
    private final static int ballWidth = 10;
    private final static Color ballColor = Color.WHITE;

    //Starting Location of the Ball 
    public static final float ballXStart = 20;
    public static final float ballYStart = 300 - paddleHeight;

    
    //----------END OF BALL VARIABLES----------\\
}
