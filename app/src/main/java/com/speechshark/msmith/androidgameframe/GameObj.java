package com.speechshark.msmith.androidgameframe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Marcus on 3/14/2015.
 */
public class GameObj{

	private int xLocation;
	private int yLocation;
	private Bitmap displayedBitmap;

	private Hashtable<String, ArrayList<Image>> textureHash;
	// We may want to support other shapes later
	private Rect containerBox;

	public GameObj(Rect box) {
		if (box != null) {
			if (!box.isEmpty()) {
				this.containerBox = box;
				if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.REPORT,
						"Container - Container", "Container has been created with Rect"); }
			} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
					"Container - Container", "The box is EMPTY (Improper dimensions). Empty Container created"); }
		} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
				"Container - Container", "The box is NULL. Empty Container created"); }
	}

	public GameObj(int left, int top, int right, int bottom){
		this.containerBox= new Rect(left, top, right, bottom);
	}

	public GameObj(String normalKey, Bitmap image) {
		if (normalKey != null) {
			if (!normalKey.isEmpty()) {
				if (image != null) {
					if (!image.isRecycled()) {

						ArrayList<Image> temp = new ArrayList<>();
						temp.add(new Image(image));
						this.textureHash.put(normalKey, temp);

						if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.REPORT,
								"Container - Container", "Container has been created with Rect"); }
					} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
							"Container - Container", "The image is recycled (Reference to the pixel data has been cleared) " +
									"Parameters disregarded; Empty Container created"); }
				} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
						"Container - Container", "The image is NULL. Parameters disregarded; Empty Container created"); }
			} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
					"Container - Container", "The normalKey is EMPTY. Parameters disregarded; Empty Container created"); }
		} else if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
				"Container - Container", "The normalKey is NULL. Parameters disregarded; Empty Container created"); }
	}

	public GameObj(Hashtable<String, ArrayList<Image>> texture) {
		this.textureHash= texture;
	}

	/** Draws the first Bitmap in the Image imageList with the normal key in the Container textureHash
	 * by default
	 * @param canvas
	 */
	protected void draw(Canvas canvas){
		canvas.drawBitmap(this.displayedBitmap, this.xLocation,  this.yLocation, null);
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
