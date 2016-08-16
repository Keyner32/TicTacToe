package com.example.gabekeyner.tictactoe;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by GabeKeyner on 8/13/2016.
 */
public class board extends AppCompatActivity implements View.OnClickListener {



    boolean there_is_a_survivor = false;

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button[] bArray;
    boolean turn = true; //X=true O = false
    int turn_count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        //this links up my Buttons to the buttons in my layout file

        Button resetButton = (Button) findViewById(R.id.resetButton);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);


        //my arrray of buttons
        bArray = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};

        for (Button b : bArray) {

            b.setOnClickListener(this);

        }

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetgame();
            }
        });
    }


    //method will be use everytime the user picks a choice
    @Override
    public void onClick(View view) {
        Button b = (Button) view;

        buttonClicked(b);


    }


    public void toast(String message) { //this will give a message every time  someone chooses
        Toast.makeText(board.this, message, Toast.LENGTH_SHORT).show();
    }


    public void buttonClicked(Button b) {


        if (turn) {
            b.setText("I");final MediaPlayer playMusic = MediaPlayer.create(this,R.raw.arrowsflying);
            playMusic.start();
        } else {
            b.setText("C");
            final MediaPlayer playMusic = MediaPlayer.create(this,R.raw.gun);
            playMusic.start();        }

       turn_count++;

        b.setTextSize(80);
        b.setClickable(false);//this makes the button not clickable after its been hit

        turn = !turn;
        //makes a turn for each user
        checkForSurvivor();
    }
    /*TODO to be able to make the choice's into pictures instead of X's and O's than make an array list
    game array[] = {1,2,3,4,5,6,7,8,9}
     */

    public void checkForSurvivor() {

        //horizontal possibilities

        if (button8.getText() == button9.getText() && button9.getText() == button2.getText() && !button8.isClickable())
            there_is_a_survivor = true;

        else if (button7.getText() == button1.getText() && button1.getText() == button4.getText() && !button7.isClickable())
            there_is_a_survivor = true;
        else if (button6.getText() == button5.getText() && button5.getText() == button3.getText() && !button6.isClickable())
            there_is_a_survivor = true;
        //vertical outcomes
        if (button8.getText() == button7.getText() && button7.getText() == button6.getText() && !button8.isClickable())
            there_is_a_survivor = true;

        else if (button9.getText() == button1.getText() && button1.getText() == button5.getText() && !button9.isClickable())
            there_is_a_survivor = true;
        else if (button2.getText() == button4.getText() && button4.getText() == button3.getText() && !button2.isClickable())
            there_is_a_survivor = true;

            //the diagonals
        else if (button8.getText() == button1.getText() && button1.getText() == button3.getText() && !button8.isClickable())
            there_is_a_survivor = true;
        else if (button6.getText() == button1.getText() && button1.getText() == button2.getText() && !button6.isClickable())
            there_is_a_survivor = true;


        if (there_is_a_survivor) {
            if (turn) {//C = Cowboys
                toast("Cowboys Wins");


            } else {//I = Indians
                toast("Indians Wins");

            }


        }else if (turn_count == 9){
            toast("DRAW");

        }



    }

    public void resetgame(){

        there_is_a_survivor = false;

        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);
        button6.setClickable(true);
        button7.setClickable(true);
        button8.setClickable(true);
        button9.setClickable(true);

        turn_count=0;
    }


}