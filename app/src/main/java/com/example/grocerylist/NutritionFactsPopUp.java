package com.example.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class NutritionFactsPopUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_facts_pop_up);
    }

//    public void fetchData(View view) {
//        final TextView textView = (TextView) findViewById(R.id.text_view);
//        String movieSearched = searchBar.getText().toString();
//        String year = yearSearchBar.getText().toString();
//        // ...
//
//        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "https://api.edamam.com/api/food-database/v2/parser" + movieSearched + "&y=" + year;
//
//        // Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject responseObject = new JSONObject(response);
//
//                            String posterURL = responseObject.getString("Poster");
//                            moviePosterUrl = posterURL;
//                            Picasso.get().load(posterURL).into(posterImageView);
//
//                            String plotText = "Plot: " + responseObject.getString("Plot");
//                            plotTextView.setText(plotText);
//
//                            String ratedText = "Rated: " + responseObject.getString("Rated");
//                            ratedTextView.setText(ratedText);
//
//                            String runtimeText = "Runtime: " + responseObject.getString("Runtime");
//                            runtimeTextView.setText(runtimeText);
//
//                            String imdbRatingText = "IMDB Rating: " + responseObject.getString("imdbRating");
//                            imdbTextView.setText(imdbRatingText);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("That didn't work!");
//            }
//        });
//
//        // Add the request to the RequestQueue.
//        queue.add(stringRequest);
//
//    }
}
