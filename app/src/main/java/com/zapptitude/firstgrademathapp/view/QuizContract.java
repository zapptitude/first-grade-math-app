package com.zapptitude.firstgrademathapp.view;

public interface QuizContract {
    interface View {
        void showQuizInterface(Integer quizSize, Integer quizTiming);
    }

    interface UserActionListener {
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
