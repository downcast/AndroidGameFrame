package com.speechshark.msmith.androidgameframe;

import java.util.Hashtable;

/**
 * Created by Marcus on 3/16/2015.
 */
public class LayerManager {

	private Hashtable<LayerLevel, Layer> members;

	/** Constructor that assigns the GameObj to the appropriate layer by sending to the appropriate manager  **/
	public LayerManager(LayerLevel level, GameObj obj) {
		members.put(level.ACTION, new Layer());
	}

	public enum LayerLevel{
		NONE,
		BACKGROUND,
		ACTION,
		EFFECT
	}
}
