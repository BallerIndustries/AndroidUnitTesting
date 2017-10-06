package com.baller.android_testing;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anguruso on 6/10/2017.
 */

public class ImageListViewModel extends ViewModel {

    interface OnComplete {
        public void onComplete();
    }

    public List<Photo> mImageList = new ArrayList<>();

    public void getImages(OnComplete onComplete)
    {
        // Put images into the list
        mImageList.add(createDummyPhoto("https://i.pinimg.com/736x/7e/a4/e4/7ea4e4e721344aec6d0cac99790ca0fc--octopus-costume-octopus-art.jpg"));
        mImageList.add(createDummyPhoto("http://kids.nationalgeographic.com/content/dam/kids/photos/articles/Nature/H-P/octopus-photos-rambo.ngsversion.1436387382745.adapt.1900.1.jpg"));
        mImageList.add(createDummyPhoto("https://i.pinimg.com/736x/cc/3e/2a/cc3e2adfda62bb7d2efdc136beffbaea--octopus-painting-octopus-art.jpg"));
        mImageList.add(createDummyPhoto("https://i.ytimg.com/vi/rX-YiYHahoo/maxresdefault.jpg"));
        mImageList.add(createDummyPhoto("https://i.ytimg.com/vi/epbJi35lzEs/maxresdefault.jpg"));

        // Call onComplete
        onComplete.onComplete();
    }

    public Photo createDummyPhoto(String urlLarge) {
        Photo photo = new Photo();
        photo.url_l  = urlLarge;
        return photo;
    }
}
