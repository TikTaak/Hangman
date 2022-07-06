package com.arman.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView imageview;
    EditText edittext;
    TextView textview;
    Button button;
    int status = 1;
    String[] words = {"Ani", "Sam", "Joe"};
    int rnd = new Random().nextInt(words.length);
    String word = words[rnd];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imageview = findViewById(R.id.imageView);
        edittext = findViewById(R.id.editTextTextMultiLine);
        textview = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        textview.setText(word.charAt(0));


    }
    public void buttonOnClick(View v){
        List<Editable> playerGusses = new ArrayList<>();
        playerGusses.add(edittext.getText());
        for (int i = 1; i < word.length(); i++){
            if (playerGusses.contains(word.charAt(i))) {
                //textview.append(word.charAt(i));
                //Add = word.charAt(i);
                //textview.setText(textview.getText() + Add);
                textview.setText(textview.getText().toString() + word.charAt(i));
            }
            else{
                textview.setText(textview.getText().toString() + "-");
            }
        }
        ///////

    }














    public void buttonOnClick2 (View v){
        //textview.setText(word[1]);
        //imageview.setImageResource(R.drawable.hang1);
        if (status == 1){
            hang1Img();
        }
        if (status == 2){
            hang2Img();
        }
        if (status == 3){
            hang3Img();
        }
        if (status == 4){
            hang4Img();
        }
        if (status == 5){
            hang5Img();
        }
        if (status == 6){
            hang6Img();
        }
        status = status + 1;
    }

    /////////////////////////////////

    public void hang1Img(){
        imageview.setImageResource(R.drawable.hang1);
    }
    public void hang2Img(){
        imageview.setImageResource(R.drawable.hang2);
    }
    public void hang3Img(){
        imageview.setImageResource(R.drawable.hang3);
    }
    public void hang4Img(){
        imageview.setImageResource(R.drawable.hang4);
    }
    public void hang5Img(){
        imageview.setImageResource(R.drawable.hang5);
    }
    public void hang6Img(){
        imageview.setImageResource(R.drawable.hang6);
    }



}