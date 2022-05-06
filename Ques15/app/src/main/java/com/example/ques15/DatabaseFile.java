package com.example.ques15;

import android.annotation.SuppressLint;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.util.ArrayList;

public class DatabaseFile extends SQLiteOpenHelper {

    private static final String DB_NAME = "college";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "student";

    private static final String ID_COL = "roll_no";

    private static final String NAME_COL = "name";

    private static final String DOB_COL = "date_of_birth";

    private static final String MOBILE_COL = "mobile_no";

    private static final String EMAIL_COL = "email";

    public DatabaseFile(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, "
                + NAME_COL + " TEXT,"
                + DOB_COL + " DATE,"
                + MOBILE_COL + " CHAR(10),"
                + EMAIL_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    public void addNewStudent(int roll_no, String name, Date dob, String mob, String email) {

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO "+TABLE_NAME+" ("
                +ID_COL+","+NAME_COL+","+DOB_COL+","+MOBILE_COL+","+EMAIL_COL+") VAlUES("
                +roll_no+","+name+","+dob+","+mob+","+email+")";

        db.execSQL(query);

        db.close();
    }

    public void updateStudent(int currRoll,int roll_no, String name, Date dob, String mob, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE "+TABLE_NAME+" SET "
                +ID_COL+"="+roll_no+"AND"+NAME_COL+"="+name+"AND"+DOB_COL+"="+dob+"AND"
                +MOBILE_COL+"="+mob+"AND"+EMAIL_COL+"="+email+
                " WHERE "+ID_COL+"="+currRoll;

        db.execSQL(query);

        db.close();
    }

    public void deleteStudent(int roll_no)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE * FROM "+TABLE_NAME+" WHERE "+ID_COL+"="+roll_no;

        db.execSQL(query);

        db.close();
    }

    @SuppressLint("Range")
    public ArrayList getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor res = db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();
        while(!res.isAfterLast()) {
            array_list.add(res.getString(res.getColumnIndex(ID_COL)));
            res.moveToNext();
        }
        res.close();
        return array_list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, "
                + NAME_COL + " TEXT,"
                + DOB_COL + " DATE,"
                + MOBILE_COL + " CHAR(10),"
                + EMAIL_COL + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }
}
