package com.baller.android_testing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by anguruso on 6/10/2017.
 */

public class ImageAdapater extends RecyclerView.Adapter<ImageAdapater.ViewHolder> {

    private Context mContext;
    private List<Photo> mData;

    public ImageAdapater(Context context, List<Photo> data) {
        this.mContext = context;
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = mData.get(position);
        Picasso.with(mContext).load(photo.url_l).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView)itemView.findViewById(R.id.photo);
        }
    }
}
