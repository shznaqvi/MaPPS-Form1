package com.mapps.mapps.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mapps.mapps.R;
import com.mapps.mapps.core.CVars;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.getClasses.GetHFList;
import com.mapps.mapps.getClasses.GetUsers;
import com.mapps.mapps.syncClasses.SycForms_Sec2;
import com.mapps.mapps.syncClasses.SyncForms;
import com.mapps.mapps.syncClasses.SyncForms_Sec4;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MainPageActivity extends Activity {

    public static final String TAG = "";

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    TextView username;
    LinearLayout vu_s1q13;
    LinearLayout vu_opendb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        vu_opendb = (LinearLayout) findViewById(R.id.vu_opendb);

//        CVars var = new CVars();
//
//        if (CVars.myuser != null) {
            username = (TextView) findViewById(R.id.username);
            username.setText("Welcome : " + MAPPSApp.user[1].toUpperCase());
//        }


        if (CVars.isadmin.equals("1")) {
            vu_opendb.setVisibility(View.VISIBLE);
        } else {
            vu_opendb.setVisibility(View.GONE);
        }

    }

    public void OpenForm(View v) {
        Intent sec1_intent = new Intent(this, Section1Activity.class);
        startActivity(sec1_intent);
    }

    public void Logout(View v) {
        CVars.myuser = null;
        Intent login_intent = new Intent(this, LoginActivity.class);
        startActivity(login_intent);
    }

    public void OpenDBAccess(View v) {
        Intent sec2_intent = new Intent(this, MainActivity.class);
        startActivity(sec2_intent);
    }

    public void testGPS(View v) {

        SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        Log.d("MAP", "testGPS: " + sharedPref.getAll().toString());
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("Map", entry.getKey() + ": " + entry.getValue().toString());
        }

    }

    public void syncData(View v) {
        //Intent sec2_intent = new Intent(this, SyncForms.class);
        //startActivity(sec2_intent);

        //Intent sec3_intent = new Intent(this, SyncForms_Section2.class);
        //startActivity(sec3_intent);

        //String stringUrl = MAPPSApp._HOST_URL + "/mapps/syncdata_sec2.php";

        //Log.d(TAG, "i m url : " + stringUrl);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            SyncForms sf = new SyncForms(this);
            sf.execute();

            //new SyncForms_Section2(this).execute(stringUrl);
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }


    public void syncData2(View v) {
        //Intent sec2_intent = new Intent(this, SyncForms.class);
        //startActivity(sec2_intent);

        //Intent sec3_intent = new Intent(this, SyncForms_Section2.class);
        //startActivity(sec3_intent);

        //String stringUrl = MAPPSApp._HOST_URL + "/mapps/syncdata_sec2.php";

        //Log.d(TAG, "i m url : " + stringUrl);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            SycForms_Sec2 sf = new SycForms_Sec2(this);
            sf.execute();

            //new SyncForms_Section2(this).execute(stringUrl);
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }


    public void OpenGetHF(View v) {
        Intent sec2_intent = new Intent(this, GetHFList.class);
        startActivity(sec2_intent);
    }


    public void syncData4(View v) {
        //Intent sec2_intent = new Intent(this, SyncForms.class);
        //startActivity(sec2_intent);

        //Intent sec3_intent = new Intent(this, SyncForms_Section2.class);
        //startActivity(sec3_intent);

        //String stringUrl = MAPPSApp._HOST_URL + "/mapps/syncdata_sec2.php";

        //Log.d(TAG, "i m url : " + stringUrl);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Toast.makeText(getApplicationContext(), "Syncing Section 4", Toast.LENGTH_SHORT).show();
            new SyncForms_Sec4(this).execute();

            //new SyncForms_Section2(this).execute(stringUrl);
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }


    public void syncServer(View view) {

        String stringUrl = MAPPSApp._HOST_URL + "/mapps/syncdata_sec2.php";

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
//            new SyncForms_Section2(this).execute(stringUrl);
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }


       /* if (isNetworkAvailable()) {
            SyncForms ff = new SyncForms(this);
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            ff.execute();
            SyncIMs im = new SyncIMs(this);
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            im.execute();
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();
            editor.putString("LastSyncServer", dtToday);
            editor.apply();
        }*/
    }

    public void syncDevice(View view) {
        if (isNetworkAvailable()) {

            GetUsers gu = new GetUsers(this);
            Toast.makeText(getApplicationContext(), "Syncing Users", Toast.LENGTH_SHORT).show();
            gu.execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo(DOWN)", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastSyncDevice ", dtToday);

            editor.apply();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private boolean isHostAvailable() {

        if (isNetworkAvailable()) {
            try {
                SocketAddress sockaddr = new InetSocketAddress(MAPPSApp._IP, MAPPSApp._PORT);
                // Create an unbound socket
                Socket sock = new Socket();

                // This method will block no more than timeoutMs.
                // If the timeout occurs, SocketTimeoutException is thrown.
                int timeoutMs = 2000;   // 2 seconds
                sock.connect(sockaddr, timeoutMs);
                return true;
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Server Not Available for Update", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            Toast.makeText(getApplicationContext(), "Network not available for Update", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(MainPageActivity.this, "Back button is disabled", Toast.LENGTH_LONG).show();
    }
}