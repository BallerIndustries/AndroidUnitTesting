package com.baller.android_testing;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class ImageListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    ImageAdapater mAdapter;
    ImageListViewModel mViewModel;

    @Inject FlickService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        // Toothpick
        Scope scope = Toothpick.openScopes(getApplication(), this);
        Toothpick.inject(this, scope);

        // Get the View Model
        mViewModel = ViewModelProviders.of(this).get(ImageListViewModel.class);

        // Create the adapater
        mAdapter = new ImageAdapater(this, mViewModel.mImageList, new ImageAdapater.OnClick() {
            @Override
            public void onClick(Photo photo) {
                this.onClick(photo);
            }
        });

        // Get View references
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler);
        mRecyclerView.setAdapter(mAdapter);

        // Get images
//        mViewModel.getImages(() -> {
//            mAdapter.notifyDataSetChanged();
//        });

        mViewModel.getImages(new ImageListViewModel.OnComplete() {
            @Override
            public void onComplete() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void launchPhotoActivity(Photo photo) {
        Intent intent = ImageActivity.createIntent(this, photo.url_l);
        startActivity(intent);
    }
}
