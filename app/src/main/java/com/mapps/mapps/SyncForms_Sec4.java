package com.mapps.mapps;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


/**
 * Created by isd on 05/11/2016.
 */

public class SyncForms_Sec4 extends AsyncTask<Void, Void, String> {

    private static final String TAG = "SyncForms_Sec2";
    private Context mContext;
    private ProgressDialog pd;
    private ListView lstvu;

    ArrayList<String> arr_members;
    List<String> mylst;


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
        pd.setTitle("Please wait... Processing Forms");
        pd.show();
    }


    @Override
    protected String doInBackground(Void... params) {

        String line = "No Response";
        HttpURLConnection connection = null;

        try {

            String request = "http://192.168.1.105/mappsweb/syncdata_sec4.php";

            //CVars var = new CVars();
            //String request = var.get_url_sync_sec1();

            URL url = new URL(request);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.setUseCaches(false);
            connection.connect();

            JSONArray jsonSync = new JSONArray();

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            MAPPSHelper db = new MAPPSHelper(mContext);
            Collection<Section4Contract> forms = db.getAllForms_Sec4();

            for (Section4Contract sc : forms) {

                JSONObject jsonParam = new JSONObject();

                jsonParam.put("ID", sc.get_ID());
                jsonParam.put("devid", sc.getROW_DEVID());

                jsonParam.put("cluster", sc.getROW_S4CLUSTER());
                jsonParam.put("lhw", sc.getROW_S4LHW());
                jsonParam.put("hh", sc.getROW_S4HH());
                jsonParam.put("sno", sc.getROW_SNO());

                jsonParam.put("s4q1", sc.getROW_S4Q1());
                jsonParam.put("s4q28a", sc.getROW_S4Q28a());
                jsonParam.put("s4q28b", sc.getROW_S4Q28b());
                jsonParam.put("s4q28c", sc.getROW_S4Q28c());
                jsonParam.put("s4q28d", sc.getROW_S4Q28d());
                jsonParam.put("s4q28oth", sc.getROW_S4Q28oth());
                jsonParam.put("s4q28e", sc.getROW_S4Q28e());
                jsonParam.put("s4q28f", sc.getROW_S4Q28f());

                jsonParam.put("s4q28f1", sc.getROW_S4Q28f1());
                jsonParam.put("s4q28f2", sc.getROW_S4Q28f2());
                jsonParam.put("s4q28f3", sc.getROW_S4Q28f3());
                jsonParam.put("s4q28f4", sc.getROW_S4Q28f4());
                jsonParam.put("s4q28f5", sc.getROW_S4Q28f5());
                jsonParam.put("s4q28f6", sc.getROW_S4Q28f6());
                jsonParam.put("s4q28f7", sc.getROW_S4Q28f7());
                jsonParam.put("s4q28f8", sc.getROW_S4Q28f8());
                jsonParam.put("s4q28f9", sc.getROW_S4Q28f9());

                jsonParam.put("s4q28g", sc.getROW_S4Q28g());
                jsonParam.put("s4q28h", sc.getROW_S4Q28h());
                jsonParam.put("uuid", sc.getROW_UID());

                jsonSync.put(jsonParam);
            }

            wr.writeBytes(jsonSync.toString().replace("\uFEFF", "") + "\n");

            longInfo(jsonSync.toString().replace("\uFEFF", "") + "\n");
            wr.flush();
            int HttpResult = connection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "utf-8"));
                StringBuffer sb = new StringBuffer();

                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println("" + sb.toString());
                return sb.toString();
            } else {
                System.out.println(connection.getResponseMessage());
                return connection.getResponseMessage();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return line;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        if (result == "" || result == null) {
            pd.setMessage("Data synchronized successfully - Section 4");
        } else {
            pd.setMessage("Error: Data not synchronized - Section 4 \r\n\r\n" + result);
        }

        //ArrayAdapter<String> lstadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylst);
        //lstvu.setAdapter(lstadapter);

        //pd.setMessage("Server Response: " + result);
        //pd.setTitle("Please wait... Done Forms");
        //pd.show();


    }
}