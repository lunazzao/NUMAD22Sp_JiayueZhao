package edu.neu.madcourse.numad22sp_jiayuezhao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class Activity6 extends AppCompatActivity {
    Button cityNameBtn, cityIDBtn, getWeatherbyIDBtn;
    EditText dataInputET;
    ListView lv_weatherReport;
    private ProgressBar spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);

        cityNameBtn = findViewById(R.id.button8);
        cityIDBtn = findViewById(R.id.button9);
        getWeatherbyIDBtn = findViewById(R.id.button7);
        dataInputET = findViewById(R.id.dataInput6);
        lv_weatherReport = findViewById(R.id.listView6);
        final WeatherDataService weather1 = new WeatherDataService(Activity6.this);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);

        cityIDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(Activity6.this);

                weather1.getCityID(dataInputET.getText().toString(), new WeatherDataService.VolleyResponseListerner() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(Activity6.this, "something wrong", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(String cityID) {
                        Toast.makeText(Activity6.this, "Returned a City ID of " + cityID, Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(Activity6.this, "Returned a City ID of "+ cityID, Toast.LENGTH_SHORT).show();

            }
        });

        getWeatherbyIDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                weather1.getCityForecastBYID(dataInputET.getText().toString(), new WeatherDataService.ForeCastByIDResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(Activity6.this, "Error on this", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(List<WeatherReportModel> weatherReportModels) {

                        ArrayAdapter arrayAdapter = new ArrayAdapter(Activity6.this,
                                android.R.layout.simple_list_item_1, weatherReportModels);
                        lv_weatherReport.setAdapter(arrayAdapter);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        spinner.setVisibility(View.INVISIBLE);
                    }
                });
                //spinner.setVisibility(View.INVISIBLE);
                //Toast.makeText(Activity6.this, "Returned a City ID of "+ cityID, Toast.LENGTH_SHORT).show();

            }
        });

        cityNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.VISIBLE);
                weather1.getCityForecastBYName(dataInputET.getText().toString(), new WeatherDataService.ForeCastByNameResponse() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(Activity6.this, "Error on city by name", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onResponse(List<WeatherReportModel> weatherReportModels) {

                        ArrayAdapter arrayAdapter = new ArrayAdapter(Activity6.this,
                                android.R.layout.simple_list_item_1, weatherReportModels);
                        lv_weatherReport.setAdapter(arrayAdapter);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        spinner.setVisibility(View.INVISIBLE);

                    }//
                });

                //Toast.makeText(Activity6.this, "Returned a City ID of "+ cityID, Toast.LENGTH_SHORT).show();

            }
        });


    }

}