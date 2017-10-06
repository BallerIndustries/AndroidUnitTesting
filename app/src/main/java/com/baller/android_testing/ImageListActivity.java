package com.baller.android_testing;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class ImageListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ImageAdapater mAdapter;
    ImageListViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        // Get the View Model
        mViewModel = ViewModelProviders.of(this).get(ImageListViewModel.class);

        // Create the adapater
        mAdapter = new ImageAdapater(this, mViewModel.mImageList);

        // Get View references
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler);
        mRecyclerView.setAdapter(mAdapter);

        // Get images
        mViewModel.getImages(() -> {
            mAdapter.notifyDataSetChanged();
        });
    }
}
