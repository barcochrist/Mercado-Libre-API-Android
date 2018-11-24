package com.programacionmaster.mercadolibreapijava.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.programacionmaster.mercadolibreapijava.R;
import com.programacionmaster.mercadolibreapijava.ResourceDetailActivity;
import com.programacionmaster.mercadolibreapijava.model.Resource;

import java.util.List;

public class ResourcesWithAuthAdapter extends RecyclerView.Adapter<ResourcesWithAuthAdapter.ResourcesWithAuthViewHolder> {

    private List<Resource> data;

    public ResourcesWithAuthAdapter(List<Resource> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ResourcesWithAuthViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_with_auth, viewGroup, false);
        return new ResourcesWithAuthViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesWithAuthViewHolder resourcesWithAuthViewHolder, int i) {
        resourcesWithAuthViewHolder.resource = data.get(i);
        resourcesWithAuthViewHolder.textViewTitle.setText(data.get(i).getTitle());
        resourcesWithAuthViewHolder.textViewDescription.setText(data.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * @Override View Holder class to {@link ResourcesWithAuthAdapter}
     */
    public class ResourcesWithAuthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewTitle;
        public TextView textViewDescription;
        public ResourcesWithAuthAdapter adapter;
        public Resource resource;

        public ResourcesWithAuthViewHolder(@NonNull View itemView, ResourcesWithAuthAdapter adapter) {
            super(itemView);
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.textViewDescription = itemView.findViewById(R.id.textViewDescription);
            itemView.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ResourceDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(view.getContext().getString(R.string.intent_resource_key), resource);
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }
    }
}