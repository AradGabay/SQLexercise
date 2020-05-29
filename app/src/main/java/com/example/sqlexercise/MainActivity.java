package com.example.sqlexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    HelperDB hlp;
    SQLiteDatabase db;
    EditText name,address,cellnum,homenum,fathername,fathernum,momname,momnum,subject,quarter,grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        name = findViewById(R.id.studname);
        address = findViewById(R.id.studaddress);
        cellnum = findViewById(R.id.cellnum);
        homenum = findViewById(R.id.homenum);
        fathername = findViewById(R.id.fathername);
        fathernum = findViewById(R.id.fathernum);
        momname = findViewById(R.id.momname);
        momnum = findViewById(R.id.momnum);
        subject = findViewById(R.id.subject);
        quarter = findViewById(R.id.quarter);
        grade = findViewById(R.id.grade);



    }

    public void applygradedata(View view) {
        ContentValues cv = new ContentValues();

        cv.put(Grades.GRADE,Integer.parseInt(grade.getText().toString()));
        cv.put(Grades.QUARTER,Integer.parseInt(quarter.getText().toString()));
        cv.put(Grades.SUBJECT,subject.getText().toString());

        db = hlp.getWritableDatabase();
        db.insert(Grades.TABLE_GRADES,null,cv);
        db.close();

    }

    public void applystudentdata(View view) {
        ContentValues cv = new ContentValues();

        cv.put(Students.NAME,name.getText().toString());
        cv.put(Students.ADDRESS,address.getText().toString());
        cv.put(Students.CEL_NUM,cellnum.getText().toString());
        cv.put(Students.HOME_NUM,homenum.getText().toString());
        cv.put(Students.FATHER_NAME,fathername.getText().toString());
        cv.put(Students.FATHER_NUM,fathernum.getText().toString());
        cv.put(Students.MOTHER_NAME,momname.getText().toString());
        cv.put(Students.MOTHER_NUM,momnum.getText().toString());

        db = hlp.getWritableDatabase();
        db.insert(Students.TABLE_STUDENTS,null,cv);
        db.close();
    }
}
