package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {
    ContentValues values = new ContentValues();
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        EditText username_editText = (EditText) findViewById(R.id.username_add);
        EditText password_editText = (EditText) findViewById(R.id.password_add);
        Button add_button = (Button) findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String username_input = username_editText.getText().toString();
                String password_input = password_editText.getText().toString();
                Intent intent = new Intent(AddUser.this, Login.class);
                String selection = DatabaseContract.UsersTable.USER_UNAME_COL + " = " + '"' + username_input + '"';
                String projection[] = new String[]{
                        DatabaseContract.UsersTable.USER_UNAME_COL,
                        DatabaseContract.UsersTable.USER_PASS_COL
                };

                Cursor cursor = db.query(
                        DatabaseContract.UsersTable.TABLE_NAME,
                        projection,
                        selection,
                        null,
                        null,
                        null,
                        null,
                        null
                );

                if(!cursor.moveToFirst()) {
                    db = dbHelper.getReadableDatabase();
                    values.put(DatabaseContract.UsersTable.USER_UNAME_COL, username_input);
                    values.put(DatabaseContract.UsersTable.USER_PASS_COL, password_input);

                    Long id = db.insert(
                            DatabaseContract.UsersTable.TABLE_NAME,
                            null,
                            values
                    );

                    startActivity(intent);
                }

                else{
                    Toast.makeText(AddUser.this,
                            "Username taken, please change it to another",
                            Toast.LENGTH_SHORT).show();

                    username_editText.setText("");
                    password_editText.setText("");
                }

                cursor.close();
            }
        });

    }

}