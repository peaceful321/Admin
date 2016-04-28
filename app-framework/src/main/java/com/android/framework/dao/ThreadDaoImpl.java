package com.android.framework.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.framework.model.ThreadInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据访问接口实现
 * Created by Ryan Xu on 2016/3/17.
 */
public class ThreadDaoImpl implements ThreadDao {

    private DBHelper mHelper = null;

    public ThreadDaoImpl(Context context) {
        mHelper = new DBHelper(context);
    }

    @Override
    public void insertThread(ThreadInfo threadInfo) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.execSQL("insert into thread_info(thread_id, url, start, end, finished) values(?,?,?,?,?)",
                new Object[]{threadInfo.getId(),
                             threadInfo.getUrl(),
                             threadInfo.getStart(),
                             threadInfo.getEnd(),
                             threadInfo.getFinished()});
        db.close();
    }

    @Override
    public void deleteThread(String url, int threadId) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        db.execSQL("delete from thread_info where url = ? and thread_id = ?",
                new Object[]{url, threadId});
        db.close();
    }

    @Override
    public void updateThreadProgress(String url, int threadId, int finished) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String sql = "update thread_info set finished = ? where url = ? and thread_id = ?";
        db.execSQL(sql, new Object[]{finished, url, threadId});
        db.close();
    }

    @Override
    public List<ThreadInfo> getThreadInfos(String url) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        List<ThreadInfo> threadInfos = new ArrayList<ThreadInfo>();
        Cursor cursor = db.rawQuery("select * from thread_info where url = ?", new String[]{url});
        while(cursor.moveToNext()) {
            ThreadInfo thread = new ThreadInfo();
            thread.setId(cursor.getInt(cursor.getColumnIndex("thread_id")));
            thread.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            thread.setStart(cursor.getInt(cursor.getColumnIndex("start")));
            thread.setEnd(cursor.getInt(cursor.getColumnIndex("end")));
            thread.setFinished(cursor.getInt(cursor.getColumnIndex("finished")));
            threadInfos.add(thread);
        }
        cursor.close();
        return threadInfos;
    }

    @Override
    public boolean isExists(String url, int threadId) {
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from thread_info where url = ? and thread_id = ?", new String[]{url, String.valueOf(threadId)});
        boolean exists = cursor.moveToNext();
        cursor.close();
        db.close();
        return exists;
    }
}
