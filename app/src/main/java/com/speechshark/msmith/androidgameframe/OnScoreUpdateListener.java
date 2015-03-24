package com.speechshark.msmith.androidgameframe;

/**
 * Created by Marcus on 3/23/2015.
 */
public interface OnScoreUpdateListener {

	/** Sends the gameobjs that collided with eachother */
	public void onScoreUpdate (GameObj go1, GameObj g02);
}
