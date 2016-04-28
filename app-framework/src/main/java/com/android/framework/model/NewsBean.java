package com.android.framework.model;

/**
 * Created by Ryan Xu on 2016/2/26.
 */
public class NewsBean implements java.io.Serializable {

    private String iconUrl;
    private String title;
    private String content;

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
