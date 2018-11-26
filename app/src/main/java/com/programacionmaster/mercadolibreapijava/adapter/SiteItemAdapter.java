package com.programacionmaster.mercadolibreapijava.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programacionmaster.mercadolibreapijava.R;
import com.programacionmaster.mercadolibreapijava.SiteItemFragment.OnListFragmentInteractionListener;
import com.programacionmaster.mercadolibreapijava.service.SiteService;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.programacionmaster.mercadolibreapijava.service.SiteService.Site}
 * and makes a call to the specified {@link OnListFragmentInteractionListener}.
 */
public class SiteItemAdapter extends RecyclerView.Adapter<SiteItemAdapter.SiteItemViewHolder> {

    private final List<SiteService.Site> data;
    private final OnListFragmentInteractionListener mListener;

    public SiteItemAdapter(List<SiteService.Site> items, OnListFragmentInteractionListener listener) {
        data = items;
        mListener = listener;
    }

    @Override
    public SiteItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_siteitem, parent, false);
        return new SiteItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SiteItemViewHolder holder, int position) {
        holder.site = data.get(position);
        holder.textViewSiteId.setText(data.get(position).id);
        holder.textViewSiteName.setText(data.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.site);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SiteItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewSiteId;
        public final TextView textViewSiteName;
        public SiteService.Site site;

        public SiteItemViewHolder(View view) {
            super(view);
            mView = view;
            textViewSiteId = view.findViewById(R.id.textViewSiteId);
            textViewSiteName = view.findViewById(R.id.textViewSiteName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewSiteName.getText() + "'";
        }
    }
}
