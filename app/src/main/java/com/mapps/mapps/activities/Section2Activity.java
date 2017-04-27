package com.mapps.mapps.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mapps.mapps.core.CVars;
import com.mapps.mapps.otherClasses.Members;
import com.mapps.mapps.R;
import com.mapps.mapps.contracts.Section2Contract;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.core.MAPPSHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Section2Activity extends Activity {

    private static final String TAG = "Sec2";

    String spDateT = "";
    String spDateLMP = "";
    MAPPSHelper db = null;
    private int counter;
    private ScrollView scrollView01;
    private TextView appHeader;
    private TextView lbl_s2q1;
    private TextView lblS2q15a;
    private TextView lblS2q15b;
    private RadioGroup radioS2q15b;
    private RadioButton rDOS2q15b1;
    private RadioButton rDOS2q15b2;
    private RadioButton rDOS2q15b3;
    private RadioButton rDOS2q15b4;
    private RadioButton rDOS2q15b5;
    private RadioButton rDOS2q15b6;
    private RadioButton rDOS2q15b7;
    private RadioButton rDOS2q15b8;
    private RadioButton rDOS2q15b9;
    private RadioButton rDOS2q15b10;
    private RadioButton rDOS2q15b11;
    private RadioButton rDOS2q15b12;
    private TextView lblS2q15cf;
    private TextView lblS2q15cm;
    private TextView lblS2q15d;
    private RadioGroup radioS2q15d;
    private RadioButton rDOS2q15d1;
    private RadioButton rDOS2q15d2;
    private TextView lblS2q15e;
    private TextView lblS2q15fy;
    private TextView lblS2q15fm;
    private TextView lblS2q15g;
    private RadioGroup radioS2q15g;
    private RadioButton rDOS2q15g1;
    private RadioButton rDOS2q15g2;
    private RadioButton rDOS2q15g3;
    private RadioButton rDOS2q15g4;
    private RadioButton rDOS2q15g5;
    private RadioButton rDOS2q15g6;
    private RadioButton rDOS2q15g7;
    private RadioButton rDOS2q15g8;
    private RadioButton rDOS2q15g9;
    private RadioButton rDOS2q15g10;
    private RadioButton rDOS2q15g11;
    private RadioButton rDOS2q15g12;
    private RadioButton rDOS2q15g13;
    private RadioButton rDOS2q15g99;
    private TextView lblS2q15h;
    private RadioGroup radioS2q15h;
    private RadioButton rDOS2q15h1;
    private RadioButton rDOS2q15h2;
    private RadioButton rDOS2q15h3;
    private RadioButton rDOS2q15h4;
    private RadioButton rDOS2q15h5;
    private RadioButton rDOS2q15h6;
    private RadioButton rDOS2q15h7;
    private RadioButton rDOS2q15h8;
    private RadioButton rDOS2q15h9;
    private RadioButton rDOS2q15h10;
    private RadioButton rDOS2q15h11;
    private RadioButton rDOS2q15h99;
    private TextView lblS2q15i;
    private RadioGroup radioS2q15i;
    private RadioButton rDOS2q15i1;
    private RadioButton rDOS2q15i2;
    private TextView lblS2q15j;
    private RadioGroup radioS2q15j;
    private RadioButton rDOS2q15j1;
    private RadioButton rDOS2q15j2;
    private RadioButton rDOS2q15j3;
    private RadioButton rDOS2q15j4;
    private RadioButton rDOS2q15j5;
    private TextView lblS2q15k;
    private RadioGroup radioS2q15k;
    private RadioButton rDOS2q15k1;
    private RadioButton rDOS2q15k2;
    private RadioButton rDOS2q15k9;
    private TextView lblS2q15lmp;
    private TextView lblS2q15gest;
    private TextView lblS2q15e1;
    private RadioGroup radioS2q15e1;
    private RadioButton rDOS2q15e11;
    private RadioButton rDOS2q15e12;
    private TextView lblS2q15l1;
    private RadioGroup radioS2q15l1;
    private RadioButton rDOS2q15l11;
    private RadioButton rDOS2q15l12;

    private DatePicker s2q15e;
    private DatePicker s2q15lmp;

    private EditText s2q15a;
    private EditText s2q15both;
    private EditText s2q15fy;
    private EditText s2q15fm;
    private EditText s2q15goth;
    private EditText s2q15hoth;
    private EditText s2q15joth;
    private EditText s2q15gest;

    private LinearLayout vu_s2q15k2;
    private LinearLayout vu_s2q15e1;
    private LinearLayout vu_s2q15age;
    private LinearLayout vu_s2q15lmp;
    private LinearLayout vu_s2q15both;
    private LinearLayout vu_s2q15goth;
    private LinearLayout vu_s2q15hoth;
    private LinearLayout vu_s2q15joth;
    private LinearLayout vu_s2q15gest;
    private LinearLayout vu_s2q15k;
    private LinearLayout vu_s2q15cf;
    private LinearLayout vu_s2q15cm;

    private Spinner ddlmembers_cf;
    private Spinner ddlmembers_cm;

    private TextView lbl_hhhead_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2);

        scrollView01 = (ScrollView) findViewById(R.id.ScrollView01);
        appHeader = (TextView) findViewById(R.id.app_header);
        //appHeader.setText("MAPPS -> SECTION 2");

        lbl_s2q1 = (TextView) findViewById(R.id.lbl_s2q1);

        CVars vars = new CVars();
        lbl_s2q1.setText(vars.Gethhno());

        lblS2q15a = (TextView) findViewById(R.id.lbl_s2q15a);
        lblS2q15b = (TextView) findViewById(R.id.lbl_s2q15b);
        radioS2q15b = (RadioGroup) findViewById(R.id.radio_s2q15b);
        rDOS2q15b1 = (RadioButton) findViewById(R.id.RDO_s2q15b_1);
        rDOS2q15b2 = (RadioButton) findViewById(R.id.RDO_s2q15b_2);
        rDOS2q15b3 = (RadioButton) findViewById(R.id.RDO_s2q15b_3);
        rDOS2q15b4 = (RadioButton) findViewById(R.id.RDO_s2q15b_4);
        rDOS2q15b5 = (RadioButton) findViewById(R.id.RDO_s2q15b_5);
        rDOS2q15b6 = (RadioButton) findViewById(R.id.RDO_s2q15b_6);
        rDOS2q15b7 = (RadioButton) findViewById(R.id.RDO_s2q15b_7);
        rDOS2q15b8 = (RadioButton) findViewById(R.id.RDO_s2q15b_8);
        rDOS2q15b9 = (RadioButton) findViewById(R.id.RDO_s2q15b_9);
        rDOS2q15b10 = (RadioButton) findViewById(R.id.RDO_s2q15b_10);
        rDOS2q15b11 = (RadioButton) findViewById(R.id.RDO_s2q15b_11);
        rDOS2q15b12 = (RadioButton) findViewById(R.id.RDO_s2q15b_12);
        lblS2q15d = (TextView) findViewById(R.id.lbl_s2q15d);
        radioS2q15d = (RadioGroup) findViewById(R.id.radio_s2q15d);
        rDOS2q15d1 = (RadioButton) findViewById(R.id.RDO_s2q15d_1);
        rDOS2q15d2 = (RadioButton) findViewById(R.id.RDO_s2q15d_2);
        lblS2q15e = (TextView) findViewById(R.id.lbl_s2q15e);
        lblS2q15fy = (TextView) findViewById(R.id.lbl_s2q15fy);
        lblS2q15fm = (TextView) findViewById(R.id.lbl_s2q15fm);
        lblS2q15g = (TextView) findViewById(R.id.lbl_s2q15g);
        radioS2q15g = (RadioGroup) findViewById(R.id.radio_s2q15g);
        rDOS2q15g1 = (RadioButton) findViewById(R.id.RDO_s2q15g_1);
        rDOS2q15g2 = (RadioButton) findViewById(R.id.RDO_s2q15g_2);
        rDOS2q15g3 = (RadioButton) findViewById(R.id.RDO_s2q15g_3);
        rDOS2q15g4 = (RadioButton) findViewById(R.id.RDO_s2q15g_4);
        rDOS2q15g5 = (RadioButton) findViewById(R.id.RDO_s2q15g_5);
        rDOS2q15g6 = (RadioButton) findViewById(R.id.RDO_s2q15g_6);
        rDOS2q15g7 = (RadioButton) findViewById(R.id.RDO_s2q15g_7);
        rDOS2q15g8 = (RadioButton) findViewById(R.id.RDO_s2q15g_8);
        rDOS2q15g9 = (RadioButton) findViewById(R.id.RDO_s2q15g_9);
        rDOS2q15g10 = (RadioButton) findViewById(R.id.RDO_s2q15g_10);
        rDOS2q15g11 = (RadioButton) findViewById(R.id.RDO_s2q15g_11);
        rDOS2q15g12 = (RadioButton) findViewById(R.id.RDO_s2q15g_12);
        rDOS2q15g13 = (RadioButton) findViewById(R.id.RDO_s2q15g_13);
        rDOS2q15g99 = (RadioButton) findViewById(R.id.RDO_s2q15g_99);
        lblS2q15h = (TextView) findViewById(R.id.lbl_s2q15h);
        radioS2q15h = (RadioGroup) findViewById(R.id.radio_s2q15h);
        rDOS2q15h1 = (RadioButton) findViewById(R.id.RDO_s2q15h_1);
        rDOS2q15h2 = (RadioButton) findViewById(R.id.RDO_s2q15h_2);
        rDOS2q15h3 = (RadioButton) findViewById(R.id.RDO_s2q15h_3);
        rDOS2q15h4 = (RadioButton) findViewById(R.id.RDO_s2q15h_4);
        rDOS2q15h5 = (RadioButton) findViewById(R.id.RDO_s2q15h_5);
        rDOS2q15h6 = (RadioButton) findViewById(R.id.RDO_s2q15h_6);
        rDOS2q15h7 = (RadioButton) findViewById(R.id.RDO_s2q15h_7);
        rDOS2q15h8 = (RadioButton) findViewById(R.id.RDO_s2q15h_8);
        rDOS2q15h9 = (RadioButton) findViewById(R.id.RDO_s2q15h_9);
        rDOS2q15h10 = (RadioButton) findViewById(R.id.RDO_s2q15h_10);
        rDOS2q15h11 = (RadioButton) findViewById(R.id.RDO_s2q15h_11);
        rDOS2q15h99 = (RadioButton) findViewById(R.id.RDO_s2q15h_99);
        lblS2q15i = (TextView) findViewById(R.id.lbl_s2q15i);
        radioS2q15i = (RadioGroup) findViewById(R.id.radio_s2q15i);
        rDOS2q15i1 = (RadioButton) findViewById(R.id.RDO_s2q15i_1);
        rDOS2q15i2 = (RadioButton) findViewById(R.id.RDO_s2q15i_2);
        lblS2q15j = (TextView) findViewById(R.id.lbl_s2q15j);
        radioS2q15j = (RadioGroup) findViewById(R.id.radio_s2q15j);
        rDOS2q15j1 = (RadioButton) findViewById(R.id.RDO_s2q15j_1);
        rDOS2q15j2 = (RadioButton) findViewById(R.id.RDO_s2q15j_2);
        rDOS2q15j3 = (RadioButton) findViewById(R.id.RDO_s2q15j_3);
        rDOS2q15j4 = (RadioButton) findViewById(R.id.RDO_s2q15j_4);
        rDOS2q15j5 = (RadioButton) findViewById(R.id.RDO_s2q15j_5);
        lblS2q15k = (TextView) findViewById(R.id.lbl_s2q15k);
        radioS2q15k = (RadioGroup) findViewById(R.id.radio_s2q15k);
        rDOS2q15k1 = (RadioButton) findViewById(R.id.RDO_s2q15k_1);
        rDOS2q15k2 = (RadioButton) findViewById(R.id.RDO_s2q15k_2);
        rDOS2q15k9 = (RadioButton) findViewById(R.id.RDO_s2q15k_9);
        lblS2q15lmp = (TextView) findViewById(R.id.lbl_s2q15lmp);
        lblS2q15gest = (TextView) findViewById(R.id.lbl_s2q15gest);
        lblS2q15e1 = (TextView) findViewById(R.id.lbl_s2q15e1);
        radioS2q15e1 = (RadioGroup) findViewById(R.id.radio_s2q15e1);
        rDOS2q15e11 = (RadioButton) findViewById(R.id.RDO_s2q15e1_1);
        rDOS2q15e12 = (RadioButton) findViewById(R.id.RDO_s2q15e1_2);
        lblS2q15l1 = (TextView) findViewById(R.id.lbl_s2q15l1);
        radioS2q15l1 = (RadioGroup) findViewById(R.id.radio_s2q15l1);
        rDOS2q15l11 = (RadioButton) findViewById(R.id.RDO_s2q15l1_1);
        rDOS2q15l12 = (RadioButton) findViewById(R.id.RDO_s2q15l1_2);

        s2q15a = (EditText) findViewById(R.id.s2q15a);
        s2q15both = (EditText) findViewById(R.id.s2q15both);
        s2q15e = (DatePicker) findViewById(R.id.s2q15e);
        s2q15fy = (EditText) findViewById(R.id.s2q15fy);
        s2q15fm = (EditText) findViewById(R.id.s2q15fm);
        s2q15goth = (EditText) findViewById(R.id.s2q15goth);
        s2q15hoth = (EditText) findViewById(R.id.s2q15hoth);
        s2q15joth = (EditText) findViewById(R.id.s2q15joth);
        s2q15gest = (EditText) findViewById(R.id.s2q15gest);


        vu_s2q15k2 = (LinearLayout) findViewById(R.id.vu_s2q15k2);
        vu_s2q15both = (LinearLayout) findViewById(R.id.vu_s2q15both);
        vu_s2q15goth = (LinearLayout) findViewById(R.id.vu_s2q15goth);
        vu_s2q15hoth = (LinearLayout) findViewById(R.id.vu_s2q15hoth);
        vu_s2q15joth = (LinearLayout) findViewById(R.id.vu_s2q15joth);
        vu_s2q15e1 = (LinearLayout) findViewById(R.id.vu_s2q15e);
        vu_s2q15age = (LinearLayout) findViewById(R.id.vu_s2q15age);
        vu_s2q15lmp = (LinearLayout) findViewById(R.id.vu_s2q15lmp);
        vu_s2q15gest = (LinearLayout) findViewById(R.id.vu_s2q15gest);
        vu_s2q15k = (LinearLayout) findViewById(R.id.vu_s2q15k);
        vu_s2q15cf = (LinearLayout) findViewById(R.id.vu_s2q15cf);
        vu_s2q15cm = (LinearLayout) findViewById(R.id.vu_s2q15cm);

        s2q15e = (DatePicker) findViewById(R.id.s2q15e);
        s2q15lmp = (DatePicker) findViewById(R.id.s2q15lmp);

        ddlmembers_cf = (Spinner) findViewById(R.id.ddlmembers_cf);
        ddlmembers_cm = (Spinner) findViewById(R.id.ddlmembers_cm);

        lbl_hhhead_count = (TextView) findViewById(R.id.lbl_hhhead_count);


        MAPPSHelper db1 = new MAPPSHelper(this);

        Collection<Members> lst_f = db1.getAll_Male_Members();
        Collection<Members> lst_m = db1.getAll_Female_Members();

        lbl_hhhead_count.setText("Total Members : " + lst_f.size() + lst_m.size());
        lbl_hhhead_count.setTextColor(Color.WHITE);
        s2q15e.setMaxDate(new Date().getTime());


        radioS2q15i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15i1.getId()) {

                    CVars var = new CVars();
                    var.Store_ismale("1");

                    vu_s2q15k2.setVisibility(View.GONE);
                    vu_s2q15k.setVisibility(View.GONE);
                    vu_s2q15lmp.setVisibility(View.GONE);
                    vu_s2q15gest.setVisibility(View.GONE);

                    radioS2q15k.clearCheck();
                    radioS2q15l1.clearCheck();

                    s2q15gest.setText(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15e.getWindowToken(), 0);

                    s2q15gest.setText(null);

                } else if (checkedId == rDOS2q15i2.getId()) {

                    CVars var = new CVars();
                    var.Store_ismale("2");

                    if (var.Get_ismale().equals("2")) {
                        vu_s2q15k2.setVisibility(View.GONE);
                        vu_s2q15lmp.setVisibility(View.GONE);
                        vu_s2q15gest.setVisibility(View.GONE);
                        vu_s2q15k.setVisibility(View.GONE);
                    } else {
                        vu_s2q15k2.setVisibility(View.VISIBLE);
                        vu_s2q15lmp.setVisibility(View.GONE);
                        vu_s2q15gest.setVisibility(View.GONE);
                        vu_s2q15k.setVisibility(View.GONE);
                    }

                    s2q15fy.setText(null);
                    s2q15fm.setText(null);
                    s2q15gest.setText(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15fm.getWindowToken(), 0);
                }
            }
        });


        radioS2q15e1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15e11.getId()) {

                    vu_s2q15e1.setVisibility(View.VISIBLE);
                    vu_s2q15age.setVisibility(View.GONE);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15e.getWindowToken(), 0);

                } else if (checkedId == rDOS2q15e12.getId()) {

                    vu_s2q15age.setVisibility(View.VISIBLE);
                    vu_s2q15e1.setVisibility(View.GONE);

                    s2q15fy.setText(null);
                    s2q15fm.setText(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15fm.getWindowToken(), 0);
                }
            }
        });


        final CVars var = new CVars();

        radioS2q15j.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15j5.getId()) {
                    vu_s2q15joth.setVisibility(View.VISIBLE);
                    vu_s2q15k2.setVisibility(View.GONE);
                    vu_s2q15k.setVisibility(View.GONE);
                    vu_s2q15lmp.setVisibility(View.GONE);
                    vu_s2q15gest.setVisibility(View.GONE);

                    var.Store_issingle("5");

                    s2q15gest.setText(null);

                    radioS2q15k.clearCheck();
                    radioS2q15l1.clearCheck();

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15joth.getWindowToken(), 0);

                } else if (checkedId == rDOS2q15j1.getId()) {
                    vu_s2q15joth.setVisibility(View.GONE);
                    vu_s2q15k2.setVisibility(View.GONE);
                    vu_s2q15k.setVisibility(View.GONE);
                    vu_s2q15lmp.setVisibility(View.GONE);
                    vu_s2q15gest.setVisibility(View.GONE);

                    s2q15joth.setText(null);
                    s2q15gest.setText(null);

                    var.Store_issingle("1");

                    radioS2q15k.clearCheck();
                    radioS2q15l1.clearCheck();

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(radioS2q15j.getWindowToken(), 0);

                } else if (checkedId == rDOS2q15j2.getId() || checkedId == rDOS2q15j3.getId() || checkedId == rDOS2q15j4.getId()) {

                    if (var.Get_ismale().equals("1") || var.Get_ismale() == null) {

                        vu_s2q15joth.setVisibility(View.GONE);
                        vu_s2q15k2.setVisibility(View.GONE);

                        s2q15joth.setText(null);

                        var.Store_issingle("2");

                        radioS2q15k.clearCheck();
                        radioS2q15l1.clearCheck();

                    } else {

                        vu_s2q15joth.setVisibility(View.GONE);
                        vu_s2q15k2.setVisibility(View.VISIBLE);

                        var.Store_issingle("3");

                        s2q15joth.setText(null);
                        radioS2q15k.clearCheck();

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(radioS2q15j.getWindowToken(), 0);
                    }

                }
            }
        });


        radioS2q15k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15k1.getId()) {

                    vu_s2q15k.setVisibility(View.VISIBLE);
                    vu_s2q15lmp.setVisibility(View.GONE);
                    vu_s2q15gest.setVisibility(View.GONE);

                    s2q15gest.setText(null);
                    radioS2q15l1.clearCheck();

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15e.getWindowToken(), 0);

                } else {

                    vu_s2q15k.setVisibility(View.GONE);
                    vu_s2q15lmp.setVisibility(View.GONE);
                    vu_s2q15gest.setVisibility(View.GONE);

                    s2q15gest.setText(null);
                    radioS2q15l1.clearCheck();
                }
            }
        });


        radioS2q15l1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15l11.getId()) {

                    vu_s2q15lmp.setVisibility(View.VISIBLE);
                    vu_s2q15gest.setVisibility(View.GONE);

                    s2q15gest.setText(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15e.getWindowToken(), 0);

                } else if (checkedId == rDOS2q15l12.getId()) {

                    vu_s2q15gest.setVisibility(View.VISIBLE);
                    vu_s2q15lmp.setVisibility(View.GONE);

                    s2q15gest.setText(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(s2q15gest.getWindowToken(), 0);
                }
            }
        });


        radioS2q15b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15b11.getId()) {
                    vu_s2q15both.setVisibility(View.VISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(radioS2q15b.getWindowToken(), 0);
                } else {
                    s2q15both.setText(null);
                    vu_s2q15both.setVisibility(View.GONE);
                }
            }
        });


        radioS2q15g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15g13.getId()) {
                    vu_s2q15goth.setVisibility(View.VISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(radioS2q15g.getWindowToken(), 0);
                } else {
                    s2q15goth.setText(null);
                    vu_s2q15goth.setVisibility(View.GONE);
                }
            }
        });


        radioS2q15h.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rDOS2q15h11.getId()) {
                    vu_s2q15hoth.setVisibility(View.VISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(radioS2q15h.getWindowToken(), 0);
                } else {
                    s2q15hoth.setText("");
                    vu_s2q15hoth.setVisibility(View.GONE);
                }
            }
        });


        final MAPPSHelper db = new MAPPSHelper(this);

        ddlmembers_cf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub

                String item = ddlmembers_cf.getSelectedItem().toString();

                Collection<Members> member = db.getAllMembers_GetID(item);

                ArrayList<String> arr_members = new ArrayList<>();

                CVars var = new CVars();

                for (Members m : member) {
                    arr_members.add(
                            m.getID());

                    var.StoreQ15fid(m.getID());
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


        ddlmembers_cm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                // TODO Auto-generated method stub

                String item = ddlmembers_cm.getSelectedItem().toString();
                Collection<Members> member = db.getAllMembers_GetID(item);

                ArrayList<String> arr_members = new ArrayList<>();

                CVars var = new CVars();

                for (Members m : member) {
                    arr_members.add(
                            m.getID());

                    var.StoreQ15mid(m.getID());
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

    }

    private EditText getS2q15a() {
        return (EditText) findViewById(R.id.s2q15a);
    }

    public void setS2q15a(EditText s2q15a) {
        this.s2q15a = s2q15a;
    }

    private DatePicker getS2q15e() {
        return (DatePicker) findViewById(R.id.s2q15e);
    }

    private EditText getS2q15fy() {
        return (EditText) findViewById(R.id.s2q15fy);
    }

    public void setS2q15fy(EditText s2q15fy) {
        this.s2q15fy = s2q15fy;
    }

    private EditText getS2q15fm() {
        return (EditText) findViewById(R.id.s2q15fm);
    }

    public void setS2q15fm(EditText s2q15fm) {
        this.s2q15fm = s2q15fm;
    }

    private EditText getS2q15gest() {
        return (EditText) findViewById(R.id.s2q15gest);
    }

    public TextView getLbl_s2q1() {
        return lbl_s2q1;
    }

    public void setLbl_s2q1(TextView lbl_s2q1) {
        this.lbl_s2q1 = lbl_s2q1;
    }

    public TextView getLblS2q15a() {
        return lblS2q15a;
    }

    public void setLblS2q15a(TextView lblS2q15a) {
        this.lblS2q15a = lblS2q15a;
    }

    public TextView getLblS2q15b() {
        return lblS2q15b;
    }

    public void setLblS2q15b(TextView lblS2q15b) {
        this.lblS2q15b = lblS2q15b;
    }

    public RadioGroup getRadioS2q15b() {
        return radioS2q15b;
    }

    public void setRadioS2q15b(RadioGroup radioS2q15b) {
        this.radioS2q15b = radioS2q15b;
    }

    public RadioButton getrDOS2q15b1() {
        return rDOS2q15b1;
    }

    public void setrDOS2q15b1(RadioButton rDOS2q15b1) {
        this.rDOS2q15b1 = rDOS2q15b1;
    }

    public RadioButton getrDOS2q15b2() {
        return rDOS2q15b2;
    }

    public void setrDOS2q15b2(RadioButton rDOS2q15b2) {
        this.rDOS2q15b2 = rDOS2q15b2;
    }

    public RadioButton getrDOS2q15b3() {
        return rDOS2q15b3;
    }

    public void setrDOS2q15b3(RadioButton rDOS2q15b3) {
        this.rDOS2q15b3 = rDOS2q15b3;
    }

    public RadioButton getrDOS2q15b4() {
        return rDOS2q15b4;
    }

    public void setrDOS2q15b4(RadioButton rDOS2q15b4) {
        this.rDOS2q15b4 = rDOS2q15b4;
    }

    public RadioButton getrDOS2q15b5() {
        return rDOS2q15b5;
    }

    public void setrDOS2q15b5(RadioButton rDOS2q15b5) {
        this.rDOS2q15b5 = rDOS2q15b5;
    }

    public RadioButton getrDOS2q15b6() {
        return rDOS2q15b6;
    }

    public void setrDOS2q15b6(RadioButton rDOS2q15b6) {
        this.rDOS2q15b6 = rDOS2q15b6;
    }

    public RadioButton getrDOS2q15b7() {
        return rDOS2q15b7;
    }

    public void setrDOS2q15b7(RadioButton rDOS2q15b7) {
        this.rDOS2q15b7 = rDOS2q15b7;
    }

    public RadioButton getrDOS2q15b8() {
        return rDOS2q15b8;
    }

    public void setrDOS2q15b8(RadioButton rDOS2q15b8) {
        this.rDOS2q15b8 = rDOS2q15b8;
    }

    public RadioButton getrDOS2q15b9() {
        return rDOS2q15b9;
    }

    public void setrDOS2q15b9(RadioButton rDOS2q15b9) {
        this.rDOS2q15b9 = rDOS2q15b9;
    }

    public RadioButton getrDOS2q15b10() {
        return rDOS2q15b10;
    }

    public void setrDOS2q15b10(RadioButton rDOS2q15b10) {
        this.rDOS2q15b10 = rDOS2q15b10;
    }

    public RadioButton getrDOS2q15b11() {
        return rDOS2q15b11;
    }

    public void setrDOS2q15b11(RadioButton rDOS2q15b11) {
        this.rDOS2q15b11 = rDOS2q15b11;
    }

    public RadioButton getrDOS2q15b12() {
        return rDOS2q15b12;
    }

    public void setrDOS2q15b12(RadioButton rDOS2q15b12) {
        this.rDOS2q15b12 = rDOS2q15b12;
    }

    public TextView getLblS2q15cf() {
        return lblS2q15cf;
    }

    public void setLblS2q15cf(TextView lblS2q15cf) {
        this.lblS2q15cf = lblS2q15cf;
    }

    public TextView getLblS2q15cm() {
        return lblS2q15cm;
    }

    public void setLblS2q15cm(TextView lblS2q15cm) {
        this.lblS2q15cm = lblS2q15cm;
    }

    public TextView getLblS2q15d() {
        return lblS2q15d;
    }

    public void setLblS2q15d(TextView lblS2q15d) {
        this.lblS2q15d = lblS2q15d;
    }

    public RadioGroup getRadioS2q15d() {
        return radioS2q15d;
    }

    public void setRadioS2q15d(RadioGroup radioS2q15d) {
        this.radioS2q15d = radioS2q15d;
    }

    public RadioButton getrDOS2q15d1() {
        return rDOS2q15d1;
    }

    public void setrDOS2q15d1(RadioButton rDOS2q15d1) {
        this.rDOS2q15d1 = rDOS2q15d1;
    }

    public RadioButton getrDOS2q15d2() {
        return rDOS2q15d2;
    }

    public void setrDOS2q15d2(RadioButton rDOS2q15d2) {
        this.rDOS2q15d2 = rDOS2q15d2;
    }

    public TextView getLblS2q15e() {
        return lblS2q15e;
    }

    public void setLblS2q15e(TextView lblS2q15e) {
        this.lblS2q15e = lblS2q15e;
    }

    public TextView getLblS2q15fy() {
        return lblS2q15fy;
    }

    public void setLblS2q15fy(TextView lblS2q15fy) {
        this.lblS2q15fy = lblS2q15fy;
    }

    public TextView getLblS2q15fm() {
        return lblS2q15fm;
    }

    public void setLblS2q15fm(TextView lblS2q15fm) {
        this.lblS2q15fm = lblS2q15fm;
    }

    public TextView getLblS2q15g() {
        return lblS2q15g;
    }

    public void setLblS2q15g(TextView lblS2q15g) {
        this.lblS2q15g = lblS2q15g;
    }

    public RadioGroup getRadioS2q15g() {
        return radioS2q15g;
    }

    public void setRadioS2q15g(RadioGroup radioS2q15g) {
        this.radioS2q15g = radioS2q15g;
    }

    public RadioButton getrDOS2q15g1() {
        return rDOS2q15g1;
    }

    public void setrDOS2q15g1(RadioButton rDOS2q15g1) {
        this.rDOS2q15g1 = rDOS2q15g1;
    }

    public RadioButton getrDOS2q15g2() {
        return rDOS2q15g2;
    }

    public void setrDOS2q15g2(RadioButton rDOS2q15g2) {
        this.rDOS2q15g2 = rDOS2q15g2;
    }

    public RadioButton getrDOS2q15g3() {
        return rDOS2q15g3;
    }

    public void setrDOS2q15g3(RadioButton rDOS2q15g3) {
        this.rDOS2q15g3 = rDOS2q15g3;
    }

    public RadioButton getrDOS2q15g4() {
        return rDOS2q15g4;
    }

    public void setrDOS2q15g4(RadioButton rDOS2q15g4) {
        this.rDOS2q15g4 = rDOS2q15g4;
    }

    public RadioButton getrDOS2q15g5() {
        return rDOS2q15g5;
    }

    public void setrDOS2q15g5(RadioButton rDOS2q15g5) {
        this.rDOS2q15g5 = rDOS2q15g5;
    }

    public RadioButton getrDOS2q15g6() {
        return rDOS2q15g6;
    }

    public void setrDOS2q15g6(RadioButton rDOS2q15g6) {
        this.rDOS2q15g6 = rDOS2q15g6;
    }

    public RadioButton getrDOS2q15g7() {
        return rDOS2q15g7;
    }

    public void setrDOS2q15g7(RadioButton rDOS2q15g7) {
        this.rDOS2q15g7 = rDOS2q15g7;
    }

    public RadioButton getrDOS2q15g8() {
        return rDOS2q15g8;
    }

    public void setrDOS2q15g8(RadioButton rDOS2q15g8) {
        this.rDOS2q15g8 = rDOS2q15g8;
    }

    public RadioButton getrDOS2q15g9() {
        return rDOS2q15g9;
    }

    public void setrDOS2q15g9(RadioButton rDOS2q15g9) {
        this.rDOS2q15g9 = rDOS2q15g9;
    }

    public RadioButton getrDOS2q15g10() {
        return rDOS2q15g10;
    }

    public void setrDOS2q15g10(RadioButton rDOS2q15g10) {
        this.rDOS2q15g10 = rDOS2q15g10;
    }

    public RadioButton getrDOS2q15g11() {
        return rDOS2q15g11;
    }

    public void setrDOS2q15g11(RadioButton rDOS2q15g11) {
        this.rDOS2q15g11 = rDOS2q15g11;
    }

    public RadioButton getrDOS2q15g12() {
        return rDOS2q15g12;
    }

    public void setrDOS2q15g12(RadioButton rDOS2q15g12) {
        this.rDOS2q15g12 = rDOS2q15g12;
    }

    public RadioButton getrDOS2q15g13() {
        return rDOS2q15g13;
    }

    public void setrDOS2q15g13(RadioButton rDOS2q15g13) {
        this.rDOS2q15g13 = rDOS2q15g13;
    }

    public RadioButton getrDOS2q15g99() {
        return rDOS2q15g99;
    }

    public void setrDOS2q15g99(RadioButton rDOS2q15g99) {
        this.rDOS2q15g99 = rDOS2q15g99;
    }

    public TextView getLblS2q15h() {
        return lblS2q15h;
    }

    public void setLblS2q15h(TextView lblS2q15h) {
        this.lblS2q15h = lblS2q15h;
    }

    public RadioGroup getRadioS2q15h() {
        return radioS2q15h;
    }

    public void setRadioS2q15h(RadioGroup radioS2q15h) {
        this.radioS2q15h = radioS2q15h;
    }

    public RadioButton getrDOS2q15h1() {
        return rDOS2q15h1;
    }

    public void setrDOS2q15h1(RadioButton rDOS2q15h1) {
        this.rDOS2q15h1 = rDOS2q15h1;
    }

    public RadioButton getrDOS2q15h2() {
        return rDOS2q15h2;
    }

    public void setrDOS2q15h2(RadioButton rDOS2q15h2) {
        this.rDOS2q15h2 = rDOS2q15h2;
    }

    public RadioButton getrDOS2q15h3() {
        return rDOS2q15h3;
    }

    public void setrDOS2q15h3(RadioButton rDOS2q15h3) {
        this.rDOS2q15h3 = rDOS2q15h3;
    }

    public RadioButton getrDOS2q15h4() {
        return rDOS2q15h4;
    }

    public void setrDOS2q15h4(RadioButton rDOS2q15h4) {
        this.rDOS2q15h4 = rDOS2q15h4;
    }

    public RadioButton getrDOS2q15h5() {
        return rDOS2q15h5;
    }

    public void setrDOS2q15h5(RadioButton rDOS2q15h5) {
        this.rDOS2q15h5 = rDOS2q15h5;
    }

    public RadioButton getrDOS2q15h6() {
        return rDOS2q15h6;
    }

    public void setrDOS2q15h6(RadioButton rDOS2q15h6) {
        this.rDOS2q15h6 = rDOS2q15h6;
    }

    public RadioButton getrDOS2q15h7() {
        return rDOS2q15h7;
    }

    public void setrDOS2q15h7(RadioButton rDOS2q15h7) {
        this.rDOS2q15h7 = rDOS2q15h7;
    }

    public RadioButton getrDOS2q15h8() {
        return rDOS2q15h8;
    }

    public void setrDOS2q15h8(RadioButton rDOS2q15h8) {
        this.rDOS2q15h8 = rDOS2q15h8;
    }

    public RadioButton getrDOS2q15h9() {
        return rDOS2q15h9;
    }

    public void setrDOS2q15h9(RadioButton rDOS2q15h9) {
        this.rDOS2q15h9 = rDOS2q15h9;
    }

    public RadioButton getrDOS2q15h10() {
        return rDOS2q15h10;
    }

    public void setrDOS2q15h10(RadioButton rDOS2q15h10) {
        this.rDOS2q15h10 = rDOS2q15h10;
    }

    public RadioButton getrDOS2q15h11() {
        return rDOS2q15h11;
    }

    public void setrDOS2q15h11(RadioButton rDOS2q15h11) {
        this.rDOS2q15h11 = rDOS2q15h11;
    }

    public RadioButton getrDOS2q15h99() {
        return rDOS2q15h99;
    }

    public void setrDOS2q15h99(RadioButton rDOS2q15h99) {
        this.rDOS2q15h99 = rDOS2q15h99;
    }

    public TextView getLblS2q15i() {
        return lblS2q15i;
    }

    public void setLblS2q15i(TextView lblS2q15i) {
        this.lblS2q15i = lblS2q15i;
    }

    public RadioGroup getRadioS2q15i() {
        return radioS2q15i;
    }

    public void setRadioS2q15i(RadioGroup radioS2q15i) {
        this.radioS2q15i = radioS2q15i;
    }

    public RadioButton getrDOS2q15i1() {
        return rDOS2q15i1;
    }

    public void setrDOS2q15i1(RadioButton rDOS2q15i1) {
        this.rDOS2q15i1 = rDOS2q15i1;
    }

    public RadioButton getrDOS2q15i2() {
        return rDOS2q15i2;
    }

    public void setrDOS2q15i2(RadioButton rDOS2q15i2) {
        this.rDOS2q15i2 = rDOS2q15i2;
    }

    public TextView getLblS2q15j() {
        return lblS2q15j;
    }

    public void setLblS2q15j(TextView lblS2q15j) {
        this.lblS2q15j = lblS2q15j;
    }

    public RadioGroup getRadioS2q15j() {
        return radioS2q15j;
    }

    public void setRadioS2q15j(RadioGroup radioS2q15j) {
        this.radioS2q15j = radioS2q15j;
    }

    public RadioButton getrDOS2q15j1() {
        return rDOS2q15j1;
    }

    public void setrDOS2q15j1(RadioButton rDOS2q15j1) {
        this.rDOS2q15j1 = rDOS2q15j1;
    }

    public RadioButton getrDOS2q15j2() {
        return rDOS2q15j2;
    }

    public void setrDOS2q15j2(RadioButton rDOS2q15j2) {
        this.rDOS2q15j2 = rDOS2q15j2;
    }

    public RadioButton getrDOS2q15j3() {
        return rDOS2q15j3;
    }

    public void setrDOS2q15j3(RadioButton rDOS2q15j3) {
        this.rDOS2q15j3 = rDOS2q15j3;
    }

    public RadioButton getrDOS2q15j4() {
        return rDOS2q15j4;
    }

    public void setrDOS2q15j4(RadioButton rDOS2q15j4) {
        this.rDOS2q15j4 = rDOS2q15j4;
    }

    public RadioButton getrDOS2q15j5() {
        return rDOS2q15j5;
    }

    public void setrDOS2q15j5(RadioButton rDOS2q15j5) {
        this.rDOS2q15j5 = rDOS2q15j5;
    }

    public TextView getLblS2q15k() {
        return lblS2q15k;
    }

    public void setLblS2q15k(TextView lblS2q15k) {
        this.lblS2q15k = lblS2q15k;
    }

    public RadioGroup getRadioS2q15k() {
        return radioS2q15k;
    }

    public void setRadioS2q15k(RadioGroup radioS2q15k) {
        this.radioS2q15k = radioS2q15k;
    }

    public RadioButton getrDOS2q15k1() {
        return rDOS2q15k1;
    }

    public void setrDOS2q15k1(RadioButton rDOS2q15k1) {
        this.rDOS2q15k1 = rDOS2q15k1;
    }

    public RadioButton getrDOS2q15k2() {
        return rDOS2q15k2;
    }

    public void setrDOS2q15k2(RadioButton rDOS2q15k2) {
        this.rDOS2q15k2 = rDOS2q15k2;
    }

    public RadioButton getrDOS2q15k9() {
        return rDOS2q15k9;
    }

    public void setrDOS2q15k9(RadioButton rDOS2q15k9) {
        this.rDOS2q15k9 = rDOS2q15k9;
    }

    public TextView getLblS2q15lmp() {
        return lblS2q15lmp;
    }

    public void setLblS2q15lmp(TextView lblS2q15lmp) {
        this.lblS2q15lmp = lblS2q15lmp;
    }

    public TextView getLblS2q15gest() {
        return lblS2q15gest;
    }

    public void setLblS2q15gest(TextView lblS2q15gest) {
        this.lblS2q15gest = lblS2q15gest;
    }

    public TextView getLblS2q15e1() {
        return lblS2q15e1;
    }

    public void setLblS2q15e1(TextView lblS2q15e1) {
        this.lblS2q15e1 = lblS2q15e1;
    }

    public RadioGroup getRadioS2q15e1() {
        return radioS2q15e1;
    }

    public void setRadioS2q15e1(RadioGroup radioS2q15e1) {
        this.radioS2q15e1 = radioS2q15e1;
    }

    public RadioButton getrDOS2q15e11() {
        return rDOS2q15e11;
    }

    public void setrDOS2q15e11(RadioButton rDOS2q15e11) {
        this.rDOS2q15e11 = rDOS2q15e11;
    }

    public RadioButton getrDOS2q15e12() {
        return rDOS2q15e12;
    }

    public void setrDOS2q15e12(RadioButton rDOS2q15e12) {
        this.rDOS2q15e12 = rDOS2q15e12;
    }

    public TextView getLblS2q15l1() {
        return lblS2q15l1;
    }

    public void setLblS2q15l1(TextView lblS2q15l1) {
        this.lblS2q15l1 = lblS2q15l1;
    }

    public RadioGroup getRadioS2q15l1() {
        return radioS2q15l1;
    }

    public void setRadioS2q15l1(RadioGroup radioS2q15l1) {
        this.radioS2q15l1 = radioS2q15l1;
    }

    public RadioButton getrDOS2q15l11() {
        return rDOS2q15l11;
    }

    public void setrDOS2q15l11(RadioButton rDOS2q15l11) {
        this.rDOS2q15l11 = rDOS2q15l11;
    }

    public RadioButton getrDOS2q15l12() {
        return rDOS2q15l12;
    }

    public void setrDOS2q15l12(RadioButton rDOS2q15l12) {
        this.rDOS2q15l12 = rDOS2q15l12;
    }

    public EditText getS2q15both() {
        return s2q15both;
    }

    public void setS2q15both(EditText s2q15both) {
        this.s2q15both = s2q15both;
    }

    public EditText getS2q15goth() {
        return s2q15goth;
    }

    public void setS2q15goth(EditText s2q15goth) {
        this.s2q15goth = s2q15goth;
    }

    public EditText getS2q15hoth() {
        return s2q15hoth;
    }

    public void setS2q15hoth(EditText s2q15hoth) {
        this.s2q15hoth = s2q15hoth;
    }

    public EditText getS2q15joth() {
        return s2q15joth;
    }

    public void setS2q15joth(EditText s2q15joth) {
        this.s2q15joth = s2q15joth;
    }

    public void gotoSection3(View view) {

        MAPPSHelper db = new MAPPSHelper(this);
        Collection<Members> member = db.getAllMembers_GetHouseHold();

        if (member.size() > 0) {
            Intent sec2_intent = new Intent(this, Section3Activity.class);
            startActivity(sec2_intent);
        } else {
            Toast.makeText(this, "You cannot jump to section 3 without entering the members information ", Toast.LENGTH_SHORT).show();
        }
    }

    /*public void SaveData(View view) {
        spDateT = new SimpleDateFormat("dd-MM-yyyy").format(s2q15e.getCalendarView().getDate());
        spDateLMP = new SimpleDateFormat("dd-MM-yyyy").format(s2q15lmp.getCalendarView().getDate());

        CalcDOB();

        if (ValidateForm()) {

            if (!IsDOB_Greater()) {

                if (!IsLMP_Greater()) {

                    if (IsMemberExists_Household() == false) {

                        if (IsValidValues()) {


                            if (SaveDraft()) {

                                Toast.makeText(getApplicationContext(), "Storing Values", Toast.LENGTH_SHORT).show();

                                if (UpdateDB()) {

                                    MAPPSHelper db = new MAPPSHelper(this);

                                    Collection<Members> members = db.getAll_Male_Members();

                                    if (members.size() > 0) {
                                        vu_s2q15cf.setVisibility(View.VISIBLE);

                                        ArrayList<String> arr_members = new ArrayList<>();

                                        for (Members m : members) {
                                            arr_members.add(
                                                    m.getNME());
                                        }

                                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Section2Activity.this,
                                                android.R.layout.simple_spinner_item, arr_members);
                                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        ddlmembers_cf.setAdapter(adapter);

                                    }

                                    members.clear();


                                    db = new MAPPSHelper(this);

                                    members = db.getAll_Female_Members();

                                    if (members.size() > 0) {
                                        vu_s2q15cm.setVisibility(View.VISIBLE);

                                        ArrayList<String> arr_members = new ArrayList<>();

                                        for (Members m : members) {
                                            arr_members.add(
                                                    m.getNME());
                                        }

                                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Section2Activity.this,
                                                android.R.layout.simple_spinner_item, arr_members);
                                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        ddlmembers_cm.setAdapter(adapter);
                                    }

                                    CVars var = new CVars();
                                    var.StoreQ15fid("");
                                    var.StoreQ15mid("");

                                    ClearFields();

                                    vu_s2q15e1.setVisibility(View.GONE);
                                    vu_s2q15lmp.setVisibility(View.GONE);
                                    vu_s2q15k.setVisibility(View.GONE);
                                    vu_s2q15k2.setVisibility(View.GONE);
                                    vu_s2q15age.setVisibility(View.GONE);
                                    vu_s2q15joth.setVisibility(View.GONE);
                                    vu_s2q15gest.setVisibility(View.GONE);

                                    lbl_hhhead_count.setText("Total Members : " + db.getAllMembers_GetHouseHold().size());
                                    lbl_hhhead_count.setTextColor(Color.RED);

                                    s2q15a.requestFocus();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Unable to update database", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    }
                }

            }

        }
    }*/

    public void SaveData(View view) {
        spDateT = new SimpleDateFormat("dd-MM-yyyy").format(s2q15e.getCalendarView().getDate());
        spDateLMP = new SimpleDateFormat("dd-MM-yyyy").format(s2q15lmp.getCalendarView().getDate());

        CalcDOB();
        CalcLMP_Months();

        if (ValidateForm()) {

            if (!IsDOB_Greater()) {

                if (!IsLMP_Greater()) {

                    if (!IsMemberExists_Household()) {

                        if (IsValidValues()) {

                            if (SaveDraft()) {

                                Toast.makeText(getApplicationContext(), "Storing Values", Toast.LENGTH_SHORT).show();

                                if (UpdateDB()) {

                                    MAPPSHelper db = new MAPPSHelper(this);

                                    Collection<Members> members = db.getAll_Male_Members();

                                    if (members.size() > 0) {
                                        vu_s2q15cf.setVisibility(View.VISIBLE);

                                        ArrayList<String> arr_members = new ArrayList<>();

                                        for (Members m : members) {
                                            arr_members.add(
                                                    m.getNME());
                                        }

                                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Section2Activity.this,
                                                android.R.layout.simple_spinner_item, arr_members);
                                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        ddlmembers_cf.setAdapter(adapter);

                                    }

                                    members.clear();


                                    db = new MAPPSHelper(this);

                                    members = db.getAll_Female_Members();

                                    if (members.size() > 0) {
                                        vu_s2q15cm.setVisibility(View.VISIBLE);

                                        ArrayList<String> arr_members = new ArrayList<>();

                                        for (Members m : members) {
                                            arr_members.add(
                                                    m.getNME());
                                        }

                                        ArrayAdapter<String> adapter = new ArrayAdapter<>(Section2Activity.this,
                                                android.R.layout.simple_spinner_item, arr_members);
                                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        ddlmembers_cm.setAdapter(adapter);
                                    }

                                    CVars var = new CVars();
                                    var.StoreQ15fid("");
                                    var.StoreQ15mid("");

                                    vu_s2q15e1.setVisibility(View.GONE);
                                    vu_s2q15lmp.setVisibility(View.GONE);
                                    vu_s2q15k.setVisibility(View.GONE);
                                    vu_s2q15k2.setVisibility(View.GONE);
                                    vu_s2q15age.setVisibility(View.GONE);
                                    vu_s2q15joth.setVisibility(View.GONE);
                                    vu_s2q15gest.setVisibility(View.GONE);

                                    ClearFields();

                                    lbl_hhhead_count.setText("Total Members : " + db.getAllMembers_GetHouseHold().size());
                                    lbl_hhhead_count.setTextColor(Color.WHITE);

                                    s2q15a.requestFocus();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Unable to update database", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Member already entered in this household ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Date of LMP is greater than current date ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Date of birth is greater than current date ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean IsDOB_Greater() {
        boolean IsExists = false;
        spDateT = new SimpleDateFormat("dd-MM-yyyy").format(s2q15e.getCalendarView().getDate());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        String dt1 = sdf.format(dt);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Date date1 = sdf1.parse(spDateT);

            if (date1.after(dt)) {
                IsExists = true;
            }

        } catch (ParseException ex) {

        }

        return IsExists;
    }


    private boolean IsLMP_Greater() {
        boolean IsExists = false;

        spDateLMP = new SimpleDateFormat("dd-MM-yyyy").format(s2q15lmp.getCalendarView().getDate());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        String dt1 = sdf.format(dt);

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Date date1 = sdf1.parse(spDateLMP);

            if (date1.after(dt)) {
                IsExists = true;
            }

        } catch (ParseException ex) {

        }

        return IsExists;
    }

    private boolean IsMemberExists_Household() {
        boolean IsExists = false;
        MAPPSHelper db = new MAPPSHelper(this);
        IsExists = db.IsMemberExists_HouseHold(lbl_s2q1.getText().toString(), s2q15a.getText().toString());
        return IsExists;
    }


    private long CalcDOB() {

        long difference = 0;
        long differenceDates = 0;
        long day = 0;
        long month = 0;
        long year = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String mydt = sdf.format(new Date());

        String[] arr_cdt = mydt.split("-");
        String[] arr_dob = spDateT.split("-");

        String str_cdt = arr_cdt[1] + "-" + arr_cdt[0] + "-" + arr_cdt[2];
        String str_dob = arr_dob[1] + "-" + arr_dob[0] + "-" + arr_dob[2];


        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
            Date dt_cdt = sdf1.parse(str_cdt);
            Date dt_dob = sdf1.parse(str_dob);

            difference = Math.abs(dt_dob.getTime() - dt_cdt.getTime());
            differenceDates = difference / (24 * 60 * 60 * 1000);

            day = differenceDates;
            month = differenceDates / 30;
            year = differenceDates / 365;

            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            Log.d(TAG, "age_months: " + month);
            Log.d(TAG, "age_year: " + year);


            CVars var = new CVars();
            var.StoreAgeMM(String.valueOf(month));
            var.StoreAgeYY(String.valueOf(year));


        } catch (Exception e) {

        }

        return differenceDates;
    }


    private long CalcLMP_Months() {

        long difference = 0;
        long differenceDates = 0;
        long day = 0;
        long month = 0;
        long year = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String mydt = sdf.format(new Date());

        String[] arr_cdt = mydt.split("-");
        String[] arr_dob = spDateLMP.split("-");

        String str_cdt = arr_cdt[1] + "-" + arr_cdt[0] + "-" + arr_cdt[2];
        String str_dob = arr_dob[1] + "-" + arr_dob[0] + "-" + arr_dob[2];


        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
            Date dt_cdt = sdf1.parse(str_cdt);
            Date dt_dob = sdf1.parse(str_dob);

            difference = Math.abs(dt_dob.getTime() - dt_cdt.getTime());
            differenceDates = difference / (24 * 60 * 60 * 1000);

            day = differenceDates;
            month = differenceDates / 30;
            year = differenceDates / 365;

            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            CVars var = new CVars();
            var.setLMP_Months(String.valueOf(month));

        } catch (Exception e) {

        }

        return differenceDates;
    }


    public void printDifference(Date startDate, Date endDate) {

        //milliseconds
        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);

    }


    private boolean UpdateDB() {
        MAPPSHelper db = new MAPPSHelper(this);
        MAPPSApp.sc.set_ID(db.InsertRecord_Sec2(MAPPSApp.sc));
        return true;
    }


    private boolean SaveDraft() {
        MAPPSApp.sc = new Section2Contract();

        //JSONObject js = new JSONObject();
        //js.put("s2q21", "s2q21.value");
        //SRCApp.fc.setROW_S2(js.toString());

        MAPPSApp.sc.setROW_DEVID(MAPPSApp.DEVID);
        MAPPSApp.sc.setROW_UID(MAPPSApp.uid);

        CVars vars = new CVars();

        MAPPSApp.sc.setROW_S2CLUSTER(vars.get_mycluster());
        MAPPSApp.sc.setROW_S2LHW(vars.get_mylhw());
        MAPPSApp.sc.setROW_S2HH(vars.get_myhh());

        MAPPSApp.sc.setROW_S2Q1(vars.Gethhno());

        MAPPSHelper db = new MAPPSHelper(this);
        counter = db.getSNO();

        if (counter == 0) {
            MAPPSApp.sc.setROW_SNO("1");
        } else {
            MAPPSApp.sc.setROW_SNO(String.valueOf(counter + 1));
        }


        MAPPSApp.sc.setROW_S2Q15a(s2q15a.getText().toString());


        String var_s2q15i = "";
        switch (radioS2q15i.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15i_1:
                var_s2q15i = "1";
                break;
            case R.id.RDO_s2q15i_2:
                var_s2q15i = "2";
                break;
        }

        MAPPSApp.sc.setROW_S2Q15i(var_s2q15i);


        String var_s2q15b = "";
        switch (radioS2q15b.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15b_1:
                var_s2q15b = "1";
                break;
            case R.id.RDO_s2q15b_2:
                var_s2q15b = "2";
                break;
            case R.id.RDO_s2q15b_3:
                var_s2q15b = "3";
                break;
            case R.id.RDO_s2q15b_4:
                var_s2q15b = "4";
                break;
            case R.id.RDO_s2q15b_5:
                var_s2q15b = "5";
                break;
            case R.id.RDO_s2q15b_6:
                var_s2q15b = "6";
                break;
            case R.id.RDO_s2q15b_7:
                var_s2q15b = "7";
                break;
            case R.id.RDO_s2q15b_8:
                var_s2q15b = "8";
                break;
            case R.id.RDO_s2q15b_9:
                var_s2q15b = "9";
                break;
            case R.id.RDO_s2q15b_10:
                var_s2q15b = "10";
                break;
            case R.id.RDO_s2q15b_11:
                var_s2q15b = "11";
                break;
            case R.id.RDO_s2q15b_12:
                var_s2q15b = "12";
                break;
        }

        MAPPSApp.sc.setROW_S2Q15b(var_s2q15b);
        MAPPSApp.sc.setROW_S2Q15both(s2q15both.getText().toString());


        MAPPSApp.sc.setROW_S2Q15cf(vars.Getfid());
        MAPPSApp.sc.setROW_S2Q15cm(vars.Getmid());


        String var_s2q15d = "";
        switch (radioS2q15d.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15d_1:
                var_s2q15d = "1";
                break;
            case R.id.RDO_s2q15d_2:
                var_s2q15d = "2";
                break;
        }


        MAPPSApp.sc.setROW_S2Q15d(var_s2q15d);


        String var_s2q15e1 = "";
        switch (radioS2q15e1.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15e1_1:
                var_s2q15e1 = "1";
                break;
            case R.id.RDO_s2q15e1_2:
                var_s2q15e1 = "2";
                break;
        }

        MAPPSApp.sc.setROW_S2Q15e1(var_s2q15e1);

        if (var_s2q15e1.equals("1")) {
            MAPPSApp.sc.setROW_S2Q15e(spDateT);
        } else {
            MAPPSApp.sc.setROW_S2Q15e("");
        }


        if (var_s2q15e1.equals("1")) {
            MAPPSApp.sc.setROW_fy(vars.GetAgeYY());
            MAPPSApp.sc.setROW_fm(vars.GetAgeMM());
        } else {

            vars.StoreAgeYY(s2q15fy.getText().toString());
            vars.StoreAgeMM(s2q15fm.getText().toString());

            MAPPSApp.sc.setROW_fy(s2q15fy.getText().toString());
            MAPPSApp.sc.setROW_fm(s2q15fm.getText().toString());
        }


        String var_s2q15g = "";
        switch (radioS2q15g.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15g_1:
                var_s2q15g = "1";
                break;
            case R.id.RDO_s2q15g_2:
                var_s2q15g = "2";
                break;
            case R.id.RDO_s2q15g_3:
                var_s2q15g = "3";
                break;
            case R.id.RDO_s2q15g_4:
                var_s2q15g = "4";
                break;
            case R.id.RDO_s2q15g_5:
                var_s2q15g = "5";
                break;
            case R.id.RDO_s2q15g_6:
                var_s2q15g = "6";
                break;
            case R.id.RDO_s2q15g_7:
                var_s2q15g = "7";
                break;
            case R.id.RDO_s2q15g_8:
                var_s2q15g = "8";
                break;
            case R.id.RDO_s2q15g_9:
                var_s2q15g = "9";
                break;
            case R.id.RDO_s2q15g_10:
                var_s2q15g = "10";
                break;
            case R.id.RDO_s2q15g_11:
                var_s2q15g = "11";
                break;
            case R.id.RDO_s2q15g_12:
                var_s2q15g = "12";
                break;
            case R.id.RDO_s2q15g_13:
                var_s2q15g = "13";
                break;
            case R.id.RDO_s2q15g_99:
                var_s2q15g = "99";
                break;
        }


        MAPPSApp.sc.setROW_S2Q15g(var_s2q15g);
        MAPPSApp.sc.setROW_S2Q15goth(s2q15goth.getText().toString());


        String var_s2q15h = "";
        switch (radioS2q15h.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15h_1:
                var_s2q15h = "1";
                break;
            case R.id.RDO_s2q15h_2:
                var_s2q15h = "2";
                break;
            case R.id.RDO_s2q15h_3:
                var_s2q15h = "3";
                break;
            case R.id.RDO_s2q15h_4:
                var_s2q15h = "4";
                break;
            case R.id.RDO_s2q15h_5:
                var_s2q15h = "5";
                break;
            case R.id.RDO_s2q15h_6:
                var_s2q15h = "6";
                break;
            case R.id.RDO_s2q15h_7:
                var_s2q15h = "7";
                break;
            case R.id.RDO_s2q15h_8:
                var_s2q15h = "8";
                break;
            case R.id.RDO_s2q15h_9:
                var_s2q15h = "9";
                break;
            case R.id.RDO_s2q15h_10:
                var_s2q15h = "10";
                break;
            case R.id.RDO_s2q15h_11:
                var_s2q15h = "11";
                break;
            case R.id.RDO_s2q15h_99:
                var_s2q15h = "99";
                break;
        }


        MAPPSApp.sc.setROW_S2Q15h(var_s2q15h);
        MAPPSApp.sc.setROW_S2Q15hoth(s2q15hoth.getText().toString());


        String var_s2q15j = "";
        switch (radioS2q15j.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15j_1:
                var_s2q15j = "1";
                break;
            case R.id.RDO_s2q15j_2:
                var_s2q15j = "2";
                break;
            case R.id.RDO_s2q15j_3:
                var_s2q15j = "3";
                break;
            case R.id.RDO_s2q15j_4:
                var_s2q15j = "4";
                break;
            case R.id.RDO_s2q15j_5:
                var_s2q15j = "5";
                break;
        }

        MAPPSApp.sc.setROW_S2Q15j(var_s2q15j);
        MAPPSApp.sc.setROW_S2Q15joth(s2q15joth.getText().toString());


        String var_s2q15k = "";
        switch (radioS2q15k.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15k_1:
                var_s2q15k = "1";
                break;
            case R.id.RDO_s2q15k_2:
                var_s2q15k = "2";
                break;
        }

        MAPPSApp.sc.setROW_S2Q15k(var_s2q15k);


        String var_s2q15l1 = "";
        switch (radioS2q15l1.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15l1_1:
                var_s2q15l1 = "1";
                break;
            case R.id.RDO_s2q15l1_2:
                var_s2q15l1 = "2";
                break;
        }

        MAPPSApp.sc.setROW_S2Q15l1(var_s2q15l1);

        if (var_s2q15l1.equals("1")) {
            MAPPSApp.sc.setROW_S2Q15lmp(spDateLMP);
        } else {
            MAPPSApp.sc.setROW_S2Q15lmp("");
        }

        MAPPSApp.sc.setROW_S2Q15gest(getS2q15gest().getText().toString());


        if (Integer.parseInt(vars.GetAgeYY()) < 14 || Integer.parseInt(vars.GetAgeYY()) > 22) {
            MAPPSApp.sc.setROW_iselig("2");
        } else {
            MAPPSApp.sc.setROW_iselig("1");
        }

        return true;
    }


    private boolean ValidateForm() {
        //Toast.makeText(getApplicationContext(), "Validating Form", Toast.LENGTH_SHORT).show();

        if (getS2q15a().getText().toString().isEmpty()) {
            s2q15a.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter name \r\n", Toast.LENGTH_LONG).show();
            s2q15a.requestFocus();
            return false;
        } else {
            s2q15a.setError(null);
        }


        int rdo_s2q15i = radioS2q15i.getCheckedRadioButtonId();

        if (rdo_s2q15i == -1) {
            rDOS2q15i1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15i1.requestFocus();
            return false;
        } else {
            rDOS2q15i1.setError(null);
        }

        String var_s2q15i = "";
        switch (rdo_s2q15i) {
            case R.id.RDO_s2q15i_1:
                var_s2q15i = "1";
                break;
            case R.id.RDO_s2q15i_2:
                var_s2q15i = "2";
                break;
        }


        int rdo_s2q15b = radioS2q15b.getCheckedRadioButtonId();
        String var_s2q15b = "";

        if (rdo_s2q15b == -1) {
            rDOS2q15b1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15b1.requestFocus();
            return false;
        } else {
            rDOS2q15b1.setError(null);
        }

        switch (rdo_s2q15b) {
            case R.id.RDO_s2q15b_11:
                var_s2q15b = "11";
                break;
        }


        if (var_s2q15b.equals("11") && getS2q15both().getText().toString().isEmpty()) {
            s2q15both.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please specify other relation with head of household \r\n", Toast.LENGTH_LONG).show();
            s2q15both.requestFocus();
            return false;
        } else {
            s2q15both.setError(null);
        }


        int rdo_s2q15d = radioS2q15d.getCheckedRadioButtonId();

        if (rdo_s2q15d == -1) {
            rDOS2q15d1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15d1.requestFocus();
            return false;
        } else {
            rDOS2q15d1.setError(null);
        }


        int rdo_s2q15e1 = radioS2q15e1.getCheckedRadioButtonId();
        String var_s2q15e1 = "";

        if (rdo_s2q15e1 == -1) {
            rDOS2q15e11.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15e11.requestFocus();
            return false;
        } else {
            rDOS2q15e11.setError(null);
        }

        switch (rdo_s2q15e1) {
            case R.id.RDO_s2q15e1_1:
                var_s2q15e1 = "1";
                break;

            case R.id.RDO_s2q15e1_2:
                var_s2q15e1 = "2";
                break;
        }


        if (var_s2q15e1.equals("2") && getS2q15fy().getText().toString().isEmpty()) {
            s2q15fy.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter age in years \r\n", Toast.LENGTH_LONG).show();
            s2q15fy.requestFocus();
            return false;
        } else {
            s2q15fy.setError(null);
        }


        if (var_s2q15e1.equals("2")  && getS2q15fm().getText().toString().isEmpty()) {
            s2q15fm.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please enter age in months \r\n", Toast.LENGTH_LONG).show();
            s2q15fm.requestFocus();
            return false;
        } else {
            s2q15fm.setError(null);
        }


        int rdo_s2q15g = radioS2q15g.getCheckedRadioButtonId();
        String var_s2q15g = "";

        if (rdo_s2q15g == -1) {
            rDOS2q15g1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15g1.requestFocus();
            return false;
        } else {
            rDOS2q15g1.setError(null);
        }

        switch (rdo_s2q15g) {
            case R.id.RDO_s2q15g_13:
                var_s2q15g = "13";
                break;
        }


        if (var_s2q15g.equals("13")  && getS2q15goth().getText().toString().isEmpty()) {
            s2q15goth.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please specify other educational level \r\n", Toast.LENGTH_LONG).show();
            s2q15goth.requestFocus();
            return false;
        } else {
            s2q15goth.setError(null);
        }


        int rdo_s2q15h = radioS2q15h.getCheckedRadioButtonId();
        String var_s2q15h = "";

        if (rdo_s2q15h == -1) {
            rDOS2q15h1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15h1.requestFocus();
            return false;
        } else {
            rDOS2q15h1.setError(null);
        }

        switch (rdo_s2q15h) {
            case R.id.RDO_s2q15h_11:
                var_s2q15h = "11";
                break;
        }


        if (var_s2q15h.equals("11")  && getS2q15hoth().getText().toString().isEmpty()) {
            s2q15hoth.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please specify other occupation \r\n", Toast.LENGTH_LONG).show();
            s2q15hoth.requestFocus();
            return false;
        } else {
            s2q15hoth.setError(null);
        }


        int rdo_s2q15j = radioS2q15j.getCheckedRadioButtonId();
        String var_s2q15j = "";

        switch (rdo_s2q15j) {
            case R.id.RDO_s2q15j_1:
                var_s2q15j = "1";
                break;
            case R.id.RDO_s2q15j_2:
                var_s2q15j = "2";
                break;
            case R.id.RDO_s2q15j_3:
                var_s2q15j = "3";
                break;
            case R.id.RDO_s2q15j_4:
                var_s2q15j = "4";
                break;
            case R.id.RDO_s2q15j_5:
                var_s2q15j = "5";
                break;
        }


        if (rdo_s2q15j == -1) {
            rDOS2q15j1.setError(getString(R.string.rdoterr));
            Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
            rDOS2q15j1.requestFocus();
            return false;
        } else {
            rDOS2q15j1.setError(null);
        }


        if (var_s2q15j.equals("5")  && getS2q15joth().getText().toString().isEmpty()) {
            s2q15joth.setError(getString(R.string.txterr));
            Toast.makeText(getApplicationContext(), "Please specify other marital status \r\n", Toast.LENGTH_LONG).show();
            s2q15joth.requestFocus();
            return false;
        } else {
            s2q15joth.setError(null);
        }


        int rdo_s2q15k = radioS2q15k.getCheckedRadioButtonId();
        String var_s2q15k = "";
        switch (rdo_s2q15k) {
            case R.id.RDO_s2q15k_1:
                var_s2q15k = "1";
                break;
            case R.id.RDO_s2q15k_2:
                var_s2q15k = "2";
                break;
            case R.id.RDO_s2q15k_9:
                var_s2q15k = "9";
                break;
        }

        if (var_s2q15j.equals("2")  || var_s2q15j.equals("3") || var_s2q15j.equals("4") ) {

            if (var_s2q15i.equals("2") && rdo_s2q15k == -1) {
                rDOS2q15k1.setError(getString(R.string.rdoterr));
                Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                rDOS2q15k1.requestFocus();
                return false;
            } else {
                rDOS2q15k1.setError(null);
            }

        }


        int rdo_s2q15l = radioS2q15l1.getCheckedRadioButtonId();

        String var_s2q15l = "";
        switch (rdo_s2q15l) {
            case R.id.RDO_s2q15l1_1:
                var_s2q15l = "1";
                break;
            case R.id.RDO_s2q15l1_2:
                var_s2q15l = "2";
                break;
        }


        if (var_s2q15j.equals("2")  || var_s2q15j.equals("3") || var_s2q15j.equals("4")) {

            if (var_s2q15b.equals("1")) {

                if (var_s2q15i.equals("2") && rdo_s2q15l == -1) {
                    rDOS2q15l11.setError(getString(R.string.rdoterr));
                    Toast.makeText(getApplicationContext(), getString(R.string.rdoterr), Toast.LENGTH_LONG).show();
                    rDOS2q15l11.requestFocus();
                    return false;
                } else {
                    rDOS2q15l11.setError(null);
                }
            }
        }


        if (!var_s2q15j.equals("1") || !var_s2q15j.equals("5")) {

            if (var_s2q15k.equals("1")) {

                if (var_s2q15l.equals("2")) {

                    if (var_s2q15i.equals("2") && getS2q15gest().getText().toString().isEmpty()) {
                        s2q15gest.setError(getString(R.string.txterr));
                        Toast.makeText(getApplicationContext(), "Please enter gestational age \r\n", Toast.LENGTH_LONG).show();
                        s2q15gest.requestFocus();
                        return false;
                    } else {
                        s2q15gest.setError(null);
                    }
                }
            }
        }


        if (var_s2q15e1.equals("2")) {

            if (!s2q15fy.getText().toString().isEmpty()) {
                if (Integer.parseInt(s2q15fy.getText().toString()) < 0 ||
                        Integer.parseInt(s2q15fy.getText().toString()) > 110) {
                    Toast.makeText(getApplicationContext(), "Age in years must be 0 - 110", Toast.LENGTH_LONG).show();
                    s2q15fy.requestFocus();
                    return false;
                }
            }


            if (!s2q15fm.getText().toString().isEmpty()) {
                if (Integer.parseInt(s2q15fm.getText().toString()) < 0 ||
                        Integer.parseInt(s2q15fm.getText().toString()) > 11) {
                    Toast.makeText(getApplicationContext(), "Age in months must be 0 - 11", Toast.LENGTH_LONG).show();
                    s2q15fm.requestFocus();
                    return false;
                }
            }
        }

        var_s2q15l = "";
        switch (rdo_s2q15l) {
            case R.id.RDO_s2q15l1_1:
                var_s2q15l = "1";
                break;
            case R.id.RDO_s2q15l1_2:
                var_s2q15l = "2";
                break;
        }


        if (var_s2q15l.equals("1")) {

            CVars var = new CVars();
            if (Integer.parseInt(var.getLMP_Months()) > 9) {
                Toast.makeText(getApplicationContext(), "Invalid LMP date please recheck", Toast.LENGTH_LONG).show();
                return false;
            }
        }


        return true;
    }


    private void ClearFields() {
        s2q15a.setText(null);
        s2q15both.setText(null);
        s2q15fy.setText(null);
        s2q15fm.setText(null);
        s2q15goth.setText(null);
        s2q15hoth.setText(null);
        s2q15joth.setText(null);
        s2q15gest.setText(null);

        radioS2q15b.clearCheck();
        radioS2q15d.clearCheck();
        radioS2q15e1.clearCheck();
        radioS2q15g.clearCheck();
        radioS2q15h.clearCheck();
        radioS2q15i.clearCheck();
        radioS2q15j.clearCheck();
        radioS2q15k.clearCheck();
        radioS2q15l1.clearCheck();
    }

    private boolean IsValidValues() {
        if (!s2q15gest.getText().toString().isEmpty()) {
            if (Integer.parseInt(s2q15gest.getText().toString()) < 4 ||
                    Integer.parseInt(s2q15gest.getText().toString()) > 42) {
                Toast.makeText(getApplicationContext(), "Gestational age cannot be greater than 4 - 42 weeks ", Toast.LENGTH_LONG).show();
                s2q15gest.requestFocus();
                return false;
            }
        }


        String var_s2q15i = "";
        switch (radioS2q15i.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15i_1:
                var_s2q15i = "1";
                break;
            case R.id.RDO_s2q15i_2:
                var_s2q15i = "2";
                break;
        }


        int rdo_s2q15b = radioS2q15b.getCheckedRadioButtonId();
        String var_s2q15b = "";

        switch (rdo_s2q15b) {
            case R.id.RDO_s2q15b_1:
                var_s2q15b = "1";
                break;
            case R.id.RDO_s2q15b_2:
                var_s2q15b = "2";
                break;
            case R.id.RDO_s2q15b_3:
                var_s2q15b = "3";
                break;
            case R.id.RDO_s2q15b_4:
                var_s2q15b = "4";
                break;
            case R.id.RDO_s2q15b_5:
                var_s2q15b = "5";
                break;
            case R.id.RDO_s2q15b_6:
                var_s2q15b = "6";
                break;
            case R.id.RDO_s2q15b_7:
                var_s2q15b = "7";
                break;
            case R.id.RDO_s2q15b_8:
                var_s2q15b = "8";
                break;
            case R.id.RDO_s2q15b_9:
                var_s2q15b = "9";
                break;
            case R.id.RDO_s2q15b_10:
                var_s2q15b = "10";
                break;
            case R.id.RDO_s2q15b_11:
                var_s2q15b = "11";
                break;
            case R.id.RDO_s2q15b_12:
                var_s2q15b = "12";
                break;
        }


        if (var_s2q15i.equals("1") && var_s2q15b.equals("2")) {
            Toast.makeText(getApplicationContext(), "if the gender is male you cannot select 2 option of relationship", Toast.LENGTH_SHORT).show();
            radioS2q15i.requestFocus();
            return false;
        }


        String var_s2q15g = "";
        switch (radioS2q15g.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15g_1:
                var_s2q15g = "1";
                break;
            case R.id.RDO_s2q15g_2:
                var_s2q15g = "2";
                break;
            case R.id.RDO_s2q15g_3:
                var_s2q15g = "3";
                break;
            case R.id.RDO_s2q15g_4:
                var_s2q15g = "4";
                break;
            case R.id.RDO_s2q15g_5:
                var_s2q15g = "5";
                break;
            case R.id.RDO_s2q15g_6:
                var_s2q15g = "6";
                break;
            case R.id.RDO_s2q15g_7:
                var_s2q15g = "7";
                break;
            case R.id.RDO_s2q15g_8:
                var_s2q15g = "8";
                break;
            case R.id.RDO_s2q15g_9:
                var_s2q15g = "9";
                break;
            case R.id.RDO_s2q15g_10:
                var_s2q15g = "10";
                break;
            case R.id.RDO_s2q15g_11:
                var_s2q15g = "11";
                break;
            case R.id.RDO_s2q15g_12:
                var_s2q15g = "12";
                break;
            case R.id.RDO_s2q15g_13:
                var_s2q15g = "13";
                break;
            case R.id.RDO_s2q15g_99:
                var_s2q15g = "99";
                break;
        }


        String var_s2q15h = "";
        switch (radioS2q15h.getCheckedRadioButtonId()) {
            case R.id.RDO_s2q15h_1:
                var_s2q15h = "1";
                break;
            case R.id.RDO_s2q15h_2:
                var_s2q15h = "2";
                break;
            case R.id.RDO_s2q15h_3:
                var_s2q15h = "3";
                break;
            case R.id.RDO_s2q15h_4:
                var_s2q15h = "4";
                break;
            case R.id.RDO_s2q15h_5:
                var_s2q15h = "5";
                break;
            case R.id.RDO_s2q15h_6:
                var_s2q15h = "6";
                break;
            case R.id.RDO_s2q15h_7:
                var_s2q15h = "7";
                break;
            case R.id.RDO_s2q15h_8:
                var_s2q15h = "8";
                break;
            case R.id.RDO_s2q15h_9:
                var_s2q15h = "9";
                break;
            case R.id.RDO_s2q15h_10:
                var_s2q15h = "10";
                break;
            case R.id.RDO_s2q15h_11:
                var_s2q15h = "11";
                break;
            case R.id.RDO_s2q15h_99:
                var_s2q15h = "99";
                break;
        }

        if (var_s2q15g.equals("1") && var_s2q15h.equals("1")) {
            Toast.makeText(getApplicationContext(), "if person is Illiterate you cannot select 1 option", Toast.LENGTH_SHORT).show();
            radioS2q15g.requestFocus();
            return false;
        }


        if (var_s2q15g.equals("1") && var_s2q15h.equals("2")) {
            Toast.makeText(getApplicationContext(), "if person is Illiterate you cannot select 2 option", Toast.LENGTH_SHORT).show();
            radioS2q15g.requestFocus();
            return false;
        }


        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back button disabled", Toast.LENGTH_SHORT).show();
    }
}