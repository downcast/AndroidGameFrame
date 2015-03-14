package com.speechshark.msmith.androidgameframe;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by Marcus on 3/13/2015.
 */
public class Image{

	protected List<Bitmap> imageList;

	public Image() {
		if (DebugLogger.DEBUG) {
			DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.WARNING,
			"Image - Image", "The bitmap is NULL. No image has been assigned");
		}
	}

	public Image(Bitmap image) {
		if (image != null) { imageList.add(image); }
		else { if (DebugLogger.DEBUG) { DebugLogger.WriteLog(DebugLogger.DebugLoggerTagSeverity.ERROR,
				"Image - Image", "The bitmap is NULL. No image added"); }}
	}
}
