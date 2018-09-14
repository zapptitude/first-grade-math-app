package com.zapptitude.firstgrademathapp.view;

import android.content.Context;

import org.firestar.data.IDataServiceApi;
import org.firestar.model.BundleData;
import org.firestar.model.DeckBundle;

public interface QuizContract {
    interface View {
        void showQuizInterface(Integer quizSize, Integer quizTiming);
        void showLevels(DeckBundle deckBundle);
    }

    interface UserActionListener {
        //fetch app's data from remote repo
        void getAppData(String appId, IDataServiceApi.DataServiceCallback dataServiceCallback);
        void prepareApp(Context context, BundleData bundleData);

        void loadLevels();
        void loadQuizConfig();

        //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
        //TODO: Create a QuizConfig class that encapsulates quiz's details like size, timing, questions etc
        //void updateQuizConfig(QuizConfig quizConfig);

        //sample
        void updateQuizSize(int size); // no. of tasks in a quiz

        void updateQuizContext(int context); // where 0 is addition(default) and 1 is subtraction

        void updateTaskTiming(int timing); // in the unit of minutes per task

        void updateTaskAnswer(int answer); // answer posted by the user
    }
}
