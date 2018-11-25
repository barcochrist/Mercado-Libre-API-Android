package com.programacionmaster.mercadolibreapijava;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.programacionmaster.mercadolibreapijava.dummy.DummyContent;

public class ResourceResultActivity extends AppCompatActivity implements SiteItemFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_result);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutFragment, SiteItemFragment.newInstance(1));
        fragmentTransaction.commit();
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
    }
}
