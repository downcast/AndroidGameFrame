package com.speechshark.msmith.androidgameframe;

import java.util.Hashtable;

/** Controls all other managers.
 * Created by Marcus on 3/16/2015.
 */
public class ExecutiveLayerManager {

	private Hashtable<LayerLevel, LayerManager> members;

	/** Constructor that assigns the GameObj to the appropriate layer by sending to the appropriate manager  **/
	public ExecutiveLayerManager(LayerLevel level, GameObj obj) { /*members.put(LayerLevel.ACTION, new LayerManager());*/
        members.put(LayerLevel.ACTION, new LayerManager());
    }

	public enum LayerLevel{
		BACKGROUND,
		ACTION,
		EFFECT
	}
}
