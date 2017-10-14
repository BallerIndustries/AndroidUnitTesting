package com.baller.android_testing;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by anguruso on 6/10/2017.
 */

public class ImageListViewModel extends ViewModel {

    private FlickService flickService;

    interface OnComplete {
        void onComplete();
    }

    public ImageListViewModel()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        flickService = retrofit.create(FlickService.class);
    }

    public List<Photo> mImageList = new ArrayList<>();

    public void getImages(OnComplete onComplete)
    {
        flickService.listPhotos("949e98778755d1982f537d56236bbb42", "octopus")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((flickrResponse) -> {
                    mImageList.addAll(flickrResponse.photos.photo);
                    onComplete.onComplete();
                }, (exception) -> {
                    Timber.e(exception, "Failed to get octopuses from Flickr");
                    onComplete.onComplete();
                });
    }

    public Photo createDummyPhoto(String urlLarge) {
        Photo photo = new Photo();
        photo.url_l  = urlLarge;
        return photo;
    }
}
