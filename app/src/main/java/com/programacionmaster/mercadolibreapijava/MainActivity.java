package com.programacionmaster.mercadolibreapijava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.mercadolibre.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init UI Components
        Button btnResourcesWithAuth = findViewById(R.id.btnResourcesWithAuth);
        Button btnResourcesWithOutAuth = findViewById(R.id.btnResourcesWithOutAuth);

        btnResourcesWithAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResourcesWithAuthActivity.class);
                startActivity(intent);
            }
        });

        btnResourcesWithOutAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResourcesWithoutAuthActivity.class);
                startActivity(intent);
            }
        });
    }
}
