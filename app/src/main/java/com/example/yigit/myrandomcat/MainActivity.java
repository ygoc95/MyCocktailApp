package com.example.yigit.myrandomcat;

import android.content.Context;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
Button newImage;
TextView textUrl,texthow,textindg;
ImageView catImage;
String imageurl;
StringBuilder stringBuilder = new StringBuilder();

private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newImage = (Button)findViewById(R.id.button);
        textUrl =(TextView)findViewById(R.id.textName);
        texthow = (TextView)findViewById(R.id.textHow);
        textindg = (TextView)findViewById(R.id.textView7);

        catImage = (ImageView)findViewById(R.id.imageView);

        mQueue = Volley.newRequestQueue(this);
        newImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }


    private void jsonParse(){

        String url ="https://www.thecocktaildb.com/api/json/v1/0674/random.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray= response.getJSONArray("drinks");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject Drinks =jsonArray.getJSONObject(i);
                        String drinkname = Drinks.getString("strDrink");
                        textUrl.setText(drinkname);
                        String description = Drinks.getString("strInstructions");
                        texthow.setText(description);
                        imageurl =Drinks.getString("strDrinkThumb");
                        new DownloadImageTask(catImage).execute(imageurl);
                        String ingd =Drinks.getString("strIngredient1")+" "+Drinks.getString("strMeasure1")+System.lineSeparator()
                                +Drinks.getString("strIngredient2")+" "+Drinks.getString("strMeasure2")+System.lineSeparator()
                                +Drinks.getString("strIngredient3")+" "+Drinks.getString("strMeasure3")+System.lineSeparator()
                                +Drinks.getString("strIngredient4")+" "+Drinks.getString("strMeasure4")+System.lineSeparator()
                                +Drinks.getString("strIngredient5")+" "+Drinks.getString("strMeasure5")+System.lineSeparator()
                                +Drinks.getString("strIngredient6")+" "+Drinks.getString("strMeasure6")+System.lineSeparator()
                                +Drinks.getString("strIngredient7")+" "+Drinks.getString("strMeasure7")+System.lineSeparator()
                                +Drinks.getString("strIngredient8")+" "+Drinks.getString("strMeasure8")+System.lineSeparator()
                                +Drinks.getString("strIngredient9")+" "+Drinks.getString("strMeasure9")+System.lineSeparator()
                                ;
                        textindg.setText(ingd);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
mQueue.add(request);

    }
}
