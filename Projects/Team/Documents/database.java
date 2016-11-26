package com.example.sainath.e_pollution;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Bharath on 26-11-2016.
 */

public class database extends SQLiteOpenHelper {


    private static String DBNAME = "locationmarkersqlite";


    private static int VERSION = 1;


    public static final String FIELD_ROW_ID = "_id";


    public static final String FIELD_LAT = "lat";


    public static final String FIELD_LNG = "lng";


    public static final String FIELD_ZOOM = "zom";


    private static final String DATABASE_TABLE = "locations";



    private static SQLiteDatabase mDB;


    public database(Context context) {
        super(context, DBNAME, null, VERSION);
        this.mDB = getWritableDatabase();
    }
    public void onCreate(SQLiteDatabase db) {

        String sql =     "create table " + DATABASE_TABLE + " ( " +
                FIELD_ROW_ID + " integer primary key autoincrement , " +
                FIELD_LNG + " double , " +
                FIELD_LAT + " double , " +
                FIELD_ZOOM + " text " +
                " ) ";

        db.execSQL(sql);
    }


    public long insert(ContentValues contentValues){
        long rowID = mDB.insert(DATABASE_TABLE, null, contentValues);
        return rowID;
    }

    public int del(){
        int cnt = mDB.delete(DATABASE_TABLE, null , null);
        return cnt;
    }
    public static Cursor getAllLocations(){
        return mDB.query(DATABASE_TABLE, new String[] { FIELD_ROW_ID,  FIELD_LAT , FIELD_LNG, FIELD_ZOOM } , null, null, null, null, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

