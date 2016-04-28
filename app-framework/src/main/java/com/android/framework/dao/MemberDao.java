package com.android.framework.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xuhuanchao on 2015/11/16.
 */
public class MemberDao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbText";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Student";
    private static final String FIELD_STU_ID = "stuId";
    private static final String FIELD_STU_NAME = "stuName";
    private static final String FIELD_STU_AGE = "stuAge";
    private static final int FIELD_STU_SEX = 1; // 1: 男，0：女

    public MemberDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " Create Table IF NOT EXISTS" + TABLE_NAME + "(" +
                            FIELD_STU_ID + " TEXT PRIMARY KEY," +
                            FIELD_STU_NAME + " TEXT," +
                            FIELD_STU_AGE + " INTEGER," +
                            FIELD_STU_SEX + " INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "Drop Table IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

}
