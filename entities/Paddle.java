package entities;

import java.awt.Color;
import utilz.*;
import main.*;

public class Paddle {
    //Location of Paddle
    private float paddleXDelta = 0;
    private float paddleYDelta = 0;
    private float paddleYVel;
    public int playerNum;
    public int playerScore;
    
    
    
    public Paddle (int playerNum) {
        if (playerNum == 1) {
            this.paddleXDelta = Constants.paddleOneXStart;
            this.paddleYDelta = Constants.paddleOneYStart;
        } else {
            this.paddleXDelta = Constants.paddleTwoXStart;
            this.paddleYDelta = Constants.paddleTwoYStart;
        }
        this.playerNum = playerNum;
        this.paddleYVel = 0;
        this.playerScore = 0;
    }


    public void changeYDelta (float yVel) {
        if (this.paddleYDelta + yVel >= 0 && this.paddleYDelta + yVel + Constants.paddleHeight < GameWindow.screenHeight) {
            this.paddleYDelta += yVel;
        } else if (yVel + this.paddleYDelta < 0){
            this.paddleYDelta = 5;
        } else {
            this.paddleYDelta = GameWindow.screenHeight - Constants.paddleHeight - 5;
        }
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

    public float getPaddleYVel () {
        return this.paddleYVel;
    }

    public int getPlayerNum () {
        return this.playerNum;
    }

    public int getPlayerScore () {
        return this.playerScore;
    }

    public void setPaddleYVel (float newYVel) {
        this.paddleYVel = newYVel;
    }
    
    public void addPoint() {
        playerScore++;
        checkIfGameOver();
    }

    public void checkIfGameOver() {
        if (playerScore == GamePanel.pointsToWin) {
            GamePanel.gameOver = true;
        }
    } 

    public void setXDelta(float newVal) {
        this.paddleXDelta = newVal;
    }
    public void setYDelta(float newVal) {
        this.paddleYDelta = newVal;
    }
    
}