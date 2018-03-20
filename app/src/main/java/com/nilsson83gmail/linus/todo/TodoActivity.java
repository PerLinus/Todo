package com.nilsson83gmail.linus.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TodoActivity extends AppCompatActivity {

    private String name;
    private String content;

    private TextView tvName;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Intent todoListIntent = getIntent();
        name = todoListIntent.getStringExtra("name");
        content = todoListIntent.getStringExtra("content");

        tvName = findViewById(R.id.text);
        tvContent = findViewById(R.id.textView);

        tvName.setText(name);
        tvContent.setText(content);

    }
}
