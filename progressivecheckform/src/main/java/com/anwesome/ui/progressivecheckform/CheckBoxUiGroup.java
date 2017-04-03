package com.anwesome.ui.progressivecheckform;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.*;
/**
 * Created by anweshmishra on 03/04/17.
 */
public class CheckBoxUiGroup {
    private CheckBoxUi curr;
    private String title = null;
    private List<CheckBoxUi> checkBoxUis = new ArrayList<>();
    private float x,y,w;
    public CheckBoxUiGroup(float x,float y,float w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
    public void createCheckBoxes(List<String> titles) {
        float newY = y,gap = w/3,size = w/4;
        if(titles.size() == 3) {
            for (String title : titles) {
                checkBoxUis.add(new CheckBoxUi(title,x,newY,size));
                newY+=gap;
            }
        }
    }
    public void draw(Canvas canvas, Paint paint) {
        for(CheckBoxUi checkBoxUi:checkBoxUis) {
            checkBoxUi.draw(canvas,paint);
        }
    }
    public String getTitle() {
        return title;
    }
    public boolean handleTap(float x,float y) {
        boolean condition = false;
        for(CheckBoxUi checkBoxUi:checkBoxUis) {
            condition = checkBoxUi.handleTap(x,y);
            if(condition) {
                if(curr != null) {
                    curr.unselect();
                }
                curr = checkBoxUi;
                if(curr!=null) {
                    title = curr.getText();
                }
                break;
            }
        }
        return condition;
    }
    public int hashCode() {
        return checkBoxUis.hashCode()+(int)(x+y+w);
    }
}
