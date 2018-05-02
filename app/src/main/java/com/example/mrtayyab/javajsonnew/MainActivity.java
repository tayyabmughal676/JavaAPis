package com.example.mrtayyab.javajsonnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String URL_JSON = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest ArrayRequest;
    private RequestQueue requestQueue;
    private List<HeroesModel> lstAnime = new ArrayList<>();
    private RecyclerView myrv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrv = findViewById(R.id.recyclerViewList);
        jsoncall();
    }

    private void jsoncall() {


        ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;


                for (int i = 0; i < response.length(); i++) {

                    //Toast.makeText(getApplicationContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();

                    try {

                        jsonObject = response.getJSONObject(i);
                        HeroesModel hero = new HeroesModel();

                        hero.setName(jsonObject.getString("name"));
                        hero.setRating(jsonObject.getString("Rating"));
                        hero.setDescription(jsonObject.getString("description"));
                        hero.setImage_url(jsonObject.getString("img"));
                        hero.setStudio(jsonObject.getString("studio"));
                        hero.setCategorie(jsonObject.getString("categorie"));
//
                        //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                        lstAnime.add(hero);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                Toast.makeText(MainActivity.this, "Size of Liste " + String.valueOf(lstAnime.size()), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, lstAnime.get(1).toString(), Toast.LENGTH_SHORT).show();

                setRvadapter(lstAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(ArrayRequest);
    }


//    }

    public void setRvadapter(List<HeroesModel> newList) {

        heroAdapter myAdapter = new heroAdapter(this, newList);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);


    }
}




