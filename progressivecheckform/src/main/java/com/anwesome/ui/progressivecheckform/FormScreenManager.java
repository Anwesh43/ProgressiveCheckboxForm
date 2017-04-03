package com.anwesome.ui.progressivecheckform;

import android.graphics.PointF;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class FormScreenManager {
    private float x=0,y=0,w,prevX;
    private boolean stop = true;
    public FormScreenManager(float x,float y,float w) {
        this.x = x;
        this.y = y;
        this.prevX = x;
        this.w = w;
    }
    public void move() {
        if(!stop) {
            this.x -= w / 5;
            if (prevX - this.x >= w) {
                prevX = this.x;
                stop = true;
            }
        }
    }
    public boolean shouldStop() {
        return stop;
    }
    public void startMoving() {
        if(stop) {
            stop = false;
        }
    }
    public PointF getXY() {
        return new PointF(x,y);
    }
}
