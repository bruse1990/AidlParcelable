package com.caomingyu.parcelableserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caomingyu on 2018/11/20.
 */

public class IRemoteService extends Service {

    private List<Person> personList;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        personList = new ArrayList<Person>();
        return iBinder;
    }

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public List<Person> addPerson(Person person) throws RemoteException {
            Log.d("personList", "addPerson: " + personList.toString());
            personList.add(person);
            return personList;
        }
    };
}
