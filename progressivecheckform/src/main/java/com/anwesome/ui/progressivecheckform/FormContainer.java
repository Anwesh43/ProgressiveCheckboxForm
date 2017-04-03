package com.anwesome.ui.progressivecheckform;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class FormContainer {
    private FormTracker formTracker;
    private FormScreenManager formScreenManager;
    private ConcurrentLinkedQueue<Form> forms = new ConcurrentLinkedQueue<>();
    private List<List<String>> options = new ArrayList<>();
    public FormContainer(List<List<String>> options) {
        this.options = options;
    }
    public void init(float x,float y,int w,int h) {
        if(options.size()>0) {
            int index = 0;
            float xi = x;
            formTracker = new FormTracker(w / 6, h / 8, 2 * w / 3, options.size());
            formScreenManager = new FormScreenManager( x, y,w);
            for (List<String> option : options) {
                Form form = new Form(xi, 0, w, h);
                form.setCheckBoxOptions(option);
                if (index == options.size() - 1) {
                    form.setSubmitButton("Complete");
                } else {
                    form.setSubmitButton("Next");
                }
                forms.add(form);
                index++;
                xi+=w;
            }
        }
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        if(formScreenManager!=null) {
            translateToPoint(canvas, formScreenManager.getXY());
        }
        for(Form form:forms) {
            form.draw(canvas,paint);
        }
        canvas.restore();
        if(formTracker!=null) {
            formTracker.draw(canvas,paint);
        }
    }
    public void moveScreen() {
        if(formScreenManager!=null) {
            formScreenManager.move();
        }
    }
    public boolean stopMovingScreen() {
        if(formScreenManager!=null) {
            boolean condition = formScreenManager.shouldStop();
            if(condition) {
                for(Form form:forms) {
                    forms.remove(form);
                    break;
                }
            }
            return condition;
        }
        return false;
    }
    private void translateToPoint(Canvas canvas,PointF pointF) {
        canvas.translate(pointF.x,pointF.y);
    }
    public boolean handleFormTap(float x,float y) {
        boolean handleFormTapCondtion = false;
        for(Form form:forms) {
            handleFormTapCondtion = form.handleFormTap(x,y);
            if(handleFormTapCondtion) {
                if(formTracker!=null) {
                    formTracker.update();
                }
                if(formScreenManager!=null) {
                    formScreenManager.startMoving();
                }
                break;
            }
        }
        return handleFormTapCondtion;
    }
    public boolean handleCheckBoxTap(float x,float y) {
        boolean condition = false;
        for(Form form:forms) {
            condition = form.handleCheckBoxTap(x,y);
            if(condition) {
                break;
            }
        }
        return condition;
    }
}
