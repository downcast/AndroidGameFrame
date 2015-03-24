package com.speechshark.msmith.androidgameframe;

import java.util.ArrayList;

/**
 * Created by Marcus on 3/21/2015.
 */
public class GameBrain {

	int Clock;

	/** Holds a list of all subscribers who will be told when to check for collisions */
	private ArrayList<OnCheckCollisionListener> listeners;


}
