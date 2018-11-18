package com.programacionmaster.mercadolibreapijava.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.programacionmaster.mercadolibreapijava.R;

public class QueriesWithoutAdapter extends RecyclerView.Adapter<QueriesWithoutAdapter.QueriesWithoutViewHolder> {

    private String[] data;

    public QueriesWithoutAdapter(String[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public QueriesWithoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_queries_without_auth, viewGroup, false);
        return new QueriesWithoutViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull QueriesWithoutViewHolder queriesWithoutViewHolder, int i) {
        queriesWithoutViewHolder.textView.setText(data[i]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    /**
     * View Holder class to Queries without authentication
     */
    public class QueriesWithoutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public QueriesWithoutAdapter adapter;

        public QueriesWithoutViewHolder(View view, QueriesWithoutAdapter adapter) {
            super(view);
            textView = view.findViewById(R.id.textViewItem);
            view.setOnClickListener(this);

            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_SHORT);
        }
    }
}
