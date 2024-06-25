package com.example.icds;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MobileAppDatabase.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "LayoutManager";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN1 = "column1";
    public static final String COLUMN2 = "column2";
    public static final String COLUMN3 = "column3";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN1 + " TEXT, " +
                    COLUMN2 + " TEXT, " +
                    COLUMN3 + " TEXT);";

    /*private static final String TABLE_INSERT =
            "INSERT INTO " + TABLE_NAME + " VALUES(" +
                    COLUMN1 + " TEXT, " +
                    COLUMN2 + " TEXT, " +
                    COLUMN3 + " TEXT);";*/

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }


    public void onInsert(SQLiteDatabase db) {
       // db.execSQL(TABLE_INSERT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
