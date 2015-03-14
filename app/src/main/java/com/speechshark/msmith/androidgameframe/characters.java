package com.speechshark.msmith.androidgameframe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/**
 * Created by Sherdon on 3/8/2015.
 */
public class characters extends ImageObj{

    /** Holds the value to move the image along the x-axis by. A negative value will move the image to the left.*/
   // protected int xSpeed;
  //  protected int ySpeed;
  //  protected int xSpawn;
  //  protected int ySpawn;
  //  protected int ID;//object ID
   // protected int spawnid;
  //  protected boolean isCollidable;
   // protected boolean cTracker;
  //  protected boolean objDetection;
  //  protected boolean spawnstate;
    protected int health;
    protected int attack;
    protected resources R;

    /** PlayerImage Class constructor
     *
     * @param bitmap The image returned by BitmapFactory.decodeResource
     * @param screenHeight The height of the device screen.
     * @param screenWidth The width of the device screen.
     * @param xInitial The starting x coordinate value of the image
     * @param yInitial The starting y coordinate value of the image
     */


    public characters(Bitmap bitmap, Bitmap gameImageDestroy, int screenHeight, int screenWidth, int xInital, int yInitial, int ID, boolean isCollidable, boolean tracker, boolean objDetection, boolean spawnState) {
		/* This makes a call to the Image class constructor to initialize its data so that the PlayerImage can function correctly*/
        super(bitmap, gameImageDestroy, screenHeight, screenWidth, xInital, yInitial, ID, isCollidable, tracker, objDetection, spawnState);

    }

    /** Draws the character to the screen but does not update its position for the next draw. This is handled by the CharacterMovementTask */
    @Override
    protected void draw(Canvas canvas){
        canvas.drawBitmap(gameImage, this.xLocation,  this.yLocation, null);
    }

    //*******************************Accessors******************************************/
    protected void setSpawnState(boolean spawnState) {
        this.spawnstate = spawnState;
    }

}
