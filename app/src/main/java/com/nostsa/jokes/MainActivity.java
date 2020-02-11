package com.nostsa.jokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout re;
    ArrayList<Joke> jokes;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokes=new ArrayList<>();
        lv= (ListView) findViewById(R.id.listview);
        re=(SwipeRefreshLayout)findViewById(R.id.ref);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("https://sv443.net/jokeapi/category/Any");
            }
        });

        re.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
                startActivity(i);
                finish();
            }
        });
    }



    class ReadJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            try {
                JSONObject jsonObject = new JSONObject(content);





                    jokes.add(new Joke(
                            jsonObject.getString("type"),
                            jsonObject.getString("category"),
                            jsonObject.getString("joke")
                    ));






                JokeAdapterTwo adapter = new JokeAdapterTwo(getApplicationContext(), R.layout.list_item, jokes);
                lv.setAdapter(adapter);


            } catch (JSONException e) {
                e.printStackTrace();
            }





            try {
                JSONObject jsonObject = new JSONObject(content);




                jokes.add(new Joke(
                        jsonObject.getString("type"),
                        jsonObject.getString("category"),
                        jsonObject.getString("setup"),
                        jsonObject.getString("delivery")
                ));




                JokeAdapter adaptertwo = new JokeAdapter(getApplicationContext(), R.layout.list_item, jokes);
                lv.setAdapter(adaptertwo);

            } catch (JSONException e) {
                e.printStackTrace();
            }




        }
    }










    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }





}
