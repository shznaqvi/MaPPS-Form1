package com.mapps.mapps.syncClasses;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mapps.mapps.contracts.Section4Contract;
import com.mapps.mapps.contracts.Section4Contract.Section4Entry;
import com.mapps.mapps.core.MAPPSApp;
import com.mapps.mapps.core.MAPPSHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

/**
 * Created by isd on 05/11/2016.
 */

//public class SyncSection4_Sec4 extends AsyncTask<Void, Void, String> {
//
//    private static final String TAG = "SyncSection4_Sec2";
//    private Context mContext;
//    private ProgressDialog pd;
//    private ListView lstvu;
//
//    ArrayList<String> arr_members;
//    List<String> mylst;
//
//
//    public SyncSection4_Sec4(Context context) {
//        mContext = context;
//    }
//
//    public static void longInfo(String str) {
//        if (str.length() > 4000) {
//            Log.i("TAG: ", str.substring(0, 4000));
//            longInfo(str.substring(4000));
//        } else
//            Log.i("TAG: ", str);
//    }
//
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        pd = new ProgressDialog(mContext);
//        pd.setTitle("Please wait... Processing Section4");
//        pd.show();
//    }
//
//
//    @Override
//    protected String doInBackground(Void... params) {
//
//        String line = "No Response";
//        HttpURLConnection connection = null;
//
//        try {
//
//            String request = "http://192.168.1.105/mappsweb/syncdata_sec4.php";
//
//            //CVars var = new CVars();
//            //String request = var.get_url_sync_sec1();
//
//            URL url = new URL(request);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setInstanceFollowRedirects(false);
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("charset", "utf-8");
//            connection.setUseCaches(false);
//            connection.connect();
//
//            JSONArray jsonSync = new JSONArray();
//
//            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
//            MAPPSHelper db = new MAPPSHelper(mContext);
//            Collection<Section4Contract> Section4 = db.getAllSection4_Sec4();
//
//            for (Section4Contract sc : Section4) {
//
//                JSONObject jsonParam = new JSONObject();
//
//                jsonParam.put("ID", sc.get_ID());
//                jsonParam.put("devid", sc.getROW_DEVID());
//
//                jsonParam.put("cluster", sc.getROW_S4CLUSTER());
//                jsonParam.put("lhw", sc.getROW_S4LHW());
//                jsonParam.put("hh", sc.getROW_S4HH());
//                jsonParam.put("sno", sc.getROW_SNO());
//
//                jsonParam.put("s4q1", sc.getROW_S4Q1());
//                jsonParam.put("s4q28a", sc.getROW_S4Q28a());
//                jsonParam.put("s4q28b", sc.getROW_S4Q28b());
//                jsonParam.put("s4q28c", sc.getROW_S4Q28c());
//                jsonParam.put("s4q28d", sc.getROW_S4Q28d());
//                jsonParam.put("s4q28oth", sc.getROW_S4Q28oth());
//                jsonParam.put("s4q28e", sc.getROW_S4Q28e());
//                jsonParam.put("s4q28f", sc.getROW_S4Q28f());
//
//                jsonParam.put("s4q28f1", sc.getROW_S4Q28f1());
//                jsonParam.put("s4q28f2", sc.getROW_S4Q28f2());
//                jsonParam.put("s4q28f3", sc.getROW_S4Q28f3());
//                jsonParam.put("s4q28f4", sc.getROW_S4Q28f4());
//                jsonParam.put("s4q28f5", sc.getROW_S4Q28f5());
//                jsonParam.put("s4q28f6", sc.getROW_S4Q28f6());
//                jsonParam.put("s4q28f7", sc.getROW_S4Q28f7());
//                jsonParam.put("s4q28f8", sc.getROW_S4Q28f8());
//                jsonParam.put("s4q28f9", sc.getROW_S4Q28f9());
//
//                jsonParam.put("s4q28g", sc.getROW_S4Q28g());
//                jsonParam.put("s4q28h", sc.getROW_S4Q28h());
//                jsonParam.put("uuid", sc.getROW_UID());
//
//                jsonSync.put(jsonParam);
//            }
//
//            wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");
//
//            longInfo(jsonSync.toString().replace("\uFEFF", "") + "\n");
//            wr.flush();
//            int HttpResult = connection.getResponseCode();
//            if (HttpResult == HttpURLConnection.HTTP_OK) {
//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        connection.getInputStream(), "utf-8"));
//                StringBuffer sb = new StringBuffer();
//
//                while ((line = br.readLine()) != null) {
//                    sb.append(line + "\n");
//                }
//                br.close();
//
//                System.out.println("" + sb.toString());
//                return sb.toString();
//            } else {
//                System.out.println(connection.getResponseMessage());
//                return connection.getResponseMessage();
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            if (connection != null)
//                connection.disconnect();
//        }
//        return line;
//    }
//
//    @Override
//    protected void onPostExecute(String result) {
//        super.onPostExecute(result);
//
//        if (result == "" || result == null) {
//            pd.setMessage("Data synchronized successfully - Section 4");
//        } else {
//            pd.setMessage("Error: Data not synchronized - Section 4 \r\n\r\n" + result);
//        }
//
//        //ArrayAdapter<String> lstadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylst);
//        //lstvu.setAdapter(lstadapter);
//
//        //pd.setMessage("Server Response: " + result);
//        //pd.setTitle("Please wait... Done Section4");
//        //pd.show();
//
//
//    }
//}

public class SyncForms_Sec4 extends AsyncTask<Void, Void, String> {

    private static final String TAG = "SyncSection4()";
    private Context mContext;
    private ProgressDialog pd;

    public SyncForms_Sec4(Context context) {
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
        pd.setTitle("Please wait... Processing Section 4");
        pd.show();
    }


    @Override
    protected String doInBackground(Void... params) {

        String line = "No Response";
        try {
            String url = MAPPSApp._HOST_URL + Section4Entry._URL;
            Log.d(TAG, "doInBackground: URL " + url);
            return downloadUrl(url);
        } catch (IOException e) {
            return "Unable to upload data. Server may be down.";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        int sSynced = 0;
        JSONArray json = null;
        try {
            json = new JSONArray(result);
            MAPPSHelper db = new MAPPSHelper(mContext);
            for (int i = 0; i < json.length(); i++) {
                JSONObject jsonObject = new JSONObject(json.getString(i));
                if (jsonObject.getString("status").equals("1")) {
                    db.updateSection4(jsonObject.getString("id"));
                    sSynced++;
                }
            }
            Toast.makeText(mContext, sSynced + " Section4 synced." + String.valueOf(json.length() - sSynced) + " Errors.", Toast.LENGTH_SHORT).show();

            pd.setMessage(sSynced + " Section4 synced." + String.valueOf(json.length() - sSynced) + " Errors.");
            pd.setTitle("Done uploading Section4 data");
            pd.show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Failed Sync " + result, Toast.LENGTH_SHORT).show();

            pd.setMessage(result);
            pd.setTitle("Section4's Sync Failed");
            pd.show();
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        String line = "No Response";
        // Only display the first 500 characters of the retrieved
        // web page content.
        //int len = 500;
        MAPPSHelper db = new MAPPSHelper(mContext);
        Collection<Section4Contract> Section4 = db.getUnsyncedSection4();
        Log.d(TAG, String.valueOf(Section4.size()));
        if (Section4.size() > 0) {
            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(20000 /* milliseconds */);
                conn.setConnectTimeout(30000 /* milliseconds */);
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

                    for (Section4Contract fc : Section4) {

                        jsonSync.put(fc.toJSONObject());

                    }
                    wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");
                    longInfo(jsonSync.toString().replace("\uFEFF", "") + "\n");
                    wr.flush();
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

/*===================================================================*/
                int HttpResult = conn.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            conn.getInputStream(), "utf-8"));
                    StringBuffer sb = new StringBuffer();

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();

                    System.out.println("" + sb.toString());
                    return sb.toString();
                } else {
                    System.out.println(conn.getResponseMessage());
                    return conn.getResponseMessage();
                }
            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else {
            return "No new records to sync";
        }
        return line;
            /*===================================================================*/

    }

   /* public String readIt(InputStream stream) throws IOException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }*/
}