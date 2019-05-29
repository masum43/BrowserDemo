package com.example.browserdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.example.browserdemo.MyDatabaseHelper.TABLE_NAME;

public class MyDatabaseSource {

    MyDatabaseHelper myDatabaseHelper;
    SQLiteDatabase sqLiteDatabase;
    NameAndUrlModel nameAndUrlModel;

    public MyDatabaseSource(Context context)
    {
        myDatabaseHelper = new MyDatabaseHelper(context);
    }


    public void open()
    {
        sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
    }

    public void close()
    {
        myDatabaseHelper.close();
    }

    public boolean addItemWithNameAndUrl(NameAndUrlModel nameAndUrlModel)
    {
        this.open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(MyDatabaseHelper.COL_NAME,nameAndUrlModel.getItemName()); //MyDatabaseHelper e error thakte pare
        contentValues.put(MyDatabaseHelper.COL_URL,nameAndUrlModel.getUrl());
        //contentValues.put(MyDatabaseHelper.COL_ID,nameAndUrlModel.getId());




        Long insertedRow = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        this.close();

        if(insertedRow>0)
        {
            return true;
        }
        else return false;

    }

    public boolean updateItemWithNameAndUrl(NameAndUrlModel nameAndUrlModel){

        this.open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(MyDatabaseHelper.COL_NAME,nameAndUrlModel.getItemName()); //MyDatabaseHelper e error thakte pare
        contentValues.put(MyDatabaseHelper.COL_URL,nameAndUrlModel.getUrl());
        contentValues.put(MyDatabaseHelper.COL_ID,nameAndUrlModel.getId());

        //to update, starting point
        //if(contentValues.get("Add Item").equals())
        int updatedRow = sqLiteDatabase.update(TABLE_NAME,contentValues,"COL_ID = ? ",new String[]{String.valueOf((nameAndUrlModel.getId()))});
        //to update, closing point

        this.close();

        if(updatedRow>0){
            return  true;
        }
        else return false;


    }


    public ArrayList<NameAndUrlModel> getAllItemWithNameUrlAndImage()
    {

        this.open();
        ArrayList<NameAndUrlModel> arrayList = new ArrayList<>();

        // select * from table
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,null,null, null,null,null,null,null);

        if(cursor.moveToFirst())
        {
            do{
                String name = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.COL_NAME));
                String url = cursor.getString(cursor.getColumnIndex(myDatabaseHelper.COL_URL));
                int image = cursor.getInt(cursor.getColumnIndex(myDatabaseHelper.COL_IMAGE));
                //int id = cursor.getInt(cursor.getColumnIndex(myDatabaseHelper.COL_ID));

                /*if(name.equals(3) && url.equals(3)){
                    id = id+50;
                } */

                NameAndUrlModel nameAndUrlModel = new NameAndUrlModel(name,url,image); // student model e datagula set korechi constructor call kore
                arrayList.add(nameAndUrlModel);
            }
            while (cursor.moveToNext());
        }
        this.close();
        cursor.close();

        return arrayList;

    }

    public Cursor displayAllItemWithUrl(MyDatabaseHelper myDatabaseHelper){  //ekhane parameter niye pb hote pare

        sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return cursor;
    }

    public Cursor getMaxId(){

        sqLiteDatabase = myDatabaseHelper.getReadableDatabase();
        Cursor getMaxId = sqLiteDatabase.rawQuery("select max(COL_ID) from TABLE_NAME",null);

        return getMaxId;

        }

    }



