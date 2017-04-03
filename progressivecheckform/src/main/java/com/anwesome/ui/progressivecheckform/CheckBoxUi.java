package com.anwesome.ui.progressivecheckform;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class CheckBoxUi {
    private String text;
    private float x,y,w;
    private boolean selected = false;
    public CheckBoxUi(String text,float x,float y,float w) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.text = text;
    }
    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(w/30);
        paint.setColor(Color.parseColor("#616161"));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(new RectF(x,y,x+w/2,y+w/2),w/50,w/50,paint);
        paint.setStyle(Paint.Style.FILL);
        if(selected) {
            paint.setColor(Color.parseColor("#3F51B5"));
            canvas.drawCircle(x+w/4,y+w/4,w/8,paint);
        }
        if(text.split(" ").length <= 3) {
            paint.setColor(Color.parseColor("#424242"));
            paint.setTextSize(w/3);
            canvas.drawText(text,x+w,y+w/3,paint);
        }
    }
    public boolean handleTap(float x,float y) {
        boolean condition = x>=this.x && x<=this.x+w && y>=this.y && y<=this.y+w;
        if(condition) {
            selected = !selected;
        }
        return condition;
    }
    public String getText() {
        return text;
    }
    public int hashCode() {
        return (int)(x+y)+text.hashCode();
    }
    public void unselect() {
        this.selected = false;
    }
}
