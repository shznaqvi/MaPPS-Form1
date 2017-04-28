package com.mapps.mapps.syncClasses;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.mapps.mapps.contracts.Section2Contract;
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

import com.mapps.mapps.core.MAPPSHelper;

/**
 * Created by isd on 05/11/2016.
 */

//public class SycForms_Sec2 extends AsyncTask<Void, Void, String> {
//
//    private static final String TAG = "SyncForms_Sec2";
//    private Context mContext;
//    private ProgressDialog pd;
//    private ListView lstvu;
//
//    ArrayList<String> arr_members;
//    List<String> mylst;
//
//
//    public SycForms_Sec2(Context context) {
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
//        pd.setTitle("Please wait... Processing Forms");
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
//            String request = "http://192.168.1.105/mappsweb/syncdata_sec2.php";
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
//            Collection<Section2Contract> forms = db.getAllForms_Sec2();
//
//            for (Section2Contract sc : forms) {
//
//                JSONObject jsonParam = new JSONObject();
//
//                jsonParam.put("ID", sc.get_ID());
//                jsonParam.put("devid", sc.getROW_DEVID());
//
//                jsonParam.put("cluster", sc.getROW_S2CLUSTER());
//                jsonParam.put("lhw", sc.getROW_S2LHW());
//                jsonParam.put("hh", sc.getROW_S2HH());
//                jsonParam.put("sno", sc.getROW_SNO());
//
//                jsonParam.put("s2q1", sc.getROW_S2Q1());
//                jsonParam.put("s2q15a", sc.getROW_S2Q15a());
//                jsonParam.put("s2q15i", sc.getROW_S2Q15i());
//                jsonParam.put("s2q15b", sc.getROW_S2Q15b());
//                jsonParam.put("s2q15cf", sc.getROW_S2Q15cf());
//                jsonParam.put("s2q15cm", sc.getROW_S2Q15cm());
//                jsonParam.put("s2q15d", sc.getROW_S2Q15d());
//                jsonParam.put("s2q15e1", sc.getROW_S2Q15e1());
//                jsonParam.put("s2q15e", sc.getROW_S2Q15e());
//                jsonParam.put("s2q15fy", sc.getROW_S2Q15fy());
//                jsonParam.put("s2q15fm", sc.getROW_S2Q15fm());
//
//                jsonParam.put("fy", sc.getROW_fy());
//                jsonParam.put("fm", sc.getROW_fm());
//
//
//                jsonParam.put("s2q15g", sc.getROW_S2Q15g());
//                jsonParam.put("s2q15h", sc.getROW_S2Q15h());
//                jsonParam.put("s2q15j", sc.getROW_S2Q15j());
//                jsonParam.put("s2q15k", sc.getROW_S2Q15k());
//                jsonParam.put("s2q15l1", sc.getROW_S2Q15l1());
//                jsonParam.put("s2q15lmp", sc.getROW_S2Q15lmp());
//                jsonParam.put("s2q15gest", sc.getROW_S2Q15gest());
//                jsonParam.put("uuid", sc.getROW_UID());
//                jsonParam.put("iselig", sc.getROW_iselig());
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
//            pd.setMessage("Data synchronized successfully - Section 2");
//        } else {
//            pd.setMessage("Error: Data not synchronized - Section 2 \r\n\r\n" + result);
//        }
//
//        //ArrayAdapter<String> lstadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylst);
//        //lstvu.setAdapter(lstadapter);
//
//        //pd.setMessage("Server Response: " + result);
//        //pd.setTitle("Please wait... Done Forms");
//        //pd.show();
//
//
//    }
//}

public class SycForms_Sec2 extends AsyncTask<Void, Void, String> {

    private static final String TAG = "SyncSection2()";
    private Context mContext;
    private ProgressDialog pd;

    public SycForms_Sec2(Context context) {
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
        pd.setTitle("Please wait... Processing Section 2");
        pd.show();
    }


    @Override
    protected String doInBackground(Void... params) {

        String line = "No Response";
        try {
            String url = MAPPSApp._HOST_URL + Section2Contract.Section2Entry._URL;
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
                    db.updateSection2(jsonObject.getString("id"));
                    sSynced++;
                }
            }
            Toast.makeText(mContext, sSynced + " Section2 synced." + String.valueOf(json.length() - sSynced) + " Errors.", Toast.LENGTH_SHORT).show();

            pd.setMessage(sSynced + " Section2 synced." + String.valueOf(json.length() - sSynced) + " Errors.");
            pd.setTitle("Done uploading Section2 data");
            pd.show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Failed Sync " + result, Toast.LENGTH_SHORT).show();

            pd.setMessage(result);
            pd.setTitle("Section2's Sync Failed");
            pd.show();
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        String line = "No Response";
        // Only display the first 500 characters of the retrieved
        // web page content.
        //int len = 500;
        MAPPSHelper db = new MAPPSHelper(mContext);
        Collection<Section2Contract> Section2 = db.getUnsyncedSection2();
        Log.d(TAG, String.valueOf(Section2.size()));
        if (Section2.size() > 0) {
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

                    for (Section2Contract fc : Section2) {

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