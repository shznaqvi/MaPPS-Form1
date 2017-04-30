package com.mapps.mapps.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.mapps.mapps.R;
import com.mapps.mapps.contracts.UsersContract;
import com.mapps.mapps.core.CVars;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.core.MAPPSHelper;
import com.mapps.mapps.getClasses.GetHF;
import com.mapps.mapps.getClasses.GetLHW;
import com.mapps.mapps.getClasses.GetUsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;


public class LoginActivity extends Activity {

    private static final String TAG = "Login";

    private EditText userid;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private LinearLayout vu_syncusers;
    private Button btnSyncUsers;
    private EditText txturl;

    private AlertDialog.Builder alert;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String DirectoryName;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        vu_syncusers = (LinearLayout) findViewById(R.id.vu_syncusers);
        btnSyncUsers = (Button) findViewById(R.id.btnSynchUsers);
        txturl = (EditText) findViewById(R.id.txturl);

//        MAPPSHelper db = new MAPPSHelper(this);
//        ArrayList<UsersContract> lstUsers = db.getAllUsers();
//
//        if (lstUsers.size() <= 0) {
//            vu_syncusers.setVisibility(View.VISIBLE);
//        } else {
//            vu_syncusers.setVisibility(View.GONE);
//        }

        // Set up the login form.
        userid = (EditText) findViewById(R.id.userid);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                return id == R.id.login || id == EditorInfo.IME_NULL;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser(view);
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);


        alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Exit");
        alert.setMessage("Are you sure you want to close this app ?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                        LoginActivity.super.onDestroy();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        Target viewTarget = new ViewTarget(R.id.btnSynchUsers, this);

        new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setContentTitle("Sync please!")
                .setContentText("Please sync Users and Data first!")
                .singleShot(42)
                .build();


        sharedPref = getSharedPreferences("mapps01", MODE_PRIVATE);

        if (sharedPref.getBoolean("flag", false)) {
            editor = sharedPref.edit();

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()).toString());

            if (dt != new SimpleDateFormat("dd-MM-yy").format(new Date()).toString()) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()).toString());

                editor.commit();
            }

            dbBackup();
        } else {
            editor = sharedPref.edit();

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()).toString());

            if (dt != new SimpleDateFormat("dd-MM-yy").format(new Date()).toString()) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()).toString());

                editor.commit();
            }
        }
    }

    public void dbBackup() {

        File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "MappsSecretCam");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {

            DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
            folder = new File(DirectoryName);
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {

                try {
                    File dbFile = new File(this.getDatabasePath(MAPPSHelper.DATABASE_NAME).getPath());
                    FileInputStream fis = new FileInputStream(dbFile);

                    String outFileName = DirectoryName + File.separator +
                            MAPPSHelper.DB_NAME;

                    // Open the empty db as the output stream
                    OutputStream output = new FileOutputStream(outFileName);

                    // Transfer bytes from the inputfile to the outputfile
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        output.write(buffer, 0, length);
                    }
                    // Close the streams
                    output.flush();
                    output.close();
                    fis.close();
                } catch (IOException e) {
                    Log.e("dbBackup:", e.getMessage());
                }

            }

        } else {
            Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
        }

    }


    public void SyncUsers(View v) {

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            CVars var = new CVars();
            var.setUrl_sync_users(MAPPSApp._HOST_URL + UsersContract.singleUser.GETURL);

//            Toast.makeText(LoginActivity.this, "Sync User", Toast.LENGTH_LONG).show();
//            GetUsers user = new GetUsers(this);
//            user.execute();
//
//            Toast.makeText(LoginActivity.this, "Sync HF", Toast.LENGTH_LONG).show();
//            GetHF gf1 = new GetHF(this);
//            gf1.execute();
//
//            Toast.makeText(LoginActivity.this, "Sync LHW", Toast.LENGTH_LONG).show();
//            GetLHW gL1 = new GetLHW(this);
//            gL1.execute();

            new syncData(this).execute();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

//        MAPPSHelper db = new MAPPSHelper(this);
//        ArrayList<UsersContract> lstUsers = db.getAllUsers();
//
//
//        if (lstUsers.size() <= 0) {
////            vu_syncusers.setVisibility(View.VISIBLE);
//            Toast.makeText(LoginActivity.this, "Error: users could not be populated ", Toast.LENGTH_LONG).show();
//        } else {
////            vu_syncusers.setVisibility(View.GONE);
////            var.setUrl_sync_users("http://10.198.107.60:8080/mappsweb/users_login.php");
//            Toast.makeText(LoginActivity.this, "Users populated successfully", Toast.LENGTH_LONG).show();
//        }
    }

    public void loginUser(View view) {

        String username = userid.getText().toString();
        String password = mPasswordView.getText().toString();
        try {

            // Reset errors.
            userid.setError(null);
            mPasswordView.setError(null);

            boolean cancel = false;
            View focusView = null;

            // Check for a valid email address.
            if (TextUtils.isEmpty(username)) {
                userid.setError(getString(R.string.error_field_required));
                focusView = userid;
                cancel = true;
            } else {
                userid.setError(null);
            }

            if (TextUtils.isEmpty(password)) {
                mPasswordView.setError(getString(R.string.error_field_required));
                focusView = mPasswordView;
                cancel = true;
            } else {
                mPasswordView.setError(null);
            }


            if (cancel == false) {

                MAPPSHelper db = new MAPPSHelper(LoginActivity.this);

                if (db.Login(username, password)) {

                    Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG).show();

                    CVars var = new CVars();
                    var.StoreUser(username);
                    Intent login_intent = new Intent(this, MainPageActivity.class);

                    startActivity(login_intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Username/Password or the user account disabled", Toast.LENGTH_LONG).show();
                }
                db.close();
            }

        } catch (Exception e) {
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(LoginActivity.this, "Back button is disabled", Toast.LENGTH_LONG).show();
    }


    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Toast.makeText(LoginActivity.this, "Sync User", Toast.LENGTH_LONG).show();
                    GetUsers user = new GetUsers(mContext);
                    user.execute();

                    Toast.makeText(LoginActivity.this, "Sync HF", Toast.LENGTH_LONG).show();
                    GetHF gf1 = new GetHF(mContext);
                    gf1.execute();

                    Toast.makeText(LoginActivity.this, "Sync LHW", Toast.LENGTH_LONG).show();
                    GetLHW gL1 = new GetLHW(mContext);
                    gL1.execute();
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    editor.putBoolean("flag", true);
                    editor.commit();

                    dbBackup();

                }
            }, 1200);
        }
    }

}