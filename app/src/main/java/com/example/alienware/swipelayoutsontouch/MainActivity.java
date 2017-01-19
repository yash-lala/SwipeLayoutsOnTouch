package com.example.alienware.swipelayoutsontouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity{

    float init_x;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    private int[] layouts;
    int index=0;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        relativeLayout =(RelativeLayout)findViewById(R.id.activity_main);
        linearLayout =(LinearLayout) findViewById(R.id.frame);
        layouts = new int[]{
                R.layout.one,
                R.layout.two,
                R.layout.three,
                R.layout.four
        };

        setContentView(layouts[index]);
    }


    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()){

            case MotionEvent.ACTION_DOWN:
                init_x = motionEvent.getX();
            case MotionEvent.ACTION_MOVE:
                float diff_x = init_x - motionEvent.getX() ;
                pos = diff_x < 0? 1 : diff_x==0? 0 : -1;
                return true;
            case MotionEvent.ACTION_UP:
                switch (pos){
                    case -1:
                        index = index==layouts.length-1? index : index+Math.abs(pos);
                        setContentView(layouts[index]);
                        //left
                        return true;
                    case 0:
                        //same
                        return true;
                    case 1:
                        index = index==0? index : index-pos;
                        setContentView(layouts[index]);
                        //right
                        return true;

                }
        }
        return true;
    }


}

