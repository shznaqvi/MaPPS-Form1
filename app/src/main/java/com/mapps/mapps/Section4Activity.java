package com.mapps.mapps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class Section4Activity extends Activity {

    private final String TAG = "Sec4";
    String var_s4q28c = "";
    String var_s4q28d = "";
    String var_s4q28e = "";
    String var_s4q28f = "";
    String var_s4q28g = "";
    String var_s1q14 = "";
    CVars vars = null;
    Collection<Members> members;
    ArrayList<String> arr_members;
    private ScrollView scrollView01;
    private TextView appHeader;
    private TextView lblHhhead;
    private TextView lblS4q1;
    private TextView lblS3q;
    private TextView lblS4q28c;
    private RadioGroup radioS4q28c;
    private RadioButton rDOS4q28c1;
    private RadioButton rDOS4q28c2;
    private TextView lblS4q28d;
    private RadioGroup radioS4q28d;
    private RadioButton rDOS4q28d1;
    private RadioButton rDOS4q28d2;
    private TextView lblS4q28oth;
    private TextView lblS4q28e;
    private RadioGroup radioS4q28e;
    private RadioButton rDOS4q28e1;
    private RadioButton rDOS4q28e2;
    private TextView lblS4q28f;
    private TextView lblS4q28g;
    private TextView lblS4q28h;
    private RadioGroup radioS4q28g;
    private RadioButton rDOS4q28g1;
    private RadioButton rDOS4q28g2;
    private RadioButton rDOS4q28g9;
    private TextView lbl_s4q28a;
    private Button btnsavedata;
    private Button btnnext;
    private EditText s4q28oth;
    private LinearLayout vu_s4q28g;
    private LinearLayout vu_s4q28oth;
    private RadioGroup radioS1q14;
    private RadioButton rDOS1q141;
    private RadioButton rDOS1q142;
    private RadioButton rDOS1q143;
    private RadioButton rDOS1q144;
    private RadioButton rDOS1q145;
    private RadioButton rDOS1q146;
    private LinearLayout vu_s1q14;
    private LinearLayout vu_s4q28e1;
    private TextView lbl_hhhead_count;
    private AlertDialog.Builder builder;
    private int rdo_s4q28c;
    private int rdo_s4q28d;
    private int rdo_s4q28e;
    private int rdo_s4q28f;
    private int rdo_s4q28g;
    private int rdo_s1q14;
    private CheckBox chk_s3q28f_1;
    private CheckBox chk_s3q28f_2;
    private CheckBox chk_s3q28f_3;
    private CheckBox chk_s3q28f_4;
    private CheckBox chk_s3q28f_5;
    private CheckBox chk_s3q28f_6;
    private CheckBox chk_s3q28f_7;
    private CheckBox chk_s3q28f_8;
    private CheckBox chk_s3q28f_9;
    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section4);

        scrollView01 = (ScrollView) findViewById(R.id.ScrollView01);
        appHeader = (TextView) findViewById(R.id.app_header);
        lblHhhead = (TextView) findViewById(R.id.lbl_hhhead);
        lblS4q1 = (TextView) findViewById(R.id.lbl_s4q1);
        lblS3q = (TextView) findViewById(R.id.lbl_s3q);
        lblS4q28c = (TextView) findViewById(R.id.lbl_s4q28c);
        radioS4q28c = (RadioGroup) findViewById(R.id.radio_s4q28c);
        rDOS4q28c1 = (RadioButton) findViewById(R.id.RDO_s4q28c_1);
        rDOS4q28c2 = (RadioButton) findViewById(R.id.RDO_s4q28c_2);
        lblS4q28d = (TextView) findViewById(R.id.lbl_s4q28d);
        radioS4q28d = (RadioGroup) findViewById(R.id.radio_s4q28d);
        rDOS4q28d1 = (RadioButton) findViewById(R.id.RDO_s4q28d_1);
        rDOS4q28d2 = (RadioButton) findViewById(R.id.RDO_s4q28d_2);
        lblS4q28oth = (TextView) findViewById(R.id.lbl_s4q28oth);
        lblS4q28e = (TextView) findViewById(R.id.lbl_s4q28e);
        radioS4q28e = (RadioGroup) findViewById(R.id.radio_s4q28e);
        rDOS4q28e1 = (RadioButton) findViewById(R.id.RDO_s4q28e_1);
        rDOS4q28e2 = (RadioButton) findViewById(R.id.RDO_s4q28e_2);
        lblS4q28g = (TextView) findViewById(R.id.lbl_s4q28g);
        radioS4q28g = (RadioGroup) findViewById(R.id.radio_s4q28g);
        rDOS4q28g1 = (RadioButton) findViewById(R.id.RDO_s4q28g_1);
        rDOS4q28g2 = (RadioButton) findViewById(R.id.RDO_s4q28g_2);
        rDOS4q28g9 = (RadioButton) findViewById(R.id.RDO_s4q28g_9);


        radioS1q14 = (RadioGroup) findViewById(R.id.radio_s1q14);
        rDOS1q141 = (RadioButton) findViewById(R.id.RDO_s1q14_1);
        rDOS1q142 = (RadioButton) findViewById(R.id.RDO_s1q14_2);
        rDOS1q143 = (RadioButton) findViewById(R.id.RDO_s1q14_3);
        rDOS1q144 = (RadioButton) findViewById(R.id.RDO_s1q14_4);

        vu_s4q28e1 = (LinearLayout) findViewById(R.id.vu_s4q28e1);

        chk_s3q28f_1 = (CheckBox) findViewById(R.id.chk_s3q28f_1);
        chk_s3q28f_2 = (CheckBox) findViewById(R.id.chk_s3q28f_2);
        chk_s3q28f_3 = (CheckBox) findViewById(R.id.chk_s3q28f_3);
        chk_s3q28f_4 = (CheckBox) findViewById(R.id.chk_s3q28f_4);
        chk_s3q28f_5 = (CheckBox) findViewById(R.id.chk_s3q28f_5);
        chk_s3q28f_6 = (CheckBox) findViewById(R.id.chk_s3q28f_6);
        chk_s3q28f_7 = (CheckBox) findViewById(R.id.chk_s3q28f_7);
        chk_s3q28f_8 = (CheckBox) findViewById(R.id.chk_s3q28f_8);
        chk_s3q28f_9 = (CheckBox) findViewById(R.id.chk_s3q28f_9);


        vu_s1q14 = (LinearLayout) findViewById((R.id.vu_s1q14));

        lbl_hhhead_count = (TextView) findViewById(R.id.lbl_hhhead_count);
        lbl_s4q28a = (TextView) findViewById(R.id.lbl_s4q28a);

        s4q28oth = (EditText) findViewById(R.id.s4q28oth);

        vu_s4q28oth = (LinearLayout) findViewById(R.id.vu_s4q28oth);
        vu_s4q28g = (LinearLayout) findViewById(R.id.vu_s4q28g);

        btnsavedata = (Button) findViewById(R.id.btnsavedata);
        btnnext = (Button) findViewById(R.id.btnnext);

        //appHeader.setText("MAPPS -> SECTION 4");

        vars = new CVars();
        lblS4q1.setText(vars.Gethhno());


        final MAPPSHelper db = new MAPPSHelper(this);

        members = db.getAll_Female_Members14_24();

        if (members.size() == 0) {
            rDOS4q28c1.setEnabled(false);
            rDOS4q28c2.setEnabled(false);

            rDOS4q28d1.setEnabled(false);
            rDOS4q28d2.setEnabled(false);

            rDOS4q28e1.setEnabled(false);
            rDOS4q28e2.setEnabled(false);

            rDOS4q28g1.setEnabled(false);
            rDOS4q28g2.setEnabled(false);
            rDOS4q28g9.setEnabled(false);

            vu_s1q14.setVisibility(View.VISIBLE);

            btnnext.setEnabled(false);
            btnsavedata.setEnabled(true);
        }

        lbl_hhhead_count.setText("Total Number : " + members.size());
        lbl_hhhead_count.setTextColor(Color.WHITE);

        arr_members = new ArrayList<>();

        for (Members m : members) {
            arr_members.add(m.getID());
            counter++;
        }


        counter = 0;

        if (members.size() > 0) {
            lbl_s4q28a.setText(arr_members.get(counter));
            lbl_s4q28a.setTextColor(Color.WHITE);

            radioS4q28c.setEnabled(true);
            radioS4q28d.setEnabled(true);
            radioS4q28e.setEnabled(true);
            radioS4q28g.setEnabled(true);

            vu_s1q14.setVisibility(View.GONE);

            btnnext.setEnabled(true);
            btnsavedata.setEnabled(false);
        }

        counter = 1;


        radioS4q28c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_s4q28c = radioS4q28c.getCheckedRadioButtonId();

                switch (rdo_s4q28c) {
                    case R.id.RDO_s4q28c_1:
                        var_s4q28c = "1";
                        break;
                    case R.id.RDO_s4q28c_2:
                        var_s4q28c = "2";
                        break;
                }


                rdo_s4q28d = radioS4q28d.getCheckedRadioButtonId();

                switch (rdo_s4q28d) {
                    case R.id.RDO_s4q28d_1:
                        var_s4q28d = "1";
                        break;
                    case R.id.RDO_s4q28d_2:
                        var_s4q28d = "2";
                        break;
                }


                rdo_s4q28e = radioS4q28e.getCheckedRadioButtonId();

                switch (rdo_s4q28e) {
                    case R.id.RDO_s4q28e_1:
                        var_s4q28e = "1";
                        break;
                    case R.id.RDO_s4q28e_2:
                        var_s4q28e = "2";
                        break;
                }

                if (checkedId == rDOS4q28c2.getId()) {

                    if (var_s4q28c.equals("2") && var_s4q28d.equals("2") && var_s4q28e.equals("2")) {
                        vu_s4q28g.setVisibility(View.VISIBLE);
                    }

                    rDOS4q28d1.requestFocus();

                } else {

                    vu_s4q28g.setVisibility(View.GONE);
                    radioS4q28g.clearCheck();
                    rDOS4q28g1.requestFocus();
                }
            }
        });


        radioS4q28d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_s4q28c = radioS4q28c.getCheckedRadioButtonId();

                switch (rdo_s4q28c) {
                    case R.id.RDO_s4q28c_1:
                        var_s4q28c = "1";
                        break;
                    case R.id.RDO_s4q28c_2:
                        var_s4q28c = "2";
                        break;
                }


                rdo_s4q28d = radioS4q28d.getCheckedRadioButtonId();

                switch (rdo_s4q28d) {
                    case R.id.RDO_s4q28d_1:
                        var_s4q28d = "1";
                        break;
                    case R.id.RDO_s4q28d_2:
                        var_s4q28d = "2";
                        break;
                }


                rdo_s4q28e = radioS4q28e.getCheckedRadioButtonId();

                switch (rdo_s4q28e) {
                    case R.id.RDO_s4q28e_1:
                        var_s4q28e = "1";
                        break;
                    case R.id.RDO_s4q28e_2:
                        var_s4q28e = "2";
                        break;
                }

                if (checkedId == rDOS4q28d2.getId()) {

                    if (var_s4q28c.equals("2")  && var_s4q28d.equals("2")  && var_s4q28e.equals("2")) {
                        vu_s4q28g.setVisibility(View.VISIBLE);
                    }

                    vu_s4q28oth.setVisibility(View.GONE);
                    s4q28oth.setText(null);

                    rDOS4q28e1.requestFocus();

                } else {

                    vu_s4q28g.setVisibility(View.GONE);
                    vu_s4q28oth.setVisibility(View.VISIBLE);

                    radioS4q28g.clearCheck();

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s4q28oth.getWindowToken(), 0);
                }
            }
        });


        radioS4q28e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                rdo_s4q28c = radioS4q28c.getCheckedRadioButtonId();

                switch (rdo_s4q28c) {
                    case R.id.RDO_s4q28c_1:
                        var_s4q28c = "1";
                        break;
                    case R.id.RDO_s4q28c_2:
                        var_s4q28c = "2";
                        break;
                }


                rdo_s4q28d = radioS4q28d.getCheckedRadioButtonId();

                switch (rdo_s4q28d) {
                    case R.id.RDO_s4q28d_1:
                        var_s4q28d = "1";
                        break;
                    case R.id.RDO_s4q28d_2:
                        var_s4q28d = "2";
                        break;
                }


                rdo_s4q28e = radioS4q28e.getCheckedRadioButtonId();

                switch (rdo_s4q28e) {
                    case R.id.RDO_s4q28e_1:
                        var_s4q28e = "1";
                        break;
                    case R.id.RDO_s4q28e_2:
                        var_s4q28e = "2";
                        break;
                }

                if (checkedId == rDOS4q28e2.getId()) {

                    if (var_s4q28c.equals("2") && var_s4q28d.equals("2") && var_s4q28e.equals("2")) {
                        radioS4q28g.clearCheck();
                        vu_s4q28g.setVisibility(View.VISIBLE);
                    }

                    vu_s4q28e1.setVisibility(View.GONE);

                    chk_s3q28f_1.setChecked(false);
                    chk_s3q28f_2.setChecked(false);
                    chk_s3q28f_3.setChecked(false);
                    chk_s3q28f_4.setChecked(false);
                    chk_s3q28f_5.setChecked(false);
                    chk_s3q28f_6.setChecked(false);
                    chk_s3q28f_7.setChecked(false);
                    chk_s3q28f_8.setChecked(false);
                    chk_s3q28f_9.setChecked(false);

                } else {

                    vu_s4q28e1.setVisibility(View.VISIBLE);
                    vu_s4q28g.setVisibility(View.GONE);
                    rDOS4q28g1.requestFocus();
                }
            }
        });


    }

    private EditText getS4q28oth() {
        return (EditText) findViewById(R.id.s4q28oth);
    }


    public void SaveData(View view) {

        if (ValidateForm1()) {

            if (members.size() == 0) {
                SaveDraft1();
                UpdateDB1();

                vars.Storehhno("");

                Intent sec2_intent = new Intent(this, MainPageActivity.class);
                startActivity(sec2_intent);
            } else {

                if (arr_members.size() < counter) {
                    SaveDraft1();
                    UpdateDB1();

                    Intent sec2_intent = new Intent(this, MainPageActivity.class);
                    startActivity(sec2_intent);

                    vars.Storehhno(null);
                } else {
                    Toast.makeText(getApplicationContext(), "Number of members must be equal to number of woman between 14 - 24 in this household ", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    public void AddMember(View view) {

        if (ValidateForm()) {

            if (SaveDraft()) {

                Toast.makeText(getApplicationContext(), "Storing Values", Toast.LENGTH_SHORT).show();

                if (UpdateDB()) {

                    final MAPPSHelper db = new MAPPSHelper(this);

                    Collection<Members> members = db.getAll_Female_Members14_24();

                    ArrayList<String> arr_members = new ArrayList<>();

                    for (Members m : members) {
                        arr_members.add(
                                m.getID());
                    }

                    lbl_hhhead_count.setText("Total Members : " + members.size());
                    lbl_hhhead_count.setTextColor(Color.RED);

                    if (arr_members.size() > counter) {
                        lbl_s4q28a.setText(arr_members.get(counter));
                        lbl_s4q28a.setTextColor(Color.RED);
                    } else {
                        btnnext.setEnabled(false);

                        radioS1q14.setEnabled(true);
                        btnsavedata.setEnabled(true);

                        vu_s1q14.setVisibility(View.VISIBLE);
                    }

                    counter++;

                    ClearFields();

                    vu_s4q28oth.setVisibility(View.GONE);
                    vu_s4q28e1.setVisibility(View.GONE);

                } else {
                    Toast.makeText(getApplicationContext(), "Unable to update database", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean UpdateDB() {
        MAPPSHelper db = new MAPPSHelper(this);
        db.InsertRecord_Sec4(MAPPSApp.sc4);

        //MAPPSApp.sc4.set_ID(db.InsertRecord_Sec4(MAPPSApp.sc4));
        //db.InsertRecord_Sec4(MAPPSApp.sc4);
        db.updateSA();

        return true;
    }


    private boolean UpdateDB1() {
        MAPPSHelper db = new MAPPSHelper(this);
        db.updateSA();

        return true;
    }


    private boolean SaveDraft() {
        MAPPSApp.sc4 = new Section4Contract();

        MAPPSApp.sc4.setROW_DEVID(MAPPSApp.DEVID);
        MAPPSApp.sc.setROW_UID(MAPPSApp.uid);

        vars = new CVars();

        MAPPSApp.sc4.setROW_S4CLUSTER(vars.get_mycluster());
        MAPPSApp.sc4.setROW_S4LHW(vars.get_mylhw());
        MAPPSApp.sc4.setROW_S4HH(vars.get_myhh());

        MAPPSApp.sc4.setROW_S4Q1(vars.Gethhno());

        MAPPSHelper db = new MAPPSHelper(this);

        String sno = db.getSNO1(lbl_s4q28a.getText().toString());

        MAPPSApp.sc4.setROW_SNO(sno);

        MAPPSApp.sc4.setROW_S4Q28a(lbl_s4q28a.getText().toString());
        MAPPSApp.sc4.setROW_S4Q28b(vars.Get_S2q28b_FemaleID());

        switch (radioS4q28c.getCheckedRadioButtonId()) {
            case R.id.RDO_s4q28c_1:
                var_s4q28c = "1";
                break;
            case R.id.RDO_s4q28c_2:
                var_s4q28c = "2";
                break;
        }

        MAPPSApp.sc4.setROW_S4Q28c(var_s4q28c);

        switch (radioS4q28d.getCheckedRadioButtonId()) {
            case R.id.RDO_s4q28d_1:
                var_s4q28d = "1";
                break;
            case R.id.RDO_s4q28d_2:
                var_s4q28d = "2";
                break;
        }

        MAPPSApp.sc4.setROW_S4Q28d(var_s4q28d);

        MAPPSApp.sc4.setROW_S4Q28oth(s4q28oth.getText().toString());

        switch (radioS4q28e.getCheckedRadioButtonId()) {
            case R.id.RDO_s4q28e_1:
                var_s4q28e = "1";
                break;
            case R.id.RDO_s4q28e_2:
                var_s4q28e = "2";
                break;
        }

        MAPPSApp.sc4.setROW_S4Q28e(var_s4q28e);

        if (var_s4q28c.equals("1") && var_s4q28d.equals("1") && var_s4q28e.equals("1")) {
            MAPPSApp.sc4.setROW_S4Q28f("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f("2");
        }


        if (chk_s3q28f_1.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f1("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f1("2");
        }


        if (chk_s3q28f_2.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f2("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f2("2");
        }


        if (chk_s3q28f_3.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f3("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f3("2");
        }


        if (chk_s3q28f_4.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f4("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f4("2");
        }


        if (chk_s3q28f_5.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f5("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f5("2");
        }


        if (chk_s3q28f_6.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f6("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f6("2");
        }


        if (chk_s3q28f_7.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f7("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f7("2");
        }


        if (chk_s3q28f_8.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f8("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f8("2");
        }


        if (chk_s3q28f_9.isChecked()) {
            MAPPSApp.sc4.setROW_S4Q28f9("1");
        } else {
            MAPPSApp.sc4.setROW_S4Q28f9("2");
        }


        switch (radioS4q28g.getCheckedRadioButtonId()) {
            case R.id.RDO_s4q28g_1:
                var_s4q28g = "1";
                break;
            case R.id.RDO_s4q28g_2:
                var_s4q28g = "2";
                break;
        }


        MAPPSApp.sc4.setROW_S4Q28g(var_s4q28g);
        MAPPSApp.sc4.setROW_S4Q28h("1");


        switch (radioS1q14.getCheckedRadioButtonId()) {
            case R.id.RDO_s1q14_1:
                var_s1q14 = "1";
                break;
            case R.id.RDO_s1q14_2:
                var_s1q14 = "2";
                break;
            case R.id.RDO_s1q14_3:
                var_s1q14 = "3";
                break;
            case R.id.RDO_s1q14_4:
                var_s1q14 = "4";
                break;
            case R.id.RDO_s1q14_5:
                var_s1q14 = "5";
                break;
            case R.id.RDO_s1q14_6:
                var_s1q14 = "6";
                break;
        }

        MAPPSApp.fc.setROW_S1Q14(var_s1q14);

        //MAPPSApp.fc.setROW_UID(MAPPSApp.DEVID + vars.Gethhno());

        return true;
    }


    private boolean SaveDraft1() {
        MAPPSApp.sc4 = new Section4Contract();

        switch (radioS1q14.getCheckedRadioButtonId()) {
            case R.id.RDO_s1q14_1:
                var_s1q14 = "1";
                break;
            case R.id.RDO_s1q14_2:
                var_s1q14 = "2";
                break;
            case R.id.RDO_s1q14_3:
                var_s1q14 = "3";
                break;
            case R.id.RDO_s1q14_4:
                var_s1q14 = "4";
                break;
            case R.id.RDO_s1q14_5:
                var_s1q14 = "5";
                break;
            case R.id.RDO_s1q14_6:
                var_s1q14 = "6";
                break;
        }

        MAPPSApp.fc.setROW_S1Q14(var_s1q14);

        return true;
    }


    private boolean ValidateForm() {
        //Toast.makeText(getApplicationContext(), "Validating Form", Toast.LENGTH_SHORT).show();

        rdo_s4q28c = radioS4q28c.getCheckedRadioButtonId();

        if (rdo_s4q28c == -1) {
            rDOS4q28c1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS4q28c1.requestFocus();
            return false;
        } else {
            rDOS4q28c1.setError(null);
        }

        switch (rdo_s4q28c) {
            case R.id.RDO_s4q28c_1:
                var_s4q28c = "1";
                break;
            case R.id.RDO_s4q28c_2:
                var_s4q28c = "2";
                break;
        }


        rdo_s4q28d = radioS4q28d.getCheckedRadioButtonId();

        if (rdo_s4q28d == -1) {
            rDOS4q28d1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS4q28d1.requestFocus();
            return false;
        } else {
            rDOS4q28d1.setError(null);
        }

        switch (rdo_s4q28d) {
            case R.id.RDO_s4q28d_1:
                var_s4q28d = "1";
                break;
            case R.id.RDO_s4q28d_2:
                var_s4q28d = "2";
                break;
        }

        if (var_s4q28d.equals("1") && getS4q28oth().getText().toString().isEmpty()) {
            s4q28oth.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter name of LHW \r\n", Toast.LENGTH_LONG).show();
            s4q28oth.requestFocus();
            return false;
        } else {
            s4q28oth.setError(null);
        }


        rdo_s4q28e = radioS4q28e.getCheckedRadioButtonId();

        if (rdo_s4q28e == -1) {
            rDOS4q28e1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS4q28e1.requestFocus();
            return false;
        } else {
            rDOS4q28e1.setError(null);
        }

        switch (rdo_s4q28e) {
            case R.id.RDO_s4q28e_1:
                var_s4q28e = "1";
                break;
            case R.id.RDO_s4q28e_2:
                var_s4q28e = "2";
                break;
        }

        if (var_s4q28e.equals("1")) {
            if (!chk_s3q28f_1.isChecked()
                    && !chk_s3q28f_2.isChecked()
                    && !chk_s3q28f_3.isChecked()
                    && !chk_s3q28f_4.isChecked()
                    && !chk_s3q28f_5.isChecked()
                    && !chk_s3q28f_6.isChecked()
                    && !chk_s3q28f_7.isChecked()
                    && !chk_s3q28f_8.isChecked()
                    && !chk_s3q28f_9.isChecked()) {

                chk_s3q28f_1.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                chk_s3q28f_1.requestFocus();
                return false;
            } else {
                chk_s3q28f_1.setError(null);
            }
        }


        if (var_s4q28c.equals("2") && var_s4q28d.equals("2")&& var_s4q28e.equals("2")) {
            rdo_s4q28g = radioS4q28g.getCheckedRadioButtonId();

            if (rdo_s4q28g == -1) {
                rDOS4q28g1.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                rDOS4q28g1.requestFocus();
                return false;
            } else {
                rDOS4q28g1.setError(null);
            }

            switch (rdo_s4q28g) {
                case R.id.RDO_s4q28g_1:
                    var_s4q28g = "1";
                    break;
                case R.id.RDO_s4q28g_2:
                    var_s4q28g = "2";
                    break;
                case R.id.RDO_s4q28g_9:
                    var_s4q28g = "9";
                    break;
            }
        }


        rdo_s1q14 = radioS1q14.getCheckedRadioButtonId();

        vu_s1q14 = (LinearLayout) findViewById(R.id.vu_s1q14);

        if (vu_s1q14.getVisibility() == View.VISIBLE) {
            if (rdo_s1q14 == -1) {
                rDOS1q141.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                rDOS1q141.requestFocus();
                return false;
            } else {
                rDOS1q141.setError(null);
            }
        }


        return true;
    }


    private boolean ValidateForm1() {

        rdo_s1q14 = radioS1q14.getCheckedRadioButtonId();

        if (rdo_s1q14 == -1) {
            rDOS1q141.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS1q141.requestFocus();
            return false;
        } else {
            rDOS1q141.setError(null);
        }

        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button disabled", Toast.LENGTH_SHORT).show();
    }

    private void ClearFields() {

        radioS4q28c.clearCheck();
        radioS4q28d.clearCheck();
        radioS4q28e.clearCheck();
        radioS4q28g.clearCheck();

        radioS4q28c.setEnabled(true);
        radioS4q28d.setEnabled(true);
        radioS4q28e.setEnabled(true);
        radioS4q28g.setEnabled(true);

        chk_s3q28f_1.setChecked(false);
        chk_s3q28f_2.setChecked(false);
        chk_s3q28f_3.setChecked(false);
        chk_s3q28f_4.setChecked(false);
        chk_s3q28f_5.setChecked(false);
        chk_s3q28f_6.setChecked(false);
        chk_s3q28f_7.setChecked(false);
        chk_s3q28f_8.setChecked(false);
        chk_s3q28f_9.setChecked(false);

        s4q28oth.setText(null);
    }

}