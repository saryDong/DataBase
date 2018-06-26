package com.example.abu.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SQLiteDatabaseActivity extends AppCompatActivity {
    private Button sqlite_open_helper;
    private MyDataBaseHelper mBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);
        sqlite_open_helper=findViewById(R.id.create_database);

        mBaseHelper=new MyDataBaseHelper(this,"BookStore.db",null,2);
        sqlite_open_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBaseHelper.getWritableDatabase();
            }
        });

    }

    public void update(View view) {
    }

    public void inserts(View view) {
    }

    public void searchs(View view) {
    }

    public void deletes(View view) {
    }
}
