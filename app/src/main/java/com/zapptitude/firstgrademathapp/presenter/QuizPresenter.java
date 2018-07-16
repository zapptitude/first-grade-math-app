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
    }
}
