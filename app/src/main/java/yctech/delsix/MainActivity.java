package yctech.delsix;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import yctech.anoapp.IMyServiceInterface;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    Button staAnS;
    private Button stoAnS;
    Intent intent;
    ComponentName componentName;
    IMyServiceInterface iMyServiceInterface;
    Button jh;
    EditText ed;

    private void assignViews() {
        staAnS = (Button) findViewById(R.id.staAnS);
        stoAnS = (Button) findViewById(R.id.stoAnS);
        jh = (Button) findViewById(R.id.jh);
        ed = (EditText) findViewById(R.id.edt);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();
        intent = new Intent();
        staAnS.setOnClickListener(this);
        stoAnS.setOnClickListener(this);
        componentName = new ComponentName("yctech.anoapp","yctech.anoapp.MyService");
        intent.setComponent(componentName);
        jh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.staAnS:
                bindService(intent, this, Context.BIND_AUTO_CREATE);
                break;
            case R.id.stoAnS:
                unbindService(this);
                break;
            case R.id.jh:
                try {
                    iMyServiceInterface.setData(ed.getText().toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
           iMyServiceInterface= IMyServiceInterface.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
