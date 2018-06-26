package com.example.abu.database;

import android.content.Context;
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
import java.util.PriorityQueue;

public class FileActivity extends AppCompatActivity {
    /**
     * 1.Context 提供openFileOutput(文件名，操作模式)方法存储数据到文件，openFileInput(文件名)读取文件数据
     * 2.openFileOutput返回FileOutputStream对象
     * 3.openFileInput返回FileInputStream对象
     * 4.存储对象.txt文件
     * @param savedInstanceState
     */
    private Button read_btn;
    private Button save_btn;
    private EditText input_str;
    private TextView read_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        initView();
    }

    private void initView() {
        read_btn=findViewById(R.id.read_btn);
        read_str=findViewById(R.id.read_str);
        save_btn=findViewById(R.id.save_btn);
        input_str=findViewById(R.id.input_str);

        read_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 readData();
                Toast.makeText(FileActivity.this, "success", Toast.LENGTH_SHORT).show();
            }
        });
        input_str.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                read_str.setText(charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                read_str.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=input_str.getText().toString();
                if (!TextUtils.isEmpty(content)){
                    saveData(content);
                    Toast.makeText(FileActivity.this, "success", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void readData() {
        read_str.setText("");

        FileInputStream inputStream;
        BufferedReader bufferedReader = null;
        StringBuilder builder = null;
        try {
            inputStream=openFileInput("data");
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            builder=new StringBuilder();
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                builder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        read_str.setText(builder.toString());
    }

    private void saveData(String string) {
        FileOutputStream outputStream=null;
        BufferedWriter bufferedWriter=null;

        try {
            outputStream=openFileOutput("data", Context.MODE_PRIVATE);
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
