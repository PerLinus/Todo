package com.nilsson83gmail.linus.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilsson83gmail.linus.todo.adapters.TodoListAdapter;

public class TodoListActivity extends AppCompatActivity implements TodoListAdapter.TodoListAdapterOnClickHandler {

    private RecyclerView mRecyclerView;
    private TodoListAdapter mTodoListAdapter;

    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_todolist);

        mErrorMessageDisplay = (TextView) findViewById(R.id.tv_todo_list_error_message);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mTodoListAdapter = new TodoListAdapter(this);

        mRecyclerView.setAdapter(mTodoListAdapter);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        mErrorMessageDisplay.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(String chosenTodo) {
        Intent intent = new Intent(TodoListActivity.this, TodoActivity.class);
        startActivity(intent);
    }
}
