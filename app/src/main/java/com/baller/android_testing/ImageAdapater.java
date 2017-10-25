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

    public interface OnClick {
        void onClick(Photo photo);
    }

    private Context mContext;
    private List<Photo> mData;
    private OnClick mOnClick;

    public ImageAdapater(Context context, List<Photo> data, OnClick onClick) {
        this.mContext = context;
        this.mData = data;
        this.mOnClick = onClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_photo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Photo photo = mData.get(position);
        Picasso.with(mContext).load(photo.url_l).into(holder.mImageView);

//        holder.mImageView.setOnClickListener((view) -> {
//            mOnClick.onClick(photo);
//        });

        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClick.onClick(photo);
            }
        });
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
