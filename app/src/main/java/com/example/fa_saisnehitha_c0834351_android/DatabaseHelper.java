package com.example.fa_saisnehitha_c0834351_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "destinationtable";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "nextdestinations";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_DATE = "date";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID +" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                COLUMN_ADDRESS + " varchar(200) NOT NULL," +
                COLUMN_LONGITUDE + " varchar(200) NOT NULL," +
                COLUMN_LATITUDE + " varchar(200) NOT NULL," +
                COLUMN_DATE + " double NOT NULL);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    //adding the next destination method
    boolean addDestination(String address, String latitude , String  longitude ,String date){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ADDRESS, address);
//        cv.put(String.valueOf(COLUMN_LATITUDE), latitude);
//        cv.put(String.valueOf(COLUMN_LONGITUDE), longitude);
        cv.put(COLUMN_LATITUDE, latitude);
        cv.put(COLUMN_LONGITUDE, longitude);
        cv.put(COLUMN_DATE, date);
        return sqLiteDatabase.insert(TABLE_NAME, null, cv) != -1;
    }
}
