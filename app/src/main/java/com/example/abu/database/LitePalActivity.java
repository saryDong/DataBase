package com.example.abu.database;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LitePalActivity extends AppCompatActivity {
    /**
     * 两种方式：1，SQLiteOpenHelper
     *             抽象类，继承实现，提供onCreate()
     *                               ,onUpgrade()
     *             通过getReadableDateBase()和getWritableDatabase()获得SQLiteDatabase对象进行CRUD操作
     *          2. LitePal
     *             对象关系映射
     *             1.配置LitePal  "compile.org.litepal.android:core:27.1.1"
     *             2.配置litepal.xml文件
     *             3.配置LitePalApplication
     *               android:name="org.litepal.LitePalApplication"
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
    }

    public void SQLiteOpenHelperMethod(View view) {
        startActivity(new Intent(this, SQLiteDatabaseActivity.class));
    }

    public void LitePalMethod(View view) {
        startActivity(new Intent(this,LitePalsActivity.class));
    }
}
