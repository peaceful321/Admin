package com.android.framework.model;

/**
 * 线程信息
 * Created by Ryan Xu on 2016/3/17.
 */
public class ThreadInfo {

    private int id;
    private String url;
    private int start;
    private int end;
    private int finished;

    public ThreadInfo() {
        super();
    }

    public ThreadInfo(int id, String url, int start, int end, int finished) {
        this.id = id;
        this.url = url;
        this.start = start;
        this.end = end;
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "ThreadInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", finished=" + finished +
                '}';
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getId() {

        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getFinished() {
        return finished;
    }
}
