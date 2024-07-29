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
    private float[] xVels = {-3, 3};
    private float[] yVels = {-3, 3};
    private float[] initXVels = {-1, 1};
    private Random randomVelChooser;
    
    
    public Ball () {
        this.ballXDelta = Constants.ballXStart;
        this.ballYDelta = Constants.ballYStart;
        this.randomVelChooser = new Random();
        int randomNum = randomVelChooser.nextInt(2);
        this.ballXVel = initXVels[randomNum];
    }


    //Collision Bug: When moving the paddle and the ball goes over the paddle,
    //with the right timing, the ball can still come back and deflect to the
    //screen
    public void changeXDelta (float xVel, boolean collidingWithPaddle) {
        // if (ballXDelta + xVel >= 0 && ballXDelta + xVel + Constants.ballWidth < GameWindow.screenWidth) {
        //     this.ballXDelta += xVel;
        // } 
        
        if (collidingWithPaddle){
            if (xVel < 0) {
                this.ballXVel = xVels[1];
            } else {
                this.ballXVel = xVels[0];
            }
        } else {
            this.ballXDelta += xVel;
        }
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
