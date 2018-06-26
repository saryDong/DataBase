package com.example.abu.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SharePfrActivity extends AppCompatActivity {
    /**
     * 1.SharedPreferences使用键值对的方式将数据存储在xml文件内
     * 2.获取SharedPreferences对象的三种方式
     *           Context    的getSharedPreferences()
     *           Activity   的getPreferences()
     *           PreferenceManager  getDefaultSharedPreferences()
     * @param savedInstanceState
     */
    private Button read_btn;
    private Button save_btn;
    private EditText input_str;
    private TextView read_str;
    private EditText input_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrc);
        initView();
    }

    private void initView() {
        read_btn=findViewById(R.id.read_btn);
        read_str=findViewById(R.id.read_str);
        save_btn=findViewById(R.id.save_btn);
        input_str=findViewById(R.id.input_name);
        input_num=findViewById(R.id.input_num);

        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData();
                Toast.makeText(SharePfrActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        });

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=input_str.getText().toString();
                int num= Integer.parseInt(input_num.getText().toString());
                if (!TextUtils.isEmpty(content)){
                    saveData(content,num);
                    Toast.makeText(SharePfrActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void readData() {
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this);
        String name=preferences.getString("name","tom");
        int num=preferences.getInt("love_num",3306);
        if (name!=null&&num!=0){
            read_str.setText("name:"+name+"\n"+"num:"+num);
        }else {
            Toast.makeText(this, "fail", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveData(String string,int num) {
        //1.夺取SharedPreference()对象
         SharedPreferences preferences;
         SharedPreferences.Editor editor;
         //方法1
           //preferences=getSharedPreferences("dataSpf",Context.MODE_PRIVATE);
         //方法二  默认将当前活动名作为文件名
           //preferences=getPreferences(Context.MODE_PRIVATE);
         //方法3   当前应用程序包名作为
             preferences= PreferenceManager.getDefaultSharedPreferences(this);
         //获取Edit对象
         editor=preferences.edit();
         //添加数据
         editor.putString("name",string);
         editor.putInt("love_num",num);
         //保存数据
         editor.apply();
    }
}
