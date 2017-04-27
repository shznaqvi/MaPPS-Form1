package com.mapps.mapps.getClasses;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mapps.mapps.core.CVars;
import com.mapps.mapps.otherClasses.Members;
import com.mapps.mapps.R;
import com.mapps.mapps.contracts.GetHFContract;
import com.mapps.mapps.contracts.UsersContract;
import com.mapps.mapps.core.MAPPSHelper;

import java.util.Collection;

public class GetHFList extends Activity {

    private final String TAG = "GetHF";
    private Button btnGetHF;
    private EditText txturl;
    private Button btnGetLHW;
    private EditText txturllhw;
    private Button btnGetUsers;
    private EditText txturlusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_hflist);

        txturl = (EditText) findViewById(R.id.txturl);
        btnGetHF = (Button) findViewById(R.id.btnGetHF);

        txturllhw = (EditText) findViewById(R.id.txturllhw);
        btnGetLHW = (Button) findViewById(R.id.btnGetHF);

        txturlusers = (EditText) findViewById(R.id.txturl_users);
        btnGetUsers = (Button) findViewById(R.id.btnGetUsers);
    }

    public void getHF(View v) {

        if (txturl.getText().toString().isEmpty() && txturl.getText().toString() == null) {
            Toast.makeText(this, "Please enter url to get the cluster / health facility", Toast.LENGTH_SHORT).show();
            txturl.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(txturl.getWindowToken(), 0);

        } else {

            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {

                CVars var = new CVars();
                var.setUrl_sync_hf(txturl.getText().toString());

                GetHF gf1 = new GetHF(this);
                gf1.execute();

                MAPPSHelper db = new MAPPSHelper(this);
                Collection<GetHFContract> lst = db.getAllHF();

                if (lst.size() == 0) {
                    Toast.makeText(this, "Could not obtained list of Cluster / Health Facility", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Got the list of Cluster / Health facility", Toast.LENGTH_SHORT).show();
                }

                //new SyncForms_Section2(this).execute(stringUrl);
            } else {
                Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void getLHW(View v) {

        if (txturllhw.getText().toString().isEmpty() && txturllhw.getText().toString() == null) {
            Toast.makeText(this, "Please enter url to get the LHW list", Toast.LENGTH_SHORT).show();
            txturllhw.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(txturllhw.getWindowToken(), 0);

        } else {

            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {

                CVars var = new CVars();
                var.setUrl_sync_lhw(txturllhw.getText().toString());

                GetLHW gf1 = new GetLHW(this);
                gf1.execute();

                MAPPSHelper db = new MAPPSHelper(this);
                Collection<Members> lst = db.getAllLHW();

                if (lst.size() == 0) {
                    Toast.makeText(this, "Could not obtained list of LHW", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Got the list of LHW", Toast.LENGTH_SHORT).show();
                }

                //new SyncForms_Section2(this).execute(stringUrl);
            } else {
                Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void getUsers(View v) {

        if (txturlusers.getText().toString().isEmpty() && txturlusers.getText().toString() == null) {
            Toast.makeText(this, "Please enter url to get the Users list", Toast.LENGTH_SHORT).show();
            txturlusers.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(txturlusers.getWindowToken(), 0);

        } else {

            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {

                CVars var = new CVars();
                var.setUrl_sync_usr(txturlusers.getText().toString());

                GetUserList gf1 = new GetUserList(this);
                gf1.execute();

                MAPPSHelper db = new MAPPSHelper(this);
                Collection<UsersContract> lst = db.getAllUsers();

                if (lst.size() == 0) {
                    Toast.makeText(this, "Could not obtained list of users", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Got the list of Users", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}