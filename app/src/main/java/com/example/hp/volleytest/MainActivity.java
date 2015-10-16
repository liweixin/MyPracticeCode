package com.example.hp.volleytest;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import android.os.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Gson gson = new Gson();
    EditText userInput;

    public static final int QUERY_RESULT = 1;
    public Handler handler = new Handler() {
        public void handleMessage(Message msg){
            switch (msg.what){
                case QUERY_RESULT:
                    updateText(msg.obj.toString());
            }
        }
    };
    public void updateText(String s){
        result.setText(s);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = (EditText) findViewById(R.id.input_text);
        result = (TextView) findViewById(R.id.query_result);
        Button query = (Button) findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlConnection();
            }
        });
       // urlConnection();
    }
    private HttpURLConnection connection;
    private void urlConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String word = userInput.getText().toString();
                    URL url = new URL("https://api.shanbay.com/bdc/search/?word=" + word);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(3000);
                    connection.setConnectTimeout(3000);
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine())!= null)
                        response.append(line);
                    line = response.toString();
                    GetWord getWord = gson.fromJson(line, GetWord.class);
                    Message msg = new Message();
                    msg.what = QUERY_RESULT;
                    msg.obj = getWord.toString();
                    handler.sendMessage(msg);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if(connection!=null) connection.disconnect();
                }
            }
        }).start();
    }
}
