package com.lkjuhkmnop.sits_27_01_21_drawing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView view = new MyView(this, null);
        view.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MyView eView = (MyView) v;
                float x = event.getX();
                float y = event.getY();
                if (event.getDownTime() > 200) {
                    eView.moveFigures(x, y);
                } else {
                    eView.createFig(x, y);
                }
                return false;
            }
        });

        setContentView(view);
    }
}