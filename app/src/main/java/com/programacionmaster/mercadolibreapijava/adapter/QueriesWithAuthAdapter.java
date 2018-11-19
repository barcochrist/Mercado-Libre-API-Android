package com.programacionmaster.mercadolibreapijava.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.programacionmaster.mercadolibreapijava.R;
import com.programacionmaster.mercadolibreapijava.model.Resource;

import java.util.List;

public class QueriesWithAuthAdapter extends RecyclerView.Adapter<QueriesWithAuthAdapter.QueriesWithAuthViewHolder> {

    private List<Resource> data;

    public QueriesWithAuthAdapter(List<Resource> data) {
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
        queriesWithAuthViewHolder.textViewTitle.setText(data.get(i).getTitle());
        queriesWithAuthViewHolder.textViewDescription.setText(data.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * View Holder class to Queries with authentication
     */
    public class QueriesWithAuthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewTitle;
        public TextView textViewDescription;
        public QueriesWithAuthAdapter adapter;

        public QueriesWithAuthViewHolder(@NonNull View itemView, QueriesWithAuthAdapter adapter) {
            super(itemView);
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.textViewDescription = itemView.findViewById(R.id.textViewDescription);
            itemView.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_SHORT);
        }
    }
}