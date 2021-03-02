package fi.group11.plantscare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    public static final String  TABLE_NAME = "plants_table";
    public static final String  COL_1 = "ID";
    public static final String  COL_2 = "NAME";
    public static final String  COL_3 = "TYPE";
    public static final String  COL_4 = "INFO";
    public static final String  COL_5 = "WATERNEEDS";
    public static final String  COL_6 = "SUNPREFERENCE";
    public static final String  COL_7 = "TEMPERATURE";

    //private constructor so that object creation from outside the class is avoided
    DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //to return the single instance of database
    public static DatabaseAccess getInstance(Context context){

        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    //open the database
    public void open(){
        this.db = openHelper.getWritableDatabase();
    }

    //close the database
    public void close(){
        if(db != null){
            this.db.close();
        }
    }

    public String getWaterNeeds(String name){
        c = db.rawQuery(" SELECT WaterNeeds FROM plants_table WHERE Name LIKE '" + name + "'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String waterNeeds = c.getString(0);
            buffer.append(""+waterNeeds);
        }
        return buffer.toString();
    }



    public boolean insertData(String name, String type, String info, String waterNeeds, String sunPreference, String temperature){
        open();
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

    public boolean updateData(String id, String name, String type, String info, String waterNeeds, String sunPreference, String temperature){
        open();
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


    public Cursor getAllData(){
        open();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}

