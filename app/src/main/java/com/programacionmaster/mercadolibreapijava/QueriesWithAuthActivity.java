package com.programacionmaster.mercadolibreapijava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programacionmaster.mercadolibreapijava.adapter.QueriesWithoutAdapter;

public class QueriesWithAuthActivity extends AppCompatActivity {

    private RecyclerView recyclerViewQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queries_with_auth);

        recyclerViewQueries = findViewById(R.id.recyclerQueries);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewQueries.setHasFixedSize(true);

        // use a linear layout manager
        recyclerViewQueries.setLayoutManager(new LinearLayoutManager(this));

        String[] data = {
                "All Categories",
                "Items by Category",
                "All sites",
                "All Categories",
                "Items by Category",
                "All sites",
                "All Categories",
                "Items by Category",
                "All sites",
                "All Categories",
                "Items by Category",
                "All sites",
                "All Categories",
                "Items by Category",
                "All sites",
                "All Categories",
                "Items by Category",
                "All sites",
                "All Categories",
                "Items by Category",
                "All sites"
        };

        recyclerViewQueries.setAdapter(new QueriesWithoutAdapter(data));
    }
}
