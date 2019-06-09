package com.bawei.Bean;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:10:22
 *@Description:
 * */public class BeanL {
     private String imageUrl;
     private String name;
     private String summary;

    public BeanL(String imageUrl, String name, String summary) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.summary = summary;
    }

    public BeanL() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "BeanL{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
