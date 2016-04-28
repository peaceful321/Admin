package com.android.framework.service;

import android.content.Context;
import android.content.Intent;

import com.android.framework.dao.ThreadDao;
import com.android.framework.dao.ThreadDaoImpl;
import com.android.framework.model.FileInfo;
import com.android.framework.model.ThreadInfo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.transform.sax.TemplatesHandler;

/**
 * Created by Ryan Xu on 2016/3/17.
 * 下载任务类
 */
public class DownloadTask {
    private FileInfo fileInfo;
    private Context context;
    private ThreadDao dao;
    private int mFinished = 0;
    public boolean isPause = false;

    public DownloadTask(Context context, FileInfo fileInfo) {
        this.fileInfo = fileInfo;
        this.context = context;
        this.dao = new ThreadDaoImpl(context);
    }

    public void download() {
        //从数据库读取上次下载信息即：线程信息
        List<ThreadInfo> threadInfos = dao.getThreadInfos(fileInfo.getUrl());
        ThreadInfo threadInfo = null;
        if (threadInfos == null || threadInfos.size() == 0) {
            //初始化线程信息对象
            threadInfo = new ThreadInfo(0, fileInfo.getUrl(), 0, fileInfo.getLength(), 0);
        } else {
            threadInfo = threadInfos.get(0);
        }
        //创建子线程下载
        new DownloadThread(threadInfo).start();

    }

    /**
     * 下载线程
     */
    class DownloadThread extends Thread {
        private ThreadInfo threadInfo;

        public DownloadThread(ThreadInfo threadInfo) {
            this.threadInfo = threadInfo;
        }

        @Override
        public void run() {
            //向数据库插入线程信息
            if (!dao.isExists(threadInfo.getUrl(), threadInfo.getId())) {
                dao.insertThread(threadInfo);
            }

            HttpURLConnection conn = null;
            RandomAccessFile raf = null;
            InputStream is = null;
            try {
                URL url = new URL(threadInfo.getUrl());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(3000);
                conn.setRequestMethod("GET");
                //设置下载位置
                int start = threadInfo.getStart() + threadInfo.getFinished();
                conn.setRequestProperty("Range", "bytes=" + start + "-" + threadInfo.getEnd());
                //文件的写入位置
                File file = new File(DownloadService.DOWNLOAD_PATH, fileInfo.getFileName());
                raf = new RandomAccessFile(file, "rwd");
                raf.seek(start);
                Intent intent = new Intent(DownloadService.ACTION_UPDATE);
                mFinished += threadInfo.getFinished();
                //开始下载：读取数据、写入文件、读取进度发送广播给主线程更新进度条、中途暂停（保存下载进度）
                if (conn.getResponseCode() == 200) {
                    is = conn.getInputStream();
                    byte[] buffer = new byte[1024 * 4];
                    int len = -1;
                    long time = System.currentTimeMillis();
                    while ((len = is.read(buffer)) != -1) {
                        raf.write(buffer, 0, len);
                        mFinished += len;
                        if ((System.currentTimeMillis() - time) >  500) {
                            time = System.currentTimeMillis();
                            intent.putExtra("finished", mFinished * 100 / fileInfo.getLength());
                            context.sendBroadcast(intent);
                        }
                        if (isPause) {
                            dao.updateThreadProgress(threadInfo.getUrl(), threadInfo.getId(), mFinished);
                            return;
                        }
                    }

                    //删除线程信息，下载完成后，线程信息保存在数据库没什么用
                    dao.deleteThread(threadInfo.getUrl(), threadInfo.getId());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.disconnect();
                    raf.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
