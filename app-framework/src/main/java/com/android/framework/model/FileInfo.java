package com.android.framework.model;

import java.io.Serializable;

/**
 * Created by Ryan Xu on 2016/3/17.
 * 文件信息
 */
public class FileInfo implements Serializable{

    private int id;
    private String url;
    private String fileName;
    private int length;
    private int finished;

    public FileInfo(int id, String url, String fileName, int length, int finished) {
        this.id = id;
        this.url = url;
        this.fileName = fileName;
        this.length = length;
        this.finished = finished;
    }

    public FileInfo() {
        super();
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", fileName='" + fileName + '\'' +
                ", length=" + length +
                ", finished=" + finished +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getFileName() {
        return fileName;
    }

    public int getLength() {
        return length;
    }

    public int getFinished() {
        return finished;
    }
}
