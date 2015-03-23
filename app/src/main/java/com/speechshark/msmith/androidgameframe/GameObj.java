package com.speechshark.msmith.androidgameframe;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Marcus on 3/14/2015.
 */
public class GameObj implements OnCollideListener{

	/** Allows for a specific GameObj's collision to be responded to */
	private OnCollideListener listener;

	/** The current x-axis location of the GameObj **/
	private int xLocation;

	/** The current y-axis location of the GameObj **/
	private int yLocation;

	/** The current image visible on the GameObj.
	 * <br> This is used during the draw to represent the GameObj.  **/
	private Bitmap displayedBitmap;

	/** Holds all the images associated with the GameObj.
	 * <br> Using a key such as "NORMAL" will give a list of all 'normal' images.
	 * This is a way to organize several categories of images that a single GameObj should use
	 */
	private Hashtable<String, ArrayList<Image>> textureHash;

	// We may want to support other shapes later
	/** Represents the boundaries of the GameObj and gives it its edges.
	 * <br> Adapts the boundaries according to the dimensions of the displayedBitmap
	 */
	private Rect container;

	/** Determines what layer level the gameobj belongs to */
	private LayerManager.LayerLevel layerLevel= LayerManager.LayerLevel.NONE;

	/** Empty default constructor **/
	public GameObj() {}

	/** Initializes data and loads a default '?' bitmap into a new box. */
	public GameObj(Context c)
	{
		this.xLocation= 0;
		this.yLocation= 0;
		this.textureHash= new Hashtable<>();

		if (c != null) {
			this.displayedBitmap= BitmapFactory.decodeResource(c.getResources(), R.drawable.ic_action_help);

			ArrayList<Image> temp = new ArrayList<>();
			temp.add(new Image(this.displayedBitmap));

			this.textureHash.put(TextureKeys.DEFAULT.name(), temp);
			this.container= new Rect(this.xLocation, this.yLocation, this.displayedBitmap.getWidth(), this.displayedBitmap.getHeight());

			if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.REPORT,
					"GameObj - GameObj(Context)", "Default bitmap loaded; boundaries set"); }
		} else {
			// Creates a 1x1 boundary box
			this.container= new Rect(0,1,1,0);
			if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
					"GameObj - GameObj(Context)", "The context is NULL. Parameters disregarded; GameObj created with new Rect"); }
		}
	}

	// Should take bitmap, can accept null box if boundaries should be wider
	public GameObj(Rect box) {
		if (box != null) {
			if (!box.isEmpty()) {
				this.container = box;
				if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.REPORT,
						"GameObj - GameObj(Rect)", "GameObj has been created with Rect"); }
			} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
					"GameObj - GameObj(Rect)", "The box is EMPTY (Improper dimensions). Parameters disregarded; Empty GameObj created"); }
		} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
				"GameObj - GameObj(Rect)", "The box is NULL.Parameters disregarded;  Empty GameObj created"); }
	}

	//keep
	public GameObj(String key, Bitmap image) {
		if (key != null) {
			if (!key.isEmpty()) {
				if (image != null) {
					if (!image.isRecycled()) {

						ArrayList<Image> temp = new ArrayList<>();
						temp.add(new Image(image));
						this.textureHash.put(key, temp);

						if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.REPORT,
								"GameObj - GameObj(String, Bitmap)", "GameObj has been created with Rect"); }
					} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
							"GameObj - GameObj(String, Bitmap)", "The image is recycled (Reference to the pixel data has been cleared) " +
									"Parameters disregarded; Empty GameObj created"); }
				} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
						"GameObj - GameObj(String, Bitmap)", "The image is NULL. Parameters disregarded; Empty GameObj created"); }
			} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
					"GameObj - GameObj(String, Bitmap)", "The key is EMPTY. Parameters disregarded; Empty GameObj created"); }
		} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.TagSeverity.WARNING,
				"GameObj - GameObj(String, Bitmap)", "The key is NULL. Parameters disregarded; Empty GameObj created"); }
	}

	public GameObj(Hashtable<String, ArrayList<Image>> texture) { this.textureHash= texture; }

	/** Draws the first Bitmap in the Image imageList with the normal key in the Container textureHash
	 * by default
	 * @param canvas
	 */
	protected void draw(Canvas canvas){
		canvas.drawBitmap(this.displayedBitmap, this.xLocation,  this.yLocation, null);
	}

	protected void absMove(int x, int y){}

	protected void relMove(int x, int y) {}

	private int getxLocation() { return xLocation; }

	private void setxLocation(int xLocation) { this.xLocation = xLocation; }

	private int getyLocation() { return yLocation; }

	private void setyLocation(int yLocation) { this.yLocation = yLocation; }

	@Override
	public void OnCollide(GameObj o) {

	}

	private enum TextureKeys{
		NORMAL,
		DESTROY,
		DEFAULT
	}

}
