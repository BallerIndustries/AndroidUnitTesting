package com.baller.android_testing;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anguruso on 25/10/2017.
 */

public interface FlickApi
{
    @GET("/services/rest/?method=flickr.photos.search&format=json&nojsoncallback=1&extras=url_t,url_c,url_l,url_o")
    Observable<FlickrPhotosSearchResponse> listPhotos(@Query("api_key") String apiKey, @Query("tags") String tags);
}