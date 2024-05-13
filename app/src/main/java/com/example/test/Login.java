package com.example.test;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor cursor_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        EditText username_editText = (EditText) findViewById(R.id.username_editText);
        EditText password_editText = (EditText) findViewById(R.id.password_editText);
        ImageView addUser_btn = (ImageView) findViewById(R.id.ic_queen);
        Button login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor_login = getAllItems();
                Intent login_intent = new Intent(Login.this, MainActivity.class);

                String username_input = username_editText.getText().toString();
                String password_input = password_editText.getText().toString();
                String selection = DatabaseContract.UsersTable.USER_UNAME_COL + " = ? AND " +
                                   DatabaseContract.UsersTable.USER_PASS_COL + " = ?";
                String selectionArgs[] = new String[]{username_input, password_input};
                String projection[] = new String[]{
                        DatabaseContract.UsersTable.USER_UNAME_COL,
                        DatabaseContract.UsersTable.USER_PASS_COL
                };

                cursor_login = db.query(
                        DatabaseContract.UsersTable.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                );

                Log.d("test", username_input + " " + password_input);

                if(cursor_login.moveToFirst()){
                    startActivity(login_intent);
                }

                else{
                   Toast.makeText(getBaseContext(),
                           "Incorrect credentials, please try again",
                           Toast.LENGTH_SHORT).show();
                }
            }
        });

        addUser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addUser_intent = new Intent(Login.this, AddUser.class);
                startActivity(addUser_intent);
            }
        });
    }

    private Cursor getAllItems(){
        return db.query(
                DatabaseContract.UsersTable.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}