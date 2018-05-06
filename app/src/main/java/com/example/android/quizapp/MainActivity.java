package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app is a Quiz on Sports
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when submit button is clicked
     */
    public void submitAnswers(View view) {
        //Finds out test takers name
        EditText userName = (EditText) findViewById(R.id.testersName);
        String name = userName.getText().toString();

        //Figures out if correct answer chosen for Q1
        CheckBox q1OptionA = (CheckBox) findViewById(R.id.Q1_option_A_checkbox);
        boolean q1OptionAChecked = q1OptionA.isChecked();

        CheckBox q1OptionB = (CheckBox) findViewById(R.id.Q1_option_B_checkbox);
        boolean q1OptionBChecked = q1OptionB.isChecked();

        CheckBox q1OptionC = (CheckBox) findViewById(R.id.Q1_option_C_checkbox);
        boolean q1OptionCChecked = q1OptionC.isChecked();

        CheckBox q1OptionD = (CheckBox) findViewById(R.id.Q1_option_D_checkbox);
        boolean q1OptionDChecked = q1OptionD.isChecked();

        //Figures out if correct answer chosen for Q2
        RadioButton q2OptionB = (RadioButton) findViewById(R.id.Q2_B_button);
        boolean q2OptionBChecked = q2OptionB.isChecked();

        //Figures out if correct answer chosen for Q3
        RadioButton q3OptionD = (RadioButton) findViewById(R.id.Q3_D_Button);
        boolean q3OptionDChecked = q3OptionD.isChecked();

        //Figures out if correct answer chosen for Q4
        CheckBox q4OptionA = (CheckBox) findViewById(R.id.Q4_option_A_checkbox);
        boolean q4OptionAChecked = q4OptionA.isChecked();

        CheckBox q4OptionB = (CheckBox) findViewById(R.id.Q4_option_B_checkbox);
        boolean q4OptionBChecked = q4OptionB.isChecked();

        CheckBox q4OptionC = (CheckBox) findViewById(R.id.Q4_option_C_checkbox);
        boolean q4OptionCChecked = q4OptionC.isChecked();

        CheckBox q4OptionD = (CheckBox) findViewById(R.id.Q4_option_D_checkbox);
        boolean q4OptionDChecked = q4OptionD.isChecked();

        //Figures out if correct answer chosen for Q5
        RadioButton q5OptionC = (RadioButton) findViewById(R.id.Q5_C_Button);
        boolean q5OptionCChecked = q5OptionC.isChecked();

        //Figures out if correct answer chosen for Q6
        CheckBox q6OptionA = (CheckBox) findViewById(R.id.Q6_option_A_checkbox);
        boolean q6OptionAChecked = q6OptionA.isChecked();

        CheckBox q6OptionB = (CheckBox) findViewById(R.id.Q6_option_B_checkbox);
        boolean q6OptionBChecked = q6OptionB.isChecked();

        CheckBox q6OptionC = (CheckBox) findViewById(R.id.Q6_option_C_checkbox);
        boolean q6OptionCChecked = q6OptionC.isChecked();

        CheckBox q6OptionD = (CheckBox) findViewById(R.id.Q6_option_D_checkbox);
        boolean q6OptionDChecked = q6OptionD.isChecked();

        int finalScore = calculateScore(q1OptionAChecked, q1OptionBChecked, q1OptionCChecked, q1OptionDChecked, q2OptionBChecked, q3OptionDChecked, q4OptionAChecked, q4OptionBChecked, q4OptionCChecked, q4OptionDChecked, q5OptionCChecked, q6OptionAChecked, q6OptionBChecked, q6OptionCChecked, q6OptionDChecked);
        String finalMessage = createFinalMessage(name, finalScore);

        displayFinalMessage(finalMessage);
    }

    /**
     * Calculates the finalScore
     *
     * @return final score
     */
    public int calculateScore(boolean q1OptionAChecked, boolean q1OptionBChecked, boolean q1OptionCChecked, boolean q1OptionDChecked, boolean q2OptionBChecked, boolean q3OptionDChecked, boolean q4OptionAChecked, boolean q4OptionBChecked, boolean q4OptionCChecked, boolean q4OptionDChecked, boolean q5OptionCChecked, boolean q6OptionAChecked, boolean q6OptionBChecked, boolean q6OptionCChecked, boolean q6OptionDChecked) {
        //The beginning score of every quiz
        int startScore = 0;

        //adds 3 pts for question 1
        if ((q1OptionAChecked) && (q1OptionBChecked) && (q1OptionCChecked) && !(q1OptionDChecked)) {
            startScore += 3;
        } else {
            showScore(startScore);
        }

        //adds 1 pt for question 2
        if (q2OptionBChecked) {
            startScore += 1;
        } else {
            showScore(startScore);
        }

        //adds 1 pt for question 3
        if (q3OptionDChecked) {
            startScore += 1;
        } else {
            showScore(startScore);
        }

        //adds 2pts for question 4
        if ((q4OptionAChecked) && (q4OptionBChecked) && !(q4OptionCChecked) && !(q4OptionDChecked)) {
            startScore += 2;
        } else {
            showScore(startScore);
        }

        //adds 1pt for question 5
        if (q5OptionCChecked) {
            startScore += 1;
        } else {
            showScore(startScore);
        }
        //adds 2pts for question 6
        if ((q6OptionAChecked) && (q6OptionBChecked) && !(q6OptionCChecked) && !(q6OptionDChecked)) {
            startScore += 2;
        } else {
            showScore(startScore);
        }
        return startScore;
    }

    /**
     * This method displays the Final message
     *
     * @param startScore provides score for quiz
     * @param name       is the quiz test takers name
     * @return text summary
     */
    private String createFinalMessage(String name, int startScore) {

        String finalMessage = name;
        finalMessage += "\nFinal Score: " + startScore + " out of 10!";
        finalMessage += "\nYou finished!";
        return finalMessage;
    }

    /**
     * These methods displays Final Score and message on the screen.
     */
    private void displayFinalMessage(String message) {
        TextView finalMessageTextView = (TextView) findViewById(R.id.result_message);
        finalMessageTextView.setText(message);
    }

    public void showScore(int startScore) {
        TextView finalMessageTextView = (TextView) findViewById(R.id.result_message);
        finalMessageTextView.setText("" + startScore);

        Toast.makeText(MainActivity.this, "Great Job! You scored " + startScore + " out of 10!!", Toast.LENGTH_SHORT).show();
    }

}
