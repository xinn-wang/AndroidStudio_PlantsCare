package fi.group11.plantscare;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "plant.db";
    public static final String  TABLE_NAME = "plant_table";
    public static final String  COL_1 = "ID";
    public static final String  COL_2 = "NAME";
    public static final String  COL_3 = "TYPE";
    public static final String  COL_4 = "INFO";
    public static final String  COL_5 = "WaterNeeds";
    public static final String  COL_6 = "SunPreference";
    public static final String  COL_7 = "Temperature";


    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,TYPE TEXT,INFO TEXT, WaterNeeds INTEGER,SunPreference text,Temperature,text)");
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
}


