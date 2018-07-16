package com.zapptitude.firstgrademathapp.data;

public class DataRepository implements IDataRepository {
    private DataServiceLocal mDataServiceLocal = null;
    private DataServiceRemote mDataServiceRemote= null;

    DataRepository(DataServiceLocal dataServiceLocal, DataServiceRemote dataServiceRemote) {
        mDataServiceLocal = dataServiceLocal;
        mDataServiceRemote = dataServiceRemote;
    }

    // Note: Request data from remote API first and fallback to local data.
    @Override
    public Integer getQuizSize() {
        Integer quizSize = mDataServiceRemote.getQuizSize();
        if (quizSize == null || quizSize < 1) {
            quizSize = mDataServiceLocal.getQuizSize();
        }

        return quizSize;
    }

    @Override
    public Integer getQuizTiming() {
        Integer quizTiming = mDataServiceRemote.getQuizTiming();
        if (quizTiming == null || quizTiming < 1) {
            quizTiming = mDataServiceLocal.getQuizTiming();
        }

        return quizTiming;
    }

    //Note: Quiz details are updated to current user only. so all changes will be updated locally only.
    @Override
    public void updateQuizSize(int size) {
        mDataServiceLocal.setQuizSize(size);
    }
}
