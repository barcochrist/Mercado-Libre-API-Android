package com.programacionmaster.mercadolibreapijava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.programacionmaster.mercadolibreapijava.model.Resource;

public class ResourceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textViewDescription = findViewById(R.id.textViewDescription);
        TextView textViewUri = findViewById(R.id.textViewUri);
        TextView textViewMethod = findViewById(R.id.textViewMethod);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Resource resource = (Resource) getIntent().getSerializableExtra(getString(R.string.intent_resource_key));
        setTitle(resource.getTitle());
        textViewDescription.setText(resource.getDescription());
        textViewUri.setText(resource.getUri());
        textViewMethod.setText(resource.getMethod().toString());
    }
}
