package com.example.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.app.AlertDialog.Builder;

public class MainActivity extends Activity implements OnClickListener {

    EditText rollno, name, marks;
    Button insert, delete, update, viewbutton, viewall;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollno = findViewById(R.id.rollno);
        name = findViewById(R.id.name);
        marks = findViewById(R.id.marks);
        insert = findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        viewbutton = findViewById(R.id.view);
        viewall = findViewById(R.id.viewall);

        insert.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        viewbutton.setOnClickListener(this);
        viewall.setOnClickListener(this);

        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists student(rollno VARCHAR, name VARCHAR, marks VARCHAR);");
    }

    @Override
    public void onClick(View view) {
        if (view == insert) {
            if (rollno.getText().toString().trim().isEmpty() || name.getText().toString().trim().isEmpty() || marks.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES('" + rollno.getText() + "', '" + name.getText() + "', '" + marks.getText() + "');");
            showMessage("Success", "Record Added");
            clearText();
        }

        if (view == delete) {
            if (rollno.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter roll no");
                return;
            }
            Cursor c = db.rawQuery("select * from student where rollno ='" + rollno.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("delete from student where rollno ='" + rollno.getText() + "'");
                showMessage("Success", "Record deleted");
            } else {
                showMessage("Error", "Invalid roll no");
            }
            clearText();
        }

        if (view == update) {
            if (rollno.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter roll no");
                return;
            }
            Cursor c = db.rawQuery("select * from student where rollno ='" + rollno.getText() + "'", null);
            if (c.moveToFirst()) {
                db.execSQL("update student set name='" + name.getText() + "', marks='" + marks.getText() + "' where rollno='" + rollno.getText() + "'");
                showMessage("Success", "Record updated");
            } else {
                showMessage("Error", "Invalid roll no");
            }
            clearText();
        }

        if (view == viewbutton) {
            if (rollno.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter roll no");
                return;
            }
            Cursor c = db.rawQuery("select * from student where rollno ='" + rollno.getText() + "'", null);
            if (c.moveToFirst()) {
                StringBuffer buffer = new StringBuffer();
                buffer.append("Roll no: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Marks: " + c.getString(2) + "\n");
                showMessage("Student details", buffer.toString());
            } else {
                showMessage("Error", "No records found for the entered roll no.");
            }
        }

        if (view == viewall) {
            Cursor c = db.rawQuery("select * from student", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("Roll no: " + c.getString(0) + "\n");
                buffer.append("Name: " + c.getString(1) + "\n");
                buffer.append("Marks: " + c.getString(2) + "\n");
            }
            showMessage("Student details", buffer.toString());
        }
    }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        rollno.setText("");
        name.setText("");
        marks.setText("");
        rollno.requestFocus();
    }
}
