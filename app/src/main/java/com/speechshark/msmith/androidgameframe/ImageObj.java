package com.speechshark.msmith.androidgameframe;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Sherdon on 3/8/2015.
 */
public abstract class ImageObj {
    /** This is the actually image */
    protected Bitmap gameImage;
    protected Bitmap gameImageDestroy;
    protected int screenHeight;
    protected int screenWidth;
    /** Holds the canvas x-coordinate location of the image. */
    protected int xLocation;
    /** Holds the canvas y-coordinate location of the image. */
    protected int yLocation;
    protected int imageWidth;
    protected int imageHeight;
    protected int ID;
    protected int xSpeed;
    protected int ySpeed;
// still not sure yet
    //tell if the object is collidable or not
    protected boolean isCollidable;
    protected boolean cTracker;
    protected boolean objDetection;
    protected boolean spawnstate;



	public ImageObj(){}
    /** Superclass constructor for all images loaded into the game
     *
     * @param bitmap The image returned by BitmapFactory.decodeResource
     * @param screenHeight The height of the device screen.
     * @param screenWidth The width of the device screen.
     * @param xInitial The starting x coordinate value of the image
     * @param yInitial The starting y coordinate value of the image
     */



    //charactor constructor
    public ImageObj(Bitmap bitmap, Bitmap gameImageDestroy, int screenHeight, int screenWidth, int xInitial, int yInitial, int id, boolean isCollidable, boolean tracker, boolean objectDetection, boolean spawnState) {
        this.gameImage= bitmap;
        this.gameImageDestroy = gameImageDestroy;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.xLocation= xInitial;
        this.yLocation= yInitial;
        this.imageHeight= this.gameImage.getHeight();
        this.imageWidth= this.gameImage.getWidth();
        this.ID = id;
        this.isCollidable= isCollidable;
        this.cTracker= tracker;
        this.objDetection= objectDetection;
        this.spawnstate = spawnState;
    }

    //resources constructor
    public ImageObj(Bitmap bitmap, Bitmap gameImageDestroy, int screenHeight, int screenWidth, int xInitial, int yInitial, int id, boolean isCollidable, boolean tracker, boolean objectDetection, boolean spawnState, int shield, int increaseFireBallPower, int lightingBolt, int otherPowerUp1, int otherPowerUp2, int otherPowerUp3){
        this.gameImage= bitmap;
        this.gameImageDestroy = gameImageDestroy;
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.xLocation= xInitial;
        this.yLocation= yInitial;
        this.imageHeight= this.gameImage.getHeight();
        this.imageWidth= this.gameImage.getWidth();
        this.ID = id;
        this.isCollidable= isCollidable;
        this.cTracker= tracker;
        this.objDetection= objectDetection;
        this.spawnstate = spawnState;
    }

    //******************************************Accessors******************************************/
    /** Used to draw objects to the screen.
     * <br>
     * Each image type will have its own version of the draw method.
     * @param canvas
     */
    protected abstract void draw(Canvas canvas);

    protected void setGameImage(Bitmap gameImage) {
        this.gameImage = gameImage;
    }

    protected void setGameImageDestroy(Bitmap gameImageDestroy) { this.gameImageDestroy = gameImageDestroy; }

    /** Used to change the x-coordinate location of the image. This function should be used to choose a custom location
     * for an image. To update the x-axis by a set number, use the updateX function instead.
     * @param xLocation The horizontal location an image will be when the system renders the image
     */
    protected synchronized void setxLocation(int xLocation) { this.xLocation = xLocation; }

    /**Used to change the y-coordinate location of the image. This function should be used to choose a custom location for an image.
     * To update the y-axis by a set number, use the updateY function instead.
     *
     * @param yLocation The vertical location an image will be when the system renders the image
     */
    protected synchronized void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    protected void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    protected void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    protected void setID(int id){
        this.ID = id;
    }

    protected void setCTracker(boolean track){
        this.cTracker= track;
    }

    protected void setObjDetection(boolean OD){
        this.objDetection= OD;
    }

    protected void setSpawnState(boolean spawnState){
        this.spawnstate= spawnState;
    }

    /** Used to update the horizontal location of an image. Use this method in a loop to take current xLocation and add value to it.
     *
     * @param value Amount that the current xLocation should increase by (+10) or decrease by (-10)
     */
    protected void updateXLocation(int value){
        this.setxLocation(this.getxLocation()+value);
    }

    /** Used to update the vertical location of an image. Use this method in a loop to take current yLocation and add value to it.
    *
    * @param value Amount that the current yLocation should increase by (+10) or decrease by (-10)
    */
    protected void updateYLocation(int value){
        this.setyLocation(this.getyLocation()+value);
    }

    //swap and destroy the images
    public void swap(){
        setGameImage(getGameImageDestroy());
    }

    protected void alignToLowerWall(){ this.setyLocation(this.screenHeight-this.getImageHeight()); }

    protected void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    protected void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    protected void setYSpeed(int ySpeed){
        this.ySpeed = ySpeed;
    }

    protected void setXSpeed(int xSpeed){
        this.xSpeed = xSpeed;
    }

    //*********************************Mutators******************************************/
    protected int getxLocation() {
        return xLocation;
    }

    protected int getyLocation() {
        return yLocation;
    }

    /** Returns the width (y) of the object's bitmap */
    protected int getImageHeight() {
        return this.imageHeight;
    }

    /** Returns the width (x) of the object's bitmap */
    protected int getImageWidth() {
        return this.imageWidth;
    }

    protected int getID(){
        return ID;
    }

    protected boolean getCTracker(){
        return cTracker;
    }

    protected boolean getObjDetection(){ return objDetection; }

    protected boolean getSpawnState() { return spawnstate; }

    protected Bitmap getGameImageDestroy() {
        return gameImageDestroy;
    }

    protected int getScreenHeight() {
        return screenHeight;
    }

    protected int getScreenWidth() {
        return screenWidth;
    }

    protected Bitmap getGameImage() {
        return gameImage;
    }

    protected int getXSpeed() {
        return xSpeed;
    }

    protected int getYSpeed() {
        return ySpeed;
    }



}
