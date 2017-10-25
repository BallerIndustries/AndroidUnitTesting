package com.baller.android_testing;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anguruso on 10/14/2017.
 */

@Singleton
public class FlickService implements FlickApi
{
    private FlickApi mApi;

    @Inject
    public FlickService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApi = retrofit.create(FlickApi.class);
    }

    @Override
    public Observable<FlickrPhotosSearchResponse> listPhotos(@Query("api_key") String apiKey, @Query("tags") String tags) {
        return mApi.listPhotos(apiKey, tags);
    }
}