package com.programacionmaster.mercadolibreapijava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programacionmaster.mercadolibreapijava.adapter.QueriesWithoutAdapter;
import com.programacionmaster.mercadolibreapijava.model.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QueriesWithoutAuthActivity extends AppCompatActivity {

    private RecyclerView recyclerViewQueries;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queries_without_auth);

        recyclerViewQueries = findViewById(R.id.recyclerQueries);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerViewQueries.setHasFixedSize(true);

        // use a linear layout manager
        recyclerViewQueries.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewQueries.setItemAnimator(new DefaultItemAnimator());

        Resource resource1 = Resource.from(UUID.randomUUID().toString(),
                "All Sites", "Get all sites from Meli", "/sites");

        Resource resource2 = Resource.from(UUID.randomUUID().toString(),
                "All Categories of Colombia", "Get all categories of Colombia from Meli", "/sites/MCO/categories");
        List<Resource> resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);

        mAdapter = new QueriesWithoutAdapter(resources);
        recyclerViewQueries.setAdapter(mAdapter);
    }
}
