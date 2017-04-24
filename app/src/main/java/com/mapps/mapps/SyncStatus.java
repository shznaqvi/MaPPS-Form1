package com.mapps.mapps;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SyncStatus extends Activity {

    private ListView lstvu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_status);

        /*lstvu = (ListView) findViewById(R.id.lstvu);

        ArrayList<String> mylst = new ArrayList<>();

        mylst.add("jojo");
        mylst.add("smith");
        mylst.add("smith");

        ArrayAdapter<String> lstadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylst);
        lstvu.setAdapter(lstadapter);*/
    }

    public class SyncForms extends AsyncTask<Void, Void, String> {

        private static final String TAG = "SyncForms";
        private Context mContext;
        private ProgressDialog pd;
        private ListView lstvu;

        ArrayList<String> arr_members;
        ArrayList<String> mylst;


        public SyncForms(Context context) {
            mContext = context;
        }

        public void longInfo(String str) {
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
            JSONObject jsonParam = null;
            try {
                String request = "http://10.198.96.72:8080/mapps/syncdata.php";
                //String request = "http://10.1.42.30:3000/forms";

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
                Collection<FormContract> forms = db.getAllForms();
                Collection<FormContract> members = null;

                arr_members = new ArrayList<>();

                for (FormContract m : forms) {
                    arr_members.add(m.getROW_S1Q1());
                }

                Log.d(TAG, "debug : " + arr_members.get(0));
                Log.d(TAG, "debug : " + arr_members.get(1));
                Log.d(TAG, "debug : " + arr_members.get(2));


                Log.d(TAG, String.valueOf(forms.size()));

//            pd.setMessage("Total Forms: " );


                for (FormContract fc : forms) {

                    jsonParam = new JSONObject();

                    jsonParam.put("devid", fc.getROW_DEVID());
                    jsonParam.put("s1q1", fc.getROW_S1Q1());
                    jsonParam.put("s1q2", fc.getROW_S1Q2());
                    jsonParam.put("s1q3", fc.getROW_S1Q3());
                    jsonParam.put("s1q4", fc.getROW_S1Q4());
                    jsonParam.put("s1q5", fc.getROW_S1Q5());
                    jsonParam.put("s1q6", fc.getROW_S1Q6());
                    jsonParam.put("s1q7", fc.getROW_S1Q7());
                    jsonParam.put("s1q8", fc.getROW_S1Q8());
                    jsonParam.put("s1q9a", fc.getROW_S1Q9a());
                    jsonParam.put("s1q9b", fc.getROW_S1Q9b());
                    jsonParam.put("s1q10", fc.getROW_S1Q10());
                    jsonParam.put("s1q11", fc.getROW_S1Q11());
                    jsonParam.put("s1q12", fc.getROW_S1Q12());
                    jsonParam.put("s1q13", fc.getROW_S1Q13());
                    jsonParam.put("s1q14", fc.getROW_S1Q14());
                    jsonParam.put("userid", fc.getROW_USERID());
                    jsonParam.put("entrydate", fc.getROW_ENTRYDATE());

                    Log.d(TAG, "doInBackground: " + jsonParam.get("s1q1"));

                    //jsonSync.put(fc.toJSONObject());

                    jsonSync.put(jsonParam);

                    //wr.writeBytes(jsonParam.toString().replace("\uFEFF", "") + "\n");
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
            //ArrayAdapter<String> lstadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mylst);
            //lstvu.setAdapter(lstadapter);

            pd.setMessage("Server Response: " + result);
            pd.setTitle("Please wait... Done Forms");
            pd.show();
        }
    }
}