package com.zapptitude.firstgrademathapp.data;

public interface IDataRepository {

    //Note: These interfaces are for demonstrate purpose.
    //It makes more sense for interface to return a QuizConfig object

    //Returns number of questions per quiz
    Integer getQuizSize();

    //Returns time in minutes
    Integer getQuizTiming();

    //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
    void updateQuizSize(int size);
}
