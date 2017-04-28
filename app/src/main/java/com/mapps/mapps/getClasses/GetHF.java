package com.mapps.mapps.getClasses;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mapps.mapps.contracts.GetHFContract;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.core.MAPPSHelper;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by isd on 05/11/2016.
 */

//public class GetHF extends AsyncTask<String, String, String> {
//
//    private final String TAG = "GetHF";
//    HttpURLConnection urlConnection;
//    private Context mContext;
//
//    public GetHF(Context context) {
//        mContext = context;
//    }
//
//    @Override
//    protected String doInBackground(String... args) {
//
//        StringBuilder result = new StringBuilder();
//
//        try {
//            //URL url = new URL("http://10.198.96.72:8080/mapps/HF_login.php");
//
//            CVars var = new CVars();
//            URL url = new URL(MAPPSApp._HOST_URL + GetHFContract.GetHFEntry.GETURL);
//
//            urlConnection = (HttpURLConnection) url.openConnection();
//            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Log.i(TAG, "HF In: " + line);
//                result.append(line);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            urlConnection.disconnect();
//        }
//
//        return result.toString();
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//
//        //Do something with the JSON string
//
//        String json = result;
//        //json = json.replaceAll("\\[", "").replaceAll("\\]","");
//        Log.d(TAG, result);
//        ArrayList<GetHFContract> HFArrayList;
//        MAPPSHelper db = new MAPPSHelper(mContext);
//        try {
//            HFArrayList = new ArrayList<GetHFContract>();
//            //JSONObject jsonObject = new JSONObject(json);
//            JSONArray jsonArray = new JSONArray(json);
//            db.syncHF(jsonArray);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        db.getAllHF();
//    }
//}

public class GetHF extends AsyncTask<String, String, String> {

    private final String TAG = "GetHF()";
    HttpURLConnection urlConnection;
    private Context mContext;
    private ProgressDialog pd;

    public GetHF(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing HF");
        pd.setMessage("Getting connected to server...");
        pd.show();

    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(MAPPSApp._HOST_URL + GetHFContract.GetHFEntry.GETURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, "HF In: " + line);
                    result.append(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            urlConnection.disconnect();
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string

        String json = result;
        //json = json.replaceAll("\\[", "").replaceAll("\\]","");
        Log.d(TAG, result);
        if (json.length() > 0) {
            ArrayList<GetHFContract> HFArrayList;
            MAPPSHelper db = new MAPPSHelper(mContext);
            try {
                HFArrayList = new ArrayList<GetHFContract>();
                //JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = new JSONArray(json);
                db.syncHF(jsonArray);
                pd.setMessage("Received: " + jsonArray.length());
                pd.show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // db.getAllHF();
        } else {
            pd.setMessage("Received: " + json.length() + "");
            pd.show();
        }
    }
}