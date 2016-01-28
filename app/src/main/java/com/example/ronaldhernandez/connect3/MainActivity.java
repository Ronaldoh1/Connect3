package com.example.ronaldhernandez.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view){

        ImageView counter = (ImageView)view;

        //need to move it off the screen.Apply red or yellow.

        counter.setTranslationY(-1000f);
        //set the image.
        counter.setImageResource(R.drawable.yellow);
        //Move it back to position
        counter.animate().translationYBy(1000f).rotation(180).setDuration(300);


    }
}
