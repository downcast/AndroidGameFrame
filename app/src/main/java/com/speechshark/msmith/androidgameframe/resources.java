package com.speechshark.msmith.androidgameframe;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Sherdon on 3/12/2015.
 */
public class resources  extends ImageObj{
    protected int shield;
    protected int increaseFireBallPower;
    protected int lightingBolt;
    protected int otherPowerUp1;
    protected int otherPowerUp2;
    protected int otherPowerUp3;

    public resources(Bitmap bitmap, Bitmap gameImageDestroy, int screenHeight, int screenWidth, int xInital, int yInitial, int ID, boolean isCollidable, boolean tracker, boolean objDetection, boolean spawnState, int Shield, int IncreaseFireBallPower, int LightingBolt, int OtherPowerUp1, int OtherPowerUp2, int OtherPowerUp3) {
		/* This makes a call to the Image class constructor to initialize its data so that the PlayerImage can function correctly*/
        super(bitmap, gameImageDestroy, screenHeight, screenWidth, xInital, yInitial, ID, isCollidable, tracker, objDetection, spawnState, Shield, IncreaseFireBallPower, LightingBolt, OtherPowerUp1, OtherPowerUp2, OtherPowerUp3);

    }

    @Override
    protected void draw(Canvas canvas){
        canvas.drawBitmap(gameImage, this.xLocation,  this.yLocation, null);
    }
}
