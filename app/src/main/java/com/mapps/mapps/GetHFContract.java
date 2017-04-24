package com.mapps.mapps;

import android.provider.BaseColumns;

/**
 * Created by isd on 20/10/2016.
 */
public final class GetHFContract implements BaseColumns {
    private static final String TAG = "hfacility_contract";
    String ROW_HFCODE;
    String ROW_HFNAME;

    public GetHFContract() {
        // Default Constructor
    }

    public GetHFContract(String hfcode, String hfname) {
        this.ROW_HFCODE = hfcode;
        this.ROW_HFNAME = hfname;
    }

    public String getROW_HFCODE() {
        return ROW_HFCODE;
    }

    public void setROW_HFCODE(String ROW_HFCODE) {
        this.ROW_HFCODE = ROW_HFCODE;
    }

    public String getROW_HFNAME() {
        return ROW_HFNAME;
    }

    public void setROW_HFNAME(String ROW_HFNAME) {
        this.ROW_HFNAME = ROW_HFNAME;
    }

    public static abstract class GetHFEntry implements BaseColumns {

        public static final String TABLE_NAME = "hfacility";
        public static final String ROW_HFCODE = "hfcode";
        public static final String ROW_HFNAME = "hfname";
    }
}