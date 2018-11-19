package com.programacionmaster.mercadolibreapijava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programacionmaster.mercadolibreapijava.adapter.QueriesWithAuthAdapter;
import com.programacionmaster.mercadolibreapijava.model.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

        Resource resource1 = Resource.from(UUID.randomUUID().toString(),
                "Get user authenticated information", "Get information from current user authenticated from Meli", "/users/me");

        Resource resource2 = Resource.from(UUID.randomUUID().toString(),
                "Get Item By ID", "Get item by ID from Meli", "/items/MLA608007087");
        List<Resource> resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);

        recyclerViewQueries.setAdapter(new QueriesWithAuthAdapter(resources));
    }
}
