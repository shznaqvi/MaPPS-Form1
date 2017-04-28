package com.mapps.mapps.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
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



    }


    public void SyncUsers(View v) {
        CVars var = new CVars();
        var.setUrl_sync_users(MAPPSApp._HOST_URL + UsersContract.singleUser.GETURL);

        Toast.makeText(LoginActivity.this, "Sync User", Toast.LENGTH_LONG).show();
        GetUsers user = new GetUsers(this);
        user.execute();

        Toast.makeText(LoginActivity.this, "Sync HF", Toast.LENGTH_LONG).show();
        GetHF gf1 = new GetHF(this);
        gf1.execute();

        Toast.makeText(LoginActivity.this, "Sync LHW", Toast.LENGTH_LONG).show();
        GetLHW gL1 = new GetLHW(this);
        gL1.execute();

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
}