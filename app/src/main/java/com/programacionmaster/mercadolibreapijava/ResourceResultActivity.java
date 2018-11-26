package com.programacionmaster.mercadolibreapijava;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.programacionmaster.mercadolibreapijava.enums.ResourceType;
import com.programacionmaster.mercadolibreapijava.model.Resource;
import com.programacionmaster.mercadolibreapijava.service.SiteService;

public class ResourceResultActivity extends AppCompatActivity implements SiteItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_result);

        Resource resource = (Resource) getIntent().getSerializableExtra(getString(R.string.intent_resource_key));
        if (resource.getType().equals(ResourceType.SITES)) {
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayoutFragment, SiteItemFragment.newInstance(1, resource));
            fragmentTransaction.commit();
        }
    }


    @Override
    public void onListFragmentInteraction(SiteService.Site item) {
    }
}
