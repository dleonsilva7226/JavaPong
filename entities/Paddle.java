package entities;

import java.awt.Color;
import utilz.*;

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

    public void setYDelta(float yDelta) {
        this.paddleYDelta = yDelta;
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