package com.programacionmaster.mercadolibreapijava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.programacionmaster.mercadolibreapijava.adapter.ResourcesWithoutAuthAdapter;
import com.programacionmaster.mercadolibreapijava.model.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ResourcesWithoutAuthActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_without_auth);

        recyclerView = findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Resource resource1 = Resource.from(UUID.randomUUID().toString(),
                "All Sites", "Get all sites from Meli", "/sites");

        Resource resource2 = Resource.from(UUID.randomUUID().toString(),
                "All Categories of Colombia", "Get all categories of Colombia from Meli", "/sites/MCO/categories");
        List<Resource> resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);

        recyclerView.setAdapter(new ResourcesWithoutAuthAdapter(resources));
    }
}
