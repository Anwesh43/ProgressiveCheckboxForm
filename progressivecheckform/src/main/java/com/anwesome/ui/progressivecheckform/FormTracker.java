package com.anwesome.ui.progressivecheckform;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class FormTracker {
    private float x,y,wFinal;
    private int n,k=0;
    public FormTracker(float x,float y,float w,int n) {
        this.x = x;
        this.y = y;
        this.n= n;
        this.wFinal = w;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(wFinal/50);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.parseColor("#CFD8DC"));
        canvas.drawLine(x,y,x+wFinal,y,paint);
        paint.setColor(Color.parseColor("#00E676"));
        canvas.drawLine(x,y,x+(wFinal*k)/n,y,paint);
    }
    public void update() {
        if(k<n) {
            k++;
        }
    }
}
