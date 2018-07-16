package com.zapptitude.firstgrademathapp.data;

import android.content.Context;

public class Injection {
    public static IDataRepository getDataRepository(Context context) {
        return new DataRepository(new DataServiceLocal(context),
                new DataServiceRemote(context));
    }
}
