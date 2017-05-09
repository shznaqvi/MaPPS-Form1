package com.mapps.mapps.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mapps.mapps.R;
import com.mapps.mapps.contracts.FormContract;
import com.mapps.mapps.core.CVars;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.core.MAPPSHelper;
import com.mapps.mapps.otherClasses.Members;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section1Activity extends Activity {

    private static final String TAG = "Sec1";
    String var_s1q12 = "";
    String var_s1q13 = "";
    private ScrollView scrollView01;
    private TextView appHeader;
    private TextView lblS1q1;
    private TextView lblS1q2;
    private TextView lblS1q3;
    private TextView lblS1q4;
    private TextView lblS1q5;
    private TextView lblS1q6;
    private TextView lblS1q7;
    private TextView lblS1q8;
    //    private TextView lblS1q9a;
//    private TextView lblS1q9b;
//    private TextView lblS1q10;
//    private TextView lblS1q11;
    private Spinner s1q1;
    private Spinner s1q2;
    private EditText s1q3;
    private EditText s1q4;
    private EditText s1q5;
    private EditText s1q6;
    private EditText s1q7;
    private EditText s1q8;
    private EditText totalMem;
    //    private EditText s1q9a;
//    private EditText s1q9b;
//    private DatePicker s1q10;
//    private TimePicker s1q11;
    private RadioGroup radioS1q12;
    private RadioButton rDOS1q121;
    private RadioButton rDOS1q122;
    private RadioGroup radioS1q13;
    private RadioButton rDOS1q131;
    private RadioButton rDOS1q132;
    private LinearLayout vu_s1q13;
    private AlertDialog.Builder alert;
    private String spDateT;
    private String spTime;
    private int rdo_s1q12;
    private int rdo_s1q13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);

        scrollView01 = (ScrollView) findViewById(R.id.ScrollView01);
        appHeader = (TextView) findViewById(R.id.app_header);
        lblS1q1 = (TextView) findViewById(R.id.lbl_s1q1);
        lblS1q2 = (TextView) findViewById(R.id.lbl_s1q2);
        lblS1q3 = (TextView) findViewById(R.id.lbl_s1q3);
        lblS1q4 = (TextView) findViewById(R.id.lbl_s1q4);
        lblS1q5 = (TextView) findViewById(R.id.lbl_s1q5);
        lblS1q6 = (TextView) findViewById(R.id.lbl_s1q6);
        lblS1q7 = (TextView) findViewById(R.id.lbl_s1q7);
        lblS1q8 = (TextView) findViewById(R.id.lbl_s1q8);
//        lblS1q9a = (TextView) findViewById(R.id.lbl_s1q9a);
//        lblS1q9b = (TextView) findViewById(R.id.lbl_s1q9b);
//        lblS1q10 = (TextView) findViewById(R.id.lbl_s1q10);
//        lblS1q11 = (TextView) findViewById(R.id.lbl_s1q11);
//        s1q10 = (DatePicker) findViewById(R.id.s1q10);
//        s1q11 = (TimePicker) findViewById(R.id.s1q11);

        s1q1 = (Spinner) findViewById(R.id.s1q1);
        s1q2 = (Spinner) findViewById(R.id.s1q2);
        s1q3 = (EditText) findViewById(R.id.s1q3);
        s1q4 = (EditText) findViewById(R.id.s1q4);
        s1q5 = (EditText) findViewById(R.id.s1q5);
        s1q6 = (EditText) findViewById(R.id.s1q6);
        s1q7 = (EditText) findViewById(R.id.s1q7);
        s1q8 = (EditText) findViewById(R.id.s1q8);

        totalMem = (EditText) findViewById(R.id.totalMem);
//        s1q9a = (EditText) findViewById(R.id.s1q9a);
//        s1q9b = (EditText) findViewById(R.id.s1q9b);

        radioS1q12 = (RadioGroup) findViewById(R.id.radio_s1q12);
        rDOS1q121 = (RadioButton) findViewById(R.id.RDO_s1q12_1);
        rDOS1q122 = (RadioButton) findViewById(R.id.RDO_s1q12_2);


        radioS1q13 = (RadioGroup) findViewById(R.id.radio_s1q13);
        rDOS1q131 = (RadioButton) findViewById(R.id.RDO_s1q13_1);
        rDOS1q132 = (RadioButton) findViewById(R.id.RDO_s1q13_2);

        vu_s1q13 = (LinearLayout) findViewById(R.id.vu_s1q13);


        MAPPSApp.totalNumMember = 0;
        MAPPSApp.countNumMember = 0;

        setGPS();

        MAPPSApp.DEVID = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);

        appHeader = (TextView) findViewById(R.id.app_header);
        //appHeader.setText("MAPPS -> Section1" + " " + getString(R.string.section1));


        ArrayList<String> arr_members = new ArrayList<>();
        final ArrayList<String> arr_members1 = new ArrayList<>();

        final MAPPSHelper db = new MAPPSHelper(this);
        final Collection<Members> members = db.getAllHF1();


        for (Members m : members) {
            arr_members.add(m.getNME());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<>(Section1Activity.this,
                android.R.layout.simple_spinner_dropdown_item, arr_members);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1q1.setAdapter(adapter);


        final CVars var = new CVars();

        s1q1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub

                String item = s1q1.getSelectedItem().toString();

                //var.setClusterName(item);

                final Collection<Members> members1 = db.getAllLHW(item);

                arr_members1.clear();

                for (Members m : members1) {
                    arr_members1.add(m.getNME());
                }


                ArrayAdapter<String> adapter1 = new ArrayAdapter<>(Section1Activity.this,
                        android.R.layout.simple_spinner_dropdown_item, arr_members1);
                //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s1q2.setAdapter(adapter1);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        alert = new AlertDialog.Builder(this);
        alert.setTitle("Confirm Exit");
        alert.setMessage("Are you sure you want to cancel the entry of this form and go back to main menu ?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(Section1Activity.this, MainPageActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        radioS1q12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS1q121.getId()) {

                    vu_s1q13.setVisibility(View.VISIBLE);
                    rDOS1q131.requestFocus();

                } else if (checkedId == rDOS1q122.getId()) {

                    vu_s1q13.setVisibility(View.GONE);

                    radioS1q13.clearCheck();
                }
            }
        });


//        s1q10 = (DatePicker) findViewById(R.id.s1q10);
//        //s1q110.updateDate(s1q110.getDayOfMonth(), s1q110.getMonth(), s1q110.getYear());
//        s1q10.setMaxDate(new Date().getTime());
//
//        s1q11.setIs24HourView(true);
//        s1q11.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));

    }


    //private EditText getS1q1() {
    //return (EditText) findViewById(R.id.s1q1);
    //}

    //private EditText getS1q2() {
    //return (EditText) findViewById(R.id.s1q2);
    //}

    private EditText getS1q3() {
        return (EditText) findViewById(R.id.s1q3);
    }

    private EditText getS1q4() {
        return (EditText) findViewById(R.id.s1q4);
    }

    private EditText getS1q5() {
        return (EditText) findViewById(R.id.s1q5);
    }

    private EditText getS1q6() {
        return (EditText) findViewById(R.id.s1q6);
    }

    private EditText getS1q7() {
        return (EditText) findViewById(R.id.s1q7);
    }

    private EditText getS1q8() {
        return (EditText) findViewById(R.id.s1q8);
    }

//    private EditText getS1q9a() {
//        return (EditText) findViewById(R.id.s1q9a);
//    }

//    private EditText getS1q9b() {
//        return (EditText) findViewById(R.id.s1q9b);
//    }


    public TextView getLblS1q1() {
        return lblS1q1;
    }

    public void setLblS1q1(TextView lblS1q1) {
        this.lblS1q1 = lblS1q1;
    }

    public TextView getLblS1q2() {
        return lblS1q2;
    }

    public void setLblS1q2(TextView lblS1q2) {
        this.lblS1q2 = lblS1q2;
    }

    public TextView getLblS1q3() {
        return lblS1q3;
    }

    public void setLblS1q3(TextView lblS1q3) {
        this.lblS1q3 = lblS1q3;
    }

    public TextView getLblS1q4() {
        return lblS1q4;
    }

    public void setLblS1q4(TextView lblS1q4) {
        this.lblS1q4 = lblS1q4;
    }

    public TextView getLblS1q5() {
        return lblS1q5;
    }

    public void setLblS1q5(TextView lblS1q5) {
        this.lblS1q5 = lblS1q5;
    }

    public TextView getLblS1q6() {
        return lblS1q6;
    }

    public void setLblS1q6(TextView lblS1q6) {
        this.lblS1q6 = lblS1q6;
    }

    public TextView getLblS1q7() {
        return lblS1q7;
    }

    public void setLblS1q7(TextView lblS1q7) {
        this.lblS1q7 = lblS1q7;
    }

    public TextView getLblS1q8() {
        return lblS1q8;
    }

    public void setLblS1q8(TextView lblS1q8) {
        this.lblS1q8 = lblS1q8;
    }

//    public TextView getLblS1q9a() {
//        return lblS1q9a;
//    }
//
//    public void setLblS1q9a(TextView lblS1q9a) {
//        this.lblS1q9a = lblS1q9a;
//    }
//
//    public TextView getLblS1q9b() {
//        return lblS1q9b;
//    }
//
//    public void setLblS1q9b(TextView lblS1q9b) {
//        this.lblS1q9b = lblS1q9b;
//    }
//
//    public TextView getLblS1q10() {
//        return lblS1q10;
//    }
//
//    public void setLblS1q10(TextView lblS1q10) {
//        this.lblS1q10 = lblS1q10;
//    }
//
//    public TextView getLblS1q11() {
//        return lblS1q11;
//    }
//
//    public void setLblS1q11(TextView lblS1q11) {
//        this.lblS1q11 = lblS1q11;
//    }


    public void gotoSection2(View view) {

        switch (radioS1q12.getCheckedRadioButtonId()) {
            case R.id.RDO_s1q12_1:
                var_s1q12 = "1";
                break;
            case R.id.RDO_s1q12_2:
                var_s1q12 = "2";
                break;
        }


        if (ValidateForm()) {

            if (!IsHouseHoldExists_InCluster()) {

                try {
                    SaveDraft();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                    if (UpdateDB()) {

                        if (var_s1q12.equals("1")) {


                            MAPPSApp.countNumMember++;

                            Intent sec2_intent = new Intent(this, Section2Activity.class);
                            startActivity(sec2_intent);

                        } else {

                            Intent sec2_intent = new Intent(this, MainPageActivity.class);
                            startActivity(sec2_intent);
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Unable to update database", Toast.LENGTH_SHORT).show();
                    }
                //}

            } else {
                Toast.makeText(getApplicationContext(), "Household number already exists in this cluster ", Toast.LENGTH_SHORT).show();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(s1q5.getWindowToken(), 0);

                s1q5.requestFocus();
            }

        } else {
            Toast.makeText(getApplicationContext(), "Visit date and current date must be same ", Toast.LENGTH_SHORT).show();
        }
    }
//    }


    private boolean IsHouseHoldExists_InCluster() {
        boolean IsExists;
        MAPPSHelper db = new MAPPSHelper(this);

        String clusterid = db.getHFCode(s1q1.getSelectedItem().toString());
        String lhwcode = db.getLHWCode(s1q2.getSelectedItem().toString());

        IsExists = db.IsHouseHoldExists_Cluster(clusterid, lhwcode, s1q5.getText().toString());
        return IsExists;
    }


    private boolean UpdateDB() {
        MAPPSHelper db = new MAPPSHelper(this);
        Long updcount = db.InsertRecord(MAPPSApp.fc);
        MAPPSApp.fc.set_ID(updcount);

        if (updcount != null) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            MAPPSApp.fc.setROW_UID(MAPPSApp.fc.getROW_DEVID() + MAPPSApp.fc.get_ID());
            CVars var = new CVars();
            var.set_myid(MAPPSApp.fc.get_ID());
            db.updateFormID();
            return true;

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

    private boolean SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();
        MAPPSApp.fc = new FormContract();

        MAPPSApp.fc.setROW_DEVID("N-" + MAPPSApp.DEVID);


        MAPPSHelper db = new MAPPSHelper(this);
        CVars var = new CVars();


        spDateT = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        spTime = new SimpleDateFormat("hh:mm:ss").format(new Date());

        String cluster = db.getHFCode(s1q1.getSelectedItem().toString());
        String lhwcode = db.getLHWCode(s1q2.getSelectedItem().toString(), s1q1.getSelectedItem().toString());

        int mycluster = Integer.parseInt(cluster) * 100;
        int mylhw = Integer.parseInt(lhwcode);
        int myhh = Integer.parseInt(s1q5.getText().toString());

        int val1 = (mycluster + mylhw) * 1000;
        int val2 = val1 + myhh;

        var.set_mycluster(cluster);
        var.set_mylhw(lhwcode);
        var.set_myhh(s1q5.getText().toString());

        var.Storehhno(String.valueOf(val2));

        MAPPSApp.fc.setROW_S1Q1(cluster);
        MAPPSApp.fc.setROW_S1Q2(lhwcode);
        MAPPSApp.fc.setROW_S1Q3(s1q3.getText().toString());
        MAPPSApp.fc.setROW_S1Q4(s1q4.getText().toString());
        MAPPSApp.fc.setROW_S1Q5(s1q5.getText().toString());
        MAPPSApp.fc.setROW_S1Q6(s1q6.getText().toString());
        MAPPSApp.fc.setROW_S1Q7(s1q7.getText().toString());
        MAPPSApp.fc.setROW_S1Q8(s1q8.getText().toString());
        MAPPSApp.fc.setROW_S1Q10(spDateT);
        MAPPSApp.fc.setROW_S1Q11(spTime);
        MAPPSApp.fc.setROW_S1Q12(rDOS1q121.isChecked() ? "1" : rDOS1q122.isChecked() ? "2" : "0");
        MAPPSApp.fc.setROW_S1Q13(rDOS1q131.isChecked() ? "1" : rDOS1q132.isChecked() ? "2" : "0");
        MAPPSApp.fc.setROW_ENTRYDATE(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        MAPPSApp.fc.setROW_USERID(MAPPSApp.user[1]);

        if (!totalMem.getText().toString().isEmpty()) {
            MAPPSApp.totalNumMember = Integer.parseInt(totalMem.getText().toString());

            MAPPSApp.fc.setROW_member_count(String.valueOf(MAPPSApp.totalNumMember));
        }

        setGPS();

        return true;


    }


    /*private boolean SaveDraft() {
        MAPPSApp.fc = new FormContract();

        MAPPSApp.fc.setROW_DEVID("N-" + MAPPSApp.DEVID);

        MAPPSHelper db = new MAPPSHelper(this);

        CVars var = new CVars();

        String cluster = db.getHFCode(s1q1.getSelectedItem().toString());
        String lhwcode = db.getLHWCode(s1q2.getSelectedItem().toString(), s1q1.getSelectedItem().toString());

        var.set_mycluster(cluster);
        var.set_mylhw(lhwcode);
        var.set_myhh(s1q5.getText().toString());

        MAPPSApp.fc.setROW_S1Q1(cluster);
        MAPPSApp.fc.setROW_S1Q2(lhwcode);


        MAPPSApp.fc.setROW_S1Q3(s1q3.getText().toString());
        MAPPSApp.fc.setROW_S1Q4(s1q4.getText().toString());
        MAPPSApp.fc.setROW_S1Q5(s1q5.getText().toString());


        int mycluster = Integer.parseInt(cluster) * 100;
        int mylhw = Integer.parseInt(lhwcode);
        int myhh = Integer.parseInt(s1q5.getText().toString());

        int val1 = (mycluster + mylhw) * 1000;
        int val2 = val1 + myhh;

        var.Storehhno(String.valueOf(val2));


        MAPPSApp.fc.setROW_S1Q6(s1q6.getText().toString());
        MAPPSApp.fc.setROW_S1Q7(s1q7.getText().toString());
        MAPPSApp.fc.setROW_S1Q8(s1q8.getText().toString());


        MAPPSApp.fc.setROW_S1Q9a(MAPPSApp.user[0]);
        MAPPSApp.fc.setROW_S1Q9b(MAPPSApp.user[1]);



        MAPPSApp.fc.setROW_S1Q10(spDateT);
        MAPPSApp.fc.setROW_S1Q11(spTime);

        switch (radioS1q12.getCheckedRadioButtonId()) {
            case R.id.RDO_s1q12_1:
                var_s1q12 = "1";
                break;
            case R.id.RDO_s1q12_2:
                var_s1q12 = "2";
                break;
        }

        MAPPSApp.fc.setROW_S1Q12(var_s1q12);


        switch (radioS1q13.getCheckedRadioButtonId()) {
            case R.id.RDO_s1q13_1:
                var_s1q13 = "1";
                break;
            case R.id.RDO_s1q13_2:
                var_s1q13 = "2";
                break;
        }


        MAPPSApp.fc.setROW_S1Q13(var_s1q13);

//        MAPPSApp.fc.setROW_UID(MAPPSApp.DEVID + s1q1.getText().toString());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        String dt1 = sdf.format(dt);

        MAPPSApp.fc.setROW_ENTRYDATE(dt1);

//        CVars var1 = new CVars();
//        MAPPSApp.fc.setROW_USERID(var1.GetUser());
        MAPPSApp.fc.setROW_USERID(MAPPSApp.user[1]);

//        Total No of Members.
        if (!totalMem.getText().toString().isEmpty()) {
            MAPPSApp.totalNumMember = Integer.parseInt(totalMem.getText().toString());

            MAPPSApp.fc.setROW_member_count(String.valueOf(MAPPSApp.totalNumMember));
        }

        setGPS();

        return true;
    }
*/

    private boolean ValidateForm() {
        //Toast.makeText(getApplicationContext(), "Validating Form", Toast.LENGTH_SHORT).show();

        /*if (getS1q1().getText().toString().isEmpty() || s1q1.getText().toString() == null) {
            s1q1.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter cluster code \r\n", Toast.LENGTH_LONG).show();
            s1q1.requestFocus();
            return false;
        } else {
            s1q1.setError(null);
        }*/


        /*if (getS1q2().getText().toString().isEmpty() || s1q2.getText().toString() == null) {
            s1q2.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter LHW name \r\n", Toast.LENGTH_LONG).show();
            s1q2.requestFocus();
            return false;
        } else {
            s1q2.setError(null);
        }*/


        if (getS1q3().getText().toString().isEmpty()) {
            s1q3.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter village name \r\n", Toast.LENGTH_LONG).show();
            s1q3.requestFocus();
            return false;
        } else {
            s1q3.setError(null);
        }


        if (getS1q4().getText().toString().isEmpty()) {
            s1q4.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter land mark/address note \r\n", Toast.LENGTH_LONG).show();
            s1q4.requestFocus();
            return false;
        } else {
            s1q4.setError(null);
        }


        if (getS1q5().getText().toString().isEmpty()) {
            s1q5.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter household number \r\n", Toast.LENGTH_LONG).show();
            s1q5.requestFocus();
            return false;
        } else {
            s1q5.setError(null);
        }


        if (getS1q6().getText().toString().isEmpty()) {
            s1q6.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter respondent name \r\n", Toast.LENGTH_LONG).show();
            s1q6.requestFocus();
            return false;
        } else {
            s1q6.setError(null);
        }

        if (getS1q7().getText().toString().isEmpty()) {
            s1q7.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter household head name \r\n", Toast.LENGTH_LONG).show();
            s1q7.requestFocus();
            return false;
        } else {
            s1q7.setError(null);
        }

        if (getS1q8().getText().toString().isEmpty()) {
            s1q8.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter contact number \r\n", Toast.LENGTH_LONG).show();
            s1q8.requestFocus();
            return false;
        } else {
            s1q8.setError(null);
        }

//
//        if (getS1q9a().getText().toString().isEmpty() ) {
//            s1q9a.setError(getString(R.string.txterr));
//            Toast.makeText(getApplicationContext(), "Please enter study personnel name \r\n", Toast.LENGTH_LONG).show();
//            s1q9a.requestFocus();
//            return false;
//        } else {
//            s1q9a.setError(null);
//        }
//
//        if (getS1q9b().getText().toString().isEmpty()) {
//            s1q9b.setError(getString(R.string.txterr));
//            Toast.makeText(getApplicationContext(), "Please enter study personnel id  \r\n", Toast.LENGTH_LONG).show();
//            s1q9b.requestFocus();
//            return false;
//        } else {
//            s1q9b.setError(null);
//        }


        rdo_s1q12 = radioS1q12.getCheckedRadioButtonId();

        if (rdo_s1q12 == -1) {
            rDOS1q121.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS1q121.requestFocus();
            return false;
        } else {
            rDOS1q121.setError(null);
        }

        switch (rdo_s1q12) {
            case R.id.RDO_s1q12_1:
                var_s1q12 = "1";
                break;
        }

        if (rDOS1q121.isChecked()){
            if (totalMem.getText().toString().isEmpty()) {
                totalMem.setError("Please enter Number of Member");
                Toast.makeText(getApplicationContext(), "Please enter Number of Member \r\n", Toast.LENGTH_LONG).show();
                totalMem.requestFocus();
                return false;
            } else {
                totalMem.setError(null);
            }
            if (Integer.parseInt(totalMem.getText().toString()) < 1) {
                totalMem.setError("Member greater than 1");
                Toast.makeText(getApplicationContext(), "Member greater than 1 \r\n", Toast.LENGTH_LONG).show();
                totalMem.requestFocus();
                return false;
            } else {
                totalMem.setError(null);
            }
        }

        rdo_s1q13 = radioS1q13.getCheckedRadioButtonId();

        if (var_s1q12.equals("1") && rdo_s1q13 == -1) {
            rDOS1q131.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS1q131.requestFocus();
            return false;
        } else {
            rDOS1q131.setError(null);
        }



        /*if (Integer.parseInt(s1q1.getText().toString()) <= 0 || Integer.parseInt(s1q1.getText().toString()) > 26) {
            Toast.makeText(getApplicationContext(), "Cluster must be between 1 - 26", Toast.LENGTH_LONG).show();
            s1q1.requestFocus();
            return false;
        }*/

        if (Integer.parseInt(s1q5.getText().toString()) <= 0 || Integer.parseInt(s1q5.getText().toString()) > 300) {
            Toast.makeText(getApplicationContext(), "Household number must be between 1 - 300", Toast.LENGTH_LONG).show();
            s1q5.requestFocus();
            return false;
        }

//        if (Integer.parseInt(s1q9b.getText().toString()) <= 0 ||
//                Integer.parseInt(s1q9b.getText().toString()) > 200) {
//            Toast.makeText(getApplicationContext(), "Study personnel id must be between 1 - 200", Toast.LENGTH_LONG).show();
//            s1q9b.requestFocus();
//            return false;
//        }


        return true;
    }


    private void ClearFields() {
        s1q3.setText(null);
        s1q4.setText(null);
        s1q5.setText(null);
        s1q6.setText(null);
        s1q7.setText(null);
        s1q8.setText(null);
//        s1q9a.setText(null);
//        s1q9b.setText(null);
        radioS1q12.clearCheck();
        radioS1q13.clearCheck();
    }

    @Override
    public void onBackPressed() {
        AlertDialog alert1 = alert.create();
        alert1.show();
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();


        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("date", "0");

            if (lat.equals("0") && lang.equals("0")) {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }


            MAPPSApp.fc.setROW_GPS_LAT(GPSPref.getString("Latitude", "0"));
            MAPPSApp.fc.setROW_GPS_LANG(GPSPref.getString("Longitude", "0"));
            MAPPSApp.fc.setROW_GPS_ACC(GPSPref.getString("Accuracy", "0"));
//            MAPPSApp.fc.setROW_GPS_DT(GPSPref.getString(date, "0"));
            MAPPSApp.fc.setROW_GPS_DT(date);


        } catch (Exception e) {

        }
    }

    private boolean CheckInvalidChars() {

        String val_q3 = s1q3.getText().toString();
        String val_q4 = s1q4.getText().toString();
        String val_q6 = s1q6.getText().toString();
        String val_q7 = s1q7.getText().toString();
//        String val_q9a = s1q9a.getText().toString();

        //Pattern allow_char = Pattern.compile("[\\d]*");
        Pattern allow_char = Pattern.compile("[\\s\\w+]*");

        Matcher match_q3 = allow_char.matcher(val_q3);
        Matcher match_q4 = allow_char.matcher(val_q4);
        Matcher match_q6 = allow_char.matcher(val_q6);
        Matcher match_q7 = allow_char.matcher(val_q7);
//        Matcher match_q9a = allow_char.matcher(val_q9a);


        if (!match_q3.matches()) {
            Toast.makeText(this, "Field contains invalid characters", Toast.LENGTH_SHORT).show();
            s1q3.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(s1q3.getWindowToken(), 0);

            return false;
        }


        if (!match_q4.matches()) {
            Toast.makeText(this, "Field contains invalid characters", Toast.LENGTH_SHORT).show();
            s1q4.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(s1q4.getWindowToken(), 0);

            return false;
        }


        if (!match_q6.matches()) {
            Toast.makeText(this, "Field contains invalid characters", Toast.LENGTH_SHORT).show();
            s1q6.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(s1q6.getWindowToken(), 0);

            return false;
        }


        if (!match_q7.matches()) {
            Toast.makeText(this, "Field contains invalid characters", Toast.LENGTH_SHORT).show();
            s1q7.requestFocus();

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(s1q7.getWindowToken(), 0);

            return false;
        }


//        if (!match_q9a.matches()) {
//            Toast.makeText(this, "Field contains invalid characters", Toast.LENGTH_SHORT).show();
//            s1q9a.requestFocus();
//
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(s1q9a.getWindowToken(), 0);
//
//            return false;
//        }


        return true;
    }

}