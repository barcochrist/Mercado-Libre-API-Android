package com.programacionmaster.mercadolibreapijava.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.programacionmaster.mercadolibreapijava.R;

public class QueriesWithAuthAdapter extends RecyclerView.Adapter<QueriesWithAuthAdapter.QueriesWithAuthViewHolder> {

    private String[] data;

    public QueriesWithAuthAdapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public QueriesWithAuthViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_queries_with_auth, viewGroup, false);
        return new QueriesWithAuthViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull QueriesWithAuthViewHolder queriesWithAuthViewHolder, int i) {
        queriesWithAuthViewHolder.textViewTitle.setText(data[i]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    /**
     * View Holder class to Queries with authentication
     */
    public class QueriesWithAuthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewTitle;
        public QueriesWithAuthAdapter adapter;

        public QueriesWithAuthViewHolder(@NonNull View itemView, QueriesWithAuthAdapter adapter) {
            super(itemView);
            this.textViewTitle = itemView.findViewById(R.id.textViewItem);
            itemView.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_SHORT);
        }
    }
}