package fi.group11.plantscare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "plants.db";
    public static final String  TABLE_NAME = "plants_table";
    public static final String  COL_1 = "ID";
    public static final String  COL_2 = "NAME";
    public static final String  COL_3 = "TYPE";
    public static final String  COL_4 = "INFO";
    public static final String  COL_5 = "WATERNEEDS";
    public static final String  COL_6 = "SUNPREFERENCE";
    public static final String  COL_7 = "TEMPERATURE";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT,TYPE TEXT,INFO TEXT, WaterNeeds " +
                "INTEGER,SunPreference text,Temperature,text)");
//        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY )");
//        Toast.makeText(mContext, "Create successed",Toast.LENGTH_SHORT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name, String type, String info, String waterNeeds, String sunPreference, String temperature){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,type);
        contentValues.put(COL_4,info);
        contentValues.put(COL_5,waterNeeds);
        contentValues.put(COL_6,sunPreference);
        contentValues.put(COL_7,temperature);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id, String name, String type, String info, String waterNeeds, String sunPreference, String temperature){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,type);
        contentValues.put(COL_4,info);
        contentValues.put(COL_5,waterNeeds);
        contentValues.put(COL_6,sunPreference);
        contentValues.put(COL_7,temperature);
        db.update(TABLE_NAME, contentValues,"ID = ?",new String[] { id } );
        return true;
    }

}


