package com.tarakhan.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     TextView textView;
    SeekBar seekBar;
    Button button;
    CountDownTimer countDownTimer;
    boolean inProgress = false;
    public void resetTimer()
    {
        seekBar.setEnabled(true);
        textView.setText("0:30");
        seekBar.setProgress(30);
        countDownTimer.cancel();
        inProgress=false;
        button.setText("Go!");
    }

    public void updateTimer(int progress)

    {
        int min = (int) progress/60;
        int sec =  progress-min*60;
        String seconds = Integer.toString(sec);
        if(sec <= 9){
            seconds="0"+seconds;
        }
        textView.setText(Integer.toString(min)+":"+seconds);
    }
    public void countdown(View view) {
        if (inProgress == false) {
            inProgress = true;
            seekBar.setEnabled(false);
            button.setText("Stop");
          countDownTimer =  new CountDownTimer(seekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                   resetTimer();
                    MediaPlayer.create(getApplicationContext(), R.raw.airho).start();


                }
            }.start();

        }
        else {
            resetTimer();



        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
