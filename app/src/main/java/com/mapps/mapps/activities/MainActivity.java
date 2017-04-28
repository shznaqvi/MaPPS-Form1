package com.mapps.mapps.activities;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import com.mapps.mapps.core.AndroidDatabaseManager;
import com.mapps.mapps.R;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.syncClasses.SycForms_Sec2;
import com.mapps.mapps.syncClasses.SyncForms;
import com.mapps.mapps.syncClasses.SyncForms_Sec4;


public class MainActivity extends Activity {

    private static final String TAG = "SyncForms";
    private EditText txturl_syncdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txturl_syncdata = (EditText) findViewById(R.id.txturl_syncdata);
    }


    public void syncData(View v) {

        Toast.makeText(getApplicationContext(), MAPPSApp._HOST_URL + "syncdata.php", Toast.LENGTH_LONG).show();
        SyncForms sec1 = new SyncForms(this);
        sec1.execute();

        Toast.makeText(getApplicationContext(), MAPPSApp._HOST_URL + "syncdata_sec2.php", Toast.LENGTH_LONG).show();
        SycForms_Sec2 sec2 = new SycForms_Sec2(this);
        sec2.execute();

        Toast.makeText(getApplicationContext(), MAPPSApp._HOST_URL + "syncdata_sec4.php", Toast.LENGTH_LONG).show();
        SyncForms_Sec4 sec4 = new SyncForms_Sec4(this);
        sec4.execute();

        //Intent dbmanager = new Intent(getApplicationContext(), SyncStatus.class);
        //startActivity(dbmanager);

        /*if (txturl_syncdata.getText().toString().isEmpty() || txturl_syncdata.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "URL could not be left blank ", Toast.LENGTH_LONG).show();
            txturl_syncdata.requestFocus();
        } else {

            String[] arr = txturl_syncdata.getText().toString().split("/");

            if (arr[4].equals("syncdata.php")) {

                CVars var = new CVars();
                var.set_url_sync_sec1(txturl_syncdata.getText().toString());
                SyncForms ff = new SyncForms(this);
                ff.execute();
            }

            if (arr[4].equals("syncdata_sec2.php")) {

                CVars var = new CVars();
                var.set_url_sync_sec1(txturl_syncdata.getText().toString());
                SycForms_Sec2 ff = new SycForms_Sec2(this);
                ff.execute();
            }

            if (arr[4].equals("syncdata_sec4.php")) {

                CVars var = new CVars();
                var.set_url_sync_sec1(txturl_syncdata.getText().toString());
                SyncForms_Sec4 ff = new SyncForms_Sec4(this);
                ff.execute();
            }

        }*/
    }


    public void syncData_Sec2(View v) {

        Toast.makeText(getApplicationContext(), "http://10.1.79.42:8080/mapps/syncdata_sec2.php", Toast.LENGTH_LONG).show();

        SycForms_Sec2 ff = new SycForms_Sec2(this);
        ff.execute();
    }

    public void syncData_Sec4(View v) {

        Toast.makeText(getApplicationContext(), "http://10.1.79.42:8080/mapps/syncdata_sec4.php", Toast.LENGTH_LONG).show();

        SyncForms_Sec4 ff = new SyncForms_Sec4(this);
        ff.execute();
    }


    public void OpenDB(View v) {
        Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }
}