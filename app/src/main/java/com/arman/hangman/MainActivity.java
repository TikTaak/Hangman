package com.arman.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageview;
    private EditText edittext;
    private TextView textview;
    private TextView textview2;
    private TextView textview3;
    private EditText editText2;
    private TextView invisible;

    private Button button;
    private String word;
    private int status = 1;
    private int testCorecction = 0;
    private int correct = 0;
    List<Character> playerGusses = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrayOfWords = {"hello", "mahin", "aghdas", "goodbye", "man", "woman"};
        int rnd = new Random().nextInt(arrayOfWords.length);
        word = arrayOfWords[rnd];

        imageview = findViewById(R.id.imageView);
        edittext = findViewById(R.id.editTextTextMultiLine);
        textview = findViewById(R.id.textView);
        textview2 = findViewById(R.id.textView2);
        textview3 = findViewById(R.id.textView3);
        editText2 = findViewById(R.id.editText2);
        invisible = findViewById(R.id.invisible);
        button = findViewById(R.id.button);
        textview.setText("");
        textview2.setText(word);
        for (int i = 0; i < word.length(); i++){
            textview.setText(textview.getText().toString() + "- ");
        }

    }
    public void buttonOnClick(View v){

        textview.setText("");
        String letterGuss = edittext.getText().toString();
        playerGusses.add(letterGuss.charAt(0));
        printWordState(word, playerGusses);
        //printWordTest(word, playerGusses);
        edittext.setText("");
        ///////

    }
    public void printWordState(String word, List<Character> playerGusses){

        testCorecction = correct;
        correct = 0;
        for (int i = 0; i < word.length(); i++){
            if (playerGusses.contains(word.charAt(i))) {
                correct++;
                textview.setText(textview.getText().toString() + word.charAt(i) + " ");
            }
            else{
                textview.setText(textview.getText().toString() + "- ");
            }

        }


        if (testCorecction == correct){
            incorrectSelection();
        }

        //editText2.setText("Corrects = " + Integer.toString(correct));

        if (correct == word.length()){
            incorrectSelection();
            editText2.setText("You Win");
        }

    }
    /*
    public boolean printWordTest(String word, List<Character> playerGusses){

        int correctCount = 0;

        for (int i = 0; i < word.length(); i++){
            if (playerGusses.contains(word.charAt(i))) {
                invisible.setText(textview.getText().toString() + word.charAt(i) + " ");
                correctCount++;
            }
            else{
                invisible.setText(textview.getText().toString() + "- ");
            }

        }
        if (testCorecction== correct){
            incorrectSelection();
        }

        //editText2.setText("Corrects = " + Integer.toString(correct));

        if (correct == word.length()){
            incorrectSelection();
            editText2.setText("You Win");
        }

        return (word.length() == correctCount);
    }*/
    ///////////////
    public void incorrectSelection() {
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