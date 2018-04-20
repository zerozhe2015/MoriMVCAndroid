package com.moriarty.morimvcandroid.model.entities.textjoke;

import com.chad.library.adapter.base.entity.MultiItemEntity;



public class TextJokeBean implements MultiItemEntity {
    public static final int JOKE = 0;
    public static final int MORE = 1;

    private int itemType;

    private String content;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

}
