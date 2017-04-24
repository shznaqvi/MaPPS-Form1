package com.mapps.mapps;

import android.provider.BaseColumns;

/**
 * Created by isd on 20/10/2016.
 */
public final class GetLHWContract implements BaseColumns {
    private static final String TAG = "lhwcontract";
    String ROW_LHWID;
    String ROW_LHWNAME;
    String ROW_CLUSTER;
    String ROW_HCODE;


    public GetLHWContract() {
        // Default Constructor
    }

    public GetLHWContract(String lhwid, String lhwname, String cluster, String hcode) {
        this.ROW_LHWID = lhwid;
        this.ROW_LHWNAME = lhwname;
        this.ROW_CLUSTER = cluster;
        this.ROW_HCODE = hcode;
    }

    public String getROW_LHWID() {
        return ROW_LHWID;
    }

    public void setROW_LHWID(String ROW_LHWID) {
        this.ROW_LHWID = ROW_LHWID;
    }

    public String getROW_LHWNAME() {
        return ROW_LHWNAME;
    }

    public void setROW_LHWNAME(String ROW_LHWNAME) {
        this.ROW_LHWNAME = ROW_LHWNAME;
    }

    public String getROW_HCODE() {
        return ROW_HCODE;
    }

    public void setROW_HCODE(String ROW_HCODE) {
        this.ROW_HCODE = ROW_HCODE;
    }

    public String getROW_CLUSTER() {
        return ROW_CLUSTER;
    }

    public void setROW_CLUSTER(String ROW_CLUSTER) {
        this.ROW_CLUSTER = ROW_CLUSTER;
    }

    public static abstract class GetLHWEntry implements BaseColumns {

        public static final String TABLE_NAME = "lhwlist";
        public static final String ROW_LHWID = "lhwid";
        public static final String ROW_LHWNAME = "lhwname";
        public static final String ROW_CLUSTER = "cluster";
        public static final String ROW_HCODE = "hcode";
    }
}