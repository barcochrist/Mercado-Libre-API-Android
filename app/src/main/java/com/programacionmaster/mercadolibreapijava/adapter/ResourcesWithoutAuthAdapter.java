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
import com.programacionmaster.mercadolibreapijava.ResourceResultActivity;
import com.programacionmaster.mercadolibreapijava.model.Resource;

import java.util.List;

public class ResourcesWithoutAuthAdapter extends RecyclerView.Adapter<ResourcesWithoutAuthAdapter.ResourcesWithoutAuthViewHolder> {

    private List<Resource> data;

    public ResourcesWithoutAuthAdapter(@NonNull List<Resource> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ResourcesWithoutAuthViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_without_auth, viewGroup, false);
        return new ResourcesWithoutAuthViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesWithoutAuthViewHolder resourcesWithoutAuthViewHolder, int i) {
        resourcesWithoutAuthViewHolder.resource = data.get(i);
        resourcesWithoutAuthViewHolder.textViewTitle.setText(data.get(i).getTitle());
        resourcesWithoutAuthViewHolder.textViewDescription.setText(data.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    /**
     * View Holder class to {@link ResourcesWithoutAuthAdapter}
     */
    public class ResourcesWithoutAuthViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewTitle;
        public TextView textViewDescription;
        public ResourcesWithoutAuthAdapter adapter;
        public Resource resource;

        public ResourcesWithoutAuthViewHolder(View view, ResourcesWithoutAuthAdapter adapter) {
            super(view);
            this.textViewTitle = view.findViewById(R.id.textViewTitle);
            this.textViewDescription = view.findViewById(R.id.textViewDescription);
            view.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ResourceResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(view.getContext().getString(R.string.intent_resource_key), resource);
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }
    }
}
