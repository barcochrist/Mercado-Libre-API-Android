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
        Button btnQueriesWithAuth = findViewById(R.id.btnQueriesWithAuth);
        Button btnQueriesWithOutAuth = findViewById(R.id.btnQueriesWithOutAuth);

        Meli.initializeSDK(getApplicationContext());

        btnQueriesWithAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), QueriesWithAuthActivity.class);
                startActivity(intent);
            }
        });

        btnQueriesWithOutAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), QueriesWithoutAuthActivity.class);
                startActivity(intent);
            }
        });
    }
}
