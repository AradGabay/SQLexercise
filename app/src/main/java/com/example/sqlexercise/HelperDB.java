package com.example.sqlexercise;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.sqlexercise.Grades.GRADE;
import static com.example.sqlexercise.Grades.QUARTER;
import static com.example.sqlexercise.Grades.SUBJECT;
import static com.example.sqlexercise.Grades.TABLE_GRADES;
import static com.example.sqlexercise.Students.ADDRESS;
import static com.example.sqlexercise.Students.CEL_NUM;
import static com.example.sqlexercise.Students.FATHER_NAME;
import static com.example.sqlexercise.Students.FATHER_NUM;
import static com.example.sqlexercise.Students.HOME_NUM;
import static com.example.sqlexercise.Students.MOTHER_NAME;
import static com.example.sqlexercise.Students.MOTHER_NUM;
import static com.example.sqlexercise.Students.NAME;
import static com.example.sqlexercise.Students.STUDENT_ID;
import static com.example.sqlexercise.Students.TABLE_STUDENTS;

public class HelperDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentsDB.db";
    private static final int DATABASE_VERSION = 1;
    String strCreate,strDelete;

    public HelperDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_STUDENTS;
        strCreate+=" ("+STUDENT_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+ADDRESS+" TEXT,";
        strCreate+=" "+CEL_NUM+" TEXT,";
        strCreate+=" "+HOME_NUM+" TEXT,";
        strCreate+=" "+FATHER_NAME+" TEXT,";
        strCreate+=" "+FATHER_NUM+" TEXT,";
        strCreate+=" "+MOTHER_NAME+" TEXT,";
        strCreate+=" "+MOTHER_NUM+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_STUDENTS;
        db.execSQL(strDelete);
        strDelete="DROP TABLE IF EXISTS "+TABLE_GRADES;
        db.execSQL(strDelete);

    }
}
