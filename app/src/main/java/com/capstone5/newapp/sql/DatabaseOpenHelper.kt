package com.capstone5.newapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ckt.db"
        // 테이블 생성 쿼리
        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${YourContract.YourEntry.TABLE_NAME} (" +
                    "${YourContract.YourEntry._ID} INTEGER PRIMARY KEY," +
                    "${YourContract.YourEntry.COLUMN_NAME_TITLE} TEXT," +
                    "${YourContract.YourEntry.COLUMN_NAME_SUBTITLE} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${YourContract.YourEntry.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}