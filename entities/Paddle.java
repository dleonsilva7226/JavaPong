package entities;

import java.awt.Color;
import utilz.*;
import main.*;

public class Paddle {
    //Location of Paddle
    private float paddleXDelta = 0;
    private float paddleYDelta = 0;
    
    
    public Paddle (int playerNum) {
        if (playerNum == 1) {
            this.paddleXDelta = Constants.paddleOneXStart;
            this.paddleYDelta = Constants.paddleOneYStart;
        } else {
            this.paddleXDelta = Constants.paddleTwoXStart;
            this.paddleYDelta = Constants.paddleTwoYStart;
        }
    }

    //Incorporate Collision Detection so that Paddle Does not Go Too Up or Too Down
    public void setYDelta(float yDelta) {
        if (yDelta >= 0 && yDelta + Constants.paddleHeight + 20 < GameWindow.screenHeight) {
            this.paddleYDelta = yDelta;
        } else if (yDelta < 0){
            this.paddleYDelta = 5;
        }
        //DRAW LINE TO TEST THE BOTTOM EDGE OF THE GAME
        //ACCOUNT FOR BOTTOM COLLISION IF IT BECOMES A PROBLEM
    }

    public float getXDelta() {
        return this.paddleXDelta;
    }

    public float getYDelta() {
        return this.paddleYDelta;
    }
    
    public int getWidth () {
        return Constants.paddleWidth;
    }

    public int getHeight () {
        return Constants.paddleHeight;
    }

    public Color getPaddleColor() {
        return Constants.paddleColor;
    }
}