package com.example.browserdemo;

import java.io.Serializable;

public class NameAndUrlModel {

    String itemName;
    String url;
    int id;
    int[] ids;
    int image;

    public NameAndUrlModel(String itemName, String url, int image) {
        this.itemName = itemName;
        this.url = url;
        this.image = image;
    }
/* public NameAndUrlModel(String itemName, String url, int id) {
        this.itemName = itemName;
        this.url = url;
        this.id = id;
    }  */

    public NameAndUrlModel(String itemName, String url) {
        this.itemName = itemName;
        this.url = url;
    }



    public NameAndUrlModel(String itemName, String url, int id, int image) {
        this.itemName = itemName;
        this.url = url;
        this.id = id;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public NameAndUrlModel(int[] ids) {
        this.ids = ids;
    }

    public int getId() {
        return id;
    }
    public int[] getIds() {
        return ids;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String  url) {
        this.url = url;
    }
}
