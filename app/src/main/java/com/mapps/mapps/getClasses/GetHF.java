package com.mapps.mapps.getClasses;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.mapps.mapps.core.CVars;
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

public class GetHF extends AsyncTask<String, String, String> {

    private final String TAG = "GetHF";
    HttpURLConnection urlConnection;
    private Context mContext;

    public GetHF(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();

        try {
            //URL url = new URL("http://10.198.96.72:8080/mapps/users_login.php");

            CVars var = new CVars();
            URL url = new URL(MAPPSApp._HOST_URL + GetHFContract.GetHFEntry.GETURL);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                Log.i(TAG, "User In: " + line);
                result.append(line);
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
        ArrayList<GetHFContract> userArrayList;
        MAPPSHelper db = new MAPPSHelper(mContext);
        try {
            userArrayList = new ArrayList<GetHFContract>();
            //JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = new JSONArray(json);
            db.syncHF(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        db.getAllHF();
    }




/*        try {

            JSONObject obj = new JSONObject(json);

            Log.d("My App", obj.toString());

        } catch (Throwable t) {
            Log.e("My App", "Could not parse malformed JSON: \"" + json + "\"");
        }*/

//        ArrayList<String> listdata = new ArrayList<String>();
//        JSONArray jArray = (JSONArray)jsonObject;
//        if (jArray != null) {
//            for (int i=0;i<jArray.length();i++){
//                listdata.add(jArray.get(i).toString());
//            }
//        }

}