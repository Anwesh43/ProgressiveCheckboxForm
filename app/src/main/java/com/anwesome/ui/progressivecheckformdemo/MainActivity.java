package com.anwesome.ui.progressivecheckformdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.progressivecheckform.FormContainer;
import com.anwesome.ui.progressivecheckform.FormContainerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String optionsContainer[][] = {{"A-Option1","A-Option2","A-Option3"},{"B-Option1","B-Option2","B-Option3"},{"C-Option1","C-Option2","C-Option3"},{"D-Option1","D-Option2","D-Option3"},{"E-Option1","E-Option2","E-Option3"}};
    List<List<String>> optionsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for(String[] options:optionsContainer) {
            List<String> optionList = new ArrayList<>();
            for(String option:options) {
                optionList.add(option);
            }
            optionsList.add(optionList);
        }
        FormContainerView formContainerView = new FormContainerView(this,optionsList);
        setContentView(formContainerView);
    }
}
