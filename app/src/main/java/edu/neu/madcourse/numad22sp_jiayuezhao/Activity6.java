package edu.neu.madcourse.numad22sp_jiayuezhao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Activity6 extends AppCompatActivity {
    Button cityNameBtn, cityIDBtn, getWeatherBtn;
    EditText dataInputET;
    ListView lv_weatherReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        cityNameBtn = findViewById(R.id.button8);
        cityIDBtn = findViewById(R.id.button9);
        getWeatherBtn = findViewById(R.id.button7);
        dataInputET = findViewById(R.id.dataInput6);
        lv_weatherReport = findViewById(R.id.listView6);

        cityNameBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(Activity6.this);
                String url = "https://www.metaweather.com/api/location/search/?query=london";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                dataInputET.setText("Response is: " + response.substring(0,500));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dataInputET.setText("That didn't work!");
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);

            }
        });


    }

}