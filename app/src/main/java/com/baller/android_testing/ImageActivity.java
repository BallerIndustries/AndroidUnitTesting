package com.baller.android_testing;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    public static final String LARGE_URL_EXTRA = "LARGE_URL_EXTRA";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        // Get view references
        mImageView = (ImageView)findViewById(R.id.photo);

        // Get URL from intent
        String url = getIntent().getStringExtra(LARGE_URL_EXTRA);
        Picasso.with(this).load(url).into(mImageView);
    }

    public static Intent createIntent(Context context, String largeUrl) {
        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra(LARGE_URL_EXTRA, largeUrl);
        return intent;
    }
}
