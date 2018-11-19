package com.programacionmaster.mercadolibreapijava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mercadolibre.android.sdk.Meli;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init UI Components
        Button btnResourcesWithAuth = findViewById(R.id.btnResourcesWithAuth);
        Button btnResourcesWithOutAuth = findViewById(R.id.btnResourcesWithOutAuth);

        Meli.initializeSDK(getApplicationContext());

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
