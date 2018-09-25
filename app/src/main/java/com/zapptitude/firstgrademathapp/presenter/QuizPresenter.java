package com.zapptitude.firstgrademathapp.presenter;

import android.content.Context;

import com.zapptitude.firstgrademathapp.R;
import com.zapptitude.firstgrademathapp.view.QuizContract;

import org.firestar.data.IDataRepository;
import org.firestar.data.IDataServiceApi;
import org.firestar.model.AppData;
import org.firestar.model.BundleData;
import org.firestar.model.Deck;
import org.firestar.model.DeckBundle;
import org.firestar.model.UserAppData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import timber.log.Timber;

public class QuizPresenter implements QuizContract.UserActionListener{
    private QuizContract.View mQuizView;
    private IDataRepository mRepository;
    private Context mContext;

    private DeckBundle mDeckBundle = null;

    public QuizPresenter(Context context, IDataRepository repository, QuizContract.View quizView){
        mContext = context;
        mRepository = repository;
        mQuizView = quizView;
    }

    @Override
    public void getAppData(String appId, IDataServiceApi.DataServiceCallback dataServiceCallback) {
        mRepository.getAppData(appId, null, dataServiceCallback);
    }

    @Override
    public void prepareApp(Context context, BundleData bundleData) {
        IDataServiceApi.DataServiceCallback callback = new IDataServiceApi.DataServiceCallback() {
            @Override
            public void onLoaded(ArrayList arrayList) {
                Timber.d("Loaded arraylist: " + arrayList);
                if (arrayList.get(0) instanceof DeckBundle) {
                    mDeckBundle = (DeckBundle) arrayList.get(0);
                    mQuizView.showLevels(mDeckBundle);
                }
            }

            @Override
            public void onLoaded(List list) {
                Timber.d("Loaded list: " + list);
            }

            @Override
            public void onAppDataLoaded(AppData appData) {
                Timber.d("Loaded appdata: " + appData);
            }

            @Override
            public void onAppDataLoaded(UserAppData userAppData) {
                Timber.d("Loaded appdata User data: " + userAppData);
            }

            @Override
            public void failure(String s) {
                Timber.d("failure: " + s);

            }
        };

        mRepository.getBundle(0, "null", bundleData, callback);
    }

    @Override
    public void loadLevels() {
        init(mContext);
    }

    private void init(Context context) {
        IDataServiceApi.DataServiceCallback callback = new IDataServiceApi.DataServiceCallback() {
            @Override
            public void onLoaded(ArrayList arrayList) {
                Timber.d("Loaded arraylist: " + arrayList);
            }

            @Override
            public void onLoaded(List list) {
                Timber.d("Loaded list: " + list);
            }

            @Override
            public void onAppDataLoaded(AppData appData) {
                Timber.d("Loaded appdata: " + appData);
                if (appData.getBundles().size() == 1) {
                    HashMap<String, BundleData> map = appData.getBundles();
                    for (Map.Entry<String, BundleData> entry: map.entrySet()) {
                        BundleData bundleData = entry.getValue();
                        prepareApp(mContext, bundleData);
                        break;
                    }
                }
            }

            @Override
            public void onAppDataLoaded(UserAppData userAppData) {
                Timber.d("Loaded appdata User data: " + userAppData);
            }

            @Override
            public void failure(String s) {
                Timber.d("failure: " + s);

            }
        };

        String appId = context.getPackageName().replace(".", "_");
        getAppData(appId, callback);
    }

    //Fetch quiz size and timing details from remote or local server to render quiz UI
    @Override
    public void loadQuizConfig() {
        //TODO: Save this configuration in AppPrefsLocal
        Integer quizSize = 10; //10 questions per quiz
        Integer quizTiming = 5; //In minutes
        mQuizView.showQuizInterface(quizSize, quizTiming);
    }

    //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
    @Override
    public void updateQuizSize(int size) {

        // this info shall be passed to the Model.setNumbQ
    }

    @Override
    public void updateQuizContext(int context) {
        // this is a stub for addition when context = 0 and for subtraction when context = 1
        // this info shall be passed to the Model.setContext
    }

    @Override
    public void updateTaskTiming(int timing) {
        // this is a stub for time limit per task in minutes
        // this info shall be retained within Presenter to setup time out event
    }

    @Override
    public void updateTaskAnswer(int answer) {
        // this is a stub for the answer posted by the user
        // this info shall be passed to the Model.setAnswer
    //TODO: update quiz size in sharedPrefs/AppPrefsLocalq

    }
}
