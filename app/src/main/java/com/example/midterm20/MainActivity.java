package com.example.midterm20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bttn2= (Button) findViewById(R.id.bttn2);
        Button bttn3= (Button) findViewById(R.id.bttn3);

        ImageButton imgbttn= (ImageButton) findViewById(R.id.imageButton);

        //ImageView img= (ImageView) findViewById(R.id.imgCat);
        mediaPlayer= new MediaPlayer();
        mediaPlayer= MediaPlayer.create(this, R.raw.track14);
        playing=0;

        imgbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (playing){
                    case 0:
                        mediaPlayer.start();
                        playing=1;
                        break;
                    case 1:
                        mediaPlayer.pause();
                        playing=0;
                        break;
                }

            }
        });



        bttn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity2.class));

            }
        });

        bttn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity3.class));

            }
        });


    }
}