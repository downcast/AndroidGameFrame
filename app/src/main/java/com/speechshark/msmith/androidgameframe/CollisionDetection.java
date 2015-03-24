package com.speechshark.msmith.androidgameframe;

import java.util.Queue;

/**
 * Created by Marcus on 3/22/2015.
 */
public class CollisionDetection implements OnCheckCollisionListener{

	/** Holds all the layers that should be looked into to find collisions */
	private Queue<Layer> collidables;

	private OnScoreUpdateListener listener2;
	private OnReturnCollidableListener listener;

	public CollisionDetection(){}


	@Override
	public void OnCheckCollision() {
		// for each listener, add data to queue
		// send message to layermanager
		// add data to queue
	}
}
