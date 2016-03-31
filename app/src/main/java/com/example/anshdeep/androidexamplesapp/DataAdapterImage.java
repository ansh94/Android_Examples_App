package com.example.anshdeep.androidexamplesapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ANSHDEEP on 31-03-2016.
 */
public class DataAdapterImage extends RecyclerView.Adapter<DataAdapterImage.ViewHolder> {
    private ArrayList<AndroidVersion> android_versions;
    private Context context;

    public DataAdapterImage(Context context, ArrayList<AndroidVersion> android_versions) {
        this.context = context;
        this.android_versions = android_versions;

    }

    @Override
    public DataAdapterImage.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(android_versions.get(i).getAndroid_version_name());

        //main Image loading line
        Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_android;
        ImageView img_android;

        public ViewHolder(View view) {
            super(view);
            tv_android = (TextView) view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
        }
    }
}
