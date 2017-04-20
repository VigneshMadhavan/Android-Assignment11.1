package com.vigneshtraining.assignment111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView msg;
    private Button btn;
    private Boolean animating=false;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg=(TextView) findViewById(R.id.msg);
        btn= (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(animating){
            msg.clearAnimation();
            animation.cancel();
            animation=null;
            btn.setText(getText(R.string.start_animate));

        }else{
            animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.blink);
            msg.startAnimation(animation);
            btn.setText(getText(R.string.stop_animate));


        }
        animating=!animating;

    }
}
