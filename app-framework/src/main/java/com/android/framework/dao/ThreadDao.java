package com.android.framework.dao;

import com.android.framework.model.ThreadInfo;

import java.util.List;

/**
 * Created by Ryan Xu on 2016/3/17.
 * 数据访问接口
 */
public interface ThreadDao {

    /**
     * 插入线程信息
     * @param threadInfo
     */
    public void insertThread(ThreadInfo threadInfo);

    /**
     * 删除线程信息
     * @param url
     * @param threadId
     */
    public void deleteThread(String url, int threadId);

    /**
     * 更新线程下载进度
     * @param url
     * @param threadId
     */
    public void updateThreadProgress(String url, int threadId, int finished);

    /**
     * 查询文件的线程信息，以集合的形式返回
     * @param url
     * @return
     */
    public List<ThreadInfo> getThreadInfos(String url);

    /**
     * 判断线程信息是否已存在
     * @param url
     * @param threadId
     * @return
     */
    public boolean isExists(String url, int threadId);

}
