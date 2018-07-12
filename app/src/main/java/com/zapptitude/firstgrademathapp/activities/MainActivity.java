package com.zapptitude.firstgrademathapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zapptitude.firstgrademathapp.R;

import java.util.Random;

import mev.zappsdk.modules.Zapptitude;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initQuestion();
    }

    /**
     * question setup for layout test
     */
    private void initQuestion() {
        // init view elements
        final TextView questionView = findViewById(R.id.question_text);
        final EditText answerInput = findViewById(R.id.answer_input);
        final Button submitButton = findViewById(R.id.submit);

        // generate two random numbers for question, (var1+var2) <= 20
        Random r = new Random();
        int low = 1;
        int high = 19;
        final int var1 = r.nextInt(high - low) + low;
        final int var2 = r.nextInt(high - var1) + low;
        final int expectedAnswer = var1 + var2;

        // getting string question from template and replacing variables with generated numbers
        String question = getResources().getString(R.string.question_template, var1, var2);
        questionView.setText(question);

        // set click listener for submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int userAnswer = getUserAnswer(answerInput);
                    checkAnswer(userAnswer, expectedAnswer);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter an integer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getUserAnswer(EditText answerInput) throws NumberFormatException {
        String answerString = answerInput.getText().toString();
        return Integer.parseInt(answerString);
    }

    private void checkAnswer(int actual, int expected) {
        if (actual == expected) {
            Toast.makeText(this, "You're correct 😊", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You're wrong 😒", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Common core standard description
     * CCSS.MATH.CONTENT.1.OA.A.1
     * Use addition and subtraction within 20 to solve word problems involving situations of adding
     * to, taking from, putting together, taking apart, and comparing, with unknowns in all
     * positions, e.g., by using objects, drawings, and equations with a symbol for the unknown
     * number to represent the problem.

     * Sample Zapptitude event logged for a given task
     */

    /**
     * Beginning a Task for a given context
     */
    void logBeginTaskExample1() {
        String task = "3+3=?";
        String context = "addition";


        Zapptitude.logBeginTask(task, context);
    }

    void logSolvedIntTaskExample1() {
        String task = "3+3=?";
        String context = "addition";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 6;
        int actual = 6;

        Zapptitude.logSolveIntTask(task, context,
                topic, expected, actual);
    }


    void logSolvedIntTaskExample2() {
        String task = "3-1=?";
        String context = "subtraction";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 2;
        int actual = 2;

        Zapptitude.logSolveIntTask(task, context,
                topic, expected, actual);
    }

    /**
     * Once Zapptitude is enabled in app, it sends event data anonymously unless a Zid is requested.
     * Zid is important when user wishes to see progress reports at Zapptitude's dashboard.
     */
    void requestZid() {
        Zapptitude.requestZappId();
    }

}
