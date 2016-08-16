package com.example.gabekeyner.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    Button playButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer playMusic = MediaPlayer.create(this,R.raw.civilwar);

        playButton = (Button) findViewById(R.id.playbutton);
        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                playMusic.start();

                Intent intent = new Intent(MainActivity.this,board.class);
                startActivity(intent);
                toast("This Is War!");
            }
        });
    }
    public void toast(String message) { //this will give a message every time  someone chooses
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();


    }
}
