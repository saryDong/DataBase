package com.example.abu.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fileMethod(View view) {
        startActivity(new Intent(this,FileActivity.class));
    }

    public void sharedPrf(View view) {
        startActivity(new Intent(this,SharePfrActivity.class));

    }

    public void litePale(View view) {
        startActivity(new Intent(this,LitePalActivity.class));
    }
}
