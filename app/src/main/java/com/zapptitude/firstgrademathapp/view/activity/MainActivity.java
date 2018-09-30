package com.zapptitude.firstgrademathapp.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import com.zapptitude.firstgrademathapp.BuildConfig;
import com.zapptitude.firstgrademathapp.R;
import com.zapptitude.firstgrademathapp.app.ZappApplication;
import com.zapptitude.firstgrademathapp.presenter.QuizPresenter;
import com.zapptitude.firstgrademathapp.view.QuizContract;
import com.zapptitude.firstgrademathapp.view.fragments.LevelsFragment;
import com.zapptitude.firstgrademathapp.view.fragments.QuizFragment;

import org.firestar.data.Injection;
import org.firestar.data.SimpleDataFilterServiceImpl;
import org.firestar.model.Deck;
import org.firestar.model.DeckBundle;
import org.firestar.model.DeckCard;

import timber.log.Timber;

public class MainActivity
        extends BaseActivity
        implements QuizContract.View,
        LevelsFragment.OnFragmentInteractionListener,
        QuizFragment.OnListFragmentInteractionListener {

    private QuizContract.UserActionListener mUserActionListener = null;

    private SimpleDataFilterServiceImpl mFilter = null;
    private org.firestar.app.AppPrefs appPrefs;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // display the basket view
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        appPrefs = ZappApplication.getSingleton().getAppPrefs();
        mContext = getApplicationContext();

        mFilter = new SimpleDataFilterServiceImpl(appPrefs.getDeckRandomLimit(),
                appPrefs.getDeckRandomLimit()>0,
                appPrefs.getCardRandomLimit(), appPrefs.getCardRandomLimit()>0);
        mUserActionListener =
                new QuizPresenter(this, Injection.Companion.getDataRepository(this, mFilter), this);

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


        //Zapptitude.logBeginTask(task, context);
    }

    void logSolvedIntTaskExample1() {
        String task = "3+3=?";
        String context = "addition";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 6;
        int actual = 6;

        //Zapptitude.logSolveIntTask(task, context, topic, expected, actual);
    }


    void logSolvedIntTaskExample2() {
        String task = "3-1=?";
        String context = "subtraction";
        String topic = "CCSS.MATH.CONTENT.1.OA.A.1";
        int expected = 2;
        int actual = 2;

        //Zapptitude.logSolveIntTask(task, context, topic, expected, actual);
    }

    /**
     * Once Zapptitude is enabled in app, it sends event data anonymously unless a Zid is requested.
     * Zid is important when user wishes to see progress reports at Zapptitude's dashboard.
     */
    void requestZid() {
        ///Zapptitude.requestZappId();
    }

    //This is where quiz UI rendering happens
    //It is part of the QuizContract.View interface
    @Override
    public void showQuizInterface(Integer quizSize, Integer quizTiming) {
        //TODO: Render main quiz UI here. Quiz view is based on quiz config: size and timing .
    }

    //Show all levels available
    //It is part of the QuizContract.View interface
    @Override
    public void showLevels(DeckBundle deckBundle) {
        Fragment fragLevels = LevelsFragment.newInstance(deckBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.replace_me, fragLevels)
                .addToBackStack(null).commitAllowingStateLoss();
    }

    //Start the app
    public void onBasketClick(View view) {
        mUserActionListener.loadLevels();
        //setContentView(R.layout.fragment_levels);  // display the smiley green apple view
    }

    // choose the view levels : alg. expr. , word, grouping, or number bond
    public void onAlgExprClick(View view) {
        setContentView(R.layout.fragment_level_expr);  // display the quiz tree view
    }

    //control will here when user interacts with LevelsFragment widgets
    @Override
    public void onLevelClick(Deck deck) {
        //open quiz in recylerview
        Toast.makeText(mContext, "Level selected: " + deck.getDeckName()
                , Toast.LENGTH_LONG).show();

        Fragment fragLevels = QuizFragment.newInstance(deck);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.replace_me, fragLevels)
                .addToBackStack(null).commitAllowingStateLoss();
    }

    @Override
    public void onListFragmentInteraction(DeckCard task) {
        Toast.makeText(mContext, "Not yet implemented", Toast.LENGTH_LONG).show();
    }
}
