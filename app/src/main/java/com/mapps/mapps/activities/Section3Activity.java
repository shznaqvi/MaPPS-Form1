package com.mapps.mapps.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mapps.mapps.core.CVars;
import com.mapps.mapps.R;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.core.MAPPSHelper;

import org.json.JSONObject;

public class Section3Activity extends Activity {

    private final String TAG = "Sec3";
    String var_s3q16 = "";
    String var_s3q18a = "";
    String var_s3q19 = "";
    String var_s3q20 = "";
    String var_s3q21 = "";
    String var_s3q23 = "";
    String var_s3q24 = "";
    String var_s3q26 = "";
    String var_s3q27 = "";
    private ScrollView scrollView01;
    private TextView appHeader;
    private TextView lblHhhead;
    private TextView lblS2q1;
    private TextView lblS3q16;
    private RadioGroup radioS3q16;
    private RadioButton rDOS3q161;
    private RadioButton rDOS3q162;
    private RadioButton rDOS3q1699;
    private TextView lblS3q17;
    private TextView lblS3q18d;
    private TextView lblS3q18m;
    private TextView lblS3q19;
    private RadioGroup radioS3q18a;
    private RadioButton rDOS3q18a1;
    private RadioButton rDOS3q18a99;
    private RadioGroup radioS3q19;
    private RadioButton rDOS3q191;
    private RadioButton rDOS3q192;
    private RadioButton rDOS3q193;
    private RadioButton rDOS3q194;
    private RadioButton rDOS3q195;
    private RadioButton rDOS3q196;
    private TextView lblS3q19oth;
    private TextView lblS3q20;
    private TextView lblS3q20oth;
    private TextView lblS3q21;
    private RadioGroup radioS3q21;
    private RadioButton rDOS3q211;
    private RadioButton rDOS3q212;
    private TextView lblS3q22d;
    private TextView lblS3q22m;
    private TextView lblS3q23;
    private RadioGroup radioS3q23;
    private TextView lblS3q24;
    private RadioGroup radioS3q24;
    private RadioButton rDOS3q241;
    private RadioButton rDOS3q242;
    private RadioButton rDOS3q243;
    private RadioButton rDOS3q244;
    private TextView lblS3q25;
    private TextView lblS3q26;
    private RadioGroup radioS3q26;
    private RadioButton rDOS3q261;
    private RadioButton rDOS3q262;
    private TextView lblS3q27;
    private TextView lbl_s2q1;
    private EditText s3q17;
    private EditText s3q18d;
    private EditText s3q18m;
    private EditText s3q19oth;
    private EditText s3q20oth;
    private EditText s3q22d;
    private EditText s3q22m;
    private EditText s3q23oth;
    private EditText s3q25;
    private EditText s3q27oth;
    private LinearLayout vu_s3q17;
    private LinearLayout vu_s3q18;
    private LinearLayout vu_s3q19oth;
    private LinearLayout vu_s3q20;
    private LinearLayout vu_s3q20oth;
    private LinearLayout vu_s3q22;
    private LinearLayout vu_s3q23oth;
    private LinearLayout vu_s3q26;
    private LinearLayout vu_s3q27oth;
    private CheckBox chk_s3q20_1;
    private CheckBox chk_s3q20_2;
    private CheckBox chk_s3q20_3;
    private CheckBox chk_s3q20_4;
    private CheckBox chk_s3q20_5;
    private CheckBox chk_s3q20_6;
    private CheckBox chk_s3q20_7;
    private CheckBox chk_s3q20_8;
    private CheckBox chk_s3q20_9;
    private CheckBox chk_s3q20_88;
    private CheckBox chk_s3q23_1;
    private CheckBox chk_s3q23_2;
    private CheckBox chk_s3q23_3;
    private CheckBox chk_s3q23_4;
    private CheckBox chk_s3q23_5;
    private CheckBox chk_s3q23_6;
    private CheckBox chk_s3q23_7;
    private CheckBox chk_s3q23_8;
    private CheckBox chk_s3q23_9;
    private CheckBox chk_s3q23_88;
    private CheckBox chk_s3q27_1;
    private CheckBox chk_s3q27_2;
    private CheckBox chk_s3q27_3;
    private CheckBox chk_s3q27_4;
    private CheckBox chk_s3q27_5;
    private CheckBox chk_s3q27_6;
    private CheckBox chk_s3q27_7;
    private int var_s3q20_1;
    private int var_s3q20_2;
    private int var_s3q20_3;
    private int var_s3q20_4;
    private int var_s3q20_5;
    private int var_s3q20_6;
    private int var_s3q20_7;
    private int var_s3q20_8;
    private int var_s3q20_9;
    private int var_s3q20_88;
    private int var_s3q23_1;
    private int var_s3q23_2;
    private int var_s3q23_3;
    private int var_s3q23_4;
    private int var_s3q23_5;
    private int var_s3q23_6;
    private int var_s3q23_7;
    private int var_s3q23_8;
    private int var_s3q23_9;
    private int var_s3q23_88;
    private int rdo_s3q16;
    private int rdo_s3q18a;
    private int rdo_s3q19;
    private int rdo_s3q20;
    private int rdo_s3q21;
    private int rdo_s3q23;
    private int rdo_s3q24;
    private int rdo_s3q26;
    private int rdo_s3q27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section3);

        scrollView01 = (ScrollView) findViewById(R.id.ScrollView01);
        appHeader = (TextView) findViewById(R.id.app_header);
        lblHhhead = (TextView) findViewById(R.id.lbl_hhhead);
        lblS2q1 = (TextView) findViewById(R.id.lbl_s2q1);
        lblS3q16 = (TextView) findViewById(R.id.lbl_s3q16);
        radioS3q16 = (RadioGroup) findViewById(R.id.radio_s3q16);
        rDOS3q161 = (RadioButton) findViewById(R.id.RDO_s3q16_1);
        rDOS3q162 = (RadioButton) findViewById(R.id.RDO_s3q16_2);
        rDOS3q1699 = (RadioButton) findViewById(R.id.RDO_s3q16_99);
        lblS3q17 = (TextView) findViewById(R.id.lbl_s3q17);
        lblS3q18d = (TextView) findViewById(R.id.lbl_s3q18d);
        lblS3q18m = (TextView) findViewById(R.id.lbl_s3q18m);
        lblS3q19 = (TextView) findViewById(R.id.lbl_s3q19);
        radioS3q18a = (RadioGroup) findViewById(R.id.radio_s3q18a);
        rDOS3q18a1 = (RadioButton) findViewById(R.id.RDO_s3q18a_1);
        rDOS3q18a99 = (RadioButton) findViewById(R.id.RDO_s3q18a_99);
        radioS3q19 = (RadioGroup) findViewById(R.id.radio_s3q19);
        rDOS3q191 = (RadioButton) findViewById(R.id.RDO_s3q19_1);
        rDOS3q192 = (RadioButton) findViewById(R.id.RDO_s3q19_2);
        rDOS3q193 = (RadioButton) findViewById(R.id.RDO_s3q19_3);
        rDOS3q194 = (RadioButton) findViewById(R.id.RDO_s3q19_4);
        rDOS3q195 = (RadioButton) findViewById(R.id.RDO_s3q19_5);
        rDOS3q196 = (RadioButton) findViewById(R.id.RDO_s3q19_6);
        lblS3q19oth = (TextView) findViewById(R.id.lbl_s3q19oth);
        lblS3q20 = (TextView) findViewById(R.id.lbl_s3q20);
        chk_s3q20_1 = (CheckBox) findViewById(R.id.RDO_s3q20_1);
        chk_s3q20_2 = (CheckBox) findViewById(R.id.RDO_s3q20_2);
        chk_s3q20_3 = (CheckBox) findViewById(R.id.RDO_s3q20_3);
        chk_s3q20_4 = (CheckBox) findViewById(R.id.RDO_s3q20_4);
        chk_s3q20_5 = (CheckBox) findViewById(R.id.RDO_s3q20_5);
        chk_s3q20_6 = (CheckBox) findViewById(R.id.RDO_s3q20_6);
        chk_s3q20_7 = (CheckBox) findViewById(R.id.RDO_s3q20_7);
        chk_s3q20_8 = (CheckBox) findViewById(R.id.RDO_s3q20_8);
        chk_s3q20_9 = (CheckBox) findViewById(R.id.RDO_s3q20_9);
        chk_s3q20_88 = (CheckBox) findViewById(R.id.RDO_s3q20_88);
        lblS3q20oth = (TextView) findViewById(R.id.lbl_s3q20oth);
        lblS3q21 = (TextView) findViewById(R.id.lbl_s3q21);
        radioS3q21 = (RadioGroup) findViewById(R.id.radio_s3q21);
        rDOS3q211 = (RadioButton) findViewById(R.id.RDO_s3q21_1);
        rDOS3q212 = (RadioButton) findViewById(R.id.RDO_s3q21_2);
        lblS3q22d = (TextView) findViewById(R.id.lbl_s3q22d);
        lblS3q22m = (TextView) findViewById(R.id.lbl_s3q22m);
        lblS3q23 = (TextView) findViewById(R.id.lbl_s3q23);

        chk_s3q23_1 = (CheckBox) findViewById(R.id.RDO_s3q23_1);
        chk_s3q23_2 = (CheckBox) findViewById(R.id.RDO_s3q23_2);
        chk_s3q23_3 = (CheckBox) findViewById(R.id.RDO_s3q23_3);
        chk_s3q23_4 = (CheckBox) findViewById(R.id.RDO_s3q23_4);
        chk_s3q23_5 = (CheckBox) findViewById(R.id.RDO_s3q23_5);
        chk_s3q23_6 = (CheckBox) findViewById(R.id.RDO_s3q23_6);
        chk_s3q23_7 = (CheckBox) findViewById(R.id.RDO_s3q23_7);
        chk_s3q23_8 = (CheckBox) findViewById(R.id.RDO_s3q23_8);
        chk_s3q23_9 = (CheckBox) findViewById(R.id.RDO_s3q23_9);
        chk_s3q23_88 = (CheckBox) findViewById(R.id.RDO_s3q23_88);

        lblS3q24 = (TextView) findViewById(R.id.lbl_s3q24);
        radioS3q24 = (RadioGroup) findViewById(R.id.radio_s3q24);
        rDOS3q241 = (RadioButton) findViewById(R.id.RDO_s3q24_1);
        rDOS3q242 = (RadioButton) findViewById(R.id.RDO_s3q24_2);
        rDOS3q243 = (RadioButton) findViewById(R.id.RDO_s3q24_3);
        rDOS3q244 = (RadioButton) findViewById(R.id.RDO_s3q24_4);
        lblS3q25 = (TextView) findViewById(R.id.lbl_s3q25);
        lblS3q26 = (TextView) findViewById(R.id.lbl_s3q26);
        radioS3q26 = (RadioGroup) findViewById(R.id.radio_s3q26);
        rDOS3q261 = (RadioButton) findViewById(R.id.RDO_s3q26_1);
        rDOS3q262 = (RadioButton) findViewById(R.id.RDO_s3q26_2);
        lblS3q27 = (TextView) findViewById(R.id.lbl_s3q27);

        chk_s3q27_1 = (CheckBox) findViewById(R.id.RDO_s3q27_1);
        chk_s3q27_2 = (CheckBox) findViewById(R.id.RDO_s3q27_2);
        chk_s3q27_3 = (CheckBox) findViewById(R.id.RDO_s3q27_3);
        chk_s3q27_4 = (CheckBox) findViewById(R.id.RDO_s3q27_4);
        chk_s3q27_5 = (CheckBox) findViewById(R.id.RDO_s3q27_5);
        chk_s3q27_6 = (CheckBox) findViewById(R.id.RDO_s3q27_6);
        chk_s3q27_7 = (CheckBox) findViewById(R.id.RDO_s3q27_7);

        lbl_s2q1 = (TextView) findViewById(R.id.lbl_s2q1);

        s3q17 = (EditText) findViewById(R.id.s3q17);
        s3q18d = (EditText) findViewById(R.id.s3q18d);
        s3q18m = (EditText) findViewById(R.id.s3q18m);
        s3q19oth = (EditText) findViewById(R.id.s3q19oth);
        s3q20oth = (EditText) findViewById(R.id.s3q20oth);
        s3q22d = (EditText) findViewById(R.id.s3q22d);
        s3q22m = (EditText) findViewById(R.id.s3q22m);
        s3q23oth = (EditText) findViewById(R.id.s3q23oth);
        s3q25 = (EditText) findViewById(R.id.s3q25);
        s3q27oth = (EditText) findViewById(R.id.s3q27oth);


        vu_s3q17 = (LinearLayout) findViewById(R.id.vu_s3q17);
        vu_s3q18 = (LinearLayout) findViewById(R.id.vu_s3q18);
        vu_s3q19oth = (LinearLayout) findViewById(R.id.vu_s3q19oth);
        vu_s3q20 = (LinearLayout) findViewById(R.id.vu_s3q20);
        vu_s3q20oth = (LinearLayout) findViewById(R.id.vu_s3q20oth);
        vu_s3q22 = (LinearLayout) findViewById(R.id.vu_s3q22);
        vu_s3q23oth = (LinearLayout) findViewById(R.id.vu_s3q23oth);
        vu_s3q26 = (LinearLayout) findViewById(R.id.vu_s3q26);
        vu_s3q27oth = (LinearLayout) findViewById(R.id.vu_s3q27oth);


        //appHeader.setText("MAPPS -> SECTION 3");

        CVars vars = new CVars();
        lbl_s2q1.setText(vars.Gethhno());

        radioS3q16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rDOS3q161.isChecked()) {

                    vu_s3q17.setVisibility(View.VISIBLE);
                    vu_s3q20.setVisibility(View.GONE);
                    vu_s3q18.setVisibility(View.GONE);

                    CVars var = new CVars();
                    var.set_s3q16_1("1");

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s3q17.getWindowToken(), 0);

                } else {

                    vu_s3q17.setVisibility(View.GONE);
                    vu_s3q18.setVisibility(View.GONE);
                    vu_s3q19oth.setVisibility(View.GONE);
                    vu_s3q20.setVisibility(View.GONE);
                    vu_s3q20oth.setVisibility(View.GONE);

                    CVars var = new CVars();
                    var.set_s3q16_1("2");

                    radioS3q18a.clearCheck();

                    chk_s3q20_1.setChecked(false);
                    chk_s3q20_2.setChecked(false);
                    chk_s3q20_3.setChecked(false);
                    chk_s3q20_4.setChecked(false);
                    chk_s3q20_5.setChecked(false);
                    chk_s3q20_6.setChecked(false);
                    chk_s3q20_7.setChecked(false);
                    chk_s3q20_8.setChecked(false);
                    chk_s3q20_9.setChecked(false);
                    chk_s3q20_88.setChecked(false);

                    s3q17.setText(null);

                    s3q18d.setText(null);
                    s3q18m.setText(null);

                    radioS3q19.clearCheck();
                }
            }
        });


        radioS3q18a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == rDOS3q18a1.getId()) {

                    vu_s3q18.setVisibility(View.VISIBLE);
                    vu_s3q19oth.setVisibility(View.GONE);

                    CVars var = new CVars();

                    if (var.get_s3q16_1() == "1") {
                        vu_s3q20.setVisibility(View.VISIBLE);
                    } else {
                        vu_s3q20.setVisibility(View.GONE);
                    }

                    rDOS3q18a1.requestFocus();


                } else if (checkedId == rDOS3q18a99.getId()) {

                    vu_s3q18.setVisibility(View.GONE);
                    vu_s3q19oth.setVisibility(View.GONE);
                    vu_s3q20.setVisibility(View.GONE);

                    s3q18d.setText(null);
                    s3q18m.setText(null);

                    radioS3q19.clearCheck();

                    chk_s3q20_1.setChecked(false);
                    chk_s3q20_2.setChecked(false);
                    chk_s3q20_3.setChecked(false);
                    chk_s3q20_4.setChecked(false);
                    chk_s3q20_5.setChecked(false);
                    chk_s3q20_6.setChecked(false);
                    chk_s3q20_7.setChecked(false);
                    chk_s3q20_8.setChecked(false);
                    chk_s3q20_9.setChecked(false);
                    chk_s3q20_88.setChecked(false);

                    rDOS3q191.requestFocus();
                }
            }
        });


        radioS3q19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS3q196.getId()) {

                    vu_s3q19oth.setVisibility(View.VISIBLE);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s3q19oth.getWindowToken(), 0);

                } else {

                    vu_s3q19oth.setVisibility(View.GONE);
                    s3q19oth.setText(null);
                    chk_s3q20_1.requestFocus();
                }
            }
        });


        chk_s3q20_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    vu_s3q20oth.setVisibility(View.VISIBLE);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s3q20oth.getWindowToken(), 0);

                } else {

                    vu_s3q20oth.setVisibility(View.GONE);
                    s3q20oth.setText(null);
                    rDOS3q211.requestFocus();
                }
            }
        });


        radioS3q21.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS3q211.getId()) {

                    vu_s3q22.setVisibility(View.VISIBLE);
                    vu_s3q23oth.setVisibility(View.GONE);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s3q22d.getWindowToken(), 0);

                } else {

                    vu_s3q22.setVisibility(View.GONE);
                    vu_s3q23oth.setVisibility(View.GONE);

                    s3q22d.setText(null);
                    s3q22m.setText(null);

                    chk_s3q23_1.setChecked(false);
                    chk_s3q23_2.setChecked(false);
                    chk_s3q23_3.setChecked(false);
                    chk_s3q23_4.setChecked(false);
                    chk_s3q23_5.setChecked(false);
                    chk_s3q23_6.setChecked(false);
                    chk_s3q23_7.setChecked(false);
                    chk_s3q23_8.setChecked(false);
                    chk_s3q23_9.setChecked(false);
                    chk_s3q23_88.setChecked(false);

                    rDOS3q211.requestFocus();
                }
            }
        });


        chk_s3q23_88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    vu_s3q23oth.setVisibility(View.VISIBLE);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s3q23oth.getWindowToken(), 0);

                } else {

                    vu_s3q23oth.setVisibility(View.GONE);
                    s3q23oth.setText(null);
                    chk_s3q23_1.requestFocus();
                }
            }
        });


        radioS3q26.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS3q262.getId()) {

                    vu_s3q26.setVisibility(View.VISIBLE);
                    vu_s3q27oth.setVisibility(View.GONE);

                    rDOS3q261.requestFocus();

                } else {

                    vu_s3q26.setVisibility(View.GONE);
                    vu_s3q27oth.setVisibility(View.GONE);

                    s3q27oth.setText(null);

                    chk_s3q27_1.setChecked(false);
                    chk_s3q27_2.setChecked(false);
                    chk_s3q27_3.setChecked(false);
                    chk_s3q27_4.setChecked(false);
                    chk_s3q27_5.setChecked(false);
                    chk_s3q27_6.setChecked(false);
                    chk_s3q27_7.setChecked(false);

                    rDOS3q211.requestFocus();
                }
            }
        });


        chk_s3q27_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    vu_s3q27oth.setVisibility(View.VISIBLE);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s3q27oth.getWindowToken(), 0);

                } else {

                    vu_s3q27oth.setVisibility(View.GONE);
                    s3q27oth.setText(null);
                }
            }
        });


        /*radioS3q27.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS3q277.getId()) {

                    vu_s3q27oth.setVisibility(View.VISIBLE);
                    s3q27oth.requestFocus();

                } else {

                    vu_s3q27oth.setVisibility(View.GONE);
                    s3q27oth.setText("");
                }
            }
        });*/


    }

    private EditText getS3q17() {
        return (EditText) findViewById(R.id.s3q17);
    }

    private EditText getS3q18d() {
        return (EditText) findViewById(R.id.s3q18d);
    }

    private EditText getS3q18m() {
        return (EditText) findViewById(R.id.s3q18m);
    }

    private EditText getS3q19oth() {
        return (EditText) findViewById(R.id.s3q19oth);
    }

    private EditText getS3q20oth() {
        return (EditText) findViewById(R.id.s3q20oth);
    }

    private EditText getS3q22d() {
        return (EditText) findViewById(R.id.s3q22d);
    }

    private EditText getS3q22m() {
        return (EditText) findViewById(R.id.s3q22m);
    }

    private EditText getS3q25() {
        return (EditText) findViewById(R.id.s3q25);
    }


    public EditText getS3q23oth() {
        return s3q23oth;
    }

    public EditText getS3q27oth() {
        return s3q27oth;
    }

    public void gotoSection4(View v) {

        if (ValidateForm()) {

            if (SaveDraft()) {

                Toast.makeText(getApplicationContext(), "Storing Values", Toast.LENGTH_SHORT).show();

                if (UpdateDB()) {
                    Intent sec4_intent = new Intent(this, Section4Activity.class);
                    startActivity(sec4_intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to update database", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean UpdateDB() {
        MAPPSHelper db = new MAPPSHelper(this);
        db.updateSB();
        return true;
    }


    private boolean SaveDraft() {

        JSONObject js = new JSONObject();

        try {

            switch (radioS3q16.getCheckedRadioButtonId()) {
                case R.id.RDO_s3q16_1:
                    var_s3q16 = "1";
                    break;
                case R.id.RDO_s3q16_2:
                    var_s3q16 = "2";
                    break;
                case R.id.RDO_s3q16_99:
                    var_s3q16 = "99";
                    break;
            }


            js.put("s3q16", var_s3q16);
            js.put("s3q17", s3q17.getText().toString());


            switch (radioS3q18a.getCheckedRadioButtonId()) {
                case R.id.RDO_s3q18a_1:
                    var_s3q18a = "1";
                    break;
                case R.id.RDO_s3q18a_99:
                    var_s3q18a = "99";
                    break;
            }

            js.put("s3q18a", var_s3q18a);
            js.put("s3q18d", s3q18d.getText().toString());
            js.put("s3q18m", s3q18m.getText().toString());


            switch (radioS3q19.getCheckedRadioButtonId()) {
                case R.id.RDO_s3q19_1:
                    var_s3q19 = "1";
                    break;
                case R.id.RDO_s3q19_2:
                    var_s3q19 = "2";
                    break;
                case R.id.RDO_s3q19_3:
                    var_s3q19 = "3";
                    break;
                case R.id.RDO_s3q19_4:
                    var_s3q19 = "4";
                    break;
                case R.id.RDO_s3q19_5:
                    var_s3q19 = "5";
                    break;
                case R.id.RDO_s3q19_6:
                    var_s3q19 = "6";
                    break;
            }

            js.put("s3q19", var_s3q19);

            js.put("s3q19oth", s3q19oth.getText().toString());


            if (chk_s3q20_1.isChecked()) {
                js.put("s3q20a", "1");
            } else {
                js.put("s3q20a", "");
            }


            if (chk_s3q20_2.isChecked()) {
                js.put("s3q20b", "1");
            } else {
                js.put("s3q20b", "");
            }


            if (chk_s3q20_3.isChecked()) {
                js.put("s3q20c", "1");
            } else {
                js.put("s3q20c", "");
            }


            if (chk_s3q20_4.isChecked()) {
                js.put("s3q20d", "1");
            } else {
                js.put("s3q20d", "");
            }


            if (chk_s3q20_5.isChecked()) {
                js.put("s3q20e", "1");
            } else {
                js.put("s3q20e", "");
            }


            if (chk_s3q20_6.isChecked()) {
                js.put("s3q20f", "1");
            } else {
                js.put("s3q20f", "");
            }


            if (chk_s3q20_7.isChecked()) {
                js.put("s3q20g", "1");
            } else {
                js.put("s3q20g", "");
            }


            if (chk_s3q20_8.isChecked()) {
                js.put("s3q20h", "1");
            } else {
                js.put("s3q20h", "");
            }


            if (chk_s3q20_9.isChecked()) {
                js.put("s3q20i", "1");
            } else {
                js.put("s3q20i", "");
            }

            if (chk_s3q20_88.isChecked()) {
                js.put("s3q20j", "1");
            } else {
                js.put("s3q20j", "");
            }


            js.put("s3q20oth", s3q20oth.getText().toString());


            switch (radioS3q21.getCheckedRadioButtonId()) {
                case R.id.RDO_s3q21_1:
                    var_s3q21 = "1";
                    break;
                case R.id.RDO_s3q21_2:
                    var_s3q21 = "2";
                    break;
            }

            js.put("s3q21", var_s3q21);
            js.put("s3q22d", s3q22d.getText().toString());
            js.put("s3q22m", s3q22m.getText().toString());


            if (chk_s3q23_1.isChecked()) {
                js.put("s3q23a", "1");
            } else {
                js.put("s3q23a", "");
            }


            if (chk_s3q23_2.isChecked()) {
                js.put("s3q23b", "1");
            } else {
                js.put("s3q23b", "");
            }


            if (chk_s3q23_3.isChecked()) {
                js.put("s3q23c", "1");
            } else {
                js.put("s3q23c", "");
            }


            if (chk_s3q23_4.isChecked()) {
                js.put("s3q23d", "1");
            } else {
                js.put("s3q23d", "");
            }


            if (chk_s3q23_5.isChecked()) {
                js.put("s3q23e", "1");
            } else {
                js.put("s3q23e", "");
            }


            if (chk_s3q23_6.isChecked()) {
                js.put("s3q23f", "1");
            } else {
                js.put("s3q23f", "");
            }


            if (chk_s3q23_7.isChecked()) {
                js.put("s3q23g", "1");
            } else {
                js.put("s3q23g", "");
            }


            if (chk_s3q23_8.isChecked()) {
                js.put("s3q23h", "1");
            } else {
                js.put("s3q23h", "");
            }


            if (chk_s3q23_9.isChecked()) {
                js.put("s3q23i", "1");
            } else {
                js.put("s3q23i", "");
            }


            if (chk_s3q23_88.isChecked()) {
                js.put("s3q23j", "1");
            } else {
                js.put("s3q23j", "");
            }


            js.put("s3q23oth", s3q23oth.getText().toString());

            switch (radioS3q24.getCheckedRadioButtonId()) {
                case R.id.RDO_s3q24_1:
                    var_s3q24 = "1";
                    break;
                case R.id.RDO_s3q24_2:
                    var_s3q24 = "2";
                    break;
                case R.id.RDO_s3q24_3:
                    var_s3q24 = "3";
                    break;
                case R.id.RDO_s3q24_4:
                    var_s3q24 = "4";
                    break;
            }

            js.put("s3q24", var_s3q24);
            js.put("s3q25", String.valueOf(Double.parseDouble(s3q25.getText().toString())));


            switch (radioS3q26.getCheckedRadioButtonId()) {
                case R.id.RDO_s3q26_1:
                    var_s3q26 = "1";
                    break;
                case R.id.RDO_s3q26_2:
                    var_s3q26 = "2";
                    break;
            }

            js.put("s3q26", var_s3q26);
            js.put("s3q27", "");

            if (chk_s3q27_1.isChecked()) {
                js.put("s3q27a", "1");
            } else {
                js.put("s3q27a", "");
            }


            if (chk_s3q27_2.isChecked()) {
                js.put("s3q27b", "1");
            } else {
                js.put("s3q27b", "");
            }


            if (chk_s3q27_3.isChecked()) {
                js.put("s3q27c", "1");
            } else {
                js.put("s3q27c", "");
            }


            if (chk_s3q27_4.isChecked()) {
                js.put("s3q27d", "1");
            } else {
                js.put("s3q27d", "");
            }


            if (chk_s3q27_5.isChecked()) {
                js.put("s3q27e", "1");
            } else {
                js.put("s3q27e", "");
            }


            if (chk_s3q27_6.isChecked()) {
                js.put("s3q27f", "1");
            } else {
                js.put("s3q27f", "");
            }


            if (chk_s3q27_7.isChecked()) {
                js.put("s3q27g", "1");
            } else {
                js.put("s3q27g", "");
            }

            js.put("s3q27oth", s3q27oth.getText().toString());

            MAPPSApp.fc.setROW_S3(js.toString());


        } catch (Exception ex) {

        }

        return true;
    }


    private boolean ValidateForm() {
        //Toast.makeText(getApplicationContext(), "Validating Form", Toast.LENGTH_SHORT).show();

        rdo_s3q16 = radioS3q16.getCheckedRadioButtonId();

        if (rdo_s3q16 == -1) {
            rDOS3q161.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS3q161.requestFocus();
            return false;
        } else {
            rDOS3q161.setError(null);
        }

        switch (rdo_s3q16) {
            case R.id.RDO_s3q16_1:
                var_s3q16 = "1";
                break;
            case R.id.RDO_s3q16_2:
                var_s3q16 = "2";
                break;
            case R.id.RDO_s3q16_99:
                var_s3q16 = "99";
                break;
        }


        if (var_s3q16.equals("1")  && getS3q17().getText().toString().isEmpty()) {
            s3q17.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter name of LHW \r\n", Toast.LENGTH_LONG).show();
            s3q17.requestFocus();
            return false;
        } else {
            s3q17.setError(null);
        }


        if (var_s3q16.equals("1") ) {
            rdo_s3q18a = radioS3q18a.getCheckedRadioButtonId();

            if (rdo_s3q18a == -1) {
                rDOS3q18a1.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                rDOS3q18a1.requestFocus();
                return false;
            } else {
                rDOS3q18a1.setError(null);
            }
        }

        switch (rdo_s3q18a) {
            case R.id.RDO_s3q18a_1:
                var_s3q18a = "1";
                break;
            case R.id.RDO_s3q18a_99:
                var_s3q18a = "99";
                break;
        }

        if (var_s3q16.equals("1") ) {
            if (!var_s3q18a.equals("99")  && getS3q18d().getText().toString().isEmpty() ) {
                s3q18d.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "Please enter number of days \r\n", Toast.LENGTH_LONG).show();
                s3q18d.requestFocus();
                return false;
            } else {
                s3q18d.setError(null);
            }


            if (!var_s3q18a.equals("99")  && getS3q18m().getText().toString().isEmpty()) {
                s3q18m.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "Please enter number of months \r\n", Toast.LENGTH_LONG).show();
                s3q18m.requestFocus();
                return false;
            } else {
                s3q18m.setError(null);
            }
        }

        rdo_s3q19 = radioS3q19.getCheckedRadioButtonId();

        if (var_s3q16.equals("1") ) {
            if (!var_s3q18a.equals("99") && rdo_s3q19 == -1) {
                rDOS3q191.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                rDOS3q191.requestFocus();
                return false;
            } else {
                rDOS3q191.setError(null);
            }
        }

        switch (rdo_s3q19) {
            case R.id.RDO_s3q19_6:
                var_s3q19 = "6";
                break;
        }


        if (var_s3q16.equals("1") ) {

            if (!var_s3q18a.equals("99")) {

                if (var_s3q19.equals("6") && getS3q19oth().getText().toString().isEmpty()) {
                    s3q19oth.setError(getString(R.string.txterr));
                    Toast.makeText(getApplicationContext(), "Please specify others \r\n", Toast.LENGTH_LONG).show();
                    s3q19oth.requestFocus();
                    return false;
                } else {
                    s3q19oth.setError(null);
                }
            }
        }


        if (var_s3q16.equals("1")) {

            if (!var_s3q18a.equals("99")) {

                if (!chk_s3q20_1.isChecked()
                        && !chk_s3q20_2.isChecked()
                        && !chk_s3q20_3.isChecked()
                        && !chk_s3q20_4.isChecked()
                        && !chk_s3q20_5.isChecked()
                        && !chk_s3q20_6.isChecked()
                        && !chk_s3q20_7.isChecked()
                        && !chk_s3q20_8.isChecked()
                        && !chk_s3q20_9.isChecked()
                        && !chk_s3q20_88.isChecked()) {


                    chk_s3q20_1.setError(getString(R.string.rdoterr));
                    Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                    chk_s3q20_1.requestFocus();
                    return false;
                } else {
                    chk_s3q20_1.setError(null);
                }
            }
        }

        if (chk_s3q20_88.isChecked()) {
            var_s3q20 = "88";
        } else {
            var_s3q20 = "";
        }


        if (var_s3q16.equals("1")) {

            if (var_s3q20.equals("88")  && getS3q20oth().getText().toString().isEmpty()) {
                s3q20oth.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "Please specify others \r\n", Toast.LENGTH_LONG).show();
                s3q20oth.requestFocus();
                return false;
            } else {
                s3q20oth.setError(null);
            }
        }


        rdo_s3q21 = radioS3q21.getCheckedRadioButtonId();

        if (rdo_s3q21 == -1) {
            rDOS3q211.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS3q211.requestFocus();
            return false;
        } else {
            rDOS3q211.setError(null);
        }

        switch (rdo_s3q21) {
            case R.id.RDO_s3q21_1:
                var_s3q21 = "1";
                break;
            case R.id.RDO_s3q21_2:
                var_s3q21 = "2";
                break;
        }


        if (var_s3q21.equals("1") && getS3q22d().getText().toString().isEmpty()) {
            s3q22d.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter number of days \r\n", Toast.LENGTH_LONG).show();
            s3q22d.requestFocus();
            return false;
        } else {
            s3q22d.setError(null);
        }


        if (var_s3q21.equals("1")  && getS3q22m().getText().toString().isEmpty()) {
            s3q22m.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter number of months \r\n", Toast.LENGTH_LONG).show();
            s3q22m.requestFocus();
            return false;
        } else {
            s3q22m.setError(null);
        }


        if (var_s3q21.equals("1")) {

            if (!chk_s3q23_1.isChecked()
                    && !chk_s3q23_2.isChecked()
                    && !chk_s3q23_3.isChecked()
                    && !chk_s3q23_4.isChecked()
                    && !chk_s3q23_5.isChecked()
                    && !chk_s3q23_6.isChecked()
                    && !chk_s3q23_7.isChecked()
                    && !chk_s3q23_8.isChecked()
                    && !chk_s3q23_9.isChecked()
                    && !chk_s3q23_88.isChecked()) {

                chk_s3q23_1.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                chk_s3q23_1.requestFocus();
                return false;
            } else {
                chk_s3q23_1.setError(null);
            }
        }


        if (chk_s3q23_88.isChecked()) {
            var_s3q23 = "88";
        }

        if (var_s3q21.equals("1")) {
            if (var_s3q23.equals("88") && getS3q23oth().getText().toString().isEmpty()) {
                s3q23oth.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "Please specify others \r\n", Toast.LENGTH_LONG).show();
                s3q23oth.requestFocus();
                return false;
            } else {
                s3q23oth.setError(null);
            }
        }

        rdo_s3q24 = radioS3q24.getCheckedRadioButtonId();

        if (rdo_s3q24 == -1) {
            rDOS3q241.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS3q241.requestFocus();
            return false;
        } else {
            rDOS3q241.setError(null);
        }


        if (getS3q25().getText().toString().isEmpty()) {
            s3q25.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter distance in kms \r\n", Toast.LENGTH_LONG).show();
            s3q25.requestFocus();
            return false;
        } else {
            s3q25.setError(null);
        }

        if ((Double.parseDouble(s3q25.getText().toString()) < 0 ||
                Double.parseDouble(s3q25.getText().toString()) > 36) && Double.parseDouble(s3q25.getText().toString()) != 99) {
            Toast.makeText(getApplicationContext(), "Distance in KM must be between 00.0 - 36.0 or 99.9 dont know (Format of value 00.0) ", Toast.LENGTH_LONG).show();
            s3q25.requestFocus();
            s3q25.setError("Range 0-36 or 99");
            return false;
        } else {
            s3q25.setError(null);
        }

        rdo_s3q26 = radioS3q26.getCheckedRadioButtonId();

        if (rdo_s3q26 == -1) {
            rDOS3q261.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS3q261.requestFocus();
            return false;
        } else {
            rDOS3q261.setError(null);
        }

        switch (rdo_s3q26) {
            case R.id.RDO_s3q26_1:
                var_s3q26 = "1";
                break;
            case R.id.RDO_s3q26_2:
                var_s3q26 = "2";
                break;
        }


        if (var_s3q26.equals("2")) {
            if (!chk_s3q27_1.isChecked()
                    && !chk_s3q27_2.isChecked()
                    && !chk_s3q27_3.isChecked()
                    && !chk_s3q27_4.isChecked()
                    && !chk_s3q27_5.isChecked()
                    && !chk_s3q27_6.isChecked()
                    && !chk_s3q27_7.isChecked()) {

                chk_s3q27_1.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                chk_s3q27_1.requestFocus();
                return false;
            } else {
                chk_s3q27_1.setError(null);
            }

            if (chk_s3q27_7.isChecked()) {
                var_s3q27 = "7";
            }
        }


        if (var_s3q26.equals("2")) {
            if (var_s3q27.equals("7") && getS3q27oth().getText().toString().isEmpty()) {
                s3q27oth.setError(getString(R.string.txterr));
                Toast.makeText(getApplicationContext(), "Please specify others \r\n", Toast.LENGTH_LONG).show();
                s3q27oth.requestFocus();
                return false;
            } else {
                s3q27oth.setError(null);
            }
        }


        if (var_s3q16.equals("1")) {

            if (s3q18d.getText().toString().isEmpty()) {

            } else {
                if (Integer.parseInt(s3q18d.getText().toString()) < 0 ||
                        Integer.parseInt(s3q18d.getText().toString()) > 29) {
                    Toast.makeText(getApplicationContext(), "Days must be between 0 - 29", Toast.LENGTH_LONG).show();
                    s3q18d.requestFocus();
                    return false;
                }
            }


            if (s3q18m.getText().toString().isEmpty()) {

            } else {
                if (Integer.parseInt(s3q18m.getText().toString()) < 0 ||
                        Integer.parseInt(s3q18m.getText().toString()) > 36) {
                    Toast.makeText(getApplicationContext(), "Months must be between 0 - 36", Toast.LENGTH_LONG).show();
                    s3q18m.requestFocus();
                    return false;
                }
            }
        }


        if (var_s3q21.equals("1")) {

            if (s3q22d.getText().toString().isEmpty()) {

            } else {
                if (Integer.parseInt(s3q22d.getText().toString()) < 0 ||
                        Integer.parseInt(s3q22d.getText().toString()) > 29) {
                    Toast.makeText(getApplicationContext(), "Days must be between 0 - 29", Toast.LENGTH_LONG).show();
                    s3q22d.requestFocus();
                    return false;
                }
            }


            if (s3q22m.getText().toString().isEmpty()) {

            } else {
                if (Integer.parseInt(s3q22m.getText().toString()) < 0 ||
                        Integer.parseInt(s3q22m.getText().toString()) > 36) {
                    Toast.makeText(getApplicationContext(), "Months must be between 0 - 36", Toast.LENGTH_LONG).show();
                    s3q22m.requestFocus();
                    return false;
                }
            }
        }


//        if (s3q25.getText().toString().isEmpty()) {
//
//        } else {
//
//            if (s3q25.length() != 4) {
//                Toast.makeText(getApplicationContext(), "Distance must be in format 99.9 ", Toast.LENGTH_LONG).show();
//                s3q25.requestFocus();
//                return false;
//            } else {
//                if (Double.parseDouble(s3q25.getText().toString()) == 99.9) {
//                } else {
//                    if (Double.parseDouble(s3q25.getText().toString()) < 00.0 ||
//                            Double.parseDouble(s3q25.getText().toString()) > 36.0) {
//                        Toast.makeText(getApplicationContext(), "Distance in KM must be between 00.0 - 36.0 or 99.9 dont know (Format of value 00.0) ", Toast.LENGTH_LONG).show();
//                        s3q25.requestFocus();
//                        return false;
//                    }
//                }
//            }
//        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button disabled", Toast.LENGTH_SHORT).show();
    }

}