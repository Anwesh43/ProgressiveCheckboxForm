package com.anwesome.ui.progressivecheckform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class FormContainerView extends View {
    private FormContainer formContainer;
    private int time = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean isAnimated = false;
    public FormContainerView(Context context, List<List<String>> options) {
        super(context);
        formContainer = new FormContainer(options);
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            int w = canvas.getWidth(),h = canvas.getHeight();
            formContainer.init(0,0,w,h);
        }
        formContainer.draw(canvas,paint);
        time++;
        if(isAnimated) {
            formContainer.moveScreen();
            if(formContainer.stopMovingScreen()) {
                isAnimated = false;
            }
            try {
                Thread.sleep(50);
                invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),y = event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN && !isAnimated && formContainer!=null) {
            boolean formTap = formContainer.handleFormTap(x,y),cbTap = formContainer.handleCheckBoxTap(x,y);
            if(formTap || cbTap) {
                if(formTap) {
                    isAnimated = true;
                }
                postInvalidate();
            }
        }
        return true;
    }
}
