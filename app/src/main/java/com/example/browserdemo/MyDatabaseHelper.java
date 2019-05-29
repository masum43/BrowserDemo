package com.example.browserdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    Context context;

    public static final String DATABASE_NAME = "additem.db";
    public static final int DATABASE_VERSION = 15 ;
    public static final int VALUE = 1000 ;

    public static final String TABLE_NAME = "all_new_item_table";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "new_item_name";
    public static final String COL_URL = "url";
    public static final String COL_IMAGE = "image";

    String sql1 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('1', 'Facebook', 'www.facebook.com', 'R.drawable.facebook');";
    String sql2 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('2', 'Twitter', 'www.twitter.com', 'R.drawable.twitter');";
    String sql3 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('3', 'Google', 'www.google.com', 'R.drawable.google');";

    String sql4 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('4', 'Youtube', 'www.youtube.com', 'R.drawable.youtube');";


String sql5 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('5', 'Wikipedia', 'www.wikipedia.org', 'R.drawable.wikipedia');";
String sql6 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('6', 'Amazon', 'www.amazon.com', 'R.drawable.amazon');";
String sql7 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('7', 'Linkedin', 'www.linkedin.com', 'R.drawable.linkedin');";
String sql8 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('8', 'Gmail', 'www.gmail.com', 'R.drawable.gmail');";

String sql9 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('9', 'Instagram', 'www.instagram.com', 'R.drawable.instagram');";
String sql10 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('10', 'Quora', 'www.quora.com', 'R.drawable.quora');";
String sql11 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('11', 'Stack', 'www.stackoverflow.com', 'R.drawable.overflowing');";

    String sql12 = "insert into " + TABLE_NAME + " (" + COL_ID + ", " +COL_NAME + ", " + COL_URL
            +", " + COL_IMAGE + ") values('12', 'Add Item', 'Add Item', 'R.drawable.plus');";




    public static final String CREATE_TABLE = "create table "+TABLE_NAME+" (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "+
            COL_NAME + " TEXT NOT NUll , " +
            COL_URL + " TEXT NOT NULL ," +
            COL_IMAGE + " INTEGER " + ")";









    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       //

        db.execSQL(CREATE_TABLE);
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);
        db.execSQL(sql10);
        db.execSQL(sql11);
        db.execSQL(sql12);

        //db.rawQuery("select max(COL_ID) from TABLE_NAME",null);






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + TABLE_NAME);
        this.onCreate(db);

    }
}
