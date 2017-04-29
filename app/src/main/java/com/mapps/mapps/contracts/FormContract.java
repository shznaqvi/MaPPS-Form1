package com.mapps.mapps.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import com.mapps.mapps.core.MAPPSApp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by isd on 28/10/2016.
 */

public class FormContract implements BaseColumns {
    private static final String TAG = "SEC1_CONTRACT";

    Long _ID;
    String ROW_DEVID = MAPPSApp.DEVID;
    String ROW_FORM_ID;
    String ROW_S1Q1;
    String ROW_S1Q2;
    String ROW_S1Q3;
    String ROW_S1Q4;
    String ROW_S1Q5;
    String ROW_S1Q6;
    String ROW_S1Q7;
    String ROW_S1Q8;
    String ROW_S1Q9a;
    String ROW_S1Q9b;
    String ROW_S1Q10;
    String ROW_S1Q11;
    String ROW_S1Q12;
    String ROW_S1Q13;
    String ROW_S1Q14;
    String ROW_member_count;
    String ROW_USERID;
    String ROW_ENTRYDATE;
    String ROW_S3;
    String ROW_S4;
    String ROW_S5;
    String ROW_UID;
    String ROW_GPS_LANG = MAPPSApp.GPS_LNG;
    String ROW_GPS_LAT = MAPPSApp.GPS_LAT;
    String ROW_GPS_DT = MAPPSApp.GPS_DT;
    String ROW_GPS_ACC = MAPPSApp.GPS_ACC;
    String synced;
    String syncDate;

    FormContract(String devid, String formid, String s1q1, String s1q2, String s1q3, String s1q4, String s1q5,
                 String s1q6, String s1q7, String s1q8, String s1q9a, String s1q9b, String s1q10,
                 String s1q11, String s1q12, String s1q13, String s1q14, String member_count) {
        this.ROW_DEVID = devid;
        this.ROW_FORM_ID = formid;
        this.ROW_S1Q1 = s1q1;
        this.ROW_S1Q2 = s1q2;
        this.ROW_S1Q3 = s1q3;
        this.ROW_S1Q4 = s1q4;
        this.ROW_S1Q5 = s1q5;
        this.ROW_S1Q6 = s1q6;
        this.ROW_S1Q7 = s1q7;
        this.ROW_S1Q8 = s1q8;
        this.ROW_S1Q9a = s1q9a;
        this.ROW_S1Q9b = s1q9b;
        this.ROW_S1Q10 = s1q10;
        this.ROW_S1Q11 = s1q11;
        this.ROW_S1Q12 = s1q12;
        this.ROW_S1Q13 = s1q13;
        this.ROW_S1Q14 = s1q14;
        this.ROW_member_count = member_count;
    }

    public FormContract() {

    }


    public FormContract(String formid, JSONObject fc) throws JSONException {

        this.ROW_FORM_ID = formid;
        this.ROW_S3 = fc.getString("va_02");
        this.ROW_S4 = fc.getString("va_03");
        this.ROW_S5 = fc.getString("va_04");
    }

    public FormContract sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getLong(Sec1Entry._ID);
        this.ROW_DEVID = jsonObject.getString(Sec1Entry.ROW_DEVID);
        this.ROW_FORM_ID = jsonObject.getString(Sec1Entry.ROW_FORM_ID);
        this.ROW_S1Q1 = jsonObject.getString(Sec1Entry.ROW_S1Q1);
        this.ROW_S1Q2 = jsonObject.getString(Sec1Entry.ROW_S1Q2);
        this.ROW_S1Q3 = jsonObject.getString(Sec1Entry.ROW_S1Q3);
        this.ROW_S1Q4 = jsonObject.getString(Sec1Entry.ROW_S1Q4);
        this.ROW_S1Q5 = jsonObject.getString(Sec1Entry.ROW_S1Q5);
        this.ROW_S1Q6 = jsonObject.getString(Sec1Entry.ROW_S1Q6);
        this.ROW_S1Q7 = jsonObject.getString(Sec1Entry.ROW_S1Q7);
        this.ROW_S1Q8 = jsonObject.getString(Sec1Entry.ROW_S1Q8);
        this.ROW_S1Q9a = jsonObject.getString(Sec1Entry.ROW_S1Q9a);
        this.ROW_S1Q9b = jsonObject.getString(Sec1Entry.ROW_S1Q9b);
        this.ROW_S1Q10 = jsonObject.getString(Sec1Entry.ROW_S1Q10);
        this.ROW_S1Q11 = jsonObject.getString(Sec1Entry.ROW_S1Q11);
        this.ROW_S1Q12 = jsonObject.getString(Sec1Entry.ROW_S1Q12);
        this.ROW_S1Q13 = jsonObject.getString(Sec1Entry.ROW_S1Q13);
        this.ROW_S1Q14 = jsonObject.getString(Sec1Entry.ROW_S1Q14);
        this.ROW_member_count = jsonObject.getString(Sec1Entry.ROW_member_count);
        this.ROW_USERID = jsonObject.getString(Sec1Entry.ROW_USERID);
        this.ROW_ENTRYDATE = jsonObject.getString(Sec1Entry.ROW_ENTRYDATE);
        this.ROW_S3 = jsonObject.getString(Sec1Entry.ROW_S3);
        this.ROW_S4 = jsonObject.getString(Sec1Entry.ROW_S4);
        this.ROW_S5 = jsonObject.getString(Sec1Entry.ROW_S5);
        this.ROW_UID = jsonObject.getString(Sec1Entry.ROW_UUID);
        this.ROW_GPS_LANG = jsonObject.getString(Sec1Entry.ROW_GPS_LNG);
        this.ROW_GPS_LAT = jsonObject.getString(Sec1Entry.ROW_GPS_LAT);
        this.ROW_GPS_DT = jsonObject.getString(Sec1Entry.ROW_GPS_DT);
        this.ROW_GPS_ACC = jsonObject.getString(Sec1Entry.ROW_GPS_ACC);


        return this;
    }

    public FormContract hydrate(Cursor cursor) {

        this._ID = cursor.getLong(cursor.getColumnIndex(Sec1Entry._ID));
        this.ROW_DEVID = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_DEVID));
        this.ROW_FORM_ID = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_FORM_ID));
        this.ROW_S1Q1 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q1));
        this.ROW_S1Q2 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q2));
        this.ROW_S1Q3 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q3));
        this.ROW_S1Q4 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q4));
        this.ROW_S1Q5 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q5));
        this.ROW_S1Q6 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q6));
        this.ROW_S1Q7 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q7));
        this.ROW_S1Q8 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q8));
        this.ROW_S1Q9a = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q9a));
        this.ROW_S1Q9b = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q9b));
        this.ROW_S1Q10 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q10));
        this.ROW_S1Q11 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q11));
        this.ROW_S1Q12 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q12));
        this.ROW_S1Q13 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q13));
        this.ROW_S1Q14 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q14));
        this.ROW_member_count = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_member_count));
        this.ROW_USERID = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_USERID));
        this.ROW_ENTRYDATE = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_ENTRYDATE));
        this.ROW_S3 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S3));
        this.ROW_S4 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S4));
        this.ROW_S5 = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S5));
        this.ROW_UID = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_UUID));
        this.ROW_GPS_LANG = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LNG));
        this.ROW_GPS_LAT = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LAT));
        this.ROW_GPS_DT = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_DT));
        this.ROW_GPS_ACC = cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_ACC));


        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(Sec1Entry._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(Sec1Entry.ROW_DEVID, this.ROW_DEVID == null ? JSONObject.NULL : this.ROW_DEVID);
        json.put(Sec1Entry.ROW_FORM_ID, this.ROW_FORM_ID == null ? JSONObject.NULL : this.ROW_FORM_ID);
        json.put(Sec1Entry.ROW_S1Q1, this.ROW_S1Q1 == null ? JSONObject.NULL : this.ROW_S1Q1);
        json.put(Sec1Entry.ROW_S1Q2, this.ROW_S1Q2 == null ? JSONObject.NULL : this.ROW_S1Q2);
        json.put(Sec1Entry.ROW_S1Q3, this.ROW_S1Q3 == null ? JSONObject.NULL : this.ROW_S1Q3);
        json.put(Sec1Entry.ROW_S1Q4, this.ROW_S1Q4 == null ? JSONObject.NULL : this.ROW_S1Q4);
        json.put(Sec1Entry.ROW_S1Q5, this.ROW_S1Q5 == null ? JSONObject.NULL : this.ROW_S1Q5);
        json.put(Sec1Entry.ROW_S1Q6, this.ROW_S1Q6 == null ? JSONObject.NULL : this.ROW_S1Q6);
        json.put(Sec1Entry.ROW_S1Q7, this.ROW_S1Q7 == null ? JSONObject.NULL : this.ROW_S1Q7);
        json.put(Sec1Entry.ROW_S1Q8, this.ROW_S1Q8 == null ? JSONObject.NULL : this.ROW_S1Q8);
        json.put(Sec1Entry.ROW_S1Q9a, this.ROW_S1Q9a == null ? JSONObject.NULL : this.ROW_S1Q9a);
        json.put(Sec1Entry.ROW_S1Q9b, this.ROW_S1Q9b == null ? JSONObject.NULL : this.ROW_S1Q9b);
        json.put(Sec1Entry.ROW_S1Q10, this.ROW_S1Q10 == null ? JSONObject.NULL : this.ROW_S1Q10);
        json.put(Sec1Entry.ROW_S1Q11, this.ROW_S1Q11 == null ? JSONObject.NULL : this.ROW_S1Q11);
        json.put(Sec1Entry.ROW_S1Q12, this.ROW_S1Q12 == null ? JSONObject.NULL : this.ROW_S1Q12);
        json.put(Sec1Entry.ROW_S1Q13, this.ROW_S1Q13 == null ? JSONObject.NULL : this.ROW_S1Q13);
        json.put(Sec1Entry.ROW_S1Q14, this.ROW_S1Q14 == null ? JSONObject.NULL : this.ROW_S1Q14);
        json.put(Sec1Entry.ROW_member_count, this.ROW_member_count == null ? JSONObject.NULL : this.ROW_member_count);
        json.put(Sec1Entry.ROW_USERID, this.ROW_USERID == null ? JSONObject.NULL : this.ROW_USERID);
        json.put(Sec1Entry.ROW_ENTRYDATE, this.ROW_ENTRYDATE == null ? JSONObject.NULL : this.ROW_ENTRYDATE);
        json.put(Sec1Entry.ROW_S3, this.ROW_S3 == null ? JSONObject.NULL : this.ROW_S3);
        json.put(Sec1Entry.ROW_S4, this.ROW_S4 == null ? JSONObject.NULL : this.ROW_S4);
        json.put(Sec1Entry.ROW_S5, this.ROW_S5 == null ? JSONObject.NULL : this.ROW_S5);
        json.put(Sec1Entry.ROW_UUID, this.ROW_UID == null ? JSONObject.NULL : this.ROW_UID);
        json.put(Sec1Entry.ROW_GPS_LNG, this.ROW_GPS_LANG == null ? JSONObject.NULL : this.ROW_GPS_LANG);
        json.put(Sec1Entry.ROW_GPS_LAT, this.ROW_GPS_LAT == null ? JSONObject.NULL : this.ROW_GPS_LAT);
        json.put(Sec1Entry.ROW_GPS_DT, this.ROW_GPS_DT == null ? JSONObject.NULL : this.ROW_GPS_DT);
        json.put(Sec1Entry.ROW_GPS_ACC, this.ROW_GPS_ACC == null ? JSONObject.NULL : this.ROW_GPS_ACC);


        return json;
    }

    public Long get_ID() {
        return _ID;
    }

    public void set_ID(Long _ID) {
        this._ID = _ID;
    }

    public String getROW_DEVID() {
        return ROW_DEVID;
    }

    public void setROW_DEVID(String ROW_DEVID) {
        this.ROW_DEVID = ROW_DEVID;
    }

    public String getROW_FORM_ID() {
        return ROW_FORM_ID;
    }

    public void setROW_FORM_ID(String ROW_FORM_ID) {
        this.ROW_FORM_ID = ROW_FORM_ID;
    }

    public String getROW_S1Q1() {
        return ROW_S1Q1;
    }

    public void setROW_S1Q1(String ROW_S1Q1) {
        this.ROW_S1Q1 = ROW_S1Q1;
    }

    public String getROW_S1Q2() {
        return ROW_S1Q2;
    }

    public void setROW_S1Q2(String ROW_S1Q2) {
        this.ROW_S1Q2 = ROW_S1Q2;
    }

    public String getROW_S1Q3() {
        return ROW_S1Q3;
    }

    public void setROW_S1Q3(String ROW_S1Q3) {
        this.ROW_S1Q3 = ROW_S1Q3;
    }

    public String getROW_S1Q4() {
        return ROW_S1Q4;
    }

    public void setROW_S1Q4(String ROW_S1Q4) {
        this.ROW_S1Q4 = ROW_S1Q4;
    }

    public String getROW_S1Q5() {
        return ROW_S1Q5;
    }

    public void setROW_S1Q5(String ROW_S1Q5) {
        this.ROW_S1Q5 = ROW_S1Q5;
    }

    public String getROW_S1Q6() {
        return ROW_S1Q6;
    }

    public void setROW_S1Q6(String ROW_S1Q6) {
        this.ROW_S1Q6 = ROW_S1Q6;
    }

    public String getROW_S1Q7() {
        return ROW_S1Q7;
    }

    public void setROW_S1Q7(String ROW_S1Q7) {
        this.ROW_S1Q7 = ROW_S1Q7;
    }

    public String getROW_S1Q8() {
        return ROW_S1Q8;
    }

    public void setROW_S1Q8(String ROW_S1Q8) {
        this.ROW_S1Q8 = ROW_S1Q8;
    }

    public String getROW_S1Q9a() {
        return ROW_S1Q9a;
    }

    public void setROW_S1Q9a(String ROW_S1Q9a) {
        this.ROW_S1Q9a = ROW_S1Q9a;
    }

    public String getROW_S1Q9b() {
        return ROW_S1Q9b;
    }

    public void setROW_S1Q9b(String ROW_S1Q9b) {
        this.ROW_S1Q9b = ROW_S1Q9b;
    }

    public String getROW_S1Q10() {
        return ROW_S1Q10;
    }

    public void setROW_S1Q10(String ROW_S1Q10) {
        this.ROW_S1Q10 = ROW_S1Q10;
    }

    public String getROW_S1Q11() {
        return ROW_S1Q11;
    }

    public void setROW_S1Q11(String ROW_S1Q11) {
        this.ROW_S1Q11 = ROW_S1Q11;
    }

    public String getROW_S1Q12() {
        return ROW_S1Q12;
    }

    public void setROW_S1Q12(String ROW_S1Q12) {
        this.ROW_S1Q12 = ROW_S1Q12;
    }

    public String getROW_S1Q13() {
        return ROW_S1Q13;
    }

    public void setROW_S1Q13(String ROW_S1Q13) {
        this.ROW_S1Q13 = ROW_S1Q13;
    }

    public String getROW_S1Q14() {
        return ROW_S1Q14;
    }

    public void setROW_S1Q14(String ROW_S1Q14) {
        this.ROW_S1Q14 = ROW_S1Q14;
    }

    public void setROW_member_count(String ROW_member_count) {
        this.ROW_member_count = ROW_member_count;
    }

    public String getROW_member_count() {
        return ROW_member_count;
    }

    public String getROW_S3() {
        return ROW_S3;
    }

    public void setROW_S3(String ROW_S3) {
        this.ROW_S3 = ROW_S3;
    }

    public String getROW_S4() {
        return ROW_S4;
    }

    public void setROW_S4(String ROW_S4) {
        this.ROW_S4 = ROW_S4;
    }

    public String getROW_S5() {
        return ROW_S5;
    }

    public void setROW_S5(String ROW_S5) {
        this.ROW_S5 = ROW_S5;
    }

    public String getROW_UID() {
        return ROW_UID;
    }

    public void setROW_UID(String ROW_UID) {
        this.ROW_UID = ROW_UID;
    }

    public String getROW_GPS_LANG() {
        return ROW_GPS_LANG;
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

    public String getROW_USERID() {
        return ROW_USERID;
    }

    public void setROW_USERID(String ROW_USERID) {
        this.ROW_USERID = ROW_USERID;
    }

    public String getROW_ENTRYDATE() {
        return ROW_ENTRYDATE;
    }

    public void setROW_ENTRYDATE(String ROW_ENTRYDATE) {
        this.ROW_ENTRYDATE = ROW_ENTRYDATE;
    }

    public static abstract class Sec1Entry implements BaseColumns {
        public static final String TABLE_NAME = "sec1";
        public static final String _ID = "_ID";

        public static final String ROW_DEVID = "devid";
        public static final String ROW_FORM_ID = "formid";
        public static final String ROW_S1Q1 = "s1q1";
        public static final String ROW_S1Q2 = "s1q2";
        public static final String ROW_S1Q3 = "s1q3";
        public static final String ROW_S1Q4 = "s1q4";
        public static final String ROW_S1Q5 = "s1q5";
        public static final String ROW_S1Q6 = "s1q6";
        public static final String ROW_S1Q7 = "s1q7";
        public static final String ROW_S1Q8 = "s1q8";
        public static final String ROW_S1Q9a = "s1q9a";
        public static final String ROW_S1Q9b = "s1q9b";
        public static final String ROW_S1Q10 = "s1q10";
        public static final String ROW_S1Q11 = "s1q11";
        public static final String ROW_S1Q12 = "s1q12";
        public static final String ROW_S1Q13 = "s1q13";
        public static final String ROW_S1Q14 = "s1q14";
        public static final String ROW_member_count = "member_count";

        public static final String ROW_USERID = "userid";
        public static final String ROW_ENTRYDATE = "entrydate";
        public static final String ROW_S3 = "s3";
        public static final String ROW_S4 = "s4";
        public static final String ROW_S5 = "s5";
        public static final String ROW_UUID = "UUID";
        public static final String ROW_GPS_LNG = "GPS_LNG";
        public static final String ROW_GPS_LAT = "GPS_LAT";
        public static final String ROW_GPS_DT = "GPS_DT";
        public static final String ROW_GPS_ACC = "GPS_ACC";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNC_DATE = "sync_date";

        public static String _URL = "syncdata.php";
    }
}