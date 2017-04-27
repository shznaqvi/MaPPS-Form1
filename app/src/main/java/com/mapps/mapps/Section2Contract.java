package com.mapps.mapps;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by isd on 28/10/2016.
 */

public class Section2Contract implements BaseColumns {
    private static final String TAG = "SEC2_CONTRACT";

    Long _ID;
    String ROW_DEVID = MAPPSApp.DEVID;
    String ROW_S2CLUSTER;
    String ROW_S2LHW;
    String ROW_S2HH;
    String ROW_S2Q1;
    String ROW_SNO;
    String ROW_S2Q15a;
    String ROW_S2Q15i;
    String ROW_S2Q15b;
    String ROW_S2Q15both;
    String ROW_S2Q15cf;
    String ROW_S2Q15cm;
    String ROW_S2Q15d;
    String ROW_S2Q15e1;
    String ROW_S2Q15e;
    String ROW_S2Q15fy;
    String ROW_S2Q15fm;
    String ROW_fy;
    String ROW_fm;
    String ROW_S2Q15g;
    String ROW_S2Q15goth;
    String ROW_S2Q15h;
    String ROW_S2Q15hoth;
    String ROW_S2Q15j;
    String ROW_S2Q15joth;
    String ROW_S2Q15k;
    String ROW_S2Q15l1;
    String ROW_S2Q15lmp;
    String ROW_S2Q15gest;
    String ROW_iselig;
    String ROW_UID;
    String ROW_GPS_LANG = MAPPSApp.GPS_LNG;
    String ROW_GPS_LAT = MAPPSApp.GPS_LAT;
    String ROW_GPS_DT = MAPPSApp.GPS_DT;
    String ROW_GPS_ACC = MAPPSApp.GPS_ACC;
    String synced;
    String syncDate;


    Section2Contract(String devid, String s1q1, String s1q2, String s1q3, String s1q4, String s1q5,
                     String s1q6, String s1q7, String s1q8, String s1q9a, String s1q9b, String s1q10,
                     String s1q11, String s1q12, String s1q13, String s1q14) {
        this.ROW_DEVID = devid;
        this.ROW_S2Q1 = s1q1;
    }

    public Section2Contract() {

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

    public String getROW_S2Q1() {
        return this.ROW_S2Q1;
    }

    public void setROW_S2Q1(String ROW_S2Q1) {
        this.ROW_S2Q1 = ROW_S2Q1;
    }

    public String getROW_S2Q15a() {
        return this.ROW_S2Q15a;
    }

    public void setROW_S2Q15a(String ROW_S2Q15a) {
        this.ROW_S2Q15a = ROW_S2Q15a;
    }

    public String getROW_S2Q15i() {
        return this.ROW_S2Q15i;
    }

    public void setROW_S2Q15i(String ROW_S2Q15i) {
        this.ROW_S2Q15i = ROW_S2Q15i;
    }

    public String getROW_S2Q15b() {
        return this.ROW_S2Q15b;
    }

    public void setROW_S2Q15b(String ROW_S2Q15b) {
        this.ROW_S2Q15b = ROW_S2Q15b;
    }

    public String getROW_S2Q15cf() {
        return this.ROW_S2Q15cf;
    }

    public void setROW_S2Q15cf(String ROW_S2Q15cf) {
        this.ROW_S2Q15cf = ROW_S2Q15cf;
    }

    public String getROW_S2Q15cm() {
        return this.ROW_S2Q15cm;
    }

    public void setROW_S2Q15cm(String ROW_S2Q15cm) {
        this.ROW_S2Q15cm = ROW_S2Q15cm;
    }

    public String getROW_S2Q15d() {
        return this.ROW_S2Q15d;
    }

    public void setROW_S2Q15d(String ROW_S2Q15d) {
        this.ROW_S2Q15d = ROW_S2Q15d;
    }

    public String getROW_S2Q15e1() {
        return this.ROW_S2Q15e1;
    }

    public void setROW_S2Q15e1(String ROW_S2Q15e1) {
        this.ROW_S2Q15e1 = ROW_S2Q15e1;
    }

    public String getROW_S2Q15e() {
        return this.ROW_S2Q15e;
    }

    public void setROW_S2Q15e(String ROW_S2Q15e) {
        this.ROW_S2Q15e = ROW_S2Q15e;
    }

    public String getROW_S2Q15fy() {
        return this.ROW_S2Q15fy;
    }

    public void setROW_S2Q15fy(String ROW_S2Q15fy) {
        this.ROW_S2Q15fy = ROW_S2Q15fy;
    }

    public String getROW_S2Q15fm() {
        return this.ROW_S2Q15fm;
    }

    public void setROW_S2Q15fm(String ROW_S2Q15fm) {
        this.ROW_S2Q15fm = ROW_S2Q15fm;
    }

    public String getROW_S2Q15g() {
        return this.ROW_S2Q15g;
    }

    public void setROW_S2Q15g(String ROW_S2Q15g) {
        this.ROW_S2Q15g = ROW_S2Q15g;
    }

    public String getROW_S2Q15h() {
        return this.ROW_S2Q15h;
    }

    public void setROW_S2Q15h(String ROW_S2Q15h) {
        this.ROW_S2Q15h = ROW_S2Q15h;
    }

    public String getROW_S2Q15j() {
        return this.ROW_S2Q15j;
    }

    public void setROW_S2Q15j(String ROW_S2Q15j) {
        this.ROW_S2Q15j = ROW_S2Q15j;
    }

    public String getROW_S2Q15k() {
        return this.ROW_S2Q15k;
    }

    public void setROW_S2Q15k(String ROW_S2Q15k) {
        this.ROW_S2Q15k = ROW_S2Q15k;
    }

    public String getROW_S2Q15l1() {
        return this.ROW_S2Q15l1;
    }

    public void setROW_S2Q15l1(String ROW_S2Q15l1) {
        this.ROW_S2Q15l1 = ROW_S2Q15l1;
    }

    public String getROW_S2Q15lmp() {
        return this.ROW_S2Q15lmp;
    }

    public void setROW_S2Q15lmp(String ROW_S2Q15lmp) {
        this.ROW_S2Q15lmp = ROW_S2Q15lmp;
    }

    public String getROW_S2Q15gest() {
        return this.ROW_S2Q15gest;
    }

    public void setROW_S2Q15gest(String ROW_S2Q15gest) {
        this.ROW_S2Q15gest = ROW_S2Q15gest;
    }

    public String getROW_iselig() {
        return this.ROW_iselig;
    }

    public void setROW_iselig(String ROW_iselig) {
        this.ROW_iselig = ROW_iselig;
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
        return this.ROW_GPS_LAT;
    }

    public void setROW_GPS_LAT(String ROW_GPS_LAT) {
        this.ROW_GPS_LAT = ROW_GPS_LAT;
    }

    public String getROW_GPS_DT() {
        return this.ROW_GPS_DT;
    }

    public void setROW_GPS_DT(String ROW_GPS_DT) {
        this.ROW_GPS_DT = ROW_GPS_DT;
    }

    public String getROW_GPS_ACC() {
        return this.ROW_GPS_ACC;
    }

    public void setROW_GPS_ACC(String ROW_GPS_ACC) {
        this.ROW_GPS_ACC = ROW_GPS_ACC;
    }

    public String getROW_S2Q15both() {
        return this.ROW_S2Q15both;
    }

    public void setROW_S2Q15both(String ROW_S2Q15both) {
        this.ROW_S2Q15both = ROW_S2Q15both;
    }

    public String getROW_S2Q15goth() {
        return this.ROW_S2Q15goth;
    }

    public void setROW_S2Q15goth(String ROW_S2Q15goth) {
        this.ROW_S2Q15goth = ROW_S2Q15goth;
    }

    public String getROW_S2Q15hoth() {
        return this.ROW_S2Q15hoth;
    }

    public void setROW_S2Q15hoth(String ROW_S2Q15hoth) {
        this.ROW_S2Q15hoth = ROW_S2Q15hoth;
    }

    public String getROW_S2Q15joth() {
        return this.ROW_S2Q15joth;
    }

    public void setROW_S2Q15joth(String ROW_S2Q15joth) {
        this.ROW_S2Q15joth = ROW_S2Q15joth;
    }

    public String getROW_fy() {
        return this.ROW_fy;
    }

    public void setROW_fy(String ROW_fy) {
        this.ROW_fy = ROW_fy;
    }

    public String getROW_fm() {
        return this.ROW_fm;
    }

    public void setROW_fm(String ROW_fm) {
        this.ROW_fm = ROW_fm;
    }

    public String getROW_SNO() {
        return this.ROW_SNO;
    }

    public void setROW_SNO(String ROW_SNO) {
        this.ROW_SNO = ROW_SNO;
    }

    public String getROW_S2CLUSTER() {
        return this.ROW_S2CLUSTER;
    }

    public void setROW_S2CLUSTER(String ROW_S2CLUSTER) {
        this.ROW_S2CLUSTER = ROW_S2CLUSTER;
    }

    public String getROW_S2LHW() {
        return this.ROW_S2LHW;
    }

    public void setROW_S2LHW(String ROW_S2LHW) {
        this.ROW_S2LHW = ROW_S2LHW;
    }

    public String getROW_S2HH() {
        return this.ROW_S2HH;
    }

    public void setROW_S2HH(String ROW_S2HH) {
        this.ROW_S2HH = ROW_S2HH;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(Section2Entry._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(Section2Entry.ROW_DEVID, this.ROW_DEVID == null ? JSONObject.NULL : this.ROW_DEVID);
        json.put(Section2Entry.ROW_S2CLUSTER, this.ROW_S2CLUSTER == null ? JSONObject.NULL : this.ROW_S2CLUSTER);
        json.put(Section2Entry.ROW_S2LHW, this.ROW_S2LHW == null ? JSONObject.NULL : this.ROW_S2LHW);
        json.put(Section2Entry.ROW_S2HH, this.ROW_S2HH == null ? JSONObject.NULL : this.ROW_S2HH);
        json.put(Section2Entry.ROW_SNO, this.ROW_SNO == null ? JSONObject.NULL : this.ROW_SNO);
        json.put(Section2Entry.ROW_S2Q1, this.ROW_S2Q1 == null ? JSONObject.NULL : this.ROW_S2Q1);
        json.put(Section2Entry.ROW_S2Q15a, this.ROW_S2Q15a == null ? JSONObject.NULL : this.ROW_S2Q15a);
        json.put(Section2Entry.ROW_S2Q15i, this.ROW_S2Q15i == null ? JSONObject.NULL : this.ROW_S2Q15i);
        json.put(Section2Entry.ROW_S2Q15b, this.ROW_S2Q15b == null ? JSONObject.NULL : this.ROW_S2Q15b);
        json.put(Section2Entry.ROW_S2Q15both, this.ROW_S2Q15both == null ? JSONObject.NULL : this.ROW_S2Q15both);
        json.put(Section2Entry.ROW_S2Q15cf, this.ROW_S2Q15cf == null ? JSONObject.NULL : this.ROW_S2Q15cf);
        json.put(Section2Entry.ROW_S2Q15cm, this.ROW_S2Q15cm == null ? JSONObject.NULL : this.ROW_S2Q15cm);
        json.put(Section2Entry.ROW_S2Q15d, this.ROW_S2Q15d == null ? JSONObject.NULL : this.ROW_S2Q15d);
        json.put(Section2Entry.ROW_S2Q15e1, this.ROW_S2Q15e1 == null ? JSONObject.NULL : this.ROW_S2Q15e1);
        json.put(Section2Entry.ROW_S2Q15e, this.ROW_S2Q15e == null ? JSONObject.NULL : this.ROW_S2Q15e);
        json.put(Section2Entry.ROW_S2Q15fy, this.ROW_S2Q15fy == null ? JSONObject.NULL : this.ROW_S2Q15fy);
        json.put(Section2Entry.ROW_S2Q15fm, this.ROW_S2Q15fm == null ? JSONObject.NULL : this.ROW_S2Q15fm);
        json.put(Section2Entry.ROW_fy, this.ROW_fy == null ? JSONObject.NULL : this.ROW_fy);
        json.put(Section2Entry.ROW_fm, this.ROW_fm == null ? JSONObject.NULL : this.ROW_fm);
        json.put(Section2Entry.ROW_S2Q15g, this.ROW_S2Q15g == null ? JSONObject.NULL : this.ROW_S2Q15g);
        json.put(Section2Entry.ROW_S2Q15goth, this.ROW_S2Q15goth == null ? JSONObject.NULL : this.ROW_S2Q15goth);
        json.put(Section2Entry.ROW_S2Q15h, this.ROW_S2Q15h == null ? JSONObject.NULL : this.ROW_S2Q15h);
        json.put(Section2Entry.ROW_S2Q15hoth, this.ROW_S2Q15hoth == null ? JSONObject.NULL : this.ROW_S2Q15hoth);
        json.put(Section2Entry.ROW_S2Q15j, this.ROW_S2Q15j == null ? JSONObject.NULL : this.ROW_S2Q15j);
        json.put(Section2Entry.ROW_S2Q15joth, this.ROW_S2Q15joth == null ? JSONObject.NULL : this.ROW_S2Q15joth);
        json.put(Section2Entry.ROW_S2Q15k, this.ROW_S2Q15k == null ? JSONObject.NULL : this.ROW_S2Q15k);
        json.put(Section2Entry.ROW_S2Q15l1, this.ROW_S2Q15l1 == null ? JSONObject.NULL : this.ROW_S2Q15l1);
        json.put(Section2Entry.ROW_S2Q15lmp, this.ROW_S2Q15lmp == null ? JSONObject.NULL : this.ROW_S2Q15lmp);
        json.put(Section2Entry.ROW_S2Q15gest, this.ROW_S2Q15gest == null ? JSONObject.NULL : this.ROW_S2Q15gest);
        json.put(Section2Entry.ROW_iselig, this.ROW_iselig == null ? JSONObject.NULL : this.ROW_iselig);
        json.put(Section2Entry.ROW_UUID, this.ROW_UID == null ? JSONObject.NULL : this.ROW_UID);
        json.put(Section2Entry.ROW_GPS_LNG, this.ROW_GPS_LANG == null ? JSONObject.NULL : this.ROW_GPS_LANG);
        json.put(Section2Entry.ROW_GPS_LAT, this.ROW_GPS_LAT == null ? JSONObject.NULL : this.ROW_GPS_LAT);
        json.put(Section2Entry.ROW_GPS_DT, this.ROW_GPS_DT == null ? JSONObject.NULL : this.ROW_GPS_DT);
        json.put(Section2Entry.ROW_GPS_ACC, this.ROW_GPS_ACC == null ? JSONObject.NULL : this.ROW_GPS_ACC);

        return json;
    }

    public Section2Contract hydrate(Cursor cursor) {

        this._ID = cursor.getLong(cursor.getColumnIndex(Section2Entry._ID));
        this.ROW_DEVID = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_DEVID));
        this.ROW_S2CLUSTER = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2CLUSTER));
        this.ROW_S2LHW = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2LHW));
        this.ROW_S2HH = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2HH));
        this.ROW_SNO = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_SNO));
        this.ROW_S2Q1 = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q1));
        this.ROW_S2Q15a = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a));
        this.ROW_S2Q15i = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15i));
        this.ROW_S2Q15b = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15b));
        this.ROW_S2Q15both = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15both));
        this.ROW_S2Q15cf = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cf));
        this.ROW_S2Q15cm = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cm));
        this.ROW_S2Q15d = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15d));
        this.ROW_S2Q15e1 = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e1));
        this.ROW_S2Q15e = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e));
        this.ROW_S2Q15fy = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fy));
        this.ROW_S2Q15fm = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fm));
        this.ROW_fy = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fy));
        this.ROW_fm = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fm));
        this.ROW_S2Q15g = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15g));
        this.ROW_S2Q15goth = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15goth));
        this.ROW_S2Q15h = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15h));
        this.ROW_S2Q15hoth = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15hoth));
        this.ROW_S2Q15j = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15j));
        this.ROW_S2Q15joth = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15joth));
        this.ROW_S2Q15k = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15k));
        this.ROW_S2Q15l1 = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15l1));
        this.ROW_S2Q15lmp = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15lmp));
        this.ROW_S2Q15gest = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15gest));
        this.ROW_iselig = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_iselig));
        this.ROW_UID = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_UUID));
        this.ROW_GPS_LANG = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_GPS_LNG));
        this.ROW_GPS_LAT = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_GPS_LAT));
        this.ROW_GPS_DT = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_GPS_DT));
        this.ROW_GPS_ACC = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_GPS_ACC));


        return this;
    }


    public Section2Contract sync(JSONObject jsonObject) throws JSONException {

        this._ID= jsonObject.getLong(Section2Entry._ID);
        this.ROW_DEVID= jsonObject.getString(Section2Entry.ROW_DEVID);
        this.ROW_S2CLUSTER= jsonObject.getString(Section2Entry.ROW_S2CLUSTER);
        this.ROW_S2LHW= jsonObject.getString(Section2Entry.ROW_S2LHW);
        this.ROW_S2HH= jsonObject.getString(Section2Entry.ROW_S2HH);
        this.ROW_SNO= jsonObject.getString(Section2Entry.ROW_SNO);
        this.ROW_S2Q1= jsonObject.getString(Section2Entry.ROW_S2Q1);
        this.ROW_S2Q15a= jsonObject.getString(Section2Entry.ROW_S2Q15a);
        this.ROW_S2Q15i= jsonObject.getString(Section2Entry.ROW_S2Q15i);
        this.ROW_S2Q15b= jsonObject.getString(Section2Entry.ROW_S2Q15b);
        this.ROW_S2Q15both= jsonObject.getString(Section2Entry.ROW_S2Q15both);
        this.ROW_S2Q15cf= jsonObject.getString(Section2Entry.ROW_S2Q15cf);
        this.ROW_S2Q15cm= jsonObject.getString(Section2Entry.ROW_S2Q15cm);
        this.ROW_S2Q15d= jsonObject.getString(Section2Entry.ROW_S2Q15d);
        this.ROW_S2Q15e1= jsonObject.getString(Section2Entry.ROW_S2Q15e1);
        this.ROW_S2Q15e= jsonObject.getString(Section2Entry.ROW_S2Q15e);
        this.ROW_S2Q15fy= jsonObject.getString(Section2Entry.ROW_S2Q15fy);
        this.ROW_S2Q15fm= jsonObject.getString(Section2Entry.ROW_S2Q15fm);
        this.ROW_fy= jsonObject.getString(Section2Entry.ROW_fy);
        this.ROW_fm= jsonObject.getString(Section2Entry.ROW_fm);
        this.ROW_S2Q15g= jsonObject.getString(Section2Entry.ROW_S2Q15g);
        this.ROW_S2Q15goth= jsonObject.getString(Section2Entry.ROW_S2Q15goth);
        this.ROW_S2Q15h= jsonObject.getString(Section2Entry.ROW_S2Q15h);
        this.ROW_S2Q15hoth= jsonObject.getString(Section2Entry.ROW_S2Q15hoth);
        this.ROW_S2Q15j= jsonObject.getString(Section2Entry.ROW_S2Q15j);
        this.ROW_S2Q15joth= jsonObject.getString(Section2Entry.ROW_S2Q15joth);
        this.ROW_S2Q15k= jsonObject.getString(Section2Entry.ROW_S2Q15k);
        this.ROW_S2Q15l1= jsonObject.getString(Section2Entry.ROW_S2Q15l1);
        this.ROW_S2Q15lmp= jsonObject.getString(Section2Entry.ROW_S2Q15lmp);
        this.ROW_S2Q15gest= jsonObject.getString(Section2Entry.ROW_S2Q15gest);
        this.ROW_iselig= jsonObject.getString(Section2Entry.ROW_iselig);
        this.ROW_UID= jsonObject.getString(Section2Entry.ROW_UUID);
        this.ROW_GPS_LANG= jsonObject.getString(Section2Entry.ROW_GPS_LNG);
        this.ROW_GPS_LAT= jsonObject.getString(Section2Entry.ROW_GPS_LAT);
        this.ROW_GPS_DT= jsonObject.getString(Section2Entry.ROW_GPS_DT);
        this.ROW_GPS_ACC= jsonObject.getString(Section2Entry.ROW_GPS_ACC);

        return this;
    }


    public static abstract class Section2Entry implements BaseColumns {
        public static final String TABLE_NAME = "sec2";
        public static final String _ID = "_ID";

        public static final String ROW_DEVID = "devid";
        public static final String ROW_S2CLUSTER = "cluster";
        public static final String ROW_S2LHW = "lhw";
        public static final String ROW_S2HH = "hh";
        public static final String ROW_SNO = "sno";
        public static final String ROW_S2Q1 = "s2q1";
        public static final String ROW_S2Q15a = "s2q15a";
        public static final String ROW_S2Q15i = "s2q15i";
        public static final String ROW_S2Q15b = "s2q15b";
        public static final String ROW_S2Q15both = "s2q15both";
        public static final String ROW_S2Q15cf = "s2q15cf";
        public static final String ROW_S2Q15cm = "s2q15cm";
        public static final String ROW_S2Q15d = "s2q15d";
        public static final String ROW_S2Q15e1 = "s2q15e1";
        public static final String ROW_S2Q15e = "s2q15e";
        public static final String ROW_S2Q15fy = "s2q15fy";
        public static final String ROW_S2Q15fm = "s2q15fm";
        public static final String ROW_fy = "fy";
        public static final String ROW_fm = "fm";
        public static final String ROW_S2Q15g = "s2q15g";
        public static final String ROW_S2Q15goth = "s2q15goth";
        public static final String ROW_S2Q15h = "s2q15h";
        public static final String ROW_S2Q15hoth = "s2q15hoth";
        public static final String ROW_S2Q15j = "s2q15j";
        public static final String ROW_S2Q15joth = "s2q15joth";
        public static final String ROW_S2Q15k = "s2q15k";
        public static final String ROW_S2Q15l1 = "s2q15l1";
        public static final String ROW_S2Q15lmp = "s2q15lmp";
        public static final String ROW_S2Q15gest = "s2q15gest";
        public static final String ROW_iselig = "iselig";
        public static final String ROW_UUID = "UUID";
        public static final String ROW_GPS_LNG = "GPS_LNG";
        public static final String ROW_GPS_LAT = "GPS_LAT";
        public static final String ROW_GPS_DT = "GPS_DT";
        public static final String ROW_GPS_ACC = "GPS_ACC";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNC_DATE = "sync_date";

        public static String _URL = "syncdata_sec2.php";
    }
}