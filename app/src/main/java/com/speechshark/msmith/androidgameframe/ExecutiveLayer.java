package com.speechshark.msmith.androidgameframe;

/**
 * Created by Sherdon on 3/15/2015.
 */


public class ExecutiveLayer{

    public enum layerLevel {
        //this is the layers level
        background(1),
        action(2),
        effect(3);
        private int value;

        private layerLevel(int v){
            this.value = v;
        }
    }
        layerLevel layerL;



        public ExecutiveLayer(layerLevel layerL) {
            this.layerL = layerL;
        }



}
