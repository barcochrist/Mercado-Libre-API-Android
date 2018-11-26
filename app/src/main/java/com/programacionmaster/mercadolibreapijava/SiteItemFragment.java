package com.programacionmaster.mercadolibreapijava;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.programacionmaster.mercadolibreapijava.adapter.SiteItemAdapter;
import com.programacionmaster.mercadolibreapijava.model.Resource;
import com.programacionmaster.mercadolibreapijava.service.SiteService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SiteItemFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String ARG_RESOURCE = "resource";

    private int mColumnCount = 1;
    private Resource resource;
    private OnListFragmentInteractionListener mListener;
    private SiteItemAdapter siteItemAdapter;
    private List<SiteService.Site> sites;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SiteItemFragment() {
    }

    @SuppressWarnings("unused")
    public static SiteItemFragment newInstance(int columnCount, Resource argResource) {
        SiteItemFragment fragment = new SiteItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putSerializable(ARG_RESOURCE, argResource);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            resource = (Resource) getArguments().getSerializable(ARG_RESOURCE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_siteitem_list, container, false);
        //Init sites list
        sites = new ArrayList<>();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            siteItemAdapter = new SiteItemAdapter(sites, mListener);
            recyclerView.setAdapter(siteItemAdapter);
            loadSites();
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(SiteService.Site item);
    }

    /**
     * Load sites in Recycler view
     */
    private void loadSites() {
        SiteService.getAll().enqueue(new Callback<List<SiteService.Site>>() {
            @Override
            public void onResponse(Call<List<SiteService.Site>> call, Response<List<SiteService.Site>> response) {
                if (response.isSuccessful()) {
                    for (SiteService.Site site : response.body()) {
                        sites.add(site);
                    }
                    siteItemAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SiteService.Site>> call, Throwable t) {
                Toast.makeText(getContext(), "Error loading sites", Toast.LENGTH_LONG).show();
            }
        });
    }
}
