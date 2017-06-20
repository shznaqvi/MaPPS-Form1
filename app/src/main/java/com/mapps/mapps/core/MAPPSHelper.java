package com.mapps.mapps.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mapps.mapps.contracts.FormContract;
import com.mapps.mapps.contracts.FormContract.Sec1Entry;
import com.mapps.mapps.contracts.GetHFContract;
import com.mapps.mapps.contracts.GetHFContract.GetHFEntry;
import com.mapps.mapps.contracts.GetLHWContract;
import com.mapps.mapps.contracts.GetLHWContract.GetLHWEntry;
import com.mapps.mapps.contracts.Section2Contract;
import com.mapps.mapps.contracts.Section2Contract.Section2Entry;
import com.mapps.mapps.contracts.Section4Contract;
import com.mapps.mapps.contracts.Section4Contract.Section4Entry;
import com.mapps.mapps.contracts.UsersContract;
import com.mapps.mapps.contracts.UsersContract.singleUser;
import com.mapps.mapps.otherClasses.Members;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * Created by isd on 20/10/2016.
 */
public class MAPPSHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE IF NOT EXISTS " + singleUser.TABLE_NAME + "("
            + singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + singleUser.ROW_USERNAME + " TEXT,"
            + singleUser.ROW_PASSWORD + " TEXT,"
            + singleUser.ROW_USERSTATUS + " TEXT,"
            + singleUser.ROW_ISADMIN + " TEXT );";
    /*******************************
     * Section 1
     ******************************/

    public static final String SQL_CREATE_BASELINE_SEC1 = "CREATE TABLE IF NOT EXISTS " + Sec1Entry.TABLE_NAME + "("
            + Sec1Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Sec1Entry.ROW_DEVID + " TEXT,"
            + Sec1Entry.ROW_FORM_ID + " INTEGER,"
            + Sec1Entry.ROW_S1Q1 + " TEXT,"
            + Sec1Entry.ROW_S1Q2 + " TEXT,"
            + Sec1Entry.ROW_S1Q3 + " TEXT,"
            + Sec1Entry.ROW_S1Q4 + " TEXT,"
            + Sec1Entry.ROW_S1Q5 + " TEXT,"
            + Sec1Entry.ROW_S1Q6 + " TEXT,"
            + Sec1Entry.ROW_S1Q7 + " TEXT,"
            + Sec1Entry.ROW_S1Q8 + " TEXT,"
            + Sec1Entry.ROW_S1Q9a + " TEXT,"
            + Sec1Entry.ROW_S1Q9b + " TEXT,"
            + Sec1Entry.ROW_S1Q10 + " DATETIME,"
            + Sec1Entry.ROW_S1Q11 + " INTEGER,"
            + Sec1Entry.ROW_S1Q12 + " INTEGER,"
            + Sec1Entry.ROW_S1Q13 + " INTEGER,"
            + Sec1Entry.ROW_S1Q14 + " INTEGER,"
            + Sec1Entry.ROW_USERID + " TEXT,"
            + Sec1Entry.ROW_ENTRYDATE + " DATETIME,"
            + Sec1Entry.ROW_S3 + " TEXT,"
            + Sec1Entry.ROW_S4 + " TEXT,"
            + Sec1Entry.ROW_S5 + " TEXT,"
            + Sec1Entry.ROW_UUID + " TEXT,"
            + Sec1Entry.ROW_GPS_LNG + " TEXT,"
            + Sec1Entry.ROW_GPS_LAT + " TEXT,"
            + Sec1Entry.ROW_GPS_DT + " TEXT,"
            + Sec1Entry.COLUMN_SYNCED + " TEXT,"
            + Sec1Entry.COLUMN_SYNC_DATE + " TEXT,"
            + Sec1Entry.ROW_GPS_ACC + " TEXT);";
    /*******************************
     * Section 2
     ******************************/

    public static final String SQL_CREATE_BASELINE_SEC2 = "CREATE TABLE IF NOT EXISTS " + Section2Entry.TABLE_NAME + "("
            + Section2Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Section2Entry.ROW_DEVID + " TEXT,"
            + Section2Entry.ROW_S2CLUSTER + " TEXT,"
            + Section2Entry.ROW_S2LHW + " TEXT,"
            + Section2Entry.ROW_S2HH + " TEXT,"
            + Section2Entry.ROW_S2Q1 + " TEXT,"
            + Section2Entry.ROW_SNO + " TEXT,"
            + Section2Entry.ROW_S2Q15a + " TEXT,"
            + Section2Entry.ROW_S2Q15i + " INTEGER,"
            + Section2Entry.ROW_S2Q15b + " INTEGER,"
            + Section2Entry.ROW_S2Q15both + " TEXT,"
            + Section2Entry.ROW_S2Q15cf + " TEXT,"
            + Section2Entry.ROW_S2Q15cm + " TEXT,"
            + Section2Entry.ROW_S2Q15d + " INTEGER,"
            + Section2Entry.ROW_S2Q15e1 + " INTEGER,"
            + Section2Entry.ROW_S2Q15e + " DATETIME,"
            + Section2Entry.ROW_S2Q15fy + " INTEGER,"
            + Section2Entry.ROW_S2Q15fm + " INTEGER,"
            + Section2Entry.ROW_fm + " INTEGER,"
            + Section2Entry.ROW_fy + " INTEGER,"
            + Section2Entry.ROW_S2Q15g + " INTEGER,"
            + Section2Entry.ROW_S2Q15goth + " TEXT,"
            + Section2Entry.ROW_S2Q15h + " INTEGER,"
            + Section2Entry.ROW_S2Q15hoth + " TEXT,"
            + Section2Entry.ROW_S2Q15j + " INTEGER,"
            + Section2Entry.ROW_S2Q15joth + " TEXT,"
            + Section2Entry.ROW_S2Q15k + " INTEGER,"
            + Section2Entry.ROW_S2Q15l1 + " INTEGER,"
            + Section2Entry.ROW_S2Q15lmp + " DATETIME,"
            + Section2Entry.ROW_S2Q15gest + " INTEGER,"
            + Section2Entry.ROW_iselig + " INTEGER,"
            + Section2Entry.ROW_UUID + " TEXT,"
            + Section2Entry.ROW_GPS_LNG + " TEXT,"
            + Section2Entry.ROW_GPS_LAT + " TEXT,"
            + Section2Entry.ROW_GPS_DT + " TEXT,"
            + Section2Entry.COLUMN_SYNCED + " TEXT,"
            + Section2Entry.COLUMN_SYNC_DATE + " TEXT,"
            + Section2Entry.ROW_GPS_ACC + " TEXT);";
    /*******************************
     * Section 4
     ******************************/

    public static final String SQL_CREATE_BASELINE_SEC4 = "CREATE TABLE IF NOT EXISTS " + Section4Entry.TABLE_NAME + "("
            + Section4Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Section4Entry.ROW_DEVID + " TEXT,"
            + Section4Entry.ROW_S4CLUSTER + " TEXT,"
            + Section4Entry.ROW_S4LHW + " TEXT,"
            + Section4Entry.ROW_S4HH + " TEXT,"
            + Section4Entry.ROW_S4Q1 + " TEXT,"
            + Section4Entry.ROW_SNO + " TEXT,"
            + Section4Entry.ROW_S4Q28a + " TEXT,"
            + Section4Entry.ROW_S4Q28b + " INTEGER,"
            + Section4Entry.ROW_S4Q28c + " INTEGER,"
            + Section4Entry.ROW_S4Q28d + " INTEGER,"
            + Section4Entry.ROW_S4Q28oth + " TEXT,"
            + Section4Entry.ROW_S4Q28e + " INTEGER,"
            + Section4Entry.ROW_S4Q28f + " INTEGER,"
            + Section4Entry.ROW_S4Q28f1 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f2 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f3 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f4 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f5 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f6 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f7 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f8 + " INTEGER,"
            + Section4Entry.ROW_S4Q28f9 + " INTEGER,"
            + Section4Entry.ROW_S4Q28g + " INTEGER,"
            + Section4Entry.ROW_S4Q28h + " INTEGER,"
            + Section4Entry.ROW_UUID + " TEXT,"
            + Section4Entry.ROW_GPS_LNG + " TEXT,"
            + Section4Entry.ROW_GPS_LAT + " TEXT,"
            + Section4Entry.ROW_GPS_DT + " TEXT,"
            + Section4Entry.COLUMN_SYNCED + " TEXT,"
            + Section4Entry.COLUMN_SYNC_DATE + " TEXT,"
            + Section4Entry.ROW_GPS_ACC + " TEXT);";
    /*******************************
     * Get Health Facility / Cluster
     ******************************/


    public static final String SQL_CREATE_HF = "CREATE TABLE IF NOT EXISTS " + GetHFEntry.TABLE_NAME + "("
            + GetHFEntry.ROW_HFCODE + " INTEGER,"
            + GetHFEntry.ROW_HFNAME + " TEXT);";
    /*******************************
     * Get LHW
     ******************************/


    public static final String SQL_CREATE_LHW = "CREATE TABLE IF NOT EXISTS " + GetLHWEntry.TABLE_NAME + "("
            + GetLHWEntry.ROW_LHWID + " INTEGER,"
            + GetLHWEntry.ROW_LHWNAME + " TEXT,"
            + GetLHWEntry.ROW_CLUSTER + " TEXT,"
            + GetLHWEntry.ROW_HCODE + " INTEGER);";
    public static final String DATABASE_NAME = "mapps.db";
    public static final String DB_NAME = "mapps_copy.db";
    private static final String TAG = "Sec1";
    private static final int DATABASE_VERSION = 3;
    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + singleUser.TABLE_NAME;
    private static final String SQL_DELETE_SEC1 =
            "DROP TABLE IF EXISTS " + Sec1Entry.TABLE_NAME;
    private static final String SQL_DELETE_SEC2 =
            "DROP TABLE IF EXISTS " + Section2Entry.TABLE_NAME;
    private static final String SQL_DELETE_SEC4 =
            "DROP TABLE IF EXISTS " + Section4Entry.TABLE_NAME;


    public MAPPSHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_HF);
        db.execSQL(SQL_CREATE_LHW);
        db.execSQL(SQL_CREATE_BASELINE_SEC1);
        db.execSQL(SQL_CREATE_BASELINE_SEC2);
        db.execSQL(SQL_CREATE_BASELINE_SEC4);

        //db.execSQL("insert into Users (USERNAME, PASSWORD, USERSTATUS, ISADMIN) VALUES('admin', 'admin.123', '1', '1')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        //db.execSQL(SQL_DELETE_SEC1);
        //db.execSQL(SQL_DELETE_SEC2);
        //db.execSQL(SQL_DELETE_SEC4);

        if (i < i1) {


            //////////////////       SECTION 2     /////////////////


            if (isColumnExists(db, Section2Entry.TABLE_NAME, Section2Entry.ROW_S2CLUSTER) == false) {
                db.execSQL("ALTER TABLE " + Section2Entry.TABLE_NAME + " ADD COLUMN " + Section2Entry.ROW_S2CLUSTER + " TEXT ");
            }

            if (isColumnExists(db, Section2Entry.TABLE_NAME, Section2Entry.ROW_S2LHW) == false) {
                db.execSQL("ALTER TABLE " + Section2Entry.TABLE_NAME + " ADD COLUMN " + Section2Entry.ROW_S2LHW + " TEXT ");
            }

            if (isColumnExists(db, Section2Entry.TABLE_NAME, Section2Entry.ROW_S2HH) == false) {
                db.execSQL("ALTER TABLE " + Section2Entry.TABLE_NAME + " ADD COLUMN " + Section2Entry.ROW_S2HH + " TEXT ");
            }


            //////////////////       SECTION 4     /////////////////


            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4CLUSTER) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4CLUSTER + " TEXT ");
            }


            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4LHW) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4LHW + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4HH) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4HH + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f1) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f1 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f2) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f2 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f3) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f3 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f4) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f4 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f5) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f5 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f6) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f6 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f7) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f7 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f8) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f8 + " TEXT ");
            }

            if (isColumnExists(db, Section4Entry.TABLE_NAME, Section4Entry.ROW_S4Q28f9) == false) {
                db.execSQL("ALTER TABLE " + Section4Entry.TABLE_NAME + " ADD COLUMN " + Section4Entry.ROW_S4Q28f9 + " TEXT ");
            }
        }

        onCreate(db);
    }


    public boolean isColumnExists(SQLiteDatabase db, String table, String column) {
        Cursor cursor = db.rawQuery("PRAGMA table_info(" + table + ")", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                if (column.equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }


    public void addUser(UsersContract userscontract) {
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(singleUser.ROW_USERNAME, userscontract.getUserName());
            values.put(singleUser.ROW_PASSWORD, userscontract.getPassword());
            values.put(singleUser.ROW_USERSTATUS, userscontract.getUserStatus());
            values.put(singleUser.ROW_ISADMIN, userscontract.getIsAdmin());

            db.insert(singleUser.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
        }
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");
                String userstatus = jsonObjectUser.getString("userstatus");
                String isadmin = jsonObjectUser.getString("isadmin");

                ContentValues values = new ContentValues();

                values.put(singleUser.ROW_USERNAME, userName);
                values.put(singleUser.ROW_PASSWORD, password);
                values.put(singleUser.ROW_USERSTATUS, userstatus);
                values.put(singleUser.ROW_ISADMIN, isadmin);

                db.insert(singleUser.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }


    public void syncHF(JSONArray test) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(GetHFContract.GetHFEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = test;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String hfcode = jsonObjectUser.getString("hfcode");
                String hfname = jsonObjectUser.getString("hfname");

                ContentValues values = new ContentValues();

                values.put(GetHFEntry.ROW_HFCODE, hfcode);
                values.put(GetHFEntry.ROW_HFNAME, hfname);

                db.insert(GetHFEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }


    public void syncLHW(JSONArray test) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(GetLHWContract.GetLHWEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = test;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String lhwid = jsonObjectUser.getString("lhwid");
                String lhwname = jsonObjectUser.getString("lhwname");
                String cluster = jsonObjectUser.getString("cluster");
                String hcode = jsonObjectUser.getString("hcode");

                ContentValues values = new ContentValues();

                values.put(GetLHWEntry.ROW_LHWID, lhwid);
                values.put(GetLHWEntry.ROW_LHWNAME, lhwname);
                values.put(GetLHWEntry.ROW_CLUSTER, cluster);
                values.put(GetLHWEntry.ROW_HCODE, hcode);

                db.insert(GetLHWEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }


    public ArrayList<UsersContract> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        //db.delete(UsersContract.singleUser.TABLE_NAME, null, null);

        ArrayList<UsersContract> userList = null;
        try {
            userList = new ArrayList<UsersContract>();
            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    user.setUserStatus(cursor.getString(3));
                    user.setIsAdmin(cursor.getString(4));

                    userList.add(user);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<GetHFContract> getAllHF() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<GetHFContract> userList = null;
        try {
            userList = new ArrayList<GetHFContract>();
            String QUERY = "SELECT * FROM " + GetHFEntry.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    GetHFContract hf = new GetHFContract();

                    hf.setROW_HFCODE(cursor.getString(0));
                    hf.setROW_HFNAME(cursor.getString(1));

                    userList.add(hf);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }

    public ArrayList<String> getAllHF_String() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> userList = null;
        try {
            userList = new ArrayList<String>();
            String QUERY = "SELECT * FROM " + GetHFEntry.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    userList.add(cursor.getString(1));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Members> getAllHF1() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {
            userList = new ArrayList<Members>();
            String QUERY = "SELECT * FROM " + GetHFEntry.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    GetHFContract hf = new GetHFContract();

                    hf.setROW_HFCODE(cursor.getString(0));
                    hf.setROW_HFNAME(cursor.getString(1));

                    userList.add(new Members(hf.getROW_HFCODE(), hf.getROW_HFNAME()));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Members> getAllLHW(String cluster) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {
            userList = new ArrayList<Members>();
            String QUERY = "SELECT * FROM " + GetLHWEntry.TABLE_NAME + " WHERE "
                    + GetLHWEntry.ROW_CLUSTER + " = '" + cluster + "'";
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    GetLHWContract hf = new GetLHWContract();

                    hf.setROW_LHWID(cursor.getString(0));
                    hf.setROW_LHWNAME(cursor.getString(1));

                    userList.add(new Members(hf.getROW_LHWID(), hf.getROW_LHWNAME()));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public String getHFCode(String cluster) {
        SQLiteDatabase db = this.getReadableDatabase();
        String hfcode = "";
        try {
            String QUERY = "SELECT * FROM " + GetHFEntry.TABLE_NAME + " WHERE "
                    + GetHFEntry.ROW_HFNAME + " = '" + cluster + "'";
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    hfcode = cursor.getString(0);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return hfcode;
    }


    public String getLHWCode(String lhwname) {
        SQLiteDatabase db = this.getReadableDatabase();
        String hfcode = "";
        try {
            String QUERY = "SELECT * FROM " + GetLHWEntry.TABLE_NAME + " WHERE "
                    + GetLHWEntry.ROW_LHWNAME + " = '" + lhwname + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    hfcode = cursor.getString(0);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return hfcode;
    }


    public String getLHWCode(String lhwname, String cluster) {
        SQLiteDatabase db = this.getReadableDatabase();
        String hfcode = "";
        try {
            String QUERY = "SELECT * FROM " + GetLHWEntry.TABLE_NAME + " WHERE "
                    + GetLHWEntry.ROW_LHWNAME + " = '" + lhwname + "' AND "
                    + GetLHWEntry.ROW_CLUSTER + " = '" + cluster + "'";
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    hfcode = cursor.getString(0);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return hfcode;
    }


    public ArrayList<Members> getAllLHW() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {
            userList = new ArrayList<Members>();
            String QUERY = "SELECT * FROM " + GetLHWEntry.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    GetLHWContract lhwlist = new GetLHWContract();

                    lhwlist.setROW_LHWID(cursor.getString(0));
                    lhwlist.setROW_LHWNAME(cursor.getString(1));

                    userList.add(new Members(lhwlist.getROW_LHWID(), lhwlist.getROW_LHWNAME()));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Members> getAll_Male_Members() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE " + Section2Entry.ROW_fy + " > 10 " +
                    " and " + Section2Entry.ROW_S2Q15i + " = 1 " +
                    " and " + Section2Entry.ROW_S2Q15j + " <> 1 " +
                    " and " + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {

                    Members m = new Members();

                    Section2Contract sc = new Section2Contract();
                    sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID)));
                    sc.setROW_S2Q15a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));

                    if (userList.size() <= 0) {
                        userList.add(new Members("99", "NA"));
                    }

                    userList.add(new Members(String.valueOf(sc.get_ID()), sc.getROW_S2Q15a()));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Members> getAll_Female_Members() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE " + Section2Entry.ROW_fy + " > 10 " +
                    " and " + Section2Entry.ROW_S2Q15i + " = 2 " +
                    " and " + Section2Entry.ROW_S2Q15j + " <> 1 " +
                    " and " + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {

                    Members m = new Members();

                    Section2Contract sc = new Section2Contract();
                    sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID)));
                    sc.setROW_S2Q15a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));

                    if (userList.size() <= 0) {
                        userList.add(new Members("99", "NA"));
                    }

                    userList.add(new Members(String.valueOf(sc.get_ID()), sc.getROW_S2Q15a()));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Members> getAll_Female_Members14_24() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + ""
                    + " WHERE (" + Section2Entry.ROW_S2Q15i + " = 2 "
                    + " and " + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'"
                    + " and " + Section2Entry.ROW_fy + " >= 13 and " + Section2Entry.ROW_fy + " <= 23) "
                    + " or (" + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'"
                    + " and " + Section2Entry.ROW_S2Q15i + " = 2 "
                    + " and " + Section2Entry.ROW_fy + " >= 13 and " + Section2Entry.ROW_fy + " <= 23) ";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {

                while (cursor.moveToNext()) {

                    Section4Contract sc4 = new Section4Contract();

                    sc4.setROW_S4Q28a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));
                    sc4.setROW_S4Q28b(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_SNO)));

                    userList.add(new Members(String.valueOf(sc4.getROW_S4Q28a()), sc4.getROW_S4Q28b()));
                }
            }
            db.close();
        } catch (Exception e) {
        }

        return userList;
    }


    public ArrayList<Members> IsWomanExists_14_24() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + ""
                    + " WHERE " + Section2Entry.ROW_S2Q15i + " = 2 "
                    + " and " + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'"
                    + " and " + Section2Entry.ROW_S2Q15fy + " > 14 "
                    + " and " + Section2Entry.ROW_S2Q15fy + " < 24 ";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {

                while (cursor.moveToNext()) {

                    Members m = null;

                    Section4Contract sc4 = new Section4Contract();

                    sc4.setROW_S4Q28a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));
                    sc4.setROW_S4Q28b(cursor.getString(cursor.getColumnIndex(Section2Entry._ID)));

                    userList.add(new Members(String.valueOf(sc4.getROW_S4Q28a()), sc4.getROW_S4Q28b()));
                }
            }
            db.close();
        } catch (Exception e) {
        }

        return userList;
    }


    public boolean IsHouseHoldExists_Cluster(String cluster, String lhwid, String hhno) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean IsExists = false;

        try {
            String QUERY = "SELECT * FROM " + Sec1Entry.TABLE_NAME + " WHERE "
                    + Sec1Entry.ROW_S1Q1 + " = '" + cluster + "' and "
                    + Sec1Entry.ROW_S1Q2 + " = '" + lhwid + "' and "
                    + Sec1Entry.ROW_S1Q5 + " = '" + hhno + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (num > 0) {

                IsExists = true;

                /*if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q14)) == "1") {
                    IsExists = true;
                }*/
            }

            db.close();
        } catch (Exception e) {
        }
        return IsExists;
    }


    public int IsMemberExists_HouseHold(String hhno) {
        SQLiteDatabase db = this.getReadableDatabase();
        int var = 0;

        try {
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE "
                    + Section2Entry.ROW_S2Q1 + " = '" + hhno + "'"
                    + " and " + Section2Entry.ROW_S2Q15i + " = 2 ";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (num > 0) {
                var = num;
            }

            db.close();
        } catch (Exception e) {
        }

        return var;
    }


    public boolean IsMemberExists_HouseHold(String hhno, String member) {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean IsExists = false;

        try {
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE "
                    + Section2Entry.ROW_S2Q1 + " = '" + hhno + "' and "
                    + Section2Entry.ROW_S2Q15a + " = '" + member + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (num > 0) {
                IsExists = true;
            }

            db.close();
        } catch (Exception e) {
        }
        return IsExists;
    }


    public ArrayList<Members> getAllMembers_GetID(String nme) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE "
                    + Section2Entry.ROW_S2Q15a + " = '" + nme + "'"
                    + " and " + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {

                    Members m = new Members();

                    Section2Contract sc = new Section2Contract();
                    //sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID)));

                    sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry.ROW_SNO)));
                    sc.setROW_S2Q15a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));

                    if (userList.size() <= 0) {
                        userList.add(new Members("0", String.valueOf("")));
                    }

                    userList.add(new Members(String.valueOf(sc.get_ID()), String.valueOf(sc.get_ID())));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Members> getAllMembers_GetHouseHold() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE "
                    + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {

                    Members m = new Members();

                    Section2Contract sc = new Section2Contract();
                    sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID)));
                    sc.setROW_S2Q15a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));

                    userList.add(new Members(String.valueOf(sc.get_ID()), String.valueOf(sc.get_ID())));
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }


    public int getSNO() {
        SQLiteDatabase db = this.getReadableDatabase();
        int sno = 0;
        try {

            CVars var = new CVars();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE "
                    + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            sno = cursor.getCount();
            db.close();
        } catch (Exception e) {
        }
        return sno;
    }


    public String getSNO1(String nme) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sno = "0";
        try {

            CVars var = new CVars();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE "
                    + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'"
                    + " and " + Section2Entry.ROW_S2Q15a + " = '" + nme + "'";

            Cursor cursor = db.rawQuery(QUERY, null);

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    sno = cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_SNO));
                }
            }

            db.close();
        } catch (Exception e) {
        }
        return sno;
    }


    /*



    public ArrayList<Members> getAllMembers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> userList = null;
        try {

            CVars var = new CVars();

            userList = new ArrayList<Members>();
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE " + Section2Entry.ROW_S2Q15fy + " > 15 " +
                    " and " + Section2Entry.ROW_S2Q15i + " = 1 " +
                    " and " + Section2Entry.ROW_S2Q15j + " = 2 " +
                    " and " + Section2Entry.ROW_S2Q1 + " = '" + var.Gethhno() + "'";

            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();

            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    //Section2Contract sc = new Section2Contract();

                    ArrayList<String> members = new ArrayList<>();

                    userList.add(new Members(String.valueOf(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID))), cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a))));

                    //sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID)));
                    //sc.setROW_S2Q15a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));

                    return userList;
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }




     */


    public ArrayList<String> getAllUsersArray() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> userList = null;
        try {
            userList = new ArrayList<String>();
            String QUERY = "SELECT * FROM " + singleUser.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext())
                    userList.add(cursor.getString(1));

                db.close();
            }
        } catch (Exception e) {
        }
        return userList;
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"mesage"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);


        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);


            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {


                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        boolean isexists = false;
        String isadmin = "";
        String status = "";

        CVars var = new CVars();

        MAPPSApp.user = new String[2];

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersContract.singleUser.TABLE_NAME + " WHERE " +
                UsersContract.singleUser.ROW_USERNAME + "=? AND " +
                UsersContract.singleUser.ROW_PASSWORD + "=? AND " +
                UsersContract.singleUser.ROW_USERSTATUS + "=?", new String[]{username, password, "1"}, null);

        if (mCursor.getCount() < 0) {
            isexists = false;

        } else {

            if (mCursor.moveToFirst()) {

                MAPPSApp.user[0] = mCursor.getString(0);
                MAPPSApp.user[1] = mCursor.getString(1);

                status = mCursor.getString(3);
                isadmin = mCursor.getString(4);
                var.set_isadmin(isadmin);


                isexists = status.equals("1");
            }
        }

        db.close();

        return isexists;
    }


    public boolean Login1(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + singleUser.TABLE_NAME + " WHERE " + singleUser.ROW_USERNAME + "=? AND " + singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
            db.close();
        }
        return false;
    }

    /*****************************
     * Section 1
     ***************************/

    public Long InsertRecord(FormContract fc) {
        long newRowId = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(Sec1Entry.ROW_DEVID, fc.getROW_DEVID());
            values.put(Sec1Entry.ROW_FORM_ID, fc.getROW_FORM_ID());
            values.put(Sec1Entry.ROW_S1Q1, fc.getROW_S1Q1());
            values.put(Sec1Entry.ROW_S1Q2, fc.getROW_S1Q2());
            values.put(Sec1Entry.ROW_S1Q3, fc.getROW_S1Q3());
            values.put(Sec1Entry.ROW_S1Q4, fc.getROW_S1Q4());
            values.put(Sec1Entry.ROW_S1Q5, fc.getROW_S1Q5());
            values.put(Sec1Entry.ROW_S1Q6, fc.getROW_S1Q6());
            values.put(Sec1Entry.ROW_S1Q7, fc.getROW_S1Q7());
            values.put(Sec1Entry.ROW_S1Q8, fc.getROW_S1Q8());
            values.put(Sec1Entry.ROW_S1Q9a, fc.getROW_S1Q9a());
            values.put(Sec1Entry.ROW_S1Q9b, fc.getROW_S1Q9b());
            values.put(Sec1Entry.ROW_S1Q10, fc.getROW_S1Q10());
            values.put(Sec1Entry.ROW_S1Q11, fc.getROW_S1Q11());
            values.put(Sec1Entry.ROW_S1Q12, fc.getROW_S1Q12());
            values.put(Sec1Entry.ROW_S1Q13, fc.getROW_S1Q13());
            values.put(Sec1Entry.ROW_S1Q14, fc.getROW_S1Q14());
            values.put(Sec1Entry.ROW_S4, fc.getROW_member_count());
            values.put(Sec1Entry.ROW_S5, fc.getROW_screened_count());
            values.put(Sec1Entry.ROW_USERID, fc.getROW_USERID());
            values.put(Sec1Entry.ROW_ENTRYDATE, fc.getROW_ENTRYDATE());
            values.put(Sec1Entry.ROW_UUID, fc.getROW_UID());
            values.put(Sec1Entry.ROW_GPS_LAT, fc.getROW_GPS_LAT());
            values.put(Sec1Entry.ROW_GPS_LNG, fc.getROW_GPS_LANG());
            values.put(Sec1Entry.ROW_GPS_ACC, fc.getROW_GPS_ACC());
            values.put(Sec1Entry.ROW_GPS_DT, fc.getROW_GPS_DT());

            newRowId = db.insert(Sec1Entry.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
        }
        db.close();

        return newRowId;
    }


    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(Sec1Entry.ROW_UUID, MAPPSApp.fc.getROW_UID());

// Which row to update, based on the ID
        String selection = Sec1Entry._ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(MAPPSApp.fc.get_ID())};

        int count = db.update(Sec1Entry.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    /*****************************
     * Section 2
     ***************************/

    public Long InsertRecord_Sec2(Section2Contract sc) {
        long newRowId = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(Section2Entry.ROW_DEVID, sc.getROW_DEVID());
            values.put(Section2Entry.ROW_S2CLUSTER, sc.getROW_S2CLUSTER());
            values.put(Section2Entry.ROW_S2LHW, sc.getROW_S2LHW());
            values.put(Section2Entry.ROW_S2HH, sc.getROW_S2HH());

            CVars var = new CVars();

            values.put(Section2Entry.ROW_S2Q1, var.Gethhno());
            values.put(Section2Entry.ROW_SNO, sc.getROW_SNO());

            values.put(Section2Entry.ROW_S2Q15a, sc.getROW_S2Q15a());
            values.put(Section2Entry.ROW_S2Q15i, sc.getROW_S2Q15i());
            values.put(Section2Entry.ROW_S2Q15b, sc.getROW_S2Q15b());
            values.put(Section2Entry.ROW_S2Q15both, sc.getROW_S2Q15both());
            values.put(Section2Entry.ROW_S2Q15cf, sc.getROW_S2Q15cf());
            values.put(Section2Entry.ROW_S2Q15cm, sc.getROW_S2Q15cm());
            values.put(Section2Entry.ROW_S2Q15d, sc.getROW_S2Q15d());
            values.put(Section2Entry.ROW_S2Q15e1, sc.getROW_S2Q15e1());
            values.put(Section2Entry.ROW_S2Q15e, sc.getROW_S2Q15e());
            values.put(Section2Entry.ROW_S2Q15fy, sc.getROW_S2Q15fy());
            values.put(Section2Entry.ROW_S2Q15fm, sc.getROW_S2Q15fm());
            values.put(Section2Entry.ROW_fy, sc.getROW_fy());
            values.put(Section2Entry.ROW_fm, sc.getROW_fm());
            values.put(Section2Entry.ROW_S2Q15g, sc.getROW_S2Q15g());
            values.put(Section2Entry.ROW_S2Q15goth, sc.getROW_S2Q15goth());
            values.put(Section2Entry.ROW_S2Q15h, sc.getROW_S2Q15h());
            values.put(Section2Entry.ROW_S2Q15hoth, sc.getROW_S2Q15hoth());
            values.put(Section2Entry.ROW_S2Q15j, sc.getROW_S2Q15j());
            values.put(Section2Entry.ROW_S2Q15joth, sc.getROW_S2Q15joth());
            values.put(Section2Entry.ROW_S2Q15k, sc.getROW_S2Q15k());
            values.put(Section2Entry.ROW_S2Q15l1, sc.getROW_S2Q15l1());
            values.put(Section2Entry.ROW_S2Q15lmp, sc.getROW_S2Q15lmp());
            values.put(Section2Entry.ROW_S2Q15gest, sc.getROW_S2Q15gest());
            values.put(Section2Entry.ROW_iselig, sc.getROW_iselig());
            values.put(Section2Entry.ROW_UUID, MAPPSApp.fc.getROW_UID());
            values.put(Section2Entry.ROW_GPS_LAT, sc.getROW_GPS_LAT());
            values.put(Section2Entry.ROW_GPS_LNG, sc.getROW_GPS_LANG());
            values.put(Section2Entry.ROW_GPS_ACC, sc.getROW_GPS_ACC());
            values.put(Section2Entry.ROW_GPS_DT, sc.getROW_GPS_DT());

            newRowId = db.insert(Section2Entry.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
        }

        return newRowId;
    }


    /*****************************
     * Section 4
     ***************************/

    public Long InsertRecord_Sec4(Section4Contract sc) {
        long newRowId = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put(Section4Entry.ROW_DEVID, sc.getROW_DEVID());

            values.put(Section4Entry.ROW_S4CLUSTER, sc.getROW_S4CLUSTER());
            values.put(Section4Entry.ROW_S4LHW, sc.getROW_S4LHW());
            values.put(Section4Entry.ROW_S4HH, sc.getROW_S4HH());

            CVars var = new CVars();

            values.put(Section4Entry.ROW_S4Q1, var.Gethhno());
            values.put(Section4Entry.ROW_SNO, sc.getROW_SNO());

            values.put(Section4Entry.ROW_S4Q28a, sc.getROW_S4Q28a());
            values.put(Section4Entry.ROW_S4Q28b, sc.getROW_S4Q28b());
            values.put(Section4Entry.ROW_S4Q28c, sc.getROW_S4Q28c());
            values.put(Section4Entry.ROW_S4Q28d, sc.getROW_S4Q28d());
            values.put(Section4Entry.ROW_S4Q28oth, sc.getROW_S4Q28oth());
            values.put(Section4Entry.ROW_S4Q28e, sc.getROW_S4Q28e());
            values.put(Section4Entry.ROW_S4Q28f, sc.getROW_S4Q28f());
            values.put(Section4Entry.ROW_S4Q28f1, sc.getROW_S4Q28f1());
            values.put(Section4Entry.ROW_S4Q28f2, sc.getROW_S4Q28f2());
            values.put(Section4Entry.ROW_S4Q28f3, sc.getROW_S4Q28f3());
            values.put(Section4Entry.ROW_S4Q28f4, sc.getROW_S4Q28f4());
            values.put(Section4Entry.ROW_S4Q28f5, sc.getROW_S4Q28f5());
            values.put(Section4Entry.ROW_S4Q28f6, sc.getROW_S4Q28f6());
            values.put(Section4Entry.ROW_S4Q28f7, sc.getROW_S4Q28f7());
            values.put(Section4Entry.ROW_S4Q28f8, sc.getROW_S4Q28f8());
            values.put(Section4Entry.ROW_S4Q28f9, sc.getROW_S4Q28f9());
            values.put(Section4Entry.ROW_S4Q28g, sc.getROW_S4Q28g());
            values.put(Section4Entry.ROW_S4Q28h, sc.getROW_S4Q28h());

            //values.put(Section4Entry.ROW_UUID, sc.getROW_UID());
            values.put(Section4Entry.ROW_UUID, MAPPSApp.fc.getROW_UID());

            values.put(Section4Entry.ROW_GPS_LAT, sc.getROW_GPS_LAT());
            values.put(Section4Entry.ROW_GPS_LNG, sc.getROW_GPS_LANG());
            values.put(Section4Entry.ROW_GPS_ACC, sc.getROW_GPS_ACC());
            values.put(Section4Entry.ROW_GPS_DT, sc.getROW_GPS_DT());

            newRowId = db.insert(Section4Entry.TABLE_NAME, null, values);
            db.close();

        } catch (Exception e) {
        }

        return newRowId;
    }


    public int updateSA() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(Sec1Entry.ROW_S1Q14, MAPPSApp.fc.getROW_S1Q14());
        values.put(Sec1Entry.ROW_S5, MAPPSApp.fc.getROW_screened_count());

// Which row to update, based on the ID
        String selection = " _ID = " + MAPPSApp.fc.get_ID();
        String[] selectionArgs = {String.valueOf(MAPPSApp.fc.get_ID())};

        int count = db.update(Sec1Entry.TABLE_NAME,
                values,
                selection,
                null);
        return count;
    }


    public int updateSB() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(Sec1Entry.ROW_S3, MAPPSApp.fc.getROW_S3());

// Which row to update, based on the ID
        String selection = " _ID = " + MAPPSApp.fc.get_ID();

        String[] selectionArgs = {String.valueOf(MAPPSApp.fc.get_ID())};


        int count = db.update(Sec1Entry.TABLE_NAME,
                values,
                selection,
                null);
        return count;


    }


    public List<FormContract> getAllForms() {

        MAPPSApp.fc = new FormContract();

        List<FormContract> formList = new ArrayList<FormContract>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + Sec1Entry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                FormContract fc = new FormContract();

                fc.set_ID(cursor.getLong(cursor.getColumnIndex(Sec1Entry._ID)));
                fc.setROW_DEVID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_DEVID)));
                fc.setROW_S1Q1(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q1)));
                fc.setROW_S1Q2(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q2)));
                fc.setROW_S1Q3(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q3)));
                fc.setROW_S1Q4(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q4)));
                fc.setROW_S1Q5(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q5)));
                fc.setROW_S1Q6(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q6)));
                fc.setROW_S1Q7(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q7)));
                fc.setROW_S1Q8(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q8)));
                fc.setROW_S1Q9a(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q9a)));
                fc.setROW_S1Q9b(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q9b)));
                fc.setROW_S1Q10(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q10)));
                fc.setROW_S1Q11(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q11)));


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q12)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q12)) == null) {
                    fc.setROW_S1Q12("");
                } else {
                    fc.setROW_S1Q12(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q12)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q13)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q13)) == null) {
                    fc.setROW_S1Q13("");
                } else {
                    fc.setROW_S1Q13(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q13)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q14)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q14)) == null) {
                    fc.setROW_S1Q14("");
                } else {
                    fc.setROW_S1Q14(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q14)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S4)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S4)) == null) {
                    fc.setROW_member_count("");
                } else {
                    fc.setROW_member_count(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S4)));
                }

                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S5)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S5)) == null) {
                    fc.setROW_screened_count("");
                } else {
                    fc.setROW_screened_count(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S5)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_USERID)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_USERID)) == null) {
                    fc.setROW_USERID("");
                } else {
                    fc.setROW_USERID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_USERID)));
                }


                fc.setROW_ENTRYDATE(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_ENTRYDATE)));

                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S3)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S3)) == null) {
                    fc.setROW_S3("");
                } else {
                    fc.setROW_S3(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S3)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_UUID)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_UUID)) == null) {
                    fc.setROW_UID("");
                } else {
                    fc.setROW_UID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_UUID)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LNG)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LNG)) == null) {
                    fc.setROW_GPS_LANG("0");
                } else {
                    fc.setROW_GPS_LANG(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LNG)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LAT)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LAT)) == null) {
                    fc.setROW_GPS_LAT("0");
                } else {
                    fc.setROW_GPS_LAT(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LAT)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_DT)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_DT)) == null) {
                    fc.setROW_GPS_DT("0");
                } else {
                    fc.setROW_GPS_DT(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_DT)));
                }


                if (cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_ACC)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_ACC)) == null) {
                    fc.setROW_GPS_ACC("0");
                } else {
                    fc.setROW_GPS_ACC(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_ACC)));
                }


                /*MAPPSApp.fc.setROW_DEVID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_DEVID)));
                MAPPSApp.fc.setROW_S1Q1(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q1)));
                MAPPSApp.fc.setROW_S1Q2(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q2)));
                MAPPSApp.fc.setROW_S1Q3(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q3)));
                MAPPSApp.fc.setROW_S1Q4(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q4)));
                MAPPSApp.fc.setROW_S1Q5(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q5)));
                MAPPSApp.fc.setROW_S1Q6(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q6)));
                MAPPSApp.fc.setROW_S1Q7(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q7)));
                MAPPSApp.fc.setROW_S1Q8(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q8)));
                MAPPSApp.fc.setROW_S1Q9a(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q9a)));
                MAPPSApp.fc.setROW_S1Q9b(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q9b)));
                MAPPSApp.fc.setROW_S1Q10(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q10)));
                MAPPSApp.fc.setROW_S1Q11(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q11)));
                MAPPSApp.fc.setROW_S1Q12(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q12)));
                MAPPSApp.fc.setROW_S1Q13(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q13)));
                MAPPSApp.fc.setROW_S1Q14(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_S1Q14)));
                MAPPSApp.fc.setROW_USERID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_USERID)));
                MAPPSApp.fc.setROW_ENTRYDATE(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_ENTRYDATE)));*/


                /*MAPPSApp.fc.setROW_FORM_ID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_FORM_ID)));
                MAPPSApp.fc.set_ID(Long.parseLong(cursor.getString(cursor.getColumnIndex(Sec1Entry._ID))));

                MAPPSApp.fc.setROW_DEVID(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_DEVID)));
                MAPPSApp.fc.setROW_GPS_LAT(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LAT)));
                MAPPSApp.fc.setROW_GPS_LANG(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_LNG)));
                MAPPSApp.fc.setROW_GPS_ACC(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_ACC)));
                MAPPSApp.fc.setROW_GPS_DT(cursor.getString(cursor.getColumnIndex(Sec1Entry.ROW_GPS_DT)));
                */

                // Adding contact to list
                formList.add(fc);
            } while (cursor.moveToNext());

        }

        // return contact list
        return formList;
    }

    public Collection<FormContract> getAllFormsNew() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Sec1Entry._ID,
                Sec1Entry.ROW_DEVID,
                Sec1Entry.ROW_FORM_ID,
                Sec1Entry.ROW_S1Q1,
                Sec1Entry.ROW_S1Q2,
                Sec1Entry.ROW_S1Q3,
                Sec1Entry.ROW_S1Q4,
                Sec1Entry.ROW_S1Q5,
                Sec1Entry.ROW_S1Q6,
                Sec1Entry.ROW_S1Q7,
                Sec1Entry.ROW_S1Q8,
                Sec1Entry.ROW_S1Q9a,
                Sec1Entry.ROW_S1Q9b,
                Sec1Entry.ROW_S1Q10,
                Sec1Entry.ROW_S1Q11,
                Sec1Entry.ROW_S1Q12,
                Sec1Entry.ROW_S1Q13,
                Sec1Entry.ROW_S1Q14,
                Sec1Entry.ROW_USERID,
                Sec1Entry.ROW_ENTRYDATE,
                Sec1Entry.ROW_S3,
                Sec1Entry.ROW_S4,
                Sec1Entry.ROW_S5,
                Sec1Entry.ROW_UUID,
                Sec1Entry.ROW_GPS_LNG,
                Sec1Entry.ROW_GPS_LAT,
                Sec1Entry.ROW_GPS_DT,
                Sec1Entry.ROW_GPS_ACC

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Sec1Entry._ID + " ASC";

        Collection<FormContract> allFC = new ArrayList<FormContract>();
        try {
            c = db.query(
                    Sec1Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormContract fc = new FormContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<FormContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Sec1Entry._ID,
                Sec1Entry.ROW_DEVID,
                Sec1Entry.ROW_FORM_ID,
                Sec1Entry.ROW_S1Q1,
                Sec1Entry.ROW_S1Q2,
                Sec1Entry.ROW_S1Q3,
                Sec1Entry.ROW_S1Q4,
                Sec1Entry.ROW_S1Q5,
                Sec1Entry.ROW_S1Q6,
                Sec1Entry.ROW_S1Q7,
                Sec1Entry.ROW_S1Q8,
                Sec1Entry.ROW_S1Q9a,
                Sec1Entry.ROW_S1Q9b,
                Sec1Entry.ROW_S1Q10,
                Sec1Entry.ROW_S1Q11,
                Sec1Entry.ROW_S1Q12,
                Sec1Entry.ROW_S1Q13,
                Sec1Entry.ROW_S1Q14,
                Sec1Entry.ROW_USERID,
                Sec1Entry.ROW_ENTRYDATE,
                Sec1Entry.ROW_S3,
                Sec1Entry.ROW_S4,
                Sec1Entry.ROW_S5,
                Sec1Entry.ROW_UUID,
                Sec1Entry.ROW_GPS_LNG,
                Sec1Entry.ROW_GPS_LAT,
                Sec1Entry.ROW_GPS_DT,
                Sec1Entry.ROW_GPS_ACC

        };
        String whereClause = Sec1Entry.COLUMN_SYNCED + " is null OR " + Sec1Entry.COLUMN_SYNCED + " = ''";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Sec1Entry._ID + " ASC";

        Collection<FormContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    Sec1Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormContract fc = new FormContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public void updateForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(Sec1Entry.COLUMN_SYNCED, true);
        values.put(Sec1Entry.COLUMN_SYNC_DATE, new Date().toString());

// Which row to update, based on the title
        String where = Sec1Entry._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                Sec1Entry.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSection4(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(Section4Entry.COLUMN_SYNCED, true);
        values.put(Section4Entry.COLUMN_SYNC_DATE, new Date().toString());

// Which row to update, based on the title
        String where = Section4Entry._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                Section4Entry.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSection2(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(Section2Entry.COLUMN_SYNCED, true);
        values.put(Section2Entry.COLUMN_SYNC_DATE, new Date().toString());

// Which row to update, based on the title
        String where = Section2Entry._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                Section2Entry.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public List<Section2Contract> getAllForms_Sec2() {

        //MAPPSApp.sc = new Section2Contract();

        List<Section2Contract> formList = new ArrayList<Section2Contract>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + Section2Entry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Section2Contract sc = new Section2Contract();

                sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section2Entry._ID)));

                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_DEVID)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_DEVID)) == null) {
                    sc.setROW_DEVID("");
                } else {
                    sc.setROW_DEVID(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_DEVID)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2CLUSTER)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2CLUSTER)) == null) {
                    sc.setROW_S2CLUSTER("");
                } else {
                    sc.setROW_S2CLUSTER(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2CLUSTER)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2LHW)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2LHW)) == null) {
                    sc.setROW_S2LHW("");
                } else {
                    sc.setROW_S2LHW(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2LHW)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2HH)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2HH)) == null) {
                    sc.setROW_S2HH("");
                } else {
                    sc.setROW_S2HH(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2HH)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_SNO)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_SNO)) == null) {
                    sc.setROW_SNO("");
                } else {
                    sc.setROW_SNO(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_SNO)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q1)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q1)) == null) {
                    sc.setROW_S2Q1("");
                } else {
                    sc.setROW_S2Q1(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q1)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)) == null) {
                    sc.setROW_S2Q15a("");
                } else {
                    sc.setROW_S2Q15a(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15a)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15i)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15i)) == null) {
                    sc.setROW_S2Q15i("");
                } else {
                    sc.setROW_S2Q15i(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15i)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15b)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15b)) == null) {
                    sc.setROW_S2Q15b("");
                } else {
                    sc.setROW_S2Q15b(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15b)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cf)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cf)) == null) {
                    sc.setROW_S2Q15cf("");
                } else {
                    sc.setROW_S2Q15cf(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cf)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cm)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cm)) == null) {
                    sc.setROW_S2Q15cm("");
                } else {
                    sc.setROW_S2Q15cm(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15cm)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15d)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15d)) == null) {
                    sc.setROW_S2Q15d("");
                } else {
                    sc.setROW_S2Q15d(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15d)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e1)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e1)) == null) {
                    sc.setROW_S2Q15e1("");
                } else {
                    sc.setROW_S2Q15e1(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e1)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e)) == null) {
                    sc.setROW_S2Q15e("");
                } else {
                    sc.setROW_S2Q15e(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15e)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fy)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fy)) == null) {
                    sc.setROW_S2Q15fy("");
                } else {
                    sc.setROW_S2Q15fy(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fy)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fm)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fm)) == null) {
                    sc.setROW_S2Q15fm("");
                } else {
                    sc.setROW_S2Q15fm(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15fm)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fy)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fy)) == null) {
                    sc.setROW_fy("");
                } else {
                    sc.setROW_fy(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fy)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fm)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fm)) == null) {
                    sc.setROW_fm("");
                } else {
                    sc.setROW_fm(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_fm)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15g)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15g)) == null) {
                    sc.setROW_S2Q15g("");
                } else {
                    sc.setROW_S2Q15g(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15g)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15h)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15h)) == null) {
                    sc.setROW_S2Q15h("");
                } else {
                    sc.setROW_S2Q15h(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15h)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15j)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15j)) == null) {
                    sc.setROW_S2Q15j("");
                } else {
                    sc.setROW_S2Q15j(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15j)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15k)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15k)) == null) {
                    sc.setROW_S2Q15k("");
                } else {
                    sc.setROW_S2Q15k(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15k)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15l1)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15l1)) == null) {
                    sc.setROW_S2Q15l1("");
                } else {
                    sc.setROW_S2Q15l1(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15l1)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15lmp)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15lmp)) == null) {
                    sc.setROW_S2Q15lmp("");
                } else {
                    sc.setROW_S2Q15lmp(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15lmp)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15gest)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15gest)) == null) {
                    sc.setROW_S2Q15gest("");
                } else {
                    sc.setROW_S2Q15gest(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_S2Q15gest)));
                }


                sc.setROW_iselig(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_iselig)));


                if (cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_UUID)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_UUID)) == null) {
                    sc.setROW_UID("");
                } else {
                    sc.setROW_UID(cursor.getString(cursor.getColumnIndex(Section2Entry.ROW_UUID)));
                }


                // Adding contact to list
                formList.add(sc);
            } while (cursor.moveToNext());


        }

        // return contact list
        return formList;
    }


    public Collection<Section2Contract> getAllSection2New() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Section2Entry._ID,
                Section2Entry.ROW_DEVID,
                Section2Entry.ROW_S2CLUSTER,
                Section2Entry.ROW_S2LHW,
                Section2Entry.ROW_S2HH,
                Section2Entry.ROW_SNO,
                Section2Entry.ROW_S2Q1,
                Section2Entry.ROW_S2Q15a,
                Section2Entry.ROW_S2Q15i,
                Section2Entry.ROW_S2Q15b,
                Section2Entry.ROW_S2Q15both,
                Section2Entry.ROW_S2Q15cf,
                Section2Entry.ROW_S2Q15cm,
                Section2Entry.ROW_S2Q15d,
                Section2Entry.ROW_S2Q15e1,
                Section2Entry.ROW_S2Q15e,
                Section2Entry.ROW_S2Q15fy,
                Section2Entry.ROW_S2Q15fm,
                Section2Entry.ROW_fy,
                Section2Entry.ROW_fm,
                Section2Entry.ROW_S2Q15g,
                Section2Entry.ROW_S2Q15goth,
                Section2Entry.ROW_S2Q15h,
                Section2Entry.ROW_S2Q15hoth,
                Section2Entry.ROW_S2Q15j,
                Section2Entry.ROW_S2Q15joth,
                Section2Entry.ROW_S2Q15k,
                Section2Entry.ROW_S2Q15l1,
                Section2Entry.ROW_S2Q15lmp,
                Section2Entry.ROW_S2Q15gest,
                Section2Entry.ROW_iselig,
                Section2Entry.ROW_UUID,
                Section2Entry.ROW_GPS_LNG,
                Section2Entry.ROW_GPS_LAT,
                Section2Entry.ROW_GPS_DT,
                Section2Entry.ROW_GPS_ACC,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Section2Entry._ID + " ASC";

        Collection<Section2Contract> allSC2 = new ArrayList<Section2Contract>();
        try {
            c = db.query(
                    Section2Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Section2Contract sc2 = new Section2Contract();
                allSC2.add(sc2.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allSC2;
    }

    public Collection<Section2Contract> getUnsyncedSection2() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Section2Entry._ID,
                Section2Entry.ROW_DEVID,
                Section2Entry.ROW_S2CLUSTER,
                Section2Entry.ROW_S2LHW,
                Section2Entry.ROW_S2HH,
                Section2Entry.ROW_SNO,
                Section2Entry.ROW_S2Q1,
                Section2Entry.ROW_S2Q15a,
                Section2Entry.ROW_S2Q15i,
                Section2Entry.ROW_S2Q15b,
                Section2Entry.ROW_S2Q15both,
                Section2Entry.ROW_S2Q15cf,
                Section2Entry.ROW_S2Q15cm,
                Section2Entry.ROW_S2Q15d,
                Section2Entry.ROW_S2Q15e1,
                Section2Entry.ROW_S2Q15e,
                Section2Entry.ROW_S2Q15fy,
                Section2Entry.ROW_S2Q15fm,
                Section2Entry.ROW_fy,
                Section2Entry.ROW_fm,
                Section2Entry.ROW_S2Q15g,
                Section2Entry.ROW_S2Q15goth,
                Section2Entry.ROW_S2Q15h,
                Section2Entry.ROW_S2Q15hoth,
                Section2Entry.ROW_S2Q15j,
                Section2Entry.ROW_S2Q15joth,
                Section2Entry.ROW_S2Q15k,
                Section2Entry.ROW_S2Q15l1,
                Section2Entry.ROW_S2Q15lmp,
                Section2Entry.ROW_S2Q15gest,
                Section2Entry.ROW_iselig,
                Section2Entry.ROW_UUID,
                Section2Entry.ROW_GPS_LNG,
                Section2Entry.ROW_GPS_LAT,
                Section2Entry.ROW_GPS_DT,
                Section2Entry.ROW_GPS_ACC,

        };
        String whereClause = Section2Entry.COLUMN_SYNCED + " is null OR " + Section2Entry.COLUMN_SYNCED + " = ''";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Section2Entry._ID + " ASC";

        Collection<Section2Contract> allSC2 = new ArrayList<Section2Contract>();
        try {
            c = db.query(
                    Section2Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Section2Contract sc2 = new Section2Contract();
                allSC2.add(sc2.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allSC2;
    }


    public List<Section4Contract> getAllForms_Sec4() {

        //MAPPSApp.sc = new Section2Contract();

        List<Section4Contract> formList = new ArrayList<Section4Contract>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + Section4Entry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Section4Contract sc = new Section4Contract();

                sc.set_ID(cursor.getLong(cursor.getColumnIndex(Section4Entry._ID)));
                sc.setROW_DEVID(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_DEVID)));

                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4CLUSTER)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4CLUSTER)) == null) {
                    sc.setROW_S4CLUSTER("");
                } else {
                    sc.setROW_S4CLUSTER(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4CLUSTER)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4LHW)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4LHW)) == null) {
                    sc.setROW_S4LHW("");
                } else {
                    sc.setROW_S4LHW(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4LHW)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4HH)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4HH)) == null) {
                    sc.setROW_S4HH("");
                } else {
                    sc.setROW_S4HH(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4HH)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_SNO)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_SNO)) == null) {
                    sc.setROW_SNO("");
                } else {
                    sc.setROW_SNO(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_SNO)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q1)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q1)) == null) {
                    sc.setROW_S4Q1("");
                } else {
                    sc.setROW_S4Q1(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q1)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28a)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28a)) == null) {
                    sc.setROW_S4Q28a("");
                } else {
                    sc.setROW_S4Q28a(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28a)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28b)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28b)) == null) {
                    sc.setROW_S4Q28b("");
                } else {
                    sc.setROW_S4Q28b(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28b)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28c)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28c)) == null) {
                    sc.setROW_S4Q28c("");
                } else {
                    sc.setROW_S4Q28c(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28c)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28d)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28d)) == null) {
                    sc.setROW_S4Q28d("");
                } else {
                    sc.setROW_S4Q28d(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28d)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28oth)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28oth)) == null) {
                    sc.setROW_S4Q28oth("");
                } else {
                    sc.setROW_S4Q28oth(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28oth)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28e)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28e)) == null) {
                    sc.setROW_S4Q28e("");
                } else {
                    sc.setROW_S4Q28e(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28e)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f)) == null) {
                    sc.setROW_S4Q28f("");
                } else {
                    sc.setROW_S4Q28f(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f1)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f1)) == null) {
                    sc.setROW_S4Q28f1("");
                } else {
                    sc.setROW_S4Q28f1(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f1)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f2)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f2)) == null) {
                    sc.setROW_S4Q28f2("");
                } else {
                    sc.setROW_S4Q28f2(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f2)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f3)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f3)) == null) {
                    sc.setROW_S4Q28f3("");
                } else {
                    sc.setROW_S4Q28f3(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f3)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f4)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f4)) == null) {
                    sc.setROW_S4Q28f4("");
                } else {
                    sc.setROW_S4Q28f4(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f4)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f5)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f5)) == null) {
                    sc.setROW_S4Q28f5("");
                } else {
                    sc.setROW_S4Q28f5(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f5)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f6)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f6)) == null) {
                    sc.setROW_S4Q28f6("");
                } else {
                    sc.setROW_S4Q28f6(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f6)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f7)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f7)) == null) {
                    sc.setROW_S4Q28f7("");
                } else {
                    sc.setROW_S4Q28f7(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f7)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f8)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f8)) == null) {
                    sc.setROW_S4Q28f8("");
                } else {
                    sc.setROW_S4Q28f8(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f8)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f9)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f9)) == null) {
                    sc.setROW_S4Q28f9("");
                } else {
                    sc.setROW_S4Q28f9(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28f9)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28g)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28g)) == null) {
                    sc.setROW_S4Q28g("");
                } else {
                    sc.setROW_S4Q28g(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28g)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28h)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28h)) == null) {
                    sc.setROW_S4Q28h("");
                } else {
                    sc.setROW_S4Q28h(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_S4Q28h)));
                }


                if (cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_UUID)).equals("") ||
                        cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_UUID)) == null) {
                    sc.setROW_UID("");
                } else {
                    sc.setROW_UID(cursor.getString(cursor.getColumnIndex(Section4Entry.ROW_UUID)));
                }


                // Adding contact to list
                formList.add(sc);
            } while (cursor.moveToNext());

        }

        // return contact list
        return formList;
    }

    public Collection<Section4Contract> getAllSection4New() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Section4Entry._ID,
                Section4Entry.ROW_DEVID,
                Section4Entry.ROW_S4CLUSTER,
                Section4Entry.ROW_S4LHW,
                Section4Entry.ROW_S4HH,
                Section4Entry.ROW_S4Q1,
                Section4Entry.ROW_SNO,
                Section4Entry.ROW_S4Q28a,
                Section4Entry.ROW_S4Q28b,
                Section4Entry.ROW_S4Q28c,
                Section4Entry.ROW_S4Q28d,
                Section4Entry.ROW_S4Q28oth,
                Section4Entry.ROW_S4Q28e,
                Section4Entry.ROW_S4Q28f,
                Section4Entry.ROW_S4Q28f1,
                Section4Entry.ROW_S4Q28f2,
                Section4Entry.ROW_S4Q28f3,
                Section4Entry.ROW_S4Q28f4,
                Section4Entry.ROW_S4Q28f5,
                Section4Entry.ROW_S4Q28f6,
                Section4Entry.ROW_S4Q28f7,
                Section4Entry.ROW_S4Q28f8,
                Section4Entry.ROW_S4Q28f9,
                Section4Entry.ROW_S4Q28g,
                Section4Entry.ROW_S4Q28h,
                Section4Entry.ROW_UUID,
                Section4Entry.ROW_GPS_LNG,
                Section4Entry.ROW_GPS_LAT,
                Section4Entry.ROW_GPS_DT,
                Section4Entry.ROW_GPS_ACC


        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Section4Entry._ID + " ASC";

        Collection<Section4Contract> allSec4 = new ArrayList<Section4Contract>();
        try {
            c = db.query(
                    Section4Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Section4Contract fc = new Section4Contract();
                allSec4.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allSec4;
    }

    public Collection<Section4Contract> getUnsyncedSection4() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Section4Entry._ID,
                Section4Entry.ROW_DEVID,
                Section4Entry.ROW_S4CLUSTER,
                Section4Entry.ROW_S4LHW,
                Section4Entry.ROW_S4HH,
                Section4Entry.ROW_S4Q1,
                Section4Entry.ROW_SNO,
                Section4Entry.ROW_S4Q28a,
                Section4Entry.ROW_S4Q28b,
                Section4Entry.ROW_S4Q28c,
                Section4Entry.ROW_S4Q28d,
                Section4Entry.ROW_S4Q28oth,
                Section4Entry.ROW_S4Q28e,
                Section4Entry.ROW_S4Q28f,
                Section4Entry.ROW_S4Q28f1,
                Section4Entry.ROW_S4Q28f2,
                Section4Entry.ROW_S4Q28f3,
                Section4Entry.ROW_S4Q28f4,
                Section4Entry.ROW_S4Q28f5,
                Section4Entry.ROW_S4Q28f6,
                Section4Entry.ROW_S4Q28f7,
                Section4Entry.ROW_S4Q28f8,
                Section4Entry.ROW_S4Q28f9,
                Section4Entry.ROW_S4Q28g,
                Section4Entry.ROW_S4Q28h,
                Section4Entry.ROW_UUID,
                Section4Entry.ROW_GPS_LNG,
                Section4Entry.ROW_GPS_LAT,
                Section4Entry.ROW_GPS_DT,
                Section4Entry.ROW_GPS_ACC


        };
        String whereClause = Section4Entry.COLUMN_SYNCED + " is null OR " + Section4Entry.COLUMN_SYNCED + " = ''";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Section4Entry._ID + " ASC";

        Collection<Section4Contract> allSec4 = new ArrayList<Section4Contract>();
        try {
            c = db.query(
                    Section4Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Section4Contract fc = new Section4Contract();
                allSec4.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allSec4;
    }


    public Collection<FormContract> getAllForms_old() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                Sec1Entry.ROW_FORM_ID,
                Sec1Entry.ROW_S1Q1,
                Sec1Entry.ROW_S1Q2,
                Sec1Entry.ROW_S1Q3,
                Sec1Entry.ROW_S1Q4,
                Sec1Entry.ROW_S1Q5,
                Sec1Entry.ROW_S1Q6,
                Sec1Entry.ROW_S1Q7,
                Sec1Entry.ROW_S1Q8,
                Sec1Entry.ROW_S1Q9a,
                Sec1Entry.ROW_S1Q9b,
                Sec1Entry.ROW_S1Q10,
                Sec1Entry.ROW_S1Q11,
                Sec1Entry.ROW_S1Q12,
                Sec1Entry.ROW_S1Q13,
                Sec1Entry.ROW_S1Q14,
                Sec1Entry.ROW_S3,
                Sec1Entry.ROW_S4,
                Sec1Entry.ROW_S5,
                Sec1Entry.ROW_USERID,
                Sec1Entry.ROW_ENTRYDATE,
                Sec1Entry.ROW_GPS_LNG,
                Sec1Entry.ROW_GPS_LAT,
                Sec1Entry.ROW_GPS_DT,
                Sec1Entry.ROW_GPS_ACC
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                Sec1Entry._ID + " ASC";


        Collection<FormContract> allFC = new ArrayList<FormContract>();
        try {

            c = db.query(
                    Sec1Entry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );


            while (c.moveToNext()) {
                FormContract fc = new FormContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public String GetSno(String nme) {
        String sno = "0";
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String QUERY = "SELECT * FROM " + Section2Entry.TABLE_NAME + " WHERE " +
                    Section2Entry.ROW_S2Q15a + " = '" + nme + "'";
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    sno = cursor.getString(0);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return sno;
    }


}