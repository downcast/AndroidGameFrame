package com.speechshark.msmith.androidgameframe;

import java.util.Hashtable;

/**
 * Created by Marcus on 3/16/2015.
 */
public class Layer{

	/** Determines what layer level the layer belongs to */
	private LayerManager.LayerLevel layerLevel;

	/** Determines the priority of when the layer should draw its objs. A lower priority means that it is drawn first */
	private int priority;

	private Hashtable<String, GameObj> members;

	public Layer() {}

}
