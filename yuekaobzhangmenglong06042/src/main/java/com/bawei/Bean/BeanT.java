package com.bawei.Bean;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:10:15
 *@Description:
 * */public class BeanT {
     private String imageUrl;
     private String title;

    public BeanT(String imageUrl, String title) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public BeanT() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BeanT{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
