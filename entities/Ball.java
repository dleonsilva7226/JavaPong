package entities;

import java.awt.Color;
import java.util.Random;

import utilz.*;
import main.*;

public class Ball {
    
    //Location of Paddle
    private float ballXDelta;
    private float ballYDelta;
    private float ballXVel;
    private float ballYVel;
    private float[] xVels = {-3, 3};
    private float[] yVels = {-3, 3};
    private float[] initVels = {-1, 1};
    private Random randomVelChooser;
    
    
    public Ball () {
        this.ballXDelta = Constants.ballXStart;
        this.ballYDelta = Constants.ballYStart;
        this.randomVelChooser = new Random();
        int randomNum = randomVelChooser.nextInt(2);
        this.ballXVel = initVels[randomNum];
        this.ballYVel = initVels[randomNum];
    }


    //Collision Bug: When moving the paddle and the ball goes over the paddle,
    //with the right timing, the ball can still come back and deflect to the
    //screen. Another bug: Ball will sometimes stop when going past paddle.
    public void changeXDelta (float xVel, boolean isColliding) {
        // if (ballXDelta + xVel >= 0 && ballXDelta + xVel + Constants.ballWidth < GameWindow.screenWidth) {
        //     this.ballXDelta += xVel;
        // } 
        
        if (isColliding){
            if (xVel <= 0) {
                this.ballXVel = xVels[1];
            } else {
                this.ballXVel = xVels[0];
            }
        }
        this.ballXDelta += xVel;
    }


    //Implement YDelta OR Movement Here
    public void changeYDelta (float yVel, boolean isColliding) {
        // if (ballXDelta + xVel >= 0 && ballXDelta + xVel + Constants.ballWidth < GameWindow.screenWidth) {
        //     this.ballXDelta += xVel;
        // } 
        
        if (isColliding){
            if (yVel <= 0) {
                this.ballYVel = yVels[1];
            } else {
                this.ballYVel = yVels[0];
            }
        } 
        this.ballYDelta += yVel;
    }

    public float getXDelta() {
        return this.ballXDelta;
    }

    public float getYDelta() {
        return this.ballYDelta;
    }
    
    public int getWidth () {
        return Constants.ballWidth;
    }

    public int getHeight () {
        return Constants.ballHeight;
    }

    public Color getBallColor() {
        return Constants.ballColor;
    }

    public float getBallXVel () {
        return this.ballXVel;
    }

    public void setBallXVel (float newXVel) {
        this.ballXVel = newXVel;
    }

    public void setBallYVel (float newYVel) {
        this.ballYVel = newYVel;
    }


    public float getBallYVel() {
        return this.ballYVel;
    }


    // public void updateXVel(boolean isColliding) {
    //     if (isColliding) {
    //         if (this.ballXVel < 0) {
    //             this.ballXVel = xVels[1];
    //         } else {
    //             this.ballXVel = xVels[0];
    //         }
    //     }
    // }
}
