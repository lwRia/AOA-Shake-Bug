package com.appsonair.shakebug.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsonair.shakebug.R;
import com.appsonair.shakebug.interfaces.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

public class ShakeBugAdapter extends RecyclerView.Adapter<ShakeBugAdapter.ViewHolder> {
    private final List<Uri> imageList;
    private final OnItemClickListener onItemClickListener;

    public ShakeBugAdapter(List<Uri> imageList, OnItemClickListener onItemClickListener) {
        this.imageList = imageList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shake_bug, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri imagePath = imageList.get(position);
        // holder.imgBug.setImageURI(imagePath);
        Glide.with(holder.itemView.getContext())
                .load(imagePath)
                .into(holder.imgBug);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBug;
        ImageView imgRemove;

        ViewHolder(View itemView, OnItemClickListener itemClickListener) {
            super(itemView);
            imgBug = itemView.findViewById(R.id.img_bug);
            imgRemove = itemView.findViewById(R.id.img_remove);
            imgRemove.setOnClickListener(view -> {
                if (itemClickListener != null) {
                    int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}
