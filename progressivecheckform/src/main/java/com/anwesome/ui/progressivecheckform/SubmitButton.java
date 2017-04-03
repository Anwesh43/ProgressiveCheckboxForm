package com.anwesome.ui.progressivecheckform;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class SubmitButton {
    private String text;
    private float x,y,w,h;
    public SubmitButton(String text,float x,float y,float w,float h) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.parseColor("#1565C0"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(x,y,x+w,y+h),w/10,w/10,paint);
        paint.setTextSize(w/9);
        paint.setColor(Color.WHITE);
        canvas.drawText(text,x+w/2-paint.measureText(text)/2,y+h/2+paint.getTextSize()/2,paint);
    }
    public boolean handleTap(float x,float y) {
        boolean condition = x>=this.x && x<=this.x+w && y>=this.y && y<=this.y+h;
        return condition;
    }
    public int hashCode() {
        return text.hashCode()+(int)(x+y+w+h);
    }
}
