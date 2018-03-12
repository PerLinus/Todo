package com.nilsson83gmail.linus.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        findViewById(R.id.toDo).setOnClickListener(this);
        findViewById(R.id.shoppingLists).setOnClickListener(this);
        findViewById(R.id.passwords).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
