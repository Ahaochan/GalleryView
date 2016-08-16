package com.ahao.galleryviewsamples;

/**
 * Created by Avalon on 2016/6/22.
 */
public class MyData {
    public MyData(int imageResId, String title){
        this.imageResId = imageResId;
        this.title = title;
    }
    private int imageResId;
    private String title;

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
