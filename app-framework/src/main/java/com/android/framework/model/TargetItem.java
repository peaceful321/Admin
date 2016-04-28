package com.android.framework.model;

/**
 * Created by xuhuanchao on 2015/11/2.
 */
public class TargetItem {

    private int targetImg;
    private String targetTitle;
    private String targetFragment;

    public TargetItem(int targetImg, String targetTitle, String targetFragment) {
        this.targetImg  = targetImg;
        this.targetTitle = targetTitle;
        this.targetFragment = targetFragment;
    }

    public int getTargetImg() {
        return targetImg;
    }

    public void setTargetImg(int targetImg) {
        this.targetImg = targetImg;
    }

    public String getTargetTitle() {
        return targetTitle;
    }

    public String getTargetFragment() {
        return targetFragment;
    }

    public void setTargetTitle(String targetTitle) {
        this.targetTitle = targetTitle;
    }

    public void setTargetFragment(String targetFragment) {
        this.targetFragment = targetFragment;
    }
}
