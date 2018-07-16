package com.zapptitude.firstgrademathapp.data;

public interface IDataServiceApi {
    //Returns number of questions per quiz
    Integer getQuizSize();

    //Returns time in minutes
    Integer getQuizTiming();

    //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
    void setQuizSize(int size);
}
