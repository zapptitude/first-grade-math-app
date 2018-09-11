package com.zapptitude.firstgrademathapp.view;

public interface QuizContract {
    interface View {
        void showQuizInterface(Integer quizSize, Integer quizTiming);
        void showLevelUI();
    }

    interface UserActionListener {
        void loadLevels();
        void loadQuizConfig();

        //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
        //TODO: Create a QuizConfig class that encapsulates quiz's details like size, timing, questions etc
        //void updateQuizConfig(QuizConfig quizConfig);

        //sample
        void updateQuizSize(int size);
    }
}
