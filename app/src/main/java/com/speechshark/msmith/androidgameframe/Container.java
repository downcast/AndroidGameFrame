package com.speechshark.msmith.androidgameframe;

import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcus on 3/14/2015.
 */
public class Container extends Image{

	private int xLocation;
	private int yLocation;

	Hashtable<String, List<Image>> textureDict;
	Rect containerBox;

	public Container() {}

	public Container(int left, int top, int right, int bottom){
		this.containerBox= new Rect(left, top, right, bottom);
	}

	public Container(String normalKey, Image normalTexture, String destroyKey, Image destroyTexture) {

	}

	public Container(Hashtable<String, List<Image>> texture) {

	}

	/** Draws the first Bitmap in the Image imageList with the normal key in the Container textureDict
	 *
	 * @param canvas
	 */
	protected void draw(Canvas canvas){
		canvas.drawBitmap(this.textureDict.get(textureKeys.NORMAL.name()).get(0).imageList.get(0), this.xLocation,  this.yLocation, null);
	}

	protected void absMove(){}

	protected void relMove() {}

	private int getxLocation() { return xLocation; }

	private void setxLocation(int xLocation) { this.xLocation = xLocation; }

	private int getyLocation() { return yLocation; }

	private void setyLocation(int yLocation) { this.yLocation = yLocation; }

	private enum textureKeys{
		NORMAL,
		DESTROY
	}
}
