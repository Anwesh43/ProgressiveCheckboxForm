package com.anwesome.ui.progressivecheckform;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.List;

/**
 * Created by anweshmishra on 03/04/17.
 */
public class Form {
    private int w,h;
    private float x,y;
    private CheckBoxUiGroup checkBoxUiGroup;
    private String value = null;
    private SubmitButton submitButton;
    public Form(float x,float y,int w,int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }
    public void setCheckBoxOptions(List<String> titles,String question) {
        checkBoxUiGroup = new CheckBoxUiGroup(w/10,h/3,2*Math.min(w,h)/3);
        checkBoxUiGroup.createCheckBoxes(titles,question);
    }
    public void setSubmitButton(String title) {
        submitButton = new SubmitButton(title,w/2-w/10,0.85f*h,w/3,w/12);
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        if(checkBoxUiGroup!=null) {
            checkBoxUiGroup.draw(canvas,paint);
        }
        if(submitButton!=null) {
            submitButton.draw(canvas,paint);
        }
        canvas.restore();
    }
    public boolean handleFormTap(float x,float y) {
        boolean handleSubmit = false;
        if(submitButton!=null) {
            handleSubmit = submitButton.handleTap(x,y);
        }

        handleSubmit = value!=null && handleSubmit;
        return handleSubmit;
    }
    public boolean handleCheckBoxTap(float x,float y) {
        if(checkBoxUiGroup!=null) {
            boolean handleCheckBox = checkBoxUiGroup.handleTap(x,y);
            if(handleCheckBox) {
                value = checkBoxUiGroup.getTitle();
            }
            return handleCheckBox;
        }
        return false;
    }
    public int hashCode() {
        return (value == null?0:value.hashCode())+(checkBoxUiGroup!=null?checkBoxUiGroup.hashCode():0) +(submitButton!=null?submitButton.hashCode():0);
    }
}
