package com.speechshark.msmith.androidgameframe;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcus on 3/13/2015.
 */
public class Image{

	private ArrayList<Bitmap> imageList;

	public Image() {
		if (DebugLogger.DEBUG) {
			DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
			"Image - Image", "The bitmap is NULL. No bitmap has been assigned");
		}
	}

	public Image(Bitmap image) {
		if (image != null) { imageList.add(image); }
		else { if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.ERROR,
				"Image - Image", "The bitmap is NULL. No bitmap added"); }}
	}


	public List<Bitmap> getImageList() { return imageList; }

	/** Overwrites the existing imageList
	 *
	 * @param imageList
	 */
	public void setImageList(ArrayList<Bitmap> imageList) { this.imageList = imageList; }

	/** Adds new Bitmaps to the imageList. <br>
	 * Checks to confirm list is not null, empty or items are null.
	 *
	 * @param imageList
	 * @return true if items were added
	 */
	public boolean addBitmap (ArrayList<Bitmap> imageList) {
		if (imageList != null) {
			if (!imageList.isEmpty()) {
				for (int i = 0; i < imageList.size(); i++) {
					if (imageList.get(i) != null) {
						this.imageList.add(imageList.get(i));
					} else {
						if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
								"Image - addBitmap", "The parameter list item is NULL. Item NOT added"); }
					}
				}
			} else {
				if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
						"Image - addBitmap", "The list is EMPTY. No bitmap added"); }
				return false;
			}
		} else {
			if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
					"Image - addBitmap", "The list is NULL. No bitmap added"); }
			return false;
		}
		return true;
	}
}
