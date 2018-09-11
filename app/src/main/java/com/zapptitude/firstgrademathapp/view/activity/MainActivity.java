package com.zapptitude.firstgrademathapp.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.zapptitude.firstgrademathapp.R;
import com.zapptitude.firstgrademathapp.data.Injection;
import com.zapptitude.firstgrademathapp.presenter.QuizPresenter;
import com.zapptitude.firstgrademathapp.view.QuizContract;
import com.zapptitude.firstgrademathapp.view.fragments.LevelsFragment;

import mev.zappsdk.modules.Zapptitude;

public class MainActivity
        extends BaseActivity
        implements QuizContract.View, LevelsFragment.OnFragmentInteractionListener {

    private QuizContract.UserActionListener mUserActionListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserActionListener =
                new QuizPresenter(this, Injection.getDataRepository(this), this);

        mUserActionListener.loadQuizConfig();
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

    //This is where quiz UI rendering happens
    @Override
    public void showQuizInterface(Integer quizSize, Integer quizTiming) {
        //TODO: Render main quiz UI here. Quiz view is based on quiz config: size and timing .
    }

    @Override
    public void showLevelUI() {
        Fragment fragLevels = new LevelsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.replace_me, fragLevels)
                .addToBackStack(null).commitAllowingStateLoss();
    }

    //Start the app
    public void onBasketClick(View view) {
        mUserActionListener.loadLevels();
    }

    //control will here when user interacts with LevelsFragment widgets
    @Override
    public void onLevelsFragmentInteraction(Uri uri) {

    }
}
