package com.zapptitude.firstgrademathapp.presenter;

import android.content.Context;

import com.zapptitude.firstgrademathapp.data.IDataRepository;
import com.zapptitude.firstgrademathapp.view.QuizContract;

public class QuizPresenter implements QuizContract.UserActionListener{
    private QuizContract.View mQuizView;
    private IDataRepository mRepository;
    private Context mContext;

    public QuizPresenter(Context context, IDataRepository repository,
                  QuizContract.View quizView){
        mContext = context;
        mRepository = repository;
        mQuizView = quizView;
    }

    //Fetch quiz size and timing details from remote or local server to render quiz UI
    @Override
    public void loadQuizConfig() {
        Integer quizSize = mRepository.getQuizSize();
        Integer quizTiming = mRepository.getQuizTiming();
        mQuizView.showQuizInterface(quizSize, quizTiming);
    }

    //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
    @Override
    public void updateQuizSize(int size) {
        mRepository.updateQuizSize(size);
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
    }
}
