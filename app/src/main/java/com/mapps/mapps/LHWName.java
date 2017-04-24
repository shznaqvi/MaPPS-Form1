package com.mapps.mapps;

/**
 * Created by isd on 09/11/2016.
 */

public class LHWName {
    String id;
    String nme;

    public LHWName() {
    }

    public LHWName(String id, String nme) {
        this.id = id;
        this.nme = nme;
    }


    public String getID() {
        return this.id;
    }

    public String getNME() {
        return this.nme;
    }

    public void SetID(String id) {
        this.id = id;
    }

    public void SetName(String nme) {
        this.nme = nme;
    }
}