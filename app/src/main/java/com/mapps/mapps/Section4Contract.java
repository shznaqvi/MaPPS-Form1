package com.mapps.mapps;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by isd on 28/10/2016.
 */

public class Section4Contract implements BaseColumns {
    private static final String TAG = "SEC4_CONTRACT";

    Long _ID;
    String ROW_DEVID = MAPPSApp.DEVID;
    String ROW_S4CLUSTER;
    String ROW_S4LHW;
    String ROW_S4HH;
    String ROW_S4Q1;
    String ROW_SNO;
    String ROW_S4Q28a;
    String ROW_S4Q28b;
    String ROW_S4Q28c;
    String ROW_S4Q28d;
    String ROW_S4Q28oth;
    String ROW_S4Q28e;
    String ROW_S4Q28f;
    String ROW_S4Q28f1;
    String ROW_S4Q28f2;
    String ROW_S4Q28f3;
    String ROW_S4Q28f4;
    String ROW_S4Q28f5;
    String ROW_S4Q28f6;
    String ROW_S4Q28f7;
    String ROW_S4Q28f8;
    String ROW_S4Q28f9;
    String ROW_S4Q28g;
    String ROW_S4Q28h;
    String ROW_S4Q14;
    String ROW_UID;
    String ROW_GPS_LANG = MAPPSApp.GPS_LNG;
    String ROW_GPS_LAT = MAPPSApp.GPS_LAT;
    String ROW_GPS_DT = MAPPSApp.GPS_DT;
    String ROW_GPS_ACC = MAPPSApp.GPS_ACC;

    Section4Contract(String devid, String s1q1, String s1q2, String s1q3, String s1q4, String s1q5,
                     String s1q6, String s1q7, String s1q8, String s1q9a, String s1q9b, String s1q10,
                     String s1q11, String s1q12, String s1q13, String s1q14) {
        this.ROW_DEVID = devid;
        this.ROW_S4Q1 = s1q1;
    }

    public Section4Contract() {

    }


    public Section4Contract(String formid, JSONObject fc) throws JSONException {

    }

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String getROW_DEVID() {
        return this.ROW_DEVID;
    }

    public void setROW_DEVID(String ROW_DEVID) {
        this.ROW_DEVID = ROW_DEVID;
    }

    public String getROW_S4Q1() {
        return this.ROW_S4Q1;
    }

    public void setROW_S4Q1(String ROW_S4Q1) {
        this.ROW_S4Q1 = ROW_S4Q1;
    }

    public String getROW_S4Q28a() {
        return this.ROW_S4Q28a;
    }

    public void setROW_S4Q28a(String ROW_S4Q28a) {
        this.ROW_S4Q28a = ROW_S4Q28a;
    }

    public String getROW_S4Q28b() {
        return this.ROW_S4Q28b;
    }

    public void setROW_S4Q28b(String ROW_S4Q28b) {
        this.ROW_S4Q28b = ROW_S4Q28b;
    }

    public String getROW_S4Q28c() {
        return ROW_S4Q28c;
    }

    public void setROW_S4Q28c(String ROW_S4Q28c) {
        this.ROW_S4Q28c = ROW_S4Q28c;
    }

    public String getROW_S4Q28d() {
        return ROW_S4Q28d;
    }

    public void setROW_S4Q28d(String ROW_S4Q28d) {
        this.ROW_S4Q28d = ROW_S4Q28d;
    }

    public String getROW_S4Q28oth() {
        return this.ROW_S4Q28oth;
    }

    public void setROW_S4Q28oth(String ROW_S4Q28oth) {
        this.ROW_S4Q28oth = ROW_S4Q28oth;
    }

    public String getROW_S4Q28e() {
        return this.ROW_S4Q28e;
    }

    public void setROW_S4Q28e(String ROW_S4Q28e) {
        this.ROW_S4Q28e = ROW_S4Q28e;
    }

    public String getROW_S4Q28g() {
        return this.ROW_S4Q28g;
    }

    public void setROW_S4Q28g(String ROW_S4Q28g) {
        this.ROW_S4Q28g = ROW_S4Q28g;
    }

    public String getROW_S4Q28h() {
        return this.ROW_S4Q28h;
    }

    public void setROW_S4Q28h(String ROW_S4Q28h) {
        this.ROW_S4Q28h = ROW_S4Q28h;
    }

    public String getROW_UID() {
        return this.ROW_UID;
    }

    public void setROW_UID(String ROW_UID) {
        this.ROW_UID = ROW_UID;
    }

    public String getROW_GPS_LANG() {
        return this.ROW_GPS_LANG;
    }

    public void setROW_GPS_LANG(String ROW_GPS_LANG) {
        this.ROW_GPS_LANG = ROW_GPS_LANG;
    }

    public String getROW_GPS_LAT() {
        return ROW_GPS_LAT;
    }

    public void setROW_GPS_LAT(String ROW_GPS_LAT) {
        this.ROW_GPS_LAT = ROW_GPS_LAT;
    }

    public String getROW_GPS_DT() {
        return ROW_GPS_DT;
    }

    public void setROW_GPS_DT(String ROW_GPS_DT) {
        this.ROW_GPS_DT = ROW_GPS_DT;
    }

    public String getROW_GPS_ACC() {
        return ROW_GPS_ACC;
    }

    public void setROW_GPS_ACC(String ROW_GPS_ACC) {
        this.ROW_GPS_ACC = ROW_GPS_ACC;
    }

    public String getROW_S4Q14() {
        return this.ROW_S4Q14;
    }

    public void setROW_S4Q14(String ROW_S4Q14) {
        this.ROW_S4Q14 = ROW_S4Q14;
    }

    public String getROW_SNO() {
        return this.ROW_SNO;
    }

    public void setROW_SNO(String ROW_SNO) {
        this.ROW_SNO = ROW_SNO;
    }

    public String getROW_S4CLUSTER() {
        return this.ROW_S4CLUSTER;
    }

    public void setROW_S4CLUSTER(String ROW_S4CLUSTER) {
        this.ROW_S4CLUSTER = ROW_S4CLUSTER;
    }

    public String getROW_S4LHW() {
        return this.ROW_S4LHW;
    }

    public void setROW_S4LHW(String ROW_S4LHW) {
        this.ROW_S4LHW = ROW_S4LHW;
    }

    public String getROW_S4HH() {
        return this.ROW_S4HH;
    }

    public void setROW_S4HH(String ROW_S4HH) {
        this.ROW_S4HH = ROW_S4HH;
    }

    public String getROW_S4Q28f() {
        return this.ROW_S4Q28f;
    }

    public void setROW_S4Q28f(String ROW_S4Q28f) {
        this.ROW_S4Q28f = ROW_S4Q28f;
    }

    public String getROW_S4Q28f1() {
        return this.ROW_S4Q28f1;
    }

    public void setROW_S4Q28f1(String ROW_S4Q28f1) {
        this.ROW_S4Q28f1 = ROW_S4Q28f1;
    }

    public String getROW_S4Q28f2() {
        return this.ROW_S4Q28f2;
    }

    public void setROW_S4Q28f2(String ROW_S4Q28f2) {
        this.ROW_S4Q28f2 = ROW_S4Q28f2;
    }

    public String getROW_S4Q28f3() {
        return this.ROW_S4Q28f3;
    }

    public void setROW_S4Q28f3(String ROW_S4Q28f3) {
        this.ROW_S4Q28f3 = ROW_S4Q28f3;
    }

    public String getROW_S4Q28f4() {
        return this.ROW_S4Q28f4;
    }

    public void setROW_S4Q28f4(String ROW_S4Q28f4) {
        this.ROW_S4Q28f4 = ROW_S4Q28f4;
    }

    public String getROW_S4Q28f5() {
        return this.ROW_S4Q28f5;
    }

    public void setROW_S4Q28f5(String ROW_S4Q28f5) {
        this.ROW_S4Q28f5 = ROW_S4Q28f5;
    }

    public String getROW_S4Q28f6() {
        return this.ROW_S4Q28f6;
    }

    public void setROW_S4Q28f6(String ROW_S4Q28f6) {
        this.ROW_S4Q28f6 = ROW_S4Q28f6;
    }

    public String getROW_S4Q28f7() {
        return this.ROW_S4Q28f7;
    }

    public void setROW_S4Q28f7(String ROW_S4Q28f7) {
        this.ROW_S4Q28f7 = ROW_S4Q28f7;
    }

    public String getROW_S4Q28f8() {
        return this.ROW_S4Q28f8;
    }

    public void setROW_S4Q28f8(String ROW_S4Q28f8) {
        this.ROW_S4Q28f8 = ROW_S4Q28f8;
    }

    public String getROW_S4Q28f9() {
        return this.ROW_S4Q28f9;
    }

    public void setROW_S4Q28f9(String ROW_S4Q28f9) {
        this.ROW_S4Q28f9 = ROW_S4Q28f9;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(Section4Entry._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(Section4Entry.ROW_DEVID, this.ROW_DEVID == null ? JSONObject.NULL : this.ROW_DEVID);
        json.put(Section4Entry.ROW_S4CLUSTER, this.ROW_S4CLUSTER == null ? JSONObject.NULL : this.ROW_S4CLUSTER);
        json.put(Section4Entry.ROW_S4LHW, this.ROW_S4LHW == null ? JSONObject.NULL : this.ROW_S4LHW);
        json.put(Section4Entry.ROW_S4HH, this.ROW_S4HH == null ? JSONObject.NULL : this.ROW_S4HH);
        json.put(Section4Entry.ROW_S4Q1, this.ROW_S4Q1 == null ? JSONObject.NULL : this.ROW_S4Q1);
        json.put(Section4Entry.ROW_SNO, this.ROW_SNO == null ? JSONObject.NULL : this.ROW_SNO);
        json.put(Section4Entry.ROW_S4Q28a, this.ROW_S4Q28a == null ? JSONObject.NULL : this.ROW_S4Q28a);
        json.put(Section4Entry.ROW_S4Q28b, this.ROW_S4Q28b == null ? JSONObject.NULL : this.ROW_S4Q28b);
        json.put(Section4Entry.ROW_S4Q28c, this.ROW_S4Q28c == null ? JSONObject.NULL : this.ROW_S4Q28c);
        json.put(Section4Entry.ROW_S4Q28d, this.ROW_S4Q28d == null ? JSONObject.NULL : this.ROW_S4Q28d);
        json.put(Section4Entry.ROW_S4Q28oth, this.ROW_S4Q28oth == null ? JSONObject.NULL : this.ROW_S4Q28oth);
        json.put(Section4Entry.ROW_S4Q28e, this.ROW_S4Q28e == null ? JSONObject.NULL : this.ROW_S4Q28e);
        json.put(Section4Entry.ROW_S4Q28f, this.ROW_S4Q28f == null ? JSONObject.NULL : this.ROW_S4Q28f);
        json.put(Section4Entry.ROW_S4Q28f1, this.ROW_S4Q28f1 == null ? JSONObject.NULL : this.ROW_S4Q28f1);
        json.put(Section4Entry.ROW_S4Q28f2, this.ROW_S4Q28f2 == null ? JSONObject.NULL : this.ROW_S4Q28f2);
        json.put(Section4Entry.ROW_S4Q28f3, this.ROW_S4Q28f3 == null ? JSONObject.NULL : this.ROW_S4Q28f3);
        json.put(Section4Entry.ROW_S4Q28f4, this.ROW_S4Q28f4 == null ? JSONObject.NULL : this.ROW_S4Q28f4);
        json.put(Section4Entry.ROW_S4Q28f5, this.ROW_S4Q28f5 == null ? JSONObject.NULL : this.ROW_S4Q28f5);
        json.put(Section4Entry.ROW_S4Q28f6, this.ROW_S4Q28f6 == null ? JSONObject.NULL : this.ROW_S4Q28f6);
        json.put(Section4Entry.ROW_S4Q28f7, this.ROW_S4Q28f7 == null ? JSONObject.NULL : this.ROW_S4Q28f7);
        json.put(Section4Entry.ROW_S4Q28f8, this.ROW_S4Q28f8 == null ? JSONObject.NULL : this.ROW_S4Q28f8);
        json.put(Section4Entry.ROW_S4Q28f9, this.ROW_S4Q28f9 == null ? JSONObject.NULL : this.ROW_S4Q28f9);
        json.put(Section4Entry.ROW_S4Q28g, this.ROW_S4Q28g == null ? JSONObject.NULL : this.ROW_S4Q28g);
        json.put(Section4Entry.ROW_S4Q28h, this.ROW_S4Q28h == null ? JSONObject.NULL : this.ROW_S4Q28h);
        json.put(Section4Entry.ROW_S4Q14, this.ROW_S4Q14 == null ? JSONObject.NULL : this.ROW_S4Q14);
        json.put(Section4Entry.ROW_UUID, this.ROW_UID == null ? JSONObject.NULL : this.ROW_UID);
        json.put(Section4Entry.ROW_GPS_LNG, this.ROW_GPS_LANG == null ? JSONObject.NULL : this.ROW_GPS_LANG);
        json.put(Section4Entry.ROW_GPS_LAT, this.ROW_GPS_LAT == null ? JSONObject.NULL : this.ROW_GPS_LAT);
        json.put(Section4Entry.ROW_GPS_DT, this.ROW_GPS_DT == null ? JSONObject.NULL : this.ROW_GPS_DT);
        json.put(Section4Entry.ROW_GPS_ACC, this.ROW_GPS_ACC == null ? JSONObject.NULL : this.ROW_GPS_ACC);

        return json;
    }

    public Section4Contract sync(JSONObject jsonObject) throws JSONException {

        this._ID= jsonObject.getLong(Section4Entry._ID);
        this.ROW_DEVID= jsonObject.getString(Section4Entry.ROW_DEVID);
        this.ROW_S4CLUSTER= jsonObject.getString(Section4Entry.ROW_S4CLUSTER);
        this.ROW_S4LHW= jsonObject.getString(Section4Entry.ROW_S4LHW);
        this.ROW_S4HH= jsonObject.getString(Section4Entry.ROW_S4HH);
        this.ROW_S4Q1= jsonObject.getString(Section4Entry.ROW_S4Q1);
        this.ROW_SNO= jsonObject.getString(Section4Entry.ROW_SNO);
        this.ROW_S4Q28a= jsonObject.getString(Section4Entry.ROW_S4Q28a);
        this.ROW_S4Q28b= jsonObject.getString(Section4Entry.ROW_S4Q28b);
        this.ROW_S4Q28c= jsonObject.getString(Section4Entry.ROW_S4Q28c);
        this.ROW_S4Q28d= jsonObject.getString(Section4Entry.ROW_S4Q28d);
        this.ROW_S4Q28oth= jsonObject.getString(Section4Entry.ROW_S4Q28oth);
        this.ROW_S4Q28e= jsonObject.getString(Section4Entry.ROW_S4Q28e);
        this.ROW_S4Q28f= jsonObject.getString(Section4Entry.ROW_S4Q28f);
        this.ROW_S4Q28f1= jsonObject.getString(Section4Entry.ROW_S4Q28f1);
        this.ROW_S4Q28f2= jsonObject.getString(Section4Entry.ROW_S4Q28f2);
        this.ROW_S4Q28f3= jsonObject.getString(Section4Entry.ROW_S4Q28f3);
        this.ROW_S4Q28f4= jsonObject.getString(Section4Entry.ROW_S4Q28f4);
        this.ROW_S4Q28f5= jsonObject.getString(Section4Entry.ROW_S4Q28f5);
        this.ROW_S4Q28f6= jsonObject.getString(Section4Entry.ROW_S4Q28f6);
        this.ROW_S4Q28f7= jsonObject.getString(Section4Entry.ROW_S4Q28f7);
        this.ROW_S4Q28f8= jsonObject.getString(Section4Entry.ROW_S4Q28f8);
        this.ROW_S4Q28f9= jsonObject.getString(Section4Entry.ROW_S4Q28f9);
        this.ROW_S4Q28g= jsonObject.getString(Section4Entry.ROW_S4Q28g);
        this.ROW_S4Q28h= jsonObject.getString(Section4Entry.ROW_S4Q28h);
        this.ROW_S4Q14= jsonObject.getString(Section4Entry.ROW_S4Q14);
        this.ROW_UID= jsonObject.getString(Section4Entry.ROW_UUID);
        this.ROW_GPS_LANG= jsonObject.getString(Section4Entry.ROW_GPS_LNG);
        this.ROW_GPS_LAT= jsonObject.getString(Section4Entry.ROW_GPS_LAT);
        this.ROW_GPS_DT= jsonObject.getString(Section4Entry.ROW_GPS_DT);
        this.ROW_GPS_ACC= jsonObject.getString(Section4Entry.ROW_GPS_ACC);


        return this;
    }

    public Section4Contract hydrate(Cursor cursor) {
        this._ID = cursor.getLong(cursor.getColumnIndex(Section4Entry._ID));
        this.ROW_DEVID = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_DEVID));
        this.ROW_S4CLUSTER = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4CLUSTER));
        this.ROW_S4LHW = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4LHW));
        this.ROW_S4HH = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4HH));
        this.ROW_S4Q1 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q1));
        this.ROW_SNO = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_SNO));
        this.ROW_S4Q28a = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28a));
        this.ROW_S4Q28b = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28b));
        this.ROW_S4Q28c = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28c));
        this.ROW_S4Q28d = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28d));
        this.ROW_S4Q28oth = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28oth));
        this.ROW_S4Q28e = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28e));
        this.ROW_S4Q28f = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f));
        this.ROW_S4Q28f1 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f1));
        this.ROW_S4Q28f2 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f2));
        this.ROW_S4Q28f3 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f3));
        this.ROW_S4Q28f4 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f4));
        this.ROW_S4Q28f5 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f5));
        this.ROW_S4Q28f6 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f6));
        this.ROW_S4Q28f7 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f7));
        this.ROW_S4Q28f8 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f8));
        this.ROW_S4Q28f9 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f9));
        this.ROW_S4Q28g = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28g));
        this.ROW_S4Q28h = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28h));
        this.ROW_S4Q14 = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q14));
        this.ROW_UID = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_UUID));
        this.ROW_GPS_LANG = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_GPS_LNG));
        this.ROW_GPS_LAT = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_GPS_LAT));
        this.ROW_GPS_DT = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_GPS_DT));
        this.ROW_GPS_ACC = cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_GPS_ACC));

        return this;
    }


    public static abstract class Section4Entry implements BaseColumns {
        public static final String TABLE_NAME = "sec4";
        public static final String _ID = "_ID";

        public static final String ROW_DEVID = "devid";
        public static final String ROW_S4CLUSTER = "cluster";
        public static final String ROW_S4LHW = "lhw";
        public static final String ROW_S4HH = "hh";
        public static final String ROW_S4Q1 = "s4q1";
        public static final String ROW_SNO = "sno";
        public static final String ROW_S4Q28a = "s4q28a";
        public static final String ROW_S4Q28b = "s4q28b";
        public static final String ROW_S4Q28c = "s4q28c";
        public static final String ROW_S4Q28d = "s4q28d";
        public static final String ROW_S4Q28oth = "s4q28oth";
        public static final String ROW_S4Q28e = "s4q28e";
        public static final String ROW_S4Q28f = "s4q28f";
        public static final String ROW_S4Q28f1 = "s4q28f1";
        public static final String ROW_S4Q28f2 = "s4q28f2";
        public static final String ROW_S4Q28f3 = "s4q28f3";
        public static final String ROW_S4Q28f4 = "s4q28f4";
        public static final String ROW_S4Q28f5 = "s4q28f5";
        public static final String ROW_S4Q28f6 = "s4q28f6";
        public static final String ROW_S4Q28f7 = "s4q28f7";
        public static final String ROW_S4Q28f8 = "s4q28f8";
        public static final String ROW_S4Q28f9 = "s4q28f9";
        public static final String ROW_S4Q28g = "s4q28g";
        public static final String ROW_S4Q28h = "s4q28h";
        public static final String ROW_S4Q14 = "s4q14";
        public static final String ROW_UUID = "UUID";
        public static final String ROW_GPS_LNG = "GPS_LNG";
        public static final String ROW_GPS_LAT = "GPS_LAT";
        public static final String ROW_GPS_DT = "GPS_DT";
        public static final String ROW_GPS_ACC = "GPS_ACC";

        public static String _URL = "syncdata_sec4.php";
    }
}