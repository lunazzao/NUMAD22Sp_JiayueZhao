package edu.neu.madcourse.numad22sp_jiayuezhao;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {
    public static final String query_for_city_id = "https://www.metaweather.com/api/location/search/?query=";
    public static final String query_for_city_weather = "https://www.metaweather.com/api/location/";

    Context context;
    String cityID = "";

    public WeatherDataService(Context context) {
        this.context = context;
    }


    public interface VolleyResponseListerner {
        void onError(String message);

        void onResponse(String cityID);
    }

    public void getCityID(String cityName, VolleyResponseListerner volleyResponseListerner) {

        String url = query_for_city_id + cityName;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONObject cityInfo = response.getJSONObject(0);
                    cityID = cityInfo.getString("woeid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(context, "City ID = "+ cityID, Toast.LENGTH_SHORT).show();
                volleyResponseListerner.onResponse(cityID);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                volleyResponseListerner.onResponse("something wrong");
            }
        });
        // Add the request to the RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface ForeCastByIDResponse {
        void onError(String message);

        void onResponse(List<WeatherReportModel> weatherModels) throws InterruptedException;
    }

    public void getCityForecastBYID(String cityID, ForeCastByIDResponse foreCastByIDResponse) {
        List<WeatherReportModel> weatherModels = new ArrayList<>();
        String url = query_for_city_weather + cityID;
        //get the json object
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    //Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                    try {
                        JSONArray checker_weather_List = response.getJSONArray("consolidated_weather");

                        for (int i = 0; i < checker_weather_List.length(); i++) {
                            WeatherReportModel one_day_weather = new WeatherReportModel();

                            JSONObject one_date_from_api = (JSONObject) checker_weather_List.get(i);

                            one_day_weather.setId(one_date_from_api.getInt("id"));
                            one_day_weather.setAir_pressure(one_date_from_api.getInt("air_pressure"));
                            one_day_weather.setApplicable_date(one_date_from_api.getString("applicable_date"));
                            one_day_weather.setCreated(one_date_from_api.getString("created"));
                            one_day_weather.setHumidity(one_date_from_api.getInt("humidity"));
                            one_day_weather.setMax_temp(one_date_from_api.getLong("max_temp"));
                            one_day_weather.setMin_temp(one_date_from_api.getLong("min_temp"));
                            one_day_weather.setWind_speed(one_date_from_api.getLong("wind_speed"));
                            one_day_weather.setVisibility(one_date_from_api.getInt("visibility"));
                            one_day_weather.setWind_direction_compass(one_date_from_api.getString(
                                    "wind_direction_compass"));
                            one_day_weather.setPredictablity(one_date_from_api.getInt("predictability"));
                            one_day_weather.setThe_temp(one_date_from_api.getLong("the_temp"));
                            one_day_weather.setWeather_state_name(one_date_from_api.getString("weather_state_name"));
                            one_day_weather.setWeather_state_abbr(one_date_from_api.getString("weather_state_abbr"));
                            weatherModels.add(one_day_weather);

                        }
                        foreCastByIDResponse.onResponse(weatherModels);

                    } catch (JSONException | InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }

    public interface ForeCastByNameResponse {
        void onError(String message);

        void onResponse(List<WeatherReportModel> weatherModels);
    }

    public void getCityForecastBYName(String cityName, ForeCastByNameResponse foreCastByNameResponse){
        getCityID(cityName, new VolleyResponseListerner() {
            @Override
            public void onError(String message) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(String cityID) {
                getCityForecastBYID(cityID, new ForeCastByIDResponse() {
                    @Override
                    public void onError(String message) {
                        //
                    }

                    @Override
                    public void onResponse(List<WeatherReportModel> weatherModels) {
                        //
                        foreCastByNameResponse.onResponse(weatherModels);

                    }
                });

            }
        });

    }


}

