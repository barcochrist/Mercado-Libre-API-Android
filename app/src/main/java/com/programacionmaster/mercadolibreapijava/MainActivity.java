package com.programacionmaster.mercadolibreapijava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mercadolibre.android.sdk.Meli;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Meli.setLoggingEnabled(true);
        Meli.initializeSDK(getApplicationContext());
    }
}
