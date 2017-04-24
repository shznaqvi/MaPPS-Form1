package com.mapps.mapps;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;


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

        Toast.makeText(getApplicationContext(), "http://10.198.97.9/mappsweb/syncdata.php", Toast.LENGTH_LONG).show();

        SyncForms ff = new SyncForms(this);
        ff.execute();

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