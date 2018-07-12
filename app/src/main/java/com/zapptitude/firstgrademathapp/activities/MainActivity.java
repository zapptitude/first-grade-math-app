package com.zapptitude.firstgrademathapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zapptitude.firstgrademathapp.R;

import mev.zappsdk.modules.Zapptitude;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initQuestion();
    }

    private void initQuestion() {
        TextView questionView = findViewById(R.id.question_text);
        EditText answerInput = findViewById(R.id.answer_input);
        Button submit = findViewById(R.id.submit);


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
