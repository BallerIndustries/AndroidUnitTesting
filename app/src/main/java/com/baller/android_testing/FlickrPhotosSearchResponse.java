package com.baller.android_testing;

import java.util.List;

/**
 * Created by anguruso on 10/14/2017.
 */

class FlickrPhotosSearchResponse
{
    String stat;
    Photos photos;

    public class Photos
    {
        int page;
        int pages;
        int perPage;
        String total;
        List<Photo> photo;
    }
}
