package yctech.anoapp;


import android.os.IBinder;
import android.os.RemoteException;

public class MyRemoteService implements IMyServiceInterface{
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public void setData(String data) throws RemoteException {

    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
