package com.mapps.mapps;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

/**
 * Created by hassan.naqvi on 7/26/2016.
 */
public class SyncForms_Section2 extends AsyncTask<String, Void, String> {

    private static final String TAG = "SyncForms";
    private Context mContext;
    private ProgressDialog pd;


    public SyncForms_Section2(Context context) {
        mContext = context;
    }

    public static void longInfo(String str) {
        if (str.length() > 4000) {
            Log.i("TAG: ", str.substring(0, 4000));
            longInfo(str.substring(4000));
        } else
            Log.i("TAG: ", str);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Please wait... Processing Forms");
        pd.show();
    }


    @Override
    protected String doInBackground(String... urls) {
        String line = "No Response";
        try {
            return downloadUrl(urls[0]);
        } catch (IOException e) {
            return "Unable to upload data. Server may be down.";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        JSONArray json = null;
        try {
            json = new JSONArray(result);

            Toast.makeText(mContext, "Successfully Synced " + json.length() + " Forms", Toast.LENGTH_SHORT).show();

            pd.setMessage(json.length() + " forms synced.");
            pd.setTitle("Done uploading forms data");
            pd.show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Failed Sync " + result, Toast.LENGTH_SHORT).show();

            pd.setMessage(result);
            pd.setTitle("Forms Sync Failed");
            pd.show();
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);

            Log.d(TAG, "url : " + myurl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);
            // Starts the query
            conn.connect();
            JSONArray jsonSync = new JSONArray();
            try {
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                MAPPSHelper db = new MAPPSHelper(mContext);
                Collection<Section2Contract> forms = db.getAllForms_Sec2();
                Log.d(TAG, String.valueOf(forms.size()));
//            pd.setMessage("Total Forms: " );
                for (Section2Contract sc : forms) {

                /*JSONObject jsonParam = new JSONObject();

                jsonParam.put("_id", fc.getID());
                jsonParam.put("_uid", fc.getUID());
                jsonParam.put("projectname", fc.getProjectName());
                jsonParam.put("surveytype", fc.getSurveyType());
                jsonParam.put("mna1", fc.getMna1());
                jsonParam.put("mna2", fc.getMna2());
                jsonParam.put("mna3", fc.getMna3());
                jsonParam.put("mna4", fc.getMna4());
                jsonParam.put("mna5", fc.getMna5());
                jsonParam.put("mna6", fc.getMna6());
                jsonParam.put("mna6a", fc.getMna6a());
                jsonParam.put("mna7", fc.getMna7());
                jsonParam.put("sa", fc.getsA());
                //Log.d(TAG, "doInBackground: sA"+ jsonParam.getJSONObject("sA"));
                jsonParam.put("sb", fc.getsB());
                jsonParam.put("sc", fc.getsC());
                jsonParam.put("sd", fc.getsD());
                jsonParam.put("se", fc.getsE());
                jsonParam.put("sf", fc.getsF());
                jsonParam.put("sg", fc.getsG());
                jsonParam.put("gpslat", fc.getGpsLat());
                jsonParam.put("gpslng", fc.getGpsLng());
                jsonParam.put("gpsacc", fc.getGpsAcc());
                jsonParam.put("gpstime", DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(fc.getGpsTime())));
                jsonParam.put("deviceid", fc.getDeviceID());

                longInfo(jsonParam.toString());*/

                    jsonSync.put(sc.toJSONObject());

                    //wr.writeBytes(jsonParam.toString().replace("\uFEFF", "") + "\n");

                }
                wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");
                longInfo(jsonSync.toString().replace("\uFEFF", "") + "\n");
                wr.flush();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            int response = conn.getResponseCode();
            Log.d(TAG, "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public String readIt(InputStream stream, int len) throws IOException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}